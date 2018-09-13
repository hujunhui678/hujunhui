<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/static/h-ui.admin/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />

<link
	href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->

<title></title>
<meta name="keywords"
	content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<article class="cl pd-20" style="margin-right:50px;">
	<form action="#" method="post" class="form form-horizontal"
		id="form-admin-add" style="line-height: 30px;">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">添加的人员：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${param.isPerson}"
					placeholder="" id="isPerson" name="" disabled="disabled"
					style="width: 100px; height: 30px">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="adminName" name="adminName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal"
				style="width: 600px; margin-left: 30px">
				<div class="radio-box">
					<input name="sex" type="radio" id="sex-1" value="男" checked /> <label
						for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-2" name="sex" value="女" /> <label
						for="sex-2">女</label>
				</div>
			</div>
		</div>
		<span class="" id="warningPhone"
			style="display: none; margin-left: 220px;"> </span>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""
					id="phone" name="phone">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">身份证号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="cardId">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">所属部门：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 150px; margin-left: 8.95px;">
					<select class="select" name="childDeptNo" size="1" id="childDeptNo">
				</select>
				</span>
			</div>
		</div>
		<div class="row cl" id="role">
			<label class="form-label col-xs-4 col-sm-3">角色：</label>
			<div class="formControls col-xs-8 col-sm-9" id="checkBoxRole"
				style="width: 600px; margin-left: 10px"></div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="button" id="sub"
					value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/static/h-ui.admin/js/H-ui.admin.page.js"></script>

	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
		$(function() {
			var isPerson = $("#isPerson").val();
			$
					.post(
							"toAddPerson",
							null,
							function(data) {
								var roleList = data.roleList;
								var childDeptList = data.childDeptList;
								if (isPerson == "管理员") {
									for (i in roleList) {
										$("#checkBoxRole")
												.append(
														"<label class='middle'><input name='roleId' class='ace' type='checkbox' id='id-disable-check' value='"+roleList[i].id+"'><span class='lbl'>"
																+ roleList[i].roleName
																+ "</span></label>&nbsp;&nbsp;");
										if (i != 0 && i % 4 == 0) {
											$("#checkBoxRole").append("<br/>");
										}
									}
								} else {
									$("#role").hide();
								}
								for (i in childDeptList) {
									$("#childDeptNo")
											.append(
													"<option value='"+childDeptList[i].id+"'>"
															+ childDeptList[i].childName
															+ "</option>");
								}

							}, "json");
			//添加用户
			$("#sub").click(
					function() {
						var arr = new Array();
						$(".ace:checked").each(function(i) {
							arr[i] = $(this).val();
						});
						var vals = arr.join(",");
						var isPerson = $("#isPerson").val();
						var adminName = $("#adminName").val();
						var phone = $("#phone").val();
						var cardId = $("#cardId").val();
						var childDeptNo = $("#childDeptNo").val();
						var gender = $("input[type='radio']:checked").val();
						if (adminName == "" || adminName.length < 2
								|| phone == "" || phone.length < 11) {
							return;
						}
						if(vals.length < 1){
							layer.alert('至少赋予一个角色!', {icon: 5});
	     					 return ;
						}
						$.post("addPerson", {
							'isPerson' : isPerson,
							'roles' : vals,
							'name' : adminName,
							'phone' : phone,
							'cardId' : cardId,
							'gender' : gender,
							'deptChildId' : childDeptNo
						}, function(data) {
							if (data == "true") {
								layer.msg('添加成功!', {
									icon : 1,
									time : 1000
								}, function() {
									parent.location.reload();
									layer_close();
								});
							}
						});
					});
			//手机号查重
			$("#phone").blur(
					function() {
						var phone = $(this).val();
						if (phone == "" || phone.length < 11) {
							$("#warningPhone").hide();
							$("#sub").attr("disabled", "disabled");
							return;
						}
						$.post("selPhone?phone=" + phone, null, function(data) {
							if (data == "true") {
								$("#warningPhone").hide();
								$("#sub").removeAttr("disabled");
							} else if (data == "false") {
								$("#warningPhone").attr("class",
										"label label-sm label-warning").show()
										.html("手机号重复");
								$("#sub").attr("disabled", "disabled");
							} else {
								$("#warningPhone").attr("display", "none");
							}
						})
					});

			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});

			$("#form-admin-add").validate({
				rules : {
					adminName : {
						required : true,
						minlength : 2,
						maxlength : 6
					},
					sex : {
						required : true,
					},
					phone : {
						required : true,
						isPhone : true,
					},
					adminRole : {
						required : true,
					},
				},
				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function(form) {
					$(form).ajaxSubmit();
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}
			});
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>