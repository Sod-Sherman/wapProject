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
<head>
    <style>
        a {
            color: #0254EB
        }
        a:visited {
            color: #0254EB
        }
        a.morelink {
            text-decoration:none;
            outline: none;
        }
        .morecontent span {
            display: none;
        }
        .comment {
            /*width: 400px;*/
            /*background-color: #f0f0f0;*/
            /*margin: 10px;*/
        }
    </style>
</head>
<body>
<%@ include file="WEB-INF/fragment/header.jsp" %>
<div class="container">
<div>
    <a href="post.jsp">Create Post</a>
</div>
    <c:forEach var="post" items="${userPosts}">
        <div class="card mb-3" style="max-width: 540px;">
            <div class="row no-gutters">
                <c:if test="${!post.imgUrl.isEmpty()}">
                    <div class="col-md-4">
                        <img src="${post.imgUrl}" class="card-img" alt="...">
                    </div>
                </c:if>
                <div class="col-md-8">
                    <div class="card-body">
                        <p class="comment more card-text">${post.content}</p>
                        <p class="card-text"><small class="text-muted">Posted:
                            <a href="profile.jsp"> <span id="fullNameOfPoster">${post.user.fullName}</span></a>
                                ${post.postedDate} <a id="follow" href="#"> Follow</a></small>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


<%@include file="WEB-INF/fragment/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/timeline.js" type="text/javascript"></script>
<script src="js/follow.js" type="text/javascript"></script>

</body>
</html>

