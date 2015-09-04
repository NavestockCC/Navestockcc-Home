<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="navwidgets" uri="WEB-INF/tld/Widget.tld"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Welcome to Navestock Cricket Club home page. Every thing you need to know about Navestock Cricket Club. Match schedules, contact information and how to find us."/>
<meta name="keywords" content="Navestock, Cricket Club, Navestockcc" />
<meta http-equiv="content-language" content="en" />


 <link type="text/css" rel="stylesheet" href="../CSS/Navestockcc.css">
 <link rel="icon" href="img/favicon.ico" type="image/x-icon" />  
 <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" /> 
<title>Navestock Cricket Club Home</title>
</head>
    <body>
    
    	<div class='page_container'>
			<jsp:include page="banner.jsp" />
			<div class='content'>
				<div class='left_panel'>
					<img class='splash_img' src='img/Splashv2.jpg'>
					<p class='left_panel_heading'>Welcome to Navestock Cricket Club</p>
					<p class='left_panel_text'>A typical village cricket club in the heart of the Essex countryside. Situated in the lovely village of Navestock, with Alec's Restaurant opposite.</p> 
					<p class='left_panel_text'>The club has two thriving Saturday league team and a Sunday friendlies team.</p>
					<p class='left_panel_text'>We welcome players of all ages and abilities and would be glad to see fresh faces. 
					All players and their families are most welcome and we look forward to seeing many of you at the matches.</p>
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