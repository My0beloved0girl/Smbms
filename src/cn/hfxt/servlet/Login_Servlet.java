package cn.hfxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.Menu;
import cn.hfxt.entity.smbms_user;
import cn.hfxt.service.Login_Service;
import cn.hfxt.service.impl.Login_Service_Impl;
import cn.hfxt.service.impl.MenuServiceImpl;
import cn.hfxt.utils.SecurityUtils;

public class Login_Servlet extends HttpServlet {

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
		
		Login_Service loginservice=new Login_Service_Impl();
		smbms_user smbmsuser=loginservice.login(request.getParameter("username"), request.getParameter("password"));
		System.out.println(SecurityUtils.md5Hex(request.getParameter("password")));
		if(smbmsuser!=null){
//			查询用户对应的菜单权限
			List<Menu> seleMenu = new MenuServiceImpl().seleMenu(smbmsuser.getId());
//			设置cookie
			Cookie cookie=new Cookie("username", smbmsuser.getUserCode());
			request.getSession().setAttribute("user", smbmsuser);
			System.out.println(smbmsuser);
			//cookie.setMaxAge(20*30*30);//最大有效时间
			response.addCookie(cookie);
			request.getSession().setAttribute("menuList", seleMenu);
			request.getSession().setAttribute("username", smbmsuser.getUserCode());
			request.getSession().setAttribute("password", smbmsuser.getUserPassword());
			response.sendRedirect("welcome.jsp"); 
//			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			request.setAttribute("X", "账号或密码错误");
			request.getRequestDispatcher("login.jsp?is="+request.getParameter("username")).forward(request, response);
		}
		
		out.flush();
		out.close();
	}

}
