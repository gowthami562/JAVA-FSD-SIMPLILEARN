<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Session</title>
</head>
<body>
<%
if(request.getParameter("error")!=null){
	out.println("<b>Your Session has expired or Invalid</b><br>");
}
%>
<form action="login.jsp" method="post">
Name<input name = "name" id="jhony" maxlength="40" placeholder="User Name"><br>
Password <input type="password" name="pwd" id="honey@123" maxlength="10" placeholder="Password"><br>
<input type="submit" value="Login">
</form>
</body>
</html>