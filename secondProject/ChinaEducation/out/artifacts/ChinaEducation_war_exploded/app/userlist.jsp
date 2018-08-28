<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
function editUser(id) {
	$.ajax({
		type:"get",
		url:"${pageContext.request.contextPath}/edit",
		data:{"id":id},
		success:function(data) {
		    $("#fill").show();
			$("#myform").show();
			$("#id").val(data.id);
			$("#username").val(data.username);
			$("#password").val(data.password);
			$("#gender").val(data.gender);
			$("#header").val(data.header);
            $("#phone").val(data.phone);
            $("#education").val(data.education);
            $("#college_name").val(data.college_name);
            $("#title").val(data.title);
            $("#sign").val(data.sign);
            $("#province").val(data.province);
            $("#city").val(data.city);
            $("#weight").val(data.weight);

		}
	});
}
function updateUser(form) {
	$.post("${pageContext.request.contextPath}/update",$(form).serialize(),function(data){
		if(data=='ok'){
			alert("客户更新成功！");
			window.location.reload();
		}
		else{
			alert("修改失败");
		}
	});
}

function deleteUser(id) {
	if(confirm('确实要删除该客户吗?')) {
		var url="${pageContext.request.contextPath}/delete";
		var args={"id":id};
		$.post(url,args,function(data){
			if(data=='ok'){
				alert("客户删除更新成功！");
				window.location.reload();
			}
			else{
				alert("删除失败");
			}
			
		});
	}
}

</script>
</head>
<body>
	<table border="1">
		<tr>
			<td>id</td>
			<td>username</td>
			<td>password</td>
			<td>gender</td>
			<td>header</td>
			<td>phone</td>
			<td>education</td>
			<td>college_name</td>
			<td>title</td>
			<td>sign</td>
			<td>province</td>
			<td>city</td>
			<td>weight</td>
			<td>操作一</td>
			<td>操作二</td>
		</tr>
		<c:forEach items="${requestScope.list}" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.gender }</td>
				<td>${user.header}</td>
				<td>${user.phone}</td>
				<td>${user.education}</td>
				<td>${user.college_name}</td>
				<td>${user.title}</td>
				<td>${user.sign}</td>
				<td>${user.province}</td>
				<td>${user.city}</td>
				<td>${user.weight}</td>

				<td><a href="#" onclick="deleteUser(${user.id})">删除</a></td>
				<td><a href="#" onclick="editUser(${user.id})">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	<div id="fill" style="width: 100%; height: 100%; background-color: #000; position: absolute; top: 0px; left: 0px; opacity: 0.3; display: none; z-index: 100"></div>
	<div id="myform"
		style="width: 100%; height: 100%; position: absolute; top: 0px; left: 0px; z-index: 101; display: none">
		<form action="" method="post" onsubmit="return updateUser(this)" id="form1">
			<table width="340" border="0"
				style="margin: 20% auto; background-color: #fff">
				<tr>
				<td><input type="text" name="id"  id="id" readonly="readonly" /></td>
				</tr>
				<tr>
				<td><input type="text" name="username"  id="username"/></td>
				</tr>
				<tr>
					<td><input type="text" name="password" id="password" /></td>
				</tr>
				<tr>
					<td><input type="text" name="gender" id="gender" /></td>
				</tr>
				<tr>
					<td><input type="text" name="header" id="header" /></td>
				</tr>
				<tr>
					<td><input type="text" name="phone" id="phone" /></td>
				</tr>
				<tr>
					<td><input type="text" name="education" id="education" /></td>
				</tr>
				<tr>
					<td><input type="text" name="college_name" id="college_name" /></td>
				</tr>
				<tr>
					<td><input type="text" name="title" id="title" /></td>
				</tr>

				<tr>
					<td><input type="text" name="sign" id="sign" /></td>
				</tr>
				<tr>
					<td><input type="text" name="province" id="province" /></td>
				</tr>
				<tr>
					<td><input type="text" name="city" id="city" /></td>
				</tr>
				<tr>
					<td><input type="text" name="weight" id="weight" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="保存修改"  /> <input type="reset"
						value="重置" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>