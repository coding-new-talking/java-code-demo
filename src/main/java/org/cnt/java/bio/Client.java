package org.cnt.java.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

/**
 * @author lixinjie
 * @since 2019-05-07
 */
public class Client {

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 200; i++) {
				Socket s = new Socket();
				s.connect(new InetSocketAddress("localhost", 8080));
				processWithNewThread(s, i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void processWithNewThread(Socket s, int i) {
		Runnable run = () -> {
			try {
				Thread.sleep((new Random().nextInt(6) + 10) * 1000);
				s.getOutputStream().write(("hello " + i).getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		new Thread(run).start();
	}
}
