<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>아임포트2</title>
   
    <!-- ssj 0128 -->
   	<!-- csrf meta tag -->
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
   
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	

	
	<script type="text/javascript">
   	
    //버튼 클릭하면 실행
    function payment(data) {
        //IMP.init('가맹점 식별코드');//아임포트 관리자 콘솔에서 확인한 '가맹점 식별코드' 입력
        IMP.init('imp35667230');// sjsong 개인 가맹점 식별 코드//www.import.kr -> 회원가입 -> 관리자 콘솔 로그인 -> 시스템설정-> 내정보
        IMP.request_pay({// param
            pg: "kakaopay.TC0ONETIME", //pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
            pay_method: "card", //지불 방법
            merchant_uid: "iamport_test_id32", //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
            name: "도서3", //결제창에 노출될 상품명
            amount: 1, //금액
            buyer_email : "testiamport@naver.com", 
            buyer_name : "홍길동3",
            buyer_tel : "01012341234"
        }, function (rsp) { // callback
            if (rsp.success) {
                alert("완료 -> imp_uid : "+rsp.imp_uid+" / merchant_uid(orderKey) : " +rsp.merchant_uid);
                $(responseStrHtml).html("");
                $(responseStrHtml).append("<b>imp_uid:</b>"+rsp.imp_uid);
                $(responseStrHtml).append("<b>merchant_uid:</b>"+rsp.merchant_uid);

            } else {
                alert("실패 : 코드("+rsp.error_code+") / 메세지(" + rsp.error_msg + ")");
            }
        });
    }
    
    function jstest(data){
    	console.log("---jstest---");
        //var responseStr = document.getElementById("responseStrHtml");
        //responseStr.append("<b>Country Code:</b>");
        
        $(responseStrHtml).html("");
        $(responseStrHtml).append("<b>Country Code:</b><br/>")
        $(responseStrHtml).append("<b>Country Code:</b>")
        
        // error : 
        //Access to XMLHttpRequest at 'https://api.iamport.kr/users/getToken' from origin 'http://localhost:8282' has been blocked by CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.
		//jquery-1.12.4.min.js:4   POST https://api.iamport.kr/users/getToken net::ERR_FAILED
		<!-- ssj 0128 -->
		<!-- csrf -->
        var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
        
        $.ajax({
        	type: 'POST',
        	url: 'https://api.iamport.kr/users/getToken',
            beforeSend: function(xhr) {  /* ssj 0128 csrf  */
                xhr.setRequestHeader(header, token); /* ssj 0128 csrf  */
             //	xhr.setRequestHeader("X-CSRF-Token", "${_csrf.token}");
             },
        	headers:{"Content-Type":"application/json"},
        	contentType:"application/json",
        	data:{
        		imp_key:"4645602351310261",// REST API키
        		imp_secret:"a0508214c06f1ece211951b540c05d9ac0108a27981e1f1503ff130c7eecf8b71f22faede5b7519c"// REST API Secret
        	},
        	dataType:"JSON",
        	//data: JSON.stringify({'imp_key':"4645602351310261",'imp_secret':"a0508214c06f1ece211951b540c05d9ac0108a27981e1f1503ff130c7eecf8b71f22faede5b7519c"}),
        	success : function(data){
        		//통신이 성공적으로 이루어졌을때 이 함수를 타게된다.
        		console.log("---success--");
        		console.log(data);
        		console.log(data.response);
        	},
        	complete : function(data){
        		//통신이 실패했어도 완료가 되었을때 이 함수를 타게 된다.
        		console.log("--complete--");
        		console.log(data);
        	},
        	error:function(xhr,status,error){
        		console.log(error);
        	}
        	
        }).done(function(){
        	alert("요청성공~!");
        	console.log("---요청성공~!---");
        })
        /*
        url: "https://api.iamport.kr/users/getToken", 처럼 사용한 경우 에러 발생 내용 :
        	
        DOMException: Failed to execute 'setRequestHeader' on 'XMLHttpRequest': '' is not a valid HTTP header field name.
	    at Object.send (https://code.jquery.com/jquery-1.12.4.min.js:4:26547)
	    at Function.ajax (https://code.jquery.com/jquery-1.12.4.min.js:4:22180)
	    at jstest (http://localhost:8282/pay/import:66:11)
	    at HTMLButtonElement.<anonymous> (http://localhost:8282/pay/import:104:4)
	    at HTMLButtonElement.dispatch (https://code.jquery.com/jquery-1.12.4.min.js:3:12444)
	    at HTMLButtonElement.r.handle (https://code.jquery.com/jquery-1.12.4.min.js:3:9173)
        */
    }
	
	//문서가 준비되면 제일먼저 실행
	$(document).ready(function(){
		$("#iamportPayment").click(function(){
			payment();//버튼 클릭하면 호출
		});
		//test
		$("#jstest").click(function(){
			jstest();//버튼 클릭하면 호출
		});
	});
	
	alert("---3---");
   	</script>
   
   
</head>

<body>

<h1>아임포트</h1>


		<div>
			<h2>iamport 결제데모</h2>
			<li>
				<button id="iamportPayment" type="button">결제테스트</button>
			</li>
			
			<li>
				<button id="jstest" type="button">결제정보조회</button>
			</li>
		</div>
		<div id="responseStrHtml">

		</div>


</body>
</html>