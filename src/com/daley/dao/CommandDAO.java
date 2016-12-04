package com.daley.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.daley.bean.Command;
import com.daley.bean.Message;
import com.daley.db.DBAccess;

/**
 * @author Daley
 * Date 2016-12-4
 * project_name MicroMessage
 * 与指令表对应的数据库操作类
 */
public class CommandDAO {
	public List<Command> queryCommandList(String name, String description) {
		List<Command> commandList = new ArrayList<Command>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			commandList = sqlSession.selectList("Command.queryCommandList",
					command);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
}
