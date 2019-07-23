package org.cnt.java.classloader;

/**
 * @author lixinjie
 * @since 2019-07-23
 */
public class A extends B {

	public static final int a = getA();
	
	static {
		System.out.println("-A-");
	}
	
	static int getA() {
		System.out.println("-a-");
		return 1;
	}
}
