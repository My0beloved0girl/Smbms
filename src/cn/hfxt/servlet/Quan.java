package cn.hfxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.FenMenu;
import cn.hfxt.entity.Menu;
import cn.hfxt.entity.UserMenu;
import cn.hfxt.service.impl.MenuServiceImpl;
import cn.hfxt.utils.Layui;
import cn.hfxt.utils.PrintUtil;

public class Quan extends HttpServlet {

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
		if(request.getParameter("userid")!=null) {
			List<UserMenu> seleUserMenu = new MenuServiceImpl().seleUserMenu(Integer.parseInt(request.getParameter("userid")));
			PrintUtil.write(seleUserMenu, response);
		}else {
			
			  Layui<Menu> layui = new Layui<Menu>(); List<Menu> allMenu = new
			  MenuServiceImpl().AllMenu();
			  
			  layui.setCode(0); layui.setCount(allMenu.size()); layui.setMessage("");
			  layui.setData(allMenu);
			  
			  PrintUtil.write(layui, response);
			 
		}
		
		

		
		out.flush();
		out.close();
	}

}
