<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta charset="UTF-8">
<title>星巴克 | 门店管理</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${APP_PATH }/css/branch_details.css" />
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
						<form id="fd" name="fd">
					<div class="list" style="height: 38px;">
						<label for="branchname" style="height: 38px;">分店名称：</label>
						<div class="texta" style="38px">
							<input type="hidden" name="id" value="${branch.branch_id }">
							<input type="text" name="branchname" id="branchname" placeholder="" value="${branch.branch_name }"  required="required"/>
						</div>
					</div>
						
					<div class="list" style="height: 38px;">
						<label for="branchaddr" style="height: 38px;">分店地址：</label>
						<div class="texta" style="38px">
							<input type="text" name="branchaddr" id="branchaddr" placeholder="" value="${branch.branch_addr }"/>
						</div>
					</div>
					<div class="list" style="height: 38px;">
						<label for="branchphone" style="height: 38px;">分店电话：</label>
						<div class="texta" style="38px">
							<input type="text" name="branchphone" id="branchphone" placeholder="" value="${branch.phone }"/>
						</div>
					</div>
					<div style="height: 38px;margin-bottom: 5px;width: 190px;margin-left: 640px;margin-top: 20px;">
						<input type="button" name="del" value="删除门店" class="btn del"/>
						<input type="button" name="upd" value="修改信息" class="btn upd"/>
					</div>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		$(".del").click(function(){
			$.ajax({
		        "url" : "${pageContext.request.contextPath}/business/BranchDel.do",
		        "type" : "get",
		        "data" :$("#fd").serialize(),
		        "dataType" : "text",
		        "success" : success,
		        "processData":false,
	            "contentType":false,
	            "cache":false
		    });
			function success(data) {
				alert("删除成功");
				location.href="${pageContext.request.contextPath}/business/branchManager.do"
			};
		});
		$(".upd").click(function(){
			$.ajax({
		        "url" : "${pageContext.request.contextPath}/business/BranchUpdate.do",
		        "type" : "get",
		        "data" :$("#fd").serialize(),
		        "dataType" : "text",
		        "success" : success,
		        "processData":false,
	            "contentType":false,
	            "cache":false
		    });
			function success(data) {
				alert("修改成功");
				location.href="${pageContext.request.contextPath}/business/branchManager.do"
			};
		});
	});
</script>