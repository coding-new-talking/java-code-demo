package org.cnt.java.annotation.typ.f;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

import org.cnt.java.utils.Logger;

/**
 * @author lixinjie
 * @since 2019-07-26
 */
public class FTest {

	static Logger log = Logger.getLogger();
	
	public static void main(String[] args) {
		test();
	}
	
	static void test() {
		try {
			AnnotatedElement ae1 = F2.class.getField("f1");
			
			log.info("getAnnotations={}", Arrays.toString(ae1.getAnnotations()));
			log.info("getDeclaredAnnotations={}", Arrays.toString(ae1.getDeclaredAnnotations()));
			
			AnnotatedElement ae2 = F2.class.getField("f2");
			
			log.info("getAnnotations={}", Arrays.toString(ae2.getAnnotations()));
			log.info("getDeclaredAnnotations={}", Arrays.toString(ae2.getDeclaredAnnotations()));
			
			//result：子类原封不动继承父类字段时，自然可以得到字段上的注解
			//note：@Inherited注解规定，只能用于子类从父类继承，其它情况不起作用
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
