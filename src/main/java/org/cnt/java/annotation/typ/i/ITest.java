package org.cnt.java.annotation.typ.i;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

import org.cnt.java.utils.Logger;

/**
 * @author lixinjie
 * @since 2019-07-26
 */
public class ITest {

	static Logger log = Logger.getLogger();
	
	public static void main(String[] args) {
		test();
	}

	static void test() {
		AnnotatedElement ae1 = I1.class;
		AnnotatedElement ae2 = I2.class;
		
		log.info("getAnnotations={}", Arrays.toString(ae1.getAnnotations()));
		log.info("getAnnotations={}", Arrays.toString(ae2.getAnnotations()));
		
		log.info("getDeclaredAnnotations={}", Arrays.toString(ae1.getDeclaredAnnotations()));
		log.info("getDeclaredAnnotations={}", Arrays.toString(ae2.getDeclaredAnnotations()));

		//result：子接口不从父接口继承注解
		//note：@Inherited注解规定，只能用于子类从父类继承，其它情况不起作用
	}
}
