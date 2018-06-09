<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
                        <li><a class="dropdown-item" href="/SpringMVCHibTemplate/displayCategory?id=2">Daily Life Products</a></li>
                        <li><a class="dropdown-item" href="/SpringMVCHibTemplate/displayCategory?id=3">Food</a></li>
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



${errorMsg}
<br>

 <a href="<spring:url value='/' />" >Go Home</a>

</body>
</html>