package org.cnt.java.thread.basic;

import static org.cnt.java.utils.Methods.doingLongTime;
import static org.cnt.java.utils.Methods.println;
import static org.cnt.java.utils.Methods.sleep;
import static org.cnt.java.utils.Methods.sleep2;

import java.time.format.DateTimeFormatter;

/**
 * @author lixinjie
 * @since 2019-05-20
 */
public class ThreadOp {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public static void main(String[] args) throws Exception {
		stopByInterrupt();
		synchronized (ThreadOp.class) {
			ThreadOp.class.wait();
		}
	}
	
	static void stopByInterrupt() {
		DRunnable dr = new DRunnable();
		Thread t = new Thread(dr);
		t.start();
		sleep(2);
		t.interrupt();
	}
	
	static class DRunnable implements Runnable {

		@Override
		public void run() {
			println("进入暂停。。。");
			try {
				sleep2(5);
			} catch (InterruptedException e) {
				println("收到中断异常。。。");
				println("做一些相关处理。。。");
			}
			println("继续执行或选择退出。。。");
		}
		
	}
	
	static void jqByJoin() {
		CRunnable cr = new CRunnable();
		Thread t = new Thread(cr);
		t.start();
		sleep(1);
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		println("终于轮到我了");
	}
	
	static class CRunnable implements Runnable {

		@Override
		public void run() {
			println("进入不可暂停区域 1。。。");
			doingLongTime(5);
			println("退出不可暂停区域 1。。。");
		}
		
	}
	
	static void pause2Flag() {
		B2Runnable br = new B2Runnable();
		new Thread(br).start();
		br.tellToPauseAWhile(5);
	}
	
	static class B2Runnable implements Runnable {
		
		volatile boolean pause;
		
		volatile int timeout;
		
		void tellToPauseAWhile(int second) {
			pause = true;
			timeout = second * 1000;
		}
		
		@Override
		public void run() {
			println("进入不可暂停区域 1。。。");
			doingLongTime(5);
			println("退出不可暂停区域 1。。。");
			println("检测标志pause = %s", String.valueOf(pause));
			if (pause) {
				println("暂停执行");
				try {
					synchronized (this) {
						this.wait(timeout);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				println("恢复执行");
			}
			println("进入不可暂停区域 2。。。");
			doingLongTime(5);
			println("退出不可暂停区域 2。。。");
		}
		
	}
	
	static void pauseByFlag() {
		BRunnable br = new BRunnable();
		new Thread(br).start();
		br.tellToPause();
		sleep(8);
		br.tellToResume();
	}
	
	static class BRunnable implements Runnable {
		
		volatile boolean pause;
		
		void tellToPause() {
			pause = true;
		}
		
		void tellToResume() {
			synchronized (this) {
				this.notify();
			}
		}
		
		@Override
		public void run() {
			println("进入不可暂停区域 1。。。");
			doingLongTime(5);
			println("退出不可暂停区域 1。。。");
			println("检测标志pause = %s", String.valueOf(pause));
			if (pause) {
				println("暂停执行");
				try {
					synchronized (this) {
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				println("恢复执行");
			}
			println("进入不可暂停区域 2。。。");
			doingLongTime(5);
			println("退出不可暂停区域 2。。。");
		}
		
	}

	static void stopByFlag() {
		ARunnable ar = new ARunnable();
		new Thread(ar).start();
		ar.tellToStop();
	}
	
	static class ARunnable implements Runnable {

		volatile boolean stop;
		
		void tellToStop() {
			stop = true;
		}
		
		@Override
		public void run() {
			println("进入不可停止区域 1。。。");
			doingLongTime(5);
			println("退出不可停止区域 1。。。");
			println("检测标志stop = %s", String.valueOf(stop));
			if (stop) {
				println("停止执行");
				return;
			}
			println("进入不可停止区域 2。。。");
			doingLongTime(5);
			println("退出不可停止区域 2。。。");
		}
		
	}
	
}
