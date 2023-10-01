<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
<p>Bonjour
    <%
    String name = (String) request.getAttribute("name");
    out.println(name);
    %>
</p>
</body>
</html>