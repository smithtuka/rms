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
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<html>
<head>
    <title>Projects</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="auth.js" />" type="text/javascript"></script>
    <script src="<c:url value="/action.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/projects.js"/>" type="text/javascript"></script>
    <link href="<c:url value="/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="resources/css/projects.css"/>" type="text/css" rel="stylesheet">
</head>
<body>

<div id="navbar">
    <ul>
        <div class="logo">
            <a href="${pageContext.request.contextPath}/index.jsp">
                <img src="resources/logo.png" />
            </a>
        </div>

        <div class="profile">
            <div class="inner-profile">
                <div class="inner-gangsta">
                    <a href="${pageContext.request.contextPath}/profile.jsp">
                        <img src="resources/male.png" />
                        <p class="name"> &nbsp; Hello,  ${sessionScope.user.username} &nbsp; </p>
                    </a></div>
            </div>
            <div class="inner-profile">
                <div class="inner-gangsta">
                    |
                    &nbsp; <a id="logout_btn">   Logout</a>
                </div>

            </div>

        </div>

    </ul>
</div>

<div class="page-title">
    <h3>Projects</h3>
</div>

<div class="container">
    <table id="req_table">
        <tr>
            <th>Id No.</th>
            <th>Project</th>
            <th>Budget</th>
            <th>Description</th>
            <th>Supervisor</th>
            <th>Action</th>
        </tr>
        <c:forEach var="project" items="${projectList}" >
            <tr>
                <td class="p_id">${project.id}</td>
                <td class="p_name">${project.projectName}</td>
                <td class="p_budget">${project.budget}</td>
                <td class="p_description">${project.description}</td>
                <td class="p_supervisor">${project.supervisor}</td>
                <td><button class="edit-pjt-btn">Edit </button><button class="del-pjt-btn">Delete</button></td>
            </tr>
        </c:forEach>
        <div id="msg"></div>
    </table>
</div>
</body>
</html>
