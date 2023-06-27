<%@page import="com.encora.test.dto.ShoppingDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	List<ShoppingDTO> cartList = (List<ShoppingDTO>) session.getAttribute("shopping-cart");
%>
<center>
Your puchase list

<table>
<%
  for(ShoppingDTO dto : cartList){
%>
	<tr><td><%=dto.getProductId() %></td><td><%=dto.getQuantity() %></td></tr>	
<%} %>
</table>
</center>
</body>
</html>