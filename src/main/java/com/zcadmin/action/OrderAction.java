package com.zcadmin.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcadmin.entity.Orders;
import com.zcadmin.service.OrderService;



@Controller
@RequestMapping("/order")
public class OrderAction {
	
	@Autowired 
	private OrderService service;
	
	Logger logger = Logger.getLogger(OrderAction.class);
	
	
	@RequestMapping("/qry-all")
	@ResponseBody
	public Map<String, Object> qryAll(int pageNo,int pageSize){
		return service.qryAll(pageNo, pageSize);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete(int id){
		service.delete(id);
		return true;
	}
	
	@RequestMapping("/out")
	public void out(int id){
		service.out(id);
	}
	
	
}
