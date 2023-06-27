<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.encora.test.dto.ShoppingDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
		String id = request.getParameter("product_id");
		String quantity = request.getParameter("quantity");
        System.out.println("User have added product "+ id );
        System.out.println("User have added quanity "+ quantity );
        
        ShoppingDTO dto = new ShoppingDTO();
        dto.setProductId(Integer.parseInt(id));
        dto.setQuantity(Integer.parseInt(quantity));
        
        List<ShoppingDTO> cartList = (List<ShoppingDTO>)session.getAttribute("shopping-cart");
        if(cartList==null){
        	cartList = new ArrayList<ShoppingDTO>();
        	cartList.add(dto);
        }else{
        	cartList.add(dto);
        }
        session.setAttribute("shopping-cart", cartList);
%>
<h4 color="green"> Item <%=dto.getProductId()%> added to cart Succesfully</h4>