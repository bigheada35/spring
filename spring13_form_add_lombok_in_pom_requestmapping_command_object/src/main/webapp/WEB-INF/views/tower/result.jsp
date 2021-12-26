<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%-- 주의  주의  <% 는 왼쪽에 꼭 붙여서 쓰기 --%>
<!-- 주의  이것 넣고, lib도 넣어야 함. 꼭 --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


<html>
<head>
   <meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

	<h1>
		
		
		<script language=JavaScript>
				
		var data2 = '<c:out value="${tower.towerlayer}"/>'
		//var data2 = "${tower.towerlayer}";
		
	    for(let i = 0; i< data2; i++){
	        for(let j = 0 ; j<data2; j++){
	            if(j<=i)
	                document.write("*");
	            else
	                document.write(" ");
	
	        }
	        document.write("<br>");
	
	    }
		
		</script>
 
	</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
