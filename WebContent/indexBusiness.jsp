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
<title>星巴克 | 欢迎</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${APP_PATH }/css/indexBusiness.css" />
</head>
<body>
	<%@ include file="Business_head.jsp"%>
	<div id="body">
		<div class="b_left">
			<%@ include file="Business_left.jsp"%>
		</div>
		<div class="b_right">
			<div class="Mheader">商家主页</div>
			<div class="Mbody">
				<table class="table">
					<thead>
						<tr>
							<th width="45.6" height="49.6">id</th>
							<th width="167.2" height="49.6">商品图片</th>
							<th width="184" height="49.6">名称</th>
							<th width="72.8" height="49.6">价格</th>
							<th width="64.8" height="49.6">类型</th>
							<th width="84" height="49.6">状态</th>
							<th width="242.4" height="49.6">操作</th>

						</tr>
					</thead>

					<tbody>

						<c:forEach items="${goodList }" var="OneGood" varStatus="loop"
							begin="${PageStart }" end="${PageEnd }">
							<tr>
								<th width="45.6" height="144.8">${OneGood.item_id}</th>
								<td width="167.2" height="144.8"><img
									src="${APP_PATH }/image/goodsimg/${OneGood.item_img}"
									width="120"></td>
								<td width="184" height="144.8">${OneGood.item_name }</td>
								<td width="72.8" height="144.8">￥<fmt:formatNumber
										type="number" value="${OneGood.price }" pattern="00.00" /></td>
								<td width="64.8" height="144.8">${typeList[loop.index].type_name}</td>
								<td width="84" height="144.8"><c:if
										test="${OneGood.status==1 }">
										在架上
									</c:if> <c:if test="${OneGood.status!=1 }">
										已下架
									</c:if></td>
								<td width="242.4" height="144.8"><a
									href="${pageContext.request.contextPath}/business/GoodsStatus.do?goodsId=${OneGood.item_id}&status=1"
									role="button" class="bt sj">上架</a> <a
									href="${pageContext.request.contextPath}/business/GoodsStatus.do?goodsId=${OneGood.item_id}&status=0"
									role="button" class="bt xj">下架</a> <a
									href="${pageContext.request.contextPath}/business/GoodsUpdateS.do?goodsId=${OneGood.item_id}"
									role="button" class="bt xg">修改</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="width: 860.8px; display: none; margin-top: 20px"
					class="info">
					<h2 style="text-align: center; color: red">${info}</h2>
				</div>
			</div>

		</div>
		<div class="foot">
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/business/indexBusiness.do?pageNo=1"
					class="first">第一页</a></li>
				<li><span class="prev">上一页</span></li>
				<li><span class="next">下一页</span></li>
				<li><a
					href="${pageContext.request.contextPath}/business/indexBusiness.do?pageNo=${page.last}"
					class="last">最后一页</a></li>
			</ul>
		</div>
	</div>

</body>
</html>
<script type="text/javascript">
	let GoodsStart = "${PageStart}";
	let GoodsEnd = "${PageEnd}";
	let pageno = "${pageno}";
	let pages = "${pages}";
	if(GoodsEnd!=0) GoodsEnd++;
	$(document).ready(function(){
		if(${goodList==null}){
			$(".info").show();
			$(".foot").hide();
		}
		if((GoodsEnd-GoodsStart)<1){
			$(".info").show();
			$(".foot").hide();
		}
		$(".All").click(function(){
			location.href="${pageContext.request.contextPath}/business/indexBusiness.do";
		});
		$(".prev").click(function(){
			if(pageno==1){
				alert("不能再往前啦！");
			}else {
				location.href="${pageContext.request.contextPath}/business/indexBusiness.do?pageNo=${page.prev}";
			}
		});
		$(".next").click(function(){
			if(pageno==pages){
				alert("不能再往后啦！");
			}else {
				location.href="${pageContext.request.contextPath}/business/indexBusiness.do?pageNo=${page.next}";
			}
		});
	});
</script>