<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%> 
<html>
<head>
<meta charset="UTF-8">
<link href="${APP_PATH }/css/head.css" rel="stylesheet" type="text/css" />
		<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>	
</head>
<body>
	<div id="head">
		<div style="float:left">
		<div style="float:left">
		<ul class="logo">
			<li><img src="${pageContext.request.contextPath}/image/logo.svg" width="40" height="40"
				class="logo_s" alt=""></li>
			<li><a class="logotext" href="${APP_PATH }/indexCustom.jsp">&nbsp;STARBUCKS </a></li>
		</ul>
		</div>
		<div style="float:right">
		<ul class="list_menu">
			<li><a href="${pageContext.request.contextPath}/branch.do">门店</a></li>
			<li><a href="${pageContext.request.contextPath}/menu.do">菜单</a></li>
			<li><a href="#">专星送</a></li>
		</ul></div></div>
		<div style="float:right">
		<ul class="menu_right">
			<li><span
				style="color: rgba(0, 0, 0, .3); cursor: default"><c:if
						test="${custom.user_name!=null}">
								Hi,&nbsp${custom.user_name }
							</c:if><c:if test="${custom.user_name==null}">
								欢迎来星巴克
							</c:if>
			</span></li>
			<li><c:if test="${custom.user_name!=null}">
					<a href="${pageContext.request.contextPath}/Logout.do">注销 </a>
				</c:if><c:if test="${custom.user_name==null}">
					<a href="${pageContext.request.contextPath}/Login.jsp">去登录 </a>
				</c:if></li>
			<li><c:if test="${custom.user_name==null}">
					<a href="${pageContext.request.contextPath}/Register.jsp">去注册 </a>
				</c:if> <c:if test="${custom.user_name!=null}">
					<a href="${pageContext.request.contextPath}/custom/Cart.do">
						购物车<span></span>
					</a>
				</c:if></li>
			<li class="bz3"><c:if test="${custom.user_name!=null}">
					<a> 
						我的订单
						<span class="jt"></span>
					</a>
					<ul class="bz4">
						<li>${custom.user_name}</li>
						<li>
							<a href="${pageContext.request.contextPath}/custom/orderToBePaid.do">
								未支付
							</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/custom/orderPaid.do">
								已支付
							</a>
						</li>
					</ul>
				</c:if></li>
		</ul>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	let custom_name="${custom.user_name}";
	$(document).ready(function(){
			$(".bz4").hide();
		$(".bz3").click(function(){
			if($(".bz4").css('display')=='none'){
				$(".bz4").fadeIn();
			}else{
				$(".bz4").fadeOut();
			}
		});
	});
</script>