package org.cnt.java.thread.coop;

import static org.cnt.java.utils.Methods.doingLongTime;
import static org.cnt.java.utils.Methods.println;

import java.util.concurrent.CyclicBarrier;

/**
 * @author lixinjie
 * @since 2019-05-24
 */
public class ThreadCo2 {

	static final int COUNT = 5;
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < COUNT; i++) {
			new Thread(new Staff(i, cb)).start();
		}
		synchronized (ThreadCo2.class) {
			ThreadCo2.class.wait();
		}
	}
	
	static CyclicBarrier cb = new CyclicBarrier(COUNT, new Singer());
	
	static class Singer implements Runnable {
		
		@Override
		public void run() {
			println("为大家唱歌。。。");
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
			doingLongTime();
			println("员工(%d)到达地点一。。。", num);
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			println("员工(%d)再出发。。。", num);
			doingLongTime();
			println("员工(%d)到达地点二。。。", num);
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			println("员工(%d)再出发。。。", num);
			doingLongTime();
			println("员工(%d)到达地点三。。。", num);
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			println("员工(%d)结束。。。", num);
		}
		
	}

}
