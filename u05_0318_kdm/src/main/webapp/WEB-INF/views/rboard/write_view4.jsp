<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){	
		var rating = $('.review .rating');
		
		rating.each(function() {
			var targetScore = $(this).attr('data-rate');
			console.log(targetScore);
			$('this').find('svg:nth-child(-n+' + targetScore +')').css({color:'#f05522'});
		});
		
		var userScore = $('#makeStar');
		userScore.change(function(){
			var userScoreNum = $(this).val();
			console.log(userScoreNum);
			$('.make_star svg').css({color:'#000'});
			$('.make_star svg:nth-child(-n+' + userScoreNum +')').css({color:'#f05522'});
		});
		
		$('.make_star svg').click(function(){
			var targetNum = $(this).index() + 1;
			$('.make_star svg').css({color:'#000'});
			$('.make_star svg:nth-child(-n+' + userScoreNum +')').css({color:'#f05522'});
		})
		
	});	
</script>
<style>

li{
   list-style:none;
   }
</style>
</head>
<body>


<table width="500" cellpadding="0" cellspacing="0" border="1">	
		<div class="review">
			<div class="rating" data-rate="3">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
			</div> 
			<div class="rating" data-rate="5"> --- </div>
			<div class="rating" data-rate="2"> --- </div>
		</div>
		<hr>
		<div class="make_star">
			<select name="" id="makeStar">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>				
			</select>
			<div class="rating" data-rate="3">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
			</div> 
		</div>

      <form:form action="rwrite" method="post">               
         <tr>
            <td> ?????? </td>
            <td> <input type="text" name="board_title" size = "50"> </td>
         </tr>
         <tr> 
            <td> ?????? </td>
            <td> <textarea name="board_content" rows="10" ></textarea> </td>
         </tr>
         <li class="img">
         <div id="image_preview">
                                    <img src="/img.png" alt="????????????"  style="width:126px; height:165px;">
                                </div>
                                <div class="f_box">
                                        <label for="img">????????????</label>
                                        <input type="file" id="img"  name="bf_file[]">
                                </div>
                            </li>

                       <script>
                            // ????????? ?????????
                            $('#img').on('change', function() {
                            ext = $(this).val().split('.').pop().toLowerCase(); //?????????
                            //????????? ????????? ???????????? ??????????????? ??????
                            if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
                                resetFormElement($(this)); //??? ?????????
                                window.alert('????????? ????????? ????????????! (gif, png, jpg, jpeg ??? ????????? ??????)');
                            } else {
                                file = $('#img').prop("files")[0];
                                blobURL = window.URL.createObjectURL(file);
                                $('#image_preview img').attr('src', blobURL);
                                $('#image_preview').slideDown(); //???????????? ????????? ???????????? 
                                $(this).slideUp(); //?????? ?????? ??????
                            }
                            });
 </script>
         <tr>             
            <td colspan="2"> <input type="submit" value="??????"> &nbsp;&nbsp; 
            <a href="rlist">????????????</a></td>
         </tr>                 
      </form:form>
     
   </table>  
</body>
</html>