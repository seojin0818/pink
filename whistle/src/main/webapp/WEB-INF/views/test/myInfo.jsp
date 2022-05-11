<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/base.css">
<script type="text/javascript" src="/whistle/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$
	});
</script>
</head>
<body>

<!-- 회원정보 태그 -->
<div style="text-align: center;">
		<div style="display: inline-block; width: 800px;">
			<div style="display: inline-block; width: 700px;">
				<h1 style="background-color: pink; color: #FFFFF0; padding: 10px;">회원정보</h1>
			</div>
		<form method="GET"
			style="border: 1px solid pink; text-align: left;" name="frm" id="frm">
			<div style="padding: 20px; display: inline-block; width: 200px; height: 200px; margin-bottom: 10px; text-align: left;">
			<img src="/black/image/avatar/img_avatar1.png" width="100" height="auto">
			</div>
			<div style="padding: 20px; display: inline-block; width: 440px; height: 200px; text-align: right;">
				<label for="mno" class="size">회원번호 : </label>
				<label for="mname" class="size">회원이름 : </label>
				<label for="id" class="size">아이디 : </label>
				<label for="mail" class="size">메일 : </label>
				<label for="tel" class="size">전화번호 : </label>
				<label for="gen" class="size">성별 : </label>
			</div>
		</form>
			<div style="padding: 20px; text-align: center;">
					<button type="button" id="hbtn" class="button">홈</button>
					<button type="button" id="lbtn" class="button">회원리스트</button>
					<button type="button" id="ebtn" class="button">수정하기</button>
			</div>
			</div>
	</div>
</body>
</html>