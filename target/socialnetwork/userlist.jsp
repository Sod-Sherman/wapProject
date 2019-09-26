<%--
  Created by IntelliJ IDEA.
  User: sdblg
  Date: 9/26/2019
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<%@ include file="WEB-INF/fragment/header.jsp" %>
${statusMsg}

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${allUsers}">
            <tr class="table-primary">
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <c:if test="${!followHash[user.id]}">
                    <td><a class="btn btn-secondary my-2 my-sm-0" href="userlist?userIdToFollow=${user.id}">Follow</a></td>
                </c:if>
                <c:if test="${followHash[user.id]}">
                <td><a class="btn btn-secondary my-2 my-sm-0" href="#">Followed</a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

<%@include file="WEB-INF/fragment/footer.jsp" %>
</body>
</html>
