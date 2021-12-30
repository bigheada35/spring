<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!-- 이거 추가함  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<!-- OK 케이스 -->
<img src="http://localhost:8282/ex/resources/img/a.png" width=100>
<img src="/ex/resources/img/a.png" width=100>
<img src="${pageContext.request.contextPath}/resources/img/a.png " width=100>
<!-- 불가능 케이스 -->
<img src="ex/resources/a.png" width=100>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
