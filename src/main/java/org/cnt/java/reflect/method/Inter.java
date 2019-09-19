package org.cnt.java.reflect.method;

/**
 * @author lixinjie
 * @since 2019-09-19
 */
public interface Inter {

	String m1();
	
	default String m2() {
		return "Inter.m2";
	}
	
	default String m3() {
		return "Inter.m3";
	}
	
	static String m4() {
		return "Inter.m4";
	}
}
