<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BlackPink 게시판 리스트</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/user.css">
<script type="text/javascript" src="/whistle/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="w3-content mxw700">
		<h1 class="w3-blue w3-card-4 w3-padding w3-center">게시글 작성</h1>
		<div class="w3-col w3-card-4 w3-padding">
			<div class="w3-col">
				<label for="title" class="w3-col m2">Title</label>
				<input type="text" class="w3-col m10 w3-input w3-border">
			</div>
			<div class="w3-col">
				<label class="w3-col m2">File</label>
				<div class="w3-col m10">
				<input type="file" id="file1" name="file1" class="w3-input w3-border">
				<input type="file" id="file2" name="file2" class="w3-input w3-border">
				<input type="file" id="file3" name="file3" class="w3-input w3-border">
			</div>
		</div>
			<div class="w3-col">
				<label for="body" class="w3-col m2">글본문</label>
				<div class="w3-col m10">
				<textarea class="w3-col w3-input w3-border" rows="10" style="resize: none;"></textarea>
				</div>
			</div>
		</div>
		
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-third w3-button w3-green" id="listbtn">리스트</div>
			<div class="w3-third w3-button w3-blue" id="reset">리셋</div>
			<div class="w3-third w3-button w3-deep-orange" id="wpbtn">글등록</div>
		</div>
	</div>
</body>
</html>