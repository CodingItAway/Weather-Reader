<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<spring:url value="/resources/theme.css" var="theme" />
<spring:url value="/resources/WeatherDataGenerator.js" var="weatherDataGenerator" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="${theme}" rel="stylesheet" />
<script src="${weatherDataGenerator}"></script>


<title>Weather Data</title>
</head>
<body>
	<div id="searchContentDiv">
	<table style='width: 100%;' class="searchSection">
		<tr>
			<td>
				<input type="text" id="cityName" style='width: 100%;' placeholder="Search..."/>
			</td>
			<td>
				<input type="button" value="Search" class="searchButton" onclick="searchWeatherData()" style='width: 100%;'/>
			</td>
		</tr>
	</table>
	</div>

	<div id="searchResultsDiv">
		
	</div>
	
	<div id="weatherFetchDiv">
	 <table style='width: 100%;' class="weatherResult" id="weatherLogsTable">
		<c:forEach var="weather" items="${weatherData}" varStatus="loop">
			<tr>
				<td rowspan='2'>
					<img src="http://openweathermap.org/img/w/${weather.weatherDetails[0].weather[0].icon}.png">
				</td>
				<td height="30">
					${weather.weatherDetails[0].name}
				</td>
				<td>
					${weather.weatherDetails[0].main.temp} &deg;C &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${weather.weatherDetails[0].weather[0].main}
				</td>
				<td rowspan='2' align="center">
					<input type='submit' value='Delete' id='${weather.id}' class="searchButton" onclick="triggerDatabaseDeleteExisting(this)"/>
				</td>
			</tr>			
			<tr>
				<td height="30" class="unixDate">	
					${weather.weatherDetails[0].searchDate}			
				<td>
					${weather.weatherDetails[0].wind.speed} m/s.   ${weather.weatherDetails[0].main.humidity}, &nbsp;&nbsp;&nbsp; ${weather.weatherDetails[0].main.pressure} hPa;
				</td>
			</tr> 
		</c:forEach>
	</table> 
	</div>	
</body>
</html>