<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<h1>This is content from the main file.</h1><br>
<%@ include file="included.jsp" %>
<hr>


<p>
       
       Current date and time is  = <%= new Date()%>
</p>

</body>
</html>