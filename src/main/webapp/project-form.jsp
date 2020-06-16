<%--
  Created by IntelliJ IDEA.
  User: smithtuka
  Date: 6/15/20
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Project Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/projects.js" />" type="text/javascript"></script>
    <link href="<c:url value="/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<ul id="navbar">

</ul>
<div class="container">
    <h1>Project Form</h1>
    <hr class="divider">
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
