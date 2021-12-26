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
	<form action="/ex/member/join">
		이름 <input type="text" name="name">
		아이디 <input type="text" name="id">
		비밀번호 <input type="text" name="pw">
		<input type="submit">
	</form>


<h1>
	이름:${member.name}<br>
	아이디:${member.id} <br>
	패스워드:${member.pw} <br>
	  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
