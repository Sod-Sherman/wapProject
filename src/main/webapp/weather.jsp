<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-09-24
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="weather/style.css">
</head>
<body>

<div id="searchContainer">
    <input class="searchControll" type="text" placeholder="City Name of Zipcode" id="searchInput">
    <button class="searchControl" id="searchBtn">Search</button>
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
<script src="weather/script.js"></script>

<style>
    body {
        background-image: url('/images/default.jpg');
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

</body>
</html>
