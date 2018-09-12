<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>奥特佳新能源科技有限公司</title>
<link rel="stylesheet" type="text/css" href="./statics/css/style2.0.css">
<link rel="stylesheet" type="text/css" href="./statics/css/login.css">
<body>
	<div id="contPar" class="contPar">
		<div id="page1" style="z-index: 1;">
			<div class="title0">AoteCar</div>
			<div class="title1">创新、高效、质量、公共安全</div>
			<div class="imgGroug">
				<ul>
					<img alt="" class="img0 png" src="./statics/images/page1_0.png">
					<img alt="" class="img1 png" src="./statics/images/page1_1.png">
					<img alt="" class="img2 png" src="./statics/images/page1_2.png">
				</ul>
			</div>
			<img alt="" class="img3 png" src="./statics/images/page1_3.jpg">
		</div>
	</div>
	<div class="tyg-div-denglv">
		<div class="tyg-div-form">
			<form action="#" method="post">
				<h2 style="margin: 3px 0 0 20px;">登录</h2>
				<p class="tyg-p">
					<a style="color: #2ec0f6;" href="http://www.aotecar.com/"
						target="_blank">企业官网 </a>&nbsp;&nbsp;&nbsp;
					<!-- 展示登录错误信息 -->
					<span style="color: red; font-weight: bold;" id="errorMessage">
					</span>
				</p>
				<div style="margin: 5px 0px;">
					<input name="loginName" id="loginName" type="text"
						value="${loginName}" placeholder="  请输入账号..." />
				</div>
				<div style="margin: 5px 0px;">
					<input type="password" name="pwd" id="pwd" placeholder="  请输入密码..." />
				</div>
				<div style="margin: 5px 0px;">
					<input type="text" name="code" id="code" style="width: 150px;"
						placeholder="  请输入验证码..." /> <a href="#" onclick="changeImg()">

						<img id="imgObj" alt="验证码"
						style="position: relative; top: 10.012px;"
						src="${pageContext.request.contextPath}/getCode">
					</a><br />
				</div>

				<div style="margin: 5px 20px; margin-top: 20px;">
					<input style="position: relative; top: 2.5px; cursor: pointer;"
						type="checkbox" name="rememberMe" id="rememberMe">&nbsp;<label
						for="rememberMe" style="cursor: pointer;">记住密码</label><br>
				</div>
				<button type="button" id="submit">
					登 <span style="width: 20px;"></span> 录
				</button>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="./statics/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="./statics/js/com.js"></script>
	<script type="text/javascript">
		$(function() {
			$("body").keydown(function() {
			    if (event.keyCode == "13") {//keyCode=13是回车键；数字不同代表监听的按键不同
			    	$("#submit").click();
			    }
			});

			//登录表单ajax提交
			$("#submit")
					.click(
							function() {
								var loginName = $("#loginName").val();
								var pwd = $("#pwd").val();
								var code = $("#code").val();
								var isRemember = $("#rememberMe").attr(
										"checked");
								if (isRemember) {
									isRemember = "true";
								} else {
									isRemember = "false";
								}

								$
										.post(
												"${pageContext.request.contextPath}/login",
												"loginName=" + loginName
														+ "&pwd=" + pwd
														+ "&code=" + code
														+ "&isRemember="
														+ isRemember,
												function(data) {
													if (data != "") {
														$("#errorMessage")
																.text(data);
														if(data == "验证输入不正确！"){
															$("#imgObj").click();
														}
														
													} else {
														window.location.href = "${pageContext.request.contextPath}/page/goMain";
													}
												}, "text");
							});
		});
		// 图片验证码
		function changeImg() {
			var imgSrc = $("#imgObj");
			var src = imgSrc.attr("src");
			imgSrc.attr("src", chgUrl(src));
		}

		// 时间戳
		// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
		function chgUrl(url) {
			var timestamp = (new Date()).valueOf();
			url = url.substring(0, 20);
			if ((url.indexOf("&") >= 0)) {
				url = url + "×tamp=" + timestamp;
			} else {
				url = url + "?timestamp=" + timestamp;
			}
			return url;
		}
	</script>
</body>
</html>