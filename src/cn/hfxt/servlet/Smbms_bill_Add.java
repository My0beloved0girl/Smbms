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
//		��ȡ��ǰʱ��
		Timestamp dateNow=new Timestamp(System.currentTimeMillis());
		Date reDate=new Date(System.currentTimeMillis());
//		��������
		sb.setBillCode(request.getParameter("billCode"));//���ñ��
		sb.setProductName(request.getParameter("productName"));//��������
		sb.setProductUnit(request.getParameter("productUnit"));//���õ�λ
		sb.setProductCount(Double.parseDouble((request.getParameter("productCount"))));//���ü۸�
		sb.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));//��������
		sb.setIsPayment(Integer.parseInt(request.getParameter("isPayment")));//�����Ƿ񸶿�
		sb.setCreatedBy(1);//����
		sb.setCreationDate(reDate);//����ʱ��
		sb.setProviderId(Integer.parseInt(request.getParameter("providerId")));//���ó���
//		���سɹ����
		if(Smbms.inse(sb)>0){
			request.getRequestDispatcher("Smbms_bill_Servlet").forward(request, response);
		}
		out.flush();
		out.close();
	}

}
