<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<html>
<head>
   <meta charset="UTF-8">
	<title>Home</title>
</head>
<body>


<h1>
	<form action="/ex/tower/result">
		석탑 높이 입력<input type="text" name="towerlayer">
		<input type="submit">
	</form>
	  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
