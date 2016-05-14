<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <script type="text/javascript" language="javascript" src="<%=basePath%>config/jquery-1.7.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath%>config/jquery.form.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath%>config/jquery.divbox.js"></script>

<!--js验证插件-->
<script src="<%=basePath%>config/validator/formValidator-4.1.3.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=basePath%>config/validator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="<%=basePath%>config/validator/DateTimeMask.js" language="javascript"  type="text/javascript"></script>

<!--js日历插件  -->
<script language="javascript" type="text/javascript" src="<%=basePath%>config/datePicker/WdatePicker.js"></script>

<!-- js数字加减插件 -->
<script language="javascript" type="text/javascript" src="<%=basePath%>config/spinner/js/jquery.spinner.js"></script>
