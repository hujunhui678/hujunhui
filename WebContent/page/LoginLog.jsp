<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	href="${pageContext.request.contextPath }/statics/assets/css/font-awesome.min.css" />
<script
	src="${pageContext.request.contextPath }/statics/assets/js/jquery.min.js"></script>
<script type="text/javascript">
	window.jQuery
			|| document
					.write("<script src='${pageContext.request.contextPath }/statics/assets/js/jquery-2.0.3.min.js'>"
							+ "<"+"/script>");
</script>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.pagination.min.js"></script>
<script type="text/javascript">
	if ("ontouchend" in document)
		document
				.write("<script src='${pageContext.request.contextPath }/statics/assets/js/jquery.mobile.custom.min.js'>"
						+ "<"+"/script>");
</script>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/jquery.pagination.css" />
<title>登录日志</title>
</head>
<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<form action="${pageContext.request.contextPath }/page/logList"
					method="post" id="form">
					<div class="search_style">
						<ul class="search_content clearfix">
							<li><label class="l_f">用户名称</label><input name="name"
								type="text" class="text_add" placeholder="输入管理员姓名..."
								style="width: 300px" value="${name}" id="name" /></li>
							<li><label class="l_f">登录时间</label><input name="loginTime"
								class="inline laydate-icon" value="${loginTime}" id="start"
								style="margin-left: 10px;" /></li>
							<li style="width: 90px;"><button type="submit"
									class="btn_search">
									<i class="icon-search"></i>查询
								</button></li>
						</ul>
					</div>
				</form>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <a href="javascript:ovid()"
						class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
					</span> <span style=" display: block;margin:2px 0 0 10px;"> <select id="delLog">
							<option>清空5天前的记录</option>
							<option>清空15天前的记录</option>
							<option>清空30天前的记录</option>
					</select>
					</span> <span class="r_f">共：<b>${page.totalCount }</b>条
					</span>
				</div>
				<!---->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th width="25"><label> <input type="checkbox"
										class="ace" /><span class="lbl"></span></label></th>
								<th width="80">编号</th>
								<th width="100">用户名</th>
								<th width="200">登录地点</th>
								<th width="220">登录IP</th>
								<th width="340">登录时间</th>
								<th width="250">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="log" items="${page.lists}">
								<tr>
									<td><label><input type="checkbox" class="ace" /><span
											class="lbl"></span></label></td>
									<td>${log.id}</td>
									<td><u style="cursor: pointer" class="text-primary"
										onclick="member_show('张三','member-show.html','10001','500','400')">${log.name}</u></td>
									<td>${log.loginAddress}</td>
									<td>${log.loginIP}</td>
									<td><fmt:formatDate value="${log.loginTime}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
							var name = $("#name").val();
							var time = $("#start").val();
							$("#pagination1")
									.pagination(
											{
												currentPage : parseInt(b),
												totalPage : a,
												callback : function(current) {
													$("#current1")
															.text(current);
													window.location.href = "logList?pageIndex="
															+ current
															+ "&name="
															+ name
															+ "&loginTime="
															+ time;
												}
											});
						});
					</script>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	jQuery(function($) {
		$("#delLog").change(function(){
			layer.confirm("记录删除无法恢复,请慎重!",{icon:8},function(){
				
				
			});
		});
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 8, 9 ]
			} // 制定列不参与排序
			]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

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
	})

	/*用户-查看*/
	function member_show(title, url, id, w, h) {
		layer_show(title, url + '#?=' + id, w, h);
	}
	/*用户-停用*/
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

	/*用户-启用*/
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
	/*用户-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon : 1,
				time : 1000
			});
		});
	}
	laydate({
		elem : '#start',
		event : 'focus'
	});
</script>