<%@page import="model.Airlines"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%
List<Airlines> listairlines=new ArrayList<>();
listairlines=(List<Airlines>)request.getAttribute("listairlines");
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

<h1>Fly Away - Airline Management</h1>

<div class="vertical-menu">
  <a href="AdminHome.jsp" class="active">Admin - Home</a>
  <a href="Airlines.jsp">Airline Management</a>
  <a href="Airports.jsp">Airport Management</a>
  <a href="Flights.jsp">Flight Management</a>	  
  <a href="logout.jsp">Logout</a>
</div>
<form action="AirlineServlet" method="post"><input type="hidden" name="airaction" value="getairlines"><button type="submit" value="Get Airlines">Get Airlines</button></form>
<form action="AirlineServlet" method="post"><input type="hidden" name="airaction" value="addairlines"><input type="text" id="airlinename" name="airlinename" placeholder="Easy Jet"><button type="submit" value="Add Airline">Add Airline</button></form>

<table class="airline-table">
	<caption>Available Airlines</caption>
	<thead>
	<tr>
		<th>Airline Id</th>
		<th>Airline</th>
	</tr>
	</thead>
	<tbody>
	    <%
	    if(listairlines != null){
    	for (int i = 1; i <= listairlines.size(); i++) {
    	out.println("<tr><td>"+listairlines.get(i-1).getId()+"</td><td>"+listairlines.get(i-1).getAirline()+"</td><td></tr>");
    
    	}
	    }
	    
    %>
    </tbody></table>

</body>
</html>
