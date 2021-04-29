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
<title>星巴克 | 未支付订单</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/orderTobepaid.css" />
</head>
<body>
<%@ include file="head.jsp"%>
	<div id="container">
		<div id="body">
			<div class="info">${info }</div>
			<div class="head">待支付订单(共${size }件)</div>
			<div class="body">
				<table class="table">
					<thead>
						<tr>
							<th width="329.6" height="49.6">订单号</th>
							<th width="144" height="49.6">收货人</th>
							<th width="176.8" height="49.6">收货地址</th>
							<th width="144.8" height="49.6">总数量</th>
							<th width="144.8" height="49.6">总价格</th>
							<th width="166.4" height="49.6">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${OrderList }" var="OneOrder" varStatus="loop">
						<form id="${OneOrder.id}" name="${OneOrder.id}" method="post" action="">
						<tr>
							<td height="63.2">${OneOrder.id}
								<input type="text" value="${OneOrder.id}" name="OrderId" style="display:none"/>
							</td>
							<td>${OneOrder.contacts}</td>
							<td>${OneOrder.address }</td>
							<td>${TitalNum[loop.count-1]}</td>
							<td><fmt:formatNumber type="number" value="${OneOrder.sum }" pattern="00.00"/> </td>
							<td>
								<button class="pay" onclick="pay('${OneOrder.id}')">支付</button>
								<button class="del pay" onclick="del('${OneOrder.id}')">删除</button>
							</td>
						</tr>
						</form>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	function pay(id){
		$("#"+id).attr("action","${pageContext.request.contextPath}/custom/OrderPay.do");
		$("#"+id).submit();
	}
	function del(id){
		$("#"+id).attr("action","${pageContext.request.contextPath}/custom/delOrder.do");
		$("#"+id).submit();
	}
</script>