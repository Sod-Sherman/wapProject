<%--
  Created by IntelliJ IDEA.
  User: sdblg
  Date: 9/21/2019
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>

    $("#logout").click(function (e) {
        e.preventDefault();
        alert("Sure?");
        sessionStorage.removeItem("loggedInUser");
        sessionStorage.clear();

        $.post({
            url: "logout",
            "logout": "LogOUT",
            success: function (msg) {
                if(msg == 'LogOUT'){
                    window.location.href = 'login.jsp';
                }
            }
        });


    });
</script>
</body>
</html>
