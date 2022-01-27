<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
   <title>Home</title>
</head>
<body>
   <h1>
      홈페이지
   </h1>
   
   <sec:authorize access="isAnonymous()">
         <p><a href="<c:url value="/login/loginForm" />">로그인</a></p>
   </sec:authorize>
   
   <sec:authorize access="isAuthenticated()">
      <p>환영합니다. : <sec:authentication property="principal.username" /> 님</p>
<%--       <p>패스워드 : <sec:authentication property="principal.password" /></p>
      <p>principal : <sec:authentication property="principal"/></p> --%>
   </sec:authorize>

</body>
</html>