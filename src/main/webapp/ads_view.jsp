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
            <form action="ads_add" method="post">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" id="customSwitch1" checked="" value="${myAds.active}">
                            <label class="custom-control-label" for="customSwitch1">Active</label>
                        </div>
                        <div class="form-group">
                            <label class="col-form-label" for="article">Article</label>
                            <input type="hidden" name="id" value="${myAds.id}">
                            <input type="text" name="article" class="form-control" placeholder="Article will be formatted in BOLD" id="article" value="${myAds.article}">
                        </div>
                        <div class="form-group">
                            <label class="col-form-label" for="content">Content</label>
                            <input type="text" name="content" class="form-control" placeholder="Content" id="content" value="${myAds.content}">
                        </div>
                        <div class="form-group">
                            <label class="col-form-label" for="imgUrl">Image URL</label>
                            <input type="text" class="form-control" name="imgURL" placeholder="Picture URL without background attracts more users" id="imgUrl" value="${myAds.imgUrl}">
                        </div>
                        <div class="form-group">
                            <label class="col-form-label" for="url">Product URL</label>
                            <input type="text" class="form-control" name="url" id="url" value="${myAds.url}">
                        </div>
                        <div class="form-group">
                            <label class="col-form-label" for="location">Location</label>
                            <input type="text" class="form-control" name="location"  id="location" value="${myAds.location}">
                        </div>
                        <div class="form-group">
                            <label class="col-form-label col-form-label-sm">User Age Range</label>
                            <input class="form-control form-control-sm" name="ageRange" type="number" id="rangeMax" placeholder="+/- 5 years of audience" maxlength="40px" value="${myAds.ageRangeMax}">
                        </div>

                        <div class="form-group">
                            <label class="col-form-label col-form-label-sm">Duration</label>
                            <input class="form-control form-control-sm" name="duration" type="number" id="duration" width="40px" value="${myAds.duration}">
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="reset" class="btn btn-primary">Reset</button>
                    </div>
                </div>
            </div>
            </form>
        </main>
    </div>
</div>
</body>
</html>