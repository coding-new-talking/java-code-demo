package org.cnt.java.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author lixinjie
 * @since 2020-07-03
 */
public class JpMain {

	public static void main(String[] args) {
		test1();
		System.out.println("\r\n--------\r\n");
		test2();
	}
	
	static void test2() {
		ClassAB classAB = new ClassAB();
		Object proxyObj = Proxy.newProxyInstance(JpMain.class.getClassLoader(),
				new Class<?>[] { InterA.class, InterB.class },
				(proxy, method, args) -> {
					String name = method.getName();
					System.out.println("before " + name);
					Object val = method.invoke(classAB, args);
					System.out.println("after " + name);
					return val;
				});
		InterA ia = (InterA)proxyObj;
		InterB ib = (InterB)proxyObj;
		ia.methodA1();
		ia.methodA2();
		ib.methodB1();
		ib.methodB2();
	}

	static void test1() {
		ClassAB classAB = new ClassAB();
		ActualHandler ah = new ActualHandler(classAB);
		Object proxy = Proxy.newProxyInstance(JpMain.class.getClassLoader(), new Class<?>[] { InterA.class, InterB.class }, ah);
		ah.setProxy(proxy);
		
		System.out.println("classAB == proxy : " + (classAB == proxy));
		
		classAB.methodA1();
		classAB.methodA2();
		classAB.methodB1();
		classAB.methodB2();
		System.out.println();
		InterA ia = (InterA)proxy;
		InterB ib = (InterB)proxy;
		ia.methodA1();
		ia.methodA2();
		ib.methodB1();
		ib.methodB2();
	}
}
