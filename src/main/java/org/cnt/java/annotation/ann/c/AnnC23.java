package org.cnt.java.annotation.ann.c;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author lixinjie
 * @since 2019-07-25
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface AnnC23 {

	String id() default "";
}
