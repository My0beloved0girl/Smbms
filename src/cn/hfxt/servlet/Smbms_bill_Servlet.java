 package cn.hfxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.smbms_bill_page;
import cn.hfxt.entity.smbms_zd;
import cn.hfxt.service.Smbms_Service;
import cn.hfxt.service.Smbms_provider_Service;
import cn.hfxt.service.impl.Smbms_Service_Impl;
import cn.hfxt.service.impl.Smbms_provider_Service_Impl;

public class Smbms_bill_Servlet extends HttpServlet {

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
		
		Smbms_Service smbms=new Smbms_Service_Impl();
		smbms_bill_page smbms_page=new smbms_bill_page();
		Smbms_provider_Service sps=new Smbms_provider_Service_Impl();
		//获得当前页码
		String pageNo=request.getParameter("pageNo");
		//System.out.println(pageNo);
		//如果没有当前页码，那就默认为1
		if(pageNo==null){pageNo="1";}
		smbms_page.setPageNo(Integer.parseInt(pageNo));
		smbms_page.setPageTotalCount(smbms.SeleCount());
		int begin = Integer.parseInt(pageNo);
		int size = 6;
		List<smbms_zd> list = smbms.SeleAll(begin, size);
		
		smbms_page.setItems(list);
		request.setAttribute("pagelist", smbms_page);
		request.setAttribute("sele", sps.sele());
		request.getRequestDispatcher("billList.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}

}
