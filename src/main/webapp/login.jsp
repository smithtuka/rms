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
    <title>Login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/auth.js"/>" type="text/javascript"></script>
    <link href="<c:url value="/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<div id="navbar">
    <ul>
        <div class="logo">
            <img src="resources/logo.png" />
        </div>
    </ul>
</div>

<div class="page-title">
    <h3>Login</h3>
</div>

<div>
    <fieldset>
        <label><p class="text">Email:</p> <input id="email" type="text" required="required" /></label>
        <label><p class="text">Username:</p> <input id="username" type="text" required="required" /></label>
        <label><p class="text">Password:</p> <input id="password" type="password" required="required" /></label>
        <span id="err-message" >Error: Input all required fields</span>
            <c:if test="${not empty requestScope.errorMessage}">
                <c:out value="${requestScope.errorMessage}" />
            </c:if>
        <input id="login-btn" type="submit" value="Submit" />
    </fieldset>
</div>

</body>
</html>
