<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<%@ page import="com.java.bean.Customer" %>
<%@ page import="com.java.bean.*" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    
	<title>Display Product</title>
</head>
<body>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="<spring:url value='/' />" class="navbar-brand"><spring:message code="home"></spring:message></a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                 <li class="dropdown">
                    <a href="#" class="dropdown-toggle" role="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="category"></spring:message> <span class="caret"></span></a>
                    <ul class="dropdown-menu aria-labelledby="dropdownMenuButton"">
                        <li><a class="dropdown-item" href="/SpringMVCHibTemplate/displayCategory?id=1">Electonic Products</a></li>
                        <li><a class="dropdown-item" href="/SpringMVCHibTemplate/displayCategory?id=7">Daily Life Products</a></li>
                        <li><a class="dropdown-item" href="/SpringMVCHibTemplate/displayCategory?id=1">Food</a></li>
                    </ul>
                </li>
                <li><a href="add-flightII.jsp"><spring:message code="customerProfile"></spring:message></a></li>
                <li><a href="<spring:url value='/showCart' />"><spring:message code="shoppingcart"></spring:message></a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
            	<c:set var="val" value="${logintag}"/>
            	 <c:if test="${sessionScope.customer == null}">
                    <li>
                        <a href="<spring:url value='/log' />" >Log in</a>
                    </li>
                    <li>
                        <a href="<spring:url value='/upd' />" >Register</a>
                    </li>
                    <li>
                    	<a href="<%=request.getContextPath() %>?mylocale=en">English</a> <br>
                    </li>
                    <li>
                    	<a href="<%=request.getContextPath() %>?mylocale=zh">Chinese</a> <br>
                    </li>
                    
                </c:if>
               <c:if test="${sessionScope.customer != null}">
                    <li><a href="<spring:url value='/logout' />" >Logout</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>


		<% ShoppingCart shoppingCart = (ShoppingCart)request.getAttribute("shoppingCart"); %>
		
		<% Map<String, Integer> productMap = shoppingCart.getProductsInCart(); %>
		<% for (Map.Entry<String, Integer> item : productMap.entrySet()) {%>
		 			<br>
		 			<% String key = item.getKey();
				    Integer value = item.getValue(); %>
				    
            		<td><%="Product Name: "%></td>
            		<td><%=key%></td>
            		<br>
            		<td><%="Product Quantity: "%></td>
            		<td><%=value%></td>
            		<br>
            		<br>
       				<form action='removeProductFromCart'>
        				<input type='hidden' name='productName'  value="<%=key%>">
						<button type="submit" class="btn btn-primary">remove from Cart</button>
					</form> 		
          <% } %> 
          
          <%if(!productMap.isEmpty()) {%>
          <%="Total Price: "%>
          <%= shoppingCart.getTotalPrice() %>
          <br>
		  <br>
		  <form action='checkOut'>
        		<input type='hidden' name='totalPrice'  value="<%=shoppingCart.getTotalPrice()%>">
				<button type="submit" class="btn btn-primary">Check Out</button>
		  </form> 
          <% } else {%> 
          	<h3>Your Shopping Cart is Empty</h3>
		  <% }%>
		  <a href="<spring:url value='/' />" >Go Home</a>

</body>
</html>