<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>年纪</td>
	</tr>
	<c:forEach items="${PageInfo.list}" var="list">
	<tr>
		<td>${list.id }</td>
		<td>${list.name }</td>
		<td>${list.age }</td>
	</tr>
	</c:forEach>
</table>
<a href="page?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNumber<=1 }">onclick="javascript:return false"</c:if>>上一页</a>
<a href="page?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNumber>=PageInfo.total }">onclick="javascript:return false"</c:if>>下一页</a>
</body>
</html>