<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'MyJsp.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="<%=basePath%>css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="<%=basePath%>css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=basePath%>config/common.js"></script>
<script type="text/javascript"  src="<%=basePath%>config/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=basePath%>config/login.js"></script>
      <script type="text/javascript">
          var mdmall = {
              base: "<%=basePath%>",
              tokenName: "mdtoken",
              isAjaxSend: "isAjaxSend"
          };
      </script>
  </head>
  
  <body>

<div class="header">
  <h1 class="headerLogo"><a title="后台管理系统" target="_blank" href=""><img alt="logo" src="images/logo.gif"></a></h1>
	<div class="headerNav"></div>
</div>

<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   
   <form class="registerform" action="user_login2" method="post" onsubmit="return login();">
   <div class="fm-item">
	   <label  class="form-label">万利登陆：</label>
	   <input type="text"  maxlength="100" name="model.userName" id="username" class="i-text" ajaxurl="demo/valid.jsp"  datatype="s6-18"   >
       <div class="ui-form-explain"></div>
  </div>
   <div class="fm-item">
       <div id="usermsg"></div>
   </div>
  
  <div class="fm-item">
	   <label  class="form-label">登陆密码：</label>
	   <input type="password"  maxlength="100" name="model.password" id="password" class="i-text" datatype="*6-16" >
       <div class="ui-form-explain"></div>
  </div>
  
 <div class="fm-item pos-r">
	   <label  class="form-label">验证码</label>
	   <input type="text" maxlength="100" id="valid" class="i-text yzm"  >
       <div id="Layer1" onClick="createCode()"> <div id="validArea" align="center"></div></div>
  </div>
  
  <div class="fm-item">
	   <label  class="form-label"></label>
	   <input type="submit" value="" tabindex="4" id="send-btn" class="btn-login"> 
       <div class="ui-form-explain"></div>
  </div>
  
  </form>

  </div>

</div>

	<div class="bd">
		<ul>
			<li style="background:url(/images/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"><a target="_blank" href=""></a></li>
			<li style="background:url(/images/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"><a target="_blank" href=""></a></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
</div>
<div style="display:none"><script src='' language='JavaScript' charset='utf-8'></script></div>
  </body>
</html>
