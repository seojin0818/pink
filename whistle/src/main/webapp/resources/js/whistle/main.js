/**
 * /resources/js/whistle/main.js
 */
 
 $(document).ready(function(){
	// 회원가입버튼 클릭이벤트
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member/join.blp');
	});
	
	// 로그인버튼 클릭이벤트
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/login.blp');
	});
	
	// 로그아웃버튼 클릭이벤트
	$('#obtn').click(function(){
		$(location).attr('href', '/whistle/member/logout.blp');
	});
	
	// 회원목록보기버튼 클릭이벤트
	$('#mlbtn').click(function(){
		$(location).attr('href', '/whistle/member/memberList.blp');
	});
});