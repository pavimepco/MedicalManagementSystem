<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Symptoms</title>
</head>
<body>

	<form method="post" action="DetailsServlet">
		<table  class="table table-hover" style="width:80%" align="center">
			<thead><tr>
				<th>Symptom</th>
				<th>Department</th>
				<th>Doctor</th></tr>
			</thead>
			<c:forEach var="s" items="${SY}">
				<tr>
					<td>${s.sname}</td>
					<td>${s.dname}<input type="hidden" name="name"  value=${s.ename }></input></td>
					
					<td>${s.ename}</td>	
					<td><button type="submit" class="btn btn-success" value=${s.sname} style='font-size:20px'>Book <i class='fas fa-bus'></i></button></td>																		
				</tr>				
				<tr>
				
				</tr>
			</c:forEach>
		</table>
	</form>


</body>
</html>