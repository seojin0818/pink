// join.html에서 전송한 데이터를
// 페이지에 h1 태그로 추가해서 보여주세요.

var param = location.search.substring(1);

param = decodeURIComponent(param);

var arr = param.split('&');

var data = {};
var key = [];

for(var i = 0 ; i < arr.length ; i++){
	var tmp = arr[i].split('=');
	key[i] = tmp[0];
	data[tmp[0]] = tmp[1];
}

for(var i = 0 ; i < arr.length ; i++){
	document.write('<h1 class="w3-center w3-padding w3-blue">' + key[i] + ' : ' + data[key[i]] + '</h1>');
}