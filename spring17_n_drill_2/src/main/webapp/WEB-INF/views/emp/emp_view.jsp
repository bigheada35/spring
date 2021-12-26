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
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>

		</tr>

			<tr>
				

			
				<td><a href="emp_view?empno=${emp.empno}">${emp.empno}</a></td>
				<td>${emp.ename} </td>
				<td>${emp.job} </td>
				<td>${emp.mgr} </td>
				<td>${emp.hiredate} </td>
				
		
				<td><fmt:formatNumber value="${emp.sal}" type="number"/> </td>
				
				<td>${emp.comm} </td>
				<td>${emp.deptno} </td> 
				
			</tr>


			
		
	</table>
	<a href="list">목록보기</a>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
