<%--
  Created by IntelliJ IDEA.
  User: 1246
  Date: 9/24/2019
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%@ include file="WEB-INF/fragment/admin_header.jsp"%>
<body>

<%@ include file="WEB-INF/fragment/admin_header_menu.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@ include file="WEB-INF/fragment/admin-side-panel.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">User name</th>
                    <th scope="col">Post Content</th>
                    <th scope="col">Posted Date</th>
                    <th scope="col">Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${usersAll}">
                    <tr class="table-primary">
                        <td>${user.id}</td>
                        <td>${user.fullName}</td>
                        <td>${user.active}</td>
                        <td><a class="btn btn-secondary my-2 my-sm-0" href="user_ban?user_name=${user.username}">Ban/Revoke</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
</div>
<main>

</main>
</body>
</html>