<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
</head>
<body>
		Hello <br>
		${loginMsg}
		<br>
		
	<%-- 	<form action='login.do'>
			<input type='text' name='userName' placeholder='Enter Username'><br>
			<input type='password' name='passWord' placeholder='Enter Password'><br>
			<input type='submit' value='Login'>
		</form> --%>
	
	<br>
	
	<form:form action='login.do' method="post" modelAttribute="Customer">
			UserName :<form:input path="userName" />
			<form:errors path="userName"/><br>
			PassWord :<form:input path="passWord" />
			<form:errors path="passWord"/><br>

			<input type="submit" value="Login">
	</form:form>
	
	

</body>
</html>