<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link
	href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
<link
	href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/Widget/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css" />
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
					<a title="隐藏" id="hide" class="close_btn"><span></span></a>
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
			<div class="type_title">编写生产计划</div>
			<form action="${pageContext.request.contextPath }/page/upload"
				method="post" class="form form-horizontal" id="form-article-add"
				enctype="multipart/form-data">
				<input type="hidden" value="${admin.id}" id="adminId" name="compilers"/>
				<input type="hidden" value="${addResult}" id="addResult" />
				<input type="hidden" value="" id="isAudit" />
				<div class=" clearfix cl">
					<div class="Add_p_s">
						<label class="form-label col-2">生产成品：</label>
						<div class="formControls col-2">
							<span class="select-box"> <select class="select"
								id="saveFinishId" name="finishedProductTypeId">
									<option value="0">请选择</option>
									<c:forEach var="fin" items="${finish}">
										<option value="${fin.id}"
											<c:if test="${fin.id eq saveFinishId}">selected</c:if>>${fin.productName}</option>
									</c:forEach>
							</select>
							</span>
						</div>
					</div>
					<div class="Add_p_s">
						<label class="form-label col-2">生产数量：</label>
						<div class="formControls col-2">
							<input type="number" max="50" min="1" class="input-text"
								value="${saveNum}" placeholder="" id="num" name="produceNum" />个
						</div>
					</div>
					<div class="Add_p_s">
						<label class="form-label col-2">配方文献：</label>
						<div class="formControls col-2">
							<span class="select-box"> <select class="select"
								id="formula" style="width: 170px;">
									<option value="0" id="selected">请选择</option>
									<c:forEach var="form" items="${page.lists}">
										<option value="${form.id}"
											<c:if test="${form.id eq id}">selected</c:if>>${form.formulaName}</option>
									</c:forEach>
							</select>
							</span>
						</div>
					</div>
					<div class="Add_p_s" style="margin-left: 50px;">
						<span class="l_f"
							style="display: block; position: relative; top: -2px;"> <a
							href="#" class="btn btn-success Order_form"
							onclick="addReveice()"><i class="fa fa-check-square-o"></i>&nbsp;提交领料单</a>
						</span>
					</div>
				</div>
				<table
					class="table table-border table-bordered table-hover table-bg">
					<thead>
						<tr class="text-c">
							<th width="40">零件编号</th>
							<th width="40">零件类型</th>
							<th width="100">零件分类</th>
							<th width="100">数量</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${PartForm}">
							<c:forEach var="PartType" items="${item.partType}"
								varStatus="index">
								<tr class="text-c" align="center">
									<td class="partId">${item.partType[index.count - 1].id}</td>
									<td class="parttype">${item.partType[index.count - 1].partType}</td>
									<td class="partName">${item.partClassify[index.count - 1].partName}</td>
									<td class="requirement">${item.partFormulaDesc[index.count - 1].requirement * saveNum}</td>
								</tr>
							</c:forEach>
							<%-- 	<c:forEach var="partClassify" items="${item.partClassify}">
								<td>${partClassify.partName}</td>
							</c:forEach>
							<c:forEach var="partFormulaDesc" items="${item.partFormulaDesc}">
								<td>${partFormulaDesc.requirement}</td>
							</c:forEach> --%>
						</c:forEach>
					</tbody>
				</table>
				<div class="clearfix cl" style="width: 500px;">
					<label class="form-label col-2">图片上传：</label>
					<div class="input-group row" style="width: 360px;">
						<div class="col-sm-9 big-photo">
							<div id="preview" style="float: left;">
								<img id="imghead" border="0"
									src="${pageContext.request.contextPath }/statics/images/photo_icon.png"
									width="90" height="90" onclick="$('#previewImg').click();" />
							</div>
							<input type="file" name="fileImage" onchange="previewImage(this)"
								style="display: none;" id="previewImg" />
							<div id="preview" style="padding-top: 30px;font-weight: bolder;color: red; font-size: 15px;width: 370px;">
								<span style="padding-left: 30px;">${msg}</span>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2">详细内容：</label>
					<div class="formControls col-10">
						<script id="editor" type="text/plain"
							style="width: 100%; height: 400px;"></script>
					</div>
				</div>
				<div class="clearfix cl">
					<div class="Button_operation">
						<button onclick="article_save_submit();"
							class="btn btn-primary radius" type="submit">
							<i class="icon-save " ></i>保存并提交审核
						</button>
						<button onClick="article_save();"
							class="btn btn-secondary  btn-warning" type="button">
							<i class="icon-save"></i>保存草稿
						</button>
						<button onClick="layer_close();" class="btn btn-default radius"
							type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/js/JQueryUpload.js"></script>
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
	var id = $("#saveFinishId").val();
	if(id != "0"){
		$("#formula").attr("disabled",true);
	}
	$("#add_picture").fix({
		float : 'left',
		skin : 'green',	
		durationTime :false,
		stylewidth:'220',
		spacingw:0,
		spacingh:260,
	});
	var result = $("#addResult").val();
	if(result == "T"){
		layer.msg('生产计划制定成功!', {
			icon : 1,
			time : 2000
		},function(){
			window.location.href = "${pageContext.request.contextPath }/page/technical";
		});
	}
	
	$("form").submit(function(){
		var isAudit = $("#isAudit").val();
		if(isAudit != "ok"){
			layer.msg('请先提交领料单的审核，在进行添加!', {
				icon : 2,
				time : 2500
			},function(){
				
			});
			return false;
		}
		return true;	
	});
	$("#saveFinishId").change(function(){
		var id = $("#saveFinishId").val();
		if(id != "0"){
			$.post("bingFormula",{'id':id},function(data){
				$("#num").val("");
				$("#formula").children().remove();
				var pfList = data.pfList;//所有配方集合
				var pf = data.pf;//使用的配方
				for (i in pfList) {
					var optionStr = "<option value='"
							+ pfList[i].id + "'";
					if (pf.id == pfList[i].id) {
						optionStr += " selected ";
					}
					optionStr = optionStr + ">"
							+ pfList[i].formulaName
							+ "</option>";
					$("#formula").append(optionStr);
				}
				$("#formula").attr("disabled",true);
			},"json");
		}
	});
	$("#formula").change(function(){
		var id = $("#formula").val();
		var saveFinishId = $("#saveFinishId").val();
		var saveNum = $("#num").val();
		if(saveFinishId == 0){
			layer.msg('请先选择成品!', {
					icon : 2,
					time : 2500
				},function(){
					location.reload();
				});
			return;
		}
		window.location.href = "${pageContext.request.contextPath }/page/toAddForProplan?id="+id+"&saveFinishId="+saveFinishId+"&saveNum="+saveNum;
	});
	
	$("#num").change(function(){
		var num = $("#num").val();
		var id = $("#formula").val();
		var saveFinishId = $("#saveFinishId").val();
		if(num <=0 ){
			layer.msg('至少加工1个吧!', {
				icon : 5,
				time : 2000
			},function(){
				location.reload();
			});
		return;
		}
		if(id != 0 && saveFinishId != 0){
			window.location.href = "${pageContext.request.contextPath }/page/toAddForProplan?id="+id+"&saveFinishId="+saveFinishId+"&saveNum="+num;
		}
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
	<script type="text/javascript">
	function addReveice(){
		var id = $("#formula").val();
		if(id == "0"){
			layer.msg('请先制定生产计划,ok?', {
				icon : 5,
				time : 2000
			},function(){
				
			});
			return;
		}
		layer.confirm('是否提交至主管进行审核?', {icon:3}, function() {
			var adminId = $("#adminId").val();
			var partId = new Array();
			$(".partId").each(function(i) {
				partId[i] = $(this).text();
			});
			var partIdVals = partId.join(",");

			var requirement = new Array();
			$(".requirement").each(function(i) {
				requirement[i] = $(this).text();
			});
			var RequirementVals = requirement.join(",");
			$.post("addReveice",{'partIds':partIdVals,'Requirements':RequirementVals,'adminId':adminId},function(data){
				if(data == "true"){
					//提交审核成功，做个标识..
					layer.msg('提交审核成功!请及时提交生产规划..', {
						icon : 1,
						time : 2000
					},function(){
						$("#isAudit").val("ok");
					});
				}
			});
		});
	}
	  //图片上传预览    IE是用了滤镜。
    function previewImage(file)
    {
      var MAXWIDTH  = 90; 
      var MAXHEIGHT = 90;
      var div = document.getElementById('preview');
      if (file.files && file.files[0])
      {
          div.innerHTML ='<img id=imghead onclick=$("#previewImg").click()>';
          var img = document.getElementById('imghead');
          img.onload = function(){
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            img.width  =  rect.width;
            img.height =  rect.height;
//             img.style.marginLeft = rect.left+'px';
            img.style.marginTop = rect.top+'px';
          }
          var reader = new FileReader();
          reader.onload = function(evt){img.src = evt.target.result;}
          reader.readAsDataURL(file.files[0]);
      }
      else //兼容IE
      {
        var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
        file.select();
        var src = document.selection.createRange().text;
        div.innerHTML = '<img id=imghead>';
        var img = document.getElementById('imghead');
        img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
        status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
        div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
      }
    }
    function clacImgZoomParam( maxWidth, maxHeight, width, height ){
        var param = {top:0, left:0, width:width, height:height};
        if( width>maxWidth || height>maxHeight ){
            rateWidth = width / maxWidth;
            rateHeight = height / maxHeight;
            
            if( rateWidth > rateHeight ){
                param.width =  maxWidth;
                param.height = Math.round(height / rateWidth);
            }else{
                param.width = Math.round(width / rateHeight);
                param.height = maxHeight;
            }
        }
        param.left = Math.round((maxWidth - param.width) / 2);
        param.top = Math.round((maxHeight - param.height) / 2);
        return param;
    }
</script>
</body>
</html>