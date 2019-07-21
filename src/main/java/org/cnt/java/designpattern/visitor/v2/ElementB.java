package org.cnt.java.designpattern.visitor.v2;

/**
 * @author lixinjie
 * @since 2019-07-21
 */
public interface ElementB extends Element<VisitorB> {

	@Override
	void accept(VisitorB visitor);
}
