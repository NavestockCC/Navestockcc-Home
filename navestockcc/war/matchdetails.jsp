<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="navwidgets" uri="WEB-INF/tld/Widget.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Detailed match information"/>
<meta name="keywords" content="Navestock, Cricket Club, Navestockcc, Match details" />
<meta http-equiv="content-language" content="en" />
 <link type="text/css" rel="stylesheet" href="../CSS/Navestockcc.css">
 <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<title>Navestock Cricket Club Match Details</title>

<style>
      #map-canvas {
        width: 328px;
        height: 280px;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
    <script>
// This example displays a marker at the center of Australia.
// When the user clicks the marker, an info window opens.

function initialize() {
	
	geocoder = new google.maps.Geocoder();
	var latlngbounds = new google.maps.LatLngBounds();
	var address = document.getElementById('pstcode').value;

	  geocoder.geocode( { 'address': address}, function(results, status) {
	      if (status == google.maps.GeocoderStatus.OK) {	    	  
	    	  var image = 'img/cricketmapicon.png';
	    	  var marker = new google.maps.Marker({
	    	      position: results[0].geometry.location,
	    	      map: map,
	    	      icon: image,
	    	  });
	    	  latlngbounds.extend(results[0].geometry.location);
	    	  var myLatlng1 = new google.maps.LatLng(51.6538104, 0.2593911);
	    	  
	    	  var image = 'img/NavestockPin.png';
	    	  var marker = new google.maps.Marker({
	    	      position: myLatlng1,
	    	      map: map,
	    	      icon: image,
	    	      title: 'Navestock Cricket Club'
	    	  });	  
	    	  
	    	  latlngbounds.extend(myLatlng1);
	    	  map.setCenter(latlngbounds.getCenter());
	    	  map.fitBounds(latlngbounds);  	  
	      } 
	    });
	  var map = new google.maps.Map(document.getElementById('map-canvas'));
}


google.maps.event.addDomListener(window, 'load', initialize);

    </script>
    
</head>
    <body>
    	<div class='page_container'>
			<jsp:include page="banner.jsp" />
			<div class='content'>
				<div class='left_panel'>
					<navwidgets:FixtureDetails matchId="${param['mId']}"/><br>
					<navwidgets:ScoreCardWidget matchId="${param['mId']}"/>
				</div>
				<div class='right_panel'>
					<div id="map-canvas"></div>
				</div>
			</div>
		</div>	
    <jsp:include page="navestockccjs/analitics.js" />	
    </body>
</html>