<!-- 이제는 이거 안지워도 됨 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 이거는 지우자  -->
<%-- <%@ page session="false" %> --%>


<!-- 이거 붙여 넣기 한글 한글 한글 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  <br>
	<form action="student" method="post">
		student id: <input type= "text" name="id"> <br>
		<input type="submit" value="전송">
	</form>
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
