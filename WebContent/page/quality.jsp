<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<form action="${pageContext.request.contextPath}/page/quality"
						method="post">
						<span class="l"> <a href="javascript:;" onclick="datadel()"
							class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
								批量删除</a> <a class="btn btn-primary radius" href="javascript:;"
							onclick="qualityadd('添加人员','${pageContext.request.contextPath}/page/doadd','900','400')"><i
								class="Hui-iconfont">&#xe600;</i> 添加质检</a> <span class="select-box"
							style="width: 100px; margin-left: 20px;">

								<div class="layui-input-block">
									<select name="deptNo" lay-verify="required" class="select"
										id="deptNo" name="brandclass" size="1">
										<option value="0">全部</option>
										<option value="1" style="align: center;"
											<c:if test="${deptNo eq '1' }">selected</c:if>>生产部门</option>
										<option value="2"
											<c:if test="${deptNo eq '2' }">selected</c:if>>装配部门</option>
									</select>
								</div>

						</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检测零件型号：<input type="text"
							name="partType" id="partType" value="${partType}" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;质检人：<input type="text"
							name="name" id="name" value="${name}" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态： <select name="state"
							id="state">
								<option value="1" <c:if test="${state eq '1' }">selected</c:if>>未通过</option>
								<option value="2" <c:if test="${state eq '2' }">selected</c:if>>通过</option>
						</select> 
						
						&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询" />

						</span> <span class="r">共有数据：<strong>${page.totalCount }</strong>
							条
						</span>
					</form>
				</div>

				<div class="mt-10">
					<table
						class="table table-border table-bordered table-hover table-bg">
						<thead>
							<tr>
								<th scope="col" colspan="8">质量检测</th>
							</tr>
							<tr class="text-c">
								<th width="25"><input type="checkbox" value="" name=""></th>
								<th width="40">编号</th>

								<th width="200">质检人</th>
								<th width="200">检测零件型号</th>
								<th width="200">检测成品型号</th>
								<th width="200">规定提交时间</th>
								<th width="200">状态</th>
								<th width="70">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.lists }" varStatus="index">
								<tr class="text-c">
									<td><input type="checkbox" value="${item.id}" name=""
										id="check"></td>
									<td>${item.id}</td>

									<%--  <c:if test="${item.deptNo eq '1'}">
										<td>生产部门</td>
									</c:if>
									<c:if test="${item.deptNo eq '2'}">
										<td>装配部门</td>
									</c:if>  --%>
									<td>${item.adminName}</td>
									<td>${item.parttypes}</td>
									<td>${item.finishedtype}</td>
									<td><fmt:formatDate value="${item.submissionTime }"
											pattern="yyyy-MM-dd" /></td>
									<td><c:if test="${item.state==1 }">
											<span class="label label-warning radius">未通过</span>
										</c:if> <c:if test="${item.state==2 }">
											<span class="label label-success radius">通过</span>
										</c:if></td>

									<td class="f-14"><a title="编辑" href="javascript:;"
										onclick="qualityedit('编辑人员','${pageContext.request.contextPath}/page/doupdate',${item.id },'800','400')"
										style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
										<a title="删除" href="javascript:;"
										onclick="qualitydel(this,${item.id})" class="ml-5"
										style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a>

									</td>
								</tr>

							</c:forEach>
							<input id="totalPage" value="${page.totalPage }" type="hidden">
							<input id="currentPage" value="${page.currentPage }"
								type="hidden">
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
							 var deptNo = $(".select").val();
							 var name = $("#name").val();
							 var partType = $("#partType").val();
							$("#pagination1")
									.pagination(
											{
												currentPage : parseInt(b),
												totalPage : a,
												callback : function(current) {
													$("#current1")
															.text(current);
													window.location.href = "quality?currentPage="
															+ current+"&deptNo="+deptNo+"&name="+name+"&partType="+partType;
												}
								});
						});
					</script>
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
	 $(function(){
		 $(".select").change(function(){
			 var deptNo = $(".select").val();
			 window.location.href = "quality?deptNo="+deptNo;
		 });
	}) 
	/*质量检测添加*/
	function qualityadd(title, url, w, h) {
		layer_show(title, url, w, h);
	}
	/*质量检测编辑*/

	
	
		function qualityedit(title, url, id, w, h) {
			layer_show(title, url+"?id="+id, w, h);
		}
	
	/*质量检测-删除*/
	function qualitydel(obj, id) {
		layer.confirm('角色删除须谨慎，确认要删除吗？', function(index) {
			if(id != ""){
     			$.post("doDelete?id="+id,null,function(data){
     				if(data == "ok"){
     					layer.msg('已删除!', {
     						icon : 1,
     						time : 1000
     					},function(){
     						window.location.reload();
     						});
     				}else if(data == "error"){
     					layer.alert('该角色下有人员，无法删除!', {icon: 2});
     					 return ;
     				}
     			},"text");
            }
		});
	}
	
	function datadel(obj){
        var arr = new Array();
        $("#check:checked").each(function(i){
            arr[i] = $(this).val();
        });
        var vals = arr.join(",");
		if(vals == ""){
			layer.alert('请先选择要删除的角色信息!', {icon: 5});
			 return ;
		}
		layer.confirm('确认进行批量删除吗？', {icon:3}, function() {
        if(vals != ""){
 			$.post("doDelete?id="+vals,null,function(data){
 				if(data == "ok"){
 					layer.msg('已删除!', {
 						icon : 1,
 						time : 1000
 					},function(){
 						window.location.reload();
 						});
 				}else if(data == "error"){
 					layer.alert('该角色下有人员，无法删除!', {icon: 2});
					 return ;
				}
 			},"text");
        }
		});
	}
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>