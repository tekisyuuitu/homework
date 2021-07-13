<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.CommonConstant"%>
<%@ page import="dto.LoginInfoDto"%>
<%
LoginInfoDto loginInfo = (LoginInfoDto)session.getAttribute("LoginInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>
</head>
<body>

<br><br><br><br>
<h1>会議室予約システム</h1>
	<br>
	<p class = "info" >ようこそ、<%=loginInfo.getDepartment() %>　<%=loginInfo.getName() %>　さん。</p>
	<br><br>
<table>
	<tr>
		<td colspan='2'><div><a href="<%=CommonConstant.PROJECT_NAME %>/AllView.jsp"><input type = 'button' value = '予約情報一覧' class = 'button' name = 'allview'></a></div></td>
	</tr>
	<tr>
		<td colspan='2'><div><a href="<%=CommonConstant.PROJECT_NAME %>/Intro.jsp"><input type = 'button' value = 'ログアウト' class = 'button' name = 'logout'></a></div></td>
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
	div{
		text-align: center;
	}
	h1{
		color: rgb(99,112,121);
		font-family: "MS Mincho";
		text-align: center;
	}
	p{
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
		padding-top: 20px;
	}
</style>

</html>