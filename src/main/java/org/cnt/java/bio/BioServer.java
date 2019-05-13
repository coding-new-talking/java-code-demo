package org.cnt.java.bio;

import java.io.IOException;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void processWithNewThread(Socket s) {
		Runnable run = () -> {
			InetSocketAddress rsa = (InetSocketAddress)s.getRemoteSocketAddress();
			System.out.println(rsa.getHostName() + ":" + rsa.getPort() + "->" + Thread.currentThread().getId() + ":" + counter.incrementAndGet());
			try {
				byte[] bytes = new byte[20];
				long begin = System.currentTimeMillis();
				int count = s.getInputStream().read(bytes);
				long end = System.currentTimeMillis();
				s.close();
				System.out.println(time() + "->" + new String(bytes, 0, count) + "->" + Thread.currentThread().getId() + ":" + counter.getAndDecrement());
				System.out.println(Thread.currentThread().getId() + "->" + (end -begin) + " ms" );
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		new Thread(run).start();
	}

	static String time() {
		return sdf.format(new Date());
	}
}
