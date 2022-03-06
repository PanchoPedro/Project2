
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%
String totalperson=(String)request.getParameter("totalperson");
String totalprice=(String)(String)request.getParameter("totalprice");
String flightid=(String)(String)request.getParameter("flightid");
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


<div class="register-box">	
<div>
<h2>Register Here</h2>
</div>
	<form action="RegisterServlet" method="post">
		<%
		String loginform="<input type=\"hidden\" name=\"totalprice\" value=\""+totalprice+"\"><input type=\"hidden\" name=\"totalperson\" value=\""+totalperson+"\"><input type=\"hidden\" name=\"flightid\" value=\""+flightid+"\">";
		out.println(loginform);
		%> 
		<label><b>Enter your first name</b></label><br/> <input type="text" id="firstname" name="firstname" placeholder="Your name.." required="required"><br>
		<label><b>Enter your last name</b></label><br/> <input type="text" id="surname" name="surname" placeholder="Your last name.." required="required"><br>
		<label><b>Enter your email : </b></label><br/><input type="email" name="email" required="required"><br>
		<label><b>Enter your phone number :</b></label><br/><input type="tel" id="phone" name="phone" placeholder="format 0351911111111" pattern="[0]{1}[0-9]{12}" required="required"><br>
		<label><b>Enter your password : </b></label><br/><input type="password" name="password" required="required"><br>
		<label><b>Enter your of birth</b></label><br/><input type="date" id="dob" name="dob"><br>
		<button type="submit"><b>Register</b></button>
		<br>

	</form>
	
</div>
<br><br>
<div class="Login-box">	
<div>
<h2>Already a User? Login Here</h2>
<form action="LoginServlet" method="post">
<%
loginform="<input type=\"hidden\" name=\"totalprice\" value=\""+totalprice+"\"><input type=\"hidden\" name=\"totalperson\" value=\""+totalperson+"\"><input type=\"hidden\" name=\"flightid\" value=\""+flightid+"\">";
out.println(loginform);
%> 
<label><b>Enter your email : </b></label><br/><input type="email" name="email" required="required"><br>
<label><b>Enter your password : </b></label><br/><input type="password" name="password" required="required"><br>
<button type="submit" value="Loging"><b>Login</b></button></form>
</div>
<div>
				<%
					String errMsg = request.getParameter("error");
						if(errMsg != null){
				%>
				<span class='error'><%= errMsg %></span>
				<%} %>
</div>

    

</body>
</html>
