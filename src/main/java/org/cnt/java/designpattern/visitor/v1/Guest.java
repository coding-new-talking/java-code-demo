package org.cnt.java.designpattern.visitor.v1;

/**
 * <p>客人，访问者
 * @author lixinjie
 * @since 2019-07-21
 */
public interface Guest {

	//看故宫
	void look(PalaceMuseum PalaceMuseum);
	
	//看长城
	void look(GreatWall GreatWall);
	
	//看颐和园
	void look(SummerPalace SummerPalace);
}
