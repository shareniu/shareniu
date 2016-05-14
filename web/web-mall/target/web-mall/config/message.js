function getMessageList(tys,t){
	$.ajax({
		async:false,
		type:"post",
		url:"user_getMessageListByType.action?str="+tys,
		dataType:"json",
		success:function(data){
		   $("#"+t).find("tr[id=sec]").remove();
		  $.each(data,function(i,item){
			  $("#"+t).append("<tr id='sec' height='40'><td width='320px' style='line-height:0em;padding-left:10px;'><p class='font2' align='center'>" +
		   "<a href=user_getMessageById.action?model.id="+item.id+">"+item.title+"</a></p><div class='hr_s'/></td>" +
		   "<td width='112px'>"+item.fromUser.userName+"</td><td width='110px'>"+item.createTime+"</td</tr>");
		   });
		},
		error:function(){
			
		}
	});
}