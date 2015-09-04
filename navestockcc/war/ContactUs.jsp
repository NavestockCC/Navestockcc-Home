<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="navwidgets" uri="WEB-INF/tld/Widget.tld"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Navestock Cricket Club contact infomration"/>
<meta name="keywords" content="Navestock, Cricket Club, Navestockcc, Contact information" />
<meta http-equiv="content-language" content="en" />
 <link type="text/css" rel="stylesheet" href="../CSS/Navestockcc.css">
 <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" /> 
<title>Navestock Cricket Club Contact Information</title>
</head>
    <body>
    
    	<div class='page_container'>
			<jsp:include page="banner.jsp" />
			<div class='content'>
				<div class='left_panel'>
					<img class='splash_img' src='img/Splashv2.jpg'>
					<p class='left_panel_heading'>Club Contact Information</p>
					
					<p class='left_panel_text'>
					President<br>
					Michael Parrish</p>
					
					<p class='left_panel_text'>
					Chairman<br>
					Ray Balcombe<br>
					Tel: 01277 899141<br>
					Email: ray@technicaldramadesign.co.uk
					</p>
					
					<p class='left_panel_text'>
					Secretary<br>
					Kevin Jordan<br>
					Tel: 07704 139359<br>
					Email: kevin.jordan1@btinternet.com
					</p>

					<p class='left_panel_text'>
					Treasurer<br>
					Ian Scott<br>
					Tel: 07885 601361<br>
					Email: ian@idscott.com
					</p>				

					<p class='left_panel_text'>
					Fixture Secretary<br>
					Malcolm Goddard<br>
					Tel: 07779 977475<br>
					Email: malcolmgoddard@hotmail.com
					</p>
					
					<p class='left_panel_text'>
					Website<br>
					Lefras Coetzee<br>
					Tel: 07415 950733<br>
					Email: lefras.coetzee@gmail.com
					</p>
					
					<p class='left_panel_text'>
					Groundsman<br>
					Geoff Wright<br>
					Tel: 07850 870230<br>
					Email: geoffwright@farming.co.uk
					</p>
					
					<p class='left_panel_text'>
					Saturday 1st XI<br>
					Gary Pearson<br>
					Tel: 07970 818302<br>
					Email: gary4pearson@yahoo.co.uk
					</p>
					
					<p class='left_panel_text'>
					Saturday 2nd XI<br>
					Paul Duhig<br>
					Tel: 07817 837458<br>
					Email: paul_duhig@sky.com
					</p>
					
					<p class='left_panel_text'>
					Sunday XI<br>
					Phil Sergeant<br>
					Tel: 07515 856231<br>
					Email: phil.sergeant.88@googlemail.com
					</p>
					
					<p class='left_panel_text'>
					Youth<br>
					Graham Cobb<br>
					Tel: 07813 044614<br>
					Email: grahamcobb31@googlemail.com</p>
					
					<p class='left_panel_text'>
					Welfare<br>
					Tracey Dooley<br>
					Tel: 07794 976190<br>
					Email: traceydoolers@googlemail.com
					</p>
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