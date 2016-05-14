function getOrderList(){
	$.ajax({
		type:"post",
		url:"orders_getOrdersListBySId.action",
		dataType:"json",
		success:function(data){
		   $.each(data,function(i,item){
			   var sign='',hr='';
			   if(item.sign==true){
				   sign='是';
			   }else{
				   sign='否';
				   hr="<a href='javascript:void(0);' onclick='outGoods("+item.id+");'>出货</a>/";
			   }
			   $("#mytable").append("<tr bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'><td>"+item.number+"</td><td>"+item.user.name+"</td><td>"+item.address+"</td>" +
			   "<td>"+item.setMoney+"</td><td>"+sign+"</td><td>"+hr+"<a href='javascript:void(0);' onclick='getOrderDetail("+item.id+");'>订单详情</a></td></tr>");
		   });
		},
		error:function(){
			
		}
	});
}
/**
 * 出货
 * @param {Object} id
 */
function outGoods(id){
 $.ajax({
    type:"post",
	url:"orders_outGoods.action",
	data:"model.id="+id,
	dateType:"json",
	success:function(data){
		if(data=='success'){
			alert('出货成功!');
			window.location.href='jsp/storeadmin/orders/orderslist.jsp';
		}
	},
	error:function(){
		
	}
	});
}
/**
 * 订单详情
 */
function getOrderDetail(id){
	$.ajax({
		type:"post",
		url:"orders_getOrderDetailListByOId.action",
		data:"model.id="+id,
		dataType:"json",
		success:function(data){
		$("#mytable2").find("tr[id=sec]").remove();
		$.each(data,function(i,item){
		   $("#mytable2").append("<tr id='sec' bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'>" +
		       "<td>"+item.orderNumber+"</td><td>"+item.good.name+"</td><td>"+item.price+"</td><td>"+item.number+"</td>" +
			   "</tr>");
		   
		});
		$("#mytable2").append("<tr id='sec'  bgcolor='#FCFDFE' align='center'><td colspan='4'><input type='button' value='关闭' onclick='$(\"#odlist\").CloseDiv();'></td></tr>");
	$("#odlist").OpenDiv();    
	    },
		error:function(){
			
		}
	});
}

function getOrderDetailList(type,table){
	$.ajax({
		type:"post",
	    url:"orders_getOrderDetailListByUId.action?type="+type,
	    dataType:"json",
	    success:function(data){
		$("#"+table).find("tr[id=sec]").remove();
	     $.each(data,function(i,item){
	    	 var str="<tr id='sec' align='center' height='28'>"+
           "<td width='100'>"+item.orderNumber+"</td>"+
           "<td width='100'>"+item.good.name+"</td>"+
           "<td width='83'>"+item.price+"</td>"+
           "<td width='82'>"+item.number+"</td>";
	    	 
	    	 if(type=='shou'){
	    		 str+="<td width='82'><a href='javascript:void(0);' onclick=enterReceive("+item.id+",this);>确认收获</a></td></tr>";
	    	 }else if(type=='true'){
	    		 str+="<td width='82'><a href='javascript:void(0);' onclick=goToComment("+item.good.id+",this)>评价</a></td></tr>";
	    	 }else{
	    		 str+="</tr>";
	    	 }
	    	 $("#"+table).append(str);
	     });
	    },
	    error:function(){
	    	
	    }
	});
}
function enterReceive(id,obj){
	$.ajax({
		type:"post",
	    url:"orders_enterReceive.action?model.id="+id,
	    dataType:"json",
	    success:function(data){
		  if(data=='success'){
		    $(obj).parent().parent().remove();
		     alert('您可以在待评价列表中对该商品进行评价!');
		  }
	    },
	    error:function(){
	    	
	    }
	});
}
function goToComment(id,obj){
	$.ajax({
		type:"post",
	    url:"good_getGood.action?model.id="+id,
	    dataType:"json",
	    success:function(data){
		　$("#goodid").val(data.id);
          $("#name").html(data.name);		
          $("#add_comm").OpenDiv();
	    },
	    error:function(){
	    	
	    }
	});
}
function addCommon(){
	$.ajax({
		type:"post",
	    url:"comment_add.action",
	    data:$("#commform").serialize(),
	    dataType:"json",
	    success:function(data){
		  if(data=="success"){
             alert('评价成功!');
			  $("#add_comm").CloseDiv();
          }else{
        	  alert('您对该商品的评价已达到三次，不能再进行评价!');
          }
		  
	    },
	    error:function(){
	    }
	});
}
/**
 * 前台获得商品购买记录列表
 */
function getBuyGoodRecordList(id){
	$.ajax({
		type:"post",
	    url:"orders_getODListByGid.action",
	    data:"str="+id,
	    dataType:"json",
	    success:function(data){
		  $.each(data,function(i, item) {
	         $("#tablejl").append('<tr height=25>' +
	'<td width=70 style=align:center;font-color:#3F3F3F;font-size:15px;>'+item.order.user.userName.substr(0,1)+'**'+item.order.user.userName.substr(item.order.user.userName.length-1,item.order.user.userName.length)+'</td>'+
    '<td width=83 style=font-weight:bold;align:center;font-size:15px;><font color=#FE4400>￥'+item.price+'</font></td>'+
    '<td width=100 style=align:center;font-color:#3F3F3F;font-size:15px;>'+item.order.createTime+'</td>' +
    '<td width=82 style=align:center;font-color:#3F3F3F;font-size:15px;>'+item.number+'</td></tr><tr><td colspan=4><hr/></td></tr>');
	         });
	    },
	    error:function(){
	    }
	});
}