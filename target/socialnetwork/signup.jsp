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
<form>
    <div class="form-group">
        <label for="InputFirstname1">First Name</label>
        <input type="text" class="form-control" id="InputFirstname1" aria-describedby="firstname" placeholder="First name">
        <small id="firstname" class="form-text text-muted"></small>
    </div>

    <div class="form-group">
        <label for="InputLastname1">Last Name</label>
        <input type="text" class="form-control" id="InputLastname1" aria-describedby="lastname" placeholder="Last name">
        <small id="lastname" class="form-text text-muted"></small>
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>



<%@include file="WEB-INF/fragment/footer.jsp"%>
</body>
</html>
