<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta charset="UTF-8">
<title>星巴克 | 添加商品</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/goodsadd.css" />
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
					<form id="goods" name="goods" enctype="multipart/form-data" method="POST">
						<div class="list" style="height: 38px;">
							<label for="goodsname" style="height: 38px;">商品名称：</label>
							<div class="texta" style="38px">
								<input type="text" name="item_name" id="goodsname" placeholder="请输入商品名称" required="required">
							</div>
						</div>

						<div class="list" style="height: 38px;">
							<label for="price" style="height: 38px;">商品价格：</label>
							<div class="texta" style="38px">
								<input type="number" name="price" id="price" placeholder="0.01" step="0.01" min="0.01" value="00.10" required="required">
							</div>
						</div>

						<div class="list" style="height: 86px;">
							<label for="details" style="height: 86px;">商品简介：</label>
							<div class="texta" style="86px">
								<textarea name="details" id="details" placeholder="请输入商品简介"></textarea>
							</div>
						</div>

						<div class="list" style="height: 38px;">
							<label for="img" style="height: 38px;">商品图片：</label>
							<div class="texta" style="38px">
								<input type="file" name="goodsimg" id="goodsimg" accept=".jpg">
							</div>
						</div>
						<div class="list" style="height: 38px;">
							<label for="price" style="height: 38px;">商品类别：</label>
							<div class="type" style="38px">
								<select name="type" class="type">
									<option value="1" selected="">饮品</option>
									<option value="2" selected="">美食</option>
									<option value="3" selected="">咖啡产品</option>
									<option value="4" selected="">咖啡器具</option>
									<option value="5" selected="">面包</option>
									<option value="6" selected="">其他</option>
								</select>
							</div>
						</div>
						<div class="list" style="height: 38px;margin-bottom: 0;">
							<div>
								<button type="button" class="btn add">添加商品</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
		$(".add").click(function(){
			var formdata = new FormData(document.getElementById("goods"));
			$.ajax({
		        "url" : "${pageContext.request.contextPath}/business/Goodsadd.do",
		        "type" : "POST",
		        "data" :formdata,
		        "dataType" : "text",
		        "success" : success,
		        "processData":false,
	            "contentType":false,
	            "cache":false
		    });
			function success(data) {
				alert("添加成功");
				location.href="${pageContext.request.contextPath}/business/indexBusiness.do"
			};
		});
	});
</script>