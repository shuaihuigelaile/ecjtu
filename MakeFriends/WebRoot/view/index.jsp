<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	<style type="text/css">
		*{
			padding: 0;
			margin: 0;
		}
		.main{
			width: 100%;
			height: auto;
		}
		.header{
			width: 100%;
			height: 105px;
			background-color: #8b6369;
		}
		.header ul{
			width:600px;
			list-style: none;
			padding: 30px 200px;
			float:left;
		}
		.header ul li{
			padding: 12px;
			float: left;
		}
		.header ul li a{
			color: white;
			padding: 5px;
			text-decoration: none;
		}
		.header ul li a:hover{
			color: red;
			background: #FAF5DF;
		}
		.header span{
			display:block;
			margin-right:10px;
			padding-top:20px;
			float:right;
		}
		.mainbody{
			width: 100%;
			height:924px;
			background: url(${pageContext.request.contextPath}/view/images/bg1.jpg) 0 0 no-repeat;
		}
		.main .header .header_left{
			width: 50px;
			height: 50px;
			float: left;
			display: block;
			margin-left: 80px;
			margin-top: 30px;
			
		}
		.middletable{
			margin:0 auto;
		}
	</style>
	<!-- <script src="js/jquery-3.2.1.js"></script> -->
	<!-- <script type="text/javascript">
	  function showUser() {
            var xmlHttp;
            xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function () {
            //alert(xmlHttp.readyState + "  "+xmlHttp.status)
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200){

                    //var obj = eval("("+xmlHttp.responseText+")");
                   var obj = JSON.parse(xmlHttp.responseText);

                    var string = "<table><tr><td>用户名</td><td>密码</td><td>手机号</td><td>邮箱</td></tr>";

                    for(var i = 0;i<obj.users.length;i++){
                       
                        string = string + "<tr>"+
				"<td>"+1+"</td>"+
				"<td>"+obj.users[i].password+"</td>"+
				"<td>"+obj.users[i].phone+"</td>"+
				"<td>"+obj.users[i].email+"</td>"+
			"</tr>";
                            
                    }

                    string = string + "</table>"; 
                    document.getElementById("d3").innerHTML=string;
          }  
          	
          }    
          xmlHttp.open("get","${pageContext.request.contextPath}/query",true);
            xmlHttp.send(null);
              
     }          
	</script> -->
	<script type="text/javascript">
			 function showUser() {
            var xmlHttp;
            xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function () {
            //alert(xmlHttp.readyState + "  "+xmlHttp.status)
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                   var obj = JSON.parse(xmlHttp.responseText);
                   var string = "<table class='middletable'>";
                   		for(var i = 0;i<obj.users.length;i++){
                   			string=string+"<tr>"+
			"<td rowspan='4'>"+"<img src='images/"+i+".jpg' width='50px' height='50px'/>"+"</td>"+
			"<td>"+"用户名"+"</td>"+
			"<td>"+obj.users[i].logname+"</td>"+
		"</tr>"+
		"<tr>"+
			"<td>"+"手机"+"</td>"+
			"<td>"+obj.users[i].phone+"</td>"+
		"</tr>"+
		"<tr>"+
			"<td>"+"邮箱"+"</td>"+
			"<td>"+obj.users[i].email+"</td>"+
		"</tr>"+
		"<tr>"+
			"<td>"+"名言"+"</td>"+
			"<td>"+obj.users[i].message+"</td>"+
		"</tr>"
                   		}
                   		string=string+"</table>";
                   		 document.getElementById("d3").innerHTML=string;
                
                 }  
          	
          }    
          xmlHttp.open("get","${pageContext.request.contextPath}/query",true);
            xmlHttp.send(null);
              
     }    
     
           
	</script>
</head>
<body>
 	<div class="main">
		<div class="header">
			<div class="header_left"><img src="${pageContext.request.contextPath}/view/images/1.jpg" style="width:50px;height: 50px"></div>
			<ul>
				<li><a href="${pageContext.request.contextPath}/view/index.jsp">主页</a></li>
				<li><a href="${pageContext.request.contextPath}/view/upload.jsp" onclick="uploadPhoto()">上传照片</a></li>
				<li><a href="#">浏览会员</a></li>
				<li><a href="${pageContext.request.contextPath}/view/updatePassword.jsp">修改密码</a></li>
				<li><a href="#" onclick="showUser()">注册信息</a></li>
				<li><a href="${pageContext.request.contextPath}/view/login.jsp">退出登录</a></li>
			</ul>
			<span style="color:white">欢迎你<%=session.getAttribute("loginName") %></span>
		</div>
		<div class="mainbody" id="d3"></div>
		<div class="mainbody2" id="d4"></div>
	</div>
</body>
</html>