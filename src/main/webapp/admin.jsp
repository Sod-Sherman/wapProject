<%--
  Created by IntelliJ IDEA.
  User: 1246
  Date: 9/22/2019
  Time: 5:44 PM
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
            <header>Usage Report
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#post">Post</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#user">User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " data-toggle="tab" href="#advertisement">Advertisement</a>
                </li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade show active" id="post">
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
                        <c:forEach var="post" items="${postsAll}">
                            <tr class="table-primary">
                                <td>${post.user.username}</td>
                                <td>${post.content}</td>
                                <td>${post.postedDate}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="user">
                  <div>
                      <p>
                          table${usersAll}
                      </p>
                  </div>
                </div>
                <div class="tab-pane fade" id="advertisement">
                    <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork.</p>
                </div>
            </div>
            </header>
        </main>
    </div>
</div>
<main>

</main>
</body>
</html>
