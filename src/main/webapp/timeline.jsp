<%--
  Created by IntelliJ IDEA.
  User: sdblg
  Date: 9/22/2019
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%@ include file="WEB-INF/fragment/header.jsp" %>
<div class="container">
<%--    <jsp:useBean id="userPosts" scope="request" type="java.util.List"/>--%>
    <c:forEach var="post" items="${userPosts}">
        <div class="card mb-3" style="max-width: 540px;">
            <div class="row no-gutters">
                <c:if test="${post.imgUrl != null}">
                    <div class="col-md-4">
                        <img src="${post.imgUrl}" class="card-img" alt="...">
                    </div>
                </c:if>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">${post.content}</p>
                        <p class="card-text"><small class="text-muted">Posted: ${post.postedDate}</small></p>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


<%@include file="WEB-INF/fragment/footer.jsp" %>
</body>
</html>

