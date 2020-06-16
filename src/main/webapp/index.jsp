<%--
  Created by IntelliJ IDEA.
  User: smithtuka
  Date: 6/13/20
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>rms</title>
    <link href="<c:url value="/style.css"/>" type="text/css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/action.js"/>" type="text/javascript"></script>
</head>
<body>
<ul id="navbar">

</ul>
<div class="container">
    <div id="requisitions">
        <h3>Manage Requisitions</h3>
        <a href=""> View Requisitions</a><br />
        <a href=""> Create Requisitions</a><br />
        <a href=""> Edit Requisitions</a><br />

    </div>

    <div id="projects">
        <h3>Manage Projects</h3>
        <a href=""> View Projects</a> <br />
        <a href=""> Create Projects</a> <br />
        <a href=""> Edit Projects</a> <br />
    </div >

</div>
</body>
</html>
