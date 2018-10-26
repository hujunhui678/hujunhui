<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath()+"/page");
%>
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
		  id="form-productivetask-add" style="line-height: 30px;">

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>生产任务书编号：</label>
			<div class="formControls col-xs-2 col-sm-3">
				<input type="text" class="input-text" id="id" name="id">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>生产计划：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 180px; margin-left: 8.95px;">
					<select class="select" name="planId" size="1" id="planId">
				</select>
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>零件类别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 200px; margin-left: 8.95px;">
					<select class="select" name="partTypeId" size="1" id="partTypeEntity">
				</select>
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>生产班长：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 200px; margin-left: 8.95px;">
					<select class="select" name="productionLeader" size="1" id="productionLeader">
				</select>
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>生产数量：</label>
			<div class="formControls col-xs-4 col-sm-3">
				<input type="text" class="input-text" name="productionNum" id="productionNum">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>预计完成时间：</label>
			<div class="formControls col-xs-7 col-sm-8">
				<input type="text" class="input-text" name="dateStr" id="estimatedTimeOfCompletion">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-7 col-sm-8">
				<input type="text" class="input-text" name="desc" id="desc">
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

        //发送请求获取生产计划
        $.ajax({
            url: "${APP_PATH}/productionplans",
            type: "GET",
            success: function (result) {
                var productionplans = result.extend.productionplans;
                $.each(productionplans, function (index, item) {
                    $("#planId").append(
                        "<option value='" + item.id + "'>"
                        + item.id
                        + "</option>"
                    )
                });
            }
        });

        //发送请求获取零件类别
        $.ajax({
            url: "${APP_PATH}/partTypes",
            type: "GET",
            success: function (result) {
                var partTypes = result.extend.partTypes;
                $.each(partTypes, function (index, item) {
                    $("#partTypeEntity").append(
                        "<option value='" + item.id + "'>"
                        + item.partType
                        + "</option>"
                    )
                });
            }
        });

        //发送请求获取生产班长
        $.ajax({
            url: "${APP_PATH}/productionLeaders",
            type: "GET",
            success: function (result) {
                var productionLeaders = result.extend.admins;
                $.each(productionLeaders, function (index, item) {
                    $("#productionLeader").append(
                        "<option value='" + item.id + "'>"
                        + item.name
                        + "</option>"
                    )
                });
            }
        });

        //提交，添加生产任务
        $("#sub").click(function () {
            if($("#id").val()===""){
                layer.alert('生产任务书编号不能为空！', {icon: 5});
                return ;
            }

			if($("#estimatedTimeOfCompletion").val()===""){
                layer.alert('预计完成时间不能为空！', {icon: 5});
                return ;
			}

            debugger
            $.ajax({
				url:"${APP_PATH}/productivetask_add",
				type:"POST",
				data:$("#form-productivetask-add").serialize(),
				success:function (result) {
				    var icon= result.code===100 ? 1 : 2;
                    layer.msg(result.msg, {
                        icon : icon,
                        time : 1000
                    }, function() {
                        parent.location.reload();
                        layer_close();
                    });
                }
			})
        });

	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>