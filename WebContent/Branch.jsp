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
<title>星巴克|门店</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/branch.css" />
</head>
<body><%@ include file="head.jsp"%>
		<div id="container">
			
			<div id="left_d">
				<div class="All">
					<span>所有门店</span>
				</div>
				<div class="ByArea">
					<div class="title">
						<span>按地区查询</span>
					</div>
					<input type="search" id="byArea" placeholder="请输入查询地区" />
					<button type="button" id="byArea_sub">查询</button>
				</div>
			</div>
			<div id="right_d">
				<div class="cardHeader">${area }线下分店</div>
				<div class="cardBody">
					<table class="T_body">
						<thead class="T_body_head">
							<tr>
								<th style="width: 44.8px;height: 49.6px;">id</th>
								<th style="width: 209.6px;height: 49.6px;">分店名称</th>
								<th style="width: 507.2px;height: 49.6px;">分店地址</th>
								<th>联系方式</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${size==0}">
								<div style="width:904px;position:absolute;top:250px;" class="info">
									<h2 style="text-align:center;color:red">暂无该地分店信息</h2>
								</div>
							</c:if>
							<c:forEach items="${branch_list }" var="branch">
							<tr>
								<th style="width: 44.8px;height: 44.8px;">${branch.branch_id }</th>
								<td style="width: 209.6px;height: 44.8px;">${branch.branch_name }</td>
								<td style="width: 507.2px;height: 44.8px;">${branch.branch_addr }</td>
								<td style="width: 99.2px;height: 44.8px;">${branch.phone }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		$("#byArea_sub").click(function(){
			let area = $("#byArea").val();
			area==""?alert("请输入查询地点"):location.href="${pageContext.request.contextPath}/branchByArea.do?area="+area;
		});
		$(".All").click(function(){
			location.href="${pageContext.request.contextPath}/branch.do";
		});
	});
</script>
