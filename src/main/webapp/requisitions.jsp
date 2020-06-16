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
</head>
<body>
<ul id="navbar">

</ul>


<div class="container">
    <div>
        <a class="req-btn" href="${pageContext.request.contextPath}/requisition_form.jsp">Create Requisition</a>
    </div>

    <h1>My Requisitions</h1>
    <hr class="divider">
<%--    <button> Add a requisition</button>--%>
    <table id="req_table">
        <tr>
            <th>Id No.</th>
            <th>Date of Request</th>
            <th>Request Deadline</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${requisitions}" var="requisition">
            <tr>
                <td>${requisition.id}</td>
                <td><fmt:formatDate type="date" value="${requisition.creationDate}" /></td>
                <td><fmt:formatDate type="date" value="${requisition.requiredDate}" /></td>
                <td>${requisition.status}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
