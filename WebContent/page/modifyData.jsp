<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link
	href="${pageContext.request.contextPath }/statics/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/pwd.css" />
<link
	href="${pageContext.request.contextPath }/statics/assets/css/codemirror.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/font/css/font-awesome.min.css" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script
	src="${pageContext.request.contextPath }/statics/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/layer/layer.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/laydate/laydate.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/typeahead-bs2.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/assets/js/jquery.dataTables.bootstrap.js"></script>
</head>
<body>
	<div class="clearfix">
		<div class="admin_info_style">
			<div class="admin_modify_style" id="Personal">
				<div class="type_title">管理员信息</div>
				<input type="hidden" id="id" value="${admin.id}">
				<div class="xinxi">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">姓名： </label>
						<div class="col-sm-9">
							<input type="text" name="姓名" id="name" value="${admin.name}"
								class="col-xs-7 text_info" disabled="disabled">
							&nbsp;&nbsp;&nbsp;<a href="javascript:void()"
								onclick="change_Password()" class="btn btn-warning btn-xs">修改密码</a>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">登录名： </label>
						<div class="col-sm-9">
							<input type="text" name="登录名" id="loginName"
								value="${admin.loginName}" class="col-xs-7 text_info"
								disabled="disabled"> <span id="msg"
								style="color: red; font-weight: bolder;"></span><input
								type="hidden" value="${admin.loginName}" id="oldLoginName">
							<input type="hidden" value="${count}" id="count">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">住址： </label>
						<div class="col-sm-9">
							<input type="text" name="地址" id="address"
								value="${admin.address}" class="col-xs-7 text_info"
								disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">联系方式： </label>
						<div class="col-sm-9">
							<input type="text" name="联系方式" id="phone" value="${admin.phone}"
								class="col-xs-7 text_info" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">入职时间： </label>
						<div class="col-sm-9">
							<span> <fmt:formatDate value="${admin.entryTime}"
									pattern="yyyy-MM-dd" />
							</span>
						</div>
					</div>
					<div class="Button_operation clearfix">
						<button onclick="modify();" class="btn btn-danger radius"
							type="submit" style="margin-left: 70px;">修改信息</button>
						<button onclick="save_info();" class="btn btn-success radius"
							type="button">保存修改</button>
					</div>
				</div>
			</div>
			<div class="recording_style">
				<div class="type_title">管理员登录记录</div>
				<div class="recording_list">
					<table
						class="table table-border table-bordered table-bg table-hover table-sort"
						id="sample-table">
						<thead>
							<tr class="text-c">
								<th width="25"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th width="80">ID</th>
								<th width="100">类型</th>
								<th>内容</th>
								<th width="17%">登录地点</th>
								<th width="10%">用户名</th>
								<th width="120">客户端IP</th>
								<th width="150">时间</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><label><input type="checkbox" class="ace"><span
										class="lbl"></span></label></td>
								<td>15686</td>
								<td>1</td>
								<td>登录成功!</td>
								<td>江苏南京</td>
								<td>admin</td>
								<td>61.233.7.80</td>
								<td>2014-6-11 11:11:42</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--修改密码样式-->
	<div class="change_Pass_style" id="change_Pass">
		<ul class="xg_style">

			<li><div style="padding: 25px 0 0 55px;">
					<label class="label_name">原&nbsp;&nbsp;密&nbsp;码 : </label> <input
						name="原密码" type="password" class="ywz_zhuce_kuangwenzi1"
						id="oldPwd" style="margin: 6px 0 0 16px;">
				</div> <span id="msgPwd" style="padding-left: 20px;"></span></li>
			<li>
				<div class="ywz_zhucexiaobo">
					<div class="ywz_zhuce_youjian">设置密码：</div>
					<div class="ywz_zhuce_xiaoxiaobao">
						<div class="ywz_zhuce_kuangzi">
							<input name="tbPassword" type="password" id="tbPassword"
								class="ywz_zhuce_kuangwenzi1" />
						</div>
						<div class="ywz_zhuce_huixian" id='pwdLevel_1'></div>
						<div class="ywz_zhuce_huixian" id='pwdLevel_2'></div>
						<div class="ywz_zhuce_huixian" id='pwdLevel_3'></div>
						<div class="ywz_zhuce_hongxianwenzi">弱</div>
						<div class="ywz_zhuce_hongxianwenzi">中</div>
						<div class="ywz_zhuce_hongxianwenzi">强</div>
					</div>
					<div class="ywz_zhuce_yongyu1">
						<span id="pwd_tip" style="color: #898989"><font
							style="color: #F00">*</font> 6-16位，由字母（区分大小写）、数字、符号组成</span> <span
							id="pwd_err" style="color: #f00; display: none;">6-16位，由字母（区分大小写）、数字、符号组成</span>
					</div>
				</div>
			</li>
			<br>
			<br>
			<li><div style="padding: 25px 0 0 55px;">
					<label class="label_name">&nbsp;确认密码 : </label> <input name="确认密码"
						type="password" class="ywz_zhuce_kuangwenzi1" id="c_password"
						style="margin: 6px 0 0 16px;">
				</div></li>
		</ul>
		<!--       <div class="center"> <button class="btn btn-primary" type="button" id="submit">确认修改</button></div>-->
	</div>
</body>
</html>
<script>
	$(function() {
		$("#loginName").focus(function() {
			var count = $("#count").val();
			if (count < 1) {
				$("#msg").html("&nbsp;&nbsp;仅能修改一次!");
			} else {
				$("#msg").html("");
			}
		});

		$("#oldPwd").blur(function() {
			var id = $("#id").val();
			var pwd = $("#oldPwd").val();
			$.post("getOldPwd.html", {
				'id' : id,
				'pwd' : pwd
			}, function(data) {
				if (data == "ok") {
					$(".layui-layer-btn0").show();
					$("#msgPwd").text("√");
					$("#msgPwd").css("color", "green");
				} else {
					$("#msgPwd").text("与原密码不符!");
					$("#msgPwd").css("color", "red");
					$(".layui-layer-btn0").hide();
				}
			});
		});
	});
	//按钮点击事件
	function modify() {
		$('.text_info').attr("disabled", false);
		var count = $("#count").val();

		$('.text_info').addClass("add");
		$('#Personal').find('.xinxi').addClass("hover");
		$('#Personal').find('.btn-success').css({
			'display' : 'block'
		});
		if (count > 0) {
			$("#loginName").attr("readonly", true);
		}

	};
	function save_info() {
		var num = 0;
		var str = "";
		$(".xinxi input[type$='text']").each(function(n) {
			if ($(this).val() == "") {
				layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
					title : '提示框',
					icon : 0,
				});
				num++;
				return false;
			}
		});
		if (num > 0) {
			return false;
		} else {

			var id = $("#id").val();
			var name = $("#name").val();
			var loginName = $("#loginName").val();
			var oldLoginName = $("#oldLoginName").val();
			var phone = $("#phone").val();
			var address = $("#address").val();
			var loginNameModifyCount = 0;
			if (loginName != oldLoginName) {
				loginNameModifyCount = 1;
			}
			$.post("modifyAdminData.html", {
				'id' : id,
				'name' : name,
				'loginName' : loginName,
				'loginNameModifyCount' : loginNameModifyCount,
				'phone' : phone,
				'address' : address,
			}, function(data) {
				if (data == "ok") {
					layer.alert('修改成功！', {
						title : '提示框',
						icon : 1,
					});
					$("#msg").html("");
					$('#Personal').find('.xinxi').removeClass("hover");
					$('#Personal').find('.text_info').removeClass("add").attr(
							"disabled", true);
					$('#Personal').find('.btn-success').css({
						'display' : 'none'
					});
					layer.close(index);
				}
			});
		}
	};
	//初始化宽度、高度    
	$(".admin_modify_style").height($(window).height());
	$(".recording_style").width($(window).width() - 400);
	//当文档窗口发生改变时 触发  
	$(window).resize(function() {
		$(".admin_modify_style").height($(window).height());
		$(".recording_style").width($(window).width() - 400);
	});
	//修改密码
	function change_Password() {
		layer.open({
			type : 1,
			title : '修改密码',
			area : [ '700px', '350px' ],
			shadeClose : true,
			content : $('#change_Pass'),
			btn : [ '确认修改' ],
			yes : function(index, layero) {
				if ($("#oldPwd").val() == "") {
					layer.alert('原密码不能为空!', {
						title : '提示框',
						icon : 0,
					});
					return false;
				}
				if ($("#tbPassword").val() == "") {
					layer.alert('新密码不能为空!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				}

				if ($("#c_password").val() == "") {
					layer.alert('确认新密码不能为空!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				}
				if (!$("#tbPassword").val
						|| $("#c_password").val() != $("#tbPassword").val()) {
					layer.alert('密码不一致!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				} else {
					var id = $("#id").val();
					var pwd = $("#c_password").val();
					$.post("updatePwd.html", {
						'id' : id,
						'password' : pwd,
					}, function(data) {
						alert(data);
					});
					layer.alert('密码重置成功,需重新登录...', {
						title : '提示框',
						icon : 1,
					});
					parent.location.href = "${pageContext.request.contextPath }/page/loginout";
				}
			}
		});
	}
</script>
<script>
	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 2, 3, 4, 5, 6 ]
			} // 制定列不参与排序
			]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});
	});
</script>
<script src="${pageContext.request.contextPath }/statics/js/pwd.js"></script>
