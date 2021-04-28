<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
<script type="text/javascript" src="js/jquery.js"></script></head>
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
                <li id="active"><a href="Smbms_bill_Servlet">账单管理</a></li>
                <li><a href="Smbms_provider_page">供应商管理</a></li>
                <li><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="Smbms_bill_Update">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="providerId">订单编码：</label>
                    <input type="text" name="billCode" id="providerId" placeholder="${list.billCode}" value="${list.billCode}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="providerName">商品名称：</label>
                    <input type="text" name="productName" id="providerName" placeholder="${list.productName}" value="${list.productName}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="people">商品单位：</label>
                    <input type="text" name="productUnit" id="people" placeholder="${list.productUnit}" value="${list.productUnit}"/>
                    <span>*</span>

                </div>
                <div>
                    <label for="phone">商品数量：</label>
                    <input type="text" name="productCount" id="phone" placeholder="${list.productCount}" value="${list.productCount}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="address">总金额：</label>
                    <input type="text" name="totalPrice" id="address" placeholder="${list.totalPrice}" value="${list.totalPrice}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="fax">供应商：</label>
                    <input type="hidden" name="id" value="${list.id}">
                    <input type="hidden" id="hidepid" value="${list.providerId}">
                    <input type="hidden" id="hideisp" value="${list.isPayment}">
                <select name="providerId" id="fax" style="width: 272px;height: 33px;">
                    <option value="">--请选择--</option>
                    <c:forEach items="${sele}" var="seles">
                    <option value="${seles.id}">${seles.proName}</option>
                    </c:forEach>
                </select>
                <script type="text/javascript">
                $(function(){  
			        var zhi = $("#hidepid").val();  
			        $("select option").each(function(){  
			            if($(this).val()==zhi){  
			                $(this).attr("selected","selected");  
			            }  
			        });  
			        var dan = $("#hideisp").val(); 
			        if(1==dan){
					     $("#inc1").removeAttr("checked");
					     $("#inc0").attr("checked","checked");                            
					 }  
			    });  
                </script>
                    <span>*</span>
                </div>
                <div>
                    <label >是否付款：</label>
                    <input id="inc1" type="radio" name="isPayment" value="2" checked/>未付款
                    <input id="inc0" type="radio" name="isPayment" value="1"/>已付款
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.html">返回</a>-->
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="js/time.js"></script>

</body>
</html>