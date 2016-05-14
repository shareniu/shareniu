function getClist(){
	$.ajax({
		type:"post",
		url:"category_selectCategoryByPid.action",
		dataType:"json",
		success:function(data){
		   		 $("#glist option:not(:first)").remove();
			    $.each(data,function(i, item) {
			    	$("#clist").append("<option value='"+item.id+"'>"+item.name+"</option>");
			     });

		},
		error:function(){
			
		}
	});
}
function getGlist(){
	$.ajax({
		type:"post",
		url:"good_getListByCidAndUid.action",
		data:"type="+$("#clist").val(),
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
function getMGList(){
	$.ajax({
		type:"post",
		url:"membergood_getList.action",
		dataType:"json",
		success:function(data){
		   		 $("#mytable").find("id=[sec]").remove();
			    $.each(data,function(i,item){
			    	var ac='会员';
			    	if(item.active==true){
			    		ac='全局';
			    	}
			$("#mytable").append("<tr bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'><td>"+(i+1)+"</td><td>"+item.good.name+"</td><td>"+item.count+"</td><td>"+ac+"</td><td>" +
			"<a href=javascript:void(0); onclick=delById(this,'"+item.id+"','"+item.good.id+"')>删除</a></td></tr>");
		   });

		},
		error:function(){
			
		}
	});
}
function delById(obj,id,gid){
	$.ajax({
		type:"post",
		url:"membergood_delete.action",
		data:"model.id="+id+"&model.good.id="+gid,
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
function add(){
	var gid=$("#glist").val();
	var count=$("#count").val();
	var ac=$("input:radio[name='model.active']:checked").val();
	   $.ajax({
		type:"post",
		url:"membergood_add.action",
		data:"model.good.id="+gid+"&model.count="+count+"&model.active="+ac,
		dataType:"json",
		success:function(data){
		if(data=='success'){
        	   alert('该商品已被放入万利折扣专区!');
        	   $("#add_mg").CloseDiv();
        	   location.href="jsp/storeadmin/membergood/membergoodlist.jsp"
           }else if(data=='fail'){
        	   alert('操作失败!');
           }
		},
		error:function(){
			
		}
	 });
}