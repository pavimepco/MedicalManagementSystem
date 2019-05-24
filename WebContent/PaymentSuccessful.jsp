<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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


.container-box {
	width: 300px;
	margin: 0 auto;
	margin-top: 20vh;
	box-shadow: -6px 5px 2px 1px rgba( 0, 0, 0, 0.2 );
    padding: 10px 20px;
    transform: scale(1.2);
}

.head-reci {
	text-align: center;
	margin-bottom: 15px;
}

.btn-center {
	margin: 0 auto;
	margin-top: 70px;
	position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
}

</style>
<body>
<br><br>
<h1 align="center">Thank you!</h1>
<h2 align="center">Your Appointment is Booked!</h2>

<div class="container">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8 col-sm-12">
			<div class="container-box">
				<div class='head-reci'><h5>Consultation Details</h5></div>
				<div class='patientName'>Patient Name: <b>${user_name}</b></div>
				<div class='doctorName'>Doctor Name: <b>${dname}</b></div>
				<div class='appointmentDate'>Appointment Date: <b>${date}</b></div>
				<div class='appointmentTime'>Appointment Time: <b>${time}</b></div>
				<div class='tId'>Transaction Id: <b><% out.print(request.getParameter("trn_id")); %></b></div>
				<div class='tStatus'>Transaction Status: <b><% out.print(request.getParameter("trn_status")); %></b></div>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>
	<a class='btn btn-success btn-center' href ="index.jsp">Home</a>
</div>


<!--  
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
    <td>${dname}</td>
    <td>${date}</td>
    <td>${time}</td>
    <td><%
		out.print(request.getParameter("trn_id"));
		%></td>
    <td><%
		out.print(request.getParameter("trn_status"));
		%></td>
</tr>  

</table> 
</center>  --> 
</body>
</html>