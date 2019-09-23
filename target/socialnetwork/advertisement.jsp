<%--
  Created by IntelliJ IDEA.
  User: 1246
  Date: 9/22/2019
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="WEB-INF/fragment/admin_header.jsp"%>
<body>

<%@ include file="WEB-INF/fragment/admin_header_menu.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@ include file="WEB-INF/fragment/admin-side-panel.jsp"%>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#view">Active advertisements</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#create">Add new advertisements</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " data-toggle="tab" href="#update">Update advertisement</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade show active" id="view">
                        VIEW
                    </div>

                    <div class="tab-pane fade" id="create">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <fieldset>
                                            <label class="control-label" for="readOnlyInput">Advertisement Id</label>
                                            <input class="form-control" id="readOnlyInput" type="text" placeholder="Auto generated ID" readonly="">
                                        </fieldset>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label" for="article">Article</label>
                                        <input type="text" class="form-control" placeholder="Article will be placed in BOLD" id="article">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleTextarea">Content</label>
                                        <textarea class="form-control" id="exampleTextarea" placeholder="Please briefly describe your advertisement" rows="3"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label" for="imgUrl">Image URL</label>
                                        <input type="text" class="form-control" placeholder="Pictures without background" id="imgUrl">
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label" for="url">Product URL</label>
                                        <input type="text" class="form-control" placeholder="Once clicked will ..." id="url">
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label">Price per view</label>
                                        <div class="form-group">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">$</span>
                                                </div>
                                                <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
                                                <div class="input-group-append">
                                                    <span class="input-group-text">.00</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <fieldset>
                                        <legend>Choose Location group</legend>
                                        <div class="form-group">
                                            <select class="custom-select">
                                                <option selected="">Choose location group</option>
                                                <option value="1">USA</option>
                                                <option value="2">China</option>
                                                <option value="3">Mongolia</option>
                                            </select>
                                        </div>
                                    </fieldset>
                                    <div class="form-group">
                                        <label class="col-form-label col-form-label-sm">User Age Range</label>
                                        <input class="form-control form-control-sm" type="number" placeholder="from..." id="rangeMin" maxlength="60px"></br>
                                        <input class="form-control form-control-sm" type="number" id="rangeMax" placeholder="to..." maxlength="40px">
                                    </div>

                                    <div class="form-group">
                                        <label class="col-form-label col-form-label-sm">Duration</label>
                                        <input class="form-control form-control-sm" type="number" id="duration" width="40px">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                    <button type="reset" class="btn btn-primary">Reset</button>
                                </div>
                                <div class="col-5">
                                    PREVIEW
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="update">
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
