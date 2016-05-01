package com.zcadmin.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T> {
	// 根据ID加载实体
	public T get(Class<T> entityClazz, Serializable id);

	// 根据一个字段加载实体类
	public T get(Class<T> entityClazz, String key, Object value);

	// 根据一个字段加载实体类List
	public List<T> getList(Class<T> entityClazz, String key, Object value);

	// 根据ID判断是否存在
	public boolean exist(Class<T> entityClazz, Serializable id);

	// 根据字段判断是否存在
	public boolean exist(Class<T> entityClazz, String key, Object value);

	// 多参数判断是否存在
	public boolean exist(String table, List<String> keys, Object... params);

	// 保存实体
	public Serializable save(T entity);

	// 更新实体
	public void update(T entity);

	// 删除实体
	public void delete(T entity);

	// 根据ID删除实体
	public void delete(Class<T> entityClazz, Serializable id);

	// 获取所有实体
	public List<T> findAll(Class<T> entityClazz);

	// 获取实体总数
	public long findCount(Class<T> entityClazz);

	// 不带参数查询总数
	public long findCount(String hql);

	// 带参数查询总数
	public long findCount(String hql, List<Object> values);

	// 根据HQL语句查询实体
	public List<T> find(String hql);

	// 根据带占位符参数HQL语句查询实体
	public List<T> find(String hql, Object... params);

	// 多参数查询实体
	public List<T> find(Class<T> entityClazz, List<String> keys,
			Object... params);

	// 多参数查询实体hql List<String> keys List<Object> values
	public List<T> execute(String hql, List<Object> values);

	//分页查询
	public List<T> findByPage(String hql, int pageNo, int pageSize);

	// 带参数分页查询
	public List<T> findByPage(String hql, int pageNo, int pageSize,
			List<Object> values);

	//执行无返回的sql
	public void sql(String sql);

	//执行sql获取单个结果
	public Object sqlQryUnique(String sql);

	//执行sql获取列表
	public Object sqlQryList(String sql);
	//sql count
	public long sqlCount(String sql);
}
