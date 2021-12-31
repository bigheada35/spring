<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<html>
<head>
	<title>Home</title>
</head>
<body>
	
		<table width="500" border="1">
			<form action="write" method="post">
				<tr>
					<td>이름</td>
					<td><input type="text" name="bname" size="50"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td> <input type="text" name="btitle" size="50"> </td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="bcontent" rows="10"> </textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;<a href="list">목록보기</a></td>
				</tr>
			</form>
		
		</table>
		

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
