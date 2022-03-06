<%@page import="model.Users"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%
List<Users> listusers=new ArrayList<>();
listusers=(List<Users>)request.getAttribute("users");
String totalprice=(String)request.getAttribute("totalprice");
String totalperson=(String)request.getAttribute("totalperson");
String flightid=(String)request.getAttribute("flightid");
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


	    <%
	    String Paymentmessage = ("<br>Please proceed with payment for "+totalperson+" tickets for flight id "+flightid+" totaling "+totalprice+ " euros.<br>");
	    out.println(Paymentmessage);
		String userid = String.valueOf((int)listusers.get(0).getId());
    	String formdata=("<input type=\"hidden\" name=\"userid\" value=\""+userid+"\"><input type=\"hidden\" name=\"totalperson\" value=\""+totalperson+"\"><input type=\"hidden\" name=\"flightid\" value=\""+flightid+"\"><button type=\"submit\" value=\"Pay\">Pay</button></form>");
    	%>
    	<form action="PaymentServlet" method="post">
    	<label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="John More Doe">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September">
    		<label for="expyear">Exp Year</label>
            <input type="text" id="expyear" name="expyear" placeholder="2023">
            <label for="cvv">CVV</label>
            <input type="text" id="cvv" name="cvv" placeholder="352">
    	<%
    	out.println(formdata);
    %>
    

</body>
</html>
