<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.mainbody{
		width:500px;
		height:300px;
		margin:0 auto;
	}
</style>
</head>
<body>	
	<div class="mainbody">
	<form action="${pageContext.request.contextPath}/Update" type="post">
		原密码：<input type="password" name="oldpassword"/><br>
		新密码：<input type="password" name="newpassword"/><br>
		<input type="submit" value="提交"/>
	</form>
	</div>
</body>
</html>