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


<body>
<p>${statusProfile}</p>

<%--<form method="post" action="profile">--%>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h2>Logged in: ${loggedInUser.fullName}</h2></div>
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

            <ul class="list-group">
                <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>

                <li class="list-group-item text-right"><span
                        class="pull-left"><strong>Posts</strong></span> ${postsNumber}</li>
                <li class="list-group-item text-right"><span
                        class="pull-left"><strong>Followers</strong></span> ${followersNumber}
                </li>
            </ul>

            <div class="panel panel-default">
                <div class="panel-heading">Social Media</div>
                <div class="panel-body">

                </div>
            </div>

        </div><!--/col-3-->

        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Information</a></li>
                <li><a data-toggle="tab" href="#editProfile">Edit Profile</a></li>
                <%--<li><a data-toggle="tab" href="#settings">Menu 2</a></li>--%>
            </ul>

<%---------------------------Information tab-------------------------------------------%>
            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>

test

                    <hr>

                </div><!--/tab-pane-->
<%---------------------------------------------------------------------%>
                <div class="tab-pane" id="editProfile">

                    <form class="form" method="post" action="profile" id="registrationForm1">
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="firstName"><h4>First name</h4></label>
                                <input type="text" class="form-control" name="firstName" id="firstName"
                                       value="${loggedInUser.firstName}"
                                       title="enter your first name if any.">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="lastName"><h4>Last name</h4></label>
                                <input type="text" class="form-control" name="lastName" id="lastName"
                                       value="${loggedInUser.lastName}" title="enter your last name if any.">
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="phone"><h4>Phone</h4></label>
                                <input type="text" class="form-control" name="phone" id="phone"
                                       value="${loggedInUser.phone}" title="enter your phone number if any.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Email</h4></label>
                                <input type="email" class="form-control" name="email" id="email"
                                       value="${loggedInUser.email}" title="enter your email.">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="location"><h4>Location</h4></label>
                                <input type="text" class="form-control" name="location" id="location"
                                       value="${loggedInUser.location}" title="enter your location if any.">
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4></label>
                                <input type="password" class="form-control" name="password" id="password"
                                       value="${loggedInUser.password}" title="enter your password.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="repeatPassword"><h4>Verify</h4></label>
                                <input type="password" class="form-control" name="password2" id="repeatPassword"
                                       title="enter your password2.">
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

            </div><!--/tab-content-->

        </div><!--/col-9-->
    </div><!--/row-->
    <%--</form>--%>

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