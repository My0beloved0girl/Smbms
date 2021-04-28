package cn.hfxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.service.impl.MenuServiceImpl;
import cn.hfxt.utils.PrintUtil;
import  cn.hfxt.utils.TransferArray;

public class FenPei extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		String[] menuid = request.getParameterValues("arrayid");
		System.out.println(userid);
		
		int[] toInt = TransferArray.StringToInt(menuid);
		int count = 0;
		if(menuid==null) {
			int deleFen = new MenuServiceImpl().deleFen(userid);
			System.out.println("deleFen:"+deleFen);
			PrintUtil.write(deleFen, response);
		} else {  
			int deleFen2 = new MenuServiceImpl().deleFen(userid);
			System.out.println("deleFen:"+deleFen2);
			for (int i = 0; i < toInt.length; i++) {
				System.out.println(toInt[i]);
				int yes = new MenuServiceImpl().addFen(userid, toInt[i]);	//循环增加数据
				if(yes > 0) {	
					count++;//如果添加成功++ 记录增加了几条数据
				}
			}
		}
		PrintUtil.write(count, response);
		
		
		out.flush();
		out.close();
	}

}
