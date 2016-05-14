function getCategoryByType(pid,ty){
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
		           str+="</tr><tr><th width='92' height='34' scope='col'><img src="+item.iconUrl+" width='20' height='22' align='absmiddle' /><a href=javascript:getListByCid('"+item.id+"');><span class='STYLE2'>"+item.name+"</span></a></th></tr>";
		         }else if((i+1)%2==0){
		           str+="</th><th width='92' align='left' scope='col'><img src="+item.iconUrl+" width='18' height='20' align='absmiddle' /><a href=javascript:getListByCid('"+item.id+"');><span class='STYLE7'>"+item.name+"</span></a></th></tr>";
		         }else{
	                str+="<tr><th width='92' height='34' scope='col'><img src="+item.iconUrl+" width='20' height='22' align='absmiddle' /><a href=javascript:getListByCid('"+item.id+"');><span class='STYLE2'>"+item.name+"</span></a>";
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
function getListByCid(cid){
	getListByType(cid,ty);
}