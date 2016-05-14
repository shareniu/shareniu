/**
 * 商品列表
 */
function getGoodList(){
	$.ajax({
		type:"post",
		url:"good_getGoodList.action",
		dataType:"json",
		success:function(data){
		$.each(data,function(i,item){
			$("#mytable").append("<tr bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'><td>"+(i+1)+"</td><td>"+item.name+"</td><td>"+item.category.name+"</td><td>"+item.grade+"</td><td>"+item.currentPrice+"</td><td><a href=good_edit.action?model.id="+item.id+">编辑</a>" +
			"/<a href=javascript:delById('"+item.id+"')>删除</a></td></tr>");
		});
		},
		error:function(){
			
		}
	});	
}

/**
 * admin:商品列表
 */
function getGoodList2(){
	$.ajax({
		type:"post",
		url:"good_getGoodList.action",
		dataType:"json",
		success:function(data){
		$.each(data,function(i,item){
			$("#mytable").append("<tr bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'><td>"+(i+1)+"</td><td>"+item.name+"</td><td>"+item.category.name+"</td><td>"+item.grade+"</td><td>"+item.currentPrice+"</td><td><a href=javascript:void(0) onclick=setStatue("+item.id+",'"+item.name+"')>设置状态</a></td></tr>");
		});
		},
		error:function(){
			
		}
	});	
}
function setStatue(id,name){
	$("#name").html(name);
	$("#id").val(id);
	$("#setStatue").OpenDiv();
}
function updateStatue(){
	var id=$("#id").val();
	var valid=$("#valid").val();
	$.ajax({
		type:"post",
		url:"good_updateGoodStatue.action",
		data:"model.id="+id+"&&type="+valid,
		dataType:"json",
		success:function(data){
		if(data=='success'){
			alert('设置成功!');
		}
           $("#setStatue").CloseDiv();		 
		},
		error:function(){
			
		}
	});	
}
function delById(id){
	$.ajax({
		type:"post",
		url:"good_delete.action",
		data:"model.id="+id,
		dataType:"json",
		success:function(data){
		  if(data=='success'){
		     alert('删除成功!');
		     window.location.href="jsp/storeadmin/good/goodlist.jsp";
		  }else{
			 alert('订单中包含该商品，暂时无法进行删除!');
		  }
		},
		error:function(){
			
		}
	});	
}

/**
 * 遍历
 * @param {Object} data
 */
function each(data){
	var count=0;
	$("#mytable").append("<tr id=tr0 width='auto' align='left'></tr>");
	$.each(data,function(i, item) {
		if(i!=0&&i%3==0){
	      count=count+1;
	      $("#mytable").append("<tr id=tr"+count+"></tr>");
	    }
			    	$("#tr"+count).append("<td id='sec' align='left' width='352' style=padding-top:20px>"+
                "<table width='327' height='306' border='0' bordercolor='#000000' cellspacing='0'>"+
                  "<tr>"+
                    "<th height='208' colspan='2' bgcolor='#FFFFFF' scope='col'><img src='"+item.pictureurl+"' width='290' height='191' /></th>"+
                  "</tr>"+
                  "<tr bgcolor='#FFFFFF'>"+
                    "<td height='16' colspan='2' bgcolor='#FFFFFF'><h5 align='left'><a href='good_view.action?model.id="+item.id+"' target='_blank' class='STYLE27 STYLE31' style='text-decoration:none;'><span style='font-weight: normal;'>&nbsp; "+item.name+"</span></a></h5></td>"+
                  "</tr>"+
                  "<tr bgcolor='#FFFFFF'>"+
                    "<td width='107' height='51'><div align='left'><span class='STYLE21'>￥</span><span class='STYLE26'>"+item.currentPrice+"</span></div></td>"+
                    "<td width='210' bgcolor='#FFFFFF' ><div align='right'><a href='good_view.action?model.id="+item.id+"' class='STYLE43' style='text-decoration:none;'>去抢购</a></div></td>"+
                  "</tr>"+
              "</table>"+
              "</td>");
		});
	
}

/**
 * 遍历
 * @param {Object} data
 */
function eachStore(data){
	$("#mytable").append("<tr id=tr0><td id=td bgcolor='#FFFFFF' colspan=3>");
	$.each(data,function(i, item) {
			    	$("#td").append("<div id='sec'  class='t1'><h2> &nbsp;&nbsp;"+item.name+"</h2><a href=store_storeIndex.action?model.id="+item.id+" class='t2'>逛店铺</a><br/>"+
	   "<font align='top'>&nbsp;&nbsp;&nbsp;&nbsp;主营项目：</font></div><hr id='sec' colr='#E6E6E6' width='90%'/>");
     });
	
}

/**
 * 通过日期排序取商品列表
 * 用于首页商品展示
 */
function getListByType(cid,ty){
	var ur="";
	if(ty=='topstore'){
		$("#mytable").attr("bgcolor","#FFF");
		ur="store_getStoreList";
	}else if(ty=='wanli'){
	    $("#mytable").attr("bgcolor","#ECECEC");
		ur="good_getActiveGoodList";//false为全民打折商品	
	}else{
	    $("#mytable").attr("bgcolor","#ECECEC");
		ur="good_getGoodListByType";
	}
	$.ajax({
		async:false,
		type:"post",
		url:ur,
		data:"model.id="+cid+"&type="+ty,
		dataType:"json",
		success:function(data){
	    $("#mytable").find("div[id=sec]").remove();
		$("#mytable").find("hr[id=sec]").remove();
		$("#mytable").find("tr[id^=tr]").remove();
		$("#mytable").find("th[id=sec]").remove();
		$("#mytable").find("br[id=br]").remove();
		  if(ty=='index'){
		     each(data);//循环商品
		  }else if(ty=='new'||ty=='top'){
			  each(data);//循环商品
		  }else if(ty=='topstore'){
			  eachStore(data);//循环店铺
		  }else if(ty=='wanli'){
			  eachWanLi(data);
		  }
		},
		error:function(){
			
		}
	});	
}
/**
 * 循环万利商品
 * @param {Object} data
 */
function eachWanLi(data){
	$.each(data,function(i, item) {
	      if(i==0){
	    	  eachAllDisCount(item);
	      }else{
	    	  eachDisCount(item);
	      }	
     });
	
}
function eachAllDisCount(data){
	var count=0;
	$("#mytable").append("<tr id='tr'><td><br id='br'/><font style='font-size:18px;font-weight=bold;'>全民大优惠</font><td></tr>");
	$("#mytable").append("<tr id='tr'><td colspan=3> <hr id='sec'/></td></tr><tr id=tr"+count+"/>");
	$.each(data,function(i, item) {
		if(i!=0&&i%3==0){
			count=count+1;
	      $("#mytable").append("<tr id=tr"+count+"></tr>");
	    }

			    	$("#tr"+count).append("<td id='sec' width='352' scope='col' style=padding-top:20px>"+
                "<table width='327' height='280' border='0' bordercolor='#000000' cellspacing='0'>"+
                  "<tr>"+
                    "<th height='208' colspan='2' bgcolor='#FFFFFF' scope='col'><img src='"+item[0].pictureurl+"' width='290' height='191' /></th>"+
                  "</tr>"+
                  "<tr bgcolor='#FFFFFF'>"+
                    "<td height='16' colspan='2' bgcolor='#FFFFFF'><h5 align='left'><a href='good_view.action?model.id="+item[0].id+"' target='_blank' class='STYLE27 STYLE31' style='text-decoration:none;'><span style='font-weight: normal;'>&nbsp; "+item[0].name+"</span></a></h5></td>"+
                  "</tr>"+
                  "<tr bgcolor='#FFFFFF'>"+
                    "<td width='107'  colspan='2'  height='auto'><div align='left'><span class='STYLE21' style='font-size:12px;height:auto'>原价：￥</span><span class='STYLE26' style='font-size:12px;height:auto'>"+item[0].currentPrice+"</span></div></td>"+
                    "</tr>" +
                  "<tr bgcolor='#FFFFFF'>" +
                    "<td width='207' height='51'><div align='left'><span class='STYLE21'>现价：￥</span><span class='STYLE26'>"+((item[0].currentPrice*item[1].count*0.1).toFixed(2))+"</span></div></td>"+                    
                    
                    "<td width='210' bgcolor='#FFFFFF' ><div align='right'><a href='good_view.action?model.id="+item[0].id+"' class='STYLE43' style='text-decoration:none;'>去抢购</a></div></td>"+
                  "</tr>"+
              "</table>"+
              "</td>");
		});
		$("#mytable").append("<br id='br'/>");
}
function eachDisCount(data){
	var count=0;
    $("#mytable").append("<tr id='tr'><td><br id='br'/><font style='font-size:18px;font-weight=bold;'>您的特价单</font><td></tr>");
	$("#mytable").append("<tr id='tr'><td  colspan=3><hr id=sec/><td></tr><tr id=trTj"+count+"/>");
	$.each(data,function(i, item) {
		if(i!=0&&i%3==0){
	      count=count+1;
	      $("#mytable").append("<tr id=trTj"+count+"></tr>");
	    }
			    	$("#trTj"+count).append("<td id='sec' width='352' scope='col' style=padding-top:20px>"+
                "<table width='327' height='280' border='0' bordercolor='#000000' cellspacing='0'>"+
                  "<tr>"+
                    "<th height='208' colspan='2' bgcolor='#FFFFFF' scope='col'><img src='"+item[0].pictureurl+"' width='290' height='191' /></th>"+
                  "</tr>"+
                  "<tr bgcolor='#FFFFFF'>"+
                    "<td height='14px' colspan='2' bgcolor='#FFFFFF'><h5 align='left'><a href='good_view.action?model.id="+item[0].id+"' target='_blank' class='STYLE27 STYLE31' style='text-decoration:none;'><span style='font-weight: normal;'>&nbsp; "+item[0].name+"</span></a></h5></td>"+
                  "</tr>"+
                  "<tr bgcolor='#FFFFFF'>"+
                    "<td width='107' height='auto' colspan='2'><div align='left' style='height:auto'><span class='STYLE21' style='font-size:12px;height:auto'>原价：￥</span><span class='STYLE26' style='font-size:12px;height:auto'><strike>"+item[0].currentPrice+"</strike></span></div></td>"+
                  "</tr>" +
                  "<tr bgcolor='#FFFFFF'>" +
                    "<td width='207' height='51'><div align='left'><span class='STYLE21'>现价：￥</span><span class='STYLE26'>"+((item[0].currentPrice*item[1].count*0.1).toFixed(2))+"</span></div></td>"+                    
                    "<td width='110' bgcolor='#FFFFFF' ><div align='right'><a href='good_view.action?model.id="+item[0].id+"' class='STYLE43' style='text-decoration:none;'>去抢购</a></div></td>"+
                  "</tr>"+
              "</table>"+
              "</td>");
		});
}
/**
 * 加入购物车
 */
function addCar(){
	document.addCarform.submit();
}

/**
 * 得到购物车列表信息
 */
function getCartItem(){
	$.ajax({
		async:false,
		type:"post",
	    url:"good_getCartItems.action",
	    dataType:"json",
	    success:function(data){
		var totle=0;
	        $.each(data,function(i, item) {
	        	
	        	totle+=item.good.currentPrice*item.count;
         	   $("#mytable").append("<tr id='tr"+i+"'>"+
    "<td width='281' height='44'><a href='good_view?model.id="+item.good.id+"'><span class='STYLE48'>"+item.good.name+"</span></a></td>"+
    "<td width='90' align='center'><p class='STYLE46' tabindex='0'></p>"+
        "<p class='STYLE46' tabindex='0'>"+item.good.introduce+"</p></td>"+
    "<td width='106'><div align='center'>"+
    "<input type='hidden' id='currentPrice"+i+"' name='cartlist["+i+"].good.currentPrice' value='"+item.good.currentPrice+"'>" +
    "<strong id=price"+i+">"+item.good.currentPrice+"</strong></div></td>"+
    "<td width='62' align='center'><input type='hidden' id='id"+i+"' name='cartlist["+i+"].good.id' value='"+item.good.id+"'>" +
    "<input type='hidden' id='type"+i+"' name='cartlist["+i+"].type' value='"+item.type+"'>" +
    "<input id=count"+i+" name='cartlist["+i+"].count' type='text' size='5' value='"+item.count+"' onblur=reCompute('"+i+"') /></td>"+
    
    "<td width='74'><span class='STYLE44' name=sum"+i+" id=sum"+i+">"+(item.good.currentPrice*item.count)+"</span></td>"+
    "<td width='107'><div align='center' class='STYLE50'><a href='javascript:void(0);' onclick=delTr('tr"+i+"')>删除</a></div></td>"+
  "</tr>"+
  "<tr>"+
    "<td height='11' colspan='6'><hr color='#CCCCCC'/></td>"+
  "</tr>");	

	         });
	        $("#mytable2").append("<tr>"+
    "<td width='693'><div align='right'>合计：<span class='STYLE44' id='totle'></span></div></td>"+
    "<td width='100'><div align='right'>"+
      "<div align='right'><a href='javascript:void(0)' onclick='settle();' class='STYLE49' style='text-decoration:none;'>结算</a></div></td>"+
  "</tr>");
	                 	   $("#totle").html("￥"+totle);
	    },
	    error:function(){
	    	
	    }
	});
}

function reCompute(i){
	var price=parseFloat($("#price"+i).html());
	var count=parseFloat($("#count"+i).val());
	$("#sum"+i).html(price*count);
	var totle = 0;//总数
	var arr = $("span[id^='sum']");
	arr.each(function() {
	   if($(this).attr("id").indexOf("sum") != -1){
	     totle += parseFloat($(this).html());  
	     
	   }
	});
	$("#totle").html(totle);
}
function delTr(tr){
	var i=tr.substring(tr.length-1,tr.length);
	var id=$("#id"+i).val();
	$.ajax({
		type:"post",
		url:"good_delCarItemByGId.action",
		data:"model.id="+id,
		dataType:"json",
		success:function(data){
			$("#"+tr).remove();
	        var totle = 0;//总数
	        var arr = $("span[id^='sum']");
	        arr.each(function() {
	          if($(this).attr("id").indexOf("sum") != -1){
	             totle += parseFloat($(this).html());  
	           }
	        });
	        $("#totle").html(totle);
	   },
		error:function(){
			
		}
	});		
}
function settle(){
$("#form2").submit();	
}
function settleOrders(){
$("#orderform").submit();	
}

function search(id){
   $.ajax({
		type:"post",
		url:"good_searchGoodName",
		data:"model.name="+$("#searchname").val()+"&model.store.id="+id,
		dataType:"json",
		success:function(data){
          $("#mytable").find("div[id=sec]").remove();
		  $("#mytable").find("hr[id=sec]").remove();
		  $("#mytable").find("th[id=sec]").remove();
		  $("#mytable").find("br[id=br]").remove();
		  $("#mytable").find("tr[id^=tr]").remove();
		      each(data);//循环商品
        },
		error:function(){
			
		}
	});
}