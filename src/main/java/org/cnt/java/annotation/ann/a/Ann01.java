package org.cnt.java.annotation.ann.a;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
/**
 * @author lixinjie
 * @since 2019-07-25
 */
public @interface Ann01 {

	String id() default "";
}
