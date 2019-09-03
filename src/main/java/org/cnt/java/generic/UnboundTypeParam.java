package org.cnt.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixinjie
 * @since 2018-07-10
 */
public class UnboundTypeParam {

//	static void test(List list) {
//		
//	}
//	
//	static void test(List<?> list) {
//		
//	}
//	
//	static void test(List<? extends Object> list) {
//		
//	}
//	
//	static void test(List<Object> list) {
//		
//	}
	
	public static void main(String[] args) {
		List l1 = new ArrayList<>();
		List<?> l2 = new ArrayList<>();
		List<? extends Object> l3 = new ArrayList<>();
		List<Object> l4 = new ArrayList<>();
		
		l1 = l2;
		l1 = l3;
		l1 = l4;
		
		l2 = l1;
		l2 = l3;
		l2 = l4;
		
		l3 = l1;
		l3 = l2;
		l3 = l4;
		
		l4 = l1;
//		l4 = l2;
//		l4 = l3;
		
//		l2.add(new Object());//?表示一种确定的类型，但不知道是什么类型，所以任何类型都不许添加
		l2.get(0);//?表示一种确定的类型，但不知道是什么类型，所以只能按Object类型对待
	}

}
