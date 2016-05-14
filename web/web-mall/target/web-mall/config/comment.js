function getSlist(){
	$.ajax({
		method:"post",
		url:"store_getStoreList.action",
		dataType:"json",
		success:function(data){
		   $("#slist option:not(:first)").remove();
			    $.each(data,function(i, item) {
			    	$("#slist").append("<option value='"+item.id+"'>"+item.name+"</option>");
			     });
		},
		error:function(){
			
		}
	});
}
function getGlist(){
	var id=$("#slist").val();
	$.ajax({
		method:"post",
		url:"good_getGoodBySid.action",
		data:"model.id="+id,
		dataType:"json",
		success:function(data){
		   $("#glist option:not(:first)").remove();
			    $.each(data,function(i, item) {
			    	$("#glist").append("<option value='"+item.id+"'>"+item.name+"</option>");
			     });
		},
		error:function(){
			
		}
	});
}
function getComlist(){
	var id=$("#glist").val();
	$.ajax({
		method:"post",
		url:"comment_getListByGid.action",
		data:"model.id="+id,
		dataType:"json",
		success:function(data){
	         $("#mytable").find("tr[id=sec]").remove();
			    $.each(data,function(i, item) {
			    	$("#mytable").append("<tr id='sec' bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'>"+
                    "<td>"+item.good.name+"</td>"+
                    "<td>"+item.content+"</td>" +
                    "<td>"+item.user.userName+"</td>" +
                    "<td>"+item.createTime+"</td>" +
                    "<td><a href=javascript:void(0); onclick=deleteById(this,'"+item.id+"');>删除</a></td></tr>");
			     });
		},
		error:function(){
			
		}
	});
}
function deleteById(obj,id){
	$.ajax({
		method:"post",
		url:"comment_deleteById.action",
		data:"model.id="+id,
		dataType:"json",
		success:function(data){
	    	if(data=='success'){
		     //alert('删除成功!');
		    $(obj).parent().parent().remove();
		  }else{
			 alert('删除异常!');
		  }
	    },
		error:function(){
			
		}
	});
}
/**
 * 前台获取
 */
function getCommentList(id){
	$.ajax({
		method:"post",
		url:"comment_getListByGid.action",
		data:"model.id="+id,
		dataType:"json",
		success:function(data){
		$.each(data,function(i, item) {
	         $("#tablepl").append('<tr><td width=90 height=99 rowspan=2><span class=STYLE1  data-uid="">'+item.user.userName.substr(0,1)+'**'+item.user.userName.substr(item.user.userName.length-1,item.user.userName.length)+'</span> </td>'+
    '<td width=794 align=left><p class=STYLE1>'+item.content+'</p><p>&nbsp;</p></td>'+
  '</tr><tr><td height=31 align=left><span class=STYLE2>'+item.createTime+'</span></td></tr>'+
  '<tr><td height=6 colspan=2><hr style=color:#D4D4D4/></td></tr>');
	         });
	    },
		error:function(){
			
		}
	});
}