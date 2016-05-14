function getList(status){
	$.ajax({
			type : "post",
			url : "store_getStoreList.action",	
			data: "model.status="+status,
			dataType : "json",
		    success : function(data) {		
                each(data);          
		    },
			error:function(){
		    
		    }
	});
}
function check(status,id){
	$.ajax({
			type : "post",
			url : "store_check.action",	
			data: "model.status="+status+"&model.id="+id,
			dataType : "json",
		    success : function(data) {
		      if(data=='success'){
                alert('操作成功!');
              }
		    },
			error:function(){
		    
		    }
	});
}
function each(data){
	$("#mytable").find("tr[id=sec]").remove();
			    $.each(data,function(i, item) {
			    	var status='',str='';
			    	str="<td><a href=javascript:void(); onclick=check('"+2+"',"+item.id+")>审核通过</a>" +
                    "/<a href=javascript:void(); onclick=check('"+1+"',"+item.id+");>不通过</a></td>";
			    	if(item.status=='0'){
			    		status='审核中';
			    	}else if(item.status=='2'){
			    		status='审核通过';
			    		str='<td><a href=javascript:void(); onclick=closeStore('+item.id+')>关闭店铺</a></td>';
			    	}else if(item.status=='1'){
			    		status='审核中';
			    	}
			    	$("#mytable").append("<tr id='sec' bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'>"+
                    "<td><a href='jsp/admin/store/storelist.jsp#' onclick='getStoreById("+item.id+")'>"+item.name+"</a></td>"+
                    "<td>"+item.descr+"</td><td>"+status+
                    "</td>"+str+
                    "</tr>");
			     });
}
function closeStore(id){
	$.ajax({
			type : "post",
			url : "store_closeStore.action",	
			data: "model.id="+id,
			dataType : "json",
		    success : function(data) {
		      if(data=='success'){
                window.location.href="store_list";
              }
		    },
			error:function(){
		    
		    }
	});

}
$(document).ready(function(){
	getList('');
});