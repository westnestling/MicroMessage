package com.daley.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.daley.bean.Message;
import com.daley.db.DBAccess;

/**
 * @author Daley Date 2016-11-28 project_name MicroMessage
 */
public class MessageDao {

	/*
	 * public List<Message> queryMessageList(String command,String description)
	 * throws ClassNotFoundException, SQLException{
	 * Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * Connection conn = DriverManager.getConnection(
	 * "jdbc:mysql://127.0.0.1:3306/mybatis", "root", "kyegickka");
	 * StringBuilder sql = new StringBuilder(
	 * "select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
	 * List<String> paramList = new ArrayList<String>();
	 * 
	 * if (command != null && !"".equals(command.trim())) {
	 * sql.append(" and COMMAND=?"); paramList.add(command); } if (description
	 * != null && !"".equals(description.trim())) {
	 * sql.append(" and DESCRIPTION like '%' ? '%'");
	 * paramList.add(description); } PreparedStatement statement =
	 * conn.prepareStatement(sql.toString()); for (int i = 0; i <
	 * paramList.size(); i++) { statement.setString(1 + i, paramList.get(i)); }
	 * 
	 * ResultSet rs = statement.executeQuery(); List<Message> messageList = new
	 * ArrayList<Message>(); while (rs.next()) { Message message = new
	 * Message(); messageList.add(message); message.setId(rs.getString("ID"));
	 * message.setCommand(rs.getString("COMMAND"));
	 * message.setContent(rs.getString("CONTENT"));
	 * message.setDescription(rs.getString("DESCRIPTION")); } return
	 * messageList; }
	 */
	public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList=new ArrayList<Message>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message=new Message();
			message.setCommand(command);
			message.setDescription(description);
			messageList=sqlSession.selectList("Message.queryMessageList",message);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
			sqlSession.close();
			}
		}
		return messageList;
	}
	//单条删除
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();  //对数据库操作需要提交事务

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null){
			sqlSession.close();
			}
		}
	}
}
