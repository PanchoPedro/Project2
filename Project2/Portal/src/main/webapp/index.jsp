<%@page import="booking.db.FetchAirports"%>
<%@page import="model.Airports"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%
List<Airports> list;
list=FetchAirports.getAllairports();
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

div.content
{
    display: block;
    text-align: center;
}
</style>
</head>
<body>
<a href="adminlogin.jsp" style="float:right">Admin Login</a>
<h1>Fly Away - Booking Portal</h1>

<div class="vertical-menu">
  <a href="#" class="active">Home</a>
  <a href="faq.html">FAQ</a>
</div>
<BR>

<BR><BR><BR><BR>
<div class="content">
  <form action="HomePageServlet" method="post">
<BR>
   <label for="source">Flight:   Source</label>
    <select id="source" name="source">
    <%
    for (int i = 1; i <= list.size(); i++) {
    	out.println("<option value='"+list.get(i-1).getAirport()+"'>"+list.get(i-1).getAirport()+"</option>");
    }
    %>
    </select>
    
    <label for="destination">Destination</label>
    <select id="destination" name="destination">
    <%
    for (int j = 1; j <= list.size(); j++) {
    	out.println("<option value='"+list.get(j-1).getAirport()+"'>"+list.get(j-1).getAirport()+"</option>");
    }
    %>
    </select>
    <label for="fdate">Date</label>
    <input type="date" id="fdate" name="fdate">

    <label for="seats">Seats/Persons</label>
<input type="number" id="seats" name="seats" min="1" max="25">

    <input type="submit" value="Search Flight">
  </form>
</div>

</body>
</html>
