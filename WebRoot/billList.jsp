<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <style type="text/css">
   /* 	#sw{
   		width:50px;
   		height:35px;
   		background-color:#DCDCDC;
    } */
    </style>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
            <a href="exit">退出</a>
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
                   <!--  <li id="active"><a href="Smbms_bill_Servlet">账单管理</a></li>
                    <li><a href="Smbms_provider_page">供应商管理</a></li>
                    <li><a href="userList.jsp">用户管理</a></li>
                    <li><a href="password.jsp">密码修改</a></li>
                    <li><a href="login.jsp">退出系统</a></li> -->
                    <jsp:include page="/leftMenu.jsp"></jsp:include>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>账单管理页面</span>
            </div>
            <div class="search">
                <span>商品名称：</span>
                <input type="text" placeholder="请输入商品的名称"/>
                
                <span>供应商：</span>
                <select name="tigong" >
                    <option value="">--请选择--</option>
                    <c:forEach items="${sele}" var="seles">
                    <option value="${seles.id}">${seles.proName}</option>
                    </c:forEach>
                </select>

                <span>是否付款：</span>
                <select name="fukuan">
                    <option value="">--请选择--</option>
                    <option value="">已付款</option>
                    <option value="">未付款</option>
                </select>

                <input type="button" value="查询"/>
                <a href="Smbms_provider_list">添加订单</a>
            </div>
            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">账单编码</th>
                    <th width="20%">商品名称</th>
                    <th width="10%">供应商</th>
                    <th width="10%">账单金额</th>
                    <th width="10%">是否付款</th>
                    <th width="10%">创建时间</th>
                    <th width="30%">操作</th>
                </tr>
             <c:forEach items="${pagelist.items}" var="page">
                <tr id="${page.id}">
                    <td>${page.billCode}</td>
                    <td>${page.productName}</td>
                    <td>${page.proName}</td>
                    <td>${page.totalPrice}</td>
                    <c:if test="${page.isPayment==1}"><td>已付款</td></c:if>
                  	<c:if test="${page.isPayment==2}"><td>未付款</td></c:if>
                    <td>${page.creationDate}</td>
                    <td>
                        <a href="billView.html"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="Smbms_bill_Upda?id1=${page.id}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="javascript:void(0);" class="removeBill" onclick="del(${page.id});"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
              </c:forEach>
            </table>
            <!-- 分页 -->
            <div align="center" style="position:absolute;left:600px;bottom: 126px;">
	            <input id="sw" type="button" value="首页" onclick="location.href='Smbms_bill_Servlet'"/>
	            <input id="up" type="button" value="上一页" onclick="up();"/>&emsp;
	            <span>第<input type="text" id="pageNo" style="width: 15px;text-align: center;" value="${pagelist.pageNo}"/>页</span>
<%-- <span id="span"><a href="Smbms_bill_Servlet?pageNo=${pagelist.pageNo-1}">${pagelist.pageNo-1}</a><a href="Smbms_bill_Servlet?pageNo=${pagelist.pageNo}">${pagelist.pageNo}</a><a href="Smbms_bill_Servlet?pageNo=${pagelist.pageNo+1}">${pagelist.pageNo+1}</a></span>--%>
	            <input id="down" type="button" value="下一页" onclick="down();"/>
	            <input id="sw" type="button" value="尾页" onclick="location.href='Smbms_bill_Servlet?pageNo=${pagelist.pageTotal}'"/>
	            <span>共${pagelist.pageTotal}页</span>
	            <input type="hidden" id="pageTotal" value="${pagelist.pageTotal}"/>
	            <div style="width: 50px;display: inline-block;"></div>
	            <span>跳转至</span><input type="text" id="tiao" style="width: 20px;text-align: center;" />页<input type="button" onclick="go()" value="GO" />
            </div>
        </div>
    </section>
<script type="text/javascript">
var index=1;
/* 下一页 */
	function down(){
	var max=$("#pageTotal").val();
	index=$("#pageNo").val();
		if(index==max){
			alert("没有下一页咯！");
			return;
		}
		index++;
		location.href="Smbms_bill_Servlet?pageNo="+index+"";
		$("#pageNo").val(index);
	}
/* 上一页 */
	function up(){
	var max=$("#pageTotal").val();
	index=$("#pageNo").val();
		if(index==1){
			alert("没有上一页咯！");
			return;
		}
		index--;
		location.href="Smbms_bill_Servlet?pageNo="+index+"";
		$("#pageNo").val(index);
	}
/* 跳转到指定页面 */
	function go(){
	var max=$("#pageTotal").val();
	var regu = /^[0-9]+\.?[0-9]*$/;
		index=$("#tiao").val();
		if(index!=""){
			if(!regu.test(index)){
				alert("请输入正确页码！！！");
				$("#tiao").val("");
				return;
			}
			if(index==$("#pageNo").val()){
				alert("当前页就是第"+index+"页，无需跳转");
				$("#tiao").val("");
				return;
			}
			if(max<index){
				alert("总共只有"+max+"页!");
				$("#tiao").val("");
				return;
			}
			if(0>=index){
				alert("输入的页码不正确!");
				$("#tiao").val("");
				return;
			}
			location.href="Smbms_bill_Servlet?pageNo="+index+"";
			$("#pageNo").val(index);
		}else{
			alert("请输入指定页码！");
		};
	};
</script>
<!-- 删除 -->
<script type="text/javascript">
	function del(id){
	var bol=confirm("确认删除吗？");
		if(bol){
			$.post("Smbms_bill_del",{"id":id},function(result){
				if(result=="1"){alert("删除成功！");window.location.href="Smbms_bill_Servlet";}
				$("#"+id).remove();
			});
		};
	};
	
</script>
    <footer class="footer">
        版权归北大青鸟
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>