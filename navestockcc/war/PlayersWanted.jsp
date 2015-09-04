<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="navwidgets" uri="WEB-INF/tld/Widget.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Players wanted. Come and join our friendly club. How to join and who to contact available on this page."/>
<meta name="keywords" content="Navestock, Cricket Club, Navestockcc, Players wanted, join our club" />
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
					<img class='splash_img' src='img/PlayersWantedRedv1.png'>
					<p class='left_panel_text'>The club has a thriving Saturday league team and Sunday friendlies team.</p>
					<p class='left_panel_text'>We welcome players of all ages and abilities and would be glad to see fresh faces. 
					All players and their families are most welcome and we look forward to seeing many of you at the matches.</p>
					<p class='left_panel_text'>If you are interested in joining please contact.</p>
					<p class='left_panel_text'>
					<b>Chairman<br>
					Ray Balcombe</b><br>
					Tel: 01277 899141<br>
					Email:ray@technicaldramadesign.co.uk
					</p>

					<p class='left_panel_text'>
					<b>Secretary<br>
					Kevin Jordan</b><br>
					Tel: 07704 139359<br>
					Email: kevin.jordan1@btinternet.com
					</p>

					<p class='left_panel_text'>
					<b>Subscriptions:</b><br>
					Seniors £60<br>
					Students £30<br>
					Colts £40 family<br>
					</p>
					
					<p class='left_panel_text'>
					<b>Match Fees</b><br>
					Seniors £10<br>
					Students £6<br>
					Colts £2
					</p>
					
					<p class='left_panel_text'>
					<b>Outdoor Practice Nights at the club</b><br>
					Seniors Tuesday evening<br>
					Colts Wednesday evening<br>
					</p>
				</div>
				<div class='right_panel'>
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