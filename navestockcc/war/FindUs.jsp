<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="navwidgets" uri="WEB-INF/tld/Widget.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="How to find Navestock Cricket Club. Our address: The Green, Navestockside, near Brentwood Essex, CM14 5SD"/>
<meta name="keywords" content="Navestock, Cricket Club, Navestockcc, Find us, address: " />
<meta http-equiv="content-language" content="en" />
 <link type="text/css" rel="stylesheet" href="../CSS/Navestockcc.css">
 <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" /> 
<title>Navestock Cricket Club Find Us</title>

<style>
      #map-canvas {
        width: 500px;
        height: 400px;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
    <script>
// This example displays a marker at the center of Australia.
// When the user clicks the marker, an info window opens.

function initialize() {
  var myLatlng = new google.maps.LatLng(51.6538104, 0.2593911);
  var mapOptions = {
    zoom: 15,
    center: myLatlng
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

  var contentString = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<p id="firstHeading" class="firstHeading"><b>Navestock Cricket Club</b></p>'+
      '<div id="bodyContent">'+
      '<p>The Green<br>Navestockside<br>near Brentwood Essex<br>CM14 5SD</p>'+
      '</div>'+
      '</div>';

  var infowindow = new google.maps.InfoWindow({
      content: contentString
  });

  var image = 'img/cricketmapicon.png';
  var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      icon: image,
      title: 'Navestock Cricket Club'
  });
  google.maps.event.addListener(marker, 'click', function() {
    infowindow.open(map,marker);
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
    
    
</head>
    <body>
    
    	<div class='page_container'>
			<jsp:include page="banner.jsp" />
			<div class='content'>
				<div class='left_panel'>
					<p class='left_panel_heading'>Where To Find Us</p>
					<p class='left_panel_text'><b>Address:</b><br>
					The Green<br>
					Navestockside<br>
					near Brentwood Essex<br>
					CM14 5SD</p>
					
					<p class='left_panel_text'><b>Directions:</b><br>
					Go North out of Brentwood on the A128 about 2 miles out turn left 
					then right at Bentley Church, right and right again. The club is on your right opposite Alec's 
					(formerly the Green Man pub.)  If all else fails just ask for directions to the restaurant!
					</p>
					<div id="map-canvas"></div>
					<br>
				</div>
				<div class='right_panel'>
					<a href="PlayersWanted.jsp"><img class='players_wanted_img' src='img/PlayersWantedRedv1.png'></a>
					<div class='right_panel_widgets green'>
					<div class='panel_widget_menu green'>
						<p class='panel_widget_menu_item_select green'>Fixtures</p>
					</div>
						<navwidgets:MatchListWidget gamesToDisplay="3" />
					</div>					
				</div>
			</div>
		</div>	
    <jsp:include page="navestockccjs/analitics.js" />	
    </body>

</html>