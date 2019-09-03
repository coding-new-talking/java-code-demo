package org.cnt.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixinjie
 * @since 2018-07-09
 */
public class ListCvCtv {

	static class Fruit {}
	static class Apple extends Fruit {}
	static class Orange extends Fruit {}
	static class Banana extends Fruit {}
	static class Peach extends Fruit {}
	
	static class YTApple extends Apple {}
	static class AKSApple extends Apple {}
	
	static void test1() {
		List<Apple> alist = new ArrayList<>();
		List<Orange> olist = new ArrayList<>();
		List<Banana> blist = new ArrayList<>();
		List<Peach> plist = new ArrayList<>();
//		List<Fruit> flist;
//		flist = alist;
//		flist = olist;
//		flist = (List<Apple>)blist;
//		flist = (List<Apple>)plist;
		List<? extends Fruit> flist;
		flist = alist;
		flist = olist;
		flist = blist;
		flist = plist;
	}
	
	static void test2() {
		List<Apple> alist = new ArrayList<>();
		alist.add(new Apple());
		alist.add(new YTApple());
		alist.add(new AKSApple());
		
		List<? extends Fruit> flist;
		flist = alist;
		Fruit f0 = flist.get(0);
		Fruit f1 = flist.get(1);
		Fruit f2 = flist.get(2);
		System.out.println(f0);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println("--------------------------");
		for (Fruit f : flist) {
			System.out.println(f);
		}
		System.out.println("--------------------------");
		flist.forEach(System.out::println);
		//读出数据没问题
		//实际存储的是Fruit的子类，读出时声明的类型是Fruit，其实是子类到父类的（自动）向上转型
		
//		flist.add(new Fruit());
//		flist.add(new Apple());
//		flist.add(new Orange());
//		flist.add(new Banana());
//		flist.add(new Peach());
		//写入数据不可以
		//? extends Fruit表示的不是一个范围（无论什么水果），而是一种确切类型（具体某种水果）
		//底层是Fruit的一个子类，具体是哪个子类不知道，无法添加
		//这里底层List其实是Apple啊（理论上编译器可以推断出来），为什么添加Apple也不行，泛型参数在运行时被擦除了
	}
	
	static void test3() {
		List<Object> list = new ArrayList<>();
		list.add("编程新说");
		list.add(456789);
		//底层List持有的Object是所有类的父类，添加的都是它的子类
		List<? super Apple> alist;
		List<Object> olist = new ArrayList<>();
		List<String> slist = new ArrayList<>();
		List<Fruit> flist = new ArrayList<>();
		List<Apple> alist1 = new ArrayList<>();
		List<YTApple> ytalist = new ArrayList<>();
		alist = olist;
		alist = flist;
		alist = alist1;
		//alist = slist;
		//alist = (List<Apple>)ytalist;
		alist.add(new Apple());
		alist.add(new YTApple());
		alist.add(new AKSApple());
		//alist.add(new Fruit());
		//写入数据没问题
		//写入的数据是Apple及Apple的子类，底层存储的类型实际是Apple及Apple的父类，其实还是子类到父类的（自动）向上转型
		Object o1 = alist.get(0);
		Object o2 = alist.get(1);
		Object o3 = alist.get(2);
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		System.out.println("--------------------------");
//		for (Apple f : alist) {
//			
//		}
//		for (Fruit f : alist) {
//			
//		}
		for (Object f : alist) {
			System.out.println(f);
		}
		System.out.println("--------------------------");
		alist.forEach(System.out::println);
		//读出数据没问题，只是类型都是Object
		//底层存储的类型实际是Apple及Apple的父类，它的父类可能有多个，编译器不知道是哪个，所以按顶级父类Object来推断
	}
	
	static void test4() {
		List<? extends Fruit> flist = new ArrayList<>();
//		flist.add(new Fruit());
//		flist.add(new Apple());
//		flist.add(new Orange());
//		flist.add(new Banana());
//		flist.add(new Peach());
		//底层在运行时是支持的，被擦出到Object，只是编译器在编译时进行了限制，这正是泛型的目的，让问题尽早暴露出来
		((List<Fruit>)(Object)flist).add(new Fruit());
		((List<Apple>)(Object)flist).add(new Apple());
		((List<Orange>)(Object)flist).add(new Orange());
		((List<Object>)(Object)flist).add(new Banana());
		((List<Object>)(Object)flist).add(new Peach());
		((List<Object>)(Object)flist).add("李新杰");
		((List<Object>)(Object)flist).add(123456);
		((List<Object>)(Object)flist).add(new Object());
		
		flist.forEach((Object f) -> System.out.println(f));
	}
	
	static void test5() {
		List<Fruit> fread = new ArrayList<>();
		List<Fruit> fwrite = new ArrayList<>();
		test6(fread, fwrite);
		test7(fread, fwrite);
		List<Apple> aread = new ArrayList<>();
		List<Apple> awrite = new ArrayList<>();
		test7(aread, awrite);
	}
	
	/**
	 * ? extends Fruit和? super Fruit都表示某种具体类型
	 * extends表示输入，相当于入参，协变
	 * super表示输出，相当于出参，逆变
	 */
	static void test6(List<? extends Fruit> readFrom, List<? super Fruit> writeTo) {
		for (Fruit f : readFrom) {
			writeTo.add(f);
		}
	}
	
	static <T> void test7(List<? extends T> readFrom, List<? super T> writeTo) {
		for (T f : readFrom) {
			writeTo.add(f);
		}
	}
	
	
	public static void main(String[] args) {
		//test2();
		//test3();
		//test4();
	}

}
