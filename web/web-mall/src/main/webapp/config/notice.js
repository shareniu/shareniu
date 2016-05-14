function addNotice(){
	$.ajax({
		type:"post",
	    url:"notice_add.action",
	    data:$("#noticeform").serialize(),
	    dataType:"json",
	    success:function(data){
		  if(data=="success"){
              alert('添加成功!');
			  $("#add_notice").CloseDiv();
			  window.location.href="jsp/admin/notice/noticelist.jsp";
          }
		  
	    },
	    error:function(){
	    }
	});
}
function getNoticeList(valid){
   $.ajax({
		type:"post",
	    url:"notice_getNoticeListBySubflag",
	    data:"model.valid="+valid,
	    dataType:"json",
	    success:function(data){
		  $("#mytable").find("tr[id=sec]").remove();
		  $.each(data,function(i,item){
		   $("#mytable").append("  <tr id='sec' height='40'><td style='padding-left:55px;line-height:0em;'><p class='font2'>" +
		   "<a href=notice_view.action?model.id="+item.id+">"+item.title+"</a></p><div class='hr_s'/></td></tr>");
		   });
		  
	    },
	    error:function(){
	    }
	});
}
function getNoticeList2(subflag){
   $.ajax({
		type:"post",
	    url:"notice_getNoticeList",
	    dataType:"json",
	    success:function(data){
		  $("#mytable").find("tr[id=sec]").remove();
		  $.each(data,function(i,item){
		   $("#mytable").append("<tr bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'><td>"+(i+1)+"</td><td>"+item.title+"</td>" +
			   "<td>"+item.createTime+"</td><td><a href='javascript:void(0);' onclick='edit("+item.id+");'>编辑</a>/<a href='javascript:void(0);' onclick='deleteById(this,"+item.id+");'>删除</a></td></tr>");
		   });
		  
	    },
	    error:function(){
	    }
	});
}
function edit(id){
	$.ajax({
		type:"post",
	    url:"notice_get.action",
	    data:"model.id="+id,
	    dataType:"json",
	    success:function(data){
		  $("#title").val(data.title);
		  $("#content").val(data.content);
		  $("#submit").attr("onclick","update("+data.id+")");
		  $("#add_notice").OpenDiv();
	    },
	    error:function(){
	    }
	});
}
function update(id){
	$.ajax({
		type:"post",
	    url:"notice_update.action?model.id="+id,
	    data:$("#noticeform").serialize(),
	    dataType:"json",
	    success:function(data){
		  if(data=="success"){
              alert('保存成功!');
			  $("#add_notice").CloseDiv();
			  window.location.href="jsp/admin/notice/noticelist.jsp";
          }
		  
	    },
	    error:function(){
	    }
	});
}
function deleteById(obj,id){
$.ajax({
		type:"post",
	    url:"notice_deleteById.action",
	    data:"model.id="+id,
	    dataType:"json",
	    success:function(data){
	         $(obj).parent().parent().remove();
	    },
	    error:function(){
	    }
	});
}