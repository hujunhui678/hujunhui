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
          id="form-production-add" style="line-height: 30px;">

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span
                    class="c-red">*</span>生产表编号：</label>
            <div class="formControls col-xs-2 col-sm-3">
                <input type="text" class="input-text" id="id" name="id">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span
                    class="c-red">*</span>生产任务书编号：</label>
            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 100px; margin-left: 8.95px;">
					<select class="select" name="taskId" size="1" id="taskId">
				</select>
				</span>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span
                    class="c-red">*</span>零件类型：</label>
            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 100px; margin-left: 8.95px;">
					<select class="select" name="partTypeId" size="1" id="partTypeId">
				</select>
				</span>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span
                    class="c-red">*</span>生产人：</label>
            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 100px; margin-left: 8.95px;">
					<select class="select" name="productionPeople" size="1" id="productionPeople">
				</select>
				</span>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span
                    class="c-red">*</span>实际生产数量：</label>
            <div class="formControls col-xs-2 col-sm-3">
                <input type="text" class="input-text" id="realQuantity" name="realQuantity">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span
                    class="c-red">*</span>完成时间：</label>
            <div class="formControls col-xs-2 col-sm-3">
                <input type="text" class="input-text" id="dateStr" name="dateStr">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注</label>
            <div class="formControls col-xs-2 col-sm-3">
                <input type="text" class="input-text" id="desc" name="desc">
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
    $.ajax({
        url: "${APP_PATH}/productiveTaskIds",
        type: "GET",
        success: function (result) {
            var productiveTaskIds = result.extend.productiveTaskIds;
            $.each(productiveTaskIds, function (index, item) {
                $("#taskId").append(
                    "<option value='" + item + "'>"
                    + item
                    + "</option>"
                )
            });
        }
    });

    $.ajax({
        url: "${APP_PATH}/partTypes",  //这是ProductivetaskController中的，理应把他放到PartTypeController中
        type: "GET",
        success: function (result) {
            var partTypeEntity = result.extend.partTypes;
            $.each(partTypeEntity, function (index, item) {
                $("#partTypeId").append(
                    "<option value='" + item.id + "'>"
                    + item.partType
                    + "</option>"
                )
            });
        }
    });

    $.ajax({
        url: "${APP_PATH}/productionPeople",
        type: "GET",
        success: function (result) {
            var productionPeopleEntity = result.extend.productionPeople;
            $.each(productionPeopleEntity, function (index, item) {
                $("#productionPeople").append(
                    "<option value='" + item.id + "'>"
                    + item.name
                    + "</option>"
                )
            });
        }
    });

    $("#sub").click(function () {
        if($("#id").val()===""){
            layer.alert('生产表编号不能为空！', {icon: 5});
            return ;
        }

        if($("#dateStr").val()===""){
            layer.alert('预计完成时间不能为空！', {icon: 5});
            return ;
        }

        if($("#realQuantity").val()===""){
            layer.alert('实际生产数量不能为空！', {icon: 5});
            return ;
        }

        $.ajax({
            url:"${APP_PATH}/production_add",
            type:"POST",
            data:$("#form-production-add").serialize(),
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
</body>
</html>

