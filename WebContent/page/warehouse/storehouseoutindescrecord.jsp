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
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui/css/H-ui.min.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/H-ui.admin.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/lib/Hui-iconfont/1.0.8/iconfont.css" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/skin/default/skin.css" id="skin" />
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/style.css" />
					<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
					<link href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css" rel="stylesheet">
					<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
					<title></title>
				<body>
					<article class="cl pd-20" style="margin-right:50px;">
						<form action="#" method="post" class="form form-horizontal" id="form-admin-add" style="line-height: 30px;margin-left:30px">
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">
									<span class="c-red"></span>记录单号</label>
								<div class="formControls col-xs-8 col-sm-3">
									<span style="display:inline-block;margin-top:2px">${storeHouse.id}</span>
								</div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">
									<span class="c-red"></span>状态</label>
								<div class="formControls col-xs-8 col-sm-3">
									<span style="display:inline-block;margin-top:2px">
										<c:if test="${storeHouse.isOut==1 }">
											出库
										</c:if>
										<c:if test="${storeHouse.isOut==2 }">
											入库
										</c:if>
									</span>
								</div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">
									<span class="c-red"></span>时间</label>
								<div class="formControls col-xs-8 col-sm-3">
									<span style="display:inline-block;margin-top:2px">${storeHouse.time}</span>
								</div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">
									<span class="c-red"></span>负责人姓名</label>
								<div class="formControls col-xs-8 col-sm-3">
									<span style="display:inline-block;margin-top:2px">${storeHouse.principalAdmin.name}</span>
								</div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">
									<span class="c-red"></span>领用/发布部门</label>
								<div class="formControls col-xs-8 col-sm-3">
									<span style="display:inline-block;margin-top:2px">
										<c:if test="${storeHouse.isOut==1 }">
											${storeHouse.leadingDepartment.deptName}
										</c:if>
										<c:if test="${storeHouse.isOut==2 }">
											${storeHouse.releaseDept.deptName}
										</c:if>
									</span>
								</div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">
									<span class="c-red"></span>领用/发布人</label>
								<div class="formControls col-xs-8 col-sm-3">
									<span style="display:inline-block;margin-top:2px">
										<c:if test="${storeHouse.isOut==1 }">
											${storeHouse.receiveAdmin.name}
										</c:if>
										<c:if test="${storeHouse.isOut==2 }">
											${storeHouse.releasePerson.name}
										</c:if>
									</span>
								</div>
							</div>
							<div class="row cl">
								<label class="form-label col-xs-4 col-sm-3">
									<span class="c-red"></span>物料详情</label>
								<div  style="display:inline-block;margin-top:3px;height:170px" class="formControls col-xs-8 col-sm-3">
									<c:if test="${storeHouse.isOut==1 }">
										<span style="display:inline-block;width:120px">零件名</span><span style="width:200px">数量</span>
										<c:forEach var="item" items="${storeHouse.storeHouseOutInDescRecordList }">
											<div>
												<span style="display:inline-block;width:120px">${item.partType.partType}</span><span style="width:200px">${item.num }</span>
											</div>
										</c:forEach>
									</c:if>
									<c:if test="${storeHouse.isOut==2 }">
										<span style="display:inline-block;width:120px">成品类型名</span><span style="width:200px">数量</span>
										<c:forEach var="item" items="${storeHouse.storeHouseOutInDescRecordList }">
											<div>
												<span style="display:inline-block;width:120px">${item.finishedProductsType.productType }</span><span style="width:200px">${item.num }</span>
											</div>
										</c:forEach>
									</c:if>
								</div>
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
					</script>
				</body>
			</html>