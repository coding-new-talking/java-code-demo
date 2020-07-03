package org.cnt.java.jdkproxy;

/**
 * @author lixinjie
 * @since 2020-07-03
 */
public class ClassAB implements InterA, InterB {

	@Override
	public void methodB1() {
		System.out.println("methodB1");
	}

	@Override
	public void methodB2() {
		System.out.println("methodB2");
	}

	@Override
	public void methodA1() {
		System.out.println("methodA1");
	}

	@Override
	public void methodA2() {
		System.out.println("methodA2");
	}

}
