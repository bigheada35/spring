<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<html>
<head>
	<title>Home</title>
</head>
<body>
	
		<table width="500" cellpadding="0" cellspacing="0" border="1"> 
		
			<tr>
				<td>번호:</td>
				<td>이름:</td>
				<td>제목:</td>
				<td>날짜:</td>
				<td>히트:</td>
			
			</tr>
			
			<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bid}</td>
				<td>${board.bname}</td>
				<td>
					<c:forEach begin="1" end="${board.bindent}"> [Re] </c:forEach>
 						<a href="content_view.do?bid=${board.bid}">${board.btitle}</a>
				</td>
				<td>${board.bdate}</td>
				<td>${board.bhit}</td>
			</tr>	
			</c:forEach>
			
			<tr>
				<td colspan="5"> 
					<a href="write_view">글작성</a>
				</td>
			</tr>
		</table>
		
		
		
	  <c:if test="${pageMaker.pre}">
         <a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
      </c:if>

      <!-- 링크를 걸어준다 1-10페이지까지 페이지를 만들어주는것  -->
      <c:forEach var="idx" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
         <a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
      </c:forEach>
      
      <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
         <a href="list2${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
      </c:if> <br>
		

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
