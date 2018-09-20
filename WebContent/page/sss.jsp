<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			 	 
    
     <table>
  
    <tr>
    <td>编号</td>
    <td>姓名</td>
    <td>手机号</td>
    <td>公司</td>
  
    </tr>
    <c:forEach var="ss" items="${clients}">
      <tr>
    <td>${ss.id}</td>
		<td>${ss.clientName}</td>
		<td>${ss.clientContact}</td>
		<td>${ss.clientCompany}</td>
    </tr>
    </c:forEach>  
    </table>
</body>
</html>