package org.cnt.java.thread.coop;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lixinjie
 * @since 2019-05-24
 */
public class ThreadCo1 {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public static void main(String[] args) throws Exception {
		new Thread(new Teacher(cdl)).start();
		sleep(1);
		for (int i = 0; i < 20; i++) {
			new Thread(new Student(i, cdl)).start();
		}
		synchronized (ThreadCo1.class) {
			ThreadCo1.class.wait();
		}
	}
	
	static CountDownLatch cdl = new CountDownLatch(20);
	
	static class Teacher implements Runnable {
		
		CountDownLatch cdl;
		
		Teacher(CountDownLatch cdl) {
			this.cdl = cdl;
		}
		
		@Override
		public void run() {
			println("老师发卷子。。。");
			try {
				cdl.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			println("老师收卷子。。。");
		}
		
	}
	
	static class Student implements Runnable {
		
		CountDownLatch cdl;
		int num;
		
		Student(int num, CountDownLatch cdl) {
			this.num = num;
			this.cdl = cdl;
		}
		
		@Override
		public void run() {
			println("学生(%d)写卷子。。。", num);
			workingHard();
			println("学生(%d)交卷子。。。", num);
			cdl.countDown();
		}
		
	}

	static void workingHard() {
		int second = 5 + new Random().nextInt(6);
		sleep(second);
	}
	
	static void sleep(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static void println(String text, Object... args) {
		System.out.println(String.format(time() + ", " + text, args));
	}
	
	static String time() {
		return LocalTime.now().format(dtf);
	}
}
