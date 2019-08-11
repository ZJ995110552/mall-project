package com.mercury.mallproject.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NMField {

	String value();
	
	PropertyType propertyType() default PropertyType.input;
	
	String constraint() default "";
	
	int order() default 1000;
	
	boolean compare() default false;
	
	String formater() default "";
	
	public static enum PropertyType {
		input,
		radio,
		checkbox,
		select,
		multiselect;
	}
	
	public static enum ValueType {
		string,//string
		number,//number
		integer,//int
		bool;//boolean
	}
	
	
}
