<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css"/>       
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/assets/css/font-awesome.min.css" />
        <link href="${pageContext.request.contextPath }/statics/Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery.pagination.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
	    <script src="${pageContext.request.contextPath }/statics/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath }/statics/assets/js/typeahead-bs2.min.js"></script>
       
		<!-- page specific plugin scripts -->
        <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/H-ui.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/H-ui.admin.js"></script> 
        <script src="${pageContext.request.contextPath }/statics/assets/layer/layer.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath }/statics/assets/laydate/laydate.js" type="text/javascript"></script>
         <script src="${pageContext.request.contextPath }/statics/assets/dist/echarts.js"></script>
         <script src="${pageContext.request.contextPath }/statics/js/lrtk.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath }/statics/js/jquery.pagination.min.js"></script>
<title>品牌管理</title>
</head>

<body>
<div class="page-content clearfix">
  <div id="brand_style">
    <div class="search_style">
     
      <form id="form" action="${pageContext.request.contextPath }/page/getstorehouseoutinrecordsForm" method="post">
      	<ul class="search_content clearfix">
	       <li><label class="l_f">出入库记录单号</label><input id="recordId" type="text"  class="text_add" placeholder="输入记录单号"  style="width:250px" name="recordId" value="${recordId }"/></li>
	       <li><label class="l_f">出库/入库时间</label><input class="inline laydate-icon" id="start" style="margin-left:10px;" name="time" value="${time }"></li>
	       <li>
	       		<select class="text_add" id="isOut" name="isOut">
			       <option value="-1">全部</option>
			       <option  value="1" <c:if test="${isOut==1 }">selected</c:if>>出库</option>
			       <option  value="2" <c:if test="${isOut==2 }">selected</c:if>>入库</option>
			    </select>
	       </li>
	       <li style="width:90px;"><button type="button" class="btn_search" onclick="formSubmit()"><i class="icon-search"></i>查询</button></li>
	      	  <!-- 存储总页数 -->
			  <input id="totalPage" type="hidden" value="${page.totalPage }">
		      <!-- 存储当前页 -->
			  <input id="currentPage" name="currentPage" type="hidden" value="${page.currentPage }">
			  <!-- 存储入库记录条数 -->
			  <input type="hidden" id="inCount" value="${inCount }">
			  <!-- 存储出库记录条数 -->
			  <input type="hidden" id="outCount" value="${outCount }">
	      </ul>
      </form>
    </div>
     <div class="border clearfix">
       <span class="l_f">
        <a href="Add_Brand.html"  title="添加品牌" class="btn btn-warning Order_form"><i class="icon-plus"></i>添加品牌</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
        <a href="javascript:ovid()" class="btn btn-info">国内品牌</a>
        <a href="javascript:ovid()" class="btn btn-success">国外品牌</a>
       </span>
       <span class="r_f">共：<b>234</b>个品牌</span>
     </div>
    <!--品牌展示-->
     <div class="brand_list clearfix" id="category">
     <div class="show_btn" id="rightArrow"><span></span></div>
     <div class="chart_style side_content">
     <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
         <div id="main" style="height:300px;" class="side_list"></div>
     </div>
     <!--品牌列表-->
      <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="180px">记录单号</th>
				<th width="80px">出库/入库</th>
				<th width="120px">负责人</th>
				<th width="120px">操作人</th>
				<th width="130px">领用部门</th>
				<th width="130px">领用人</th>
				<th width="130px">出库/入库时间</th>
				<th width="120px">备注</th>                
				<th width="100px">操作</th>
			</tr>
		</thead>
	<tbody  id="scTables">
        <c:forEach var="item" items="${page.lists }">
        	<tr>
        	<td width='180px'>${item.id }</td>
        	<td width='80px'>
        		<c:if test="${item.isOut==2 }">
        			入库
        		</c:if>
        		<c:if test="${item.isOut==1 }">
        			出库
        		</c:if>
        	</td>
        	<td>${item.principalAdmin.name }</td>
        	<td>${item.empName }</td>
        	<td>${item.leadingDepartment.deptName }</td>
        	<td class='text-l'>${item.receiveAdmin.name }</td>
        	<td>${item.time }</td>
        	<td>${item.remark }</td>
        	<td class='td-manage'>
        	<a title='详情' onclick='' href='javascript:;'  class='btn btn-xs btn-info' >
        	<i class='icon-edit bigger-120'></i></a>
        	 </td>
        	 </tr>
        </c:forEach>
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
</div>
</body>
</html>
<script>
function formSubmit(){
	document.forms[0].submit();
}
// ajax获取出入库记录分页数据
$(function(){
		var a = $("#totalPage").val();
		var b = $("#currentPage").val();
		$("#pagination1").pagination({
						currentPage : parseInt(b),
						totalPage : a,
						callback : function(current) {
							$("#current1").text(current);
							$("#currentPage").val(current);
							var recordId=$("#recordId").val();
							var time = $("#start").val();
							var isOut = $("#isOut").val();
							$.post("getstorehouseoutinrecords",{'currentPage':current,'recordId':recordId,'time':time,'isOut':isOut},function(result){
								$("#scTables").children().remove();
								$("#totalPage").val(result.totalPage);
								$("#currentPage").val(result.currentPage);
								var data = result.lists;
								for(i in data){
									if(data[i].isOut==1){
										$("#scTables").append("<tr><td width='25px'><label><input type='checkbox' class='ace' ><span class='lbl'></span></label></td><td width='180px'>"+data[i].sid+"</td><td width='80px'>出库</td><td>"+data[i].principalAdmin.name+"</td><td>"+data[i].empName+"</td><td>"+data[i].leadingDepartment.deptName+"</td><td class='text-l'>"+data[i].receiveAdmin.name+"</td><td>"+data[i].time+"</td><td>"+data[i].remark+"</td><td class='td-manage'><a title='详情' onclick='' href='javascript:;'  class='btn btn-xs btn-info' ><i class='icon-edit bigger-120'></i></a> </td></tr>");
									}else{
										$("#scTables").append("<tr><td width='25px'><label><input type='checkbox' class='ace' ><span class='lbl'></span></label></td><td width='180px'>"+data[i].sid+"</td><td width='80px'>入库</td><td>"+data[i].principalAdmin.name+"</td><td>"+data[i].empName+"</td><td>"+data[i].leadingDepartment.deptName+"</td><td class='text-l'>"+data[i].receiveAdmin.name+"</td><td>"+data[i].time+"</td><td>"+data[i].remark+"</td><td class='td-manage'><a title='详情' onclick='' href='javascript:;'  class='btn btn-xs btn-info' ><i class='icon-edit bigger-120'></i></a></td></tr>");
									}
								}
							},"json");
						}
		});
});
	
jQuery(function($) {
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			
			
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			});


//初始化宽度、高度  
 $(".chart_style").height($(window).height()-215);
  $(".table_menu_list").height($(window).height()-215);
  $(".table_menu_list ").width($(window).width()-440);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	 $(".chart_style").height($(window).height()-215);
	 $(".table_menu_list").height($(window).height()-215);
	 $(".table_menu_list").width($(window).width()-440);
	});	
	//图层隐藏限时参数		 
$(function() { 
	$("#category").fix({
		float : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false,
		stylewidth:'400',
		spacingw:30,//设置隐藏时的距离
	    spacingh:440,//设置显示时间距
	});
});
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form ,.brond_name').on('click', function(){
	var cname = $(this).attr("title");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe span').html(cname);
	parent.$('#parentIframe').css("display","inline-block");
    parent.$('.Current_page').attr("name",herf).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+">" + cnames + "</a>");
    parent.layer.close(index);
	
});
function generateOrders(id){
	window.location.href = "Brand_detailed.html?="+id;
};
/*品牌-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*品牌-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!',{icon: 6,time:1000});
	});
}
/*品牌-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*品牌-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
laydate({
    elem: '#start',
    event: 'focus' 
});


</script>
 <script type="text/javascript">
        require.config({
            paths: {
                echarts: '${pageContext.request.contextPath }/statics/assets/dist'
            }
        });
        require(
            [
            	 'echarts',
                 'echarts/chart/pie',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
                 'echarts/chart/funnel'
            ],
            function (ec) {
                var myChart = ec.init(document.getElementById('main'));
			
			option = {
    title : {
        text: '出库入库比例',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['入库记录','出库记录']
    },
    toolbox: {
        show : false,
        feature : {
            mark : {show: false},
            dataView : {show: false, readOnly: false},
            magicType : {
                show: true, 
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 545
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name:'记录数',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:document.getElementById("inCount").value, name:'入库记录'},
                {value:document.getElementById("outCount").value, name:'出库记录'},

            ]
        }
    ]
};
   myChart.setOption(option);
			}
);
</script>