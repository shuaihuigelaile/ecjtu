<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />

<link href="css/style1.css" rel='stylesheet' type='text/css' />

<script type="text/javascript" src="js/jquery.min.js"></script>
<style type="text/css">
	.register{
		width: 100%;
		height: 50px;
		line-height: 50px;
	}
	.register a{
		font-size: 20px;
		color: white;
	}
</style>
</head>
<body>
		<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>

<h1>欢迎来到华缘交友</h1>
<div class="login-form">
	<div class="close"> </div>
	<div class="head-info">
		<label class="lbl-1"> </label>
		<label class="lbl-2"> </label>
		<label class="lbl-3"> </label>
	</div>
	<div class="clear"> </div>
	<div class="avtar"><img src="images/avtar.png" /></div>
		<form action="${pageContext.request.contextPath}/login" method="post">
		<input type="text" class="text" value="Username" name="username" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Username';}" >
		<div class="key"><input type="password" value="Password" name="password" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Password';}"></div>
		<div class="signin"><input type="submit" value="登录" ></div>
		</form>
		
	<div class="register"><a href="register.jsp">注册</a></div>
</div>

<div class="copy-rights">
	<p>Copyright &copy; 2018.ECJTU name All rights reserved.</p>
</div>
</body>
</html>