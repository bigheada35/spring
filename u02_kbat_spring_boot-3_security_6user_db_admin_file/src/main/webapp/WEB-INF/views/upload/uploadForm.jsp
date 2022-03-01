<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>업로드 폼 및 현재 리스트</title>
</head>

<body>
		<p>"${message}"</p>
	
	<form:form enctype="multipart/form-data" action="fileUpload" method="POST">
		<input type="file" name="file" />
		<button type="submit" class="btn">파일업로드</button>
	</form:form>
	
	<p>files</p>
	<c:forEach items="${files}" var="file">
	<tr>
 	 			<td>${file} </td> 
 				<td>
 					<video width="300" height="250" controls/>
		          		<source src="<c:url value="${file}"/>" type="video/mp4">
				    </video>
				<td/>

	 </tr>
	</c:forEach>	

</body>
</html>