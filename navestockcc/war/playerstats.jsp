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
		<navwidgets:PlayerDataTable playerId="${param['pId']}"/>

		
		var tblView = new google.visualization.DataView(playerData);
		tblView.setColumns([3,2,6,11,12,14]);
		
		var tblViewOptions = {
				allowHtml:true				
		};
		
		var seasonView = new google.visualization.DataView(playerData);
		seasonView.setColumns([3, 12,{calc:runsSC, type:'string', role:'annotation'},18]);
		
		function runsSC(dataTable, rowNum){
		  return " " + dataTable.getValue(rowNum, 12)+ " " ;
		}
		
	    var seasonOptions = {
	    	      title :  playerData.getValue(0, 8) + ' Batting Statistics',
	    	      height:450,
	    	      // Use an HTML tooltip.
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
      tblchart.draw(tblView, tblViewOptions);
      
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
				<div id="season_div"></div>
				<br>
				<br>
				<div id="table_div"></div>
				<br>
				<div id="howout_div"></div>
				<br>
				
			</div>
		</div>	
    <jsp:include page="navestockccjs/analitics.js" />	
    </body>
</html>