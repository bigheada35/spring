<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<!-- 이거 붙여 넣기 한글 한글 한글 -->
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
	<form action="/ex/grade/result">
		국어:<input type="text" name="kor">
		영어:<input type="text"  name="eng">
		수학:<input type="text"  name="mat">
		<input type="submit">
	
	</form>
	
	
	</form>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
