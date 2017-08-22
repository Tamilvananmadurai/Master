<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
    <meta charset="UTF-8">
    <title>APS Dashboard - Login</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
	<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/stylelogin.css">
  </head>
  <body>
<!-- Form Mixin-->
<!-- Input Mixin-->
<!-- Button Mixin-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>APS Dashboard</h1>
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle">
  </div>
  <div class="form">
    <h2>Login to your account</h2>
    <form name="Login" action="<%=request.getContextPath()%>/LoginControl?choice=1" method=post>
      <input type="text" placeholder="Username" name="Username"/>
      <input type="password" placeholder="Password" name="Password"/>
      <button>Login</button>
    <% String msg="";
		msg=request.getParameter("msg");
		if(msg != null)
		{%><br>
		<a style="color:red" ><br><br><%out.println("Invalid Credentials");%></a>
		 <%}
	%>
    </form>
  </div>
</div>
        <script src="js/index.js"></script>
  </body>
</html>
