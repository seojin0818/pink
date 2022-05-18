<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BlackPink 방명록</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/user.css">
<script type="text/javascript" src="/whistle/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/whistle/resources/js/whistle/reboard.js"></script>
<style type="text/css">
	.w3-button {
		padding: 1px 16px;
	}
	
	.box120 {
		width: 135px;
	}
</style>
</head>
<body>
	<div class="w3-content mxw750 w3-margin-top">
		<!-- 페이지 헤더 -->
		<header class="w3-col w3-card-4 mgb20">
			<h1 class="w3-pink w3-center w3-padding mg0">BlackPink 댓글 게시판</h1>
			<nav class="w3-bar w3-yellow">
				<div class="w3-col w150 w3-button w3-small w3-green" id="hbtn">home</div>
<c:if test="${empty SID}">
				<div class="w3-col w150 w3-button w3-small w3-deep-orange w3-right" id="lbtn">login</div>
				<div class="w3-col w150 w3-button w3-small w3-orange w3-right" id="jbtn">join</div>
</c:if>
<c:if test="${not empty SID}">
<!-- 글작성 버튼이 보이려면 컨트롤러에서 뭔가 데이터를 넘겨줘야 하는 것 -->
				<div class="w3-col w150 w3-button w3-small w3-red w3-right" id="obtn">logout</div>
	<c:if test="${CNT eq 0}">
				<div class="w3-col w150 w3-button w3-small w3-orange w3-right" id="wbtn">글작성</div>
	</c:if>
</c:if>
			</nav>
		</header>
		
		<!-- 페이지 본문 -->
<c:forEach var="data" items="${LIST}">
		<div class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding" style="padding-left:${data.step * 50}px">
			<div class="w3-col box120 pdAll10 w3-border-right">
				<img src="/whistle/resources/img/avatar/${data.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
					<span class="w3-col mgb10 w3-center ft10"><b>${data.id}</b></span>
			</div>
			<div class="w3-rest w3-padding">
				<div class="w3-col w3-border-bottom">
					<div class="w3-col w3-twothird w3-right">
		<c:if test="${SID eq data.id}">
						<div class="w3-col w3-button w100 w3-orange w3-right">수정</div>
						<div class="w3-col w3-button w100 w3-red w3-right">삭제</div>
		</c:if>
						<div class="w3-col w3-button w100 w3-blue w3-right">댓글</div>
					</div>
					<span class="w3-right mgb10 ft10"><small>${data.sdate}</small></span>
				</div>
				<div class="w3-col w3-margin-top">
					<span class="w3-col w3-padding ft12">${data.body}</span>
				</div>
			</div>
		</div>
</c:forEach>

	<!-- 페이지 처리 -->
	<div class="w3-center">
		<div class="w3-bar w3-border w3-margin-top w3-margin-bottom">
	<c:if test="${PAGE.startPage eq 1}">
			<div class="w3-bar-item w3-light-grey">&laquo;</div>
	</c:if>
	<c:if test="${PAGE.startPage ne 1}">
			<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${PAGE.startPage - 1}">&laquo;</div>
	</c:if>
	<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
		<c:if test="${page eq PAGE.nowPage}">
			<div class="w3-bar-item w3-lime">${page}</div>
		</c:if>
		<c:if test="${page ne PAGE.nowPage}">
			<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${page}">${page}</div>
		</c:if>
	</c:forEach>
		<c:if test="${PAGE.endPage eq PAGE.totalPage}">
			<div class="w3-bar-item w3-light-grey">&raquo;</div>
		</c:if>
		<c:if test="${PAGE.endPage ne PAGE.totalPage}">
			<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${PAGE.endPage + 1}">&raquo;</div>
		</c:if>
		</div>
	</div>
	<!-- 페이지 처리 태그 끝 -->
	
	</div>
	
	<!-- 데이터 전송용 form 태그 -->
	<form method="POST" action="/whistle/guestBoard/gBoardList.blp" id="frm" name="frm">
		<input type="hidden" id="nowPage" name="nowPage" value="${PAGE.nowPage}">
	</form>
</body>
</html>