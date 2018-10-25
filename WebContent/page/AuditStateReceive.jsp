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
		<div class="Store_Introduction">
			<div class="title_name">零件领料单</div>
			<input type="hidden" value="${id}" id="id"/>
			<input type="hidden" value="${admin.id}" id="adminId"/>
			<div class="info">
				<span
					style="font-size: 16px; font-weight: bolder; color: red;">${ProPlan.finishedProductsType.productName}</span>
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
						<c:forEach var="item" items="${Receive}">
								<tr class="text-c" align="center">
									<td>${item.partType.partType}</td>
									<td>${item.partType.partClassify.partName}</td>
									<td>${item.orderNum}</td>
								</tr>
							<%-- 	<c:forEach var="partClassify" items="${item.partClassify}">
								<td>${partClassify.partName}</td>
							</c:forEach>
							<c:forEach var="partFormulaDesc" items="${item.partFormulaDesc}">
								<td>${partFormulaDesc.requirement}</td>
							</c:forEach> --%>
						</c:forEach>
					</tbody>
				</table>
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
		layer.confirm('将提交至仓库进行审批，确定审核通过？', {
			icon : 3
		}, function(index) {
			var ison = 3;//审核通过
			var id = $("#id").val();
			var adminId = $("#adminId").val();//审批人
			$.post("AuditReceive",{'auditStateId':ison,'id':id,'auditorId':adminId},function(data){
				if (data == "true") {
					layer
							.msg(
									'审核通过!',
									{
										icon : 1,
										time : 2000
									},
									function() {
										window.location.href = "${pageContext.request.contextPath }/page/goReceive";
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
							var adminId = $("#adminId").val();//审批人
							$.post("AuditReceive",{'id':id,'auditStateId':ison,'notPassDesc':reason,'auditorId':adminId},function(data){
								if (data == "true") {
									layer
											.msg(
													'拒绝申请成功!',
													{
														icon : 1,
														time : 2000
													},
													function() {
														window.location.href = "${pageContext.request.contextPath }/page/goReceive";
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