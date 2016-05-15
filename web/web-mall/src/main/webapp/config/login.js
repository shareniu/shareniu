var $isRememberUsername = $("#isRememberUsername");
$().ready( function() {
	var $username = $("#username");
	var $password = $("#password");
	// 记住用户名
	if(getCookie("mallUser") != null) {
		$isRememberUsername.prop("checked", true);
		$username.val(getCookie("mallUser"));
		$password.focus();
	} else {
		$isRememberUsername.prop("checked", false);
		$username.focus();
	}
});

$(function(){
	var username = getCookie('mallUser');
	if(username) {
		$('username').val(username);
	}
});
//登录
function login() {
	$(".errorTipTxt").html("");
	if($("#username").val() == "") {
        alert("请输入用户名");
		return;
	}
	if($("#password").val() == "") {
		alert("请输入密码");
		return;
	}
	//登录提交
	var $username = $("input[name=username]");
	var $password = $("input[name=password]");
	$.ajax({
		url: "<%=base%>/login.jsp",
		type: "POST",
		data: {
			username: $username.val(),
			password: $password.val()
		},
		dataType: "json",
		cache: false,
		success: function(result) {
			if(result.loginStatus=="success") {
				if ($isRememberUsername.prop("checked")) {
					addCookie("mallUser", $username.val(), {expires: 7 * 24 * 60 * 60});
				} else {
					removeCookie("mallUser");
				}
				location.href="<%=base%>"+result.ReturnUrl;
			} else {
				$("#login_err").html("用户名或密码不正确").addClass("vShow");
			}
		}
	});
}

function loginCallback() {
	$('#callback').attr('name', 'callback');
	login();
}

document.onkeydown = function(e){
	if(!e) e = window.event;//火狐中是 window.event
	if((e.keyCode || e.which) == 13){
		login();
	}
}





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