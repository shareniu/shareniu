<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <script type="text/javascript"  src="<%=basePath%>config/jquery-1.7.2.js"></script>
  <script type="text/javascript" src="<%=basePath%>config/common.js"></script>
  <script type="text/javascript">
    var mdmall = {
      base: "<%=basePath%>",
      tokenName: "mdtoken",
      isAjaxSend: "isAjaxSend"
    };
    // 登录验证
    doLogin(mdmall.base, function() {
    });
    </script>
    <title></title>
</head>
<body>
个人中心<br/>
这个页面需要登录
</body>
</html>
