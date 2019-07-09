package org.cnt.java.utils;

/**
 * @author lixinjie
 * @since 2019-07-08
 */
public class Sleeper {

	public static void sleep(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			
		}
	}
}
