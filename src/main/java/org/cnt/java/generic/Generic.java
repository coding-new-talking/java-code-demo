package org.cnt.java.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lixinjie
 * @since 2019-07-18
 */
public class Generic {

	protected List<String> strList = new ArrayList<>();
	
	protected List<Integer> intMethod() {
		return null;
	}
	
	public static void main(String[] args) {
		try {
			Field field = Generic.class.getDeclaredField("strList");
			System.out.println(field.getType());
			System.out.println(field.getGenericType());
			System.out.println(field.getAnnotatedType().getType());
			Class<?> clazz = new Generic().strList.getClass();
			System.out.println(clazz.toGenericString());
			System.out.println(clazz.getTypeName());
			System.out.println(clazz.getTypeParameters()[0]);
			Method method = Generic.class.getDeclaredMethod("intMethod");
			System.out.println(method.getReturnType());
			System.out.println(method.getGenericReturnType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
