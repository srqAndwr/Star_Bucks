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
<title>星巴克 | 菜单</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/menu.css" />
</head>
<body>
<%@ include file="head.jsp"%>
		<div id="container">
			<div id="left_d">
				<div class="All">
					<span>所有商品</span>
				</div>
				<div class="listGroup">
					<c:forEach items="${goods_type}" var="type">
						<a href="${pageContext.request.contextPath}/menuByType.do?type=${type.type_id}">${type.type_name}</a>
					</c:forEach>
				</div>
			</div>
			<div id="right_d">
				<div style="width:904px;position:absolute;top:200px;display:none" class="info">
					<h2 style="text-align:center;color:red">暂无此类商品销售</h2>
				</div>
				<div class="Goods">
					<c:if test="${PageEnd >=0}">
					<c:forEach items="${goods}" var="good" begin="${PageStart }" end="${PageEnd }">
					<div class="everGood">
						<img class="goodImg" src="${APP_PATH }/image/goodsimg/${good.item_img }" alt="Card image cap" width="284.2px" height="284.2px">
						<div class="goodBody">
							<p style="margin-bottom: 2px;">
								<a href="${pageContext.request.contextPath}/GoodsDetails.do?goodId=${good.item_id}"
								style="width:236.5px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;display:inline-block"
								title="${good.item_name}">${good.item_name}</a>
							</p>
							<p style="color: red; margin-bottom: 2px">￥<fmt:formatNumber
										type="number" value="${good.price}" pattern="00.00" /></p>
						</div>
					</div>
					</c:forEach>
					</c:if>
				</div>
				<div class="btnPageGroup">
					<ul>
						<li><a href="${pageContext.request.contextPath}/menu.do?pageNo=${page.first}" style="border-top-left-radius: .25rem;
    border-bottom-left-radius: .25rem;">第一页</a></li>
						<li><span class="prev">上一页</span></li>
						<li><span class="next">下一页</span></li>
						<li style="width: 89px;"><a href="${pageContext.request.contextPath}/menu.do?pageNo=${page.last}" style="border-top-right-radius: .25rem;
    border-bottom-right-radius: .25rem;">最后一页</a></li>
					</ul>
				</div>
			</div>
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
		if((GoodsEnd-GoodsStart)<1){
			$(".info").show();
			$(".btnPageGroup").hide();
		}
		if((GoodsEnd-GoodsStart)>3&&(GoodsEnd-GoodsStart)<=6){
			$(".btnPageGroup").css("margin-top","-358.2px");
		}else if((GoodsEnd-GoodsStart)>0&&(GoodsEnd-GoodsStart)<=3){
			$(".btnPageGroup").css("margin-top","-726.4px");
		}
		$(".All").click(function(){
			location.href="${pageContext.request.contextPath}/menu.do";
		});
		$(".prev").click(function(){
			if(pageno==1){
				alert("不能再往前啦！");
			}else {
				location.href="${pageContext.request.contextPath}/menu.do?pageNo=${page.prev}";
			}
		});
		$(".next").click(function(){
			if(pageno==pages){
				alert("不能再往后啦！");
			}else {
				location.href="${pageContext.request.contextPath}/menu.do?pageNo=${page.next}";
			}
		});
	});
</script>