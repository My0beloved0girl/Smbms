package cn.hfxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.smbms_provider;
import cn.hfxt.entity.smbms_provider_page;
import cn.hfxt.service.Smbms_provider_Service;
import cn.hfxt.service.impl.Smbms_provider_Service_Impl;

public class Smbms_provider_page extends HttpServlet {

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
		Smbms_provider_Service Sps=new Smbms_provider_Service_Impl();
		smbms_provider_page sppage=new smbms_provider_page();
		//获得当前页码
		String pageNo=request.getParameter("pageNo");
		//System.out.println(pageNo);
		//如果没有当前页码，那就默认为1
		if(pageNo==null){pageNo="1";}
		//设置当前页码
		sppage.setPageNo(Integer.parseInt(pageNo));
		sppage.setPageTotalCount(Sps.SeleCount());
		int begin=Integer.parseInt(pageNo);
		int size=9;
		List<smbms_provider> list=Sps.seleall(begin, size);
		
		sppage.setItems(list);
		request.setAttribute("pagelist", sppage);
		request.getRequestDispatcher("providerList.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}

}
