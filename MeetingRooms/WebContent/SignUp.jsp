<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.CommonConstant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<br><br><br><br>
<h1>新規登録</h1>
<br><br>
<form name = new action ="<%=CommonConstant.PROJECT_NAME %>/SignUpServlet" method = "post" onsubmit ="return judge()">
<table>
	<tr>
		<th class = "info">雇員ID</th>
		<td><input name = 'registerId' id = 'registerId' maxlength="6"></td>
	</tr>
	<tr>
		<th class = "info">名前</th>
		<td><input name = 'fullname' id = 'fullname'></td>
	</tr>
	<tr>
		<th class = "info">部署</th>
		<td>
			<select name="department" id="department">

					<option value="総務部" >総務部</option>
					<option value="営業部" >営業部</option>
					<option value="開発部" >開発部</option>
					<option value="人事部" >人事部</option>
					<option value="経理部" >経理部</option>

			</select>
	</tr>
	<tr>
		<th class = "info">通知用メール</th>
		<td><input type = 'email' name = 'email' id = 'email'></td>
	</tr>
	<tr>
		<th class = "info">パスワード</th>
		<td><input type = 'password' name = 'PassWord' id = 'PassWord'></td>
	</tr>
	<tr>
		<th class = "info">パスワード再入力</th>
		<td><input type = 'password' name='PassWordCheck' id='PassWordCheck'></td>
	</tr>
	<tr>
		<th colspan='2'><input type = 'submit' value = '新規登録' class = 'button' name = 'SignUp'></th>
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
	div{
		text-align: center;
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
		var meru = document.getElementById('email').value;
		var empid = document.getElementById('registerId').value;
		var idlength = empid.length;
		var name = document.getElementById('fullname').value
		var pw1 = document.getElementById('PassWord').value;
		var pw2 = document.getElementById('PassWordCheck').value;
		if(idlength == 6){
			if (name != "") {
				if (meru != "") {
					if (pw1 != ""){
					if (pw1 == pw2) {
						return true;
					}else{
						alert('パスワードが一致しません。');
						return false;
					}
					}
					else {
						alert('パスワードを入力してください。');
						return false;
					}
					}
				else{
					alert('メールアドレスを入力してください。');
					return false;
				}
			} else {
				alert('名前を入力してください。');
				return false;
			}
		} else {
			alert('正しいIDを入力してください。');
			return false;
		}
	}

</script>
</html>