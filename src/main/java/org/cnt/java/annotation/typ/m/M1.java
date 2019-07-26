package org.cnt.java.annotation.typ.m;

import org.cnt.java.annotation.ann.m.AnnM13;
import org.cnt.java.annotation.ann.m.AnnM33;
import org.cnt.java.annotation.ann.m.AnnM43;

/**
 * @author lixinjie
 * @since 2019-07-26
 */
public class M1 {

	@AnnM13
	@AnnM33
	@AnnM43("M1")
	public void m1() {}
	
	@AnnM13
	@AnnM33
	@AnnM43("M1")
	public void m2() {}
}
