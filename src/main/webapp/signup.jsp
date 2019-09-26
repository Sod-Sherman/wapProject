<%--
  Created by IntelliJ IDEA.
  User: sdblg
  Date: 9/21/2019
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="WEB-INF/fragment/header.jsp"%>

<p></p>

<div class="container">
<form action="user" method="POST">
    <h2>Signup From</h2>
    <div class="form-group">
        <label for="InputFirstName1">First Name</label>
        <input type="text" name="firstName" class="form-control" id="InputFirstName1" aria-describedby="firstName" placeholder="First name">
        <small id="firstName" class="form-text text-muted"></small>
    </div>

    <div class="form-group">
        <label for="InputLastName1">Last Name</label>
        <input type="text" name="lastName" class="form-control" id="InputLastName1" aria-describedby="lastName" placeholder="Last name">
        <small id="lastName" class="form-text text-muted"></small>
    </div>

    <div class="form-group">
        <label for="InputUsername1">Username</label>
        <input type="text" name="username" class="form-control" id="InputUsername1" aria-describedby="username" placeholder="Username">
        <small id="username" class="form-text text-muted"></small>
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>


<%@include file="WEB-INF/fragment/footer.jsp"%>
</body>
</html>
