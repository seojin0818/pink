$(document).ready(function(){
	
$('#ibtn').click(function(){
	$.ajax({
			url: '/whistle/test/myInfoAjax.pink',
			type: 'POST',
			dataType: 'json',
			success: function(data){
				data.name = decodeURIComponent(data.name);
				data.joindate = decodeURIComponent(data.joindate);
				var mno = data.mno;
				var name = data.name;
				var id = data.id;
				var mail = data.mail;
				var tel = data.tel;
				var gen = data.gen;
				var joindate = data.joindate;
				var ano = data.ano;
				var savename = data.savename;
				
				$('#mmno').html(mno);
				$('#mname').html(name);
				$('#mid').html(id);
				$('#mmail').html(mail);
				$('#mtel').html(tel);
				$('#mgen').html(gen);
				$('#mjdate').html(joindate);
				$('#mavt').html(ano);
				$('#msave').html(savename);
				$('#box').attr('src', '/whistle/resources/img/avatar/' + savename);
				
				$('#tag').slideDown(500);
			},
			error:function(){
				alert('통신 에러');
			}
			});
	});
});
