<html>
<body>
<%@ include file="WEB-INF/fragment/header.jsp" %>
<p></p>
${statusMsg}
<form action="#" method="post" enctype = "multipart/form-data" id="fileUploadForm">
<div class="container-fluid">
    <div class="card" style="max-width: 540px; margin: auto;">
        <div class="form-group">
            <label for="textarea" class="left-arrow">Create post</label>
            <textarea class="form-control" id="textarea" rows="4" name="textarea"></textarea>
        </div>
        <div class="form-group">
            <label for="file">Example file input</label>
            <input type="file" class="form-control-file btn-sm" name="file" id="file" size = "50">
        </div>
        <div class="form-group">
            <input type="submit" class="btn-sm btn-primary" id="btnSubmit"/>
        </div>
        <span id="result"></span>
    </div>
</div>
</form>

<%@include file="WEB-INF/fragment/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/post.js" type="text/javascript">

</script>
</body>
</html>
