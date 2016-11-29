package com.daley.service;

import java.sql.SQLException;
import java.util.List;

import com.daley.bean.Message;
import com.daley.dao.MessageDao;

/**
 * @author Daley
 * Date 2016-11-28
 * project_name MicroMessage
 */
public class ListService {
	public List<Message> queryMessageList(String command,String description) throws ClassNotFoundException, SQLException{
		MessageDao messageDao=new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
}
