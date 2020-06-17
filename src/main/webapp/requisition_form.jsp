<%--
  Created by IntelliJ IDEA.
  User: Discus
  Date: 6/14/2020
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Requisition Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/action.js"/>" type="text/javascript"></script>
    <link href="<c:url value="/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<ul id="navbar">

</ul>
<div class="container">
    <h1>Requisition Form</h1>
    <hr class="divider">
    <div>
        <label class="req-label" for="req-date">Required Date</label>
        <input class="req-input" id="req-date" type="date">

        <label class="req-label" for="project">Choose Project</label>
        <select class="req-input" name="project" id="project">
            <c:forEach items="${requisitions}" var="requisition">
                <option value="${requisition.projectId}">${projects.get(requisition.projectId).projectName}</option>
            </c:forEach>
        </select>

        <h3>Products</h3>
        <hr class="divider">
        <div id="pdt-list">
            <form id="pdt-form">
                <div class="pdt-input">
                    <label class="req-label" for="name">Product Name</label>
                    <input class="req-input" id="name" type="text" value="" name="name">
                </div>

                <div class="pdt-input">
                    <label class="req-label" for="quantity">Quantity</label>
                    <input class="req-input" id="quantity" type="number" value="" name="quantity">
                </div>
                <div class="pdt-input">
                    <label class="req-label" for="price">Price</label>
                    <input class="req-input" id="price" type="number" value="" name="price">
                </div>
                <div class="clear-box">
                    <button id="pdt-btn" class="req-btn">Add product</button>
                    <span id="total-label">Total:   <span id="total">0</span></span>
                </div>
            </form>
        </div>

        <table id="req_table">
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Sub Total</th>
                <th></th>
            </tr>
        </table>
        <div class="clear-box">
            <button id="submit-btn" class="req-btn">Submit</button>
        </div>
    </div>
</div>

</body>
</html>
