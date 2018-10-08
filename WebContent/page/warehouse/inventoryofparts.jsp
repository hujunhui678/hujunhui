<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>零件库存</title>
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
			<li class="active"><a data-toggle="tab" href="#home"> <i class="green ace-icon fa fa-reddit bigger-120"></i> 毛坯库存</a></li>
			<li><a data-toggle="tab" href="#messages" id="chengpinku"><i class="red ace-icon fa fa-car bigger-120"></i> 成品库存</a></li>
		</ul>

		<div class="tab-content">
		
			<!-- 毛坯库存 -->
			<div id="home" class="tab-pane fade in active">
				
<div class="page-content clearfix">
 <div class="sort_style">
    
     
     <div class="search_style">
      <div class="Shops_Audit" style="margin-bottom:10px">
	        	<span class="l_f">
		          <a href="javascript:void()" id="sort_add" class="btn btn-warning" style="margin:5px"><i class="fa fa-plus"></i> 添加分类</a>
		         </span>
		   	<div class="prompt">当前共有<b id="partCount">5</b>种毛坯零件</div>
		 </div>
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
								<span id="current1" style="display:none"></span>
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
	<div class="page-content clearfix">
 <div class="sort_style">
    
     
     <div class="search_style">
      <div class="Shops_Audit" style="margin-bottom:10px">
	        	<span class="l_f">
		          <a href="javascript:void()" id="sort_add2" class="btn btn-warning" style="margin:5px"><i class="fa fa-plus"></i> 添加分类</a>
		         </span>
		   	<div class="prompt">当前共有<b id="partCount2">5</b>种成品零件</div>
		 </div>
     <form id="orderForm" action="${pageContext.request.contextPath }/page/getmeterials" method="post">
	      <!-- 存储总页数 -->
		  <input id="totalPage2" type="hidden">
	      <!-- 存储当前页 -->
		  <input id="currentPage2" name="currentPage" type="hidden">
      </form>
    </div>
     
     
  <div class="sort_list">
    <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 	<tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="25px">序号</th>
				<th width="100px">成品类型</th>
				<th width="50px">成品名</th>
				<th width="150px">库存量</th>
				<th width="150px">来源途径</th>
				<th width="250px">操作</th>
			</tr>
		</thead>
    <tbody id="scTables2">
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
    				<div class="box" id="box2">
						<div id="pagination2" class="page fl"></div>
						<div class="info fl">
							<p>
								<span id="current2" style="display:none"></span>
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			 <!--添加毛坯分类弹出层-->
			 <div id="part_add" style=" display:none">
			    <div class="content_style" style="margin-top:30px">
			    
			    
			  	<div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="partType">零件型号 </label>
			       <div class="col-sm-9"><input type="text"  class="col-xs-10 col-sm-11" id="partType" style="margin-left:0px;"></div>
				</div>
				
			   <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">零件分类 </label>
			       <div class="col-sm-9">
						<select class="select" id="partClassId">
							<option value="0">请选择</option>
							<c:forEach var="item" items="${partClassifyList }">
								<option value="${item.id }">${item.partName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			 </div>
			 </div>
			 
			 <!--添加成品分类弹出层-->
			 <div id="part_add2" style=" display:none">
			    <div class="content_style" style="margin-top:30px">
			    
			    
			  	<div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="productType">成品型号 </label>
			       <div class="col-sm-9"><input type="text"  class="col-xs-10 col-sm-11" id="productType" style="margin-left:0px;"></div>
				</div>
				
			   <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="productName">成品名 </label>
			       <div class="col-sm-9"><input type="text"  class="col-xs-10 col-sm-11" id="productName" style="margin-left:0px;"></div>
				</div>
			 </div>
			 </div>
			 
		<div id="Delivery_stop" style=" display:none">
				  <div class="">
				    <div class="content_style" style="margin-top:30px">
				    
				    
				  	<div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">物料名称 </label>
				       <div class="col-sm-9"><label class="col-sm-2 control-label no-padding-right" for="form-field-1" id="typeName"></label></div>
					</div>
					<div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">库存量 </label>
				       <div class="col-sm-9"><label class="col-sm-2 control-label no-padding-right" for="form-field-1" id="inventoryNum">111</label></div>
					</div>
					
					
				 </div>
				  </div>
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
		//记录查看
		$(function(){
			$('table th input:checkbox').on('click' , function(){
				var that = this;
				$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
					
			});
		});
		
		
		
		//成品库数据获取
		$("#chengpinku").click(function(){
			$.post("getfinishedproductsstocks",null,function(result){
				$("#totalPage2").val(result.totalPage);
				$("#currentPage2").val(result.currentPage);
				var a = $("#totalPage2").val();
				var b = $("#currentPage2").val();
				$("#box2").children("a").remove();
				$("#pagination2").pagination({
								currentPage : parseInt(b),
								totalPage : a,
								callback : function(current) {
									$("#current2").text(current);
									$("#currentPage2").val(current);
									$.post("getfinishedproductsstocks",{'currentPage':current},function(result){
										$("#scTables2").children().remove();
										$("#totalPage2").val(result.totalPage);
										$("#currentPage2").val(result.currentPage);
										var data = result.lists;
										for(i in data){
											if(data[i].purchaseWay==1){
												$("#scTables2").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].finishedProductsType.productType+"</td><td>"+data[i].finishedProductsType.productName+"</td><td>"+data[i].inventoryNum+"</td><td>厂家直销</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
											}else if(data[i].purchaseWay==2){
												$("#scTables2").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].finishedProductsType.productType+"</td><td>"+data[i].finishedProductsType.productName+"</td><td>"+data[i].inventoryNum+"</td><td>厂内自产</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
											}else{
												$("#scTables2").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].finishedProductsType.productType+"</td><td>"+data[i].finishedProductsType.productName+"</td><td>"+data[i].inventoryNum+"</td><td>专人定制</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
											}
										}
									},"json");
								}
				});
				$("#scTables2").children().remove();
				var data = result.lists;
				$("#partCount2").html(result.totalCount);
				for(i in data){
					if(data[i].purchaseWay==1){
						$("#scTables2").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].finishedProductsType.productType+"</td><td>"+data[i].finishedProductsType.productName+"</td><td>"+data[i].inventoryNum+"</td><td>厂家直销</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
					}else if(data[i].purchaseWay==2){
						$("#scTables2").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].finishedProductsType.productType+"</td><td>"+data[i].finishedProductsType.productName+"</td><td>"+data[i].inventoryNum+"</td><td>厂内自产</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
					}else{
						$("#scTables2").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].finishedProductsType.productType+"</td><td>"+data[i].finishedProductsType.productName+"</td><td>"+data[i].inventoryNum+"</td><td>专人定制</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
					}
				}
			},"json");
		});
		//添加分类
		$("#sort_add").click(function(){
			layer.open({
		        type: 1,
		        title: '毛坯类别添加',
				maxmin: true, 
				shadeClose:true,
		        area : ['500px' , '250px'],
		        content:$('#part_add'),
				btn:['添加','取消'],
				success:function(layero){
				     var mask = $(".layui-layer-shade");
				     mask.appendTo(layero.parent());
				},
				yes: function(index, layero){
					var partType = $('#partType').val();
					var partClassId = $('#partClassId').val();
					if(partType==""){
						layer.alert('零件型号不能为空！',{
			               title: '提示框',				
						  icon:0,		
						})
						return;
					}
					if(partClassId=="0"){
						layer.alert('请选择零件分类！',{
			               title: '提示框',				
						  icon:0,	
						})
						return;
					}
					$.post("insertparttype",{'partType':partType,'partClassId':partClassId},function(data){
						if(data=="1"){
							layer.close(layer.index);
							layer.msg('已保存!',{icon:1,time:1000});
							$("#partType").val("");
							$("#partClassId").val("0");
						}else{
							layer.msg('添加出现异常!',{icon:2,time:1000});
						}
					},"text");
				}
			});
		});
		//添加成品零件分类
		$("#sort_add2").click(function(){
			layer.open({
		        type: 1,
		        title: '成品类别添加',
				maxmin: true, 
				shadeClose:true,
		        area : ['500px' , '250px'],
		        content:$('#part_add2'),
				btn:['添加','取消'],
				success:function(layero){
				     var mask = $(".layui-layer-shade");
				     mask.appendTo(layero.parent());
				},
				yes: function(index, layero){
					var productType = $('#productType').val();
					var productName = $('#productName').val();
					if(productType==""){
						layer.alert('成品类型不能为空！',{
			               title: '提示框',				
						  icon:0,		
						})
						return;
					}
					if(productName=="0"){
						layer.alert('成品名不能为空！',{
			               title: '提示框',				
						  icon:0,	
						})
						return;
					}
					$.post("insertfinishedproductstype",{'productType':productType,'productName':productName},function(data){
						if(data=="1"){
							layer.close(layer.index);
							layer.msg('已保存!',{icon:1,time:1000});
							$("#productType").val("");
							$("#productName").val("");
						}else{
							layer.msg('添加出现异常!',{icon:2,time:1000});
						}
					},"text");
				}
			});
		});
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
												$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>厂家直销</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
											}else if(data[i].purchaseWay==2){
												$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>厂内自产</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
											}else{
												$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>专人定制</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
											}
										}
									},"json");
								}
				});
				$("#scTables").children().remove();
				var data = result.lists;
				$("#partCount").html(result.totalCount);
				for(i in data){
					if(data[i].purchaseWay==1){
						$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>厂家直销</td><td class='td-manage'><a title='记录查看'   jiluchakan='"+data[i].id+"'   class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
					}else if(data[i].purchaseWay==2){
						$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>厂内自产</td><td class='td-manage'><a title='记录查看' jiluchakan='"+data[i].id+"'  class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
					}else{
						$("#scTables").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td><td>"+data[i].partType.partType+"</td><td>"+data[i].inventoryNum+"</td><td>专人定制</td><td class='td-manage'><a title='记录查看'  jiluchakan='"+data[i].id+"'    class='btn btn-xs btn-info' ><i class='fa fa-info bigger-120'></i></a></td></tr>");
					}	
				}
			},"json");
			
			 $(document).on("click","[jiluchakan]",function(){
				 
				 layer.open({
				        type: 1,
				        title: '详细',
				        shade:false,
						maxmin: true, 
						shadeClose:true,
				        area : ['500px' , '750px'],
				        content:$('#Delivery_stop'),
						btn:['导出至Excel表格','关闭'],
						yes: function(index, layero){		
						if($('#form-field-1').val()==""){
							layer.alert('快递号不能为空！',{
				               title: '提示框',				
							  icon:0,		
							  }) 
							
							}
							layer.close();    		  
						
						}
					});
				 
			  });
			
		});
		
</script>
