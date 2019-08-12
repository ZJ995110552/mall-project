package com.mercury.mallproject.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	int index();
	String title();
	String type() default "label";
	String format() default "";
	boolean isPic() default false;
}
