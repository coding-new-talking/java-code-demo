package org.cnt.java.designpattern.visitor.v2;

/**
 * @author lixinjie
 * @since 2019-07-21
 */
public interface Element<V extends Visitor> {

	//接受访问者
	void accept(V visitor);
}
