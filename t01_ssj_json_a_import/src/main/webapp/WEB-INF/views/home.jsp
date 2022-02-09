<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	
	<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
	
    <script type="text/javascript">
        $(document).ready( ()=>{
        	console.log("------1-----");
            $.ajax({
                        type:"get",
                        url:"${pageContext.request.contextPath}/sample/getText",
                        success : function(data){
                            console.log(data);
                            $("#hello").text(data);
                        },
                        error: (xhr, textStatus, errorThrown)=>{

                            console.log(xhr);
                            console.log(textStatus);
                            console.log(errorThrown);
                        }


            });
            console.log("------2-----");
        });




    </script>
	
	
	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}... </P>
	<div id="hello">
		
	</div>

</body>
</html>
