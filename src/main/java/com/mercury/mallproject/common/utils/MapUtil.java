package com.mercury.mallproject.common.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MapUtil {

	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return map == null || map.isEmpty();
	}
	
	public static <K, V> Map<K, V> convert2Map(Collection<V> source, Function<V, K> function) {
		if (CollectionUtils.isEmpty(source)) {
			return new HashMap<K, V>();
		}
		Map<K, V> map = new HashMap<K, V>();
		for (V v : source) {
			K k = function.apply(v);
			map.put(k, v);
		}
		return map;
	}
	
	public static <T, K, V> Map<K, V> convert2Map(Collection<T> source, Function<T, K> kFunction, Function<T, V> vfunction) {
		if (CollectionUtils.isEmpty(source)) {
			return Maps.newHashMap();
		}
		Map<K, V> map = new HashMap<K, V>();
		for (T t : source) {
			K k = kFunction.apply(t);
			V v= vfunction.apply(t);
			map.put(k, v);
		}
		return map;
	}
	
	public static <K,V> Map<K,Collection<V>> group(Collection<V> source, Function<V, K> function) {
		if (CollectionUtils.isEmpty(source)) {
			return Maps.newHashMap();
		}
		Map<K, Collection<V>> map = new HashMap<K, Collection<V>>();
		for (V v : source) {
			K k = function.apply(v);
			Collection<V> collection = map.get(k);
			if(CollectionUtils.isEmpty(collection)) {
				collection = Lists.newArrayList();
				map.put(k, collection);
			}
			collection.add(v);
		}
		return map;
	}
	
	public static <K,V> Map<K,List<V>> group2(Collection<V> source, Function<V, K> function) {
		if (CollectionUtils.isEmpty(source)) {
			return Maps.newHashMap();
		}
		Map<K, List<V>> map = new HashMap<K, List<V>>();
		for (V v : source) {
			K k = function.apply(v);
			List<V> collection = map.get(k);
			if(CollectionUtils.isEmpty(collection)) {
				collection = Lists.newArrayList();
				map.put(k, collection);
			}
			collection.add(v);
		}
		return map;
	}
	
	public static <K,V> Map<K,List<V>> group2LinkedHashMap(Collection<V> source, Function<V, K> function) {
		if (CollectionUtils.isEmpty(source)) {
			return java.util.Collections.<K,List<V>>emptyMap();
		}
		Map<K, List<V>> map = new LinkedHashMap<K, List<V>>();
		for (V v : source) {
			K k = function.apply(v);
			if (k == null) {
				continue;
			}
			List<V> collection = map.get(k);
			if(CollectionUtils.isEmpty(collection)) {
				collection = Lists.newArrayList();
				map.put(k, collection);
			}
			collection.add(v);
		}
		return map;
	}
	
	public static <T,K,V> Map<K,List<V>> group2(Collection<T> source, Function<T, K> kFunction, Function<T, V> vFunction) {
		if (CollectionUtils.isEmpty(source)) {
			return Maps.newHashMap();
		}
		Map<K, List<V>> map = new HashMap<K, List<V>>();
		for (T t : source) {
			K k = kFunction.apply(t);
			List<V> collection = map.get(k);
			if(CollectionUtils.isEmpty(collection)) {
				collection = Lists.newArrayList();
				map.put(k, collection);
			}
			collection.add(vFunction.apply(t));
		}
		return map;
	}
	
	public static <T,K,V> Map<K,List<V>> group2LinkedHashMap(Collection<T> source, Function<T, K> kFunction, Function<T, V> vFunction) {
		if (CollectionUtils.isEmpty(source)) {
			return Maps.newHashMap();
		}
		Map<K, List<V>> map = new LinkedHashMap<K, List<V>>();
		for (T t : source) {
			K k = kFunction.apply(t);
			List<V> collection = map.get(k);
			if(CollectionUtils.isEmpty(collection)) {
				collection = Lists.newArrayList();
				map.put(k, collection);
			}
			collection.add(vFunction.apply(t));
		}
		return map;
	}
	
	public static <T,K,V> Map<K,Collection<V>> group(Collection<T> source, Function<T, K> kFunction, Function<T, V> vFunction) {
		if (CollectionUtils.isEmpty(source)) {
			return Maps.newHashMap();
		}
		Map<K, Collection<V>> map = new HashMap<K, Collection<V>>();
		for (T t : source) {
			K k = kFunction.apply(t);
			Collection<V> collection = map.get(k);
			if(CollectionUtils.isEmpty(collection)) {
				collection = Lists.newArrayList();
				map.put(k, collection);
			}
			collection.add(vFunction.apply(t));
		}
		return map;
	}
}
