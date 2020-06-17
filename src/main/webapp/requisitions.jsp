<%--
  Created by IntelliJ IDEA.
  User: Discus
  Date: 6/13/2020
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>My Requisitions</title>
    <link href="style.css" type="text/css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/action.js"/>" type="text/javascript"></script>
</head>
<body>
<ul id="navbar">

</ul>


<div class="container">
    <div>
        <a class="req-btn" href="${pageContext.request.contextPath}/requisition-form">Create Requisition</a>
    </div>

    <h1>My Requisitions</h1>
    <hr class="divider">
<%--    <button> Add a requisition</button>--%>
    <table id="req_table">
        <tr>
            <th>Id No.</th>
            <th>Project Name</th>
            <th>Date of Request</th>
            <th>Request Deadline</th>
            <th>Proposed Budget (UDS$)</th>
            <th>Status</th>
            <th>  </th>
        </tr>
        <c:forEach items="${requisitions}" var="requisition">
            <tr>
                <td>${requisition.id}</td>
                <td>${projects.get(requisition.projectId).projectName}</td>
                <td><fmt:formatDate type="date" value="${requisition.creationDate}" /></td>
                <td><fmt:formatDate type="date" value="${requisition.requiredDate}" /></td>
                <td>${requisition.total}</td>
                <td>${requisition.status}</td>
                <td><button class="del-btn" id="btn_${requisition.id}">Delete</button></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
