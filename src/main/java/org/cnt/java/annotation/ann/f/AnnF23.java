package org.cnt.java.annotation.ann.f;

import static java.lang.annotation.ElementType.FIELD;
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
@Target(FIELD)
public @interface AnnF23 {

}
