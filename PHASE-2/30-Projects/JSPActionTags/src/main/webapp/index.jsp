<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Action Tags</title>
</head>
<body>
Usage of useBean tag<br>
<jsp:useBean id="productBean" class="com.ecommerce.ProductBean" scope="session"></jsp:useBean>
        <jsp:setProperty property="productId" name="productBean" value="1430"/>
        <jsp:setProperty property="productName" name="productBean" value="HP Laptop"/>
        <jsp:setProperty property="price" name="productBean" value="93000.00"/>
        <hr>

<jsp:useBean id="mobiles" class="com.consumerGoods.Mobiles" scope="session"></jsp:useBean>
        <jsp:setProperty property="productId" name="mobiles" value="1235"/>
        <jsp:setProperty property="productName" name="mobiles" value="iphone 13"/>
        <jsp:setProperty property="price" name="mobiles" value="85000.00"/>
<a href="showbean.jsp">Access bean properties from another page</a><br>
<a href="forward.jsp">Use Forward action to go to Google</a><br>

<hr>

<jsp:text>
        <![CDATA[This is my content.<br/>This will show within a text action tag exactly as it has been entered]]>
</jsp:text>

</body>
</html>