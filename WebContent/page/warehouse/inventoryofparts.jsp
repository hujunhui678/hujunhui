<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>元素 - UI元素 - 统一开发平台 - UI库</title>
		<meta name="description" content="Common UI Features &amp; Elements" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" id="main-ace-style" />
	    <link href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css"/>       
        <link href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
			<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery.pagination.css" />
		<script src="${pageContext.request.contextPath }/statics/js/jquery-1.9.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/typeahead-bs2.min.js"></script>   
        <script src="${pageContext.request.contextPath }/statics/js/lrtk.js" type="text/javascript" ></script>		
        <script src="${pageContext.request.contextPath }/statics/assets/layer/layer.js" type="text/javascript" ></script>   
		<script src="${pageContext.request.contextPath }/statics/js/jquery.pagination.min.js"></script>
	</head>
<body class="no-skin">
	<div class="tabbable">
		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a data-toggle="tab" href="#home"> <i class="green ace-icon fa fa-home bigger-120"></i> 毛坯库存</a></li>
			<li><a data-toggle="tab" href="#messages"> 成品库存</a></li>
		</ul>

		<div class="tab-content">
		
			<!-- 毛坯库存 -->
			<div id="home" class="tab-pane fade in active">
				
<div class="page-content clearfix">
 <div class="sort_style">
     <div class="border clearfix" style="margin-bottom:30px">
       <span class="r_f">共：<b>5</b>类</span>
     </div>
     
     <div class="search_style">
     <c:if test="${notSigninCount>0 }">
     	<div class="Shops_Audit" style="margin-bottom:10px">
		   <div class="prompt">当前共有<b>${notSigninCount }</b>份采购单请求签收</div>
		 </div>
     </c:if>
     <c:if test="${notSigninCount==0 }">
     	<div class="Shops_Audit" style="margin-bottom:10px">
		   <div class="prompt">当前没有采购单请求签收</div>
		 </div>
     </c:if>
     <form id="orderForm" action="${pageContext.request.contextPath }/page/getmeterials" method="post">
	      <!-- 存储总页数 -->
		  <input id="totalPage" type="hidden">
	      <!-- 存储当前页 -->
		  <input id="currentPage" name="currentPage" type="hidden">
      </form>
    </div>
     
     
  <div class="sort_list">
    <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 	<tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="25px">序号</th>
				<th width="100px">毛坯名称</th>
				<th width="50px">库存量</th>
				<th width="150px">购买途径/厂商</th>
				<th width="250px">操作</th>
			</tr>
		</thead>
    <tbody id="scTables">
      <tr>
       <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
       <td>1</td>
       <td>幻灯片</td>
       <td>5</td>
       <td>5</td>
      <td class="td-manage">
        <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="fa fa-check  bigger-120"></i></a>   
        <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')" href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>      
       </td>
      </tr> 
    </tbody>
    </table>
    
    				<!-- 分页 -->
    				<div class="box" id="box">
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
<!--添加分类-->
<div class="sort_style_add margin" id="sort_style_add" style="display:none">
  <div class="">
     <ul>
      <li><label class="label_name">分类名称</label><div class="col-sm-9"><input name="分类名称" type="text" id="form-field-1" placeholder="" class="col-xs-10 col-sm-5"></div></li>
      <li><label class="label_name">分类说明</label><div class="col-sm-9"><textarea name="分类说明" class="form-control" id="form-field-8" placeholder="" onkeyup="checkLength(this);"></textarea><span class="wordage">剩余字数：<span id="sy" style="color:Red;">200</span>字</span></div></li>
      <li><label class="label_name">分类状态</label>
      <span class="add_content"> &nbsp;&nbsp;<label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">显示</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1" type="radio" class="ace"><span class="lbl">隐藏</span></label></span>
     </li>
     </ul>
  </div>	
</div>


			</div>
			
			<!-- 零件库存 -->
			<div id="messages" class="tab-pane fade">
				<ul class="list-unstyled spaced">
					<li><i class="ace-icon fa fa-bell-o bigger-110 purple"></i>
						南航开通华中首条直达美国航线</li>

					<li><i class="ace-icon fa fa-check bigger-110 green"></i> 人命关天
						南航空地联动紧急备降</li>

					<li><i class="ace-icon fa fa-times bigger-110 red"></i>
						以健康名义去旅行</li>
				</ul>
			</div>
</body>
</html>
		<!-- basic scripts -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath }/statics/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath }/statics/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/jquery-ui.custom.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/bootbox.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/ace.min.js"></script>
		<script type="text/javascript">
		//生成表格
		$(function(){
			$.post("getmeterials",null,function(result){
				$("#totalPage").val(result.totalPage);
				$("#currentPage").val(result.currentPage);
				var a = $("#totalPage").val();
				var b = $("#currentPage").val();
				$("#box").children("a").remove();
				$("#pagination1").pagination({
								currentPage : parseInt(b),
								totalPage : a,
								callback : function(current) {
									$("#current1").text(current);
									$("#currentPage").val(current);
									$.post("getmeterials",{'currentPage':current},function(result){
										$("#scTables").children().remove();
										$("#totalPage").val(result.totalPage);
										$("#currentPage").val(result.currentPage);
										var data = result.lists;
										for(i in data){
											if(data[i].purchaseWay==1){
												$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>厂家直销</td><td class='td-manage'><a onClick='member_stop(this,'10001')'  href='javascript:;' title='停用'  class='btn btn-xs btn-success'><i class='fa fa-check  bigger-120'></i></a><a title='编辑' onclick='member_edit('编辑','member-add.html','4','','510')' href='javascript:;'  class='btn btn-xs btn-info' ><i class='fa fa-edit bigger-120'></i></a></td></tr>");
											}else if(data[i].purchaseWay==2){
												$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>厂内自产</td><td class='td-manage'><a onClick='member_stop(this,'10001')'  href='javascript:;' title='停用'  class='btn btn-xs btn-success'><i class='fa fa-check  bigger-120'></i></a><a title='编辑' onclick='member_edit('编辑','member-add.html','4','','510')' href='javascript:;'  class='btn btn-xs btn-info' ><i class='fa fa-edit bigger-120'></i></a></td></tr>");
											}else{
												$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>专人定制</td><td class='td-manage'><a onClick='member_stop(this,'10001')'  href='javascript:;' title='停用'  class='btn btn-xs btn-success'><i class='fa fa-check  bigger-120'></i></a><a title='编辑' onclick='member_edit('编辑','member-add.html','4','','510')' href='javascript:;'  class='btn btn-xs btn-info' ><i class='fa fa-edit bigger-120'></i></a></td></tr>");
											}
										}
									},"json");
								}
				});
				$("#scTables").children().remove();
				var data = result.lists;
				for(i in data){
					if(data[i].purchaseWay==1){
						$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>厂家直销</td><td class='td-manage'><a onClick='member_stop(this,'10001')'  href='javascript:;' title='停用'  class='btn btn-xs btn-success'><i class='fa fa-check  bigger-120'></i></a><a title='编辑' onclick='member_edit('编辑','member-add.html','4','','510')' href='javascript:;'  class='btn btn-xs btn-info' ><i class='fa fa-edit bigger-120'></i></a></td></tr>");
					}else if(data[i].purchaseWay==2){
						$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>厂内自产</td><td class='td-manage'><a onClick='member_stop(this,'10001')'  href='javascript:;' title='停用'  class='btn btn-xs btn-success'><i class='fa fa-check  bigger-120'></i></a><a title='编辑' onclick='member_edit('编辑','member-add.html','4','','510')' href='javascript:;'  class='btn btn-xs btn-info' ><i class='fa fa-edit bigger-120'></i></a></td></tr>");
					}else{
						$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>专人定制</td><td class='td-manage'><a onClick='member_stop(this,'10001')'  href='javascript:;' title='停用'  class='btn btn-xs btn-success'><i class='fa fa-check  bigger-120'></i></a><a title='编辑' onclick='member_edit('编辑','member-add.html','4','','510')' href='javascript:;'  class='btn btn-xs btn-info' ><i class='fa fa-edit bigger-120'></i></a></td></tr>");
					}	
				}
			},"json");
		});
</script>
