package org.cnt.java.thread.thre;

import static org.cnt.java.utils.Methods.*;

/**
 * @author lixinjie
 * @since 2019-06-09
 */
public class Thre {

	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		test4();
	}
	
	static void test1() {
		Thread t = new Thread(Interrupt::interrupt);
		t.start();
		sleep(2);
		println2("主线程id=%d去中断线程tid=%d", Thread.currentThread().getId(), t.getId());
		t.interrupt();
		//sleep(2);
	}
	
	static void test2() {
		Thread t = new Thread(Interrupt::interrupt2);
		t.start();
		sleep(2);
		println2("主线程id=%d去中断线程tid=%d", Thread.currentThread().getId(), t.getId());
		t.interrupt();
		//sleep(2);
	}
	
	static void test3() {
		Thread t = new Thread(Interrupt::interrupt3);
		t.start();
		sleep(2);
		println2("主线程id=%d去中断线程tid=%d", Thread.currentThread().getId(), t.getId());
		t.interrupt();
		//sleep(2);
	}
	
	static void test4() {
		Thread t = new Thread(Interrupt::interrupt4);
		t.start();
		sleep(2);
		println2("主线程id=%d去中断线程tid=%d", Thread.currentThread().getId(), t.getId());
		t.interrupt();
		//sleep(2);
	}
	
	static class Interrupt {
		
		static void interrupt() {
			Thread t = Thread.currentThread();
			println2("线程tid=%d开始运行。。。", t.getId());
			while(true) {
				if (t.isInterrupted()) {
					println2("线程tid=%d被中断", t.getId());
					//该方法只返回当前中断状态，但不会清除中断状态
					println2("t.isInterrupted() is %s", t.isInterrupted());
					println2("t.isInterrupted() is %s", t.isInterrupted());
					//该方法返回当前中断状态并会清除中断状态
					println2("Thread.interrupted() is %s", Thread.interrupted());
					//状态已清除
					println2("Thread.interrupted() is %s", Thread.interrupted());
					//状态已清除
					println2("t.isInterrupted() is %s", t.isInterrupted());
					//退出
					break;
				}
			}
		}
		
		static void interrupt2() {
			Thread t = Thread.currentThread();
			try {
				println2("线程tid=%d开始睡眠。。。", t.getId());
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				println2("线程tid=%d在睡眠中被中断，且收到中断异常", t.getId());
				//中断状态已经被清除（因为都已经有异常了，状态也就没必要了）
				println2("t.isInterrupted() is %s", t.isInterrupted());
			}
		}
		
		static void interrupt3() {
			//因为是测试，所以就把监视器对象定义在方法里了
			Object object = new Object();
			Thread t = Thread.currentThread();
			try {
				println2("线程tid=%d开始等待。。。", t.getId());
				synchronized(object) {
					object.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				println2("线程tid=%d在等待中被中断，且收到中断异常", t.getId());
				//中断状态已经被清除（因为都已经有异常了，状态也就没必要了）
				println2("t.isInterrupted() is %s", t.isInterrupted());
			}
		}
		
		static void interrupt4() {
			//启动一个线程，作为被等待的对象
			Thread wt = new Thread(() -> sleep(4));
			wt.start();
			
			Thread t = Thread.currentThread();
			try {
				println2("线程tid=%d开始等待线程wtid=%d结束。。。", t.getId(), wt.getId());
				//这里没有使用synchronized关键字获取监视器
				//因为join方法本身就是synchronized的，
				//因此监视器就是wt这个线程本身了
				wt.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				println2("线程tid=%d在等待线程wtid=%d结束过程中被中断，且收到中断异常", t.getId(), wt.getId());
				//中断状态已经被清除（因为都已经有异常了，状态也就没必要了）
				println2("t.isInterrupted() is %s", t.isInterrupted());
			}
		}
	}
}
