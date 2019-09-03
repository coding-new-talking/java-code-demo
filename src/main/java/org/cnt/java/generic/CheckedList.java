package org.cnt.java.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lixinjie
 * @since 2018-07-10
 */
public class CheckedList {

	static class A {}
	static class B {}
	
	static void test1() {
		List<A> al = new ArrayList<>();
		al.add(new A());
		((List)al).add(new B());
		//al.forEach(System.out::println);
		al.forEach((Object o) -> System.out.println(o));
	}
	
	static void test2() {
		List<A> al = new ArrayList<>();
		List<A> cal = Collections.checkedList(al, A.class);
		cal.add(new A());
		((List)cal).add(new B());
		//al.forEach(System.out::println);
		al.forEach((Object o) -> System.out.println(o));
	}
	
	public static void main(String[] args) {
		//test1();
		test2();
	}

}
