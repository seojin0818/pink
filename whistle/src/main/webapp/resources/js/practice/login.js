$(document).ready(function(){
	$('#lbtn').click(function(){
		var sid = $('#id').val();
		var spw = $('#pw').val();
		
		if(!sid){
			$('#id').focus();
			return;
		}
		
		if(!spw){
			$('#pw').focus();
			return;
		}
		
		/*
		
		if(!(sid && spw)){
			return;
		}
		
		*/
		
		$('#frm').attr('action', '/whistle/practice/loginProc.bear');
		$('#frm').submit();	
	});
});