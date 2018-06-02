<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Add Customer:	
			<form:form action='addCustomer' method="post" modelAttribute="Customer">
			UserName :<form:input path="userName" />
			<form:errors path="userName"/><br>
			PassWord :<form:input path="passWord" />
			<form:errors path="passWord"/><br>
			email :<form:input path="email" />
			<form:errors path="email"/><br>
			Street :<form:input path="shippingAddress.street" />
			<form:errors path="shippingAddress.street"/><br>
			City :<form:input path="shippingAddress.city" />
			<form:errors path="shippingAddress.city"/><br>
			State :<form:input path="shippingAddress.state" />
			<form:errors path="shippingAddress.state"/><br>
			Zipcode :<form:input path="shippingAddress.zipcode" />
			<form:errors path="shippingAddress.zipcode"/><br>

			<input type="submit" value="Add Customer">
		</form:form>
	
</body>
</html>