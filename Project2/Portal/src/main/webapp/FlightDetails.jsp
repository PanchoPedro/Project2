<%@page import="model.Flights"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%
List<Flights> listflights=new ArrayList<>();
listflights=(List<Flights>)request.getAttribute("flights");
int tickets=Integer.parseInt((String)request.getAttribute("totalPerson"));
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
<h1>Fly Away - Booking Portal</h1>

<div class="vertical-menu">
  <a href="index.jsp" class="active">Home</a>
  <a href="faq.html">FAQ</a>
</div>


<table class="flight-table">
	<caption>Available Flights</caption>
	<thead>
	<tr>
		<th>Flight Id</th>
		<th>Flight Source</th>
		<th>Flight Destination</th>
		<th>Airline</th>
		<th>Price (Euros)</th>
		<th>Departure</th>
		<th>Plane Capacity</th>
		<th>Current available seats</th>
		<th>Total Price (Euros)</th>
		<th>Commit to buy</th>
	</tr>
	</thead>
	<tbody>
	    <%
	    int freeseats;
	    String totalprice;
	    String flightid;
	    String buy;
	    String totalperson=String.valueOf(tickets);
    for (int i = 1; i <= listflights.size(); i++) {
    	freeseats=listflights.get(i-1).getSeats()-listflights.get(i-1).getTakenseats();
    	buy="No more seats";
    	totalprice=String.valueOf((int)listflights.get(i-1).getPrice()*tickets);
    	flightid=String.valueOf(listflights.get(i-1).getId());
    	//if(freeseats>=tickets){buy="<a href=\"register.jsp\">BUY</a>"; }
    	if(freeseats>=tickets){buy="<form action=\"register.jsp\"><input type=\"hidden\" name=\"totalprice\" value=\""+totalprice+"\"><input type=\"hidden\" name=\"totalperson\" value=\""+totalperson+"\"><input type=\"hidden\" name=\"flightid\" value=\""+flightid+"\"><button type=\"submit\" value=\"Buy\">BUY</button></form>";}
    	out.println("<tr><td>"+flightid+"</td><td>"+listflights.get(i-1).getSource()+"</td><td>"
    			+listflights.get(i-1).getDestination()+"</td><td>"+listflights.get(i-1).getAirline()+"</td><td>"
    			+listflights.get(i-1).getPrice()+"</td><td>"+listflights.get(i-1).getDate_time()+"</td><td>"
    			+listflights.get(i-1).getSeats()+"</td><td>"+freeseats+"</td><td>"+totalprice+"</td><td>"+buy+"</td><td></tr>");
    
    }
	if(listflights.size()<1){
		out.println("</tbody></table><br><h1 style=\"text-align:center\">No flights available for this query</h1><br>");
	}
	else{
		out.println("</tbody></table>");
	}
    %>
    

</body>
</html>
