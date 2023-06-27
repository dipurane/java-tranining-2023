<%@page import="com.encora.test.dto.ProductDTO"%>
<%@page import="com.encora.test.service.ProductServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.encora.test.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List Page</title>
<script type="text/javascript">
function addToCart(id){
	//alert("Add to cart Link was clicked for product "+id);
	var quantity = document.getElementById(id).value;
//	alert("quantiy purchased " + quantity);
	
	var URL = "cart.jsp?product_id="+id+"&quantity="+quantity;
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     document.getElementById("result").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", URL, true);
	  xhttp.send();
	
}

</script>
</head>
<body bgcolor="#4ea2cf">
<br><br><br><br><br><br>
<center>
<%
 	ProductService productService = new ProductServiceImpl();
	List<ProductDTO> productList =  productService.getProductList();
	
%>
<table border="2">
	<tr><td>Product Name</td><td> Description</td><td>Unit Price</td><td>Quanity</td><td>Action</td></tr>
	<%
		for(ProductDTO dto : productList){
	%>
	<tr><td><%= dto.getProductName() %></td><td><%= dto.getProductDescription() %></td><td><%=dto.getUnitPrice() %></td><td><input type="text" id="<%=dto.getProductId()%>"></td><td><a href="#" onclick="addToCart(<%=dto.getProductId()%>);">Add To Cart</a></td></tr>
	
	<%
		}
	%>
	<tr><td colspan="5" align="right"><a href="checkout.jsp">Checkout Now</a></td></tr>
</table>
<div id="result">

</div>
</center>

</body>
</html>

