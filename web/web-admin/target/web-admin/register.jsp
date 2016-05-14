<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form id="registerForm" name="registerForm" action="register" method="post">
		用户名<input type="text" name="username" /><br /> 
		密码<input type="text" name="password" /><br />
		邮箱<input type="text" name="email" /><br />
		手机号<input type="text" name="mobile" /><br />
		<button name="注册" onclick="register()">注册</button>
	</form>
</body>
<script type="text/javascript" src="js/jquery-1.7.2.js">
<script type="text/javascript">
function register(){
    var username=$("input[name='username']").val();	
    var password=$("input[name='password']").val();	
    var email=$("input[name='email']").val();	
    var mobile=$("input[name='mobile']").val();
    if(username==null||username==''){
    	alert("用户名不能为null");
    	return false;
    }
    if(password==null||password==''){
    	alert("密码不能为null");
    	return false;
    }
    if(email==null||email==''){
    	alert("邮箱不能为null");
    	return false;
    }
    if(mobile==null||mobile==''){
    	alert("手机号不能为null");
    	return false;
    }
	$("#registerForm").submit();
}
</script>
</html>