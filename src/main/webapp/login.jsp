<%--
  Created by IntelliJ IDEA.
  User: elgordo
  Date: 6/15/20
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/auth.js"/>" type="text/javascript"></script>
    <link href="<c:url value="/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<form>
    Username: <input id="username" type="text" name="username"  /> <br>
    Password: <input id="password" type="password" name="password" /> <br>
    <input id="login-btn" type="submit" value="Submit" />
</form>
</body>
</html>
