<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta charset="UTF-8">
<title>星巴克 | 添加门店</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/branchadd.css" />
	</head>
	<body>
		<%@ include file="Business_head.jsp"%>
		<div id="body">
			<div class="b_left">
				<%@ include file="Business_left.jsp"%>
			</div>
			<div class="b_right">
				<div class="Mheader">添加分店</div>
				<div class="Mbody">
				<form action="${pageContext.request.contextPath}/business/BranchAdd.do" method="post">
						<div class="list" style="height: 38px;">
						<label for="branchname" style="height: 38px;">分店名称：</label>
						<div class="texta" style="38px">
							<input type="hidden" name="id" value="1">
							<input type="text" name="branchname" id="branchname" placeholder="请输入分店名称" />
						</div>
					</div>
	
					<div class="list" style="height: 38px;">
						<label for="branchaddr" style="height: 38px;">分店地址：</label>
						<div class="texta" style="38px">
							<input type="text" name="branchaddr" id="branchaddr" placeholder="请输入分店地址"/>
						</div>
					</div>
					<div class="list" style="height: 38px;">
						<label for="branchphone" style="height: 38px;">分店电话：</label>
						<div class="texta" style="38px">
							<input type="text" name="branchphone" id="branchphone" placeholder="请输入分店电话"/>
						</div>
					</div>
					<div class="list" style="height: 38px;margin-bottom: 0;">
						<div>
							<button type="submit" class="btn">添加分店</button>
						</div>
					</div>
				</form>
				</div>
			</div>
		</div>

	</body>
</html>