<%--
  Created by IntelliJ IDEA.
  User: sdblg
  Date: 9/23/2019
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Update info</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css2">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<p>${statusProfile}</p>

<p>${loggedInUser.firstName}</p>

<body>
<hr>
<form method="post" action="profile">
    <div class="container bootstrap snippet">
        <div class="row">
            <div class="col-sm-10"><h1>User name: ${loggedInUser.firstName}</h1></div>
            <div class="col-sm-2"><a href="timeline" class="pull-right"><img title="Time Line"
                                                                             class="img-circle img-responsive"
                                                                             src="http://www.gravatar.com/avatar/28fd20ccec6865e2d5f0e1f4446eb7bf?s=100"></a>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3"><!--left col-->

                <div class="text-center">
                    <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail"
                         alt="avatar">
                    <h6>Upload a different photo...</h6>
                    <input type="file" class="text-center center-block file-upload">
                </div>
                </hr><br>


                <div class="panel panel-default">
                    <div class="panel-heading">Website <i class="fa fa-link fa-1x"></i></div>
                    <div class="panel-body"><a href="http://bootnipets.com">bootnipets.com</a></div>
                </div>


                <ul class="list-group">
                    <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                    <li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span> 125
                    </li>
                    <li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> 13</li>
                    <li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span> 37</li>
                    <li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span> 78
                    </li>
                </ul>

                <div class="panel panel-default">
                    <div class="panel-heading">Social Media</div>
                    <div class="panel-body">
                        <i class="fa fa-facebook fa-2x"></i> <i class="fa fa-github fa-2x"></i> <i
                            class="fa fa-twitter fa-2x"></i> <i class="fa fa-pinterest fa-2x"></i> <i
                            class="fa fa-google-plus fa-2x"></i>
                    </div>
                </div>

            </div><!--/col-3-->

            <div class="col-sm-9">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#home">Update information</a></li>
                    <%--<li><a data-toggle="tab" href="#messages">Menu 1</a></li>--%>
                    <%--<li><a data-toggle="tab" href="#settings">Menu 2</a></li>--%>
                </ul>


                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <hr>
                        <form class="form" action="##" method="post" id="registrationForm1">
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="firstName"><h4>First name</h4></label>
                                    <input type="text" class="form-control" name="firstName" id="firstName"
                                           placeholder="${loggedInUser.firstName}"
                                           title="enter your first name if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="lastName"><h4>Last name</h4></label>
                                    <input type="text" class="form-control" name="lastName" id="lastName"
                                           placeholder="${loggedInUser.lastName}" title="enter your last name if any.">
                                </div>
                            </div>

                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="username"><h4>Username</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="username" id="username"--%>
                                           <%--placeholder="${loggedInUser.username}" title="enter your username if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="phone"><h4>Phone</h4></label>
                                    <input type="text" class="form-control" name="phone" id="phone"
                                           placeholder="${loggedInUser.phone}" title="enter your phone number if any.">
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="email"><h4>Email</h4></label>
                                    <input type="email" class="form-control" name="email" id="email"
                                           placeholder="${loggedInUser.email}" title="enter your email.">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="location"><h4>Location</h4></label>
                                    <input type="text" class="form-control" name="location" id="location"
                                           placeholder="${loggedInUser.location}" title="enter your location if any.">
                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="password"><h4>Password</h4></label>
                                    <input type="password" class="form-control" name="password" id="password"
                                           placeholder="${loggedInUser.password}" title="enter your password.">
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="repeatPassword"><h4>Verify</h4></label>
                                    <input type="password" class="form-control" name="password2" id="repeatPassword"
                                           placeholder="repeat password" title="enter your password2.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save
                                    </button>
                                    <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i>
                                        Reset
                                    </button>
                                </div>
                            </div>
                        </form>

                        <hr>

                    </div><!--/tab-pane-->



                    <%--<div class="tab-pane" id="messages">--%>

                        <%--<h2></h2>--%>

                        <%--<hr>--%>
                        <%--<form class="form" action="##" method="post" id="registrationForm2">--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="firstName2"><h4>First name</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="first_name" id="firstName2"--%>
                                           <%--placeholder="first name" title="enter your first name if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="lastName2"><h4>Last name</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="last_name" id="lastName2"--%>
                                           <%--placeholder="last name" title="enter your last name if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="phone"><h4>Phone</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="phone" id="phone2"--%>
                                           <%--placeholder="enter phone" title="enter your phone number if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="mobile2"><h4>Mobile</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="mobile" id="mobile2"--%>
                                           <%--placeholder="enter mobile number" title="enter your mobile number if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="email"><h4>Email</h4></label>--%>
                                    <%--<input type="email" class="form-control" name="email" id="email2"--%>
                                           <%--placeholder="you@email.com" title="enter your email.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="email"><h4>Location</h4></label>--%>
                                    <%--<input type="email" class="form-control" id="location2" placeholder="somewhere"--%>
                                           <%--title="enter a location">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="password"><h4>Password</h4></label>--%>
                                    <%--<input type="password" class="form-control" name="password" id="passwordrep2"--%>
                                           <%--placeholder="password" title="enter your password.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="password2rep2"><h4>Verify</h4></label>--%>
                                    <%--<input type="password" class="form-control" name="password2" id="password2rep2"--%>
                                           <%--placeholder="password2" title="enter your password2.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<div class="col-xs-12">--%>
                                    <%--<br>--%>
                                    <%--<button class="btn btn-lg btn-success" type="submit"><i--%>
                                            <%--class="glyphicon glyphicon-ok-sign"></i> Save--%>
                                    <%--</button>--%>
                                    <%--<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i>--%>
                                        <%--Reset--%>
                                    <%--</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</form>--%>

                    <%--</div><!--/tab-pane-->--%>


                    <%--<div class="tab-pane" id="settings">--%>
                        <%--<hr>--%>
                        <%--<form class="form" action="##" method="post" id="registrationForm3">--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="firstName3"><h4>First name</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="first_name" id="firstName3"--%>
                                           <%--placeholder="first name" title="enter your first name if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="lastName3"><h4>Last name</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="last_name" id="lastName3"--%>
                                           <%--placeholder="last name" title="enter your last name if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="phone"><h4>Phone</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="phone" id="phone3"--%>
                                           <%--placeholder="enter phone" title="enter your phone number if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="mobile3"><h4>Mobile</h4></label>--%>
                                    <%--<input type="text" class="form-control" name="mobile" id="mobile3"--%>
                                           <%--placeholder="enter mobile number" title="enter your mobile number if any.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="email"><h4>Email</h4></label>--%>
                                    <%--<input type="email" class="form-control" name="email" id="email3"--%>
                                           <%--placeholder="you@email.com" title="enter your email.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="email"><h4>Location</h4></label>--%>
                                    <%--<input type="email" class="form-control" id="location3" placeholder="somewhere"--%>
                                           <%--title="enter a location">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="password"><h4>Password</h4></label>--%>
                                    <%--<input type="password" class="form-control" name="password" id="passwordrep3"--%>
                                           <%--placeholder="password" title="enter your password.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>

                                <%--<div class="col-xs-6">--%>
                                    <%--<label for="password2rep3"><h4>Verify</h4></label>--%>
                                    <%--<input type="password" class="form-control" name="password2" id="password2rep3"--%>
                                           <%--placeholder="password2" title="enter your password2.">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<div class="col-xs-12">--%>
                                    <%--<br>--%>
                                    <%--<button class="btn btn-lg btn-success pull-right" type="submit"><i--%>
                                            <%--class="glyphicon glyphicon-ok-sign"></i> Save--%>
                                    <%--</button>--%>
                                    <%--<!--<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>-->--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</form>--%>
                    <%--</div>--%>

                </div><!--/tab-pane-->
            </div><!--/tab-content-->

        </div><!--/col-9-->
    </div><!--/row-->
</form>
<script>
    $(document).ready(function () {

        var readURL = function (input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('.avatar').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }


        $(".file-upload").on('change', function () {
            readURL(this);
        });
    });
</script>

</body>
</html>