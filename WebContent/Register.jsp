<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%> 
<html>
<head>
<meta charset="UTF-8">
<title>星享俱乐部</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/register.css">
</head>
	<body>
		<div id="head">
			<ul id="logo">
				<li style="width: 40px;">
					<img src="${APP_PATH }/image/logo.svg" width="40" height="40">
				</li>
				<li class="out">
					<span  style="color: rgba(0,0,0,.87);cursor: default;">心情惬意，来杯咖啡吧&nbsp;☕</span>
				</li>
			</ul>
			<p class="logotext">
					Welcome to register
			</p>
			<ul id="Lmenu">
				<li>
					<a href="${APP_PATH }/Login.jsp" style="color: rgba(0,0,0,.5);">登录</a>
				</li>
				<li>
					<a href="${APP_PATH }/Register.jsp" style="color: rgba(0,0,0,.5);">注册</a>
				</li>
			</ul>
		</div>
		<div id="bd">
			<label class="form_title">
				注&nbsp;&nbsp;册
			</label>
			<div id="form_body">
				<p class="info"></p>
				<form   name="Register" id="register_form">
					<div class="li" style="margin-top: 10px;">
						<label>用户名:</label>
						<input type="text" name="user_name" class="user user_name" placeholder="请输入用户名"/>
					</div>
					<div class="li">
						<label>密&nbsp;&nbsp;&nbsp;码:</label>
						<input type="password" name="user_paw" class="user user_paw" placeholder="请输入密码"/>
					</div>
					<div class="li" style="line-height: 38px;">
						<label>性&nbsp;&nbsp;&nbsp;别:</label>
						<div class="sf">
							<input type="radio" name="user_sex" checked="checked" id="mj1" value="nan"/><label for="mj1">男</label>
							<input type="radio" name="user_sex"  id="mj2" value="nv"/><label for="mj2">女</label>
						</div>
					</div>
					<div class="li">
						<label>校验码:</label>
						<input type="text" name="user_v" class="user_v" placeholder="输入校验码"/>
						<div class="v_code">
							<img src="${pageContext.request.contextPath }/Verfimg.do" width="80" height="34"  class="ver_code"/>
						</div>
					</div>
					<input type="button" value="注册" id="sub" />
				</form>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		$(".v_code").click(function() {
			$(".ver_code").attr("src","${pageContext.request.contextPath}/Verfimg.do?"
					+ Math.random());
		});
		$("#sub").click(function(){
			if($(".user_name").val()==""){
				alert("请输入正确的用户名");
			}else if($(".user_paw").val()==""){
				alert("请输入正确的密码");
			}else if($(".user_v").val()==""){
				alert("请输入验证码");
			}else{
				$.ajax({
			        "url" : "register.do",
			        "type" : "get",
			        "data" :$("#register_form").serialize(),
			        "dataType" : "text",
			        "success" : success,
			        "processData":false,
		            "contentType":false,
		            "cache":false,
			    });
				function success(data) {
					if(data=="code error"){
						$(".info").text("验证码错误");
						$("#user_v").val("");
						$(".ver_code").attr("src","${pageContext.request.contextPath}/Verfimg.do?"
								+ Math.random());
						$("#user_v").focus();
					}else if(data=="user exit"){
						$(".info").text("用户已存在");
						$(".user_name").val("");
						$(".user_paw").val("");
						$(".user_v").val("");
						$(".ver_code").attr("src","${pageContext.request.contextPath}/Verfimg.do?"
								+ Math.random());
						$(".user_name").focus();
					}else if(data=="success"){
						location.href="${APP_PATH }/Login.jsp";
					}else{
						$(".info").text("注册失败");
					}
				};
			}
			
		});
	});
</script>