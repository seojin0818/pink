<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/base.css">
<script type="text/javascript" src="/whistle/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/whistle/resources/js/test/myinfo.js"></script>
<style type="text/css">

 #tag {
  	display: none;
 }
 
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('#obtn').click(function(){
			$(location).attr('href', '/whistle/test/logout.pink');
		});
		
		$('#lbtn').click(function(){
			$(location).attr('href', '/whistle/test/login.pink');
		});
		
	});
</script>
</head>
<body>
	<div class="w3-content mx650">
<c:if test="${not empty SID}">
		<h1 class="w3-blue w3-padding w3-center">Hello ${SID}</h1>
		<div class="w3-col m2 w3-button w3-red" id="obtn">logout</div>
		<div class="w3-col m2 w3-button w3-green w3-right" id="ibtn">myInfo</div>
</c:if>
<c:if test="${empty SID}">
		<h1 class="w3-blue w3-padding w3-center">Hello JSP!</h1>
		<div class="w3-col m2 w3-button w3-pink" id="lbtn">login</div>
</c:if>
	</div>
	
	<!-- 회원정보 태그 -->
<div class="w3-content mx650" id="tag">
		<div class="w3-col w3-content" style="display: inline-block; width: 650px;">
			<div style="display: inline-block; width: 650px;">
				<h1 class="w3-col w3-blue w3-padding w3-center">회원정보</h1>
			</div>
		<form method="GET"
			style="border: 1px solid gray; text-align: center;" name="frm" id="frm">
		<div class="w3-col w3-display-container" style="width: 300px; height: 350px;">
			<div class="w3-display-middle" style="width: 170px; height: 185px;">
			<img width="100%" height="auto" id="box">
			<h4 class="size">아이디 : <span id="mid"></span></h4>
		</div>
			</div>
			<div style="padding: 20px; display: inline-block; width: 300px; height: 370px; text-align: right; margin-bottom: 30px;">
				<h4 class="size">회원번호 : <span id="mmno"></span></h4>
				<h4 class="size">회원이름 : <span id="mname"></span></h4>
				<h4 class="size">메일 : <span id="mmail"></span></h4>
				<h4 class="size">전화번호 : <span id="mtel"></span></h4>
				<h4 class="size">성별 : <span id="mgen"></span></h4>
				<h4 class="size">가입일 : <span id="mjdate"></span></h4>
				<h4 class="size">아바타 : <span id="mavt"></span></h4>
				<h4 class="size">저장이름 : <span id="msave"></span></h4>
			</div>
		</form>
			</div>
	</div>
</body>
</html>