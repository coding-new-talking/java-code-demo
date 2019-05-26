package org.cnt.java.thread.coop;

import static org.cnt.java.utils.Methods.doingLongTime;
import static org.cnt.java.utils.Methods.println;
import static org.cnt.java.utils.Methods.sleep;

import java.util.concurrent.CountDownLatch;

/**
 * @author lixinjie
 * @since 2019-05-24
 */
public class ThreadCo1 {

	static final int COUNT = 20;
	
	public static void main(String[] args) throws Exception {
		new Thread(new Teacher(cdl)).start();
		sleep(1);
		for (int i = 0; i < COUNT; i++) {
			new Thread(new Student(i, cdl)).start();
		}
		synchronized (ThreadCo1.class) {
			ThreadCo1.class.wait();
		}
	}
	
	static CountDownLatch cdl = new CountDownLatch(COUNT);
	
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
			doingLongTime();
			println("学生(%d)交卷子。。。", num);
			cdl.countDown();
		}
		
	}

}
