package org.cnt.java.io.bio;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lixinjie
 * @since 2019-05-07
 */
public class BioServer {

	static AtomicInteger counter = new AtomicInteger(0);
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
	
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket();
			ss.bind(new InetSocketAddress("localhost", 8080));
			while (true) {
				Socket s = ss.accept();
				processWithNewThread(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void processWithNewThread(Socket s) {
		Runnable run = () -> {
			InetSocketAddress rsa = (InetSocketAddress)s.getRemoteSocketAddress();
			System.out.println(time() + "->" + rsa.getHostName() + ":" + rsa.getPort() + "->" + Thread.currentThread().getId() + ":" + counter.incrementAndGet());
			try {
				String result = readBytes(s.getInputStream());
				System.out.println(time() + "->" + result + "->" + Thread.currentThread().getId() + ":" + counter.getAndDecrement());
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		new Thread(run).start();
	}
	
	static String readBytes(InputStream is) throws Exception {
		long start = 0;
		int total = 0;
		int count = 0;
		byte[] bytes = new byte[1024];
		//开始读数据的时间
		long begin = System.currentTimeMillis();
		while ((count = is.read(bytes)) > -1) {
			if (start < 1) {
				//第一次读到数据的时间
				start = System.currentTimeMillis();
			}
			total += count;
		}
		//读完数据的时间
		long end = System.currentTimeMillis();
		return "wait=" + (start - begin) + "ms,read=" + (end - start) + "ms,total=" + total + "bs";
	}

	static String time() {
		return sdf.format(new Date());
	}
}
