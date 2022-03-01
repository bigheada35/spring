<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>  
   <table width="500" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>번호</td>
         <td>제목</td>
         <td>날짜</td>
         <td>작성자</td>
         <td>조회수</td>
      </tr>
      <c:forEach items="${list}" var="board">
      <tr>
         <td>${board.board_id}</td>
         <td>
            <a href="qcontent_view?board_id=${board.board_id}">${board.board_title}</a></td>
         <td>${board.board_date}</td>
         <td>${board.member_id}</td>
         <td>${board.board_hit}</td>
      </tr>
      </c:forEach>
      <tr>
         <td colspan="5"> <a href="write_view">글작성</a> </td>
      </tr>                
   </table>
   <c:if test="${pageMaker.pre}">
         <a href="qlist${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
   </c:if>

	<!-- 링크를 걸어준다 1-10페이지까지 페이지를 만들어주는것  -->
	<c:forEach var="idx" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
		<a href="qlist${pageMaker.makeQuery(idx)}">${idx}</a>
	</c:forEach>
	      
	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		<a href="qlist${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
	</c:if>
</body>
</html>