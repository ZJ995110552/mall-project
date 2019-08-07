package com.mercury.mallproject.common.utils;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

public class SplitorUtil {

	public static <T> List<T>[] split(List<T> values, int size) {
		return split(values, size, null);
	}

	public static <T> List<T>[] split(List<T> values, int size, Predicate<T> predicate) {
		List<List<T>> splitValues = Lists.<List<T>>newArrayList();
		if (CollectionUtils.isNotEmpty(values)) {
			int i = 0;
			List<T> temp = Lists.<T>newArrayList();
			for (T t : values) {
				if (predicate != null) {
					if (predicate.apply(t)) {
						i++;
						temp.add(t);
					}
				} else {
					i++;
					temp.add(t);
				}
				if (i == size) {
					splitValues.add(temp);
					temp = Lists.<T>newArrayList();
					i = 0;
				}
			}
			if (CollectionUtils.isNotEmpty(temp)) {
				splitValues.add(temp);
			}
		}
		values.clear();
		return (List<T>[]) splitValues.toArray(new List<?>[0]);
	}

	public static void main(String[] args) {
		List<Long> test = Lists.newArrayList();
		for (long i = 1; i <= 6443; i++) {
			test.add(i);
		}
		Collection<Long>[] split = SplitorUtil.split(test, 50);
		System.out.println(split.length);
	}

}
