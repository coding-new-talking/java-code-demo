package org.cnt.java.classfile;

/**
 * <p>蔬菜
 * @author lixinjie
 * @since 2019-07-09
 */
public abstract class Vegetable implements Green {

	@Override
	public int getColor() {
		return 0;
	}

	public final String sprout() {
		return "ok";
	}
	
	public abstract void grow();
	
	
}
