let appId = 'd0752d62343d10e5a5feb80ddc04f18c';
let units = 'imperial';
let searchMethod;

function getSearchMethod(searchTerm) {
    if (searchTerm.length === 5 && Number.parseInt(searchTerm) + '' === searchTerm)
        searchMethod = 'zip';
    else
        searchMethod = 'q';
}

function searchWeather(searchTerm) {
    getSearchMethod(searchTerm);
    fetch(`http://api.openweathermap.org/data/2.5/weather?${searchMethod}=${searchTerm}&APPID=${appId}&units=${units}`).then(result => {
        return result.json();
    }).then(result =>{
        init(result);
    })
}

function init(resultFromServer) {
    switch (resultFromServer.weather[0].main) {
        case 'Clear':
            document.getElementById("weatherContainer").style.backgroundImage = 'url("images/clear.jpg")';
            break;

        case 'Clouds':
            document.getElementById("weatherContainer").style.backgroundImage = 'url("images/cloudy.jpg")';
            document.getElementById("weatherContainer").style.color = 'white';

            break;

        case 'Rain':
        case 'Drizzle':
        case 'Mist':
            document.getElementById("weatherContainer").style.backgroundImage = 'url("images/rain.jpg")';
            break;

        case 'Thunderstorm':
            document.getElementById("weatherContainer").style.backgroundImage = 'url("images/storm.jpg")';
            break;

        case 'Snow':
            document.getElementById("weatherContainer").style.backgroundImage = 'url("images/snow.jpg")';
            break;

        default:
            break;
    }

    let weatherDescriptionHeader = document.getElementById('weatherDescriptionHeader');
    let temperatureElement = document.getElementById('temperature');
    let humidityElement = document.getElementById('humidity');
    let windSpeedElement = document.getElementById('windSpeed');
    let cityHeader = document.getElementById('cityHeader');
    let weatherIcon = document.getElementById('documentIconImg');

    weatherIcon.src = 'http://openweathermap.org/img/wn/' + resultFromServer.weather[0].icon + '.png'; // icon is not working




    let resultDescription = resultFromServer.weather[0].description;
    weatherDescriptionHeader.innerText = resultDescription.charAt(0).toUpperCase() + resultDescription.slice(1);

    temperatureElement.innerHTML = Math.floor(resultFromServer.main.temp) + '&#176';
    windSpeedElement.innerHTML = 'Winds at ' + Math.floor(resultFromServer.wind.speed) + 'm/s';
    cityHeader.innerHTML = resultFromServer.name;
    humidityElement.innerHTML = 'Humidity levels at ' + resultFromServer.main.humidity + '%';

    setPositionForWeatherInfo();
}

function setPositionForWeatherInfo(){
    let weatherContainer = document.getElementById('weatherContainer');
    let weatherContainerHeight = weatherContainer.clientHeight;
    let weatherContainerWidth = weatherContainer.clientWidth;

    //weatherContainer.style.left = `calc(50% - ${weatherContainerWidth/2}px)`;
    //weatherContainer.style.top = `calc(50% - ${weatherContainerHeight/1.3}px)`;
    weatherContainer.style.visibility = 'visible';
}

document.getElementById('searchBtn').addEventListener('click', () =>{
        let searchTerm = '';

        if(navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                var lat = position.coords.latitude;
                var long = position.coords.longitude;
                var point = new google.maps.LatLng(lat, long);
                new google.maps.Geocoder().geocode(
                    {'latLng': point},
                    function (res, status) {
                        var zip = res[0].formatted_address.match(/,\s\w{2}\s(\d{5})/);
                        //searchTerm = zip;
                        console.log(zip[1]);
                        //$("#location").val(zip);
                        searchTerm = zip[1];
                        let cityHeader = document.getElementById('searchInput').value;
                        if(cityHeader) searchTerm = cityHeader;
                        console.log(cityHeader);
                        //if($("#searchInput").val()) searchTerm = $("#searchInput").val();
                        searchWeather(searchTerm);
                    }
                );
            });
        }
});

