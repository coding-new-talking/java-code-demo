package org.cnt.java.reflect.method;

import java.lang.reflect.Method;

/**
 * @author lixinjie
 * @since 2019-09-11
 */
public class MainTest {

	public static void main(String[] args) throws Exception {
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		test9();
		//test10();
	}
	
	static void test1() throws Exception {
		Method pm1 = Parent.class.getDeclaredMethod("m1");
		Method cm1 = Child.class.getDeclaredMethod("m1");
		System.out.println(pm1.getName() + ":" + cm1.getName());
		System.out.println(pm1);
		System.out.println(cm1);
		System.out.println(pm1 == cm1);
		System.out.println(pm1.equals(cm1));
		
		Parent p = new Parent();
		Child c = new Child();
		System.out.println(pm1.invoke(p));//Parent.m1
		System.out.println(pm1.invoke(c));//Child.m1
		
		System.out.println(cm1.invoke(c));//Child.m1
		
		//System.out.println(cm1.invoke(p));
	}
	
	static void test2() throws Exception {
		Method pm2 = Parent.class.getDeclaredMethod("m2");
		Method cm2 = Child.class.getDeclaredMethod("m2");
		System.out.println(pm2.getName() + ":" + cm2.getName());
		System.out.println(pm2);
		System.out.println(cm2);
		System.out.println(pm2 == cm2);
		System.out.println(pm2.equals(cm2));
		
		Parent p = new Parent();
		Child c = new Child();
		System.out.println(pm2.invoke(p));//Parent.m2
		System.out.println(pm2.invoke(c));//Child.m2
		
		System.out.println(cm2.invoke(c));//Child.m2
		
		//System.out.println(cm2.invoke(p));
	}
	
	static void test3() throws Exception {
		Method pm1 = Parent2.class.getDeclaredMethod("m1");
		Method cm1 = Child2.class.getDeclaredMethod("m1");
		System.out.println(pm1.getName() + ":" + cm1.getName());
		System.out.println(pm1);
		System.out.println(cm1);
		System.out.println(pm1 == cm1);
		System.out.println(pm1.equals(cm1));
		
		Child2 c2 = new Child2();
		
		System.out.println(cm1.invoke(c2));//Child2.m1
		System.out.println(pm1.invoke(c2));//Child2.m1
	}
	
	static void test4() throws Exception {
		Method pm2 = Parent2.class.getDeclaredMethod("m2");
		Method cm2 = Child2.class.getDeclaredMethod("m2");
		System.out.println(pm2.getName() + ":" + cm2.getName());
		System.out.println(pm2);
		System.out.println(cm2);
		System.out.println(pm2 == cm2);
		System.out.println(pm2.equals(cm2));
		
		Child2 c2 = new Child2();
		
		System.out.println(cm2.invoke(c2));//Child2.m2
		System.out.println(pm2.invoke(c2));//Child2.m2
	}
	

	static void test5() throws Exception {
		Method pm3 = Parent.class.getDeclaredMethod("m3");
		Method cm3 = Child.class.getDeclaredMethod("m3");
		System.out.println(pm3.getName() + ":" + cm3.getName());
		System.out.println(pm3);
		System.out.println(cm3);
		System.out.println(pm3 == cm3);
		System.out.println(pm3.equals(cm3));
		
		Parent p = new Parent();
		Child c = new Child();
		pm3.setAccessible(true);
		cm3.setAccessible(true);
		
		System.out.println(pm3.invoke(p));//Parent.m3
		System.out.println(pm3.invoke(c));//Parent.m3
		
		System.out.println(cm3.invoke(c));//Child.m3
		
		//System.out.println(cm3.invoke(p));
	}
	
	static void test6() throws Exception {
		Method im1 = Inter.class.getDeclaredMethod("m1");
		Method cm1 = Impl.class.getDeclaredMethod("m1");
		System.out.println(im1.getName() + ":" + cm1.getName());
		System.out.println(im1);
		System.out.println(cm1);
		System.out.println(im1 == cm1);
		System.out.println(im1.equals(cm1));
		
		Impl c = new Impl();
		
		System.out.println(im1.invoke(c));
		System.out.println(cm1.invoke(c));
	}
	
	static void test7() throws Exception {
		Method im2 = Inter.class.getDeclaredMethod("m2");
		Method cm2 = Impl.class.getDeclaredMethod("m2");
		System.out.println(im2.getName() + ":" + cm2.getName());
		System.out.println(im2);
		System.out.println(cm2);
		System.out.println(im2 == cm2);
		System.out.println(im2.equals(cm2));
		
		Impl c = new Impl();
		
		System.out.println(im2.invoke(c));
		System.out.println(cm2.invoke(c));
	}
	
	static void test8() throws Exception {
		Method im3 = Inter.class.getDeclaredMethod("m3");
		//Method cm3 = Impl.class.getDeclaredMethod("m3");
		Method cm3 = Impl.class.getMethod("m3");
		System.out.println(im3.getName() + ":" + cm3.getName());
		System.out.println(im3);
		System.out.println(cm3);
		System.out.println(im3 == cm3);
		System.out.println(im3.equals(cm3));
		
		Impl c = new Impl();
		
		System.out.println(im3.invoke(c));
		System.out.println(cm3.invoke(c));
	}
	
	static void test9() throws Exception {
		Method im4 = Inter.class.getDeclaredMethod("m4");
		//Method cm4 = Impl.class.getDeclaredMethod("m4");
		//Method cm4 = Impl.class.getMethod("m4");
		System.out.println(im4.getName()/* + ":" + cm4.getName()*/);
		System.out.println(im4);
		//System.out.println(cm4);
		//System.out.println(im4 == cm4);
		//System.out.println(im4.equals(cm4));
		
		Impl c = new Impl();
		
		System.out.println(im4.invoke(c));
		System.out.println(im4.invoke(null));
		System.out.println(im4.invoke(new Object()));
		System.out.println(im4.invoke(new String()));
		//System.out.println(cm4.invoke(c));
	}
	
	static void test10() throws Exception {
		Method cm5 = Impl.class.getDeclaredMethod("m5");
		System.out.println(cm5.getName());
		System.out.println(cm5);
		
		Impl c = new Impl();
		
		System.out.println(cm5.invoke(c));
		System.out.println(cm5.invoke(null));
		System.out.println(cm5.invoke(new Object()));
		System.out.println(cm5.invoke(new String()));
	}
}
