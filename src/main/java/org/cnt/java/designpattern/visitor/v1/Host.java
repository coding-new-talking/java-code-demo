package org.cnt.java.designpattern.visitor.v1;

/**
 * <p>东道主，协调者
 * @author lixinjie
 * @since 2019-07-21
 */
public interface Host {

	//带朋友去故宫
	void show(PalaceMuseum PalaceMuseum, Guest guest);
	
	//带朋友去长城
	void show(GreatWall GreatWall, Guest guest);
	
	//带朋友去颐和园
	void show(SummerPalace SummerPalace, Guest guest);
}
