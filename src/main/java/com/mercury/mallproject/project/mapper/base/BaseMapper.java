package com.mercury.mallproject.project.mapper.base;

import java.util.List;
import java.util.Map;

/**
 * BaseMapper(继承时需要在mapper里有相应语句，主要针对分页查询、批量操作)
 */
public interface BaseMapper<T> {

	void saveBatch(List<T> list);
	
	int deleteBatch(Object[] id);

	List<T> queryList(Map<String, Object> map);

	List<T> getList(Map<String, Object> map);
	
	List<T> queryList(Object id);
	
	int queryTotal(Map<String, Object> map);

	int getCount(Map<String, Object> map);

	int queryTotal();
}
