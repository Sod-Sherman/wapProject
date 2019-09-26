<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sdblg
  Date: 9/21/2019
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Social Network</title>
    <link href="static/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="css/animate.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>

    <script src="static/feather.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<nav class="navbar bg-primary">
    <a class="nav-link" href="/wapProject" style="color: white">Home</a>
<%--    <a class="nav-link" href="#">Features</a>--%>
<%--    <a class="nav-link" href="#">Pricing</a>--%>
    <c:if test="${loggedInUser != null}">
        <a href="profile" style="color: white"> ${loggedInUser.fullName}</a>
        <a href="#" id="logout" style="color: white">Log Out</a>
    </c:if>

</nav>



