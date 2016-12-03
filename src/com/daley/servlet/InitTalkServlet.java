package com.daley.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Daley Date 2016-12-1 project_name MicroMessage
 */
public class InitTalkServlet extends HttpServlet {

	/**
	 * 对话页的初始化控制
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		request.getRequestDispatcher("/WEB-INF/jsp/front/talk.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
