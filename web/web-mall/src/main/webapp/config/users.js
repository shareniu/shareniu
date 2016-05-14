/**
 * 获取用户信息列表
 */
function getUserList(){
	$.ajax({
			type : "post",
			url : "user_getUserList.action",	
			dataType : "json",
		    success : function(data) {
                each2(data);          
		    },
			error:function(){
		    
		    }
	});
}
/**
 * 遍历用户信息
 * @param {Object} data
 */
function each2(data){
	$("#mytable").find("tr[id=sec]").remove();
			    $.each(data,function(i, item) {
			    	var status='',valid='';
			    	if(item.stou==true){
			    		status='店主';
			    	}else{
			    		status='非店主';
			    	}
			    	if(item.valid==true){
			    		valid='有效';
			    	}else{
			    		valid='无效';
			    	}
			    	$("#mytable").append("<tr id='sec' bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'>"+
                    "<td >"+item.userName+"</td>"+
                    "<td>"+item.name+"</td><td>"+status+"</td><td>"+valid+"</td>"+
                    "<td><a href=javascript:void(); onclick=view('"+item.id+"')>查看</a>" +
                    "/<a href=javascript:void(); onclick=OpenUpdateValid("+item.id+",'"+item.userName+"');>设置状态</a></td>"+
                    "</tr>");
			     });
}
function OpenUpdateValid(id,name){
	$("#name2").html(name);
	$("#id2").val(id);
	$("#setValid").OpenDiv();
}
function updateValid(){
	var id=$("#id2").val();
	var valid=$("#valid2").val();
	$.ajax({
			type : "post",
			url : "user_updateValid.action",
			data:"model.id="+id+"&&str="+valid,
			dataType : "json",
		    success : function(data) {
		        if(data=='success'){
		        	$('#setValid').CloseDiv();
		        	window.location.href="user_list";
		        }
            },
			error:function(){
		    
		    }
	});
}
function view(id){
	$.ajax({
			type : "post",
			url : "user_view.action",
			data:"model.id="+id,
			dataType : "json",
		    success : function(data) {
		       $("#username").html(data.userName);
		       if(data.sex=='1'){
		         $("#sex").html('男');
		       }else{
		    	 $("#sex").html('女');
		       }
		       $("#name").html(data.name);
		       $("#birthday").html(data.birthday);
		       $("#accountNumber").html(data.accountNumber);
		       $("#email").html(data.email);
		       $("#address").html(data.address);
		       $("#qq").html(data.qq);
		       $("#tel").html(data.tel);
		        $("#introduce").html(data.introduce);
		       $("#view_userinfo").OpenDiv();
		    },
			error:function(){
		    
		    }
	});
}
function deleteById(obj,id){
$.ajax({
			type : "post",
			url : "user_delete.action",
			data:"model.id="+id,
			dataType : "json",
		    success : function(data) {
              $(obj).parent.parent.remove();
            },
			error:function(){
		    
		    }
	});
}