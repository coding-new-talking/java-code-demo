package org.cnt.java.classfile;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
/**
 * @author lixinjie
 * @since 2019-07-23
 */
public @interface Health {

	String name() default "";
	
	int classify() default 0;
	
	Class<?> type() default Object.class;
}
