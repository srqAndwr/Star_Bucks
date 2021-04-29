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
<title>Insert title here</title>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/good_detail.css" />
</head>
	<body>
	<%@ include file="head.jsp"%>
		<div id="container">
			
			</div>
			<div id="body">
				<div class="top">
					<div class="left">
						<img src="${APP_PATH }/image/goodsimg/${OneGood.item_img}">
					</div>
					<div class="right">
						<h3><a href="#">${OneGood.item_name}</a></h3>
						<form id="good" action="${pageContext.request.contextPath}/custom/addCart.do" method="get">
							<p style="font-size: 1.2em; margin-top: 15px">价格：￥<fmt:formatNumber
										type="number" value="${OneGood.price}" pattern="00.00" /></p>
							<p style="font-size: 1.2em; margin-top: 15px">体积：
								<input type="radio" name="tj" checked="checked" id="big" value="big"/><label for="big">大杯</label>
							</p>
							<p style="font-size: 1.2em; margin-top: 15px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="tj" id="mid" value="mid"/><label for="mid">中杯</label>
							</p>
							<p style="font-size: 1.2em; margin-top: 15px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="tj"  id="small" value="small"/><label for="small">小杯</label>
							</p>
							<p style="font-size: 1.2em; margin-top: 15px">分类：&nbsp;${goodtype.type_name}</p>
							<p>
								<label for="inputPassword3"  style="font-size: 1.2em;margin-left: 0px;">数量：</label>
								<input type="hidden" name="goodsId" value="${OneGood.item_id}">
								<input type="number" name="num"  id="inputPassword3" value="1" step="1" min="1" required="">
							</p>
							<button type="submit" class="addOrder">加入购物车</button>
						</form>
					</div>
				</div>
				<div class="bottom">
					<ul  id="myTab" role="tablist">
						<li><a href="#home" class="xq">详情</a></li>
						<li><a href="#profile" style="width: 98px" class="cs">商品参数</a></li>
						<li><a href="#contact" class="pl">评论</a></li>
					</ul>
					<div class="xqy">
						${OneGood.details}
					</div>
					<div class="csy">
						西柚+橙+柠檬三重果肉，富含维生素C，低糖低卡
					</div>
					<div class="ply">
						西柚+橙+柠檬
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		$(".xq").addClass("addClass");
		$(".xqy").show();
		$(".csy").hide();
		$(".ply").hide();
		$(".xq").click(function(){
			$(".xq").addClass("addClass");
			$(".cs").removeClass("addClass");
			$(".pl").removeClass("addClass");
			$(".xqy").show();
			$(".csy").hide();
			$(".ply").hide();
		});
		$(".cs").click(function(){
			$(".cs").addClass("addClass");
			$(".xq").removeClass("addClass");
			$(".pl").removeClass("addClass");
			$(".csy").show();
			$(".xqy").hide();
			$(".ply").hide();
		});
		$(".pl").click(function(){
			$(".pl").addClass("addClass");
			$(".xq").removeClass("addClass");
			$(".cs").removeClass("addClass");
			$(".ply").show();
			$(".xqy").hide();
			$(".csy").hide();
		});
	});
</script>
