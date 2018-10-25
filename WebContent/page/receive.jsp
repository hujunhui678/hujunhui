<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/Widget/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css" />
<link
	href="${pageContext.request.contextPath }/statics/Widget/icheck/icheck.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath }/statics/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/typeahead-bs2.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/jquery.dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/H-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/H-ui.admin.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/layer/layer.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/laydate/laydate.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/lrtk.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.pagination.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/jquery.pagination.css" />
<title>领料详情</title>
</head>
<body>
	<div class=" page-content clearfix">
		<div id="products_style">
			<div class="search_style">
				<form action="${pageContext.request.contextPath }/page/goReceive"
					method="post" id="form">
					<ul class="search_content clearfix">
						<li><label class="l_f">申请人:</label><input name="propose"
							value="${propose}" id="propose" type="text" class="text_add"
							placeholder="输入申请人姓名" style="width: 250px" /></li>
						<li><label class="l_f">申请时间</label><input name="arrivalTime"
							value="${arrivalTime}" id="arrivalTime"
							class="inline laydate-icon" style="margin-left: 10px;" /></li>
						<li style="width: 90px;"><button type="submit"
								class="btn_search">
								<i class="icon-search"></i>查询
							</button></li>
					</ul>
			</div>
			<div class="table_menu_list" id="testIframe">
				<table class="table table-striped table-bordered table-hover"
					id="sample-table">
					<thead>
						<tr>
							<th width="130px">编号</th>
							<th width="50px">申请人</th>
							<th width="50px">领用人</th>
							<th width="180px">申请时间</th>
							<th width="120px">状态</th>
							<th width="100px">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${page.lists}">
							<tr>
								<td width="80px">${item.id}</td>
								<td width="80px">${item.proposer.name}</td>
								<td width="100px">${item.receivePerson.name}</td>
								<td width="120px">${fun:substring(item.releaseTime,0,19)}</td>
								<td class="text-l"><c:if
										test="${item.auditState.auditStateName eq '审核未通过'}">
										<u style="cursor: pointer" class="text-primary"
											onClick="show_Audit(this,'${item.id}')">${item.auditState.auditStateName}</u>
									</c:if> <c:if test="${item.auditState.auditStateName ne '审核未通过'}">
									${item.auditState.auditStateName}
								</c:if></td>
								<td class="td-manage"><shiro:hasPermission
										name="audit:technical">
										<c:if test="${item.auditState.auditStateName ne '审核通过'}">
											<a
												href="${pageContext.request.contextPath }/page/goAuditReceive?id=${item.id}"
												title="审核" class="btn btn-xs btn-success"><i class=""></i>审核</a>
											<a title="删除" href="javascript:;"
												onclick="member_del(this,'${item.id}')"
												class="btn btn-xs btn-warning"><i
												class="icon-trash  bigger-120"></i></a>
										</c:if>
									</shiro:hasPermission></td>
							</tr>
						</c:forEach>
						<input id="totalPage" value="${page.totalPage }" type="hidden" />
						<input id="currentPage" value="${page.currentPage}" type="hidden" />
					</tbody>
				</table>
				<div class="box">
					<div id="pagination1" class="page fl"></div>
					<div class="info fl">
						<p>
							<span id="current1"></span>
						</p>
					</div>
				</div>
				<script>
					$(function() {
						var a = $("#totalPage").val();
						var b = $("#currentPage").val();
						var propose = $("#propose").val();//申请人
						var arrivalTime = $("#arrivalTime").val();//申请时间
						$("#pagination1")
								.pagination(
										{
											currentPage : parseInt(b),
											totalPage : a,
											callback : function(current) {
												$("#current1").text(current);
												window.location.href = "goReceive?currentPage="
														+ current
														+ "&propose="
														+ propose
														+ "&arrivalTime="
														+ arrivalTime;
											}
										});
					});
				</script>
			</div>
		</div>
	</div>
	<div id="Delivery_stop" style="display: none">
		<div class="">
			<div class="content_style">
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-field-1">审核状态 :</label> <span
						style="display: inline-block; color: red; font-size: 15px; margin: 2px 0 0 15px;">审核未通过!</span>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-field-1">拒绝原因 :</label> <span
						style="display: inline-block; color: red; font-size: 15px; margin: 2px 0 0 15px;"
						id="notPassDesc">审核未通过!</span>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-field-1">拒绝人 :</label> <span
						style="display: inline-block; color: red; font-size: 15px; margin: 2px 0 0 15px;">Jack</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	jQuery(function($) {
		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}
	});
	laydate({
		elem : '#arrivalTime',
		event : 'focus'
	});
</script>
<script type="text/javascript">
	//初始化宽度、高度  
	$(".widget-box").height($(window).height() - 215);
	$(".table_menu_list").width($(window).width() - 260);
	$(".table_menu_list").height($(window).height() - 215);
	//当文档窗口发生改变时 触发  
	$(window).resize(function() {
		$(".widget-box").height($(window).height() - 215);
		$(".table_menu_list").width($(window).width() - 260);
		$(".table_menu_list").height($(window).height() - 215);
	})

	var code;

	function showCode(str) {
		if (!code)
			code = $("#code");
		code.empty();
		code.append("<li>" + str + "</li>");
	}

	$(document).ready(function() {
		var t = $("#treeDemo");
		t = $.fn.zTree.init(t, setting, zNodes);
		demoIframe = $("#testIframe");
		demoIframe.bind("load", loadReady);
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.selectNode(zTree.getNodeByParam("id", '11'));
	});
	/*技术规划书审核*/
	function AuditState(title, url, id, w, h) {
		layer_show(title, url, w, h);
	}

	/*产品-删除*/
	function member_del(obj, id) {
		layer.confirm('删除无法恢复,确认要此领料单吗？', function(index) {
			$.post("delReveice", {
				'id' : id
			}, function(data) {
				if (data == "true") {
					$(obj).parents("tr").remove();
					layer.msg('已删除!', {
						icon : 1,
						time : 1000
					});
				}
			});
		});
	}
	/**查看拒绝审核的原因**/
	function show_Audit(obj, id) {
		$.post("getAuditToReceive", {
			'id' : id
		}, function(data) {
			$("#notPassDesc").text(data.notPassDesc);
			layer.open({
				type : 1,
				title : '审核状态',
				maxmin : true,
				shadeClose : false,
				area : [ '500px', '' ],
				content : $('#Delivery_stop'),
				btn : [ '确定' ],
				yes : function(index, layero) {
					layer.close(index);
				}
			})
		}, "json");
	};

	//面包屑返回值
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	$('.Order_form').on('click', function() {
		var cname = $(this).attr("title");
		var chref = $(this).attr("href");
		var cnames = parent.$('.Current_page').html();
		var herf = parent.$("#iframe").attr("src");
		parent.$('#parentIframe').html(cname);
		parent.$('#iframe').attr("src", chref).ready();
		;
		parent.$('#parentIframe').css("display", "inline-block");
		parent.$('.Current_page').attr({
			"name" : herf,
			"href" : "javascript:void(0)"
		}).css({
			"color" : "#4c8fbd",
			"cursor" : "pointer"
		});
		//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
		parent.layer.close(index);
	});
</script>
