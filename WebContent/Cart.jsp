<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%> 
<html>
<head>
<meta charset="UTF-8">
<title>星巴克 | 购物车</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/cart.css" />
	</head>
	<body>
	<%@ include file="head.jsp"%>
		<div id="container">
			<div id="body">
				<div class="header">
					我的购物车(共${size }件)
				</div>
				<table class="cardbody">
					<thead>
						<tr>
							<th style="width: 165.5px;height: 49.6px;">
								<div>
									<input type="checkbox" id="exampleCheck1"> <label for="exampleCheck1">全选</label>
								</div>
							</th>
							<th width="313.6">商品图片</th>
							<th width="226.4">名称</th>
							<th width="136">价格</th>
							<th width="149.6">数量</th>
							<th width="180.8">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${info!=null}">
								<div style="width:400px;height:50px;color:red;position:absolute;font-size:25px;font-weight:bold;top:206px;left:600px">${info}</div>
						</c:if>
					<form id="item" action="${APP_PATH }/custom/order_confirm.do" method="post">
						<c:forEach items="${CartList }" var="OneCart" varStatus="loop">
						<tr height="144.8">
							<th width="165.5">
								<div style="padding-left: 1.25rem;box-sizing: border-box;">
									<input type="checkbox" name="itemid" value="${OneCart.id }">
								</div>
							</th>
							<td width="313.6"><img src="${APP_PATH }/image/goodsimg/${GoodList[loop.count-1].item_img }" width="120"></td>
							<td width="226.4">${GoodList[loop.count-1].item_name }</td>
							<td width="136"><fmt:formatNumber
										type="number" value="${GoodList[loop.count-1].price }" pattern="00.00" /></td>
							<td width="149.6">
								<div style="width: 125.6px;height: 38px;">
									<div style="width: 32.4px;height: 38px;float: left;">
										<button type="button" class="reduce" onclick="re(${OneCart.id })">-</button>
									</div>
									<input type="text"  class="shownum" disabled="true" value="${OneCart.num }">
									<div style="width: 32.4px;height: 38px;float: right;">
										<button type="button" class="add" onclick="add(${OneCart.id })">+</button>
									</div>
								</div>
							</td>
							<td width="180.8"><a class="erase" href="${pageContext.request.contextPath}/custom/DeleteCartItem.do?cartid=${OneCart.id }" role="button">删除</a></td>
						</c:forEach>
						
					</tbody>
				</table>
				<div id="btnGroup">
					<input type="button"  id="back" value="继续购物" style="width: 116px;"/>
					<input type="submit"  id="js" value="结算" />
				</div>
				</form>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
	function re(id){
		location.href="${pageContext.request.contextPath}/custom/ReNum.do?cartid="+id;
	}
	function add(id){
		location.href="${pageContext.request.contextPath}/custom/AddNum.do?cartid="+id;
	}
	$(document).ready(function(){
		$("#back").click(function(){
			location.href="${pageContext.request.contextPath}/menu.do";
		});
		$("#exampleCheck1").click(function(){
			if($("#exampleCheck1").prop("checked")==true){
				$('input:checkbox').prop("checked", true);
			}else {
				$('input:checkbox').prop("checked", false);
			}
		});
	});
</script>