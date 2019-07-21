package org.cnt.java.designpattern.visitor.v1;

/**
 * <p>长城，景点
 * @author lixinjie
 * @since 2019-07-21
 */
public interface GreatWall {

	//让访客看
	void accept(Guest guest);
}
