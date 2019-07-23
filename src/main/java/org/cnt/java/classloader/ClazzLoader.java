package org.cnt.java.classloader;

/**
 * @author lixinjie
 * @since 2019-07-23
 */
public class ClazzLoader {

	public static void main(String[] args) {
		try {
			System.out.println(A.class);
			Class<?> fa = Class.forName("org.cnt.java.classloader.A");
			Class<?> ca = A.class;
			System.out.println(ca == fa);
			Class<?> clazz = ClazzLoader.class.getClassLoader().loadClass("org.cnt.java.classloader.A");
			System.out.println(clazz);
			System.out.println(A.a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
