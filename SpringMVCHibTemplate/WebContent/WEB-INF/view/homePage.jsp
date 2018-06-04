<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<%@ page import="com.java.bean.Customer" %>
<%@ page import="java.util.*" %>
 <title>Shopping Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                    <a href="#" class="dropdown-toggle" role="button"><spring:message code="category"></spring:message> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Electonic Products</a></li>
                        <li><a href="#">Daily Life Products</a></li>
                        <li><a href="#">Food</a></li>
                    </ul>
                </li>
                <li><a href="add-flightII.jsp"><spring:message code="customerProfile"></spring:message></a></li>
                <li><a href="addAirPlane.jsp"><spring:message code="shoppingcart"></spring:message></a></li>
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
                    
                    <%-- <li>
                        <a href="<spring:url value='/reg' />" >Register</a>
                    </li> --%>
                </c:if>
               <c:if test="${sessionScope.customer != null}">
                    <li><a href="<spring:url value='/logout' />" >Logout</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

		<h4><spring:message code="homemessage"></spring:message></h4> <br>
	

</body>
</html>