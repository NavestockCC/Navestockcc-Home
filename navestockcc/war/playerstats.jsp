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

      // Create the data table
      <navwidgets:PlayerDataTable playerId="${param['pId']}"/>
/*     var playerData = new google.visualization.DataTable();
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
      playerData.addColumn({id: 'battingAvg', label: 'Batting Avrage', type: 'number'});
      playerData.addColumn({id: 'resultTooltip', label: 'Result', type: 'string', 'role': 'tooltip', 'p': {'html': true}});
      playerData.addRow([128,83, 'South Weald : Sunday XI',new Date('2015, 4, 26'), 83, 'South Weald : Sunday XI', '<table><tr><td>South Weald : Sunday XI 173/6</td></tr><tr><td>Sunday XI 142/7</td></tr><tr><td>South Weald : Sunday XI won by 31 runs</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 5, 8, 2, 'Caught', 0, 0, 0, 16, '<table><tr><td>South Weald : Sunday XI 173/6</td></tr><tr><td>Sunday XI 142/7</td></tr><tr><td>South Weald : Sunday XI won by 31 runs</td></tr></table>']);
      playerData.addRow([131,10, 'Woodham Mortimer : Sunday XI',new Date('2015, 5, 17'), -3, 'Fixture : drawn.', '<table><tr><td>Woodham Mortimer : Sunday XI 286/5</td></tr><tr><td>Sunday XI 134/5</td></tr><tr><td>Draw</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 4, 22, 2, 'Caught', 2, 0, 26, 16, '<table><tr><td>Woodham Mortimer : Sunday XI 286/5</td></tr><tr><td>Sunday XI 134/5</td></tr><tr><td>Draw</td></tr></table>']);
      playerData.addRow([132,11, 'Hainault & Clayhall : Sunday XI',new Date('2015, 5, 24'), 11, 'Hainault & Clayhall : Sunday XI', '<table><tr><td>Hainault & Clayhall : Sunday XI 212/5</td></tr><tr><td>Sunday XI 128/10</td></tr><tr><td>Hainault & Clayhall : Sunday XI won by 84 runs</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 3, 31, 1, 'Bowled', 0, 0, 0, 16, '<table><tr><td>Hainault & Clayhall : Sunday XI 212/5</td></tr><tr><td>Sunday XI 128/10</td></tr><tr><td>Hainault & Clayhall : Sunday XI won by 84 runs</td></tr></table>']);
      playerData.addRow([134,13, 'South Fambridge : Sunday XI',new Date('2015, 6, 7'), 13, 'South Fambridge : Sunday XI', '<table><tr><td>South Fambridge : Sunday XI 294/5</td></tr><tr><td>Sunday XI 133/5</td></tr><tr><td>South Fambridge : Sunday XI won by 161 runs</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 1, 9, 1, 'Bowled', 0, 0, 0, 16, '<table><tr><td>South Fambridge : Sunday XI 294/5</td></tr><tr><td>Sunday XI 133/5</td></tr><tr><td>South Fambridge : Sunday XI won by 161 runs</td></tr></table>']);
      playerData.addRow([136,80, 'Shakespeare : Sunday XI',new Date('2015, 6, 21'), 80, 'Shakespeare : Sunday XI', '<table><tr><td>Shakespeare : Sunday XI 155/5</td></tr><tr><td>Sunday XI 154/8</td></tr><tr><td>Shakespeare : Sunday XI won by 5 wickets</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 1, 13, 2, 'Caught', 1, 0, 4, 16, '<table><tr><td>Shakespeare : Sunday XI 155/5</td></tr><tr><td>Sunday XI 154/8</td></tr><tr><td>Shakespeare : Sunday XI won by 5 wickets</td></tr></table>']);
      playerData.addRow([137,15, 'Navestock : Presidents XI',new Date('2015, 6, 28'), 15, 'Navestock : Presidents XI', '<table><tr><td>Navestock : Presidents XI 212/8</td></tr><tr><td>Sunday XI 170/8</td></tr><tr><td>Navestock : Presidents XI won by 42 runs</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 2, 0, 1, 'Bowled', 0, 0, 0, 16, '<table><tr><td>Navestock : Presidents XI 212/8</td></tr><tr><td>Sunday XI 170/8</td></tr><tr><td>Navestock : Presidents XI won by 42 runs</td></tr></table>']);
      playerData.addRow([139,18, 'Shenfield : Sunday XI',new Date('2015, 7, 12'), -3, 'Fixture : drawn.', '<table><tr><td>Shenfield : Sunday XI 182/8</td></tr><tr><td>Sunday XI 263/3</td></tr><tr><td>Draw</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 3, 50, -2, 'Retired not out', 1, 1, 1, 16, '<table><tr><td>Shenfield : Sunday XI 182/8</td></tr><tr><td>Sunday XI 263/3</td></tr><tr><td>Draw</td></tr></table>']);
      playerData.addRow([163,83, 'South Weald : Sunday XI',new Date('2015, 7, 19'), 83, 'South Weald : Sunday XI', '<table><tr><td>South Weald : Sunday XI 330/8</td></tr><tr><td>Sunday XI 166/10</td></tr><tr><td>South Weald : Sunday XI won by 164 runs</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 1, 24, 1, 'Bowled', 1, 0, 7, 16, '<table><tr><td>South Weald : Sunday XI 330/8</td></tr><tr><td>Sunday XI 166/10</td></tr><tr><td>South Weald : Sunday XI won by 164 runs</td></tr></table>']);
      playerData.addRow([143,21, 'Woodcutters : Sunday XI',new Date('2015, 8, 16'), 21, 'Woodcutters : Sunday XI', '<table><tr><td>Woodcutters : Sunday XI 120/5</td></tr><tr><td>Sunday XI 115/10</td></tr><tr><td>Woodcutters : Sunday XI won by 5 wickets</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 4, 7, 2, 'Caught', 0, 0, 0, 16, '<table><tr><td>Woodcutters : Sunday XI 120/5</td></tr><tr><td>Sunday XI 115/10</td></tr><tr><td>Woodcutters : Sunday XI won by 5 wickets</td></tr></table>']);
      playerData.addRow([144,22, 'Abridge : Sunday XI',new Date('2015, 8, 23'), 22, 'Abridge : Sunday XI', '<table><tr><td>Abridge : Sunday XI 144/2</td></tr><tr><td>Sunday XI 141/5</td></tr><tr><td>Abridge : Sunday XI won by 8 Wickets</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 2, 1, 1, 'Bowled', 0, 0, 0, 16, '<table><tr><td>Abridge : Sunday XI 144/2</td></tr><tr><td>Sunday XI 141/5</td></tr><tr><td>Abridge : Sunday XI won by 8 Wickets</td></tr></table>']);
      playerData.addRow([145,19, 'Eastonians : Sunday XI',new Date('2015, 9, 6'), 19, 'Eastonians : Sunday XI', '<table><tr><td>Eastonians : Sunday XI 308/3</td></tr><tr><td>Sunday XI 158/8</td></tr><tr><td>Eastonians : Sunday XI won by 150 runs</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 3, 11, 2, 'Caught', 0, 0, 0, 16, '<table><tr><td>Eastonians : Sunday XI 308/3</td></tr><tr><td>Sunday XI 158/8</td></tr><tr><td>Eastonians : Sunday XI won by 150 runs</td></tr></table>']);
      playerData.addRow([147,23, 'Rayleigh : Sunday XI',new Date('2015, 9, 27'), 23, 'Rayleigh : Sunday XI', '<table><tr><td>Rayleigh : Sunday XI 138/3</td></tr><tr><td>Sunday XI 137/10</td></tr><tr><td>Rayleigh : Sunday XI won by 8 wickets</td></tr></table>',22, 'Phil Sergeant',1, 'Sunday XI', 4, 0, 2, 'Caught', 0, 0, 0, 16, '<table><tr><td>Rayleigh : Sunday XI 138/3</td></tr><tr><td>Sunday XI 137/10</td></tr><tr><td>Rayleigh : Sunday XI won by 8 wickets</td></tr></table>']);
      var playerBattingAvgData = new google.visualization.DataTable();
      playerBattingAvgData.addColumn({id: 'idPlayer', label: 'Player Id', type: 'number'});
      playerBattingAvgData.addColumn({id: 'playerName', label: 'Player', type: 'string'});
      playerBattingAvgData.addColumn({id: 'idNavestockTeam', label: 'Navestock Team Id', type: 'number'});
      playerBattingAvgData.addColumn({id: 'NavestockTeamName', label: 'Navestock Team', type: 'string'});
      playerBattingAvgData.addColumn({id: 'statYear', label: 'Year', type: 'number'});
      playerBattingAvgData.addColumn({id: 'runsScored', label: 'Runs', type: 'number'});
      playerBattingAvgData.addColumn({id: 'nInnings', label: 'Innings', type: 'number'});
      playerBattingAvgData.addColumn({id: 'outCount', label: 'Out', type: 'number'});
      playerBattingAvgData.addColumn({id: 'battingAvg', label: 'Avg', type: 'number'});
      playerBattingAvgData.addRow([22, 'Phil Sergeant', 1, 'Sunday XI', 2015, 176, 12, 11, 16]);
	*/      

//Season summary table		
		var tblView = new google.visualization.DataView(playerData);
		tblView.setColumns([3,2,6,11,12,14]);
		
		var tblViewOptions = {
				allowHtml:true				
		};
		
		
		
		
//Battingstats bar chart		
		var seasonView = new google.visualization.DataView(playerData);
		seasonView.setColumns(['matchDate', 'runsScored', {calc:runsSC, type:'string', role:'annotation'}, {calc:resultsTxt, type:'string', role:'annotationText'}, 'resultTooltip', 'battingAvg']);
		
	    var seasonOptions = {
	    	      title :  playerData.getValue(0, 8) + ' Batting Statistics',
	    	      height:450,
	    	      allowHtml:true,
	    	      tooltip: { isHtml: true },
	    	      vAxis: {title: 'Runs'},
	    	      hAxis: {title: 'Match',
	    	    	      gridlines : {color:'#FFFFFF'},
	    	    	      ticks: playerData.getDistinctValues(3),
	    	    	  	  slantedText:'True',
	    	    	  	  showTextEvery : 1,
	    	    	  	  slantedTextAngle:50, 
	    	    	  	  textPosition:'out',
	    	    	  	  viewWindowMode:'maximized',
	    	    	  	  format: 'd MMM'
	    	      		},		
	    	      annotations:{alwaysOutside:'true',
	    	    	  		   },
	    	     seriesType: 'bars', 
	    	     series: {
	    	    	 0: {type: 'bars',
	    	    		  visibleInLegend: 'false'
	    	    	 },
	    	    	 1: {type: 'line',
	    	    		 visibleInLegend: 'true',
	    	    		 labelInLegend: 'Average: ' + playerData.getValue(0, 18)
	    	    		  }
	    	    	  		   },
	    	      legend:{position:'right',
	    	    	      alignment:'center'}
	    		};

//Batting averages table
		var tblBatAvg = new google.visualization.DataView(playerBattingAvgData);
		tblBatAvg.setColumns(['statYear', 'NavestockTeamName', 'runsScored', 'nInnings', 'battingAvg']);
		
		var tblBatAvgOptions = {
				allowHtml:true				
		};
	    
	    
//How out bowling analysis		
		var howOutView = google.visualization.data.group(
				  playerData,
				  [14],
				  [{'column': 13, 'aggregation': google.visualization.data.count, 'type': 'number'}]
				);
		
		var howOutViewOptions = {
				title: 'Dismisal Analysis',
		          pieHole: 0.3,
		};
		
		
		
		
		

      // Instantiate and draw our chart, passing in some options.
      var tblchart = new google.visualization.Table(document.getElementById('table_div'));
      tblchart.draw(tblView, tblViewOptions);
     
      var tblBatAvgchart = new google.visualization.Table(document.getElementById('tableBAtAvg_div'));
      tblBatAvgchart.draw(tblBatAvg, tblBatAvgOptions);
      
      
      var howoutchart = new google.visualization.PieChart(document.getElementById('howout_div'));
      howoutchart.draw(howOutView, howOutViewOptions);
      
      var seasonchart = new google.visualization.ComboChart(document.getElementById('season_div'));
      seasonchart.draw(seasonView, seasonOptions);
      }
      
		function runsSC(dataTable, rowNum){
			  return " " + dataTable.getValue(rowNum, 12)+ " " ;
			}
		
		function resultsTxt(dataTable, rowNum){
			  return " " + dataTable.getValue(rowNum, 19)+ " " ;
			}
    </script>
    
</head>
    <body>
    	<div class='page_container'>
			<jsp:include page="banner.jsp" />
			<div class='content'>
				<div id="season_div" style="width: 100%"></div>
				<br>
				<div id="tableBAtAvg_div" style="width: 49%"></div>
				<div id="howout_div" style="width: 49%"></div>
				<br>
				<div id="table_div"></div>
				<br>
				
				<br>
				
			</div>
		</div>		
    </body>
</html>