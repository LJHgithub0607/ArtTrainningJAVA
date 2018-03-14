<%@page import="com.javaweb.domain.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="query.do" method="post">
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
 		    <td><input type="submit" value="query"/></td>
 		    <td><a href="update.jsp">Add New Customer</a></td>
 		</tr>
 	</table>
 	<br><br>
 	<%
 	List<Customer> customers=(List<Customer>)request.getAttribute("customers");
 	if(customers!=null&&customers.size()>0){
 	%>
 	<hr>
 	<br><br>
 		<table border="1" cellpadding="10" cellsapcing="10">
 		<tr>
 			<th>ID</th>
 			<th>CustomerName</th>
 			<th>Address</th>
 			<th>Phone</th>
 			<th>UPDATE\DELECT</th>
 		</tr>
 		<%
 		for(Customer customer:customers){
 		%>
 		<tr>
 		 	<td><%=customer.getId() %></td>
 			<td><%=customer.getName() %></td>
 			<td><%=customer.getAddress() %></td>
 			<td><%=customer.getPhone() %></td>
 			<td>
 				<a href="edit.do?id=<%=customer.getId()%>">UPDATE</a>
 				<a href="delete.do?id=<%= customer.getId()%>">DELETE</a>
 			</td>
 		</tr>
 		<%
 		}
 	}
 		%>
 			<tr>
 				
 			</tr>
 		</table>
 	</form>
 	
</body>
</html>