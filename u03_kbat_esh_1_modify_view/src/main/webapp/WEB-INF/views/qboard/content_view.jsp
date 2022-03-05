<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <table width="500" cellpadding="0" cellspacing="0" border="1">
      <form action="modify" method="post">
         <input type="hidden" name="bid" value="${content_view.board_id}">
         <tr>
            <td> 번호 </td>
            <td> ${content_view.board_id} </td>
         </tr>
         <tr>
            <td> 조회수 </td>
            <td> ${content_view.board_hit} </td>
         </tr>
         <tr>
            <td> 작성자 </td>
            <td> <input type="text" name="bname" value="${content_view.member_id}"></td>
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" name="btitle" value="${content_view.board_title}"></td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea rows="10" name="bcontent" >${content_view.board_content}</textarea></td>
         </tr>
          <tr>
            <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; 
            <a href="qlist">목록보기</a> &nbsp;&nbsp; 
            <a href="qdelete?board_id=${content_view.board_id}">삭제</a> &nbsp;&nbsp; 
            <%-- <a href="reply_view?bid=${content_view.bid}">답변</a></td> --%> 
         </tr>
      </form>
   </table>
   
</body>
</html>