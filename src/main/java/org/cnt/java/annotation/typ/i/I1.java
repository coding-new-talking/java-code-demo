package org.cnt.java.annotation.typ.i;

import org.cnt.java.annotation.ann.i.AnnI13;
import org.cnt.java.annotation.ann.i.AnnI33;
import org.cnt.java.annotation.ann.i.AnnI43;
import org.cnt.java.annotation.ann.m.AnnM13;
import org.cnt.java.annotation.ann.m.AnnM33;
import org.cnt.java.annotation.ann.m.AnnM43;

/**
 * @author lixinjie
 * @since 2019-07-25
 */
@AnnI13
@AnnI33("I1")
@AnnI43("I1")
public interface I1 {

	@AnnM13
	@AnnM33
	@AnnM43("I1")
	void m1();
	
	@AnnM13
	@AnnM33
	@AnnM43("I1")
	void m2();

}
