function slide(name,id){
	if(name!=null||name!=undefined){
	  $("#p").html("说明：父类为"+name);
	  $("#pid").val(id);
	}else{
	  $("#p").html("说明：该类为根类");
	  $("#pid").val(0);
	}
    $("#c_add1").slideToggle(700);
    $("#addcform").attr("action","category_add");
}
function addc(){
	var name=$("#name").val();
	var con=$("#content").val();
	if(name!=null&&con!=null){
		$("#addcform").submit();
	}
}
function update(id){
	$.ajax({
			type : "post",
			url : "category_get.action",	
			data: "model.id="+id,
			dataType : "json",
		    success : function(data) {	
		    $("#pid").val(data.pid);
		    $("#name").val(data.name);
	        $("#content").val(data.content);
	        $("#addcform").attr("action","category_update.action?model.id="+id);
            $("#c_add1").slideToggle(700);
		    },
			error:function(){
		    
		    }
	});
}
function submitForm(){
	$.ajax({
			type : "post",
			url : "category_add.action",	
			data: $("#addcform").serialize(),
			dataType : "json",
		    success : function() {		
                selectAllC();          
		    },
			error:function(){
		    
		    }
	});
}
function each(data){
	$("#mytable").find("tr[id=sec]").remove();
			    $.each(data,function(i, item) {
			    	$("#mytable").append("<tr id='sec'   bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'>"+
                    "<td><a href='javascript:void(0);' onClick=getCListByPId('"+item.id+"')>"+item.name+"</a></td>"+
                    "<td>"+item.content+"</td>"+
                    "<td><a href='jsp/admin/category/categorylist.jsp#' onclick='update("+item.id+")'>编辑</a>" +
                    "/<a href='jsp/admin/category/categorylist.jsp#' onclick=slide('"+item.name+"',"+item.id+");>添加子类</a>" +
                    "/<a href=javascript:deleteById('"+item.id+"');>删除</a></td>"+
                    "</tr>");
			     });
}
function deleteById(id){
	$.ajax({
			type : "post",
			ContentType: "application/json; charset=utf-8",
			url : "category_delete.action",
			data:"model.id="+id,
			dataType : "json",
		    success : function(data) {
		       if(data=='success'){
		    	   alert("删除成功!");
		    	   window.location.href='jsp/admin/category/categorylist.jsp';
		       }else{
		    	   alert('有子类或该类下有商品，删除失败!');
		       }
	        },
			error:function(XMLHttpRequest, textStatus, errorThrown){
		    	alert(errorThrown);
		    }
	});
}
function getCListByPId(pid){
	  $.ajax({
			type : "post",
			ContentType: "application/json; charset=utf-8",
			url : "category_selectPCategory.action",
			data:"model.pid="+pid,
			dataType : "json",
		    success : function(data) {
		      each(data);
		    },
			error:function(XMLHttpRequest, textStatus, errorThrown){
		    	alert(errorThrown);
		    }
	});
}
$(document).ready(function(){
	 $("#c_add1").hide();
	getCListByPId(0);
});

