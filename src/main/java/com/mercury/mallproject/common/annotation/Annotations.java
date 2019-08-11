package com.mercury.mallproject.common.annotation;

import com.google.common.collect.Lists;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class Annotations {
	
	public static <T extends Annotation> List<Object>  getFields(Object target, Class<T> annotationClass) throws Exception {
		Class<?> clazz = target.getClass();
		
		List<Object> result = Lists.newArrayList();
		
		final Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			final T annotation = AnnotationUtils.getAnnotation(field, annotationClass);
			if(annotation == null){
				continue;
			}
			final Object fieldValue = field.get(target);
			if(fieldValue == null){
				continue;
			}	
			result.add(fieldValue);
		}
		return result;
	}
	
	public static <T extends Annotation> List<Field>  getFields(Class<?> clazz, Class<T> annotationClass) throws Exception {
		List<Field> result = Lists.newArrayList();
		
		Class<?> searchType = clazz;
		while (!Object.class.equals(searchType) && searchType != null) {
			Field[] fields = searchType.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				final T annotation = AnnotationUtils.getAnnotation(field, annotationClass);
				if(annotation != null){
					result.add(field);
				}
			}
			searchType = searchType.getSuperclass();
		}
		return result;
	}
	
	public static <T extends Annotation> List<Field>  getFieldsWithoutException(Class<?> clazz, Class<T> annotationClass) {
		try {
			return getFields(clazz, annotationClass);
		} catch (Exception e) {
			//ignore;
		}
		return Collections.emptyList();
	}
	
}
