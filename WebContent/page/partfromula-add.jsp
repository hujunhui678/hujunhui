<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link
	href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/style.css" />
<link
	href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/Widget/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/font-awesome.min.css" />
<link
	href="${pageContext.request.contextPath }/statics/Widget/icheck/icheck.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/statics/Widget/webuploader/0.1.5/webuploader.css"
	rel="stylesheet" type="text/css" />

<title>新增图片</title>
</head>
<body>
	<div class="clearfix" id="add_picture">
		<div id="scrollsidebar" class="left_Treeview">
			<div class="show_btn" id="rightArrow">
				<span></span>
			</div>
			<div class="widget-box side_content">
				<div class="side_title">
					<a title="隐藏" class="close_btn" id="hide"><span></span></a>
				</div>
				<div class="side_list">
					<div class="widget-header header-color-green2">
						<h4 class="lighter smaller">选择产品类型</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main padding-8">
							<div id="treeDemo" class="ztree"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="page_right_style">
			<div class="type_title">编写配方</div>
			<form action="#" method="post" class="form form-horizontal"
				id="form-article-add">
				<input type="hidden" class="input-text" value="${admin.id}"
					placeholder="" id="adminId" name="">
				<div class="clearfix cl">
					<label class="form-label col-2"><span class="c-red">*</span>配方名称：</label>
					<div class="formControls col-10">
						<input type="text" class="input-text" value="" placeholder=""
							id="formulaName" name="">
					</div>
				</div>
				<div class=" clearfix cl">
					<div class="Add_p_s">
						<label class="form-label col-2">成品类型：</label>
						<div class="formControls col-2">
							<select class="select" id="finishId">
								<option>请选择</option>
								<c:forEach var="finish" items="${finish}">
									<option value="${finish.id}">${finish.productName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="
									Add_p_s" id="inputNum">
						<label class="form-label col-2">所需零件数量：</label>
						<div class="formControls col-2">
							<select class="select" id="select">
								<option>请选择</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div>

					<div id="num" class="one">
						<div class='Add_p_s'></div>
						<div class='Add_p_s'></div>
						<div class='Add_p_s'></div>
						<div class='Add_p_s'></div>
						<div class='Add_p_s'></div>
						<div class='Add_p_s'></div>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2">立即启用 ：</label>
					<div class="formControls col-2 skin-minimal">
						<div class="check-box" style="margin-top: 9px">
							<input type="checkbox" id="checkbox-1"><label
								for="checkbox-1">&nbsp;</label>
						</div>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2">内容摘要：</label>
					<div class="formControls col-10">
						<textarea name="" cols="" rows="" class="textarea"
							placeholder="说点什么...最少输入10个字符" datatype="*10-100"
							dragonfly="true" nullmsg="备注不能为空！"
							onKeyUp="textarealength(this,200)"></textarea>
						<p class="textarea-numberbar">
							<em class="textarea-length">0</em>/200
						</p>
					</div>
				</div>
				<div class="clearfix cl">
					<div class="Button_operation">
						<button class="btn btn-primary radius" type="button" id="submit">
							<i class="icon-save "></i>保存并提交审核
						</button>
						<button onClick="article_save();"
							class="btn btn-secondary  btn-warning" type="button">
							<i class="icon-save"></i>保存草稿
						</button>
						<button onclick="javascript:history.go(-1)"
							class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery-1.9.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/assets/js/typeahead-bs2.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/assets/layer/layer.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath }/statics/assets/laydate/laydate.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/Widget/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/Widget/icheck/jquery.icheck.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/Widget/Validform/5.3.2/Validform.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/Widget/webuploader/0.1.5/webuploader.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/Widget/ueditor/1.4.3/ueditor.config.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/Widget/ueditor/1.4.3/ueditor.all.min.js"> </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/Widget/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
	<script src="${pageContext.request.contextPath }/statics/js/lrtk.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/js/H-ui.admin.js"></script>
	<script>
$(function() { 
	$("#inputNum").change(function(){
		var inputNum = $("#select").val();
		$(".num").remove();
		$.post("getPart",null,function(data){
			var partClassies = data.partClassies;
			var partTypes = data.partTypes;
			for (var i = 0; i < inputNum; i++) {
				var part ="<div class='num'><div class='Add_p_s'><label class='form-label col-2'>零件类别：</label><div class='formControls col-2'><select class='PartType'>"
				var optionStr = "";	
				var optionClass = "";
				for (j in partTypes) {
						 optionStr += "<option value='"
									+ partTypes[j].id + "'";
							optionStr = optionStr + ">"
									+ partTypes[j].partType
									+ "</option>";
						}
				var last = part+optionStr + "</select></div></div><div class='Add_p_s'><label class='form-label col-2'>分类：</label><div class='formControls col-2'><select class='PartClass'>";
				for (k in partClassies) {
					optionClass += "<option value='"
									+ partClassies[k].id + "'";
					optionClass = optionClass + ">"
									+ partClassies[k].partName
									+ "</option>";
						}
				last = last+ optionClass+ "</select></div></div><div class='Add_p_s'><label class='form-label col-2'>数量：</label><div class='formControls col-2'><input type='text' class='input-text' value='' placeholder=''  name='requ'>个</div></div><div class='Add_p_s'></div></div></div>";
				$("#num").append(last);
			}
		},"json");
		
	});
	$("#add_picture").fix({
		float : 'left',
		skin : 'green',	
		durationTime :false,
		stylewidth:'220',
		spacingw:0,
		spacingh:260,
	});
	
	$("#submit").click(function(){
		var formulaName = $("#formulaName").val();
		var nums = new Array();
		$("input[name='requ']").each(function(i) {
			nums[i] = $(this).val();
		});
		var numsVals = nums.join(",");
		var finishId = $("#finishId").val();
		var parttype = new Array();
		$(".PartType").each(function(i) {
			parttype[i] = $(this).val();
		});
		var PartTypeVals = parttype.join(",");
		
		var PartClass = new Array();
		$(".PartClass").each(function(i) {
			PartClass[i] = $(this).val();
		});
		var PartClassVals = PartClass.join(",");
		var adminId = $("#adminId").val();
		
		$.post("addPartFormula",{
			'formulaName':formulaName,
			'compilers':adminId,
			'finishId':finishId,
			'PartTypeVals':PartTypeVals,
			'PartClassVals':PartClassVals,
			'num':numsVals
			},function(data){
				layer.msg('配方新增成功!', {
					icon : 1,
					time : 1000
				}, function() {
					window.location.href = "${pageContext.request.contextPath }/page/SelPartForm";
				});
		});
		
	});
});
$( document).ready(function(){
//初始化宽度、高度
  
   $(".widget-box").height($(window).height()); 
   $(".page_right_style").height($(window).height()); 
   $(".page_right_style").width($(window).width()-220); 
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){

	 $(".widget-box").height($(window).height()); 
	 $(".page_right_style").height($(window).height()); 
	 $(".page_right_style").width($(window).width()-220); 
	});	
});
$(function(){
	$("#hide").click();
	var ue = UE.getEditor('editor');
});

</script>
</body>
</html>