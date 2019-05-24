<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table {  
    color: #333;
    font-family: Helvetica, Arial, sans-serif;
    width: 640px; 
    border-collapse: 
    collapse; border-spacing: 0; 
}

td, th {  
    border: 1px solid transparent; /* No more visible border */
    height: 30px; 
    transition: all 0.3s;  /* Simple transition for hover effect */
}

th {  
    background: #0000FF;  /* Darken header a bit */
    font-weight: bold;
}

td {  
    background: #FAFAFA;
    text-align: center;
}

/* Cells in even rows (2,4,6...) are one color */        
tr:nth-child(even) td { background: #F1F1F1; }   

/* Cells in odd rows (1,3,5...) are another (excludes header cells)  */        
tr:nth-child(odd) td { background: #FEFEFE; }  

tr td:hover { background: #666; color: #FFF; }  
/* Hover cell effect! */
</style>
<body>
<br><br><br><br><br><br>
<center>
<table>  
<tr>  
    <th>Patient Name</th>
    <th>Doctor Name</th>
    <th>Appointment Date</th>
    <th>Appointment Time</th>
    <th>Transaction id</th>
    <th>Status</th>
</tr>  
<tr>  
    <td>${user_name}</td>
    <td>${doc_name}</td>
    <td>${app_date}</td>
    <td>${app_time}</td>
    <td><%
		out.print(request.getParameter("trn_id"));
		%></td>
    <td><%
		out.print(request.getParameter("trn_status"));
		%></td>
</tr>  

</table> 
</center> 
</body>
</html>