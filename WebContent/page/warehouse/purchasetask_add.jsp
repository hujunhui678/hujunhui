<%@page import="java.net.URLDecoder" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
				<head>
					<meta charset="utf-8">
					<meta name="renderer" content="webkit|ie-comp|ie-stand">
					<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
					<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
					<meta http-equiv="Cache-Control" content="no-siteapp" />
					<!--[if lt IE 9]>
						<script type="text/javascript" src="lib/html5.js"></script>
						<script type="text/javascript" src="lib/respond.min.js"></script>
					<![endif]-->
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui/css/H-ui.min.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/H-ui.admin.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/lib/Hui-iconfont/1.0.8/iconfont.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/skin/default/skin.css" id="skin" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/style.css" />
					<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
					<link href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css" rel="stylesheet">
					<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
					<!--[if IE 6]>
						<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
						<script>DD_belatedPNG.fix('*');</script>
					<![endif]-->
					<!--/meta 作为公共模版分离出去-->
					<title></title>
					<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
					<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。"></head>
				<body>
					<article class="cl pd-20" style="margin-right:50px;">
						<form action="#" method="post" class="form form-horizontal" id="form-admin-add" style="line-height: 30px;margin-left:30px">
							<!-- purchaseorder表 -->
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">
									<span class="c-red"></span>采购单号</label>
								<div class="formControls col-xs-8 col-sm-3">
									<input type="text" class="input-text" value="${orderId}" id="id" name="" disabled="disabled" style="height: 30px"></div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">审核状态：</label>
								<div class="formControls col-xs-8 col-sm-3">
									<select style="margin-left:10px" name="auditStateId" id="auditStateId">
										<option value="1">未审核</option></select>
								</div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">签收状态：</label>
								<div class="formControls col-xs-8 col-sm-3">
									<select style="margin-left:10px" name="isSignin" id="isSignin">
										<option value="0">未签收</option></select>
								</div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">包含材料：</label>
								<div class="formControls col-xs-8 col-sm-8">
									<span style="display:inline-block;width:105px">零件型号</span>
									<span>数量</span>
								</div>
									<c:forEach var="item" items="${material}">
										<div style="margin-left:138px"  class="formControls col-xs-8 col-sm-8">
											<span style="display:inline-block;width:100px" class="partType">${item.partType.partType }</span>
											<span class="orderNum">${item.missNum}</span>
											<span style="display:none" class="partTypeId">${item.partType.id }</span>
										</div>
									</c:forEach>
							</div>
							<div class="row cl" style="margin-top:40px">
								<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
									<input class="btn btn-primary radius" type="button" id="sub" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"></div>
							</div>
						</form>
					</article>
					<!--_footer 作为公共模版分离出去-->
					<script type="text/javascript" src="${pageContext.request.contextPath }/statics/lib/jquery/1.9.1/jquery.min.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath }/statics/lib/layer/2.4/layer.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath }/statics/static/h-ui/js/H-ui.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath }/statics/static/h-ui.admin/js/H-ui.admin.page.js"></script>
					<!--/_footer /作为公共模版分离出去-->
					<!--请在下方写此页面业务相关的脚本-->
					<script type="text/javascript" src="${pageContext.request.contextPath }/statics/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath }/statics/lib/jquery.validation/1.14.0/validate-methods.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath }/statics/lib/jquery.validation/1.14.0/messages_zh.js"></script>
					<script type="text/javascript">
						$("#sub").click(function(){
							var partTypeIdList='';
							var orderNumList='';
							var id = $("#id").val();
							$(".partTypeId").each(function(){
								partTypeIdList += $(this).text()+",";
							});
							$(".orderNum").each(function(){
								orderNumList += $(this).text()+",";
							});
							partTypeIdList = partTypeIdList.substring(0,partTypeIdList.lastIndexOf(","));
							orderNumList = orderNumList.substring(0,orderNumList.lastIndexOf(","));
							
							$.post("dopurchaseaskadd",{'materialId':id,'partTypeIdList':partTypeIdList,'orderNumList':orderNumList},function(data){
								if(data=="true"){
									layer.msg('发布完成!', {
										icon : 1,
										time : 1000
									},function(){
										parent.location.reload();
									});
								}else if(data=="false"){
									layer.msg('参数异常!', {
										icon : 2,
										time : 1000
									},function(){
										
									});
								}
							},"text");
						});
					</script>
				</body>
			</html>