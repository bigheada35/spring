<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Insert title here</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   
	<script type="text/javascript">
	

   /*
    $.ajax({
      url : '서비스 주소'
         , data : '서비스 처리에 필요한 인자값'
         , type : 'HTTP방식' (POST/GET 등)
         , dataType : 'return 받을 데이터 타입' (json, text 등)
         , success : function('결과값'){
         // 서비스 성공 시 처리 할 내용
         }, error : function('결과값'){
         // 서비스 실패 시 처리 할 내용
         }
      }); 
   */
	
	
	
	
	function getList(){
		var url = "${pageContext.request.contextPath}/rest/board/list.json";
		
		$.ajax(()=>{
			type : 'GET',
			url : url,
			//cache : false,  //이걸 안쓰거나 true하면 수정해도 값 반영이 잘 않됨
			cache : true,
			dataType: 'json',
			success : function(result){
				console.log("------success-----")
				var htmls="";
				$("#list-table").html("");//테이블 밑의 자식 테그를  모두 없애는 것임.
				
				$("<tr>", {
					html : "<td>" + "번호" + "</td>" +
					"<td>" + "이름" + "</td>" +
					"<td>" + "제모" + "</td>" +
					"<td>" + "날짜" + "</td>" +
					"<td>" + "히트" + "</td>" 
					
					
					
					
				}).appendTo("#list-table")// 이것을 테이블에붙임
				
				
				if(result.length<1){
                  htmls.push("등록된 댓글이 없습니다.");
				}else{
					
					$(result).each(function(){
						
						htmls += '<tr>';
						htmls += '<td>' + this.bid + '</td>';
						htmls += '<td>' + this.bname + '</td>';
						 htmls += '<td>'

						for(var i=0; i<this.bindent; i++){
							htmls += '-';
						}
						                             htmls += '<a href="${pageContext.request.contextPath}/content_view?bid=' + this.bid + '">' + this.btitle + '</a></td>';
                              htmls += '<td>'+ this.bdate + '</td>'; 
                             htmls += '<td>'+ this.bhit + '</td>';   
                             htmls += '</tr>';  
						
						
					});
					
					htmls += '<tr>';
					htmls+='<td colspan="5"> <a href="${pageContext.request.contextPath}/write_view">글작성</a> </td>';                         
					htmls += '</tr>';
				}
				
				
				$("#list-table").append(htmls);
				
				
				
			}
			
			
		});//ajax end
		
		
	}//getList()
	
	</script>
	
   <script>
      $(document).ready(function(){
         getList();
      });
   </script>
   
</head>


<body>

		<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1"> 
		
	
		</table>

</body>
</html>
