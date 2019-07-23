package org.cnt.java.classloader;

/**
 * @author lixinjie
 * @since 2019-07-23
 */
public class B {
	
	public static final int b = getA();
	
	static {
		System.out.println("-B-");
	}
	
	static int getA() {
		System.out.println("-b-");
		return 2;
	}
}
