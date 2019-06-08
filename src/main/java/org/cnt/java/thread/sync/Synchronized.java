package org.cnt.java.thread.sync;

import static org.cnt.java.utils.Methods.*;

/**
 * @author lixinjie
 * @since 2019-06-08
 */
public class Synchronized {
	
	boolean testThis(Synchronized sync) {
		return this == sync;
	}

	public static void main(String[] args) {
		Synchronized sync = new Synchronized();
		//this就是new出来的对象本身
		println(sync.testThis(sync));
		//对象监视器
		//test1();
		
		
		//对象不相同
		println(new Object() == new Object());
		//但类型信息相同
		println(new Object().getClass() == new Object().getClass());
		//对象类型信息的两种获取方式
		println(new Object().getClass() == Object.class);
		//因为一个类被JVM加载 一次，生成一个Class<?>类型的对象，表明类本身的信息，或称元数据信息
		//Class<?>类型的对象也有监视器
		//test2();
		
		//synchronized关键字用于获取对象的监视器
		//编译后对应于JVM的两条指令：
		//monitorenter/monitorexit
		//进入监视器/退出监视器
		//每次只有一个线程可以拥有一个对象的监视器
	}
	
	static void test1() {
		SyncA syncA = new SyncA();
		SyncB syncB = new SyncB(syncA);
		new Thread(syncA::methodA).start();
		new Thread(syncA::methodB).start();
		new Thread(syncB::methodC).start();
	}
	
	static class SyncA {
		
		public synchronized void methodA() {
			println3("enter into SyncA.methodA");
			println("sleep...");
			sleep(5);
			println3("drop out SyncA.methodA");
		}
		
		public void methodB() {
			synchronized(this) {
				println3("enter into SyncA.methodB");
				println("sleep...");
				sleep(5);
				println3("drop out SyncA.methodB");
			}
		}
	}
	
	static class SyncB {
		
		private SyncA syncA;
		
		public SyncB(SyncA syncA) {
			this.syncA = syncA;
		}
		
		public void methodC() {
			synchronized(syncA) {
				println3("enter into SyncB.methodC");
				println("sleep...");
				sleep(5);
				println3("drop out SyncB.methodC");
			}
		}
	}
	
	//============================================
	
	@SuppressWarnings("unchecked")
	static void test2() {
		new Thread(SyncC::methodA).start();
		new Thread(SyncC::methodB).start();
		new Thread(new SyncD(SyncC.class)::methodC).start();
		new Thread(new SyncD((Class<SyncC>)new SyncC().getClass())::methodD).start();
	}
	
	static class SyncC {
		
		public static synchronized void methodA() {
			println3("enter into SyncC.methodA");
			println("sleep...");
			sleep(5);
			println3("drop out SyncC.methodA");
		}
		
		public static void methodB() {
			synchronized(SyncC.class) {
				println3("enter into SyncC.methodB");
				println("sleep...");
				sleep(5);
				println3("drop out SyncC.methodB");
			}
		}
	}
	
	static class SyncD {
		
		private Class<SyncC> syncClass;
		
		public SyncD(Class<SyncC> syncClass) {
			this.syncClass = syncClass;
		}
		
		public void methodC() {
			synchronized(syncClass) {
				println3("enter into SyncD.methodC");
				println("sleep...");
				sleep(5);
				println3("drop out SyncD.methodC");
			}
		}
		
		public void methodD() {
			synchronized(syncClass) {
				println3("enter into SyncD.methodD");
				println("sleep...");
				sleep(5);
				println3("drop out SyncD.methodD");
			}
		}
	}
}
