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
 <form action="ChangePasswordServlet" method="post">
   Admin Email Id : <input name="email" value="<%= session.getAttribute("email")%>" readonly="readonly">
    <br>
    <br>
	Set new Password : <input type="password" name="password" required="required">
	<br>
	<br>
	<button type="submit">Change Password</button>
    </form>
    <br>
    <br>
  
    <a href="AdminHome.jsp" style="text-decoration:none;">GoTo HomePage</a>

</body>
</html>
