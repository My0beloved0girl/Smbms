package cn.hfxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.smbms_bill;
import cn.hfxt.service.Smbms_Service;
import cn.hfxt.service.Smbms_provider_Service;
import cn.hfxt.service.impl.Smbms_Service_Impl;
import cn.hfxt.service.impl.Smbms_provider_Service_Impl;

public class Smbms_bill_Upda extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		修改回显数据
		Smbms_Service smbms=new Smbms_Service_Impl();
		int id=Integer.parseInt(request.getParameter("id1"));
		List<smbms_bill> list=smbms.seleid(id);
		smbms_bill hh=list.get(0);
		Smbms_provider_Service sps=new Smbms_provider_Service_Impl();
		request.setAttribute("sele", sps.sele());
		request.setAttribute("list", list.get(0));
		request.getRequestDispatcher("billUpdate.jsp").forward(request, response);
		out.flush();
		out.close();
	}

}
