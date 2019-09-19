package org.cnt.java.reflect.method;

/**
 * @author lixinjie
 * @since 2019-09-19
 */
public class Impl implements Inter {

	@Override
	public String m1() {
		return "Impl.m1";
	}

	@Override
	public String m2() {
		return "Impl.m2";
	}
	
	public static String m5() {
		return "Impl.m5";
	}
}
