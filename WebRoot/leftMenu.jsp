<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:forEach var="menu" items="${sessionScope.menuList}">
	<c:if test="${menu.mtype==1}">
		<li><a href="${menu.murl}">${menu.mname}</a></li>
	</c:if>
</c:forEach>

