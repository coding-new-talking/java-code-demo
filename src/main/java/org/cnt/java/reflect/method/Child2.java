package org.cnt.java.reflect.method;

/**
 * @author lixinjie
 * @since 2019-09-11
 */
public class Child2 extends Parent2 {

	@Override
	public String m1() {
		return "Child2.m1";
	}
	
	@Override
	protected String m2() {
		return "Child2.m2";
	}
}
