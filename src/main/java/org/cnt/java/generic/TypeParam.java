package org.cnt.java.generic;

import java.util.Arrays;

/**
 * @author lixinjie
 * @since 2018-07-06
 */
public class TypeParam<T, R> {

	public void printTypeInfo1() {
		System.out.println(Arrays.asList(this.getClass().getTypeParameters()));
	}
	
	public static void printTypeInfo2() {
		System.out.println(Arrays.asList(TypeParam.class.getTypeParameters()));
	}
	
	public void testType(Object obj) {
//		System.out.println(obj instanceof T);
//		System.out.println(obj instanceof R);
//		System.out.println(new T());
//		System.out.println(new R());
	}
	
	public void testArray() {
		
	}
	
	public static void main(String[] args) {
		new TypeParam().printTypeInfo1();
		new TypeParam<String, Integer>().printTypeInfo1();
		TypeParam.printTypeInfo2();
		
		System.out.println(new TypeParam().getClass() == new TypeParam<String, Integer>().getClass());
		System.out.println(TypeParam.class == new TypeParam<String, Integer>().getClass());
		System.out.println(new TypeParam<Double, Short>().getClass() == new TypeParam<String, Integer>().getClass());
	}
}
