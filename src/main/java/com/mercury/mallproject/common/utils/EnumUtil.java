package com.mercury.mallproject.common.utils;

import com.mercury.mallproject.common.enumresource.EnumCode;
import com.mercury.mallproject.common.enumresource.IsInitEnum;

import java.util.HashMap;

public class EnumUtil {
	
    public static <K,T extends EnumCode<K>> T[] getEnumConstants(Class<T> enumClass) {
        if(!enumClass.isEnum()){
            return null;
        }
        T[] tObj = enumClass.getEnumConstants();
        return tObj;
    }
    
    
    public static <K,T extends EnumCode<K>> HashMap<K,String> getKeyDescriptionMap(Class<T> enumClass) {
    	HashMap<K, String> enumMap = new HashMap<K, String>();
    	
    	if(!enumClass.isEnum()){
            return null;
        }
    	
    	T[] enumConstants = enumClass.getEnumConstants();
    	
    	for (T enumObj : enumConstants) {
    		enumMap.put( enumObj.getCode(), enumObj.getDescription());
    	}
    	
    	return enumMap;
    }
    
    
    
    
	public static HashMap<String,String> getValues(Class<?> enumClass) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
//		Object[] constants = getEnumConstants(enumClass);
//		List<String> values = new ArrayList<String>();
//		for (Object constant : constants) {
//			values.add(((Enum<?>) constant).toString());
//		}
//		return values.toArray(new String[values.size()]);
		
		//判断类是不是枚举类
		if(!enumClass.isEnum()){
			return null;
			
		}
		Object[] enumConstants = enumClass.getEnumConstants();
		
		System.out.println(enumClass);
		//遍历内部内
//		for (Class class1 : enumClass) {
//			//判断类是不是枚举类
//			if(class1.isEnum()){
//				//获取内部内的类名，在这里其实就是获取枚举类
//				 String simpleName = class1.getSimpleName();
//				//反射获取枚举类
//				 Class<Enum> clazz = (Class<Enum>)Class.forName("com.zr.entity.Constant$"+simpleName);
//				 //获取所有枚举实例
//				 Enum[] enumConstants = clazz.getEnumConstants();
//				 //根据方法名获取方法
//				 Method getCode = clazz.getMethod("getDesc");
//				 for (Enum enum1 : enumConstants) {
//				 	 //得到枚举实例名
//					 String name2 = enum1.name();
//					 //执行枚举方法获得枚举实例对应的值
//					 Object invoke = getCode.invoke(enum1);
//					 System.out.println(name2+":"+invoke.toString());
//				 }
//			 }
		
		return null;
	}
	
	public static void main(String[] args) {
		IsInitEnum[] enumAttributeObject = EnumUtil.getEnumConstants(IsInitEnum.class);
		System.out.println(enumAttributeObject);
		HashMap<String, String> values = EnumUtil.getValues(IsInitEnum.class);

		HashMap<String, String> keyDescriptionMap = EnumUtil.getKeyDescriptionMap(IsInitEnum.class);

		System.out.println(keyDescriptionMap);
		
	}
	

}
