<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/business_head.css" />
	</head>
	<body>
		<div class="head">
			<a class="logo" href="${pageContext.request.contextPath}/business/indexBusiness.do">STARBUCKS</a>
			<div class="right">
				<ul>
					<li><a href="#" class="h">Link</a></li>
					<li><a href="#" class="h">Link</a></li>
					<li>
						<a href="#" class="name" style="">
							<span>
								${business.user_name}
							</span>
							<span class="jt"></span>
						</a>
						<div class="down">
							<a href="${pageContext.request.contextPath}/Logout.do">注销</a>
						</div>
					</li>
				</ul>
				<form method="post" action="${pageContext.request.contextPath}/business/BusinessByName.do" id="search">
					<input  type="search" placeholder="Search" name="key" class="key">
					<button  type="button" class="sub">Search</button>
				</form>
			</div>
			</nav>
		</div>
	</body>
</html>
<script type="text/javascript">
	$(".down").hide();
	$(document).ready(function() {
		$(".name").mouseenter(function() {
			$(".jt").css({
				"background-image": "url(${APP_PATH }/image/businessJTHover.jpg)",
				"left":"-1.5px",
				"top":"1px"
			});
			$(".jt").width("15px");
			$(".jt").height("13px");
		});
		$(".name").mouseleave(function() {
			$(".jt").css({
				"background-image": "url(${APP_PATH }/image/businessJT.jpg)",
				"left":"0px",
				"top":"3px"
			});
			$(".jt").width("23px");
			$(".jt").height("15px");
		});
		$(".name").click(function(){
			$(".down").fadeToggle();
		});
		$(".sub").click(function(){
			if($("key").val()==""){
				alert("请输入查询商品名字");
				$("key").focus();
				return false;
			}else {
				$("#search").submit();
			}
		});
	});
</script>
