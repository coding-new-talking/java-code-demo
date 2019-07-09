package org.cnt.java.utils;

import java.util.Random;

/**
 * @author lixinjie
 * @since 2019-07-09
 */
public class Randomer {
	
	public static int random(int max) {
		return random(0, max);
	}
	
	public static int random(int min, int max) {
		return min + new Random().nextInt(max - min + 1);
	}
}
