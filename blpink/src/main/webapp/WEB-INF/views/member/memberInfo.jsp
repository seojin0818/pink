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
<script type="text/javascript" src="/whistle/resources/js/whistle/memberInfo.js"></script>

<script type="text/javascript">
	
</script>
</head>
<body>

	<%--
		요청시 부가정보 전달용 태그
	 --%>
	 
	 <form method="POST" action="" id="frm" name="frm">
	 	<input type="hidden" name="mno" id="smno">
	 	<input type="hidden" name="id" id="sid">
	 </form>
 
	<div class="w3-content mx650">
<c:if test="${DATA.gen ne 'F'}">
		<h1 class="w3-blue w3-center w3-padding w3-card-4">
	<c:if test="${DATA.id eq SID}">
		My Information
	</c:if>
	<c:if test="${DATA.id ne SID}">
		${DATA.name} 회원 정보
	</c:if>
		</h1>
</c:if>
<c:if test="${DATA.gen eq 'F'}">
	<h1 class="w3-pink w3-center w3-padding w3-card-4">
	<c:if test="${DATA.id eq SID}">
		My Information
	</c:if>
	<c:if test="${DATA.id ne SID}">
		${DATA.name} 회원 정보
	</c:if>
	</h1>
</c:if>
	<div class="w3-col w3-margin-top w3-pading w3-card-4">
		<div class="w3-display-container w3-col w3-border-right" style="width: 200px; height: 200px;">
		<div class="avtbox w3-display-middle">
			<img class="avtimg" src="/whistle/resources/img/avatar/${DATA.savename}">
		</div>
	</div>
	<div class="w3-rest w3-text-grey pdl20">
	<h4><span class="w3-col w100 w3-right-align">회원번호 :</span><span class="w3-col w3-center" id="mno">${DATA.mno}</span></h4>
	<h4><span class="w3-col w100 w3-right-align">회원이름 :</span><span class="w3-col w3-center" id="name">${DATA.name}</span></h4>
	<h4><span class="w3-col w100 w3-right-align">아이디 :</span><span class="w3-col w3-center" id="id">${DATA.id}</span></h4>
	<h4><span class="w3-col w100 w3-right-align">전화번호 :</span><span class="w3-col w3-center" id="tel">${DATA.tel}</span></h4>
	<h4><span class="w3-col w100 w3-right-align">이메일 :</span><span class="w3-col w3-center" id="mail">${DATA.mail}</span></h4>
	<h4><span class="w3-col w100 w3-right-align">회원성별 : </span><span class="w3-rest w3-center" id="gen">${DATA.gen == 'M' ? "남자":"여자"}</span></h4>
	<h4><span class="w3-col w100 w3-right-align">가입일 :</span><span class="w3-col w3-center" id="jdate">${DATA.sdate}</span></h4>
	</div>
	</div>
	<footer class="w3-col w3-margin-top w3-card-4">
<c:if test="${DATA.id eq SID}">
	<div class="w3-third w3-button w3-green" id="lbtn">Member List</div>
	<div class="w3-third w3-button w3-blue" id="ebtn">edit</div>
	<div class="w3-third w3-button w3-red" id="dbtn">회원탈퇴</div>
</c:if>
<c:if test="${DATA.id ne SID}">
	<div class="w3-col w3-button w3-green" id="lbtn">Member List</div>
</c:if>
	</footer>
	</div>
</body>
</html>