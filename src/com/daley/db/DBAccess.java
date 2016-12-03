package com.daley.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Daley Date 2016-11-29 project_name MicroMessage
 */
public class DBAccess {
	public SqlSession getSqlSession() {
		// 通过配置文件获取数据库连接信息
		try {
			Reader reader = Resources
					.getResourceAsReader("com/daley/config/Configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			return sqlSession;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
