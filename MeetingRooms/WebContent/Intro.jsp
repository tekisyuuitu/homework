<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="common.CommonConstant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室予約システ</title>
</head>
<body>
<br><br><br><br>

	<h1>会議室予約システム</h1>
	<br><br>
<table>
	<tr>
		<td colspan='2'><a href="<%=CommonConstant.PROJECT_NAME %>/Login.jsp"><input type = 'button' value = 'ログイン' class = 'button' name = 'tologin'></a></td>
	</tr>
	<tr>
		<td colspan='2'><a href="<%=CommonConstant.PROJECT_NAME %>/SignUp.jsp"><input type = 'button' value = '新規登録' class = 'button' name = 'tosignup'></a></td>
	</tr>
</table>
</body>
<style>
	table{
		background: rgba(230,230,230,0.45);
		border-width: 3px;
		border-color: grey;
		width:400px;
		height: 200px;
		margin: auto;
	}
	body{
		background-image: url(./images/bgrd.JPG);
		background-repeat: no-repeat;
		background-size: 100% auto;
	}
	.button{
		width: 120px;
		border: none;
		margin-bottom: 20px;
		padding: 7px;
		font-family: "BIZ UDPMincho Medium";
		color: white;
		background: rgba(112,173,71,0.5);
	}
	h1{
		color: rgb(99,112,121);
		font-family: "MS Mincho";
		text-align: center;
	}
	.info{
		color: white;
		text-shadow: 1px 1px 1px grey;
	}
		td,th{
		padding-top: 20px;
		text-align: center;
	}
</style>
</html>