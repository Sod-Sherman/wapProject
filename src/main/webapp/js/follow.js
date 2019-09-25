$(document).ready(function () {

    $(".follow").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        let data = {"fullNameOfPoster": $('.fullNameOfPoster').text()};
        // data.append("fullNameOfPoster", $('.fullNameOfPoster').val());
        console.log(data);

        $.ajax({
            type: "POST",
            url: "follow",
            data: data,
            // processData: false,
            // contentType: false,
            // cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                //window.location.href = "timeline";

            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });

    });

});
