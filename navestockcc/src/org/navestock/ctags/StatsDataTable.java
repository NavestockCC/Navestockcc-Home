package org.navestock.ctags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.navestock.stats.BattingStats;
import org.navestock.stats.PlayerStats;
import org.navestock.stats.PlayerStatsServices;


public class StatsDataTable extends SimpleTagSupport {
	
	private int PlayerId;

	public void setPlayerId(int playerId) {
		PlayerId = playerId;
	}
	
	public void doTag() throws JspException {

		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		SimpleDateFormat matchDateFormat = new SimpleDateFormat("yyyy, M, d");

		try {
			PlayerStatsServices PlyerSatServices = new PlayerStatsServices();
			List <PlayerStats> PlayerDataTbl = PlyerSatServices.getPlayerStats(PlayerId);
			
			if((PlayerDataTbl != null) && (!PlayerDataTbl.isEmpty())){	
			out.println("var playerData = new google.visualization.DataTable();");
			
			out.println("playerData.addColumn({id: 'idMatch', label: 'Match Id', type: 'number'});");
			out.println("playerData.addColumn({id: 'oppositionTeamId', label: 'Opposition Team Id', type: 'number'});");
			out.println("playerData.addColumn({id: 'oppositionName', label: 'Opposition', type: 'string'});");
			out.println("playerData.addColumn({id: 'matchDate', label: 'Match Date', type: 'date'});");
			out.println("playerData.addColumn({id: 'idTeamWinning', label: 'Winning Team Id', type: 'number'});");			
			out.println("playerData.addColumn({id: 'winningTeamName', label: 'Winning Team', type: 'string'});");
			out.println("playerData.addColumn({id: 'resultDescription', label: 'Result', type: 'string'});");
			out.println("playerData.addColumn({id: 'idPlayer', label: 'Player Id', type: 'number'});");
			out.println("playerData.addColumn({id: 'playerName', label: 'Player', type: 'string'});");
			out.println("playerData.addColumn({id: 'idNavestockTeam', label: 'Navestock Team Id', type: 'number'});");
			out.println("playerData.addColumn({id: 'NavestockTeamName', label: 'Navestock Team', type: 'string'});");
			out.println("playerData.addColumn({id: 'batingOrder', label: 'Batting at', type: 'number'});");
			out.println("playerData.addColumn({id: 'runsScored', label: 'Runs Scored', type: 'number'});");
			out.println("playerData.addColumn({id: 'idHowOut', label: 'How Out Id', type: 'number'});");
			out.println("playerData.addColumn({id: 'howOutDescription', label: 'How Out', type: 'string'});");
			out.println("playerData.addColumn({id: 'oversBowled', label: 'Overs Bowled', type: 'number'});");
			out.println("playerData.addColumn({id: 'wickets', label: 'Wickets', type: 'number'});");
			out.println("playerData.addColumn({id: 'runsConseded', label: 'Runs Conseded', type: 'number'});");
			out.println("playerData.addColumn({id: 'battingAvg', label: 'Batting Avrage', type: 'number'});");
			out.println("playerData.addColumn({id: 'resultTooltip', label: 'Result', type: 'string', 'role': 'tooltip', 'p': {'html': true}});");
			
			for (int i = 0; i < PlayerDataTbl.size(); i++){
			out.println("playerData.addRow("
							+ "[" + PlayerDataTbl.get(i).getIdMatch() + "," + PlayerDataTbl.get(i).getOppositionTeamId() + ", '"  + PlayerDataTbl.get(i).getOppositionName() + "'," + "new Date('" + matchDateFormat.format(PlayerDataTbl.get(i).getMatchDate())
							+ "'), " + PlayerDataTbl.get(i).getIdTeamWinning() + ", '" + PlayerDataTbl.get(i).getWinningTeamName() + "', '" +  PlayerDataTbl.get(i).getResult()
							+ "'," + PlayerDataTbl.get(i).getIdPlayer() + ", '" +  PlayerDataTbl.get(i).getFirstname() + " " + PlayerDataTbl.get(i).getLastname()
							+ "'," +  PlayerDataTbl.get(i).getIdTeam() + ", '" +  PlayerDataTbl.get(i).getTeamName() + "', " + PlayerDataTbl.get(i).getBatingOrder() 
							+ ", " + PlayerDataTbl.get(i).getRunsScored() + ", " + PlayerDataTbl.get(i).getIdHowOut()
							+ ", '" + PlayerDataTbl.get(i).getHowOutDescription() + "', " +  PlayerDataTbl.get(i).getOversBowled()
							+ ", " +  PlayerDataTbl.get(i).getWickets() + ", " +  PlayerDataTbl.get(i).getRunsConseded() + ", " + PlayerDataTbl.get(i).getBattingAvrage() + ", '" +  PlayerDataTbl.get(i).getResult() + "']"
							+ ");");
			}
		}
			List <BattingStats> BattingAvgTbl = PlyerSatServices.getPlayerBattingAvg(PlayerDataTbl);
			if((BattingAvgTbl != null) && (!BattingAvgTbl.isEmpty())){
				out.println("var playerBattingAvgData = new google.visualization.DataTable();");
				
				out.println("playerBattingAvgData.addColumn({id: 'idPlayer', label: 'Player Id', type: 'number'});");
				out.println("playerBattingAvgData.addColumn({id: 'playerName', label: 'Player', type: 'string'});");
				out.println("playerBattingAvgData.addColumn({id: 'idNavestockTeam', label: 'Navestock Team Id', type: 'number'});");
				out.println("playerBattingAvgData.addColumn({id: 'NavestockTeamName', label: 'Navestock Team', type: 'string'});");
				out.println("playerBattingAvgData.addColumn({id: 'statYear', label: 'Year', type: 'number'});");
				out.println("playerBattingAvgData.addColumn({id: 'runsScored', label: 'Runs', type: 'number'});");
				out.println("playerBattingAvgData.addColumn({id: 'nInnings', label: 'Innings', type: 'number'});");
				out.println("playerBattingAvgData.addColumn({id: 'outCount', label: 'Out', type: 'number'});");
				out.println("playerBattingAvgData.addColumn({id: 'battingAvg', label: 'Avg', type: 'number'});");
				
				for (BattingStats BS: BattingAvgTbl){
					out.println("playerBattingAvgData.addRow(["
							+ BS.getIdPlayer() + ", "
							+ "'" + BS.getPlayerName() + "', "
							+ BS.getIdTeam() + ", "
							+ "'" + BS.getTeamName() + "', "
							+ BS.getStatYear() + ", "
							+ BS.getRunsScored() + ", "
							+ BS.getnInnings() + ", "
							+ BS.getnOutCount() + ", "
							+ BS.getAvrage()
							+ "]);");
				}
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
