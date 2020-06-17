<%--
  Created by IntelliJ IDEA.
  User: smithtuka
  Date: 6/15/20
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<html>
<head>
    <title>Project Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="auth.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/projects.js" />" type="text/javascript"></script>
    <link href="<c:url value="/style.css"/>" type="text/css" rel="stylesheet">
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
    <h3>Project Form</h3>
</div>
<div class="container">
    <div>
        <%--        <label class="req-label" for="req-date">Required Date</label>--%>
        <%--        <input class="req-input" id="req-date" type="date">--%>
        <h3>Projects</h3>
        <hr class="divider">
        <div id="pdt-list">
            <form id="pjt-form">
                <div class="pjt-input">
                    <label class="pjt-label" for="projectName">Project Name</label>
                    <input class="pjt-input" id="projectName" type="text" value="" name="projectName">
                </div>

                <div class="pdt-input">
                    <label class="pjt-label" for="budget">Budget</label>
                    <input class="pjt-input" id="budget" type="number" value="" name="budget">
                </div>
                <div class="pdt-input">
                    <label class="pjt-label" for="supervisor">Supervisor</label>
                    <input class="pjt-input" id="supervisor" type="text" value="" name="supervisor">
                </div>
                <div class="pjt-input">
                    <label class="pjt-label" for="description">Description</label>
                    <input class="pjt-input" id="description" type="text" value="" name="description">
                </div>
                <div class="clear-box">
                    <button id="pjt-btn" class="pjt-btn">Add Project</button>
                </div>
            </form>
        </div>
        <div class="clear-box">
            <table>
                <tr>
                    <td>Name</td>
                    <td>Budget</td>
                    <td>Supervisor</td>
                    <td>Description</td>
                    <td>Action</td>
                </tr>
            </table>
            <button id="submit-btn" class="pjt-btn">Submit</button>
        </div>


    </div>
</div>

</body>
</html>
