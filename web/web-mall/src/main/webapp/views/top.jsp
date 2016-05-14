<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/views/common/tag.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一本万利</title>
<link href="css/index.css" rel="stylesheet" type="text/css"/>
</head>
<script type="text/javascript">
 $(document).ready(function(){
		      hasNewMessage();
		    });
 function hasNewMessage(){
		     $.ajax({
		       async:false,
		       type:"post",
		       url:"user_hasNewMesssage",
		       dataType:"json",
		       success:function(data){
	                if(data=="true"){
	                	$("#message").append("<span class=STYLE2 style=border-right:1px dashed #999999> " +
	                	"<a href=jsp/messagelist.jsp>新消息</a>&nbsp; &nbsp;</span>"
	                	);
	                }else{
                         $("#message").append("<span class=STYLE2 style=border-right:1px dashed #999999> " +
                        "&nbsp;&nbsp;<a href=jsp/messagelist.jsp>消息</a>&nbsp; &nbsp;</span>");
	                }
		       },
		       error:function(){
			
		       }
	});	
}
 
function apply(){
	$.ajax({
			type:"post",
			url:"store_applyOpen.action",
			data:$("#s_add").serialize(),
			dataType:"json",
		    success:function(data) {
				if(data=='success'){
				    alert('申请成功，请等待审核!');
				    $('#apply_store').CloseDiv();
				}else if(data=='checking'){
				    alert('审核中，请您耐心等待!');
				}else if(data=='error'){
					alert('您余额不足,请充值!');
				}
		    },
			error:function(){
		    	alert('1');
		    }
	});
}
function openApplyDiv(){
	$.ajax({
		  type:"post",
		  url:"store_getCategoryByCId.action",
		  dataType:"json",
		  success:function(data){
		           $.each(data,function(i,item){
              		$("#cid").append("<option value="+item.id+">"+item.name+"</option>");
		           });
              $('#apply_store').OpenDiv();
		  },
		  error:function(){
			  
		  }
	});
}
</script>
<body>
<table width="100%" align="top" border="0" bgcolor="#F5F5F5" style="border-bottom:1px solid #EEEEEE">
  <tr>
    <th width="447" height="28" scope="col">&nbsp;</th>
    <th width="341" scope="col">
               <span class="STYLE2" style="border-right:1px dashed #999999;"><a href="jsp/index.jsp">首页</a>&nbsp;&nbsp;</span>
      <c:if test="${empty sessionScope.user}">
         <span class="STYLE2" style="border-right:1px dashed #999999;"><a href="jsp/login.jsp">登录</a>&nbsp;&nbsp;</span>
          <span class="STYLE2" style="border-right:1px dashed #999999"> &nbsp;&nbsp;<a href="jsp/register.jsp">免费注册</a>&nbsp; &nbsp;</span>
       </c:if>
       <c:if test="${not empty sessionScope.user}">
             <span class="STYLE2" style="border-right:1px dashed #999999;"><a href="user_getSelfUserInfo">个人信息</a>&nbsp;&nbsp;</span>
             <span class="STYLE2" id="message" style="border-right:1px dashed #999999;"><a href="user_loginOut">退出登录</a>&nbsp;&nbsp;</span>
        
          <c:if test="${sessionScope.user.stou==true}">
              <span class="STYLE2" style="border-right:1px dashed #999999"> &nbsp;&nbsp;<a href="store_index.action">我的店铺</a>&nbsp; &nbsp;</span>
          </c:if>
          <c:if test="${sessionScope.user.stou==false}">
              
              <span class="STYLE2" style="border-right:1px dashed #999999"> &nbsp;&nbsp;<a href="javascript:openApplyDiv();">申请店铺</a>&nbsp; &nbsp;</span>
          </c:if>
       </c:if>
    
    </th>
    <th width="134" scope="col"><div align="left"><span class="STYLE2" style="border-right:1px dashed #999999"><img src="images/good_car.png" alt="b" width="25" height="23" align="absmiddle" /><a href="jsp/buy_car.jsp">我的购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;</span></div></th>
    <th width="100" scope="col"><div align="left"><span class="STYLE2"><img src="images/cart_item.png" alt="a" width="21" height="20" align="absmiddle" /><a href="jsp/order_list.jsp">我的订单</a></span></div></th>
    <th width="140" scope="col"><div align="left"><span class="STYLE2"><img src="images/cart_item.png" alt="a" width="21" height="20" align="absmiddle" /><a href="jsp/noticelist.jsp">常见问题</a></span></div></th>
  </tr>
</table>



 <div id="apply_store" style="width:400px;display:none;">
     <form method="post" id="s_add">
        <table>
             <tr>
                <td>店铺名称</td>
                <td><input type="text" name="model.name"/></td>
             </tr>
             <tr>
                <td>销售类型</td>
                <td>
                   <select id="cid" name="model.cid">
                      <option value="0">请选择类型</option>
                   </select>
                </td>
             </tr>
             <tr>
                <td>打折积分线</td>
                <td><input type="text" name="model.gradeMember"/></td>
             </tr>
              <tr>
                <td>店铺简介</td>
                <td><input type="text" name="model.descr"/></td>
                <td>
                   <input type="hidden" name="model.flow" value="0"/>
                   <input type="hidden" name="model.grade" value="0"/>
                   <input type="hidden" name="model.status" value="1"/>
                </td>
             </tr>
              <tr>
                <td><input type="button" value="申请" onClick="apply()"/></td>
                <td><input type="button" value="关闭" onClick="$('#apply_store').CloseDiv();"/></td>
             </tr>
           </table>
    </form>
  </div>
</body>
</html>
