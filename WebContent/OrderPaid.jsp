<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta charset="UTF-8">
<title>星巴克 | 已支付订单</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/orderPaid.css" />
	</head>
	<body>
	<%@ include file="head.jsp"%>
		<div id="container">
			<div id="body">
				<div class="info">
					${info }
				</div>
				<div class="head">
					已支付订单(共${size }件)
				</div>
				<div class="body">
					<table class="table">
						<thead>
							<tr>
								<th width="295.6" height="49.6">订单号</th>
								<th width="144" height="49.6">收货人</th>
								<th width="176.8" height="49.6">收货地址</th>
								<th width="144.8" height="49.6">总数量</th>
								<th width="144.8" height="49.6">总价格</th>
								<th width="166.4" height="49.6">支付时间</th>

							</tr>
						</thead>
						<tbody>
						<c:forEach items="${OrderList }" var="OneOrder" varStatus="loop">
						<tr>
							<td height="63.2">${OneOrder.id}</td>
							<td>${OneOrder.contacts}</td>
							<td>${OneOrder.address }</td>
							<td>${TitalNum[loop.count-1]}</td>
							<td><fmt:formatNumber type="number" value="${OneOrder.sum }" pattern="00.00"/></td>
							<td><fmt:formatDate value="${OneOrder.payTime }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
						</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
