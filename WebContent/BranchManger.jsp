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
<title>星巴克 | 门店管理</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/branchManger.css" />
	</head>
	<body>
		<%@ include file="Business_head.jsp"%>
		<div id="body">
			<div class="b_left">
				<%@ include file="Business_left.jsp"%>
			</div>
			<div class="b_right">
				<div class="Mheader">分店管理</div>
				<div class="Mbody">
						<table class="table">
						<thead>
							<tr>
								<th style="width: 43.2px;height: 49.6px;">id</th>
								<th style="width: 187.2px;height: 49.6px;">分店名称</th>
								<th style="width: 454.4px;height: 49.6px;">分店地址</th>
								<th style="width: 93.6px;height: 49.6px;">联系方式</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${branch_list }" var="b">
							<tr>
								<th>${b.branch_id }</th>
								<td>${b.branch_name }</td>
								<td>${b.branch_addr }</td>
								<td>${b.phone }</td>
								<td><a href="${pageContext.request.contextPath}/business/Branch_details.do?BranchId=${b.branch_id }" role="button" class="xg">修改</a></td>
							</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>

	</body>
</html>