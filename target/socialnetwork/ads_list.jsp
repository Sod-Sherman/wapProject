<%--
  Created by IntelliJ IDEA.
  User: 1246
  Date: 9/24/2019
  Time: 12:01 AM
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
                    <th scope="col">Id</th>
                    <th scope="col">Content</th>
                    <th scope="col">URL</th>
                    <th scope="col">imgURL</th>
                    <th scope="col">postedDate</th>
                    <th scope="col">location</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ad" items="${adsAll}">
                    <tr class="table-primary">
                        <td>${ad.id}</td>
                        <td>${ad.content}</td>
                        <td>${ad.url}</td>
                        <td>${ad.imgUrl}</td>
                        <td>${ad.postedDate}</td>
                        <td>${ad.location}</td>
                        <td><button class="btn btn-secondary my-2 my-sm-0" type="submit">Edit</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form action="/ads_view" method="post">
                <button type="submit" class="btn btn-primary">Create Add</button>
            </form>
        </main>
    </div>
</div>
<main>

</main>
</body>
</html>