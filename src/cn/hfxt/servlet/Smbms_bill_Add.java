package cn.hfxt.servlet;
import java.sql.Timestamp;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.smbms_bill;
import cn.hfxt.service.Smbms_Service;
import cn.hfxt.service.impl.Smbms_Service_Impl;

public class Smbms_bill_Add extends HttpServlet {

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
		Smbms_Service Smbms=new Smbms_Service_Impl();
		smbms_bill sb=new smbms_bill();
//		获取当前时间
		Timestamp dateNow=new Timestamp(System.currentTimeMillis());
		Date reDate=new Date(System.currentTimeMillis());
//		设置数据
		sb.setBillCode(request.getParameter("billCode"));//设置编号
		sb.setProductName(request.getParameter("productName"));//设置名称
		sb.setProductUnit(request.getParameter("productUnit"));//设置单位
		sb.setProductCount(Double.parseDouble((request.getParameter("productCount"))));//设置价格
		sb.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));//设置总数
		sb.setIsPayment(Integer.parseInt(request.getParameter("isPayment")));//设置是否付款
		sb.setCreatedBy(1);//设置
		sb.setCreationDate(reDate);//设置时间
		sb.setProviderId(Integer.parseInt(request.getParameter("providerId")));//设置厂商
//		返回成功与否
		if(Smbms.inse(sb)>0){
			request.getRequestDispatcher("Smbms_bill_Servlet").forward(request, response);
		}
		out.flush();
		out.close();
	}

}
