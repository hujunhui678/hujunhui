<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css"/>       
        <link href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery.pagination.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath }/statics/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/H-ui.js"></script>     
		<script src="${pageContext.request.contextPath }/statics/assets/js/typeahead-bs2.min.js"></script>           	
		<script src="${pageContext.request.contextPath }/statics/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath }/statics/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="${pageContext.request.contextPath }/statics/assets/laydate/laydate.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath }/statics/assets/js/jquery.easy-pie-chart.min.js"></script>
        <script src="${pageContext.request.contextPath }/statics/js/lrtk.js" type="text/javascript" ></script>
		<script src="${pageContext.request.contextPath }/statics/js/jquery.pagination.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/ace.min.js"></script>
		<title>采购任务单</title>
</head>

<body>
<div class="tabbable">
		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a data-toggle="tab" href="#home"> <i class="red ace-icon fa fa-reply bigger-120"></i> 领料单</a></li>
			<li><a data-toggle="tab" href="#messages" id=shouliaodan><i class="green ace-icon fa fa-recycle bigger-120"></i> 收料单</a></li>
		</ul>

		<div class="tab-content">
		
			<!-- 毛坯库存 -->
			<div id="home" class="tab-pane fade in active">
				<div class="margin clearfix">
 <div class="cover_style" id="cover_style">
 
 <div class="search_style">
     <c:if test="${notAgreeCount>0 }">
     	<div class="Shops_Audit" style="margin-bottom:10px">
		   <div class="prompt">当前共有<b>${notAgreeCount }</b>份领料单请求批准</div>
		 </div>
     </c:if>
     <c:if test="${notAgreeCount==0 }">
     	<div class="Shops_Audit" style="margin-bottom:10px">
		   <div class="prompt">当前没有领料单请求批准</div>
		 </div>
     </c:if>
     <form id="orderForm" action="${pageContext.request.contextPath }/page/materialmanage" method="post">
     	  <!-- 领料单标识 -->
     	  <input type="hidden" name="isReceive" value="2" id="isReceive">
	      <ul class="search_content clearfix">
	       <li><label class="l_f" style="margin-right:10px">审核状态</label>
	       	<select style=" width:100px" name="auditStateId">
	       		<option value="0">全部</option>
	       		<c:forEach var="item" items="${auditStateList }">
	       			<option value="${item.id }" <c:if test="${auditStateId==item.id }">selected</c:if>>${item.auditStateName }</option>
	       		</c:forEach>
	       	</select>
	       </li>
	       <li><label class="l_f">领料单编号</label><input name="materialId" type="text" class="text_add" value="${materialId }" placeholder="领料单编号" style=" width:250px"></li>
	       <li><label class="l_f">发布时间</label><input class="inline laydate-icon" id="start" name="releaseTime" style=" margin-left:10px;" value="${ releaseTime}"></li>
	       <li style="width:90px;"><button type="button" class="btn_search" onclick="javascript:document.forms[0].submit()"><i class="fa fa-search"></i>查询</button></li>
	      </ul>
	      <!-- 存储总页数 -->
		  <input id="totalPage" value=${page.totalPage } type="hidden">
	      <!-- 存储当前页 -->
		  <input id="currentPage" name="currentPage" value="${page.currentPage}" type="hidden">
      </form>
    </div>
 
    <!--内容-->
   <div class="centent_style" id="centent_style">
     <div id="covar_list" class="order_list">
       <div id="scrollsidebar" class="left_Treeview">
        <div class="show_btn" id="rightArrow"><span></span></div>
     </div>
     <!--左侧样式-->
     <div>
      <!--订单列表展示-->
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="150px">领料单编号</th>
				<th width="150px">领用部门</th>			
				<th width="150px">领用人</th>
                <th width="200px">发布时间</th>	
				<th width="100px">审核状态</th>
				<th width="70px">审批状态</th>                
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody>
     
     <c:forEach var="item" items="${page.lists }">
	     <tr>
	     <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
	     <td>${item.id }</td>	
	     <td class="order_product_name">
	      	${item.leadingDept.deptName }
	     </td>
	     <td>${item.receivePerson.name }</td>
	     <td>${item.releaseTime }</td>
	     <td class="td-status">
	     	<c:if test="${item.auditState.id==1 }">
				<span class="label label-warning radius">${item.auditState.auditStateName }</span>
			</c:if>
			<c:if test="${item.auditState.id==2 }">
				<span class="label label-danger radius">${item.auditState.auditStateName }</span>
			</c:if>
			<c:if test="${item.auditState.id==3 }">
				<span class="label label-success radius">${item.auditState.auditStateName }</span>
			</c:if>
	     </td>
	     	
	     <td>
			<c:if test="${item.isAgree==1 }">
				<span class="label label-success radius">已批准</span>
			</c:if>
			<c:if test="${item.isAgree==2 }">
				<span class="label label-warning radius">未批准</span>
			</c:if>
		 </td>
		 <td>
	     <a title="详细" style="cursor:pointer" xiangxi="openDesc" orderId="${item.id }" class="btn btn-xs btn-info order_detailed" ><i class="fa fa-list bigger-120"></i></a>
	     <c:if test="${item.isAgree==2 }">
	     	<a style="display:none" qianshou="qianshou" shenhe="${item.auditState.id }" qianshouren="${admin.id }" href="javascript:;" title="批准" materialId="${item.id }" class="btn btn-xs btn-success"><i class="fa fa-check  bigger-120"></i></a>
	     </c:if>
	     <shiro:hasPermission name="purchasetask:remove">
		 	<a title="删除" href="javascript:;"   class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
		 </shiro:hasPermission>
		 <!-- onclick="Delivery_stop(this,'${item.id}')" -->
	     </td>
	     
	     </tr>
     </c:forEach>
     
     
     <tr>
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
</div>
</div>
			</div>
			
			
			
			<!-- 零件库存 -->
			<div id="messages" class="tab-pane fade">
				<!-- 毛坯库存 -->
			<div id="home" class="tab-pane fade in active">
				<div class="margin clearfix">
 <div class="cover_style" id="cover_style">
 
 <div class="search_style">
     <c:if test="${notAgreeCount>0 }">
     	<div class="Shops_Audit" style="margin-bottom:10px">
		   <div class="prompt">当前共有<b>${notAgreeCount }</b>份领料单请求批准</div>
		 </div>
     </c:if>
     <c:if test="${notAgreeCount==0 }">
     	<div class="Shops_Audit" style="margin-bottom:10px">
		   <div class="prompt">当前没有领料单请求批准</div>
		 </div>
     </c:if>
    </div>
 
    <!--内容-->
   <div class="centent_style" id="centent_style">
     <div id="covar_list" class="order_list">
       <div id="scrollsidebar" class="left_Treeview">
        <div class="show_btn" id="rightArrow"><span></span></div>
     </div>
     <!--左侧样式-->
     <div>
      <!--订单列表展示-->
       <table class="table table-striped table-bordered table-hover" id="sample-table" tableTwo="tableTwo">
		<thead>
		 <tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="150px">收料单编号</th>
				<th width="150px">发布部门</th>			
				<th width="150px">发布人</th>
                <th width="200px">发布时间</th>	
				<th width="100px">审核状态</th>
				<th width="70px">审批状态</th>                
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody id="appendTable">
     
     
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
			
			
			
			
			
			
			
			
			
			
			
			
			

<!-- ///////////////////////////////////////////////////

///////////////////////////
























////////////////////////////////////////////// -->

 <!--发货-->
 <div id="Delivery_stop" style=" display:none">
  <div class="">
    <div class="content_style" style="margin-top:30px">
    
    
  	<div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">订单号 </label>
       <div class="col-sm-9"><input type="text"  class="col-xs-10 col-sm-11" readonly id="id" style="margin-left:0px;"></div>
	</div>
	<!-- 订单需求 -->
	<div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">订单需求 </label>
       <div class="col-sm-9" name="aboutPartType" style="margin-top:5px;margin-left:15px;">
			
		</div>
	</div>
	
    <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">发布时间 </label>
       <div class="col-sm-9"><input type="text"  class="col-xs-10 col-sm-11" readonly id="releaseTime" style="margin-left:0px;"></div>
	</div>
	
	
	<div class="form-group" id="shenhe">
	</div>
		<%-- <c:if test=""></c:if> 已审核 --%>
	<div class="form-group" id="shenheren">
	</div>
	<div class="form-group" id="qianshou">
	</div>
	<div class="form-group" id="shenpiren">
	</div>
	<div class="form-group" id="shenpishijian">
	</div>
	<div class="form-group" id="lingyongbumen">
	</div>
	<div class="form-group" id="lingyongren">
	</div>
	<%-- <c:if test=""></c:if> 审核未通过 --%>
	<div class="form-group" id="weitongguoyuanyin">
	</div>

	<!-- 判断出库时库存是否充足 -->
 	<div class="form-group" style="margin-bottom:20px;" id="kuncunchaxun"><label class="col-sm-2 control-label no-padding-right" for="form-field-1"></label>
    	<div class="col-sm-9" style="margin-left:30px">
    		<button id="chaxun" class="btn btn-info" style="margin-left:70px;margin-top:20px">批准</button>
    	</div>
    </div> 
	
	
 </div>
  </div>
 </div>
</body>
</html>
<script>
//收料单开始
$(function(){
	$("#shouliaodan").click(function(){
		$("#appendTable").children().remove();
		$.post("receivemanage",null,function(result){
			var data = result.lists;
			for(i in data){
				$("#appendTable").append("<tr><td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td><td>"+data[i].id+"</td>	<td class='order_product_name'>"+data[i].releaseDept.deptName+"</td><td>"+data[i].releasePerson.name+"</td><td>"+data[i].releaseTime+"</td><td class='td-status'><span class='label label-warning radius'>"+data[i].auditState.auditStateName+"</span></td><td><span class='label label-success radius'>已批准</span></td><td><a title='详细' style='cursor:pointer' xiangxi='openDesc' orderId='"+data[i].id+"' class='btn btn-xs btn-info order_detailed' ><i class='fa fa-list bigger-120'></i></a></td></tr>");
			}
		},"json");
	});
})
//判断出库时零件是否充足
 $("#chaxun").click(function(){
	var isMiss;
	var json;
	var materialId = $("#id").val();
	$.post("comparisonMaterial",{'materialId':materialId},function(data){
		if(data.length==0){
			isMiss = true;
		}else{
			json=data;
		}
	},"json");
	layer.msg('查询中...', {
		icon : 16,
		time : 500
	},function(){
		if(isMiss){
			layer.confirm('材料充足,是否立即批准?', {
                title:false,
                btnAlign: 'c',
                area: ['20rem', '12rem'],
                btn: ['是', '否'] //按钮
            }, function(index){
            	var auditStateId = $("[shenhe]").attr("shenhe");
        		if(auditStateId!=3){
        			layer.msg('审核未通过无法批准!', {
        				icon : 8,	
        				time : 1000
        			},function(){
        				
        			});
        			return;
        		}
        		var id = $("[materialId]").attr("materialId");
        		var adminId = $("[qianshouren]").attr("qianshouren");
        		var lingyongren = $("[lingyongren]").attr("lingyongren");
        		var lingyongbumen = $("[lingyongbumen]").attr("lingyongbumen");
        		$.post("updateIsAgreeById",{'id':id,'adminId':adminId,'receivePerson':lingyongren,'leadingDept':lingyongbumen},function(data){
        			if(data=="yes"){
        				layer.msg('已保存!', {
        					icon : 1,
        					time : 1000
        				},function(){
        					window.location.reload();
        				})
        			}else if(data=="no"){
        				layer.msg('出现错误,未保存成功!', {
        					icon : 2,
        					time : 1000
        				},function(){
        					window.location.reload();
        				})
        			}else if(data=="error"){
        				layer.msg('参数异常!', {
        					icon : 2,
        					time : 1000
        				},function(){
        					window.location.reload();
        				})
        			}
        		},"text");
                layer.close(index);
                StartGame();
            });
		}else{
			 	var msg='';
				for(var i in json){
					 msg+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;零件名："+json[i].partType.partType+"&nbsp;&nbsp;&nbsp;&nbsp;缺少数量："+json[i].missNum+"<br/>"; 
				}
				
				layer.open({
			        type: 1,
			        title: '提示',
					maxmin: true, 
					shadeClose:true,
			        area : ['350px' ],
			        content:'<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;库存不足：<br/><br/>'+msg+"<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否发起采购单？<br/><br/>",
					btn:['是','否'],
					yes: function(index, layero){	
						alert("跳转到采购单发起页")
						layer.close();    		  
					}
				});
				
		}
	});
}); 

$('#id-button-borders').attr('checked' , 'checked').on('click', function(){
		$('#default-buttons .btn').toggleClass('no-border');
});

//分页
$(function() {
	var a = $("#totalPage").val();
	var b = $("#currentPage").val();
	$("#pagination1").pagination({
						currentPage : parseInt(b),
						totalPage : a,
						callback : function(current) {
							$("#current1").text(current);
							$("#currentPage").val(current);
							$("#orderForm").submit();
						}
		});
});
//左侧栏鼠标悬浮样式
 $(function() { 
	 $(".partTypeClass").mouseover(function(){
		  $(this).css("background-color","#438EB9");
		  $(this).siblings(".partTypeClass").css("background-color","white");
	});
	 $(".partTypeClass").mouseout(function(){
		  $(".	partTypeClass").css("background-color","white");
	});
	 
	$("#cover_style").fix({
		float : 'top',
		minStatue : false,
		skin : 'green',	
		durationTime :false,
		window_height:30,//设置浏览器与div的高度值差
		spacingw:0,//
		spacingh:0,//
		close_btn:'.yingchan_btn',
		show_btn:'.xianshi_btn',
		side_list:'.hide_style',
		widgetbox:'.top_style',
		close_btn_width:60,	
		da_height:'#centent_style,.left_Treeview,.list_right_style',	
		side_title:'.b_n_btn',		
		content:null,
		left_css:'.left_Treeview,.list_right_style'
	});
	//点击采购单零件类型分类后存储到隐藏域中并提交表单
	$(".partTypeClass").click(function(){
		$("#partType").val($(this).attr("partType"));
		$("#orderForm").submit();
	});
	//点击订单批准后改变数据库状态
	$("[qianshou='qianshou']").click(function(){
		var auditStateId = $(this).attr("shenhe");
		if(auditStateId!=3){
			layer.msg('审核未通过无法批准!', {
				icon : 8,	
				time : 1000
			},function(){
				
			});
			return;
		}
		var id = $(this).attr("materialId");
		var adminId = $(this).attr("qianshouren");
		$.post("updateIsAgreeById",{'id':id,'adminId':adminId},function(data){
			if(data=="yes"){
				layer.msg('已保存!', {
					icon : 1,
					time : 1000
				},function(){
					window.location.reload();
				})
			}
		},"text");
	});
	//点击订单详细按钮后弹出的东西
	$("[xiangxi='openDesc']").click(function(){
		var materialId = $(this).attr("orderId");
		$.post("getMaterialDesc?materialId="+materialId,null,function(data){
			$("div[name='aboutPartType']").html("<span class='col-xs-10 col-sm-3'>分类 </span><span class='col-xs-10 col-sm-3'>类别 </span><span class='col-xs-10 col-sm-3'>数量 </span><br/>");
			$("#id").val(data[0].id);
			$("#releaseTime").val(data[0].releaseTime);
			var result = data[0].receiveCollectMaterialDescList;
			for(var i in result){
				$("div[name='aboutPartType']").append("<br/><span class='col-xs-10 col-sm-3'>"+result[i].partType.partClassify.partName+"</span><span class='col-xs-10 col-sm-3'>"+result[i].partType.partType+" </span><span class='col-xs-10 col-sm-3'>"+result[i].orderNum+" </span><br/>");
			}
			$("div[name='aboutPartType']").append("<br/>");
			$("#shenhe").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1' >审核状态 </label>");
			//审核
			if(data[0].auditState.id==1){
				$("#shenheren").remove();
				$("#weitongguoyuanyin").children().remove();
				$("#shenhe").append("<span class='label label-warning radius' style='margin-left:15px;margin-top:3px;'>"+data[0].auditState.auditStateName+"</span>");
			}else if(data[0].auditState.id==2){
				$("#shenheren").remove();
				$("#shenhe").append("<span class='label label-danger radius' style='margin-left:15px;margin-top:3px;'>"+data[0].auditState.auditStateName+"</span>");
				$("#weitongguoyuanyin").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1'>审核未通过原因 </label>");
				$("#weitongguoyuanyin").append("<textarea class='col-xs-10 col-sm-8' rows='5' cols='15' readonly>"+data[0].notPassDesc+"</textarea>");
			}else if(data[0].auditState.id==3){
				$("#weitongguoyuanyin").children().remove();
				$("#shenheren").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1'>审核人 </label>");
				$("#shenhe").append("<span class='label label-success radius' style='margin-left:15px;margin-top:3px;'>"+data[0].auditState.auditStateName+"</span>");
				$("#shenheren").append("<div class='col-sm-9'><input type='text'   class='col-xs-10 col-sm-11' readonly id='auditor' style='margin-left:0px;' value='"+data[0].auditor.name+"'></div>");
			}
			//审批
			if(data[0].isAgree==2){
				$("#kuncunchaxun").show();
				$("#qianshou").children().remove();
				$("#shenpiren").hide();
				$("#shenpishijian").hide();
				$("#qianshou").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1' >审批状态 </label>");
				$("#qianshou").append("<span class='label label-warning radius' style='margin-left:15px;margin-top:3px;'>未批准</span>");
			}else if(data[0].isAgree==1){
				$("#kuncunchaxun").hide();
				$("#shenpiren").show();
				$("#shenpishijian").show();
				$("#qianshou").children().remove();
				$("#qianshou").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1' >审批状态 </label>");
				$("#qianshou").append("<span class='label label-success radius' style='margin-left:15px;margin-top:3px;'>已批准</span>");
				//审批人
				$("#shenpiren").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1' >审批人 </label>");
				$("#shenpiren").append("<div class='col-sm-9'><input type='text'   class='col-xs-10 col-sm-11' readonly id='agreeAdmin' style='margin-left:0px;' value='"+data[0].approver.name+"'></div>");
				//审批时间
				$("#shenpishijian").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1' >审批时间 </label>");
				$("#shenpishijian").append("<div class='col-sm-9'><input type='text'   class='col-xs-10 col-sm-11' readonly id='agreeTime' style='margin-left:0px;' value='"+data[0].agreeTime+"'></div>");
			}
			
			if(data[0].receivePerson){
				$("#lingyongren").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1'>领用人 </label>");
				$("#lingyongren").append("<div class='col-sm-9'><input type='text'   class='col-xs-10 col-sm-11' readonly id='receiveAdmin' lingyongren='"+data[0].receivePerson.id+"' style='margin-left:0px;' value='"+data[0].receivePerson.name+"'></div>");
			}
			if(data[0].leadingDept){
				$("#lingyongbumen").html("<label class='col-sm-2 control-label no-padding-right' for='form-field-1'>领用部门 </label>")
				$("#lingyongbumen").append("<div class='col-sm-9'><input type='text'   class='col-xs-10 col-sm-11' readonly id='leadingDepartment' lingyongbumen='"+data[0].leadingDept.id+"' style='margin-left:0px;' value='"+data[0].leadingDept.deptName+"'></div>");
			}
			},"json");
		layer.open({
	        type: 1,
	        title: '详细',
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
//左侧显示隐藏
$(function() { 
	$("#covar_list").fix({
		float : 'left',
		minStatue : false,
		skin:false,	
		//durationTime :false,
		spacingw:50,//设置隐藏时的距离
	    spacingh:270,//设置显示时间距
		stylewidth:'220',
		close_btn:'.close_btn',
		show_btn:'.show_btn',
		side_list:'.side_list',
		content:'.side_content',
		widgetbox:'.widget-box',
		da_height:null,
		table_menu:'.list_right_style'
	});
});
//时间选择
 laydate({
    elem: '#start',
    event: 'focus' 
});
/*订单-删除*/
function Order_form_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
/**发货**/
function Delivery_stop(obj,id){
	layer.open({
        type: 1,
        title: '发货',
		maxmin: true, 
		shadeClose:false,
        area : ['500px' , ''],
        content:$('#Delivery_stop'),
		btn:['确定','关闭'],
		yes: function(index, layero){		
		if($('#form-field-1').val()==""){
			layer.alert('快递号不能为空！',{
               title: '提示框',				
			  icon:0,		
			  }) 
			
			}
			layer.close();    		  
		
		}
	})
};
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form,.order_detailed').on('click', function(){
	var cname = $(this).attr("title");
	var chref = $(this).attr("href");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe').html(cname);
    parent.$('#iframe').attr("src",chref).ready();;
	parent.$('#parentIframe').css("display","inline-block");
	parent.$('.Current_page').attr({"name":herf,"href":"javascript:void(0)"}).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
    parent.layer.close(index);
});
//初始化宽度、高度  
  var heights=$(".top_style").outerHeight()+47; 
 $(".centent_style").height($(window).height()-heights); 
 $(".page_right_style").width($(window).width()-220);
 $(".left_Treeview,.list_right_style").height($(window).height()-heights-2); 
 $(".list_right_style").width($(window).width()-250);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".centent_style").height($(window).height()-heights); 
	 $(".page_right_style").width($(window).width()-220);
	 $(".left_Treeview,.list_right_style").height($(window).height()-heights-2);  
	 $(".list_right_style").width($(window).width()-250);
	}) 
//比例
var oldie = /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase());
			$('.easy-pie-chart.percentage').each(function(){
				$(this).easyPieChart({
					barColor: $(this).data('color'),
					trackColor: '#EEEEEE',
					scaleColor: false,
					lineCap: 'butt',
					lineWidth: 10,
					animate: oldie ? false : 1000,
					size:103
				}).css('color', $(this).data('color'));
			});
			$('[data-rel=tooltip]').tooltip();
			$('[data-rel=popover]').popover({html:true});
</script>

<script>
			//订单列表
			jQuery(function($) {
				var oTable1 = $('#sample-table').dataTable( {
				"aaSorting": [[ 1, "desc" ]],//默认第几个排序
				"bStateSave": true,//状态保存
				"aoColumnDefs": [
				  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				  {"orderable":false,"aTargets":[0,1,2,3,4,5,6,7,8,9]}// 制定列不参与排序
				] } );
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			});
</script>

