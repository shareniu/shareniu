function getStatisticData(store){
	var ctype=$("#ctype").val();
    // 3选择统计周期
	var sel_time= $("#sel_time").val();
	var time_list = new Array();
	switch($("#sel_time").find("option:selected").text()){
		case "--请选择--":
			time_list = [];
			break;
		case "月度":
			time_list = [];
			time_list.push("month");
			$("#month select").find("option:selected").each(function(){
				time_list.push($(this).val());
			});
			break;
		case "季度":
			time_list = [];
			time_list.push("season");
			$("#season select").find("option:selected").each(function(){
				time_list.push($(this).val());
			});
			break;
		case "年度":
			time_list = [];
			time_list.push("year");
			$("#year select").find("option:selected").each(function(){
				time_list.push($(this).val());
			});
			break;
	}
	if(time_list.length==0){
		alert("请选择统计周期");
		return		
	}
	if(ctype=='0'){
		alert("请选择统计类别");
		return;				
	}
	else
		{
		$.ajax({
			type : "post",
			url : "datastatistic_getStaData.action",		
			data :  "str="+ctype+"&t_list="+time_list+"&sel_time="+sel_time,
			dataType : "json",
			success : function(data) {
			if(data.length==0){
				alert('没有查询到数据，请重新选择!');
			}
			 $("#mytable").find('tr[id=sec]').remove();
				  $.each(data, function(i, item) {
					  var time=item.time;
					  if(sel_time=='season'){
						  time=item.time.substring(0,4)+'年'+(Math.ceil((item.time.substring(5,7).replace(/-/g, " "))/3))+'季度';
					  }else if(sel_time=='year'){
						  time=item.time.substring(0,4)+'年';
					  }
					  var name=''; 
					  if(store==null){
					    name="<td>"+item.name+"</td>";
					  }
	                      $("#mytable").append("<tr id='sec' bgcolor='#FCFDFE' align='center' height='35' style='font-size:14;'>" +
	                      "<td>"+(i+1)+"</td>"+name+"<td>"+item.totlePrice+"</td>" +
		 	              "<td>"+time+"</td></tr>");
				  });
	         },
				
			error: function() {
				alert("数据加载失败！");
			}
		});
      }

}