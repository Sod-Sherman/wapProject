<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<script src="https://maps.googleapis.com/maps/api/js"></script>--%>


<div id="searchContainer">
<%--    <input class="searchControll" type="text" placeholder="City Name of Zipcode" id="searchInput">--%>
    <input hidden id="searchInput" value="${city}">
    <button class="searchControl" id="searchBtn" style="display: none">Get Weather</button>
</div>
<div id="weatherContainer">
    <div id="weatherDescription">
        <h1 id="cityHeader"></h1>
        <div id="weatherMain">
            <div id="temperature"></div>
            <div id="weatherDescriptionHeader"></div>
            <div img id="documentIconImg"></div>
        </div>
        <hr>
        <div id="windSpeed" class="bottom-details"></div>
        <div id="humidity" class="bottom-details"></div>
    </div>
</div>

<style>
    .weather_container {
        background-image: url('images/default.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
        color: white;
        text-shadow: 2px 2px 1px black;
        font-family: "Palatino Linotype", "Book Antiqua", "Palatino Linotype", serif ;
    }

    #weatherContainer {
        background-color: rgba(0, 0, 0, 0.25);
        box-shadow: 1px 1px 5px black;
        padding: 50px;
        border-radius: 10px;
        position: absolute;
        visibility: hidden;
        background-position: center;
        background-size: cover;
    }

    #weatherContainer h1 {
        margin: 5px;
        font-size: 42px;
        font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
    }

    #searchContainer {
        padding: 15px;
        position: absolute;
        top: 0;
        right: 0;
    }

    #searchContainer input {
        width: 200px;
    }

    #searchContainer button {
        background-color: rgb(1, 159, 198);
        width: 75px;
    }

    .searchControl {
        box-shadow: 2px 2px 5px black;
        border: none;
        border-radius: 5px;
        padding: 5px;
    }

    #weatherMain {
        display: block;
        margin-bottom: 20px;
    }

    #weatherMain div {
        display: inline-block;
    }

    #weatherDescriptionHeader {
        font-size: 28px;
        vertical-align: 50%;
    }

    #temperature {
        font-size: 38px;
        vertical-align: 25%;
    }

    .bottom-details {
        display: block;
        font-size: 24px;
        text-align: right;
    }

    hr {
        margin-bottom: 20px;
    }
</style>

<script async="false" defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyClLUXvXjhCsWfw3t2P838TLd-Jnx2Uwro" type="text/javascript"></script>

<script src="weather/script.js"></script>

<script>
    $(function() {
        $("#searchBtn").click();
    });
</script>