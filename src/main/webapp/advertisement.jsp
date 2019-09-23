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
            <header>Usage Report
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
                        <div class="form-group">
                            <fieldset>
                                <label class="control-label" for="readOnlyInput">Advertisement Id</label>
                                <input class="form-control" id="readOnlyInput" type="text" placeholder="Auto generated ID" readonly="">
                            </fieldset>
                        </div>

                        <div class="form-group">
                            <label for="exampleTextarea">Content</label>
                            <textarea class="form-control" id="exampleTextarea" placeholder="Please briefly describe your advertisement" rows="3"></textarea>
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

                        <div class="form-group">
                            <select class="custom-select">
                                <option selected="">Choose location group</option>
                                <option value="1">USA</option>
                                <option value="2">China</option>
                                <option value="3">Mongolia</option>
                            </select>
                        </div>


                        <div class="form-group has-danger">
                            <label class="form-control-label" for="inputDanger1">Invalid input</label>
                            <input type="text" value="wrong value" class="form-control is-invalid" id="inputInvalid">
                            <div class="invalid-feedback">Sorry, that username's taken. Try another?</div>
                        </div>

                        <div class="form-group">
                            <label class="col-form-label col-form-label-lg" for="inputLarge">Large input</label>
                            <input class="form-control form-control-lg" type="text" placeholder=".form-control-lg" id="inputLarge">
                        </div>



                        <div class="form-group">
                            <label class="col-form-label col-form-label-sm" for="inputSmall">Small input</label>
                            <input class="form-control form-control-sm" type="text" placeholder=".form-control-sm" id="inputSmall">
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
