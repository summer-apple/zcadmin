package com.zcadmin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcadmin.dao.BaseDao;
import com.zcadmin.entity.OrderView;
import com.zcadmin.entity.Orders;
import com.zcadmin.entity.Project;



@Service
public class OrderService {

	@Autowired
	private BaseDao<Orders> dao;
	
	//查询
	public Map<String, Object> qryAll(int pageNo, int pageSize) {
		String hql = "FROM Orders ORDER BY id DESC";
		List<Orders> list = dao.findByPage(hql, pageNo, pageSize);
		
		
		long amount = dao.findCount("SELECT COUNT(*) " + hql);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		if (amount == 0) {
			map.put("amount", 0);
		} else if (amount <= pageSize) {
			map.put("amount", 1);
		}else if (amount%pageSize==0) {
			map.put("amount", amount/pageSize);
		} else {
			map.put("amount", amount / pageSize + 1);
		}
		return map;
	}
	
	
	//删除
	public void delete(int id ) {
		dao.delete(Orders.class, id);
	}
	
	//发货
	public void out(int id) {
		Orders o = dao.get(Orders.class, id);
		o.setOrderState("已发货");
		dao.update(o);
	}
	
}
