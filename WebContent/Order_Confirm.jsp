<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta charset="UTF-8">
<title>星巴克 | 订单</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/order_confirm.css" />
</head>
<body>
<%@ include file="head.jsp"%>
	<div id="container">
		<div id="body">
			<form id="order" method="post" action="${pageContext.request.contextPath}/custom/AddorderToBePaid.do">
				<div class="head">订单确认</div>
				<div class="body_form">
					<label class="left_t">订单号</label><input type="text" readonly="true"
						value="${orderId }" class="right_t" name="order_id" /> <label
						class="left_t" >总金额</label><input type="text" readonly="true"
						value="${sum }" class="right_t sum" name="tatilsum" /> <label class="left_t">收货地</label><input
						type="text" value="" class="right_p addr" name="addr"
						placeholder="请输入收货地" /> <label class="left_t">联系人</label><input
						type="text" value="" class="right_p contacts" name="contacts"
						placeholder="请输入联系人" /> <label class="left_t">联系电话</label><input
						type="text" value="" class="right_p phone" name="phone"
						placeholder="请输入联系电话" />
				</div>
				<div id="foot">
					<button type="submit" class="sub" >确认订单</button>
				</div>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th width="383.2" height="49.6">详情</th>
					<th width="272" height="49.6">名称</th>
					<th width="192.8" height="49.6">价格</th>
					<th width="172.8" height="49.6">数量</th>
					<th width="254.7" height="49.6">金额</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${CartList }" var="OneCart" varStatus="loop">
				<tr>
					<td height="124.8"><img
						src="${APP_PATH }/image/goodsimg/${GoodList[loop.count-1].item_img }" width="100px"></td>
					<td>${GoodList[loop.count-1].item_name }</td>
					<td>${GoodList[loop.count-1].price }</td>
					<td>${OneCart.num }</td>
					<td><fmt:formatNumber type="number" value="${OneCart.num* GoodList[loop.count-1].price}" pattern="00.00"/> </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		$(".sub").click(function(){
			if($(".addr").val()==""){
				alert("请输入收货地址");
				$(".addr").focus();
				return false;
			}else if($(".contacts").val()==""){
				alert("请输入收货人");
				$(".contacts").focus();
				return false;
			}else if($(".phone").val()==""){
				alert("请输入联系电话");
				$(".phone").focus();
				return false;
			}else{
				$(".order").submit();
			}
		});
	});
</script>
