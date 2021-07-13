<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="common.CommonConstant"%>
<%
List<String> errorMsgList = (List<String>) request.getAttribute(CommonConstant.ATTRIBUTE_MSGLIST);
String EmpID = "";			// ログインID
String PassWord = "";		// パスワード
if (null != request.getAttribute("EmpID")) {
	EmpID = (String) request.getAttribute("EmpID");
}
if (null != request.getAttribute("PassWord")) {
	PassWord = (String) request.getAttribute("PassWord");
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<%
if (null != errorMsgList) {
	for (String msg : errorMsgList) {
%>
	<%=msg %><br/>
<%
	}
}
%>
<%--  --%>
<br><br><br><br>

<h1>ログイン</h1>
<br><br>
<form name="form1" action="<%=CommonConstant.PROJECT_NAME %>/LoginServlet" method="post" onsubmit ="return judge()">
<table>

	<tr>
		<th class = "info">雇員ID</th>
		<td><input type="text" name = "EmpID" id = "EmpID" maxlength="6"></td>
	</tr>

	<tr>
		<th class = "info">パスワード</th>
		<td><input type = 'password' name = 'PassWord'></td>
	</tr>
	<tr>
		<th colspan='2'><input type = 'submit' value = 'ログイン' class = 'button' name = 'Login'></th>
	</tr>
</table>
</form>
</body>

<style>
	table{
		background: rgba(230,230,230,0.45);
		border-width: 3px;
		border-color: grey;
		width:400px;
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
		text-align: right;
		margin-right: 4px;
	}
	td,th{
		padding-top: 30px;
	}
</style>
<script type="text/javascript">
	function judge(){
		var empid = document.getElementById('EmpID').value;
		var idlength = empid.length;
		if(idlength != 6)
			{
				alert('正しいIDを入力してください。');
				return false;
			}
			else
				return true;
	}



</script>
</html>