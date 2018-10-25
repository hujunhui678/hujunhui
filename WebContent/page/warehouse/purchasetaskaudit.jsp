<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
		<script src="${pageContext.request.contextPath }/statics/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/assets/js/typeahead-bs2.min.js"></script>           	
        <script src="${pageContext.request.contextPath }/statics/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="${pageContext.request.contextPath }/statics/assets/laydate/laydate.js" type="text/javascript"></script>
<title>交易金额</title>
</head>

<body>
<div class="margin clearfix">
 <div class="detailed_style clearfix">
 <em class="type"></em>
  <div class="shop_logo"><img src="${pageContext.request.contextPath }/statics/images/caigoudan.jpg" /></div>
   <ul class="shop_content clearfix">
    <li class="shop_name"><label class="label_name">采购单号：</label><span class="info" id="orderId"0000000000000000>ATC${purchase[0].purchaseOrderId }</span> </li>
    <li><label class="label_name">店铺类型：</label><span class="info">个人店铺</span></li>
    <li><label class="label_name">采购分类：</label><span class="info">零件</span></li>
    <li><label class="label_name">申请时间：</label><span class="info"><fmt:formatDate value="${purchase[0].purchaseOrder.purchaseTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span></li>
    <li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span class="info">${purchase[0].purchaseOrder.auditState.auditStateName }</span></li>
    <li><label class="label_name">采购员姓名：</label><span class="info">${purchase[0].purchaseOrder.buyerEmp.name }</span></li>
    <li><label class="label_name">是否签收：</label><span class="info">
    	<c:if test="${purchase[0].purchaseOrder.isSignin==0 }">
    		未签收
    	</c:if>
		<c:if test="${purchase[0].purchaseOrder.isSignin==1 }">
    		已签收
    	</c:if>
    </span></li>
    <li><label class="label_name">签收人：</label><span class="info">${purchase[0].purchaseOrder.consigneeEmp.name }</span></li>
    <li><label class="label_name">领用部门：</label><span class="info">${purchase[0].purchaseOrder.leadingDepartment.deptName }</span></li>
    <li><label class="label_name">领用人：</label><span class="info">${purchase[0].purchaseOrder.receiveAdmin.name }</span></li>
    <input type="hidden" id="admin" value="${admin.id }" />
   </ul>
 </div>
 <div class="Store_Introduction">
  <div class="title_name">采购明细</div>
   <div class="info">
   		<table border="0" cellpadding="0" cellspacing="0" style="width:1650px;" align="center"  class="table table-hover">
   			<tr style="background-color:#E5FAFF;line-height:35px">
   				<th style="text-align: center;color:#666">零件类型</th>
   				<th style="text-align: center;color:#666">采购数量</th>
   				<th style="text-align: center;color:#666">所属类别</th>
   			</tr>
   			<c:forEach var="item" items="${purchase }">
   				<tr style='line-height:35px'>
   					<td style="text-align: center;">${item.partType.partType }</td>
   					<td style="text-align: center;">${item.orderNum }</td>
   					<td style="text-align: center;">${item.partType.partClassify.partName }</td>
   				</tr>
   			</c:forEach>
   		</table>
   </div>
 </div>
 <div class="At_button">
				<button onclick="through_save()" class="btn btn-primary radius" type="submit">通  过</button>
				<button onclick="cancel_save();" class="btn btn-danger  btn-warning" type="button">拒  绝</button>
				<button onclick="return_close();" class="btn btn-default radius" type="button">返回上一步</button>
 </div>
</div>
</body>
</html>
<script type="text/javascript">
//通过
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
 function through_save(){
	 layer.confirm('确定通过该采购单吗？',function(index){
		 var orderId = $("#orderId").html();
		 var admin =$("#admin").val();
		$.post("updateauditstate",{'orderId':orderId,'auditor':admin},function(data){
			if(data=="1"){
				layer.msg('审核已通过!',{icon:1,time:1000},function(){
					location.href="${pageContext.request.contextPath}/page/purchasetask";
					parent.$('#parentIframe').css("display","none");
					parent.$('.Current_page').css({"color":"#333333"});
				});
			}else{
				layer.msg('参数异常，未审核成功!',{icon:2,time:1000},function(){
					location.href="${pageContext.request.contextPath}/page/purchasetask";
					parent.$('#parentIframe').css("display","none");
					parent.$('.Current_page').css({"color":"#333333"});
				});
			}
		},"text");
		
	});
	 
	 
	 }
	 
	 //返回操作
function return_close(){
		history.go(-1);
		parent.$('#parentIframe').css("display","none");
		parent.$('.Current_page').css({"color":"#333333"});
	}
	 //拒绝
function cancel_save(){
	var orderId=$("#orderId").html();
	var index = layer.open({
        type: 1,
        title: '提示',
		maxmin: true, 
		shadeClose:false,
        area : ['600px' , ''],
        content:('<div class="shop_reason"><span class="content">请说明拒绝该申请人采购单的理由，以便下次在申请时做好准备	。</span><textarea name="请填写拒绝理由" class="form-control" id="form_textarea" placeholder="请填写拒绝理由" onkeyup="checkLength(this);"></textarea><span class="wordage">剩余字数：<span id="sy" style="color:Red;">500</span>字</span></div>'),
		btn:['确定','取消'],
		yes: function(index, layero){	
		if($('.form-control').val()==""){
				layer.alert('回复内容不能为空！',{
               title: '提示框',				
			  icon:0,		
			  });
			 }else{
				 var notPassDesc = $('.form-control').val();
				 $.post("updatenotpassdesc",{'orderId':orderId,'notPassDesc':notPassDesc},function(data){
					 if(data=="1"){
						 	layer.msg('提交成功!',{icon:1,time:1000},function(){
						 		location.href="${pageContext.request.contextPath}/page/purchasetask";
								parent.$('#parentIframe').css("display","none");
								parent.$('.Current_page').css({"color":"#333333"});
						 	});
					 }else{
						 layer.msg('提交失败!',{icon:1,time:1000},function(){
								location.href="${pageContext.request.contextPath}/page/purchasetask";
								parent.$('#parentIframe').css("display","none");
								parent.$('.Current_page').css({"color":"#333333"});
						 });
					 }
				 },"text");
				 
			 }
		}
	})
	
	}
		/*字数限制*/
function checkLength(which) {
	var maxChars = 500; //
	if(which.value.length > maxChars){
	   layer.open({
	   icon:2,
	   title:'提示框',
	   content:'您输入的字数超过限制!',	
    });
		// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
		which.value = which.value.substring(0,maxChars);
		return false;
	}else{
		var curr = maxChars - which.value.length; //减去当前输入的
		document.getElementById("sy").innerHTML = curr.toString();
		return true;
	}
};
</script>
