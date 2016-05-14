<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/views/common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
.t_title_font{
font-family:verdana;
font-weight:bold;
font-size:80%;
}
.t_cont{
font-size:80%;
}

</style>
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/user.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.formValidator.initConfig({formID:"regform",theme:"ArrowSolidBox",submitOnce:true,
		onError:function(msg,obj,errorlist){
			$("#errorlist").empty();
			$.map(errorlist,function(msg){
				$("#errorlist").append("<li>" + msg + "</li>")
			});
			alert(msg);
		},
		ajaxPrompt : '有数据正在异步验证，请稍等...'
	});

	$("#uname").formValidator({onShowText:"请输入用户名",onShow:"请输入用户名,只有输入\"maodong\"才是对的",onFocus:"用户名至少2个字符,最多10个字符",onCorrect:"该用户名可以注册"}).inputValidator({min:2,max:10,onError:"你输入的用户名非法,请确认"})//.regexValidator({regExp:"username",dataType:"enum",onError:"用户名格式不正确"})
	    .ajaxValidator({
		dataType : "json",
		async : true,
		url : "user_validateName",
		success : function(data){
            if( data == "0" ) return true;
			return "该用户名已存在，请更换用户名";
		},
		buttons: $("#button"),
		error: function(jqXHR, textStatus, errorThrown){alert("服务器没有返回数据，可能服务器忙，请重试"+errorThrown);},
		onError : "该用户名已存在，请更换用户名",
		onWait : "正在对用户名进行合法性校验，请稍候..."
	}).defaultPassed();
	$("#pwd").formValidator({onShow:"请输入密码",onFocus:"至少1个长度",onCorrect:"密码合法"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码不能为空,请确认"});
	$("#pwd2").formValidator({onShow:"输再次输入密码",onFocus:"至少1个长度",onCorrect:"密码一致"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"重复密码两边不能有空符号"},onError:"重复密码不能为空,请确认"}).compareValidator({desID:"pwd",operateor:"=",onError:"2次密码不一致,请确认"});
	$("#pic").formValidator({triggerEvent:"change",onShow:"请修改您的头像 ", onFocus:"图片格式可以为jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga ", onCorrect:"恭喜您，图片可用" }).inputValidator({min:1, empty:{leftEmpty:false,emptyError:"不允许有空格 "}, onError:"必须上传头像" }).regexValidator({regExp:"picture",dataType:"enum",onError:"图片格式不正确 " })
    var dd=new Date();
	var month=dd.getMonth()+1;
	if(month<10){
		month="0"+month;
	}
	var today=dd.getFullYear()+"-"+(month)+"-"+dd.getDate();
	$("#birthday").DateTimeMask({lawlessmessage:"你输入的出生日期格式错误"}).formValidator({onShow:"请输入的出生日期",onFocus:"请输入的出生日期，不能全部是0哦",onCorrect:"你输入的日期合法"}).inputValidator({min:"1900-01-01",max:today,type:"value",onError:"日期必须在\"1900-01-01\"和\""+today+"\"之间"}).defaultPassed();
	
    $("#email").formValidator({onShow:"请输入邮箱",onFocus:"邮箱6-100个字符,输入正确了才能离开焦点",onCorrect:"恭喜你,你输对了",defaultValue:"@"}).inputValidator({min:6,max:100,onError:"你输入的邮箱长度非法,请确认"}).regexValidator({regExp:"^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$",onError:"你输入的邮箱格式不正确"});
    $(":radio[name='model.sex']").formValidator({tipID:"sexTip",onShow:"请选择你的性别",onFocus:"没有第三种性别了，你选一个吧",onCorrect:"输入正确",defaultValue:["1"]}).inputValidator({min:1,max:1,onError:"性别忘记选了,请确认"});//.defaultPassed();
	$("#introduce").formValidator({onShowText:"这家伙很懒，什么都没有留下。",onShow:"请输入你的描述",onFocus:"描述至少要输入10个汉字或20个字符",onCorrect:"恭喜你,你输对了",defaultValue:"这家伙很懒，什么都没有留下。"}).inputValidator({min:20,onError:"你输入的描述长度不正确,请确认"});
	$("#tel").formValidator({onShow:"请输入你的手机号码",onfocus:"必须是13或15打头哦",onCorrect:"谢谢你的合作，你的手机号码正确"}).regexValidator({regExp:"mobile",dataType:"enum",onError:"手机号码格式不正确"});
	$("#qq").formValidator({onShow:"请输入QQ号码",onCorrect:"谢谢你的合作，你的QQ号码正确"}).regexValidator({regExp:"qq",dataType:"enum",onError:"QQ号码格式不正确"});
	
	$("#address").formValidator({onShow:"请输入详细住址",onFocus:"请输入详细住址",onCorrect:"合法",defaultValue:""}).inputValidator({min:1,onError:"请输入详细住址,请确认"});
	$("#name").formValidator({onShow:"请输入真实姓名",onFocus:"请输入真实姓名",onCorrect:"合法",defaultValue:""}).inputValidator({min:1,onError:"请输入真实姓名,请确认"});
	$("#accountNumber").formValidator({onShow:"请输入支付宝账号",onFocus:"请输入支付宝账号",onCorrect:"合法",defaultValue:""}).inputValidator({min:1,onError:"请输入支付宝账号,请确认"});
	
});
</script>
</head>

<body>
<jsp:include page="../top.jsp" flush="true" />
     		
     		<table width="100%" border="0" >
  <tr>
    <th width="24%" height="87" scope="col"><a href="jsp/index.jsp"><img src="images/ybwl3.png" width="213" height="80" /></a></th>
    <th width="50%" scope="col">
	   </th>
    <th width="26%" scope="col">&nbsp;</th>
  </tr>
</table>

<ul id="errorlist"></ul>
<form action="user_register" name="regform" id="regform" method="post">
<table width="866" height="406" border="0" align="center" cellspacing="1" style="border:1px solid #CCCCCC">
  <tr><td>账户注册</td></tr>
  <tr>
    <td>
     <table width="662" height="571" border="0" align="center" cellspacing="1" style="border:1px solid #CCCCCC;">
      <tr>
        <td height="43" width='21%' class='t_title_font'>昵 称</td>
        <td width="31%" align="center" class='t_cont'><input type="text" name="model.userName" id="uname"/></td>
        <td width="48%"><div id="unameTip" style="width:280px"></div></td>
      </tr>
      <tr>
        <td height="43" width='21%' class='t_title_font'>真实姓名</td>
        <td width="31%" align="center" class='t_cont'><input type="text" name="model.name" id="name"/></td>
        <td width="48%"><div id="nameTip" style="width:280px"></div></td>
      </tr>
      <tr>
        <td height="44" width='21%' class='t_title_font'>密 码</td>
        <td align="center" width="31%" class='t_cont'><input type="password" name="model.password" id="pwd"/></td>
        <td><div id="pwdTip" style="width:280px"></div></td>
      </tr>
      
       <tr>
        <td height="44" width='21%' class='t_title_font'>重复输入</td>
        <td align="center" width="31%" class='t_cont'><input type="password" name="password2" id="pwd2"/></td>
        <td><div id="pwd2Tip" style="width:280px"></div></td>
      </tr>
      <tr>
        <td height="44" width='21%' class='t_title_font'>出生日期</td>
        <td align="center" width="31%"><input class="Wdate" type="text" name="model.birthday" id="birthday" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" style="cursor:pointer"/></td>
        <td><div id="birthdayTip" style="width:280px"></div></td>
      </tr>
      <tr>
        <td height="48" width='21%' class='t_title_font'>性 别</td>
        <td align="center" width="31%" class='t_cont'><input type="radio" name="model.sex" value="1" checked/>男
      <input type="radio" name="model.sex" value="0" />女</td>
      <td><div id="sexTip" style="width:280px"></div></td>
      </tr>
      
     
      <tr>
        <td height="47" width='21%' class='t_title_font'>住 址</td>
        <td align="center" width="31%" class='t_cont'><label>
          <input type="text" name="model.address" id="address"/><br/>
        </label></td>
              <td><div id="addressTip" style="width:280px"></div></td>
      </tr>
       <tr>
        <td height="45" width='21%' class='t_title_font'> QQ</td>
        <td align="center" width="31%" class='t_cont'><input type="text"  name="model.qq" id="qq"/></td>
              <td><div id="qqTip" style="width:280px"></div></td>
      </tr>
       <tr>
        <td height="45" width='21%' class='t_title_font'> 联系电话</td>
        <td align="center" width="31%" class='t_cont'><input type="text"  name="model.tel" id="tel"/></td>
              <td><div id="telTip" style="width:280px"></div></td>
      </tr>
      <tr>
        <td height="47" width='21%' class='t_title_font'> 邮 箱</td>
        <td align="center" width="31%" class='t_cont'><label>
          <input type="text" name="model.email" id="email"/><br/>
        </label></td>
              <td><div id="emailTip" style="width:280px"></div></td>
      </tr>
      
      <tr>
        <td height="47" width='21%' class='t_title_font'>支付宝账 户</td>
        <td align="center"  width="31%" class='t_cont'><label>
          <input type="text" name="model.accountNumber" id="accountNumber"/><br/>
        </label></td>
              <td><div id="accountNumberTip" style="width:280px"></div></td>
      </tr>
      
      <tr>
        <td height="97" width='21%'  valign="top" class='t_title_font'> 自我介绍</td>
        <td align="center"  valign="top" width="31%" class='t_cont'><label>
          <textarea name="model.introduce" id="introduce" cols="15" rows="3"></textarea>
        </label></td>
              <td><div id="introduceTip" style="width:280px"></div></td>
      </tr>
      
      <tr>
        
<td height="53" align="center" colspan="3">
          <input type="submit" name="Submit" value="注册" />
 <input type="reset" name="reset" value="重置" />         
          </td>
        </tr>
    </table>
      </td>
  </tr>
</table>
</form>
<div id="output"></div>
</body>
</html>
