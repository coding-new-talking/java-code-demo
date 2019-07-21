package org.cnt.java.designpattern.visitor.v2;

/**
 * @author lixinjie
 * @since 2019-07-21
 */
public interface VisitorB extends Visitor<ElementB> {

	@Override
	void visit(ElementB element);
}
