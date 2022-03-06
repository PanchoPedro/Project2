<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.vertical-menu {
  width: 200px;
}

.vertical-menu a {
  background-color: #eee;
  color: black;
  display: block;
  padding: 12px;
  text-decoration: none;
}

.vertical-menu a:hover {
  background-color: #ccc;
}

.vertical-menu a.active {
  background-color: #04AA6D;
  color: white;
}

.flight-table {
  margin-left: auto;
  margin-right: auto;
}

div.content
{
    display: block;
    text-align: center;
}
</style>
</head>
<body>
<%if (session.getAttribute("email")==null){
	response.sendRedirect("index.jsp");
}
%>
<a href="Changepass.jsp" style="float:right">Change Password</a>
<h1>Fly Away - Admin Home</h1>

<div class="vertical-menu">
  <a href="AdminHome.jsp" class="active">Admin - Home</a>
  <a href="Airlines.jsp">Airline Management</a>
  <a href="Airports.jsp">Airport Management</a>
  <a href="Flights.jsp">Flight Management</a>	  
  <a href="logout.jsp">Logout</a>
</div>

   
</body>
</html>
