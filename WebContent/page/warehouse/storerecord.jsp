<%@page import="java.net.URLDecoder" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
				<head>
					<meta charset="utf-8">
					<meta name="renderer" content="webkit|ie-comp|ie-stand">
					<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
					<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
					<meta http-equiv="Cache-Control" content="no-siteapp" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui/css/H-ui.min.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/H-ui.admin.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/lib/Hui-iconfont/1.0.8/iconfont.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/skin/default/skin.css" id="skin" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/style.css" />
					<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
					<link href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css" rel="stylesheet">
					<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
      				<script src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
 					<link href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css" rel="stylesheet" />
					<title></title>
				</head>
				<body>
					<c:if test="${emptyMsg==1}">
						
						<div style="width:630px;text-align: center;height:500px;margin-top:150px">
							<div class="text-warning bigger-180 orange">
							<i class="ace-icon fa fa-exclamation-triangle"></i>
							选中零件没有出入库记录</div>
						</div>
					</c:if>
					<c:if test="${emptyMsg!=1}">
					<article class="cl pd-20" style="margin-right:50px;">
							<form action="#" method="post" class="form form-horizontal" id="form-admin-add" style="line-height: 30px;margin-left:30px">
								
								<c:if test="${record[0].storeHouseOutInDescRecordList[0].partType!=null and isLj==1 }">
									<div class="row cl">
										<label class="form-label col-xs-4 col-sm-3">
											<span class="c-red"></span>零件名</label>
										<div class="formControls col-xs-8 col-sm-3">
											<span style="display:inline-block;margin-top:2px">${record[0].storeHouseOutInDescRecordList[0].partType.partType}</span>
										</div>
									</div>
								</c:if>
								<c:if test="${record[0].storeHouseOutInDescRecordList[0].finishedProductsType!=null and isLj==2 }">
									<div class="row cl">
										<label class="form-label col-xs-4 col-sm-3">
											<span class="c-red"></span>成品名</label>
										<div class="formControls col-xs-8 col-sm-3">
											<span style="display:inline-block;margin-top:2px">${record[0].storeHouseOutInDescRecordList[0].finishedProductsType.productType}</span>
										</div>
									</div>
								</c:if>
								<div class="row cl" style="margin-top:20px">
									<div style="display:block;margin:0 auto;"><label style="display:inline-block;width:560px;text-align:center"><span class="c-red"></span>状态变更详情</label></div>
								<div  style="display:inline-block;margin-top:3px;height:170px" class="formControls col-xs-8 col-sm-8">
										<table style="margin-top:20px;margin-left:80px" class="table">
											<tr>
												<th style="width:70px"><span style="display:inline-block;text-align: center;width:130px">入库/出库</span></th>
												<th style="width:50px"><span style="display:inline-block;text-align: center;width:50px">数量</span></th>
												<th style="width:150px"><span style="display:inline-block;text-align: center;width:150px">时间</span></th>
											</tr>
										
										<c:forEach var="item" items="${record}" varStatus="index">
											<c:forEach var="item2" items="${record[index.count-1].storeHouseOutInDescRecordList}">
												<tr>
													<td style="width:70px"><span style="display:inline-block;text-align: center;width:130px"><c:if test="${item.isOut==1 }">出库</c:if><c:if test="${item.isOut==2 }">入库</c:if></span></td>
													<td style="width:50px"><span style="display:inline-block;text-align: center;width:50px">${item2.num }</span></td>
													<td style="width:150px"><span style="display:inline-block;text-align: center;width:150px">${fn:substring(item.time,0,16)}</span></td>
												</tr>
											</c:forEach>
										</c:forEach>
										</table>
								</div>
							</div>
							</form>
						</c:if>
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
				</body>
			</html>