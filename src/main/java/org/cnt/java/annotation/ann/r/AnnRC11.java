package org.cnt.java.annotation.ann.r;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
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
@Target({TYPE, FIELD, METHOD})
@Inherited
public @interface AnnRC11 {

	AnnR11[] value();
}
