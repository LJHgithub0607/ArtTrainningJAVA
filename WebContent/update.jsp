<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update.do" method="post">
 	<table>
 		<tr>
 		    <td>CustomerName:</td>
 		    <td><input type="text" name="name"/></td>
 		</tr>
 		 <tr>
 		    <td>Address:</td>
 		    <td><input type="text" name="address"/></td>
 		</tr>
 		 <tr>
 		    <td>Phone:</td>
 		    <td><input type="text" name="phone"/></td>
 		</tr>
 		 <tr>
 		    <td><input type="submit" value="submit"/></td>
 		</tr>
 	</table>
</body>
</html>