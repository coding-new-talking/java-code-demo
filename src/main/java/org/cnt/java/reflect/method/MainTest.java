package org.cnt.java.reflect.method;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.cnt.java.utils.Log;

/**
 * @author lixinjie
 * @since 2019-09-11
 */
public class MainTest {

	public static void main(String[] args) throws Exception {
		test1();
		test2();
		test3();
		
		Log.log("\r\n---------------------------------\r\n");
		
		test4();
		test5();
		
		Log.log("\r\n---------------------------------\r\n");
		
		test6();
		test7();
		test8();
		test9();
		
		Log.log("\r\n---------------------------------\r\n");
		
		test10();
		
		Log.log("\r\n---------------------------------\r\n");
		
		test11();
		
		Log.log("\r\n---------------------------------\r\n");
		
		test12();
		test13();
		test14();
	}
	
	//公共方法
	static void test1() throws Exception {
		Method pm1 = Parent.class.getDeclaredMethod("m1");
		Method cm1 = Child.class.getDeclaredMethod("m1");
		Log.log(pm1);
		Log.log(cm1);
		Log.log("pm1 == cm1 -> {}", pm1 == cm1);
		Log.log("pm1.equals(cm1) -> {}", pm1.equals(cm1));
		
		Parent p = new Parent();
		Child c = new Child();
		Log.log(pm1.invoke(p));//Parent.m1
		Log.log(pm1.invoke(c));//Child.m1
		
		//Log.log(cm1.invoke(p));
		Log.log(cm1.invoke(c));//Child.m1
	}
	
	//受保护方法
	static void test2() throws Exception {
		Method pm2 = Parent.class.getDeclaredMethod("m2");
		Method cm2 = Child.class.getDeclaredMethod("m2");
		Log.log(pm2);
		Log.log(cm2);
		Log.log("pm2 == cm2 -> {}", pm2 == cm2);
		Log.log("pm2.equals(cm2) -> {}", pm2.equals(cm2));
		
		Parent p = new Parent();
		Child c = new Child();
		Log.log(pm2.invoke(p));//Parent.m2
		Log.log(pm2.invoke(c));//Child.m2
		
		//Log.log(cm2.invoke(p));
		Log.log(cm2.invoke(c));//Child.m2
	}
	
	//私有方法
	static void test3() throws Exception {
		Method pm3 = Parent.class.getDeclaredMethod("m3");
		Method cm3 = Child.class.getDeclaredMethod("m3");
		Log.log(pm3);
		Log.log(cm3);
		Log.log("pm3 == cm3 -> {}", pm3 == cm3);
		Log.log("pm3.equals(cm3) -> {}", pm3.equals(cm3));
		
		Parent p = new Parent();
		Child c = new Child();
		pm3.setAccessible(true);
		cm3.setAccessible(true);
		
		Log.log(pm3.invoke(p));//Parent.m3
		Log.log(pm3.invoke(c));//Parent.m3
		
		//Log.log(cm3.invoke(p));
		Log.log(cm3.invoke(c));//Child.m3
	}
	
	//抽象公共方法
	static void test4() throws Exception {
		Method pm1 = Parent2.class.getDeclaredMethod("m1");
		Method cm1 = Child2.class.getDeclaredMethod("m1");
		Log.log(pm1);
		Log.log(cm1);
		Log.log("pm1 == cm1 -> {}", pm1 == cm1);
		Log.log("pm1.equals(cm1) -> {}", pm1.equals(cm1));
		
		Child2 c2 = new Child2();
		
		Log.log(pm1.invoke(c2));//Child2.m1
		Log.log(cm1.invoke(c2));//Child2.m1
	}
	
	//抽象受保护方法
	static void test5() throws Exception {
		Method pm2 = Parent2.class.getDeclaredMethod("m2");
		Method cm2 = Child2.class.getDeclaredMethod("m2");
		Log.log(pm2);
		Log.log(cm2);
		Log.log("pm2 == cm2 -> {}", pm2 == cm2);
		Log.log("pm2.equals(cm2) -> {}", pm2.equals(cm2));
		
		Child2 c2 = new Child2();
		
		Log.log(cm2.invoke(c2));//Child2.m2
		Log.log(pm2.invoke(c2));//Child2.m2
	}
	
	//接口抽象方法
	static void test6() throws Exception {
		Method im1 = Inter.class.getDeclaredMethod("m1");
		Method cm1 = Impl.class.getDeclaredMethod("m1");
		Log.log(im1);
		Log.log(cm1);
		Log.log("im1 == cm1 -> {}", im1 == cm1);
		Log.log("im1.equals(cm1) -> {}", im1.equals(cm1));
		
		Impl c = new Impl();
		
		Log.log(im1.invoke(c));//Impl.m1
		Log.log(cm1.invoke(c));//Impl.m1
	}
	
	//接口默认方法，被重新实现
	static void test7() throws Exception {
		Method im2 = Inter.class.getDeclaredMethod("m2");
		Method cm2 = Impl.class.getDeclaredMethod("m2");
		Log.log(im2);
		Log.log(cm2);
		Log.log("im2 == cm2 -> {}", im2 == cm2);
		Log.log("im2.equals(cm2) -> {}", im2.equals(cm2));
		
		Impl c = new Impl();
		
		Log.log(im2.invoke(c));//Impl.m2
		Log.log(cm2.invoke(c));//Impl.m2
	}
	
	//接口默认方法，没有被重新实现，等于直接继承
	static void test8() throws Exception {
		Method im3 = Inter.class.getDeclaredMethod("m3");
		//Method cm3 = Impl.class.getDeclaredMethod("m3");
		Method cm3 = Impl.class.getMethod("m3");
		Log.log(im3);
		Log.log(cm3);
		Log.log("im3 == cm3 -> {}", im3 == cm3);
		Log.log("im3.equals(cm3) -> {}", im3.equals(cm3));//true
		
		Impl c = new Impl();
		
		Log.log(im3.invoke(c));//Inter.m3
		Log.log(cm3.invoke(c));//Inter.m3
	}
	
	//接口静态方法，无法被继承
	static void test9() throws Exception {
		Method im4 = Inter.class.getDeclaredMethod("m4");
		//Method cm4 = Impl.class.getDeclaredMethod("m4");
		//Method cm4 = Impl.class.getMethod("m4");
		Log.log(im4);
		//Log.log(cm4);
		//Log.log(im4 == cm4);
		//Log.log(im4.equals(cm4));
		
		Impl c = new Impl();
		
		//静态方法，无需对象，所以参数随意
		Log.log(im4.invoke(c));
		Log.log(im4.invoke(null));
		Log.log(im4.invoke(new Object()));
		Log.log(im4.invoke(new String()));
		//Log.log(cm4.invoke(c));
		
		//直接使用接口调用
		Log.log(Inter.m4());
		
		//不能通过实现类调用接口的静态方法
		//Log.log(Impl.m4());
	}
	
	//类的静态方法
	static void test10() throws Exception {
		Method cm5 = Impl.class.getDeclaredMethod("m5");
		Method c2m5 = Impl2.class.getMethod("m5");
		Log.log(cm5);
		Log.log(c2m5);
		Log.log("cm5 == c2m5 -> {}", cm5 == c2m5);
		Log.log("cm5.equals(c2m5) -> {}", cm5.equals(c2m5));//true
		
		Log.log(cm5.invoke(null));
		Log.log(c2m5.invoke(null));
		
		Log.log(Impl.m5());
		//子类可以直接调用父类的静态方法
		Log.log(Impl2.m5());
	}
	
	static void test11() throws Exception {
		Method m1 = Object.class.getDeclaredMethod("toString");
		Method m2 = Object.class.getDeclaredMethod("toString");
		//Method对象每次返回的都不是同一个，即不相同
		Log.log("m1 == m2 -> {}", m1 == m2);//false
		//但是它们相等
		Log.log("m1.equals(m2) -> {}", m1.equals(m2));//true
	}
	
	//公共字段
	static void test12() throws Exception {
		Field pf1 = Parent3.class.getDeclaredField("f1");
		Field cf1 = Child3.class.getDeclaredField("f1");
		Log.log(pf1);
		Log.log(cf1);
		Log.log("pf1.equals(cf1) -> {}", pf1.equals(cf1));
		Parent3 p = new Parent3();
		Child3 c = new Child3();
		Log.log(pf1.get(p));//Parent3.f1
		Log.log(pf1.get(c));//Parent3.f1
		
		//Log.log(cf1.get(p));
		Log.log(cf1.get(c));//Child3.f1
	}
	
	//受保护字段
	static void test13() throws Exception {
		Field pf2 = Parent3.class.getDeclaredField("f2");
		Field cf2 = Child3.class.getDeclaredField("f2");
		Log.log(pf2);
		Log.log(cf2);
		Log.log("pf2.equals(cf2) -> {}", pf2.equals(cf2));
		Parent3 p = new Parent3();
		Child3 c = new Child3();
		Log.log(pf2.get(p));//Parent3.f2
		Log.log(pf2.get(c));//Parent3.f2
		
		//Log.log(cf2.get(p));
		Log.log(cf2.get(c));//Child3.f2
	}
	
	//私有字段
	static void test14() throws Exception {
		Field pf3 = Parent3.class.getDeclaredField("f3");
		Field cf3 = Child3.class.getDeclaredField("f3");
		Log.log(pf3);
		Log.log(cf3);
		Log.log("pf3.equals(cf3) -> {}", pf3.equals(cf3));
		Parent3 p = new Parent3();
		Child3 c = new Child3();
		
		pf3.setAccessible(true);
		cf3.setAccessible(true);
		Log.log(pf3.get(p));//Parent3.f3
		Log.log(pf3.get(c));//Parent3.f3
		
		//Log.log(cf3.get(p));
		Log.log(cf3.get(c));//Child3.f3
	}
}
