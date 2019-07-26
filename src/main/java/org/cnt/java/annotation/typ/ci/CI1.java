package org.cnt.java.annotation.typ.ci;

import org.cnt.java.annotation.ann.m.AnnM23;
import org.cnt.java.annotation.ann.m.AnnM43;
import org.cnt.java.annotation.typ.i.I1;

/**
 * @author lixinjie
 * @since 2019-07-25
 */
public class CI1 implements I1 {

	String f1;
	
	@AnnM23
	@AnnM43("CI1")
	@Override
	public void m1() {
	}

	@Override
	public void m2() {
	}

}
