<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

<%
     // for checking the session is available or not, if not available it will throw exception, "Session already invalidated."
      if (session!=null) {
        session.invalidate();
        response.sendRedirect("index.jsp");
      }
     %>
   
</body>
</html>
