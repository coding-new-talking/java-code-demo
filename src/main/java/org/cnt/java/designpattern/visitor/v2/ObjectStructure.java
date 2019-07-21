package org.cnt.java.designpattern.visitor.v2;

import java.util.List;

/**
 * @author lixinjie
 * @since 2019-07-21
 */
public interface ObjectStructure {

	//所有元素
	List<Element> getElements();
	
	//所有访问者
	List<Visitor> getVisitors();
}
