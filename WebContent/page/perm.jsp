<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link
			href="${pageContext.request.contextPath}/statics/assets/css/bootstrap.min.css"
			rel="stylesheet" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/statics/css/style.css" />
		<link
			href="${pageContext.request.contextPath}/statics/assets/css/codemirror.css"
			rel="stylesheet">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/statics/assets/css/ace.min.css" />
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/statics/font/css/font-awesome.min.css" />
			<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
			<script
				src="${pageContext.request.contextPath}/statics/js/jquery-1.9.1.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/statics/assets/js/bootstrap.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/statics/assets/js/typeahead-bs2.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/statics/assets/js/jquery.dataTables.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/statics/assets/js/jquery.dataTables.bootstrap.js"></script>
			<script
				src="${pageContext.request.contextPath}/statics/assets/layer/layer.js"
				type="text/javascript"></script>
			<script
				src="${pageContext.request.contextPath}/statics/assets/laydate/laydate.js"
				type="text/javascript"></script>
			<script
				src="${pageContext.request.contextPath}/statics/js/dragDivResize.js"
				type="text/javascript"></script>
			<title>添加权限</title>
</head>

<body>
	<div class="Competence_add_style clearfix">
		<div class="left_Competence_add">
			<div class="title_name">添加权限</div>
			<div class="Competence_add">
			
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="permNameC"> 权限名称 </label>
					<div class="col-sm-9">
						<input type="text" id="permNameC" placeholder="" name="权限名称"
							class="col-xs-10 col-sm-5" />&nbsp;&nbsp;&nbsp;
						<span id="permNameCMess" style="color: Red;"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="permNameE"> 权限标识 </label>
					<div class="col-sm-9">
						<input type="text" id="permNameE" placeholder="" name="权限标识"
							class="col-xs-10 col-sm-5" />&nbsp;&nbsp;&nbsp;
						<span id="permNameEMess" style="color: Red;"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="permURL"> 权限链接 </label>
					<div class="col-sm-9">
						<input type="text" id="permURL" placeholder="" name="权限链接"
							class="col-xs-10 col-sm-5" />&nbsp;&nbsp;&nbsp;
						<span id="permURLMess" style="color: Red;"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="permLevel"> 权限等级 </label>
					<div class="col-sm-9">
						<select id="permLevel" style="margin-left:10px">
							<option value="-1">请选择</option>
							<option value="0">1</option>
							<option value="1">2</option>
							<option value="2">3</option>
						</select>&nbsp;&nbsp;&nbsp;
						<span id="permLevelMess" style="color: Red;"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="parentPermId"> 父级权限 </label>
					<div class="col-sm-9">
						<select id="parentPermId" style="margin-left:10px">
							<option value="-1">请选择权限等级</option>
						</select>&nbsp;&nbsp;&nbsp;
						<span id="parentPermIdMess" style="color: Red;"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="permDesc"> 权限描述 </label>
					<div class="col-sm-9">
						<textarea name="权限描述" class="form-control" id="permDesc"
							placeholder="" onkeyup="checkLength(this);"></textarea>
						<span class="wordage">剩余字数：<span id="sy"
							style="color: Red;">200</span>字
						</span>
					</div>
				</div>
				
				<!--按钮操作-->
				<div class="Button_operation">
					<button
						class="btn btn-primary radius" type="button" id="submit">
						<i class="fa fa-save "></i> 保存并提交
					</button>
					<button id="back"
						class="btn btn-secondary  btn-warning" type="button" onclick="javascript:history.go(-1)">
						<i class="fa fa-reply"></i> 返回上一步
					</button>
					<button class="btn btn-default radius"	
						type="button" id="reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
				</div>
			</div>
		</div>
		<!--权限分配-->
		<div class="Assign_style">
			<div class="title_name">权限分配</div>
			<div class="form-group" style="width:469px;padding-top:20px;">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-field-1"> 角色选择 </label>
					<div class="col-sm-9">
						<!-- 遍历除人事之外的角色信息 -->
						<c:forEach var="item" items="${roleList }">
							<label class="middle"><input class="ace" type="radio"
								name="roleCheck" id="id-disable-check" value="${item.id }" /><span
								class="lbl">${item.roleName }</span></label>
						</c:forEach>

					</div>
				</div>
			<div class="Select_Competence">




				<!-- 显示权限集合 -->
				<c:forEach var="item" items="${permList }">
					<dl class="permission-list">
						<dt>
							<label class="middle"> <input name="user-Character-0"
								class="ace" type="checkbox" id="id-disable-check" value="${item.id }" permName="${item.permNameC }" permLevel="${item.permLevel }"/> <span
								class="lbl">${item.permNameC }</span>
							</label>
						</dt>
						<dd>
							<c:forEach var="item1" items="${item.permListLv2 }">
								<dl class="cl permission-list2">
									<dt>
										<label class="middle"> <input type="checkbox"
											value="${item1.id }" class="ace" name="user-Character-0-0"
											id="id-disable-check" permName="${item1.permNameC }" permLevel="${item1.permLevel }"/> <span class="lbl">${item1.permNameC}</span>
										</label>
									</dt>

									<dd>
											<label class="middle" style="line-height: 30px"><span class="lbl">&nbsp;</span>
											</label>
										<c:forEach var="item2" items="${item1.permListLv3 }">
											<label class="middle"><input type="checkbox"
												value="${item2.id }" class="ace" name="user-Character-0-0-0"
												id="user-Character-0-0-0" permName="${item2.permNameC }" permLevel="${item2.permLevel }"/> <span class="lbl">${item2.permNameC }</span>
											</label>
										</c:forEach>
									</dd>
								</dl>
							</c:forEach>
						</dd>
					</dl>
				</c:forEach>



			</div>

		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(function(){
		// 禁用所有权限 直到选择角色以后
		$("input[type='checkbox']").prop("disabled",true);
	});
	//点击重置按钮后触发
	$("#reset").click(function(){
		$("#permNameC").val("");
		$("#permNameE").val("");
		$("#permURL").val("");
		$("#permLevel").val("-1");
		$("#parentPermId").val("-1");
		$("#permDesc").val("");
		$("#sy").html("200");
	});
	//添加权限
	$("#submit").click(function(){
		var permNameC = $("#permNameC").val();
		if(permNameC==""){
			$("#permNameCMess").html("权限名称为必填项");
			$("#parentPermIdMess").html("");
			$("#permLevelMess").html("");
			$("#permNameEMess").html("");
			return;
		}
		var permNameE = $("#permNameE").val();
		if(permNameE==""){
			$("#permNameEMess").html("权限标识为必填项");
			$("#permNameCMess").html("");
			$("#parentPermIdMess").html("");
			$("#permLevelMess").html("");
			return;
		}
		var permURL = $("#permURL").val();
		if(permURL==""){
			permURL='/';
		}
		var permLevel = $("#permLevel").val();
		if(permLevel=="-1"){
			$("#permLevelMess").html("权限等级为必选项");
			$("#permNameEMess").html("");
			$("#permNameCMess").html("");
			$("#parentPermIdMess").html("");
			return;
		}
		var parentPermId = $("#parentPermId").val();
		if(parentPermId=="-3"){
			$("#parentPermIdMess").html("父级权限为必选项");
			$("#permLevelMess").html("");
			$("#permNameEMess").html("");
			$("#permNameCMess").html("");
			return;
		}
		var permDesc = $("#permDesc").val();
		$.post("addPerm",{'permNameC':permNameC,'permNameE':permNameE,'permURL':permURL,'permLevel':permLevel,'parentPermId':parentPermId,'permDesc':permDesc},function(result){
			layer.msg('已保存', {
				icon : 1,
				time : 3000
			},function(){
				window.location.reload();
			});
		},"text");
	});
	//选择权限等级后更新父级权限下拉列表的值
	$("#permLevel").change(function(){
		var permLevel = $(this).val();
		if(permLevel==-1){
			$("#parentPermId").html("<option value='-1'>请选择权限等级</option>");
			$("#permURL").prop("disabled",false);
			return;
		}else if(permLevel==0){
			$("#parentPermId").html("<option value='-1'>无父级权限</option>");
			$("#permURL").val("");
			$("#permURL").prop("disabled",true);
		}else{
			$("#permURL").prop("disabled",false);
			$.post("getPermByLevel?permLevel="+permLevel,null,function(data){
				var parentPerm = "<option value='-3'>请选择父级权限</option>";
				for(i in data){
					parentPerm+="<option value='"+data[i].id+"'>"+data[i].permNameC+"</option>";
				}
				$("#parentPermId").html(parentPerm);
			},"json");
		}
	});
	// 权限选择后触发事件，包括添加权限
	$("input[type='checkbox']").change(function(){
		roleId = $("input[name='roleCheck']:checked").val();
		var permIds1=[];
		$("input[type='checkbox']:checked").each(function(i){
			permIds1.push($(this).val());
		});
		//将数组转换成字符串
		permIds = permIds1.join(",");
		//删除所有与当前选中角色相关的角色权限数据
		  $.post("insertRolePerm",{'permIds':permIds,'roleId':roleId},function(result){
			  layer.msg('已保存', {
					icon : 1,
					time : 1000
				});
		},"text");
	});
	//角色选择后触发事件
	$("input[name='roleCheck']").change(function() {
		//解除禁用
		$("input[type='checkbox']").prop("disabled",false);
		//先清除所有checkbox选中
		$("input[type='checkbox']").prop("checked",false);
		//获取选中角色的ID
		roleId = $("input[name='roleCheck']:checked").val();
		if(roleId!=""){
			//根据角色ID获取角色权限并打勾
			$.post("getPermByRole?id="+roleId,null,function(data){
				if(data==""){return;}
				var perm1 =  data;
				for(i in perm1){
					$("input[permName='"+perm1[i].permNameC+"']").each(function(index,element){
						$(element).prop("checked",true);
					});
					var perm2=perm1[i].permListLv2;
					for(j in perm2){
						$("input[permName='"+perm2[j].permNameC+"']").each(function(index,element){
							$(element).prop("checked",true);
						});
						var perm3=perm2[j].permListLv3;
						for(k in perm3){
							$("input[permName='"+perm3[k].permNameC+"']").each(function(index,element){
								$(element).prop("checked",true);
							});
						}
					}
				}
			},"json");
		}
	});

	//初始化宽度、高度  
	$(".left_Competence_add,.Competence_add_style").height($(window).height()).val();
	;
	$(".Assign_style").width($(window).width() - 500)
			.height($(window).height()).val();
	$(".Select_Competence").width($(window).width() - 500).height(
			$(window).height() - 40).val();
	//当文档窗口发生改变时 触发  
	$(window).resize(
			function() {
				$(".Assign_style").width($(window).width() - 500).height(
						$(window).height()).val();
				$(".Select_Competence").width($(window).width() - 500).height(
						$(window).height() - 40).val();
				$(".left_Competence_add,.Competence_add_style").height(
						$(window).height()).val();
				;
			});
	/*字数限制*/
	function checkLength(which) {
		var maxChars = 200; //
		if (which.value.length > maxChars) {
			layer.open({
				icon : 2,
				title : '提示框',
				content : '您出入的字数超多限制!',
			});
			// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
			which.value = which.value.substring(0, maxChars);
			return false;
		} else {
			var curr = maxChars - which.value.length; //250 减去 当前输入的
			document.getElementById("sy").innerHTML = curr.toString();
			return true;
		}
	};
	/*按钮选择*/
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
							var l2 = $(this).parents(".permission-list").find(
									".permission-list2 dd").find(
									"input:checked").length;
							if ($(this).prop("checked")) {
								$(this).closest("dl").find("dt input:checkbox")
										.prop("checked", true);
								$(this).parents(".permission-list").find("dt")
										.first().find("input:checkbox").prop(
												"checked", true);
							} else {
								if (l == 0) {
									$(this).closest("dl").find(
											"dt input:checkbox").prop(
											"checked", false);
								}
								if (l2 == 0) {
									$(this).parents(".permission-list").find(
											"dt").first()
											.find("input:checkbox").prop(
													"checked", false);
								}
							}

						});
	});
</script>
