<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${APP_PATH }/css/Business_left.css" />
</head>
<body>
			<div class="card">
				<p class="card-text">
					<img src="${APP_PATH }/image/logo.svg" style="width: 100%;">
				</p>
				<p class="card-text">当前管理员：${business.user_name}</p>
				<p class="card-text">所在地址：${business.user_addr}</p>
			</div>
			<div id="control">
				<div class="All">
					<span>商家首页</span>
				</div>
				<div class="listGroup">
					<a href="${APP_PATH }/GoodsAdd.jsp"
						style="border-bottom: none;">商品添加</a> <a
						href="${pageContext.request.contextPath}/business/branchManager.do"
						style="border-bottom: none;">分店管理</a> <a
						href="${APP_PATH }/BranchAdd.jsp">分店添加</a>
				</div>
			</div>
</body>
</html>
<script type="text/javascript">
	$(".All").click(function(){
		location.href="${pageContext.request.contextPath}/business/indexBusiness.do";
	});
</script>