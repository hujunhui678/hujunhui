<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath() + "/page");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/statics/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/statics/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/statics/static/h-ui.admin/skin/default/skin.css"
          id="skin"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/statics/static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/statics/css/jquery.pagination.css"/>


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
					<span class="l"> <a href="javascript:;" onclick="delBatch()"
                                        class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
							批量删除</a>
					</span>
                </span> <span class="r">共有数据：<strong id="total_info"></strong> 条
					</span>
            </div>
            <div class="mt-10">
                <table
                        class="table table-border table-bordered table-hover table-bg">
                    <thead>
                    <tr>
                        <th scope="col" colspan="9">生产表管理</th>
                    </tr>
                    <tr class="text-c">
                        <th width="25"><input type="checkbox" value="" name=""></th>
                        <th width="80">生产表编号</th>
                        <th width="100">生产任务书编号</th>
                        <<th width="100">零件类型</th>
                        <th width="100">生产人</th>
                        <th width="100">实际生产数量</th>
                        <th width="100">完成时间</th>
                        <th width="70">操作</th>
                    </tr>
                    </thead>
                    <tbody id="body_production">

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
    $(function () {
        toPage(1);
    });

    var currentPage;
    var totalPage;
    var pageSize;

    function toPage(pn) {
        $.ajax({
            url:"${APP_PATH}/production_list",
            data:"pn="+pn,
            type:"GET",
            success:function (result) {
                var pageInfo = result.extend.pageInfo;
                currentPage=pageInfo.pageNum;
                totalPage=pageInfo.pages;
                pageSize=pageInfo.pageSize;
                $("#total_info").empty();
                $("#total_info").append(pageInfo.total);

                build_table(result);
                initPagination();
            }
        })
    }

    function build_table(result) {
        var body=$("#body_production").empty();
        var prosuctions=result.extend.pageInfo.list;
        $.each(prosuctions, function (index, item) {
            var tr=$("<tr></tr>").addClass("text-c");
            var check=$("<td></td>").append(
                $("<input>").attr("value",item.id).attr("id","check").attr("type","checkbox")
            );
            var id=$("<td></td>").append(item.id);
            var taskId=$("<td></td>").append(item.taskId);
            var partType=$("<td></td>").append(item.partTypeEntity.partType);
            var productionPeopleEntityName=$("<td></td>").append(item.productionPeopleEntity.name);
            var realQuantity=$("<td></td>").append(item.realQuantity);
            var finishedTime=$("<td></td>").append(timestampToTime(item.finishedTime));

            var editTd=$("<td></td>").addClass("f-14");
            var a1=$("<a></a>").attr("title","编辑").attr("href","javascript:;")
                .attr("onclick","production_edit('编辑生产表','${APP_PATH}/production_modify.jsp',"+item.id+",'800','400')")
                .attr("style","text-decoration: none")
                .append(
                    $("<i></i>").addClass("Hui-iconfont").append("&#xe6df;")
                );
            var a2=$("<a></a>").addClass("ml-5").attr("title","删除").attr("href","javascript:;")
                .attr("onclick","production_del("+item.id+")")
                .attr("style","text-decoration: none")
                .append(
                    $("<i></i>").addClass("Hui-iconfont").append("&#xe6e2;")
                );
            editTd.append(a1).append(a2);
            tr.append(check);
            tr.append(id);
            tr.append(taskId);
            tr.append(partType);
            tr.append(productionPeopleEntityName);
            tr.append(realQuantity);
            tr.append(finishedTime);
            tr.append(editTd);
            body.append(tr);
        });
    }

    function initPagination() {
        $("#pagination1").pagination( {
            currentPage:parseInt(currentPage),
            totalPage:totalPage,
            callback:function(clickedPage){
                toPage(clickedPage);
            }
        });
    }
  
    function production_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    function production_edit(title, url, id, w, h) {
        layer_show(title,url+"?id="+id,w,h);
    }

    function production_del(id) {
        layer.confirm('将会删除所有信息,确认要删除此生产表吗？',{icon:3}, function(index) {
            if(id != ""){
                sendAjaxDel(id);
            }
        });
    }

    function delBatch() {
        var ids = "";
        $("#check:checked").each(function (index) {
            ids += $(this).val() + "-";
        });
        //去除多余的"-"
        ids.substring(0, ids.length - 1);
        if (ids === "") {
            layer.alert('请先选择要删除的生产栏!', {icon: 5});
            return;
        }
        layer.confirm('确认进行批量删除吗？', {icon: 3}, function () {
            if (ids != "") {
                sendAjaxDel(ids);
            }
        });
    }

    /*发送ajax删除请求*/
    function sendAjaxDel(ids) {
        $.ajax({
            url: "${APP_PATH}/production_del/" + ids,
            type: "DELETE",
            success: function (result) {
                var icon = result.code === 100 ? 1 : 2;
                layer.msg(result.msg, {
                    icon: icon,
                    time: 1000
                }, function () {
                    location.reload();
                    layer_close();
                });
            }
        });
    }
    function timestampToTime(timestamp) {
		var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		var Y = date.getFullYear() + '-';
		var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1)
				: date.getMonth() + 1)
				+ '-';
		var D = date.getDate() + ' ';
		var h = date.getHours() + ':';
		var m = date.getMinutes() + ':';
		var s = date.getSeconds();
		return Y + M + D + h + m + s;
	}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>