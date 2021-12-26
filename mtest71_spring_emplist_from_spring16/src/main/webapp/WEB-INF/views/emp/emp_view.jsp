<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

	<table width="50%" border="1">
	<tr>
		
		<td><a href="emp_view?empno=${emp.empno}">${emp.empno}</a>
		
		
		</td>
		<td>${emp.ename}</td>
		<td>${emp.job}</td>
		<td>${emp.mgr}</td>
		<td>${emp.hiredate}</td>
		<td>${emp.sal}</td>
		<td>${emp.comm}</td>
		<td>${emp.deptno}</td>
		
		
	</tr>
	</table>
	<a href="list">목록보기</a>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
