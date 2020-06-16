<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: smithtuka
  Date: 6/16/20
  Time: 00:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projects</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/action.js"/>" type="text/javascript"></script>
    <link href="<c:url value="/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<hr class="divider">
<%--    <button> Add a requisition</button>--%>
<table id="req_table">
    <tr>
        <th>Id No.</th>
        <th>Date of Request</th>
        <th>Request Deadline</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td>${project.id}</td>
            <td>${project.name}</td>
            <td>${project.budget}</td>
            <td>${project.description}</td>
            <td>${project.supervisor}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
