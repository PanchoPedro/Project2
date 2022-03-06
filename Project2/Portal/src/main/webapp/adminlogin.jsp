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
<h1>Fly Away - Admin Login</h1>

<div class="vertical-menu">
  <a href="index.jsp" class="active">Home</a>
  <a href="faq.html">FAQ</a>
</div>

<form action="AdminLoginServlet" method="post">
<label><b>Enter admin email : </b></label><br/><input type="email" name="email" required="required"><br>
<label><b>Enter admin password : </b></label><br/><input type="password" name="password" required="required"><br>
<button type="submit" value="Loging"><b>Login</b></button></form>
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
