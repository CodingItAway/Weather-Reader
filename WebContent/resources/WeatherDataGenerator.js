function searchWeatherData(){
	var cityName = document.getElementById("cityName").value;	
	var url = "http://api.openweathermap.org/data/2.5/weather?";
	url = url +"q="+cityName;
	url = url + "&APPID=efcfcdb2a6f83e1a654824f06b0f5d27&units=metric";
	getWeatherJson(url);
}


function getWeatherJson(url)
{
	$.getJSON(url,function(result){
	    buildUILayout(result);
	    var convertedDate = timeConverter(result.dt);
	    result.searchDate = convertedDate;
	    $.ajax({ 
	        url:'postWeatherData',    
	        type:"POST", 
	        contentType: "application/json; charset=utf-8",
	        data: JSON.stringify(result), 
	        async: true,    
	        cache: false,            
	        processData:false, 
	        success: function(resposeJsonObject){
	        }
	    });
	    });
	 
}

function buildUILayout(weatherData)
{
	var date = timeConverter(weatherData.dt);
	
	var htmlStr = "<table style='width: 100%;' class='weatherResult' id='searchTable'>";
    htmlStr = htmlStr + "<tr>";
        htmlStr = htmlStr + "<td rowspan='2'>";
        htmlStr = htmlStr + "<img src='http://openweathermap.org/img/w/" + weatherData.weather[0].icon + ".png'>";
        htmlStr = htmlStr + "</td>";
        htmlStr = htmlStr + "<td>";
        htmlStr = htmlStr + weatherData.name;
        htmlStr = htmlStr + "</td>";
        htmlStr = htmlStr + "<td>";
        htmlStr = htmlStr + weatherData.main.temp+'&deg;C &nbsp;&nbsp;'+weatherData.weather[0].main;
        htmlStr = htmlStr + "</td>";
        htmlStr = htmlStr + "<td rowspan='2' align='center'>";
        htmlStr = htmlStr + "<input type='button' value='Delete' id="+weatherData.id+" class='searchButton' onclick='triggerDatabaseDeleteSearch(this)''/>";
        htmlStr = htmlStr + "</td>";
        htmlStr = htmlStr + "</tr>";        
        htmlStr = htmlStr + "<tr>";
        htmlStr = htmlStr + "<td>";
        htmlStr = htmlStr + date;
        htmlStr = htmlStr + "</td>";
        htmlStr = htmlStr + "<td>";
        htmlStr = htmlStr + weatherData.wind.speed+'m/s.   '+weatherData.main.humidity+'%, &nbsp;'+weatherData.main.pressure+' hPa';
        htmlStr = htmlStr + "</td>";
        htmlStr = htmlStr + "</tr>";
        
    htmlStr = htmlStr + "</table>";
    document.getElementById('searchResultsDiv').innerHTML = htmlStr;
}

function triggerDatabaseDeleteSearch(tableRow)
{
	var rowId = tableRow.id;		    
	    $.ajax({ 
	        url:'deleteDataForCityId',    
	        type:"POST", 
	        contentType: "application/json; charset=utf-8",
	        data: JSON.stringify(rowId), 
	        async: true,    
	        cache: false,            
	        processData:false, 
	        success: function(resposeJsonObject){
	            // Success Message Handler
	        }
	    });
	    var row = tableRow.parentNode.parentNode.rowIndex;
	    for(i=0;i<2;i++)
	    	{
	    		document.getElementById('searchTable').deleteRow(row);
	    	}
}


function triggerDatabaseDeleteExisting(tableRow)
{
	var rowId = tableRow.id;		    
	    $.ajax({ 
	        url:'deleteDataForId',    
	        type:"POST", 
	        contentType: "application/json; charset=utf-8",
	        data: JSON.stringify(rowId), 
	        async: true,    
	        cache: false,            
	        processData:false, 
	        success: function(resposeJsonObject){
	            // Success Message Handler
	        }
	    });
	    var row = tableRow.parentNode.parentNode.rowIndex;
	    for(i=0;i<2;i++)
	    	{
	    		document.getElementById('weatherLogsTable').deleteRow(row);
	    	}
}

function timeConverter(UNIX_timestamp){
	  var a = new Date(UNIX_timestamp * 1000);
	  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
	  var year = a.getFullYear();
	  var month = months[a.getMonth()];
	  var date = a.getDate();
	  var time = month + ' ' + date + ',' + year;
	  return time;
	}
