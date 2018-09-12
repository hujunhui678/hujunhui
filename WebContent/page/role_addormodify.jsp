<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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
<!--/meta 作为公共模版分离出去-->
<title></title>
<style type="text/css">
#form-admin-role-add {
	position: relative;
	left: -50px;
	top: 10px;
}
</style>
</head>
<body>
	<article class="cl pd-20">
	<!-- 添加角色 -->
	 <c:if test="${param.roleUpdate!='yes' }">
		<form action="#" method="post" class="form form-horizontal"
			id="form-admin-role-add">
			<span class="" id="warningRoleName"
				style="display: none; margin-left: 200px;"> </span>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>角色名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="roleName" name="roleName" datatype="*4-16" nullmsg="用户账户不能为空">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">描述：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="" id="roleDesc"
						name="roleDesc">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<button type="button" class="btn btn-success radius"
						id="admin-role-save" name="admin-role-save">
						<i class="icon-ok"></i> 确定
					</button>
				</div>
			</div>
		</form>
	</c:if>
	<!-- 修改角色 -->
	<c:if test="${param.roleUpdate=='yes' }">
		<form action="#" method="post" class="form form-horizontal"
			id="uform-admin-role-add">
			<input type="hidden" id="uid" value="${param.id }">
			<input type="hidden" id="urolename" value="${param.roleName }">
			<input type="hidden" id="uroledesc" value="${param.roleDesc }">
			<span class="" id="uWarningRoleName"
				style="display: none; margin-left: 200px;"> </span>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>角色名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""
						id="uRoleName" name="roleName" datatype="*4-16" nullmsg="用户账户不能为空"
						value="${param.roleName }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">描述：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="" id="uRoleDesc"
						name="uRoleDesc" value="${param.roleDesc }">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<button type="button" class="btn btn-success radius"
						id="uAdmin-role-save" name="admin-role-save">
						<i class="icon-ok"></i> 确定
					</button>
				</div>
			</div>
		</form>
	</c:if>
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
			$(".permission-list dt input:checkbox").click(
					function() {
						$(this).closest("dl").find("dd input:checkbox").prop(
								"checked", $(this).prop("checked"));
					});
			$(".permission-list2 dd input:checkbox")
					.click(
							function() {
								var l = $(this).parent().parent().find(
										"input:checked").length;
								var l2 = $(this).parents(".permission-list")
										.find(".permission-list2 dd").find(
												"input:checked").length;
								if ($(this).prop("checked")) {
									$(this).closest("dl").find(
											"dt input:checkbox").prop(
											"checked", true);
									$(this).parents(".permission-list").find(
											"dt").first()
											.find("input:checkbox").prop(
													"checked", true);
								} else {
									if (l == 0) {
										$(this).closest("dl").find(
												"dt input:checkbox").prop(
												"checked", false);
									}
									if (l2 == 0) {
										$(this).parents(".permission-list")
												.find("dt").first().find(
														"input:checkbox").prop(
														"checked", false);
									}
								}
							});
			$("#form-admin-role-add").validate({
				rules : {
					roleName : {
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
			// 添加角色名查重
			$("#roleName").blur(
					function() {
						var roleName = $(this).val();
						if (roleName == "") {
							$("#warningRoleName").hide();
							$("#admin-role-save").attr("disabled", "disabled");
							return;
						}
						$.post("chachong?roleName=" + roleName, null, function(
								data) {
							if (data == "true") {
								$("#warningRoleName").attr("class",
										"label label-success arrowed").show()
										.html("可用");
								$("#admin-role-save").removeAttr("disabled");
							} else if (data == "false") {
								$("#warningRoleName").attr("class",
										"label label-sm label-warning").show()
										.html("角色名重复");
								$("#admin-role-save").attr("disabled",
										"disabled");
							} else {
								$("#warningRoleName").attr("display", "none");
							}
						})
					});
			//修改角色名查重
			$("#uRoleName").blur(
					function() {
						var selfRoleName = $("#urolename").val();
						var roleName = $(this).val();
						if (roleName == "") {
							$("#uWarningRoleName").hide();
							$("#uAdmin-role-save").attr("disabled", "disabled");
							return;
						}
						if(selfRoleName==roleName){
							$("#uWarningRoleName").attr("class",
							"label label-success arrowed").show()
							.html("可用");
							$("#uAdmin-role-save").removeAttr("disabled");
							return;
						}
						$.post("chachong?roleName=" + roleName, null, function(
								data) {
							if (data == "true") {
								$("#uWarningRoleName").attr("class",
										"label label-success arrowed").show()
										.html("可用");
								$("#uAdmin-role-save").removeAttr("disabled");
							} else if (data == "false") {
								$("#uWarningRoleName").attr("class",
										"label label-sm label-warning").show()
										.html("角色名重复");
								$("#uAdmin-role-save").attr("disabled",
										"disabled");
							} else {
								$("#uWarningRoleName").attr("display", "none");
							}
						})
					});
			
			// 添加表单提交
			$("#admin-role-save").click(
					function() {
						var roleName = $("#roleName").val();
						var roleDesc = $("#roleDesc").val();
						if(roleName==""){
							return;
						}
						$.post("addRole?roleName=" + roleName + "&roleDesc="
								+ roleDesc, null, function(data) {
							layer.msg('添加成功!', {
	     						icon : 1,
	     						time : 1000
	     					},function(){
	     						parent.location.reload();
								layer_close();
	     						});
						});
						
					});
			});
			// 修改表单提交
			$("#uAdmin-role-save").click(function(){
				var id = $("#uid").val();
				var oldRoleName = $("#urolename").val();
				var oldRoleDesc = $("#uroledesc").val();
				var newRoleName = $("#uRoleName").val();
				var newRoleDesc =$("#uRoleDesc").val();
				if(newRoleName==""){
					return;
				}
				if(oldRoleName==newRoleName&&oldRoleDesc==newRoleDesc){
					layer_close();
					return;
				}
				$.post("updateRole?id="+id+"&roleName="+newRoleName+"&roleDesc="+newRoleDesc,null,function(){
					layer.msg('修改成功!', {
 						icon : 1,
 						time : 1000
 					},function(){
 						parent.location.reload();
						layer_close();
 						});
				})
			});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>