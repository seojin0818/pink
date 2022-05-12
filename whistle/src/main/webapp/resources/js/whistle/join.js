$(document).ready(function(){
	$(document.frm.gen).change(function(){
		$('#avtfr').stop().slideUp(1000);
		var sgen = $(this).val();
		
		if(sgen == 'M'){
			$('#favt').css('display', 'none');
			$('#mavt').css('display', 'block');
			$('#avtfr').stop().slideDown(1000);
		} else {
			$('#mavt').css('display', 'none');
			$('#favt').css('display', 'block');
			$('#avtfr').stop().slideDown(1000);
			
		}
	});
});