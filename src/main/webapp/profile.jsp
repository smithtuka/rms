<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elgordo
  Date: 6/16/20
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<html>
<head>
    <title>Profile</title>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="auth.js" />" type="text/javascript"></script>
    <link href="style.css" type="text/css" rel="stylesheet">
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
  <h3>Profile</h3>
</div>

<div>
    <fieldset>
            <input type="hidden" id="update_id" value=${sessionScope.user.userId} />
            <label><p class="text">UserEmail:</p> <input id="update_email" type="text" value=${sessionScope.user.email} /></label>
        <label><p class="text">UserName:</p> <input id="update_name" type="text" value=${sessionScope.user.username} /></label>
            <label><p class="text">New Password:</p> <input id="update_password" type="text" value=${sessionScope.user.password} /></label>
            <input id="update_prof" type="submit" value="Update Info" />
    </fieldset>
</div>

</body>
</html>
