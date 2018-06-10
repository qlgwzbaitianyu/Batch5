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
    
    
	<title>Home Page</title>
</head>
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
                        <li><a class="dropdown-item" href="/SpringMVCHibTemplate/displayCategory?id=8">Food</a></li>
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


		<h4><spring:message code="homemessage"></spring:message></h4> <br>
		<% List<Product> productList= (List<Product>)request.getAttribute("productList"); %>
		<% Long productCount = (Long)request.getAttribute("productCount"); %>
		<%if(productList.size() == 0) { %>
		<% }else %>
		<% { %>
			<br>
			<% for(int i = 0; i < productList.size(); i+=1) { %>
        <tr>
            <%="Product Name: " + productList.get(i).getName()%></a>
            <br>
            <td><%="Product Price: "%></td>
            <td><%=productList.get(i).getPrice()%></td>
            <br>
            <td><%="Product Description: "%></td>
            <td><%=productList.get(i).getDescription()%></td>
            <br>
            <td><%="Product Category: "%></td>
            <td><%=productList.get(i).getCategory().getName()%></td>
            <br>
            
            <form action='displayProduct'>
        		<input type='hidden' name='productId'  value="<%=productList.get(i).getId()%>">  <br>
				<button type="submit" class="btn btn-primary">show detail</button>
			</form>
        </tr>
        <br>
        <br>
    <% } %>
			
		
		<% } %>
		
		<img SRC="https://upload.wikimedia.org/wikipedia/commons/b/b7/Lenovo_G500s_laptop-2903.jpg" width="100" height="100">
		 
		  <ul class="pagination"> 
		  <% for(int i = 0; i < (productCount/3); i+=1) { %>
		 		<li><a href="/SpringMVCHibTemplate/?first=<%=i*3 %>&max=3"><%=i + 1 %></a></li>
		 		<%System.out.println("in home page: " + i + " productsize : " + productList.size()); %>
		  <% } %>
		   <% if(productCount % 3 != 0) {%>
		   		<li><a href="/SpringMVCHibTemplate/?first=<%=(productCount/3)*3 %>&max=3"><%=(productCount/3) + 1 %></a></li>
		   <% } %>
		  <ul>
</body>
</html>