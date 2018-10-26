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
	content="H-ui.productionLeader v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.productionLeader v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<article class="cl pd-20" style="margin-right:50px;">
	<form action="#" method="post" class="form form-horizontal"
		id="form-assemblytask-modi" style="line-height: 30px;">

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>装配任务书编号：</label>
			<div class="formControls col-xs-2 col-sm-3">
				<input type="text" class="input-text" id="id" name="id" value="${param.id}" disabled>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>成品类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 180px; margin-left: 8.95px;">
					<select class="select" name="finishedType" size="1" id="finishedType">
				</select>
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>装配班长：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 100px; margin-left: 8.95px;">
					<select class="select" name="assemblyLeader" size="1" id="assemblyLeader">
				</select>
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>零件配方：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 250px; margin-left: 8.95px;">
					<select class="select" name="partformulaId" size="1" id="partformulaId">
				</select>
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>预计完成时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="dateStr" id="estimatedTimeOfCompletion">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="desc">
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
        //发送请求获取成品类型
        $.ajax({
            url: "${APP_PATH}/finishedtypes",
            type: "GET",
            success: function (result) {
                var finishedtypes = result.extend.finishedtypes;
                $.each(finishedtypes, function (index, item) {
                    $("#finishedType").append(
                        "<option value='" + item.id + "'>"
                        + item.productType
                        + "</option>"
                    )
                });
            }
        });

        //发送请求获取装配班长
        $.ajax({
            url: "${APP_PATH}/assemblyLeaders",
            type: "GET",
            success: function (result) {
                var assemblyLeaders = result.extend.assemblyLeaders;
                $.each(assemblyLeaders, function (index, item) {
                    $("#assemblyLeader").append(
                        "<option value='" + item.id + "'>"
                        + item.name
                        + "</option>"
                    )
                });
            }
        });

        //发送请求获取零件配方
        $.ajax({
            url: "${APP_PATH}/partformulas",
            type: "GET",
            success: function (result) {
                var partformulas = result.extend.partformulas;
                $.each(partformulas, function (index, item) {
                    $("#partformulaId").append(
                        "<option value='" + item.id + "'>"
                        + item.formulaName
                        + "</option>"
                    )
                });
            }
        });

        //获取要修改的装配任务书信息
        $.ajax({
			//从上个页面传来的id
			url:"${APP_PATH}/assebmlytask1/${param.id}",
			type:"GET",
			success:function (result) {
			    var assebmlytask=result.extend.assemblytask;
                var finishedtype = assebmlytask.finishedTypeEntity.productType;
                var assemblyLeader = assebmlytask.assemblyLeaderEntity.name;
                var partformula = assebmlytask.partformulaEntity.formulaName;
                var dateStr=assebmlytask.dateStr;
                var desc=assebmlytask.desc;
                $("#finishedType").val(finishedtype);
				$("#assemblyLeader").val(assemblyLeader);
				$("#partformulaId").val(partformula);
				$("#estimatedTimeOfCompletion").val(dateStr);
				$("#desc").val(desc);
            }
		});


		//提交，修改用户
		$("#sub").click(function() {
            if($("#estimatedTimeOfCompletion").val()===""){
                layer.alert('预计完成时间不能为空！', {icon: 5});
                return ;
            }

            /**
			 * 如果直接发送ajax请求，除了id，其他都为null
			 * 问题：请求体中有对象，但是对象封装不上
			 * tomcat将请求体中的数据封装为map，但是SpringMVC封装为pojo
             */
            $.ajax({
                url:"${APP_PATH}/assemblytask_edit/${param.id}",
                type:"PUT",
                data:$("#form-assemblytask-modi").serialize(),
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

		$('.skin-minimal input').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>