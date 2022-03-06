<%@page import="model.Airlines"%>
<%@page import="model.Airports"%>
<%@page import="model.Flights"%>
<%@page import="booking.db.FetchAirports"%>
<%@page import="booking.db.FetchAirlines"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%
List<Flights> listflights=new ArrayList<>();
listflights=(List<Flights>)request.getAttribute("listflights");
%> 
<%
List<Airports> listairports;
listairports=FetchAirports.getAllairports();
%> 
<%
List<Airlines> listairlines;
listairlines=FetchAirlines.getAllairlines();
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

<h1>Fly Away - Flights Management</h1>

<div class="vertical-menu">
  <a href="AdminHome.jsp" class="active">Admin - Home</a>
  <a href="Airlines.jsp">Airline Management</a>
  <a href="Airports.jsp">Airport Management</a>
  <a href="Flights.jsp">Flight Management</a>	  
  <a href="logout.jsp">Logout</a>
</div>
<form action="FlightsServlet" method="post"><input type="hidden" name="airaction" value="getflights"><button type="submit" value="Get Flights">Get Flights</button></form>
<form action="FlightsServlet" method="post"><input type="hidden" name="airaction" value="addflights">
<BR>
   <label for="source">Flight:   Source</label>
    <select id="source" name="source">
    <%
    for (int i = 1; i <= listairports.size(); i++) {
    	out.println("<option value='"+listairports.get(i-1).getAirport()+"'>"+listairports.get(i-1).getAirport()+"</option>");
    }
    %>
    </select>
    
    <label for="destination">Destination</label>
    <select id="destination" name="destination">
    <%
    for (int j = 1; j <= listairports.size(); j++) {
    	out.println("<option value='"+listairports.get(j-1).getAirport()+"'>"+listairports.get(j-1).getAirport()+"</option>");
    }
    %>
    </select>
    <select id="airline" name="airline">
    <%
    for (int j = 1; j <= listairlines.size(); j++) {
    	out.println("<option value='"+listairlines.get(j-1).getAirline()+"'>"+listairlines.get(j-1).getAirline()+"</option>");
    }
    %>
    </select>
    <label for="price">Price</label>
<input type="number" id="price" name="price" min="1" max="5000">
    <label for="fdate">Date</label>
    <input type="datetime-local" id="fdate" name="fdate">

    <label for="seats">Capacity</label>
<input type="number" id="seats" name="seats" min="1" max="500">

    <button type="submit" value="Add Flight">Add Flight</button>
  </form>
<table class="airline-table">
	<caption>Available Flights</caption>
	<thead>
	<tr>
		<th>Flight Id</th>
		<th>Flight Source</th>
		<th>Flight Destination</th>
		<th>Flight Airline</th>
		<th>Flight Price</th>
		<th>Flight Date-Time</th>
		<th>Flight Capacity</th>
	</tr>
	</thead>
	<tbody>
	    <%
	    if(listflights != null){
    	for (int i = 1; i <= listflights.size(); i++) {
    	out.println("<tr><td>"+listflights.get(i-1).getId()+"</td><td>"+listflights.get(i-1).getSource()+
    			"</td><td>"+listflights.get(i-1).getDestination()+"</td><td>"+listflights.get(i-1).getAirline()+
    			"</td><td>"+listflights.get(i-1).getPrice()+"</td><td>"+listflights.get(i-1).getDate_time()+
    			"</td><td>"+listflights.get(i-1).getSeats()+"</td><td></tr>");
    
    	}
	    }
	    
    %>
    </tbody></table>

</body>
</html>
