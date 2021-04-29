<%@page import="org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%> 
<html>
<head>
<meta charset="UTF-8">
<title>星巴克 | 用每一杯咖啡传递独特体验</title>
<link href="${APP_PATH }/css/indexCustom.css" rel="stylesheet" type="text/css" />
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<%@ include file="head.jsp"%>
		<div id="container">
			<div id="docu">
				<div id="docu_ul">
					<h5><span>王同学</span> <span>软件工程2班</span> <span>180******</span></h5><br>
					<h5><span>李同学</span> <span>软件工程2班</span> <span>180******</span></h5><br>
					<h5><span>贾同学</span> <span>软件工程2班</span> <span>180******</span></h5>
					<a href="${APP_PATH }/image/项目说明书.doc"><button class="uploadb">下载说明书</button></a>
				</div>
				<div id="docu_ph">
					<img src="${APP_PATH }/image/default_img2.jpg">
				</div>
			</div>
			<div id="lbt">
				<div class="box">
					<ul class="image">
						<li><img src="${APP_PATH }/image/carousel_img1.jpg" /></li>
						<li><img src="${APP_PATH }/image/carousel_img2.jpg" /></li>
						<li><img src="${APP_PATH }/image/carousel_img3.jpg" /></li>
					</ul>
					<ul class="num">
						<li class='current'>1</li>
						<li>2</li>
						<li>3</li>
					</ul>
					<div class="left arrow"><</div> 
					<div class="right arrow">></div>
				</div>
			</div>
			<div id="foot">
				<img src="${APP_PATH }/image/default_img1.jpg" >
			</div>
		</div>
	</body>
</html>
<script>
	var i = 0,timer;
	var sum = $(".image li").length;
	$(function() {
		$(".image li").eq(0).show();
		$(".box").hover(function() {
			$(".arrow").show();
			clearInterval(timer);
		}, function() {
			$(".arrow").hide();
			iLunbo();
		})
		iLunbo();

		$(".arrow").hover(function() {
			clearInterval(timer);
		});
		/*左箭头控制轮播*/
		$(".left").click(function() {
			clearInterval(timer);
			if (i == 0) {
				i = sum;
			}
			i--;
			startLunbo();
			iLunbo();
		});

		/*右箭头控制轮播*/
		$(".right").click(function() {
			clearInterval(timer);
			if (i == sum - 1) {
				i = -1;
			}
			i++;
			startLunbo();
			iLunbo();
		});

		/*提示信息变换*/
		$(".num>li").hover(function() {
			clearInterval(timer);
			i = $(this).index();
			//console.log(i);
			startLunbo();
		});
	});

	/*自动轮播*/
	function iLunbo() {
		timer = setInterval(function() {
			i++;
			if (i == sum - 1) {
				i = -1;
			}
			startLunbo();
		}, 4000)
	}

	/*图片轮播和提示信息*/
	function startLunbo() {
		if (i == 3) {
			i = 0;
		}
		$(".image>li").eq(i).fadeIn().siblings().fadeOut();
		$(".num>li").eq(i).addClass("current").siblings().removeClass("current");
	}
</script>
