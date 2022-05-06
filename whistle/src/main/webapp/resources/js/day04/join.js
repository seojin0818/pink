document.getElementById('jbtn').onclick = function(){
/*
	var sname = document.getElementById('name').value;
	if(!sname){
		alert('이름은 필수 데이터입니다.');
		document.getElementById('name').focus();
		return;
	}
	var sid = document.getElementById('id').value;
	if(!sid){
		alert('아이디를 입력하세요.');
		document.getElementById('id').focus();
		return;
	}
	var spw = document.getElementById('pw').value;
	if(!spw){
		alert('비밀번호를 입력하세요.');
		document.getElementById('pw').focus();
		return;
	}
	var smail = document.getElementById('mail').value;
	if(!smail){
		alert('메일을 입력하세요.');
		document.getElementById('mail').focus();
		return;
	}
	var stel = document.getElementById('tel').value;
	if(!stel){
		alert('전화번호를 입력하세요.')
		document.getElementById('tel').focus();
	}
	var sgen = document.querySelectorAll('[name="gen"]:checked')[0].value;
	if(!sgen){
		alert('성별을 선택하세요.');
		return;
	}
	var savt = document.querySelectorAll('[name="avt"]:checked')[0].value;
	if(!savt){
		alert('아바타를 선택하세요.');
		return;
	}
*/	

	/*
	
	 var el = document.getElementsByClassName('ck');
	 for(var i = 0 ; i < el.length ; i++){
		var tmp = el[i].value;
		if(!tmp){
			el[i].focus();
			return;
		}
	}	
	
	*/

/*	
	var namePat = /^[가-힣]{2,5}$/;
	var idPat = /^[a-zA-Z]{4,8}$/;
	var pwPat = /^[a-zA-Z][a-zA-Z0-9]{3,7}$/;
	var mailPat = /^\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
	var telPat = /^(010|016|011)\d{3,4}\d{4}$/;
	
	var nameResult = namePat.test(sname);
	var idResult = idPat.test(sid);
	var pwResult = pwPat.test(spw);
	var mailResult = mailPat.test(smail);
	var telResult = telPat.test(stel);
	
	if(!(nameResult && idResult && pwResult && mailResult && telResult)){
		// 통과 못한 경우이므로 즉시 이함수 실행을 종료시킨다.
		document.frm.reset();
		return;
	}
*/	
	document.getElementById('frm').submit();
};

// reset 버튼 이벤트 처리
document.getElementById('rbtn').onclick = function(){
	document.getElementById('frm').reset();
	
	/*
	
	var sid = document.frm.id.value;
	
	document.frm.reset();
	
	*/
};