package com.daley.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daley.service.MaintainService;

/**
 * @author Daley
 * Date 2016-11-30
 * project_name MicroMessage
 */

//µ¥ÌõÉ¾³ý¿ØÖÆ²ã
public class DeleteOneServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		MaintainService maintainService = new MaintainService();
		maintainService.deleteOne(id);
		request.getRequestDispatcher("/List.action").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
