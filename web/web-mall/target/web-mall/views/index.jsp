<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/views/common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<base href="<%=basePath%>"/> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>E-Store</title>
			<script type="text/javascript" language="javascript" src="<%=basePath%>js/user.js"></script>
		    <script type="text/javascript" language="javascript" src="<%=basePath%>js/good.js"></script>
		    <script type="text/javascript" language="javascript" src="<%=basePath%>js/index.js"></script>
		    <script type="text/javascript">
		    var ty='index';
		    $(document).ready(function(){
		   
		    getListByType(0,'index');
		    getCategoryByType(0,ty);//类别列表
		    });
		    function change(id,type){
		        ty=type;
		        var arr = $("td[id^='a']");
	           arr.each(function() {
	            if($(this).attr("id").indexOf("a") != -1){
	               $(this).attr("bgcolor",'#FF6600');
	             }
	           });
		       var bg=$("#"+id).attr('bgcolor');
		       if(bg=='#EE5500'){
		          $("#"+id).attr('bgcolor','#FF6600');
		       }else{
		       	  $("#"+id).attr('bgcolor','#EE5500');
		       }
		       getListByType(0,type);
		    }
		    </script>
		    <style type="text/css">
		    .t1 {
    max-width: 1190px;
    min-width: 990px;
    margin: 0px auto 20px;
    overflow: hidden;
    border-top: 2px solid #E22C37;
    padding: 29px;
    background: url("images/t2.png") no-repeat scroll 0% 0% transparent;
}
.t2{
display: block;
background: none repeat scroll 0% 0% #E22C37;
font-family: "Microsoft Yahei";
color: #FFF;
border-radius: 12px;
text-align: center;
width: 121px;
height: 24px;
line-height: 24px;
font-weight: 700;
text-decoration: none;
margin-bottom: 5px;
margin-left:50px;
}</style>
	<link href="css/index.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
     		<jsp:include page="top.jsp" flush="true" />
     		
     		<table width="100%" border="0" >
  <tr>
    <th width="24%" height="87" scope="col"><a href="jsp/index.jsp"><img src="images/ybwl3.png" width="213" height="80" /></a></th>
    <th width="50%" scope="col">
	   <table width="456" height="47" align="center" border="0" bordercolor="#FF6600" style="border:1px solid #FF6600" cellspacing="0">
      <tr>
        <td width="363" valign="middle" scope="col"><input name="model.name" type="text" id="searchname" style="border-style:none" value="输入任意商品/宝贝名称开始购物" size="50" 
        onfocus="javascript:if(this.value=='输入任意商品/宝贝名称开始购物')this.value='';"/></td>
        <td width="79" bgcolor="#FF6600" scope="col" align="center">
             <a href="javascript:search(0);"><span class="STYLE3">搜 索</span></a>
        </td>
      </tr>
    </table></th>
    <th width="26%" scope="col">&nbsp;</th>
  </tr>
</table>


<table width="100%" border="0" bgcolor="#FF6600">
  <tr>
    <td width="19%" height="46" bgcolor="#FF6600" scope="col">&nbsp;</td>
    <td id="a1" width="7%" bgcolor="#EE5500" scope="col" ><div align="center"><a href="javascript:change('a1','index');" style="text-decoration:none;"><span class="STYLE3">首页</span></a></div></td>
    <td id="a2" width="10%" bgcolor="#FF6600" scope="col"><div align="center"><a href="javascript:change('a2','top');" style="text-decoration:none;"><span class="STYLE3">热门商品</span></a></div></td>
    <td id="a3" width="10%" bgcolor="#FF6600" scope="col" ><div align="center"><a href="javascript:change('a3','new');" style="text-decoration:none;"><span class="STYLE3">今日新单</span></a></div></td>
    <td id="a4" width="10%" bgcolor="#FF6600" scope="col"><div align="center"><a href="javascript:change('a4','topstore');" style="text-decoration:none;"><span class="STYLE3">最热店铺</span></a></div></td>
    <td id="a5" width="10%" bgcolor="#FF6600" scope="col"><div align="center"><a href="javascript:change('a5','wanli');" style="text-decoration:none;"><span class="STYLE3" >万利专区</span></a></div></td>
    <td width="44%" bgcolor="#FF6600" scope="col" >&nbsp;</td>
  </tr>
</table>



<table width="100%" border="0" bgcolor="#F6F6F6" cellspacing="0">
  <tr>
        <td width="17%" valign="top" bordercolor="0" bgcolor="#ECECEC">
	         <table>
			    <tr>				</tr>
			 </table>
			 <br>
            <jsp:include page="menu.jsp" flush="true" ></jsp:include>
    </td>
        <td width="83%" height="3064" valign="baseline" bgcolor="#ECECEC" scope="col">
            <table width="100%" id="mytable" border='0' style="border-color:#ECECEC;">
               <tr><td width=352></td><td width=352></td><td width=352></td></tr>
            </table>
       </td></tr>
</table>
<p>&nbsp;</p>
	</body>
</html>

