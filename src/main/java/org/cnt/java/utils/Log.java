package org.cnt.java.utils;

/**
 * @author lixinjie
 * @since 2019-09-20
 */
public class Log {

	public static void log(Object o) {
		System.out.println(o);
	}
	
	public static void log(String str, Object... os) {
		for (Object o : os) {
			str = str.replaceFirst("\\{\\}", String.valueOf(o));
		}
		log(str);
	}
}
