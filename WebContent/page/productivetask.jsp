<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath() + "/page");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/jquery.pagination.css" />



<script
	src="${pageContext.request.contextPath }/statics/js/jquery-1.10.2.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.pagination.min.js"></script>

<title></title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: "微软雅黑";
}

button {
	display: inline-block;
	padding: 6px 12px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	vertical-align: middle;
	cursor: pointer;
	border: 1px solid transparent;
	border-radius: 4px;
	border-color: #28a4c9;
	color: #fff;
	background-color: #5bc0de;
	margin: 20px 20px 0 0;
}

.box {
	width: 900px;
	margin: 0px auto 0;
	height: 34px;
}

.page {
	width: 700px;
}

.info {
	width: 200px;
	height: 34px;
	line-height: 34px;
}

.fl {
	float: left;
}
</style>
</head>
<body>
	<!--/_menu 作为公共模版分离出去-->
	<section>
		<div>
			<div class="cl pd-20">
				<div class="cl pd-5 bg-1 bk-gray">
					<span class="l"> <a href="javascript:;" onclick="delBatch()"
						class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
							批量删除</a> <a class="btn btn-primary radius" href="javascript:;"
						onclick="productivetask_add('添加生产任务','${APP_PATH}/productivetask_add.jsp','900','500')"><i
							class="Hui-iconfont">&#xe600;</i> 添加生产任务</a>

					</span>
					
						&nbsp;&nbsp;&nbsp;&nbsp;生产编号 <input type="text" name="sid" id="sid" value="${sid}"/> <input
							type="button" id="ok" value="查 询" />
					
					<span class="r">共有数据：<strong id="total_info"></strong> 条
					</span>
				</div>
				<div class="mt-10">
					<table
						class="table table-border table-bordered table-hover table-bg">
						<thead>
							<tr>
								<th scope="col" colspan="9">生产任务管理</th>
							</tr>
							<tr class="text-c">
								<th width="25"><input type="checkbox" value="" name=""></th>
								<th width="40">序号</th>
								<th width="200">生产计划</th>
								<th width="200">零件类别</th>
								<th width="200">生产班长</th>
								<th width="200">生产数量</th>
								<th width="200">完成时间</th>
								<th width="200">备注</th>
								<th width="70">操作</th>
							</tr>
						</thead>
						<tbody id="body_productivetask">

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

				</div>
			</div>
		</div>
	</section>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	
		$(function() {
			toPage(1);
			$("#ok").click(function(){
				var id = $("#sid").val();
				selByid(id);
			});
		});
		
		var currentPage;
		var totalPage;
		var pageSize;
		function selByid(id) {
			$.ajax(({
				url : "${APP_PATH}/productivetask_list",
				data : "sid=" + id,
				type : "GET",
				success : function(result) {
					var pageInfo = result.extend.pageInfo;
					currentPage = pageInfo.pageNum;
					totalPage = pageInfo.pages;
					pageSize = pageInfo.pageSize;
					$("#total_info").empty();
					$("#total_info").append(pageInfo.total);
					build_table(result);
					initPagination();
				}
			}))
		}
	

		function toPage(pn) {
			$.ajax(({
				url : "${APP_PATH}/productivetask_list",
				data : "pn=" + pn,
				type : "GET",
				success : function(result) {
					var pageInfo = result.extend.pageInfo;
					currentPage = pageInfo.pageNum;
					totalPage = pageInfo.pages;
					pageSize = pageInfo.pageSize;
					$("#total_info").empty();
					$("#total_info").append(pageInfo.total);
					build_table(result);
					initPagination();
					//build_pageInfo_nav(result);
				}
			}))
		}

		function build_table(result) {
			var body = $("#body_productivetask").empty();
			var productivetasks = result.extend.pageInfo.list;

			$.each(productivetasks, function(index, item) {
				var tr = $("<tr></tr>").addClass("text-c");
				var check = $("<td></td>").append(
						$("<input>").attr("value", item.id).attr("id", "check")
								.attr("type", "checkbox"));
				var id = $("<td></td>").append(item.id);
				var planId = $("<td></td>").append(item.planId);
				var partTypeEntity = $("<td></td>").append(
						item.partTypeEntity.partType);
				var monitor = $("<td></td>").append(
						item.productionLeaderEntity.name);
				var productionNum = $("<td></td>").append(item.productionNum);
				var estimatedTimeOfCompletion = $("<td></td>").append(
						item.estimatedTimeOfCompletion);
				var desc = $("<td></td>").append(item.desc);
				var editTd = $("<td></td>").addClass("f-14");
				var a1 = $("<a></a>").attr("title", "编辑").attr("href",
						"javascript:;").attr(
						"onclick",
						"productivetask_edit('编辑生产任务','${APP_PATH}/productivetask_modify.jsp',"
								+ item.id + ",'800','400')").attr("style",
						"text-decoration: none").append(
						$("<i></i>").addClass("Hui-iconfont")
								.append("&#xe6df;"));

				var a2 = $("<a></a>").addClass("ml-5").attr("title", "删除")
						.attr("href", "javascript:;").attr("onclick",
								"productivetask_del(" + item.id + ")").attr(
								"style", "text-decoration: none").append(
								$("<i></i>").addClass("Hui-iconfont").append(
										"&#xe6e2;"));
				editTd.append(a1).append(a2);
				tr.append(check);
				tr.append(id);
				tr.append(planId);
				tr.append(partTypeEntity);
				tr.append(monitor);
				tr.append(productionNum);
				tr.append(estimatedTimeOfCompletion);
				tr.append(desc);
				tr.append(editTd);
				body.append(tr);
			});
		}

		function initPagination() {
			$("#pagination1").pagination({
				currentPage : parseInt(currentPage),
				totalPage : totalPage,
				callback : function(clickedPage) {
					toPage(clickedPage);
				}
			});
		}

		/*生产任务-添加*/
		function productivetask_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}

		/*生产任务-编辑*/
		function productivetask_edit(title, url, id, w, h) {
			layer_show(title, url + "?id=" + id, w, h);
		}

		/*生产任务-单个删除*/
		function productivetask_del(id) {
			layer.confirm('将会删除所有信息,确认要删除此装配任务书吗？', {
				icon : 3
			}, function(index) {
				if (id != "") {
					sendAjaxDel(id);
				}
			});
		}

		/*生产任务-批量删除*/
		function delBatch() {
			var ids = "";
			$("#check:checked").each(function(index) {
				ids += $(this).val() + "-";
			});
			//去除多余的"-"
			ids.substring(0, ids.length - 1);
			if (ids === "") {
				layer.alert('请先选择要删除的装配任务书!', {
					icon : 5
				});
				return;
			}
			layer.confirm('确认进行批量删除吗？', {
				icon : 3
			}, function() {
				if (ids != "") {
					sendAjaxDel(ids);
				}
			});
		}

		/*发送ajax删除请求*/
		function sendAjaxDel(ids) {
			$.ajax({
				url : "${APP_PATH}/productivetask_del/" + ids,
				type : "DELETE",
				success : function(result) {
					var icon = result.code === 100 ? 1 : 2;
					layer.msg(result.msg, {
						icon : icon,
						time : 1000
					}, function() {
						location.reload();
						layer_close();
					});
				}
			});
		}
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>