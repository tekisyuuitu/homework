<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.CommonConstant"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.LoginInfoDto"%>
<%@ page import="dto.ApInfoDto"%>
<%
LoginInfoDto loginInfo = (LoginInfoDto)session.getAttribute("LoginInfo");
ApInfoDto apInfo = (ApInfoDto)session.getAttribute("AP_INFO");
List<String> MsgList = (List<String>) request.getAttribute(CommonConstant.ATTRIBUTE_MSGLIST);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認</title>
</head>
<body>
<%
if (null != MsgList) {
	for (String msg : MsgList) {
%>
	<%=msg %>
<%
	}
}
%>
<%--  --%>
<br><br><br><br>
<h1>予約確認</h1>
<br><br>
<form name="formAp" action="<%=CommonConstant.PROJECT_NAME %>/ConfirmApServlet" method="post">
<table>

	<tr>
		<th class = "info">予約情報：</th>
	</tr>
	<tr>
		<th class = "info">
		<p>時間帯</p>
			<select name="time" id="time">

					<option value="0" >10:00~11:00</option>
					<option value="1" >11:30~12:30</option>
					<option value="2" >13:00~14:00</option>
					<option value="3" >14:30~15:30</option>
					<option value="4" >16:00~17:00</option>
					<option value="5" >17:30~18:30</option>

			</select>
			<p><%=loginInfo.getDepartment() %></p>
		</th>
	</tr>

	<tr>
		<th colspan='2'><a href = "./AllView.jsp"><input type = 'button' value = '戻る' class = 'button' name = 'backtoview' id = 'back'></a><input type = 'submit' value = '予約する' class = 'button' name = 'confirmAp'></th>
	</tr>
</table>
</form>
</body>
<style>
	table{
		background: rgba(230,230,230,0.45);
		border-width: 3px;
		border-color: grey;
		width:100%;
		height: 300px;
		border-spacing: 10px;
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
		margin-bottom: 20px;
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
	.info{
		font-weight: bold;
		font-family: "BIZ UDPMincho Medium";
		color: rgba(0,0,0,0.5);
		text-align: middle;
		margin-right: 4px;
	}
	td,th{
		padding-top: 30px;
	}
	#back{
		margin-right: 50px;
	}
</style>



</html>