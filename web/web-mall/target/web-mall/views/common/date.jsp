<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
	<script language="javascript" type="text/javascript">
	var d=new Date();
	var year=d.getFullYear();
	  function datePlay(){
		  
		  var cdate=$("#sel_time").val();
		  if(cdate=='month'){
			  $("#month").attr("style","display:");
			  $("#year").attr("style","display:none");
			  $("#season").attr("style","display:none");
		  }else if(cdate=='season'){
			  $("#month").attr("style","display:none");
			  $("#season").attr("style","display:");
			  $("#year").attr("style","display:none");
		  }else if(cdate=='year'){
			  $("#month").attr("style","display:none");
			  $("#year").attr("style","display:");
			  $("#season").attr("style","display:none");
		  }else{
			  $("#month").attr("style","display:none");
			  $("#year").attr("style","display:none");
			  $("#season").attr("style","display:none");
		  }
	  }
	</script>
	</head>
	<body>
	<%--月度--%>
	<div style="display: none;" id="month">
  <table width="70%" border=0>
    <tr><td width="10px">
			<select id="t_month_year1">
				<script language="javascript" type="text/javascript">
for ( var i = year; i >= 2000; i--) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select>
			</td>
			<td width="10px">年</td>
			<td width="30px">
			
			<select id="t_month_month1">
				<script language="javascript" type="text/javascript">
for ( var i = 1; i <= 12; i++) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select>
					</td><td width="60px">
			月度&nbsp;-&nbsp;
					</td><td width="30px">
			<select id="t_month_year2">
				<script language="javascript" type="text/javascript">
for ( var i = year; i >= 2000; i--) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select>
					</td><td width="20px">
			年
					</td><td width="30px">
			<select id="t_month_month2">
				<script language="javascript" type="text/javascript">
for ( var i = 1; i <= 12; i++) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select></td><td width="60px">
		月度&nbsp; &nbsp;
</td></tr></table>
</div>


<%--季度--%>
<div  style="display: none;" id="season">
		<table width="70%" border=0>
		<tr><td width="30px">
			<select id="t_season_year1">
				<script language="javascript" type="text/javascript">
for ( var i = year; i >= 2000; i--) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select></td><td width="20px">
			年
</td><td width="30px">
			<select id="t_season_month1">
				<script language="javascript" type="text/javascript">
//var s = "一二三四";s.substring(i,i-1);
for ( var i = 1; i <= 4; i++) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select>
</td><td width="60px">			季度&nbsp;-&nbsp;
		</td><td width="30px">
			<select id="t_season_year2">
				<script language="javascript" type="text/javascript">
for ( var i = year; i >= 2000; i--) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select>
		</td><td width="20px">	年
</td><td width="30px">			<select id="t_season_month2">
				<script language="javascript" type="text/javascript">
for ( var i = 1; i <= 4; i++) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select>
		</td><td width="60px">季度&nbsp; &nbsp;
</td></tr></table></div>		
		
		
		<%--年度--%>
		<div id="year" style="display:none">
		<table width="40%" border=0>
		<tr><td width="20px">
			<select id="t_year_1">
				<script language="javascript" type="text/javascript">
for ( var i = year; i >= 2000; i--) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select>
</td>
<td width="60px">			年度&nbsp;-&nbsp;
</td><td width="30px">			<select id="t_year_2">
				<script language="javascript" type="text/javascript">
for ( var i = year; i >= 2000; i--) {
	document.write("<option value=" + i + ">" + i + "</option>");
}
</script>
			</select>
		</td><td width="40px">	年度
		</td>
		</tr></table></div>
	</body>
</html>