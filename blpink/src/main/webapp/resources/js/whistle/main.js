 $(document).ready(function(){
	// 회원가입버튼 클릭이벤트
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member/join.black');
	});
	
	// 로그인버튼 클릭이벤트
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/login.black');
	});
	
	// 로그아웃버튼 클릭이벤트
	$('#obtn').click(function(){
		$(location).attr('href', '/whistle/member/logout.black');
	});
	
	// 회원목록보기버튼 클릭이벤트
	$('#mlbtn').click(function(){
		$(location).attr('href', '/whistle/member/memberList.black');
	});
	
	// 내정보보기버튼 클릭이벤트
	$('#ibtn').click(function(){
		$(location).attr('href', '/whistle/member/myInfo.black');
	});
});