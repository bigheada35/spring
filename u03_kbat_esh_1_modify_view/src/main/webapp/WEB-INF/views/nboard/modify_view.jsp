<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
      <form:form action="nmodify_view" method="post">
      		<tr>
      			<td><input type="hidden" name="board_id" value="${modify_view.board_id}"/>
      			</td>
      		</tr>
      
      
         <tr>
            <td> 작성자 </td>
            <%-- <td> <input type="text" name="member_number" value="${modify_view.member_number}"></td> --%>
            
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" name="board_title" value="${modify_view.board_title}"></td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea rows="10" name="board_content" >${modify_view.board_content}</textarea></td>
         </tr>
         <tr >
            <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; 
            <a href="nlist">목록보기</a> &nbsp;&nbsp; 
         </tr>
      </form:form>
   </table>
</body>
</html>