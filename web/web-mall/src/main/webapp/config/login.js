$(document).ready(function() {
createCode();
	$(".i-text").focus(function() {
		$(this).addClass('h-light');
	});

	$(".i-text").focusout(function() {
		$(this).removeClass('h-light');
	});

	$("#username").focus(function() {
		var username = $(this).val();
		if (username == '输入账号') {
			$(this).val('');
		}
	});

	$("#username").focusout(function() {
		var username = $(this).val();
		if (username == '') {
			$(this).val('输入账号');
		}
	});

	$("#password").focus(function() {
		var username = $(this).val();
		if (username == '输入密码') {
			$(this).val('');
		}
	});

	$("#valid").focus(function() {
		var username = $(this).val();
		if (username == '输入验证码') {
			$(this).val('');
		}
	});

	$("#valid").focusout(function() {
		var username = $(this).val();
		if (username == '') {
			$(this).val('输入验证码');
		}
	});

	$(".registerform").Validform( {
		tiptype : function(msg, o, cssctl) {
			var objtip = $(".error-box");
			cssctl(objtip, o.type);
			objtip.text(msg);
		},
		ajaxPost : true
	});
	//验证码生成
		$("#validArea").click(function() {
			createCode();
		});

});


/**
 * login val
 * @returns {Boolean}
 */
function login(){
	var uname=$("#username").val();
	var up=$("#password").val();
	var validAreaValue = $("#validArea").html();
	var validValue = $("#valid").val();
	if (uname == "") {
		alert("用户名不能为空!");
		return false;
	} else if (up == "") {
		alert("密码不能为空!");
		return false;
	}else if(validValue==""){
		alert("验证码不能为空!");
		createCode();
		return false;
	}else if(validAreaValue.toString().toUpperCase()!=validValue.toString().toUpperCase()){
		alert("验证码错误!");
		createCode();
		return false;
	}else{
		return true;
	}
}

//验证码生成器	
var code; 
function createCode() {
	code = "";
	var codeLength = 4;//验证码的长度
	var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
	for ( var i = 0; i < codeLength; i++) {
		var charIndex = Math.floor(Math.random() * 33);
		code += selectChar[charIndex];
	}
	if (code.length != codeLength) {
		createCode();
	}
	$("#validArea").html(code);
}