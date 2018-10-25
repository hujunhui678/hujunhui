<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
 <link href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css" rel="stylesheet" />
 <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
 <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />



		<script src="${pageContext.request.contextPath }/statics/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.pagination.min.js"></script>
        <script src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>

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
					<form action="${pageContext.request.contextPath }/page/sales"
		method="post">
					<span class="l"> 
					<shiro:hasPermission name="sales:remove">
					<a href="javascript:;" onclick="datadel()"
						class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
							批量删除</a> 
					</shiro:hasPermission>
							<shiro:hasPermission name="sales:add">
							<a class="btn btn-primary radius" href="javascript:;"
							onclick="admin_add('添加订单','${pageContext.request.contextPath}/page/sales_add.jsp','900','400')"><i
								class="Hui-iconfont">&#xe600;</i> 添加订单</a>
							</shiro:hasPermission>
					</span> <!--   订单状态: <input type="text" name="state"
						value="${state}"/><span >(输入:1 未出货,2 已发货, 3 已到达)</span><input type="submit" value="查询" />-->
						
					&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp;
					&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 
					&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 
					 订单状态: <input type="text" name="state"
						value="${state}"/><span >(输入:1 未出货 ,2 已发货 ,3 已到达)</span>

						<input type="submit" value="查询" class="btn_search" />
						  <span
						class="r">共有数据：<strong>${pageUtil.totalCount }</strong> 条
					</span>
					</form>
				</div>
				<div class="mt-10">
					<table
						class="table table-border table-bordered table-hover table-bg">
						<thead>
							<tr>
								<th scope="col" colspan="9">销售订单管理</th>
							</tr>
							<tr class="text-c">
								<th width="25"><input type="checkbox" value="" name=""></th>
								<th width="40">序号</th>
								<th width="200">成品类别</th>
								<th width="200">订购数量</th>
								<th width="200">客户公司</th>
								<th width="200">联系方式</th>
								<th width="200">订单日期</th>
								<th width="200">订单状态</th>
								<th width="70">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${pageUtil.lists }"
								varStatus="index">
								<tr class="text-c">
									<td><input type="checkbox" value="${item.id}" name=""
										id="check"></td>
									<td>${index.count}</td>
									<td>${item.productType}</td>
									<td>${item.orderNum }</td>
									<td>${item.clientCompany}</td>
									<td>${item.clientContact}</td>
									<td>${item.orderDate}</td>
									<td><c:if test="${item.state==1 }">
											<span class="label label-warning radius">未出货</span>
										</c:if> <c:if test="${item.state==2 }">
											<span class="label label-success radius">已发货</span>
										</c:if>
										<c:if test="${item.state==3 }">
											<span class="label label-info radius">已到达</span>
										</c:if></td>

									<td class="f-14">
									<shiro:hasPermission name="sales:edit">
									<a title="编辑" href="javascript:;"
										onclick="person_edit('编辑人员','${pageContext.request.contextPath}/page/doupdateSales',${item.id },'800','400')"
										style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
									</shiro:hasPermission>
									<shiro:hasPermission name="sales:remove">
										<a title="删除" href="javascript:;"
										onclick="person_del(this,${item.id})" class="ml-5"
										style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a>
									</shiro:hasPermission>
									<c:if test="${item.state==1 }">
										<shiro:hasPermission name="sales:sendout">
											<a title="发货" href="javascript:;"
											onclick="fahuo(${item.id},${item.finishedType},${item.orderNum},'${item.productType }',${admin.id } )" class="ml-5"
											style="text-decoration: none"><i class="Hui-iconfont">&#xe615;</i></a>
										</shiro:hasPermission>
									</c:if>
									</td>
								</tr>

							</c:forEach>
							<input id="totalPage" value=${pageUtil.totalPage } type="hidden">
							<input id="currentPage" value="${pageUtil.currentPage}"
								type="hidden">
						</tbody>
					</table>


					<div class="box">
						<div id="pagination1" class="page fl"></div>
						<div class="info fl" style="display: none">
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
													window.location.href = "sales?currentPage="
															+ current;
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
		//发货
		function fahuo(orderId,finishedType,orderNum,productType,adminId){
			 var orderId=orderId;
			 var finishedType = finishedType;
			 var orderNum = orderNum;
			 var productType = productType;
			 $(function(){
				 layer.confirm("确定发货吗？",function(){
						$.post("comparisonFinishedPart",{'finishedType':finishedType,'orderNum':orderNum},function(data){
							var result = JSON.parse(data);
							var missPart = parseInt(orderNum)-parseInt(result.inventoryNum);
							if(parseInt(result.inventoryNum)>=parseInt(orderNum)){
								$.post("finishedPartOut",{'orderId':orderId,'finishedType':finishedType,'orderNum':orderNum,'adminId':adminId},function(json){
									if(json=="yes"){
										layer.msg('发货成功!', {
											icon : 1,
											time : 1000
										},function(){
											window.location.reload();
										});
									}else{
										layer.msg('发货失败,参数异常', {
											icon : 2,
											time : 1000
										},function(){
											window.location.reload();
										});
									}
								},"text");
							}else{
								layer.confirm("成品零件数量不足!<br/>缺少零件："+productType+"<br/>缺少数量："+missPart+"<br/>是否发送采购计划？", {
					                title:false,
					                btnAlign: 'c',
					                area: ['25rem', '15rem'],
					                btn: ['是', '否'] //按钮
					            }, function(index){
					            	$.post("sendoutproductionplan",{'finishedProductTypeId':finishedType,'produceNum':missPart},function(data){
					            		if(data=="yes"){
					            			layer.msg('发送成功,预计三天后完成', {
												icon : 1,
												time : 1000
											},function(){
												window.location.reload();
											});
					            		}else{
					            			layer.msg('发送失败,参数错误!', {
												icon : 2,
												time : 1000
											},function(){
												window.location.reload();
											});
					            		}
					            	},"text");
					            });
							}
						},"text");
				 });
			 });
		 }
		/*管理员-添加*/
		function admin_add(title, url, w, h) {
			var isPerson = $(".select").val();
			layer_show(title, url+"?isPerson="+isPerson, w, h);
			/* $.post("toAddPerson?isPerson="+isPerson+"&url="+url,null,function(data){
			},"text"); */
		}
		 /*管理员-编辑*/
			function person_edit(title, url, id, w, h) {
				layer_show(title, url+"?id="+id, w, h);
			}
		/*管理员-删除*/
		function person_del(obj, id) {
				layer.confirm('将会删除所有信息,确认要删除此吗？',{icon:3}, function(index) {
					if(id != ""){
		     			$.post("delete",{'ids':id},function(data){
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
     			$.post("delete",{'ids':vals,'isPerson':isPerson},function(data){
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