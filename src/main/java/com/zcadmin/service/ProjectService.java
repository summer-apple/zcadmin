package com.zcadmin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcadmin.dao.BaseDao;
import com.zcadmin.entity.Project;
import com.zcadmin.entity.User;



@Service
public class ProjectService {

	@Autowired
	private BaseDao<Project> dao;
	
	//查询
	public Map<String, Object> qryAll(int pageNo, int pageSize) {
		String hql = "FROM Project ORDER BY id DESC";
		List<Project> list = dao.findByPage(hql, pageNo, pageSize);
		
		for (Project project : list) {
			project.setProjectContent(null);
			project.setProjectDescription(null);
		}

		
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
	
	//审核
	public void check(int id,int state) {
		Project p = dao.get(Project.class, id);
		if (state == 0) {//通过
			p.setProjectState("审核通过");
		}else {
			p.setProjectState("审核不通过");
		}
		
		dao.update(p);
	}
	
	//删除
	public void delete(int id ) {
		dao.delete(Project.class, id);
	}
	
}
