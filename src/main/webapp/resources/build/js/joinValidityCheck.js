/**
 *  회원가입 항목별 유효성 체크
 */
$(function() {
	checkPhone(); // 핸드폰 번호 유효성 체크
	checkPassword(); // 비밀번호 유효성 체크
	checkName(); // 이름 유효성 체크
	dupliCheck(); // 비밀번호 중복체크
	
	//회원가입 버튼을 눌렀을시 최종체크
	$('#sbm-btn').on('click',function(){
		if(finalCheck()){
			$(this).parent().submit();
		}else{
			alert('잘못된 입력 입니다.');
			return;
		}
	});
	
	$('#newPwdBtn').on('click',function(){
		var bool = check();
		var bool2 = regxPwd.test($('#newPwd').val());
		if(bool){
			if(bool2){
				$('form[name=newPwd]').submit();
			}else{
				alert('비밀번호는 영문자,숫자,특수문자가 포함된 8~20글자');
			}
		}else{
			alert('비밀번호가 일치하지 않습니다');
		}
	});
});


var regxPhone = /^[0-9]{10,11}$/; //핸드폰번호 정규식
var regxName = /^[가-힣]{2,4}$/; // 이름 정규식 (한글,2~4글자)
var regxPwd = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$/; //영어,숫자,특수문자 포함 8~20글자

function check(){
	var newPwd = $('#newPwd').val();
	var newPwd2 = $('#newPwd2').val();
	if(newPwd == newPwd2){
		return true;
	}else{
		return false;
	}
}

function dupliCheck() {
	$('#password2').keyup(function () {
		var pwd = $('#password').val();
		var pwd2 = $('#password2').val();
		if(pwd === pwd2){
			$('label[for=pwd-check]').find('span').html('&nbsp;&nbsp; 일치합니다.').css('color','blue');
			return true;
		}else{
			$('label[for=pwd-check]').find('span').html('&nbsp;&nbsp; 일치하지 않습니다.').css('color','red');
			return false;
		}
	});
}

function checkPhone() {
	$('#phone').keyup(function () {
		var phone = $('#phone').val();
		var bool = regxPhone.test(phone);
		if(bool){
			console.log(true);
			return true;
		}else{
			console.log(false);
			return false;
		}
	});
}

function checkPassword() {
	$('#password').keyup(function () {
		var password = $('#password').val();
		var bool = regxPwd.test(password);
		if(bool){
			$('label[for=pwd]').find('span').html('&nbsp;&nbsp; 사용할 수 있습니다.').css('color','blue');
			return true;
		}else{
			$('label[for=pwd]').find('span').html('');
			return false;
		}
	});
}

function checkName(){
	$('#name').keyup(function nameRegx() {
		var name = $('#name').val();
		var bool = regxName.test(name);
		if(bool){
			console.log(true);
			return true;
		}else{
			console.log(false);
			return false;
		}
	});
}



function finalCheck(){
	var pwd = $('#password').val();
	var pwd2 = $('#password2').val();
	var password = $('#password').val();
	var phone = $('#phone').val();
	var name = $('#name').val();
	
	var bool1 = regxPhone.test(phone);
	var bool2 = regxPwd.test(password);
	var bool3 = regxName.test(name);
	
	if(pwd===pwd2 && bool1 && bool2 && bool3){
		return true;
	}else{
		return false;
	}
}
