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
	국어:${grade.kor}<br>
	영어:${grade.eng} <br>
	수학:${grade.mat} <br>
	합계: ${grade.tot}<br>
	평균:${grade.avg}<br>
	등급:${grade.gra}<br>
	  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
