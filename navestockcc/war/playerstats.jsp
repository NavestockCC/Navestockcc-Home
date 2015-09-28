<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="navwidgets" uri="WEB-INF/tld/Widget.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Match schedule"/>
<meta name="keywords" content="Navestock, Cricket Club, Navestockcc, Match Schedule, Fixture List" />
<meta http-equiv="content-language" content="en" />
 <link type="text/css" rel="stylesheet" href="../CSS/Navestockcc.css">
 <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" /> 
<title>Navestock Cricket Club Match Schedule</title>

    <!--Load the AJAX API. Do this only once per web page! -->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1', {'packages':['corechart', 'table']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);


      // Callback that creates and populates a data table, 
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

      // Create the data table.
	  	/* <navwidgets:PlayerDataTable playerId="${param['pId']}"/> */
var playerData = new google.visualization.DataTable();
playerData.addColumn({id: 'idMatch', label: 'Match Id', type: 'number'});
playerData.addColumn({id: 'oppositionTeamId', label: 'Opposition Team Id', type: 'number'});
playerData.addColumn({id: 'oppositionName', label: 'Opposition', type: 'string'});
playerData.addColumn({id: 'matchDate', label: 'Match Date', type: 'date'});
playerData.addColumn({id: 'idTeamWinning', label: 'Winning Team Id', type: 'number'});
playerData.addColumn({id: 'winningTeamName', label: 'Winning Team', type: 'string'});
playerData.addColumn({id: 'resultDescription', label: 'Result', type: 'string'});
playerData.addColumn({id: 'idPlayer', label: 'Player Id', type: 'number'});
playerData.addColumn({id: 'playerName', label: 'Player', type: 'string'});
playerData.addColumn({id: 'idNavestockTeam', label: 'Navestock Team Id', type: 'number'});
playerData.addColumn({id: 'NavestockTeamName', label: 'Navestock Team', type: 'string'});
playerData.addColumn({id: 'batingOrder', label: 'Batting at', type: 'number'});
playerData.addColumn({id: 'runsScored', label: 'Runs Scored', type: 'number'});
playerData.addColumn({id: 'idHowOut', label: 'How Out Id', type: 'number'});
playerData.addColumn({id: 'howOutDescription', label: 'How Out', type: 'string'});
playerData.addColumn({id: 'oversBowled', label: 'Overs Bowled', type: 'number'});
playerData.addColumn({id: 'wickets', label: 'Wickets', type: 'number'});
playerData.addColumn({id: 'runsConseded', label: 'Runs Conseded', type: 'number'});
playerData.addRow([128,83, 'South Weald : Sunday XI',new Date('2015, 4, 26'), 83, 'South Weald : Sunday XI', 'South Weald : Sunday XI won by 31 runs',22, 'Phil Sergeant',1, 'Sunday XI', 5, 8, 2, 'Caught', 0, 0, 0]);
playerData.addRow([131,10, 'Woodham Mortimer : Sunday XI',new Date('2015, 5, 17'), -3, 'Fixture : drawn.', 'Draw',22, 'Phil Sergeant',1, 'Sunday XI', 4, 22, 2, 'Caught', 2, 0, 26]);
playerData.addRow([132,11, 'Hainault & Clayhall : Sunday XI',new Date('2015, 5, 24'), 11, 'Hainault & Clayhall : Sunday XI', 'Hainault & Clayhall : Sunday XI won by 84 runs',22, 'Phil Sergeant',1, 'Sunday XI', 3, 31, 1, 'Bowled', 0, 0, 0]);
playerData.addRow([134,13, 'South Fambridge : Sunday XI',new Date('2015, 6, 7'), 13, 'South Fambridge : Sunday XI', 'South Fambridge : Sunday XI won by 161 runs',22, 'Phil Sergeant',1, 'Sunday XI', 1, 9, 1, 'Bowled', 0, 0, 0]);
playerData.addRow([136,80, 'Shakespeare : Sunday XI',new Date('2015, 6, 21'), 80, 'Shakespeare : Sunday XI', 'Shakespeare : Sunday XI won by 5 wickets',22, 'Phil Sergeant',1, 'Sunday XI', 1, 13, 2, 'Caught', 1, 0, 4]);
playerData.addRow([137,15, 'Navestock : Presidents XI',new Date('2015, 6, 28'), 15, 'Navestock : Presidents XI', 'Navestock : Presidents XI won by 42 runs',22, 'Phil Sergeant',1, 'Sunday XI', 2, 0, 1, 'Bowled', 0, 0, 0]);
playerData.addRow([139,18, 'Shenfield : Sunday XI',new Date('2015, 7, 12'), -3, 'Fixture : drawn.', 'Draw',22, 'Phil Sergeant',1, 'Sunday XI', 3, 50, -2, 'Retired not out', 1, 1, 1]);
playerData.addRow([163,83, 'South Weald : Sunday XI',new Date('2015, 7, 19'), 83, 'South Weald : Sunday XI', 'South Weald : Sunday XI won by 164 runs',22, 'Phil Sergeant',1, 'Sunday XI', 1, 24, 1, 'Bowled', 1, 0, 7]);
playerData.addRow([143,21, 'Woodcutters : Sunday XI',new Date('2015, 8, 16'), 21, 'Woodcutters : Sunday XI', 'Woodcutters : Sunday XI won by 5 wickets',22, 'Phil Sergeant',1, 'Sunday XI', 4, 7, 2, 'Caught', 0, 0, 0]);
playerData.addRow([144,22, 'Abridge : Sunday XI',new Date('2015, 8, 23'), 22, 'Abridge : Sunday XI', 'Abridge : Sunday XI won by 8 Wickets',22, 'Phil Sergeant',1, 'Sunday XI', 2, 1, 1, 'Bowled', 0, 0, 0]);
playerData.addRow([145,19, 'Eastonians : Sunday XI',new Date('2015, 9, 6'), 19, 'Eastonians : Sunday XI', 'Eastonians : Sunday XI won by 150 runs',22, 'Phil Sergeant',1, 'Sunday XI', 3, 11, 2, 'Caught', 0, 0, 0]);
playerData.addRow([147,23, 'Rayleigh : Sunday XI',new Date('2015, 9, 27'), 23, 'Rayleigh : Sunday XI', 'Rayleigh : Sunday XI won by 8 wickets',22, 'Phil Sergeant',1, 'Sunday XI', 4, 0, 2, 'Caught', 0, 0, 0]);	  	

		var tblView = new google.visualization.DataView(playerData);
		tblView.setColumns([2,3,6,11,12,14,15,16,17]);
		
		var seasonView = new google.visualization.DataView(playerData);
		//seasonView.setColumns([3, 12, 12]);
		seasonView.setColumns([3, 12,{calc:runsSC, type:'string', role:'annotation'}]);
		function runsSC(dataTable, rowNum){
		  return "(" + dataTable.getValue(rowNum, 12)+ ")" ;
		}

	    var seasonOptions = {
	    	      title : 'Season',
	    	      height:450,
	    	      vAxis: {title: 'Runs'},
	    	      //ticks: [new Date('2015-04-26'), new Date('2015-05-17'), new Date('2015-05-24'), new Date('2015-06-07'), new Date('2015-06-21'), new Date('2015-06-28'), new Date('2015-07-12'), new Date('2015-07-19'), new Date('2015-08-16'), new Date('2015-08-23'), new Date('2015-09-06'), new Date('2015-09-27')]
	    	      hAxis: {title: 'Match',
	    	    	  	  slantedText:'True', 
	    	    	  	  slantedTextAngle:50, 
	    	    	  	  textPosition:'out',
	    	    	  	  viewWindowMode:'maximized'
	    	      		},
	    	      annotations:{alwaysOutside:'true',
	    	    	  		   slantedText:'true',
	    	    	  		   slantedTextAngle:90},
	    	      seriesType: 'bars',
	    	      legend:{position:'none'}
	    	    };

		
		var howOutView = google.visualization.data.group(
				  playerData,
				  [14],
				  [{'column': 13, 'aggregation': google.visualization.data.count, 'type': 'number'}]
				);
		
		

      // Instantiate and draw our chart, passing in some options.
      var tblchart = new google.visualization.Table(document.getElementById('table_div'));
      tblchart.draw(tblView);
      
      var howoutchart = new google.visualization.PieChart(document.getElementById('howout_div'));
      howoutchart.draw(howOutView);
      
      var howoutchart = new google.visualization.ComboChart(document.getElementById('season_div'));
      howoutchart.draw(seasonView, seasonOptions);}
    </script>
    
</head>
    <body>
    	<div class='page_container'>
			<jsp:include page="banner.jsp" />
			<div class='content'>
				<div id="table_div"></div>
				<br>
				<div id="howout_div"></div>
				<br>
				<div id="season_div"></div>
			</div>
		</div>	
    <jsp:include page="navestockccjs/analitics.js" />	
    </body>
</html>