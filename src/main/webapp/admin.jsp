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
            <div class="container">
                <div class="row">
                    <br/>
                    <div class="col text-center">
                        <h2>Today's report</h2>
                    </div>
                </div>
                <div class="row text-center">
                    <div class="col">
                        <div class="counter">
                            <i class="fa fa-code fa-2x"></i>
                            <h2 class="timer count-title count-number" data-to="${postz}" data-speed="1500"></h2>
                            <p class="count-text ">Total Posts</p>
                        </div>
                    </div>
                    <div class="col">
                        <div class="counter">
                            <i class="fa fa-coffee fa-2x"></i>
                            <h2 class="timer count-title count-number" data-to="${userz}" data-speed="1500"></h2>
                            <p class="count-text ">Total users</p>
                        </div>
                    </div>
                    <div class="col">
                        <div class="counter">
                            <i class="fa fa-lightbulb-o fa-2x"></i>
                            <h2 class="timer count-title count-number" data-to="${activeAdz}" data-speed="1500"></h2>
                            <p class="count-text ">Active advertisements</p>
                        </div></div>
                    <div class="col">
                        <div class="counter">
                            <i class="fa fa-bug fa-2x"></i>
                            <h2 class="timer count-title count-number" data-to="${badPost}" data-speed="1500"></h2>
                            <p class="count-text ">Unhealthy post</p>
                        </div>
                    </div>
                </div>
            </div>
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
                            <th scope="col">Post Health</th>
                            <th scope="col">Posted Date</th>
                            <th scope="col">Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="post" items="${postsAll}">
                            <tr class="table-primary">
                                <td>${post.user.username}</td>
                                <td>${post.health}</td>
                                <td>${post.postedDate}</td>
                                <td>${post.active}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="user">
                  <div>
                      <table class="table table-hover">
                          <thead>
                          <tr>
                              <th scope="col">User id</th>
                              <th scope="col">User Name</th>
                              <th scope="col">Status</th>
                              <th scope="col">Twitter account</th>
                              <th scope="col">Email</th>
                          </tr>
                          </thead>
                          <tbody>
                          <c:forEach var="user" items="${usersAll}">
                              <tr class="table-primary">
                                  <td>${user.id}</td>
                                  <td>${user.username}</td>
                                  <td>${user.active}</td>
                                  <td>${user.twitter}</td>
                                  <td>${user.email}</td>
                              </tr>
                          </c:forEach>
                          </tbody>
                      </table>
                  </div>
                </div>
                <div class="tab-pane fade" id="advertisement">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Active</th>
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
                                <td>${ad.active}</td>
                                <td>${ad.id}</td>
                                <td>${ad.content}</td>
                                <td>${ad.url}</td>
                                <td>${ad.imgUrl}</td>
                                <td>${ad.postedDate}</td>
                                <td>${ad.location}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
