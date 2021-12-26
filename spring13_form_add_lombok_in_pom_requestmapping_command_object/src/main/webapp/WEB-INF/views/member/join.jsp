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
	이름:${member.name}<br>
	아이디:${member.id} <br>
	패스워드:${member.pw} <br>
	  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
