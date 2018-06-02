<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


		<h2>Submitted File</h2>
			<table>
    			<tr>
        			<td>OriginalFileName:</td>
        			<td>${file.originalFilename}</td>
        			<td>${file.size}</td>
    			</tr>
    			<tr>
        			<td>Type:</td>
        			<td>${file.contentType}</td>
    			</tr>
			</table>

</body>
</html>