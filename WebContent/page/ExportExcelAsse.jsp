<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="http://oss.sheetjs.com/js-xlsx/xlsx.full.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
<!--调用FileSaver saveAs函数可以实现文件下载-->
<!--<script src="http://sheetjs.com/demos/Blob.js"></script>
    <script src="http://sheetjs.com/demos/FileSaver.js"></script>-->
<script>
	//如果使用 FileSaver.js 就不要同时使用以下函数
	function saveAs(obj, fileName) {//当然可以自定义简单的下载文件实现方式 
		var tmpa = document.createElement("a");
		tmpa.download = fileName || "下载";
		tmpa.href = URL.createObjectURL(obj); //绑定a标签
		tmpa.click(); //模拟点击实现下载
		setTimeout(function() { //延时释放
			URL.revokeObjectURL(obj); //用URL.revokeObjectURL()来释放这个object URL
		}, 100);
	}
	function p(s) {
		return s < 10 ? '0' + s : s;
	}

	var myDate = new Date();
	//获取当前年
	var year = myDate.getFullYear();
	//获取当前月
	var month = myDate.getMonth() + 1;
	//获取当前日
	var date = myDate.getDate();
	var h = myDate.getHours(); //获取当前小时数(0-23)
	var m = myDate.getMinutes(); //获取当前分钟数(0-59)
	var s = myDate.getSeconds();
	var now = year + "-" + p(month) + "-" + p(date) + "  " + p(h) + "：" + p(m)
			+ "：" + p(s);

	const wopts = {
		bookType : 'xlsx',
		bookSST : false,
		type : 'binary'
	};//这里的数据是用来定义导出的格式类型
	// const wopts = { bookType: 'csv', bookSST: false, type: 'binary' };//ods格式
	// const wopts = { bookType: 'ods', bookSST: false, type: 'binary' };//ods格式
	// const wopts = { bookType: 'xlsb', bookSST: false, type: 'binary' };//xlsb格式
	// const wopts = { bookType: 'fods', bookSST: false, type: 'binary' };//fods格式
	// const wopts = { bookType: 'biff2', bookSST: false, type: 'binary' };//xls格式

	function downloadExl() {
		var keysArr = new Array("1", "2", "3", "4", "5");
		var rows = document.getElementById("a").rows.length; //获得行数(包括thead)
		var colums = document.getElementById("a").rows[0].cells.length; //获得列数 
		var json = "[";
		var tdName;
		var tdValue;
		for (var i = 0; i < rows; i++) { //每行 
			json += "{";
			for (var j = 0; j < colums; j++) {
				tdName = keysArr[j]; //Json数据的键 
				json += "\""; //加上一个双引号 
				json += tdName;
				json += "\"";
				json += ":";
				tdValue = document.getElementById("a").rows[i].cells[j].innerHTML;//Json数据的值 
				if (j === 1) {//第1列是日期格式，需要按照json要求做如下添加 
					tdValue = "\ " + tdValue + "";
				}
				json += "\"";
				json += tdValue;
				json += "\"";
				json += ",";
			}
			json = json.substring(0, json.length - 1);
			json += "}";
			json += ",";
		}
		json = json.substring(0, json.length - 1);
		json += "]";
		var a = $.parseJSON(json);
		const wb = {
			SheetNames : [ 'Sheet1' ],
			Sheets : {},
			Props : {}
		};
		wb.Sheets['Sheet1'] = XLSX.utils.json_to_sheet(a);
		//通过json_to_sheet转成单页(Sheet)数据
		saveAs(new Blob([ s2ab(XLSX.write(wb, wopts)) ], {
			type : "application/octet-stream"
		}), now + '.' + (wopts.bookType == "biff2" ? "xls" : wopts.bookType));
	}
	function s2ab(s) {
		if (typeof ArrayBuffer !== 'undefined') {
			var buf = new ArrayBuffer(s.length);
			var view = new Uint8Array(buf);
			for (var i = 0; i != s.length; ++i)
				view[i] = s.charCodeAt(i) & 0xFF;
			return buf;
		} else {
			var buf = new Array(s.length);
			for (var i = 0; i != s.length; ++i)
				buf[i] = s.charCodeAt(i) & 0xFF;
			return buf;
		}
	}
</script>
</head>

<body>
	<table width="90%" border="1" cellpadding="8" cellspacing="0"
		class="tableBasic" id="a">
		<tr>
			<td width="80" align="center">任务书编号</td>
			<td width="100" align="center" class="nameT">成品类型</td>
			<td width="50" align="center">装配班长</td>
			<td width="50" align="center">零件配方</td>
			<td width="80" align="center">预计完成时间</td>
		</tr>
		<c:forEach var="item" items="${Asse}">
			<tr>
				<td align="center">${item.id}</td>
				<td align="center" class="nameT">${item.finishedTypeEntity.productType}</td>
				<td align="center">${item.assemblyLeaderEntity.name}</td>
				<td align="center">${item.partformulaEntity.formulaName}</td>
				<td align="center"><fmt:formatDate
						value="${item.estimatedTimeOfCompletion}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
	</table>
	<button style="padding: 10px; margin-top: 20px; margin-left: 10px;"
		onclick="downloadExl()">导出至Excel</button>
</body>
</html>
