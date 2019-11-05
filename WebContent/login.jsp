<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function change() {
	var image = document.getElementById("image");
	image.src="/webProject/VerifyCodeServlet?a="+new Date().getTime();
}
</script>
<div align="center">
<form action="/webProject/LoginServlet" method="post">
	用户名：<input type="text" name="username" required> <br><br>
	密码：<input type="password" name="password" required> <br><br>
	验证码：<input type="text" name="code">
	       <img alt="" src="/webProject/VerifyCodeServlet" id="image">
	       <a href="javascript:change()">点击更换验证码</a>
	       <br><br>
	<input type="submit" value="登录">
	<%if(null != request.getAttribute("message")) {%>> 
	<P style="color:red"><%=request.getAttribute("message") %>></P>
	<%} %>>
	</form>
</div>
</body>
</html>