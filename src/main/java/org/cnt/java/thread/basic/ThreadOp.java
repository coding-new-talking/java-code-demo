package org.cnt.java.thread.basic;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author lixinjie
 * @since 2019-05-20
 */
public class ThreadOp {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public static void main(String[] args) throws Exception {
		stopByItselfUseInterrupt();
		synchronized (ThreadOp.class) {
			ThreadOp.class.wait();
		}
	}
	
	static void stopByItselfUseInterrupt() {
		CRunable cr = new CRunable();
		Thread t = new Thread(cr);
		t.start();
		sleep(2);
		t.interrupt();
	}
	
	static class CRunable implements Runnable {

		@Override
		public void run() {
			println("进入暂停。。。");
			try {
				sleep2(5);
			} catch (InterruptedException e) {
				println("收到中断异常。。。");
				println("做一些相关处理。。。");
			}
			println("退出执行。。。");
		}
		
	}
	
	static void pauseAWhileByItselfUseFlag() {
		BRunnable br = new BRunnable();
		new Thread(br).start();
		br.tellToPauseAWhile(5);
	}
	
	static void pauseByItselfUseFlag() {
		BRunnable br = new BRunnable();
		new Thread(br).start();
		br.tellToPause();
		sleep(8);
		br.tellToResume();
	}
	
	static class BRunnable implements Runnable {
		volatile boolean pause;
		
		volatile int timeout;
		
		void tellToPause() {
			pause = true;
		}
		
		void tellToResume() {
			synchronized (this) {
				this.notify();
			}
		}
		
		void tellToPauseAWhile(int second) {
			pause = true;
			timeout = second * 1000;
		}
		
		@Override
		public void run() {
			println("进入不可暂停区域 1。。。");
			sleep(5);
			println("退出不可暂停区域 1。。。");
			println("检测标志pause = %s", String.valueOf(pause));
			if (pause) {
				println("暂停执行");
				try {
					synchronized (this) {
						if (timeout < 1) {
							this.wait();
						} else {
							this.wait(timeout);
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				println("恢复执行");
			}
			println("进入不可暂停区域 2。。。");
			sleep(5);
			println("退出不可暂停区域 2。。。");
		}
		
	}

	static void stopByItselfUseFlag() {
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
			sleep(5);
			println("退出不可停止区域 1。。。");
			println("检测标志stop = %s", String.valueOf(stop));
			if (stop) {
				println("停止执行");
				return;
			}
			println("进入不可停止区域 2。。。");
			sleep(5);
			println("退出不可停止区域 2。。。");
		}
		
	}
	
	static void println(String text, Object... args) {
		System.out.println(String.format(time() + ", " + text, args));
	}
	
	static String time() {
		return LocalTime.now().format(dtf);
	}
	
	static void sleep(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static void sleep2(int second) throws InterruptedException {
		TimeUnit.SECONDS.sleep(second);
	}
}
