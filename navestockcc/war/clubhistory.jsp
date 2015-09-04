<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="navwidgets" uri="WEB-INF/tld/Widget.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Navestock Cricket Club History"/>
<meta name="keywords" content="Navestock, Cricket Club, Navestockcc, History" />
<meta http-equiv="content-language" content="en" />
 <link type="text/css" rel="stylesheet" href="../CSS/Navestockcc.css">
 <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" /> 
<title>Navestock Cricket Club Home</title>
</head>
    <body>
    
    	<div class='page_container'>
			<jsp:include page="banner.jsp" />
			<div class='content'>
				<div class='left_panel'>
					<img class='splash_img' src='img/Splashv2.jpg'>
					<p class='left_panel_heading'>EARLY HISTORY OF CRICKET AT NAVESTOCK</p>
					<p class='left_panel_text'>Navestock has a rich history dating back almost 250 years.</p> 
					<p class='left_panel_text'>One of the most famous Essex grounds. Navestock together with Hornchurch and Stock served as the usual grounds 
					for matches between ESSEX and KENT. Records show three instances of play there before 1784.</p> 
					<p class='left_panel_text'>The earliest of these dates is the rumour-type report dated 23rd. September 1768. 
					It is worth reproducing in full, if only because of its charming language.</p>
					<p class='left_panel_text'><i>“We hear that there will be a match of Cricket played on Saturday next, at the Green Man On Navestock Common, 
					between the Gentlemen of Epping and the Gentlemen of Brentwood. The wickets will be pitched at 11 o'clock and the match to be played out.”</i></p>
					<p class='left_panel_text'>Six years later (1774) a loosely worded advertisement in the Chelmsford Chronicle again refers to famous ground at Navestock. 
					Here it is in full:</p>
					<p class='left_panel_text'><i>“This is to give notice, that on Monday next, the 20th. Instant, there will be played a match at cricket between 
					two of the best elevens in Essex. For a considerable sum of money, at The Green Man at Navestock Common. The wickets will be pitched at Ten o'clock.”</i></p>
					<p class='left_panel_text'>Further report show on August 26th.1783, a match was played at Mrs Barkers at the Green Man at Navestock Between Hornchurch and 
					Ingatestone, for a Guinea a man.</p>
					<p class='left_panel_text'>August 1793 notice is given in the Chelmsford Chronicle of a giant game arranged between fifty from Essex and Hertfordshire, 
					and the All England Eleven.</p>
					<p class='left_panel_text'>Notice of the match to be held at Navestock on the 19th Of August 1793, was given, in two separate issues of 
					The CHELMSFORD CHRONICAL, but no result ever appeared. The notice read as follows:</p>
					<p class='left_panel_text'><i>“ELEVEN ALL ENGLAND against FIFTY ESSEX and HERTFORDSHIRE</i></p>
					<p class='left_panel_text'><i>For £500 to be played on Monday the 19th. Instant, at the Green Man, Navestock. Wickets to be pitched at 10 o'clock.</i></p>
					<p class='left_panel_text'>Later it was reported one more that:</p>
					<p class='left_panel_text'><i>“As it may afford pleasure to the amateurs of cricket and to many of our readers to know The first eleven players in the world, 
					the following are judged to be them: -T. Walker H. Walker Beldham Ring Small jun. Boxall Freemantle Hammond Wells Purchase Harris.</i></p>
					<p class='left_panel_text'><i>They are to play 50 cricketers taken from the Counties of Essex and Hertfordshire and 6 to 4 are betted in their favour.”</i></p>
					<p class='left_panel_text'>A venerable cricketing site indeed is the Green Man ground at Navestock. Perhaps one of the oldest in England with a continuous history of matches.</p>

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