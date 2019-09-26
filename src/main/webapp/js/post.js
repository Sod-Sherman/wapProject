$(document).ready(function () {
    console.log("sdblg");
    $("#btnSubmit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        console.log("sdblg");

        // Get form
        var form = $('#fileUploadForm')[0];

        // Create an FormData object
        var data = new FormData(form);
        data.append("textArea1", $('#textarea').val());
        console.log(data);

        // If you want to add an extra field for the FormData
        //data.append("CustomField", "This is some extra data, testing");

        // disabled the submit button
        $("#btnSubmit").prop("disabled", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "post",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                $("#result").text("Success!");
                console.log("SUCCESS : ", data);
                $("#btnSubmit").prop("disabled", true);

                window.location.href = "timeline";

            },
            error: function (e) {

                $("#result").text(e.responseText);
                console.log("ERROR : ", e);
                $("#btnSubmit").prop("disabled", false);

            }
        });


        function postMessage() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("POST", "shoutServlet?t=" + new Date(), false);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            var messageText = escape(document.getElementById("message").value);
            document.getElementById("message").value = "";
            xmlhttp.send("&message=" + messageText);
        }

        var messagesWaiting = false;

        function getMessages() {
            if (!messagesWaiting) {
                messagesWaiting = true;
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        messagesWaiting = false;
                        var contentElement = document.getElementById("content");
                        contentElement.innerHTML = xmlhttp.responseText + contentElement.innerHTML;
                    }
                }
                xmlhttp.open("GET", "shoutServlet?t=" + new Date(), true);
                xmlhttp.send();
            }
        }
        postMessage();
        setInterval(getMessages, 1000);


    });

});
