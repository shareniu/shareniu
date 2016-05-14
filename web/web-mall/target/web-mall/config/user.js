var regv=false;
function validate(){
	var uname=$("#uname").val();
	if(uname!=null&&uname!=''){
		var url1="user_validateName?model.userName="+uname;
		$.ajax( {
			type : "post",
			url : url1,
			dataType : "json",
			success : function(data) {
				if(data=="rename"){
				    $("#tip0").html("<font color='red'>该用户名已存在</font>"); 
				    regv=false;
				}else{
					$("#tip0").html("<font color='green'>√</font>");
					regv=true;
				}
			},
			error : function() {
			}
		});
	}else{
		  $("#tip0").html("<font color='red'>x</font>");
		  regv=false;
	}
}
var b=false;
function repwd(val){
	var p1=$("#pwd").val();
	if(p1==val){
		$("#tip1").html("<font color='green'>√</font>");
		b=true;
	}else{
		$("#tip1").html("<font color='red'>x</font>");
	    b=false;
	}
}
var name=false,age=false,birth=true,add=false,email=false,account=false;
function regval(val,id){
   switch(id){
	case "name":
		if(val==null||val==''){
			$("[id='"+id+"']:eq(1)").html("<font color='red'>x</font>");
			 name=false;
		 }else{
			$("[id='"+id+"']:eq(1)").html("<font color='green'>√</font>");
		     name=true;
		 }
		//regval2(val,id,name);
		break;
	case "age":
		if(val==null||val==''){
			$("[id='"+id+"']:eq(1)").html("<font color='red'>x</font>");
			 age=false;
		 }else{
			$("[id='"+id+"']:eq(1)").html("<font color='green'>√</font>");
		     age=true;
		 }
		//regval2(val,id,age);
		break;
	case "birth":
		if(val==null||val==''){
			$("[id='"+id+"']:eq(1)").html("<font color='red'>x</font>");
			 birth=false;
		 }else{
			$("[id='"+id+"']:eq(1)").html("<font color='green'>√</font>");
		     birth=true;
		 }
		//regval2(val,id,birth);
		break;
	case "add":
		if(val==null||val==''){
			$("[id='"+id+"']:eq(1)").html("<font color='red'>x</font>");
			 add=false;
		 }else{
			$("[id='"+id+"']:eq(1)").html("<font color='green'>√</font>");
		     add=true;
		 }
		//regval2(val,id,add);
		break;
	case "email":
		if(val==null||val==''){
			$("[id='"+id+"']:eq(1)").html("<font color='red'>x</font>");
			 email=false;
		 }else{
			$("[id='"+id+"']:eq(1)").html("<font color='green'>√</font>");
		     email=true;
		 }
		//regval2(val,id,email);
		break;
	case "account":
		if(val==null||val==''){
			$("[id='"+id+"']:eq(1)").html("<font color='red'>x</font>");
			 account=false;
		 }else{
			$("[id='"+id+"']:eq(1)").html("<font color='green'>√</font>");
		     account=true;
		 }
		
		//regval2(val,id,account);
		break;
	case "qq":
		if(val==null||val==''){
			$("[id='"+id+"']:eq(1)").html("<font color='red'>x</font>");
			 account=false;
		 }else{
			$("[id='"+id+"']:eq(1)").html("<font color='green'>√</font>");
		     account=true;
		 }
		
		//regval2(val,id,account);
		break;
  }
}
function regval2(val,id){
	if(val==null||val==''){
		$("[id='"+id+"']:eq(1)").html("<font color='red'>x</font>");
		 v=false;
	 }else{
		$("[id='"+id+"']:eq(1)").html("<font color='green'>√</font>");
	     v=true;
	 }
	alert(v);
	alert(name);
}
function reg(){
	var b1=false;
	if(b&&regv&&name&&birth&&age&&add&&email&&account){
	   b1=true;
	}else{
	   alert("请您把信息填完整!");
	}
	alert(b+","+regv+","+name+","+birth+","+age+","+add+","+email+","+account);
	return b1;
}
