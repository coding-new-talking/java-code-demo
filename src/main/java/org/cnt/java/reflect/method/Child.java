package org.cnt.java.reflect.method;

/**
 * @author lixinjie
 * @since 2019-09-11
 */
public class Child extends Parent {

	@Override
	public String m1() {
		return "Child.m1";
	}
	
	@Override
	protected String m2() {
		return "Child.m2";
	}
	
	private String m3() {
		return "Child.m3";
	}
}
