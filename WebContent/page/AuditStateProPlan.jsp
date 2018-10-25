<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link
	href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/style.css" />
<link
	href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
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
<title></title>
</head>

<body>
	<div class="margin clearfix">
		<div class="detailed_style clearfix">
			<div class="shop_logo">
				<img src=${pageContext.request.contextPath }${ProPlan.imageUrl}  width="180px" height="150px"/>
			</div>
			<ul class="shop_content clearfix">
				<li><label class="label_name">生产产品：</label><span class="info">${ProPlan.finishedProductsType.productName}</span></li>
				<li><label class="label_name">产品类型：</label><span class="info">${ProPlan.finishedProductsType.productType}</span></li>
				<li><label class="label_name"></label><span class="info"></span></li>
				<li><label class="label_name">申请时间：</label><span class="info">
						<fmt:formatDate value="${ProPlan.arrivalTime}"
							pattern="yyyy-MM-dd" />
				</span></li>
				<li><label class="label_name">规定完成：</label><span class="info">
						<fmt:formatDate value="${ProPlan.estimatedTimeOfCompletion}"
							pattern="yyyy-MM-dd" />
				</span></li>
				<li><label class="label_name"></label></li>
				<li><label class="label_name">制定人：</label><span class="info">${ProPlan.admin.name}</span></li>
				<li><label class="label_name">生产数量：</label><span class="info">${ProPlan.produceNum}</span></li>
			</ul>
		</div>
		<div class="Store_Introduction">
			<div class="title_name">规划详情</div>
			<input type="hidden" value="${id}" id="id"/>
			<div class="info">
				根据客户订单生产产品：现编写生产计划书交由审核，生产的产品为: <span
					style="font-size: 16px; font-weight: bolder; color: red;">${ProPlan.finishedProductsType.productName}</span>
				<br /> <br />

				<table
					class="table table-border table-bordered table-hover table-bg">
					<thead>
						<tr class="text-c">
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
									<td>${item.partType[index.count - 1].partType}</td>
									<td>${item.partClassify[index.count - 1].partName}</td>
									<td>${item.partFormulaDesc[index.count - 1].requirement * ProPlan.produceNum}</td>
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
				<br /> 参考产品配方: <span
					style="font-size: 16px; font-weight: bolder; color: red;">
					${formulaName} </span>

			</div>
		</div>
		<div class="At_button">
			<button onclick="through_save('this','123');"
				class="btn btn-primary radius" type="submit">通 过</button>
			<button onclick="cancel_save();" class="btn btn-danger  btn-warning"
				type="button">拒 绝</button>
			<button onclick="return_close();" class="btn btn-default radius"
				type="button">返回上一步</button>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	//通过
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	$(function(){
		$(".text-c:not(:first):even").css("background","#F2F2F2");
	});
	function through_save(obj, id) {
		layer.confirm('此计划将会执行，确定审核通过？', {
			icon : 3
		}, function(index) {
			var ison = 3;
			var id = $("#id").val();
			$.post("audit",{'ison':ison,'id':id},function(data){
				if (data == "true") {
					layer
							.msg(
									'审核通过!',
									{
										icon : 1,
										time : 2000
									},
									function() {
										window.location.href = "${pageContext.request.contextPath }/page/technical";
									});
				}
			},"text");
		});
	}

	//返回操作
	function return_close() {
		history.go(-1);
		parent.$('#parentIframe').css("display", "none");
		parent.$('.Current_page').css({
			"color" : "#333333"
		});

	}
	//拒绝
	function cancel_save() {
		var index = layer
				.open({
					type : 1,
					title : '内容',
					maxmin : true,
					shadeClose : false,
					area : [ '600px', '' ],
					content : ('<div class="shop_reason"><span class="content">请说明拒绝该申请人申请店铺的理由，以便下次在申请时做好准备。</span><textarea name="请填写拒绝理由" class="form-control" id="form_textarea" placeholder="请填写拒绝理由" onkeyup="checkLength(this);"></textarea><span class="wordage">剩余字数：<span id="sy" style="color:Red;">500</span>字</span></div>'),
					btn : [ '确定', '取消' ],
					yes : function(index, layero) {
						if ($('.form-control').val() == "") {
							layer.alert('回复内容不能为空！', {
								title : '提示框',
								icon : 0,
							})
						} else {
							var ison = 2;
							var id = $("#id").val();
							var reason = $('.form-control').val();
							$.post("audit",{'id':id,'ison':ison,'reason':reason},function(data){
								if (data == "true") {
									layer
											.msg(
													'拒绝申请成功!',
													{
														icon : 1,
														time : 2000
													},
													function() {
														window.location.href = "${pageContext.request.contextPath }/page/technical";
													});
								}
							},"text");
						}
					}
				})
	}
	/*字数限制*/
	function checkLength(which) {
		var maxChars = 500; //
		if (which.value.length > maxChars) {
			layer.open({
				icon : 2,
				title : '提示框',
				content : '您输入的字数超过限制!',
			});
			// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
			which.value = which.value.substring(0, maxChars);
			return false;
		} else {
			var curr = maxChars - which.value.length; //减去当前输入的
			document.getElementById("sy").innerHTML = curr.toString();
			return true;
		}
	};
</script>