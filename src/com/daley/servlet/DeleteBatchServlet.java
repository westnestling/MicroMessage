package com.daley.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daley.service.MaintainService;

/**
 * ÅúÁ¿É¾³ý
 * @author Daley
 * Date 2016-12-1
 * project_name MicroMessage
 */
public class DeleteBatchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] ids=request.getParameterValues("ids");
		MaintainService maintainService=new MaintainService();
		maintainService.deleteBatch(ids);
		request.getRequestDispatcher("/List.action").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
