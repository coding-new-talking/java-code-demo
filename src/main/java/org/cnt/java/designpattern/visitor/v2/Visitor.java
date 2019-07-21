package org.cnt.java.designpattern.visitor.v2;

/**
 * @author lixinjie
 * @since 2019-07-21
 */
public interface Visitor<E extends Element> {

	//访问元素
	void visit(E element);
}
