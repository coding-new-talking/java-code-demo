package org.cnt.java.thread.obj;

import static org.cnt.java.utils.Methods.*;

/**
 * @author lixinjie
 * @since 2019-06-08
 */
public class Obj {

	public static void main(String[] args) {
		test1();
		//test2();
		//test3();
		//test4();
	}
	
	static void test1() {
		O o = new O("小白");
		new Thread(new W(o):: run).start();
		new Thread(new W(o):: run).start();
		new Thread(new N(o):: run).start();
	}
	
	static void test2() {
		O o = new O("大白");
		new Thread(new W(o):: run).start();
		new Thread(new W(o):: run).start();
		new Thread(new W(o):: run).start();
		new Thread(new W(o):: run).start();
		new Thread(new N(o):: run2).start();
	}
	
	static void test3() {
		O o = new O("老白");
		new Thread(new W(o):: run2).start();
		new Thread(new W(o):: run2).start();
		new Thread(new W(o):: run2).start();
		new Thread(new W(o):: run2).start();
	}
	
	static void test4() {
		O o1 = new O("小白");
		O o2 = new O("大白");
		//在小白上等待
		new Thread(new W(o1):: run).start();
		new Thread(new W(o1):: run).start();
		new Thread(new W(o1):: run).start();
		new Thread(new W(o1):: run).start();
		//在大白上等待
		new Thread(new W(o2):: run).start();
		new Thread(new W(o2):: run).start();
		new Thread(new W(o2):: run).start();
		new Thread(new W(o2):: run).start();
		//通知小白上的
		new Thread(new N(o1):: run2).start();
		//通知大白上的
		new Thread(new N(o2):: run2).start();
	}
	
	static class O {
		String name;
		O(String name) {
			this.name = name;
		}
	}
	
	static class W {
		O o;
		W(O o) {
			this.o = o;
		}
		
		void run() {
			sleep(1);
			synchronized(o) {
				println("当前线程（%d）在对象（%s）上等待", Thread.currentThread().getId(), o.name);
				try {
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			println("当前线程（%d）在对象（%s）上因被通知而醒来", Thread.currentThread().getId(), o.name);
		}
		
		void run2() {
			sleep(1);
			int n = random(5, 10);
			synchronized(o) {
				println("当前线程（%d）在对象（%s）上等待[%d]秒", Thread.currentThread().getId(), o.name, n);
				try {
					o.wait(n * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			println("当前线程（%d）在对象（%s）上因等待超过[%d]秒导致超时而自动醒来", Thread.currentThread().getId(), o.name, n);
		}
	}
	
	static class N {
		O o;
		N(O o) {
			this.o = o;
		}
		
		void run() {
			sleep(6);
			synchronized(o) {
				println("当前线程（%d）通知在对象（%s）上等待的其他单个线程", Thread.currentThread().getId(), o.name);
				o.notify();
			}
			sleep(6);
			synchronized(o) {
				println("当前线程（%d）通知在对象（%s）上等待的其他单个线程", Thread.currentThread().getId(), o.name);
				o.notify();
			}
		}
		
		void run2() {
			sleep(random(9, 19));
			synchronized(o) {
				println("当前线程（%d）通知在对象（%s）上等待的其他所有线程", Thread.currentThread().getId(), o.name);
				o.notifyAll();
			}
		}
	}
}
