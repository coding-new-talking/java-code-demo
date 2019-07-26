package org.cnt.java.annotation.typ.ci;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

import org.cnt.java.utils.Logger;

/**
 * @author lixinjie
 * @since 2019-07-26
 */
public class CITest {

	static Logger log = Logger.getLogger();
	
	public static void main(String[] args) {
		test();
		log.info("--------------------------------------------------------");
		test1();
	}

	static void test() {
		AnnotatedElement ae1 = CI1.class;
		
		log.info("getAnnotations={}", Arrays.toString(ae1.getAnnotations()));
		log.info("getDeclaredAnnotations={}", Arrays.toString(ae1.getDeclaredAnnotations()));

		//result：类不从它实现的接口继承注解
		//note：@Inherited注解规定，只能用于子类从父类继承，其它情况不起作用
	}
	
	static void test1() {
		try {
			AnnotatedElement ae1 = CI1.class.getDeclaredMethod("m1");
			
			log.info("getAnnotations={}", Arrays.toString(ae1.getAnnotations()));
			log.info("getDeclaredAnnotations={}", Arrays.toString(ae1.getDeclaredAnnotations()));
			
			AnnotatedElement ae2 = CI1.class.getDeclaredMethod("m2");
			
			log.info("getAnnotations={}", Arrays.toString(ae2.getAnnotations()));
			log.info("getDeclaredAnnotations={}", Arrays.toString(ae2.getDeclaredAnnotations()));
			
			//result：类在实现接口方法时不继承接口方法的注解
			//note：@Inherited注解规定，只能用于子类从父类继承，其它情况不起作用
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
