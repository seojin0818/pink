$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href', '/whistle/');
	});
	
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member.join.blp');
	});
	
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/login.blp');
	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/whistle/member/logout.blp');
	});
	
	$('.pbtn').click(function(){
		// 데이터 읽어오고
		var page = $(this).attr('id');
		
		// 데이터 세팅하고
		$('#nowPage').val(page);
		$('#frm').submit();
	});
});