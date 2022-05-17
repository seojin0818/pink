$(document).ready(function(){
	// 리셋 버튼 클릭이벤트
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	
	// 홈 버튼 클릭이벤트
	$('#hbtn').click(function(){
		$(location).attr('href', '/whistle/main.blp');
	});
	
	// 수정 버튼 클릭이벤트
	$('#ebtn').click(function(){
		// 할 일
		// 수정된 데이터를 알아내기
		// 받은 데이터를 꺼내오기
		var tmail = $('#tmail').val();
		var ttel = $('#ttel').val();
		var tano = $('#tano').val();
		
		// 입력한 데이터 꺼내오고
		var pw = $('#pw').val();
		var mail = $('#mail').val();
		var tel = $('#tel').val();
		var ano = $('[name="ano"]:checked').val();
		
		if(!pw){
			$('#pw').prop('disabled', true);
		}
		
		if(tmail == mail){
			// 메일이 수정되지 않은 경우
			$('#mail').prop('disabled', true);
		}
		
		if(ttel == tel){
			$('#tel').prop('disabled', true);
		}
		
		if(tano == ano){
			$('[name="ano"]').prop('disabled', true);
		}
		
		if(!pw && (tmail == mail) && (ttel == tel) && (tano == ano)){
			// 수정을 하나도 하지 않은 경우
			alert('아무것도 수정안함');
			return;
		}
		
		// 보낼 주소 설정하고
		$('#frm').attr('action', '/whistle/member/editProc.blp');
		$('#frm').submit();
	});
});