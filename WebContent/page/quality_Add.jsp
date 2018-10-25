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
		id="form-admin-add" style="line-height: 30px; enctype="multipart/form-data">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">所属部门：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" class="input-text" value="${param.isPerson}"
					placeholder="" id="isPerson" name="" disabled="disabled"
					style="width: 100px; height: 30px"> --%>
				<select id="deptNo" name="deptNo" class="select-box"
					style="width: 150px; margin-left: 8.95px;">


					<option value="1">生产部门</option>


					<option value="2">装配部门</option>

				</select>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>检测人：</label>
			<div class="formControls col-xs-8 col-sm-9"
				style="width: 150px; margin-left: 8.95px;">
				<select id="adminPeper" name="adminPeper"
					class="select-box">
					<c:forEach var="a" items="${admins}">
						<option value="${a.id }"
							<c:if test="a.id==adminPeper">selected="selected"</c:if>>

							${a.name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>检测零件型号：</label>
			<div class="formControls col-xs-8 col-sm-9"
				style="width: 150px; margin-left: 8.95px;">
				<select id="detectionPartTypeId" name="detectionPartTypeId"
					class="select-box">
					<c:forEach var="p" items="${partTypes}">
						<option value="${p.id }"
							<c:if test="p.id==detectionPartTypeId">selected="selected"</c:if>>

							${p.partType }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>检测成品型号：</label>
			<div class="formControls col-xs-8 col-sm-9"
				style="width: 150px; margin-left: 8.95px;">
				<select id="detectionFinishedTypeId" name="detectionFinishedTypeId"
					class="select-box">
					<c:forEach var="f" items="${finishedproductstypes}">
						<option value="${f.id }"
							<c:if test="f.id==detectionFinishedTypeId">selected="selected"</c:if>>

							${f.productType }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>零件规格图地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="file" class="input-text"  placeholder=""
					id="partImageUrl" name="partImageUrl">
			</div>
		</div> -->
		
		<span class="" id="warningPhone"
			style="display: none; margin-left: 220px;"> </span>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>规定提交时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="date" Class="Wdate" onclick="WdatePicker" class="input-text" value="" placeholder=""
					id="submissionTime" name="submissionTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">检测数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="detectionNum"
					name="detectionNum">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red"></span>备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea rows="40" cols="10" class="input-text" id="desc"
					name="desc"></textarea>
			</div>
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
		//添加用户
		$(function() {
			$("#sub")
					.click(
							function() {
								var deptNo = $("#deptNo").val();
								var adminPeper = $("#adminPeper").val();
								var detectionPartTypeId = $(
										"#detectionPartTypeId").val();
								var detectionFinishedTypeId = $(
										"#detectionFinishedTypeId").val();
								var submissionTime = $("#submissionTime").val();
								/* var partImageUrl = $("#partImageUrl").val(); */
								var detectionNum = $("#detectionNum").val();
								
								var desc = $("#desc").val();
								$.post("toadd",{
													'deptNo' : deptNo,
													'adminPeper':adminPeper,
													'detectionPartTypeId' : detectionPartTypeId,
													'detectionFinishedTypeId' : detectionFinishedTypeId,
													/* 'partImageUrl':partImageUrl, */
													'detectionNum':detectionNum,
													'desc':desc,
													'subTime':submissionTime
												}, function(data) {
													layer.msg('添加成功!', {
														icon : 1,
														time : 1000
													}, function() {
														parent.location
																.reload();
														layer_close();
													});
												},"text");
							});
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>