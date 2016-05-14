/**
 * 商家主页默认获得该店铺热门商品列表
 * @param {Object} id
 * @param {Object} cid
 */
function getGList(sid,cid,type){
	var ur='';
	if(ty=='index'){
		ur='good_getTopGoodListBySid';
	}else if(ty=='qmwl'){
		ur='good_getDiscountGoodListAtStore';
	}else if(ty=='wdwl'){
		ur='good_getActiveGoodListAtStore';
	}
	$.ajax({
		async:false,
		method:"post",
		url:ur,
		data:"model.id="+sid+"&type="+cid,
		dataType:"json",
		success:function(data){
		$("#mytable").find("th[id=sec]").remove();
		$("#mytable").find("br[id=br]").remove();
		$("#mytable").find("div[id=sec]").remove();
		$("#mytable").find("hr[id=sec]").remove();
	    $("#mytable").find("tr[id^=tr]").remove();
		
	      if(ty=='index'){
	    	eachG(cid,data);
	      }else if(ty=='qmwl'){
	    	 eachAllDisCount(data);
	      }else if(ty=='wdwl'){
	    	  eachDisCount(data);
	      }	
		},
		error:function(){
			
		}
	});
}
function eachG(cid,data){
	   if(cid==null){
		   $("#mytable").append("<tr id=tr><td><br/>热门商品</td></tr>");
		  
		}
	   $("#mytable").append("<br id='br'/>");
	   $("#mytable").append("<tr id=tr0></tr>");
		   var count=0;
		   
	       $.each(data,function(i, item) {
		    if(i!=0&&i%3==0){
		    	count=count+1;
	           $("#mytable").append("<tr id=tr"+count+"></tr>");
	        }
			$("#tr"+count).append("<th id='sec' width='352' scope='col' style=padding-top:20px>"+
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
              "</th>");
		});
}
function getCListByPid(sid,pid){
   $.ajax({
			type : "post",
			ContentType: "application/json; charset=utf-8",
			url : "category_selectPCategory.action",
			data:"model.pid="+pid,
			dataType : "json",
		    success : function(data) {
	        var str="";       
	      $.each(data,function(i,item){
		         if(data.length%2!=0&&(i+1)==data.length){
		           str+="</tr><tr><th width='92' height='34' scope='col'><img src="+item.iconUrl+" width='20' height='22' align='absmiddle' /><a href=javascript:getGList('"+sid+"','"+item.id+"');><span class='STYLE2'>"+item.name+"</span></a></th></tr>";
		         }else if((i+1)%2==0){
		           str+="</th><th width='92' align='left' scope='col'><img src="+item.iconUrl+" width='18' height='20' align='absmiddle' /><a href=javascript:getGList('"+sid+"','"+item.id+"');><span class='STYLE7'>"+item.name+"</span></a></th></tr>";
		         }else{
	                str+="<tr><th width='92' height='34' scope='col'><img src="+item.iconUrl+" width='20' height='22' align='absmiddle' /><a href=javascript:getGList('"+sid+"','"+item.id+"');><span class='STYLE2'>"+item.name+"</span></a>";
		         }   	 
		      });
	        str+="<tr><td height='117'>&nbsp;</td><td>&nbsp;</td></tr>";
	         $("#c_icon_name").html(str);
		    },
			error:function(XMLHttpRequest, textStatus, errorThrown){
		    	alert(errorThrown);
		    }
	});
}