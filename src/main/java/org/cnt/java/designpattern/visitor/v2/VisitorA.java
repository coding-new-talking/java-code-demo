package org.cnt.java.designpattern.visitor.v2;

/**
 * @author lixinjie
 * @since 2019-07-21
 */
public interface VisitorA extends Visitor<ElementA> {
	
	@Override
	void visit(ElementA element);
}
