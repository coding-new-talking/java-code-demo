package org.cnt.java.designpattern.visitor.v2;

/**
 * @author lixinjie
 * @since 2019-07-21
 */
public interface ElementA extends Element<VisitorA> {
	
	@Override
	void accept(VisitorA visitor);
}
