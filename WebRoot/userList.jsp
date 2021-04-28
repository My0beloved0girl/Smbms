<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="<%=basePath %>/css/public.css"/>
    <link rel="stylesheet" href="<%=basePath %>/css/style.css"/>
    <link rel="stylesheet" href="<%=basePath %>/layui/css/layui.css">
	<link rel="stylesheet" href="<%=basePath %>/layui/lay-module/layui_ext/dtree/dtree.css">
	<link rel="stylesheet" href="<%=basePath %>/layui/lay-module/layui_ext/dtree/font/dtreefont.css">
	<script type="text/javascript" src="<%=basePath %>/layui/layui.js"></script>
	<script type="text/javascript" src="<%=basePath %>/layui/lay-module/layui_ext/dtree/dtree.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
            <a href="Exit">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
            <nav>
                <ul class="list">
                   <!--  <li><a href="Smbms_bill_Servlet">账单管理</a></li>
                    <li><a href="Smbms_provider_page">供应商管理</a></li>
                    <li id="active"><a href="userList.jsp">用户管理</a></li>
                    <li><a href="password.jsp">密码修改</a></li>
                    <li><a href="login.jsp">退出系统</a></li> -->
                    <jsp:include page="/leftMenu.jsp"></jsp:include>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名"/>
                <input type="button" value="查询"/>
                <a href="userAdd.jsp">添加用户</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach var="li" items="${list}">
                <tr >
                    <th width="10%">${li.id}</th>
                    <th width="20%">${li.userName}</th>
                    <th width="10%">${li.gender}</th>
                    <th width="10%">${li.birthday}</th>
                    <th width="10%">${li.phone}</th>
                    <th width="10%">${li.userrole}</th>
                    <th width="30%"><button type="button" onclick="Fen('${li.id}')" lay-event="fenFunc" class="layui-btn layui-btn-greed">分配权限</button></th>
                </tr>
                </c:forEach>
            </table>
            <c:if test="${user.userRole>1}">
			<input type="button" chong="${chen}" value="重置密码" onclick="demo()" id="chong">
			</c:if>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
        版权归北大青鸟
    </footer>
    
<h1></h1>
<script src="js/quan.js"></script>
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
<script>
		/*  function login() {
  		 var jo=null;
			$.getJSON("user",{"action":"cha"},function(response) {
  				var obj= response;
  			 	for(var i=0;i<obj.length;i++){
  					var num=$("<tr></tr>").append("<td>"+(i+1)+"</td>")
  					.append("<td>"+obj[i].username+"</td>")
  					.append("<td>"+(obj[i].gender==1?"男":"女")+"</td>")
  					.append("<td>"+obj[i].genderby+"</td>")
  					.append("<td>"+obj[i].phone+"</td>")
  					.append("<td>"+obj[i].userrole+"</td>")
  					.append("<td><a href='user?action=sele&id="+obj[i].id+"'><img src='img/read.png' alt='查看' title='查看'/></a><a href='userUpdate.jsp'><img src='img/xiugai.png' alt='修改' title='修改'/></a><a href=''#' class='removeUser'><img src='img/schu.png' alt='删除' title='删除'/></a>");
  					$("table").append(num);
  				} 
		}); 
  		 	 
   		 }
  		login();
	function demo(){
		location.href="http://localhost:8080/Supermarket/user?action=up";
	}
	if($("#chong")>0){
		if($("#chong").attr("chong")!=""){
		alert("密码已经更改，请重新登录")
		alert($("#chong").attr("chong"));
		location.href="http://localhost:8080/Supermarket/login.jsp";
		}
	}
	
	 */
	
</script>
</body>
<!-- 分配权限 -->
	<div style="height: 400px;overflow: auto;display: none;" id="fenpei" >
	  <ul id="demoTree" class="dtree" data-id="0"></ul>
	</div>
</html>