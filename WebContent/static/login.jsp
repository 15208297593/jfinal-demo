<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html >
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

</head>
<body>
	<form action="login/login" method="POST">
		<span>用户名:</span><input type="text" name="name"/>
		<br/>
		<span>密    码:</span><input type="text" name="password"/>
		<button id = "submit" type="submit">登录</button>
	</form>
</body>
</html>