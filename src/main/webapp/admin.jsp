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
                    <%@ include file="post_list.jsp"%>
                </div>
                <div class="tab-pane fade" id="user">
                  <div>
                      <<%@ include file="user_list.jsp"%>
                  </div>
                </div>
                <div class="tab-pane fade" id="advertisement">
                    <%@ include file="ads_list.jsp"%>
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
