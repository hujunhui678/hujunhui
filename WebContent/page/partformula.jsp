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
<title>产品列表</title>
</head>
<body>
	<div class=" page-content clearfix">
		<div id="products_style">
			<div class="search_style">
				<form action="${pageContext.request.contextPath }/page/SelPartForm"
					method="post" id="form">
					<ul class="search_content clearfix">
						<li><label class="l_f">成品名称</label><input name="productName" value="${productName}" type="text"
							class="text_add" placeholder="输入成品名称" style="width: 250px" /></li>
						<li><label class="l_f">编写时间</label><input  name="createTime" value="${createTime}"
							class="inline laydate-icon" id="start" style="margin-left: 10px;" /></li>
						<li style="width: 90px;"><button type="submit"
								class="btn_search">
								<i class="icon-search"></i>查询
							</button></li>
						<li style="width: 90px;"><span class="l_f"
							style="display: block; position: relative; top: -2px;"> <a
								href="${pageContext.request.contextPath }/page/toAdd" title="编写配方"
								class="btn btn-warning Order_form"><i class="icon-plus"></i>编写配方</a>
						</span></li>
					</ul>
			</div>
			<div class="table_menu_list" id="testIframe">
				<table class="table table-striped table-bordered table-hover"
					id="sample-table">
					<thead>
						<tr>
							<th width="30px">配方编号</th>
							<th width="170px">配方名称</th>
							<th width="180px">成品名</th>
							<th width="180px">编写时间</th>
							<th width="80px">编写人</th>
							<th width="70px">状态</th>
							<th width="200px">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${page.lists}">
							<tr>
								<td width="80px">${item.id}</td>
								<td width="250px"><u style="cursor: pointer"
									class="text-primary"
									onclick="partform_show('${item.formulaName}','partform-show.jsp','${item.id}','500','400')">${item.formulaName}</u>
								</td>
								<td width="100px">${item.finishedProductsType.productName}</td>
								<td width="180px">
									<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:ss:mm" />
								</td>
								<td class="text-l">${item.admin.name}</td>
								<td class="td-status"><span
									class="label label-success radius">已启用</span></td>
								<td class="td-manage"><a
									onClick="member_stop(this,'10001')" href="javascript:;"
									title="停用" class="btn btn-xs btn-success"><i
										class="icon-ok bigger-120"></i></a> <a title="删除"
									href="javascript:;" onclick="member_del(this,'1')"
									class="btn btn-xs btn-warning"><i
										class="icon-trash  bigger-120"></i></a></td>
							</tr>
						</c:forEach>
						<input id="totalPage" value=${page.totalPage } type="hidden" />
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
						$("#pagination1")
								.pagination(
										{
											currentPage : parseInt(b),
											totalPage : a,
											callback : function(current) {
												$("#current1").text(current);
												window.location.href = "SelPartForm?pageIndex="
														+ current;
											}
										});
					});
				</script>
			</div>
		</div>
	</div>
</body>
</html>
<
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
		elem : '#start',
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
	/*产品-停用*/
	function member_stop(obj, id) {
		layer
				.confirm(
						'确认要停用吗？',
						function(index) {
							$(obj)
									.parents("tr")
									.find(".td-manage")
									.prepend(
											'<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
							$(obj)
									.parents("tr")
									.find(".td-status")
									.html(
											'<span class="label label-defaunt radius">已停用</span>');
							$(obj).remove();
							layer.msg('已停用!', {
								icon : 5,
								time : 1000
							});
						});
	}

	/*产品-启用*/
	function member_start(obj, id) {
		layer
				.confirm(
						'确认要启用吗？',
						function(index) {
							$(obj)
									.parents("tr")
									.find(".td-manage")
									.prepend(
											'<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
							$(obj)
									.parents("tr")
									.find(".td-status")
									.html(
											'<span class="label label-success radius">已启用</span>');
							$(obj).remove();
							layer.msg('已启用!', {
								icon : 6,
								time : 1000
							});
						});
	}
	/*产品-编辑*/
	function member_edit(title, url, id, w, h) {
		layer_show(title, url, w, h);
	}
	/*配方-查看*/
	function partform_show(title, url, id, w, h) {
		layer_show(title, url + '?id=' + id, w, h);
	}

	/*产品-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon : 1,
				time : 1000
			});
		});
	}
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
