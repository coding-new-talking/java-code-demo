package org.cnt.java.annotation.ann.a;

/**
 * @author lixinjie
 * @since 2019-08-05
 */
@Ann01
@Ann02(id = "ATest.Ann02")
public class ATest {

	public static void main(String[] args) {
		try {
			showAnn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void showAnn() throws Exception {
		Ann01 ann01 = ATest.class.getAnnotation(Ann01.class);
		System.out.println(ann01.id());
		System.out.println(ann01.annotationType().getDeclaredMethod("id").getDefaultValue());
		System.out.println(ann01);
		Ann02 ann02 = ATest.class.getAnnotation(Ann02.class);
		System.out.println(ann02.id());
		System.out.println(ann02.annotationType().getDeclaredMethod("id").getDefaultValue());
		System.out.println(ann02);
	}
}
