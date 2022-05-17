$(document).ready(function(){
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/memberList.black');
	});
	
	$('#dbtn').click(function(){
		// 보낼 데이터 읽고
		var sno = $('#mno').html();
		var sid = $('#id').html();
		
		// 보낼 데이터 세팅하고
		$('#smno').val(sno);
		$('#sid').val(sid);
		
		// 보낼 주소 수정하고
		$('#frm').attr('action', '/whistle/member/delInfo.blp');
		
		if(confirm('정말 탈퇴하시겠습니까?')){
			// 폼 태그가 완성 됐으니 전송하기
			$('#frm').submit();
			
		}
		
	});
	
	$('#ebtn').click(function(){
		$(location).attr('href', '/whistle/member/editInfo.blp');
	});
});