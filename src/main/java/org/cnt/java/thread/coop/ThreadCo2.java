package org.cnt.java.thread.coop;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author lixinjie
 * @since 2019-05-24
 */
public class ThreadCo2 {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public static void main(String[] args) throws Exception {
		new Thread(new Leader(cb)).start();
		for (int i = 0; i < 10; i++) {
			new Thread(new Staff(i, cb)).start();
		}
		synchronized (ThreadCo2.class) {
			ThreadCo2.class.wait();
		}
	}
	
	static CyclicBarrier cb = new CyclicBarrier(11);
	
	static class Leader implements Runnable {
		
		CyclicBarrier cb;
		
		Leader(CyclicBarrier cb) {
			this.cb = cb;
		}
		
		@Override
		public void run() {
			println("队长出发。。。");
			workingHard();
			println("队长到达地点一。。。");
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			cb.reset();
			println("队长再出发。。。");
			workingHard();
			println("队长到达地点二。。。");
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			cb.reset();
			println("队长再出发。。。");
			workingHard();
			println("队长到达地点三。。。");
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			println("队长结束。。。");
		}
		
	}
	
	static class Staff implements Runnable {
		
		CyclicBarrier cb;
		int num;
		
		Staff(int num, CyclicBarrier cb) {
			this.num = num;
			this.cb = cb;
		}
		
		@Override
		public void run() {
			println("员工(%d)出发。。。", num);
			workingHard();
			println("员工(%d)到达地点一。。。", num);
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			println("员工(%d)再出发。。。", num);
			workingHard();
			println("员工(%d)到达地点二。。。", num);
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			println("员工(%d)再出发。。。", num);
			workingHard();
			println("员工(%d)到达地点三。。。", num);
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			println("员工(%d)结束。。。", num);
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
