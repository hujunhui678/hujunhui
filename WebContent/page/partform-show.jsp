<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<style type="text/css">
	tr{
		line-height:42px;
	}
</style>
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
	href="${pageContext.request.contextPath }/statics/assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/font-awesome-ie7.min.css" />
<script
	src="${pageContext.request.contextPath }/statics/assets/js/jquery.min.js"></script>
<title>配方查看</title>
</head>
<body>
	<div class="member_show">
		<div class="member_jbxx clearfix">
			<img class="img"
				src="${pageContext.request.contextPath }/statics/images/user.png">
			<dl class="right_xxln">
				<dt>
					编写人: <span class="" id="name"
						style="display: inline-block; padding: 20px 0 0 5px; color: black; font-size: 14px;"></span>
				</dt>
			</dl>
		</div>
		<div class="member_content">
			<input type="hidden" id="id" value="${param.id}" />
			<div style="margin: 10px 0 0 50px;font-size: 16px;">
				<span class="">成品名：</span><span id="productName"></span> 
				<span style="display:inline-block;margin:  0 0 0 35px;">
					<span class="">创建时间：</span> <span id="time"></span>
				</span>
			</div>
			<br>
			<table border="0" width="90%"  style="font-size: 14px;font-size: 16px;" align="left">
				<tr class="title" align="center">
					<td>零件类型</td>
					<td>零件分类</td>
					<td>数量</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			//进入修改控制器，获取要修改的人员的信息
			var id = $("#id").val();
			$.post("getPartForm", {
				'id' : id
			}, function(data) {
				var partFormulaDesc = data[0].partFormulaDesc;//配方详情表
				var finishedProductsType = data[0].finishedProductsType;//成品类型
				var partType = data[0].partType;//零件类别
				var partClassify = data[0].partClassify;//零件分类
				for (var i = 0; i < partFormulaDesc.length; i++) {
					$(".title").after(
							"'<tr align='center'><td>" + partType[i].partType + "</td><td>"
									+ partClassify[i].partName + "</td><td>"
									+ partFormulaDesc[i].requirement
									+ "</td></tr>'");
				}
				$("#name").text(data[0].admin.name);
				$("#productName").text(finishedProductsType.productName);
				$("#time").text(data[0].createTime.substring(0, 10));
			}, "json");
		});
	</script>
</body>
</html>
