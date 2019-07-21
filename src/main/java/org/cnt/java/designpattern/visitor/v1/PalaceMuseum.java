package org.cnt.java.designpattern.visitor.v1;

/**
 * <p>故宫，景点
 * @author lixinjie
 * @since 2019-07-21
 */
public interface PalaceMuseum {

	//让访客看
	void accept(Guest guest);
}
