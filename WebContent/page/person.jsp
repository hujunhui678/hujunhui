<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<span class="l"> <a href="javascript:;" onclick="datadel()"
						class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
							批量删除</a> <a class="btn btn-primary radius" href="javascript:;"
						onclick="admin_add('添加人员','${pageContext.request.contextPath}/page/person_add.jsp','900','400')"><i
							class="Hui-iconfont">&#xe600;</i> 添加人员</a> <span class="select-box"
						style="width: 100px; margin-left: 20px;">

							<div class="layui-input-block">
								<select name="city" lay-verify="required" class="select"
									name="brandclass" size="1">
									<option value="管理员" style="align: center;"
										<c:if test="${sel eq '管理员' }">selected</c:if>>管理员</option>
									<option value="雇员" <c:if test="${sel eq '雇员' }">selected</c:if>>雇员</option>
								</select>
							</div>

					</span>
					</span> <span class="r">共有数据：<strong>${page.totalCount }</strong> 条
					</span>
				</div>
				<div class="mt-10">
					<table
						class="table table-border table-bordered table-hover table-bg">
						<thead>
							<tr>
								<th scope="col" colspan="6">人员管理</th>
							</tr>
							<tr class="text-c">
								<th width="25"><input type="checkbox" value="" name=""></th>
								<th width="40">序号</th>
								<th width="200">姓名</th>
								<th width="200">联系方式</th>
								<th width="200">所属部门</th>
								<th width="70">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.lists }" varStatus="index">
								<tr class="text-c">
									<td><input type="checkbox" value="${item.id}" name=""
										id="check"></td>
									<td>${index.count}</td>
									<td>${item.name}</td>
									<td>${item.phone }</td>
									<td>${item.childdept.childName }</td>
									<td class="f-14"><a title="编辑" href="javascript:;"
										onclick="person_edit('编辑人员','${pageContext.request.contextPath}/page/',${item.id },'800','400')"
										style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
										<a title="删除" href="javascript:;"
										onclick="person_del(this,${item.id})" class="ml-5"
										style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
								</tr>
							</c:forEach>
							<input id="totalPage" value=${page.totalPage } type="hidden">
							<input id="currentPage" value="${page.currentPage}" type="hidden">
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
							 var sel = $(".select").val();
							$("#pagination1")
									.pagination(
											{
												currentPage : parseInt(b),
												totalPage : a,
												callback : function(current) {
													$("#current1")
															.text(current);
													window.location.href = "person?currentPage="
															+ current+"&sel="+sel;
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
				 var sel = $(".select").val();
				 window.location.href = "person?sel="+sel;
			 });
		}) 
		/*管理员-添加*/
		function admin_add(title, url, w, h) {
			var isPerson = $(".select").val();
			layer_show(title, url+"?isPerson="+isPerson, w, h);
			/* $.post("toAddPerson?isPerson="+isPerson+"&url="+url,null,function(data){
			},"text"); */
		}
		 /*管理员-编辑*/
			function person_edit(title, url, id, w, h) {
				var isPerson = $(".select").val();
				if(isPerson == "管理员"){
					layer_show(title, url+"person_modify.jsp?isPerson="+isPerson+"&id="+id, w, h);
				}else{
					layer_show(title, url+"emp_modify.jsp?isPerson="+isPerson+"&id="+id, w, h);
				}
			}
		/*管理员-删除*/
		function person_del(obj, id) {
			var isPerson = $(".select").val();
				layer.confirm('将会删除所有信息,确认要删除此'+isPerson+'吗？',{icon:3}, function(index) {
					if(id != ""){
		     			$.post("delPerson?ids="+id+"&isPerson="+isPerson,null,function(data){
		     				if(data == "ok"){
		     					layer.msg('已删除!', {
		     						icon : 1,
		     						time : 1000
		     					},function(){
		     						window.location.reload();
		     					});
		     				}
		     			},"text");
		            }
				});
		};
		function datadel(obj){
            var arr = new Array();
            $("#check:checked").each(function(i){
                arr[i] = $(this).val();
            });
            var vals = arr.join(",");
			if(vals == ""){
				layer.alert('请先选择要删除的人员!', {icon: 5});
				 return ;
			}
			var isPerson = $(".select").val();
			layer.confirm('确认进行批量删除吗？', {icon:3}, function() {
            if(vals != ""){
     			$.post("delPerson?ids="+vals+"&isPerson="+isPerson,null,function(data){
     				if(data == "ok"){
     					layer.msg('已删除!', {
     						icon : 1,
     						time : 1000
     					},function(){
     						window.location.reload();
     						});
     				}
     			},"text");
            }
			});
		}
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>