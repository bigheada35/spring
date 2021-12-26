<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<table width="50%" border="1">
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>deptno</th>		
		</tr>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.hiredate}</td>
				<td><fmt:formatNumber value="${emp.sal}" type="number" /></td>
				<td>${emp.deptno}</td>
				
			</tr>
		
		
		</c:forEach>
	
	
	</table>
</body>
</html>
