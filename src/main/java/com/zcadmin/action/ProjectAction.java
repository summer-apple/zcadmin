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

import com.zcadmin.entity.Project;
import com.zcadmin.service.ProjectService;



@Controller
@RequestMapping("/project")
public class ProjectAction {
	
	@Autowired 
	private ProjectService service;
	
	Logger logger = Logger.getLogger(ProjectAction.class);
	
	
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

	
	@RequestMapping("/check")
	@ResponseBody
	public boolean check(int id,int state){
		service.check(id, state);
		return true;
	}
	
	
}
