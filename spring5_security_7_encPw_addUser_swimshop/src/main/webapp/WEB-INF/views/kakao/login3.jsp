<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

<!-- ssj 0128 -->
<!-- csrf meta tag -->
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>



<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
		Kakao.init('7df15154cd15e7e3fefcfd0b7d57931d');
		console.log(Kakao.isInitialized());	
	</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">


	$(function() {
		
		$('#logBt1').click(function() {
			if ($('#id').val() == '') {
					alert('아이디를 입력하세요.');
					$('#id').focus();
					return false;
			}else if ($('#pw').val() == '') {
					alert('패스워드를 입력하세요.');
					$('#pw').focus();
					return false;
			}else{
				$.ajax({
					url: "sLogin.member",   
					data: {
						Id :  $('#id').val(),
						Pw :  $('#pw').val(),
					},
					success: function(data) {
						if (data == 0) {
								console.log(data);
								alert('아이디 혹은 패스워드가 틀렸습니다!');
							}else{
								location.href = "main.jsp";
							}
						} //success end 
					}) //ajax
			
			}//else	
		})//click
					// "loginCheck.member", -> 비암호화시 사용할 맵핑주소   
 					/* $('#loginForm').submit();  */
	})//func ready
	
	
	
</script>
</head>
<body>


아이디 : <input type="text" name="id" id="id" > <br>
패스워드 : <input type="text" name="pw" id="pw"> <br>

<button id="logBt1" name="logBt1" >로그인</button> <br>
<a href="member_join.jsp">회원가입</a>

<!-- 카카오 로그인 -->
<a id="custom-login-btn" href="javascript:loginWithKakao()">
 
    <img
	    src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
	    width="222"
	    alt="카카오 로그인 버튼"
  	/>
  
</a>
<script type="text/javascript">
  function loginWithKakao() {
	        

	  
    Kakao.Auth.login({
    	
    	
      success: function(authObj) {
        //alert(JSON.stringify(authObj))
        console.log("----nnnnn-:  " + JSON.stringify(authObj));
        
		<!-- ssj 0128 -->
		<!-- csrf -->
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		  
        
        $.ajax({
            type: 'POST',
            url: `${pageContext.request.contextPath}/kakao2/getAccesToken`,
            beforeSend: function(xhr) {  /* ssj 0128 csrf  */
               xhr.setRequestHeader(header, token); /* ssj 0128 csrf  */
            //	xhr.setRequestHeader("X-CSRF-Token", "${_csrf.token}");
            },
               statusCode: {
			    404: function() {
			      alert( "404 ,page not found" );
			    }
			  },
            contentType: "application/json",
            data: JSON.stringify({'token':authObj['access_token']}),

            success: function (response) {
            	console.log("----응답:----");
                localStorage.setItem("token", response['token']);
                localStorage.setItem("username", response['username']);
                //ssj  location.href = '/';
                //ssj
                console.log(" ---");
            } 
        })
        
        
        
      },
      fail: function(err) {
        alert(JSON.stringify(err))
      },
    })
  }
</script>
</body>
</html>