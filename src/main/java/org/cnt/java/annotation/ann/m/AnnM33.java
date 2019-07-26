package org.cnt.java.annotation.ann.m;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author lixinjie
 * @since 2019-07-25
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
@Inherited
public @interface AnnM33 {

}
