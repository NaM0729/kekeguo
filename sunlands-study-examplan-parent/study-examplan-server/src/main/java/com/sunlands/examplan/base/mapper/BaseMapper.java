package com.sunlands.examplan.base.mapper;

import java.util.List;
import java.util.Map;


/**
 * 基类mapper接口
 * @Class Name BaseMapper
 * @author 周宇
 * @Create In 2018年3月15日9:45:22
 * @param <T>
 */
public abstract interface BaseMapper<T> {
	
	public abstract int insert(T paramT);

	public abstract T get(String id);
	
	public abstract T get(T entity);
	
	public abstract int update(T paramT);
	
	public abstract int delete(T paramT);

	public abstract int delete(String id);

	public abstract int deleteBatchIds(List<String> stringIds);

	public abstract List<T> findList(T entity);
	
	public abstract List<T> findList(Map<String, Object> params);
	
	public abstract List<T> findAllList(T entity);

	public abstract Integer queryTotal();
}
