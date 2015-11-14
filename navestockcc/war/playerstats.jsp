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

// *************** Season summary table	***************	
		var tblView = new google.visualization.DataView(playerData);
		tblView.setColumns([3,2,6,11,12,14]);
		
		var tblViewOptions = {
				allowHtml:true				
		};
		
// *************** Battingstats bar chart ***************
		var seasonView = new google.visualization.DataView(playerData);
		seasonView.setColumns([{sourceColumn:'matchDate', type:'date', role:'domain'}, {sourceColumn:'runsScored', type:'number', role:'data'}, {calc:runsSC, type:'string', role:'annotation'}, {calc:resultsTxt, type:'string', role:'annotationText'}, 'resultTooltip', {sourceColumn:'battingAvg', type:'number', role:'data'}]);
		
	    var seasonOptions = {	    	  
	    		  title :  playerData.getValue(0, 8),
	    	      height:450,
	    	      allowHtml:true,
	    	      tooltip: { isHtml: true },  
	    	      vAxis: {title: 'Runs'},
	    	      hAxis: {title: 'Match',
	    	    	  	  ticks: seasonView.getDistinctValues(0),
	    	    	      gridlines : {color:'#FFFFFF'},
	    	    	  	  slantedText:'True',
	    	    	  	  showTextEvery : 1,
	    	    	  	  slantedTextAngle:50, 
	    	    	  	  textPosition:'out',
	    	    	  	  viewWindowMode:'maximized',
	    	    	  	  format:'d MMM, yy'
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
	    
		function runsSC(dataTable, rowNum){
			var txtReturn = "";
			if(dataTable.getValue(rowNum, 13) == -1){
				txtReturn =  "DNB"; 
				} else if(dataTable.getValue(rowNum, 13) == 0 || dataTable.getValue(rowNum, 13) == -2 ){
				txtReturn =  " " + dataTable.getValue(rowNum, 12)+ "*" ; 
				} 
				else {
					txtReturn =  " " + dataTable.getValue(rowNum, 12)+ " " ; 
				}		
		  	return txtReturn;
			}

		function resultsTxt(dataTable, rowNum){
			  return " " + dataTable.getValue(rowNum, 2)+ " " ;
			}
		
		//calculate Batting average
		function avgBatting(dataTable, rowNum){
			
			
		  	//Get the max wixket taken from the function bowlingGroupby
			var MaxWikets = dataTable.getValue(rowNum, 5);
		    var MinRuns = 999;
		    var Oposition = "";
		    //get the rowindexes of the max values which match in the main datatable 'playerData', match on MaxWicket, year and team
		    var maxRowIndexs = playerData.getFilteredRows([{column: 16, value: MaxWikets}, {column: 3, minValue: new Date(dataTable.getValue(rowNum, 0), 1,1), maxValue: new Date(dataTable.getValue(rowNum, 0), 12,31)}, {column: 10, value: dataTable.getValue(rowNum, 1)}]);
		    //for each row index find the least number of runs conceded.
		    for (i = 0; i < maxRowIndexs.length; i++) { 
		    	if(MinRuns > playerData.getValue(maxRowIndexs[i], 17)){MinRuns = playerData.getValue(maxRowIndexs[i], 17); Oposition=playerData.getValue(maxRowIndexs[i], 2);}	    
				}
		    //return the best figures as string
		    return MaxWikets + "/" + MinRuns + " v " + Oposition
			}
	    

//*************** Batting averages table ***************
		var tblBatAvg = new google.visualization.DataView(playerBattingAvgData);
		tblBatAvg.setColumns(['statYear', 'NavestockTeamName', 'runsScored', 'nInnings', 'battingAvg']);
		
		var tblBatAvgOptions = {
				width:'500',
				allowHtml:true				
		};
	    
	    
//*************** Dismisal Analysis chart ***************	
		var howOutView = google.visualization.data.group(
				  playerData,
				  [14],
				  [{'column': 13, 'aggregation': google.visualization.data.count, 'type': 'number'}]
					);
		
		var howOutViewOptions = {
		          pieHole: 0.3,
				};
		
//*************** Bowling Stats bubble chart ***************
	var tblBowlingWickRuns = new google.visualization.DataView(playerData);
		tblBowlingWickRuns.setColumns(['oppositionName', 'runsConseded', 'wickets', 'oppositionName', 'oversBowled']);
		tblBowlingWickRuns.setRows(tblBowlingWickRuns.getFilteredRows([{column: 4, minValue: 1}]));
	
		var BowlingWickRunsOptions = {
				titleTextStyle:{fontSize:18},
				height: '500',
	    	    hAxis: {title: 'Runs Conceded'},
				vAxis: {title: 'Wickets',
						viewWindowMode : 'explicit',
						viewWindow:{min:'-1'},
						ticks: [-1,0,1,2,3,4,5]
						},
				bubble: {
					textStyle:{
						color: 'none',
						fontSize:'10'
							}
						},
				sizeAxis: {minValue: 1,
						   minSize: 5,
						   maxValue: 10,
						   maxSize: 35,
						   },
				legend: {position:'top',
						 alignment:'center',
						 maxLines: 6,
						 textStyle: {fontSize:11}
						 }
					};
		
//*************** Bowling Stats table chart ***************
	//Data view created from the function bowlingGroupby() and the functions. 
	var tblBowlingStats = new google.visualization.DataView(bowlingGroupby(playerData));
		tblBowlingStats.setColumns([0,1,2,3,4,{calc:bowlingAvg, type:'string', label:'Average', 'p': {'html': true}}, {calc:bowlingEconomy, type:'string', label:'Economy Rate', 'p': {'html': true}}, {calc:strikeRate, type:'string', label:'Strike Rate', 'p': {'html': true}}, {calc:bestBowling, type:'string', label:'Best', 'p': {'html': true}}]);    
    
	var tblBowlingStatsOptions = {
		allowHtml:true				
		};
	
    //Agregate the data per year per team and sum the stats
	function bowlingGroupby(value) {
  		return google.visualization.data.group(value, [{column:3, modifier:statYear, type:'number', label: 'Season'},10], [{'column': 15, 'aggregation': google.visualization.data.sum, 'type': 'number'}, {'column': 16, 'aggregation': google.visualization.data.sum, 'type': 'number'}, {'column': 17, 'aggregation': google.visualization.data.sum, 'type': 'number'}, {'column': 16, 'aggregation': google.visualization.data.max, 'type': 'number'}]);
		}   
    
	//Calculate strike rate, number of ball bowled per wociket
	function strikeRate(dataTable, rowNum){
		var ret = ""
			if(dataTable.getValue(rowNum, 3)>0){
				var stat = (dataTable.getValue(rowNum, 2)*6)/dataTable.getValue(rowNum, 3);
				var onedecimcalFormat = new google.visualization.NumberFormat(
			    	{fractionDigits:'1'});
				ret = "<div style=\"text-align:center;\">" + onedecimcalFormat.formatValue(stat) + "</div>";
				} 
			else{
				ret = "<div style=\"text-align:center;\">-</div>";
				}
		return ret;
		}
	//calculate bowling avergage, number of runs conceded per wicket
	function bowlingAvg(dataTable, rowNum){
		var ret = ""
			if(dataTable.getValue(rowNum, 3)>0){
				var stat = dataTable.getValue(rowNum, 4)/dataTable.getValue(rowNum, 3);
				var onedecimcalFormat = new google.visualization.NumberFormat(
				    {fractionDigits:'1'});		
				ret = "<div style=\"text-align:center;\">" + onedecimcalFormat.formatValue(stat) + "</div>";
			} 
			else{
				ret = "<div style=\"text-align:center;\">-</div>";
				}
		return ret;
		}
	//calculate bowling economy rate, number of runs conceded per over.
	function bowlingEconomy(dataTable, rowNum){
    	var stat = dataTable.getValue(rowNum, 4)/dataTable.getValue(rowNum, 2);
    	var onedecimcalFormat = new google.visualization.NumberFormat(
			    {fractionDigits:'1'});		
		return "<div style=\"text-align:center;\">" + onedecimcalFormat.formatValue(stat) + "</div>";
		}
	//calculate Best Bowling figures
	function bestBowling(dataTable, rowNum){
	  	//Get the max wixket taken from the function bowlingGroupby
		var MaxWikets = dataTable.getValue(rowNum, 5);
	    var MinRuns = 999;
	    var Oposition = "";
	    //get the rowindexes of the max values which match in the main datatable 'playerData', match on MaxWicket, year and team
	    var maxRowIndexs = playerData.getFilteredRows([{column: 16, value: MaxWikets}, {column: 3, minValue: new Date(dataTable.getValue(rowNum, 0), 1,1), maxValue: new Date(dataTable.getValue(rowNum, 0), 12,31)}, {column: 10, value: dataTable.getValue(rowNum, 1)}]);
	    //for each row index find the least number of runs conceded.
	    for (i = 0; i < maxRowIndexs.length; i++) { 
	    	if(MinRuns > playerData.getValue(maxRowIndexs[i], 17) && playerData.getValue(maxRowIndexs[i], 17) != 0 ){MinRuns = playerData.getValue(maxRowIndexs[i], 17); Oposition=playerData.getValue(maxRowIndexs[i], 2);}	    
			}
	    if(MinRuns == 999){MinRuns = 0;}
	    //return the best figures as string
	    return "<div style=\"text-align:center;\">" + MaxWikets + "/" + MinRuns + " v " + Oposition + "</div>";
		}
	//Return the Year
	function statYear(someDate){
			return someDate.getFullYear();
		}

// *************** Bolwing details table	***************	
	var tblBowlingview = new google.visualization.DataView(playerData);
	tblBowlingview.setColumns([{sourceColumn:'matchDate', type:'date', role:'data', label:'Match Date'},{sourceColumn:'oppositionName', type:'string', role:'data', label:'Opposition'},6,{sourceColumn:'oversBowled', type:'number', role:'data', label:'O'},{sourceColumn:'wickets', type:'number', role:'data', label:'W'},{sourceColumn:'runsConseded', type:'number', role:'data', label:'R'}, {calc:bowlingAvgV1, type:'string', label:'Avg.', 'p': {'html': true}}, {calc:bowlingEconomyV1, type:'string', label:'Econ', 'p': {'html': true}}, {calc:strikeRateV1, type:'string', label:'Strike Rate', 'p': {'html': true}}]);
	tblBowlingview.setRows(tblBowlingview.getFilteredRows([{column: 3, minValue: 1}]));
	var tblBowlingviewOptions = {
			allowHtml:true				
	}; 	

	//Calculate strike rate, number of ball bowled per wicket
	function strikeRateV1(dataTable, rowNum){
		var ret = ""
		if(dataTable.getValue(rowNum, 16)>0){
			var stat = (dataTable.getValue(rowNum, 15)*6)/dataTable.getValue(rowNum, 16);
			var onedecimcalFormat = new google.visualization.NumberFormat(
				    {fractionDigits:'1'});
			ret = "<div style=\"text-align:center;\">" + onedecimcalFormat.formatValue(stat) + "</div>";
			} 
		else{
			ret = "<div style=\"text-align:center;\">-</div>";
			}
		return ret;
		}
	//calculate bowling avergage, number of runs conceded per wicket
	function bowlingAvgV1(dataTable, rowNum){
		var ret = ""
		if(dataTable.getValue(rowNum, 16)>0){
			var stat = dataTable.getValue(rowNum, 17)/dataTable.getValue(rowNum, 16);
			var onedecimcalFormat = new google.visualization.NumberFormat(
				    {fractionDigits:'1'});
			ret = "<div style=\"text-align:center;\">" + onedecimcalFormat.formatValue(stat) + "</div>";
			} 
		else{
			ret = "<div style=\"text-align:center;\">-</div>";
			}
		return ret;
		}
	//calculate bowling economy rate, number of runs conceded per over.
	function bowlingEconomyV1(dataTable, rowNum){
    	var stat = dataTable.getValue(rowNum, 17)/dataTable.getValue(rowNum, 15);
    	var onedecimcalFormat = new google.visualization.NumberFormat(
			    {fractionDigits:'1'});		
		return "<div style=\"text-align:center;\">" + onedecimcalFormat.formatValue(stat) + "</div>";
		}	
		
// *************** Instantiate and draw our chart *************** 
      var tblchart = new google.visualization.Table(document.getElementById('table_div'));
      tblchart.draw(tblView, tblViewOptions);
     
      var tblBatAvgchart = new google.visualization.Table(document.getElementById('tableBAtAvg_div'));
      	tblBatAvgchart.draw(tblBatAvg, tblBatAvgOptions);
      
      var howoutchart = new google.visualization.PieChart(document.getElementById('howout_div'));
      	howoutchart.draw(howOutView, howOutViewOptions);
      
      var seasonchart = new google.visualization.ComboChart(document.getElementById('season_div'));
      	seasonchart.draw(seasonView, seasonOptions);
      
      var chrtBowlingWickRuns = new google.visualization.BubbleChart(document.getElementById('bowling_div'));
		chrtBowlingWickRuns.draw(tblBowlingWickRuns, BowlingWickRunsOptions);
		
	  var tblBowlingStatschart = new google.visualization.Table(document.getElementById('tableBowlingStats_div'));
	  	tblBowlingStatschart.draw(tblBowlingStats, tblBowlingStatsOptions);
	  
	  var tblBowlingviewchart = new google.visualization.Table(document.getElementById('tableBowlingSeason_div'));
	  	tblBowlingviewchart.draw(tblBowlingview, tblBowlingviewOptions);	
      }
      

		
    </script>
    
</head>
    <body>
    	<div class='page_container'>
			<jsp:include page="banner.jsp" />
			<div class='content'>
				<h2>Batting Stats</h2><br>
				<h3>Averages:</h3>
				<div id="tableBAtAvg_div" style="width: 49%"></div>
				<br>
				<h3>Season Overview</h3>
				<div id="season_div" style="width: 100%"></div>
				<br>
				<h3>Dismisal Analysis</h3>
				<div id="howout_div" style="width: 500px; height: 300px"></div>
				<br>
				<h3>Innings Detail</h3>
				<div id="table_div"></div>
				<br>
				<br>
				<h2>Bowling Stats</h2><br>
				<h3>Averages:</h3>
				<div id="tableBowlingStats_div"></div><br>
				<h3>Season Overview</h3>
				<div id="bowling_div"></div><br>
				<h3>Innings Detail:</h3>
				<div id="tableBowlingSeason_div"></div>
				
				
			</div>
		</div>
	<jsp:include page="navestockccjs/analitics.js" />			
    </body>
</html>