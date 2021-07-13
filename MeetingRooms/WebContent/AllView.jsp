<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="common.CommonConstant"%>
<%@ page import="dto.ApInfoDto"%>
<%@ page import="dto.LoginInfoDto"%>
<%@ page import="service.ApService"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Date"%>
<%
LoginInfoDto loginInfo = (LoginInfoDto)session.getAttribute("LoginInfo");
ApInfoDto searchAp = new ApInfoDto();
ApService apService = new ApService();
List<ApInfoDto> listAp = apService.doSelect(searchAp);
ApInfoDto ApInfo = listAp.get(0);
List<String> checkAp = new ArrayList<String>();
checkAp.add(ApInfo.getApTime1());
checkAp.add(ApInfo.getApTime2());
checkAp.add(ApInfo.getApTime3());
checkAp.add(ApInfo.getApTime4());
checkAp.add(ApInfo.getApTime5());
checkAp.add(ApInfo.getApTime6());
List<String> Mark = new ArrayList<String>();
for(int i=0 ; i<6 ; i++ ){
	if(checkAp.get(i) == null ){
		Mark.add("○");
	} else {Mark.add("×");}
}
for(int i=0 ; i<6 ; i++ ){
	if(checkAp.get(i) != null && checkAp.get(i).equals(loginInfo.getDepartment())){
		Mark.set(i,"予約済み");
	} else {}
}
List<String> url= new ArrayList<String>();
for(int i=0 ; i<6 ; i++ ){
	if(checkAp.get(i) != null ){
		url.add(checkAp.get(i));
	} else {
		url.add("<a href = './ConfirmAp.jsp'>予約可能</a>");
	}
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約状況一覧</title>
</head>
<body>
<br><br><br><br>
<h1>予約情報一覧</h1>
<br><br>
<form action = "serblet/ApServlet" method = "get" name = "AllView"></form>
<table border="1">
	<tr class ="firstline1">
		<th class = 'firstclm'></th>
		<th class = 'firstline'>会議室</th>
	</tr>
	<tr>
		<th class = 'firstclm'>10:00~11:00</th>
		<th>
			<p class = 'apinfo'><%=Mark.get(0) %></p>
			<p class = 'apinfo'><%=url.get(0) %></p>

	</tr>
	<tr>
		<th class = 'firstclm'>11:30~12:30</th>
		<th>
			<p class = 'apinfo'><%=Mark.get(1) %></p>
			<p class = 'apinfo'><%=url.get(1) %></p>
		</th>

	</tr>
	<tr>
		<th class = 'firstclm'>13:00~14:00</th>
		<th>
			<p class = 'apinfo'><%=Mark.get(2) %></p>
			<p class = 'apinfo'><%=url.get(2)%></p>
		</th>
	</tr>
	<tr>
		<th class = 'firstclm'>14:30~15:30</th>
		<th>
			<p class = 'apinfo'><%=Mark.get(3) %></p>
			<p class = 'apinfo'><%=url.get(3) %></p>
		</th>

	</tr>
	<tr>
		<th class = 'firstclm'>16:00~17:00</th>
		<th>
			<p class = 'apinfo'><%=Mark.get(4) %></p>
			<p class = 'apinfo'><%=url.get(4) %></p>
		</th>
	</tr>
	<tr>
		<th class = 'firstclm'>17:30~18:30</th>
		<th>
			<p class = 'apinfo'><%=Mark.get(5) %></p>
			<p class = 'apinfo'><%=url.get(5)%></p>
		</th>
	</tr>
</table>

<div><a href="<%=CommonConstant.PROJECT_NAME %>/TopPage.jsp"><input type = 'button' value = 'トップページへ' class = 'button' name = 'backtoview' id = 'totop'></a></div>


</body>

<style>
	table{
		background: rgba(230,230,230,0.45);
		border-width: 3px;
		border-color: grey;
		width:400px;
		height: 300px;
		margin: auto;
	}
	body{
		background-image: url(./images/bgrd.JPG);
		background-repeat: no-repeat;
		background-size: 100% auto;
		padding-bottom: 30px;
	}
	.button{
		width: 120px;
		border: none;
		margin-bottom: 30px;
		padding: 7px;
		font-family: "BIZ UDPMincho Medium";
		color: white;
		background: rgba(68,114,196,0.5);
	}
	h1{
		color: rgb(99,112,121);
		font-family: "MS Mincho";
		text-align: center;
	}
	div{
	margin-top: 35px;
	text-align: center;
	}
	.firstline1{
		height: 20px;
	}
	.apinfo{
		margin:0 auto;
		font-family: 'BIZ UDPMincho Medium';
		padding: 5px;
	}
	.info{
		font-weight: bold;
		font-family: "BIZ UDPMincho Medium";
		color: rgba(0,0,0,0.5);
		text-align: middle;
		margin-right: 4px;
	}
	.firstline{
		font-family: "BIZ UDPMincho Medium";
		color: rgba(0,0,0,0.8);
		padding: 15px;
	}
	.firstclm{
		font-family: 'times new roman'
	}

</style>

</html>