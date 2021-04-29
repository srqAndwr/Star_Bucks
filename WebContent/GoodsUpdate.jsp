<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta charset="UTF-8">
<title>星巴克 | 修改商品</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/GoodsUpdate.css" />
	</head>
	<body>
		<%@ include file="Business_head.jsp"%>
		<div id="body">
			<div class="b_left">
				<%@ include file="Business_left.jsp"%>
			</div>
			<div class="b_right">
				<div class="Mheader">商品修改</div>
				<div class="Mbody">
				<form action="${pageContext.request.contextPath}/business/GoodsUpdate.do" method="post">
					<div class="list" style="height: 38px;">
						<label for="goodsname" style="height: 38px;">商品名称：</label>
						<div class="texta" style="38px">
							<input type="hidden" name="id" value="${Goods.item_id }">
							<input type="text" name="goodsname" id="goodsname" placeholder="请输入商品名称" value="${Goods.item_name }"
							 required="">
						</div>
					</div>

					<div class="list" style="height: 38px;">
						<label for="price" style="height: 38px;">商品价格：</label>
						<div class="texta" style="38px">
							<input type="number" name="price" id="price" placeholder="0.01" step="0.01" min="0.01"
							 value="${Goods.price }" >
						</div>
					</div>

					<div class="list" style="height: 86px;">
						<label for="details"  style="height: 86px;">商品简介：</label>
						<div class="texta" style="86px">
							<textarea name="details" id="details" rows="3">${Goods.details }</textarea>
						</div>
					</div>

					<div class="list" style="height: 200px;">
						<label for="img"  style="height: 200px;">商品图片：</label>
						<div class="texta" style="200px">
							<img src="${APP_PATH }/image/goodsimg/${Goods.item_img}" width="200">
						</div>
					</div>

					<div class="list" style="height: 38px;margin-bottom: 0;">
						<div>
							<button type="submit" class="btn">修改商品</button>
						</div>
					</div>
				</form>
				</div>
			</div>
		</div>

	</body>
</html>
