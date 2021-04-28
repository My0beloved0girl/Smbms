<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="<%=basePath %>/layui/css/layui.css">
	<link rel="stylesheet" href="<%=basePath %>/layui/lay-module/layui_ext/dtree/dtree.css">
	<link rel="stylesheet" href="<%=basePath %>/layui/lay-module/layui_ext/dtree/font/dtreefont.css">
	<script type="text/javascript" src="<%=basePath %>/layui/layui.js"></script>
	<script type="text/javascript" src="<%=basePath %>/layui/treeTable.js"></script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b">${cookie.username.value}</span> , 欢迎你！</p>
        <a href="Exit">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
               <!--  <li ><a href="Smbms_bill_Servlet">账单管理</a></li>
                <li><a href="Smbms_provider_page">供应商管理</a></li>
                <li><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="exit">退出系统</a></li> -->
                <%-- <c:forEach var="menu" items="${menuList}">
                   	<li><a href="${menu.murl}">${menu.mname}</a></li>
                </c:forEach> --%>
                <jsp:include page="/leftMenu.jsp"></jsp:include>
            </ul>
        </nav>
    </div>
    <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>权限管理页面</span>
            </div>
            <div class="search">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名"/>
                <input type="button" value="查询"/>
                <a href="userAdd.jsp">添加用户</a>
            </div>
            <div id="btn" style="display: none;">
            <!--用户-->
             <c:forEach var="anniu" items="${an}">
            	${anniu.mbtn}
            </c:forEach>
            </div>
            <table class="layui-hide" id="test" lay-filter="test"></table>
           
            <c:if test="${user.userRole>1}">
			<input type="button" chong="${chen}" value="重置密码" onclick="demo()" id="chong">
			</c:if>
        </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="js/time.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/Allquan.js"></script>
</body>
</html>