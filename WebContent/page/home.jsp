<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/font-awesome.min.css" />
<link
	href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css"
	rel="stylesheet">
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script
	src="${pageContext.request.contextPath }/statics/assets/js/ace-extra.min.js"></script>
<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
<!--[if !IE]> -->
<script
	src="${pageContext.request.contextPath }/statics/assets/js/jquery.min.js"></script>
<!-- <![endif]-->
<script
	src="${pageContext.request.contextPath }/statics/assets/dist/echarts.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>


	<div class="page-content clearfix">
		<div class="alert alert-block alert-success">
			<button type="button" class="close" data-dismiss="alert">
				<i class="icon-remove"></i>
			</button>
			<i class="icon-ok green"></i>欢迎登录，你本次登录时间为${date}，登录IP: ${ip }
		</div>
		<div style="font-family:  微软雅黑">
			<b style="color: #0000ff; font-size: 16px;"> 立足中国，放眼全球</b>，以创新产品和经营，创造性价比和质量优势，成为中国领先，世界有竞争力的汽车空调压缩机优秀供应商。
		</div>
		<br />
		<div>
			<img src="http://www.aotecar.com/images/hefei/banner/banner2.jpg">
		</div>
		<!--记录-->
		<div class="clearfix">
			<div class="home_btn">
				<div>
					<a href="picture-add.html" title="添加商品"
						class="btn  btn-info btn-sm no-radius"> <i class="bigger-200"><img
							src="${pageContext.request.contextPath }/statics/images/icon-addp.png" /></i>
						<h5 class="margin-top">添加商品</h5>
					</a> <a href="Category_Manage.html" title="产品分类"
						class="btn  btn-primary btn-sm no-radius"> <i
						class="bigger-200"><img
							src="${pageContext.request.contextPath }/statics/images/icon-cpgl.png" /></i>
						<h5 class="margin-top">产品分类</h5>
					</a> <a href="admin_info.html" title="个人信息"
						class="btn  btn-success btn-sm no-radius"> <i
						class="bigger-200"><img
							src="${pageContext.request.contextPath }/statics/images/icon-grxx.png" /></i>
						<h5 class="margin-top">个人信息</h5>
					</a> <a href="Systems.html" title="系统设置"
						class="btn  btn-info btn-sm no-radius"> <i class="bigger-200"><img
							src="${pageContext.request.contextPath }/statics/images/xtsz.png" /></i>
						<h5 class="margin-top">系统设置</h5>
					</a> <a href="Order_handling.html" title="商品订单"
						class="btn  btn-purple btn-sm no-radius"> <i
						class="bigger-200"><img
							src="${pageContext.request.contextPath }/statics/images/icon-gwcc.png" /></i>
						<h5 class="margin-top">商品订单</h5>
					</a> <a href="picture-add.html" title="添加广告"
						class="btn  btn-pink btn-sm no-radius"> <i class="bigger-200"><img
							src="${pageContext.request.contextPath }/statics/images/icon-ad.png" /></i>
						<h5 class="margin-top">添加广告</h5>
					</a> <a href="article_add.html" title="添加文章"
						class="btn  btn-info btn-sm no-radius"> <i class="bigger-200"><img
							src="${pageContext.request.contextPath }/statics/images/icon-addwz.png" /></i>
						<h5 class="margin-top">添加文章</h5>
					</a>
				</div>
			</div>

		</div>

	</div>
</body>
</html>
<script type="text/javascript">
	//面包屑返回值
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	$('.no-radius').on('click', function() {
		var cname = $(this).attr("title");
		var chref = $(this).attr("href");
		var cnames = parent.$('.Current_page').html();
		var herf = parent.$("#iframe").attr("src");
		parent.$('#parentIframe').html(cname);
		parent.$('#iframe').attr("src", chref).ready();
		;
		parent.$('#parentIframe').css("display", "inline-block");
		parent.$('.Current_page').attr({
			"name" : herf,
			"href" : "javascript:void(0)"
		}).css({
			"color" : "#4c8fbd",
			"cursor" : "pointer"
		});
		//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
		parent.layer.close(index);

	});
	$(document).ready(function() {
		$(".t_Record").width($(window).width() - 640);
		//当文档窗口发生改变时 触发  
		$(window).resize(function() {
			$(".t_Record").width($(window).width() - 640);
		});
	});
</script>
