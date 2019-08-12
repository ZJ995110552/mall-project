package com.mercury.mallproject.common.utils;

import com.mercury.mallproject.common.enums.EnumCode;
import com.mercury.mallproject.common.enums.IsInitEnum;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class EnumUtil {
	
	public static <K, E extends EnumCode<K>> E getEnumByKey(Class<E> clazz, K key) {
		if (Enum.class.isAssignableFrom(clazz)) {
			if (key == null) {
				return null;
			}
			E[] enumConstants = clazz.getEnumConstants();
			if (ArrayUtils.isNotEmpty(enumConstants)) {
				for (E e : enumConstants) {
					if (key instanceof String && ObjectUtils.equals(String.valueOf(e.getCode()), key)) {
						return e;
					} else if (ObjectUtils.equals(e.getCode(), key)) {
						return e;

					}
				}
			}
			return null;
		}
		return null;
	}
	
	public static <K, E extends EnumCode<K>> E getEnumByDescription(Class<E> clazz, String description) {
		if (Enum.class.isAssignableFrom(clazz)) {
			if (StringUtils.isEmpty(description)) {
				return null;
			}
			E[] enumConstants = clazz.getEnumConstants();
			if (ArrayUtils.isNotEmpty(enumConstants)) {
				for (E e : enumConstants) {
					if (StringUtils.equals(e.getDescription(), description)) {
						return e;
					}
				}
			}
			return null;
		}
		return null;
	}
	
	public static EnumCode getEnumByDescriptionWithGenericClass(Class clazz, String description) {
		if (Enum.class.isAssignableFrom(clazz)) {
			if (StringUtils.isEmpty(description)) {
				return null;
			}
			Object[] enumConstants = clazz.getEnumConstants();
			if (ArrayUtils.isNotEmpty(enumConstants)) {
				for (Object e : enumConstants) {
					if (StringUtils.equals(((EnumCode)e).getDescription(), description)) {
						return (EnumCode)e;
					}
				}
			}
			return null;
		}
		return null;
	}
	
	public static <K, E extends EnumCode<K>> K getEnumKey(E enumV) {
		if(enumV == null){
			return null;
		}
		return enumV.getCode();
	}

	public static <K,T extends EnumCode<K>> T[] getEnumConstants(Class<T> enumClass) {
		if(!enumClass.isEnum()){
			return null;
		}
		T[] tObj = enumClass.getEnumConstants();
		return tObj;
	}


	public static <K,T extends EnumCode<K>> HashMap<K,String> getEnumMap(Class<T> enumClass) {
		HashMap<K, String> enumMap = new HashMap();

		if(!enumClass.isEnum()){
			return null;
		}

		T[] enumConstants = enumClass.getEnumConstants();

		for (T enumObj : enumConstants) {
			enumMap.put( enumObj.getCode(), enumObj.getDescription());
		}

		return enumMap;
	}

	public static void main(String[] args) {
		System.out.println("========================================");
		IsInitEnum enum1 = EnumUtil.getEnumByKey(IsInitEnum.class, "0");
		System.out.println(enum1);
		System.out.println("========================================");
		IsInitEnum anEnum = EnumUtil.getEnumByDescription(IsInitEnum.class, "是");
		System.out.println(anEnum);
		System.out.println("========================================");
		EnumCode aaa = EnumUtil.getEnumByDescriptionWithGenericClass(IsInitEnum.class, "是");
		System.out.println(aaa);
		System.out.println("========================================");
		HashMap<String, String> enumMap = EnumUtil.getEnumMap(IsInitEnum.class);
		Iterator<Map.Entry<String, String>> iterator = enumMap.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> entry = iterator.next();
			System.out.println("code = " + entry.getKey() + ", value = " + entry.getValue());
		}
		System.out.println("========================================");
		IsInitEnum[] enumConstants = EnumUtil.getEnumConstants(IsInitEnum.class);
		for (IsInitEnum is: enumConstants) {
			System.out.println("key = " + is.toString() + ", code = " + is.getCode() + ", value = " + is.getDescription());
		}
	}

}
