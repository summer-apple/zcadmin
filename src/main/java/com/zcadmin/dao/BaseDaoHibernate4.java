package com.zcadmin.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.io.Serializable;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BaseDaoHibernate4<T> implements BaseDao<T> {
	// DAO组件进行持久化操作底层依赖的SessionFactory组件
	// @Resource(name="sessionFactory")

	private SessionFactory sessionFactory;

	// 依赖注入SessionFactory所需的setter方法
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	// 根据ID加载实体
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	// 根据一个字段加载实体类
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, String key, Object value) {

		System.out.println(entityClazz.getSimpleName());

		String hql = "FROM " + entityClazz.getSimpleName() + " WHERE " + key
				+ "=?0";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter(0 + "", value);
		List<T> list = (List<T>) query.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 根据一个字段加载实体类List
	@SuppressWarnings("unchecked")
	public List<T> getList(Class<T> entityClazz, String key, Object value) {
		String hql = "FROM " + entityClazz.getSimpleName() + " WHERE " + key
				+ "=?0";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter(0 + "", value);
		List<T> list = (List<T>) query.list();
		return list;

	}

	// 根据ID判断是否存在
	@SuppressWarnings("unchecked")
	public boolean exist(Class<T> entityClazz, Serializable id) {
		T t = (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
		if (t != null) {
			return true;
		} else {
			return false;
		}
	}

	// 根据字段判断是否存在
	@SuppressWarnings("unchecked")
	public boolean exist(Class<T> entityClazz, String key, Object value) {

		String hql = "FROM " + entityClazz.getSimpleName() + " WHERE " + key
				+ "=?0";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter(0 + "", value);
		List<T> list = (List<T>) query.list();
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	// 多参数判断是否存在
	@SuppressWarnings("unchecked")
	public boolean exist(String table, List<String> keys, Object... params) {
		// 创建查询
		String hql = "FROM " + table + " WHERE ";

		for (int i = 0; i < keys.size(); i++) {
			if (i < keys.size() - 1) {
				hql = hql + keys.get(i) + "=?" + i + " and ";
			} else {
				hql = hql + keys.get(i) + "=?" + i;
			}
		}

		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}

		List<T> list = (List<T>) query.list();

		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 保存实体
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}

	// 更新实体
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	// 删除实体
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	// 根据ID删除实体
	public void delete(Class<T> entityClazz, Serializable id) {
		getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"delete " + entityClazz.getSimpleName()
								+ " en where en.id = ?0").setParameter("0", id)
				.executeUpdate();
	}

	// 获取所有实体
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	// 获取实体总数

	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		// 返回查询得到的实体总数
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	// 不带参数查询总数
	public long findCount(String hql) {

		// 创建查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数

		return (long) query.list().get(0);

	}

	// 带参数查询总数
	public long findCount(String hql, List<Object> values) {

		// 创建查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + "", values.get(i));
		}

		return (long) query.list().get(0);

	}

	// 根据HQL语句查询实体
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return (List<T>) getSessionFactory().getCurrentSession()
				.createQuery(hql).list();
	}

	// 根据带占位符参数HQL语句查询实体
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object... params) {
		// 创建查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}

	// 多参数查询实体
	@SuppressWarnings("unchecked")
	public List<T> find(Class<T> entityClazz, List<String> keys,
			Object... params) {
		// 创建查询
		String hql = "FROM " + entityClazz.getSimpleName() + " WHERE ";

		for (int i = 0; i < keys.size(); i++) {
			if (i < keys.size() - 1) {
				hql = hql + keys.get(i) + "=?" + i + " and ";
			} else {
				hql = hql + keys.get(i) + "=?" + i;
			}
		}

		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}

	// 多参数查询实体hql List<String> keys List<Object> values
	@SuppressWarnings("unchecked")
	public List<T> execute(String hql, List<Object> values) {
		// 创建查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + "", values.get(i));
		}
		return (List<T>) query.list();
	}

	// 分页查询
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql, int pageNo, int pageSize) {
		// 创建查询
		return getSessionFactory().getCurrentSession().createQuery(hql)
				// 执行分页
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	// 带参数分页查询
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql, int pageNo, int pageSize,
			List<Object> values) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0; i < values.size(); i++) {
			query.setParameter(i + "", values.get(i));
		}
		// 执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	// 执行无返回的sql
	public void sql(String sql) {
		getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.executeUpdate();
	}

	// 执行sql获取单个结果
	public Object sqlQryUnique(String sql) {
		return getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.uniqueResult();
	}

	// 执行sql获取列表
	public Object sqlQryList(String sql) {
		return getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.list();
	}
	//sql count
	public long sqlCount(String sql) {
		return getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.list().size();
	}
}
