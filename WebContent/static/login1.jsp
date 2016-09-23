<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>BootStrap3.3.0测试</title>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script>
	 
</script>

</script>
<style>
.col-center-block {
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>
</head>

<body>
<div class="container">
  <div class="row myCenter">
    <div class="col-xs-6 col-md-4 col-center-block">
      <form id="frm1" class="form-signin" action="${ctxPath}/login/login" method="POST">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="username" class="sr-only">用户名</label>
        <input type="text" name="username" class="form-control" placeholder="用户名"  required autofocus value="${username}">
        <span style="color:red;">${nameMsg}</span>
        <label for="inputPassword" class="sr-only">密码 </label>
        <input type="password" name="inputPassword" class="form-control" placeholder="密码" required value="${inputPassword}">
         <span style="color:red;">${inputPasswordMsg}</span>
        <input name="randomCode"  size="30" type="text" placeholder="验证码" style="height:35px;" required	 />
        <img src="${ctxPath}/login/img" id="imgId" style="height:35px;margin-top: -2px;margin-left: -2px;" onclick="javascript:this.src='${ctxPath}/login/img?'+Math.random();"/>
       	<p style="color:red;">${errorCodeMsg}</p>  
       	<p style="color:red;">${codeMsg}</p>  
       	<p style="color:red;">${errorAcountMsg}</p>  
        <!-- onclick="javascript:this.src='/common/random_code?' + new Date().getTime();" -->
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me">
           	 记住我</label>
        </div>
        <button id="ss" class="btn btn-lg btn-primary btn-block" type="submit" onclick="show()">登录</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>