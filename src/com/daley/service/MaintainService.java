package com.daley.service;

import com.daley.dao.MessageDao;

/**
 * @author Daley
 * Date 2016-11-30
 * project_name MicroMessage
 */
//维护相关的业务
public class MaintainService {
	//单条删除
	public void deleteOne(String id){
		if(id!=null&&!"".equals(id.trim())){
			MessageDao messageDao=new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
	}
	}
}
