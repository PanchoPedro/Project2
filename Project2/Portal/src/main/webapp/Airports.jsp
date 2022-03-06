<%@page import="model.Airports"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%
List<Airports> listairports=new ArrayList<>();
listairports=(List<Airports>)request.getAttribute("listairports");
%> 
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

<h1>Fly Away - Airport Management</h1>

<div class="vertical-menu">
  <a href="AdminHome.jsp" class="active">Admin - Home</a>
  <a href="Airlines.jsp">Airline Management</a>
  <a href="Airports.jsp">Airport Management</a>
  <a href="Flights.jsp">Flight Management</a>	  
  <a href="logout.jsp">Logout</a>
</div>
<form action="AirportServlet" method="post"><input type="hidden" name="airaction" value="getairports"><button type="submit" value="Get Airports">Get Airports</button></form>
<form action="AirportServlet" method="post"><input type="hidden" name="airaction" value="addairports"><input type="text" id="airportname" name="airportname" placeholder="Zurich Airport (ZRH)"><button type="submit" value="Add Airport">Add Airport</button></form>

<table class="airport-table">
	<caption>Available Airports</caption>
	<thead>
	<tr>
		<th>Airport Id</th>
		<th>Airport</th>
	</tr>
	</thead>
	<tbody>
	    <%
	    if(listairports != null){
    	for (int i = 1; i <= listairports.size(); i++) {
    	out.println("<tr><td>"+listairports.get(i-1).getId()+"</td><td>"+listairports.get(i-1).getAirport()+"</td><td></tr>");
    
    	}
	    }
	    
    %>
    </tbody></table>

</body>
</html>
