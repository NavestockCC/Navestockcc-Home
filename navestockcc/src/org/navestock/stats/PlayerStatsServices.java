package org.navestock.stats;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.navestock.dbcom.NavestockDbConnection;
import org.navestock.stats.PlayerStats;

public class PlayerStatsServices {
	
	public static List<PlayerStats> StatsPerPlayer = new ArrayList<PlayerStats>();	

	public PlayerStatsServices() {
		// TODO Auto-generated constructor stub
	}
	
	public List<PlayerStats> getPlayerStats(int idPlayer){
		List<PlayerStats> StatsPerPlayer = new ArrayList<PlayerStats>();
		
		NavestockDbConnection connObj = new NavestockDbConnection();
		Connection conn = connObj.getNavestockDbConnection();
		ResultSet rs;
		
		try {
			rs = conn.createStatement().executeQuery(SQL(idPlayer));
				while (rs.next()) {
					PlayerStats sc = new PlayerStats(rs.getInt("idMatch"), rs.getInt("OppositionTeamId"), rs.getString("OppositionName"), rs.getDate("MatchDate"), rs.getInt("idTeamWinning"), rs.getString("WinningTeamName"), rs.getString("ResultDescription"), rs.getInt("idPlayer"), rs.getString("Firstname"),
							rs.getString("Lastname"), rs.getInt("idTeam"), rs.getString("TeamName"), rs.getInt("BatingOrder"), rs.getInt("RunsScored"), rs.getInt("idHowOut"),
							rs.getString("HowOutDescription"), rs.getInt("OversBowled"), rs.getInt("Wickets"), rs.getInt("RunsConseded"), rs.getInt("OppositionRuns"), rs.getInt("OppositionWickets"), rs.getInt("NavestockRuns"), rs.getInt("NavestockWickets"));
					StatsPerPlayer.add(sc);
				}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connObj.closeNavestockDbConnection(conn);
		return StatsPerPlayer;
	}	

	public String playerBattingAvg(int idPlayer){
		int runsSum = 0;
		int outCount = 0;
		
		for (PlayerStats PS: StatsPerPlayer ){
			runsSum = runsSum + PS.getRunsScored();
			if(PS.getIdHowOut() > 0){
				outCount = outCount + 1;
			}
		}
		return null;		
	}



	private String SQL(int idPlayer){
		String BuildSql = null;
		BuildSql = "SELECT";
		BuildSql = BuildSql + " Stats.idMatch,";
		BuildSql = BuildSql + " Matches.OppositionTeamId,";
		BuildSql = BuildSql + " (select CONCAT(Club.ClubName, ' : ', teams.TeamName) from teams inner join(Club) on (teams.idClub = Club.idClub) where teams.TeamId = Matches.OppositionTeamId) AS OppositionName,";
		BuildSql = BuildSql + " Matches.MatchDate,";
		BuildSql = BuildSql + " Matches.idTeamWinning,";
		BuildSql = BuildSql + " (select CONCAT(Club.ClubName, ' : ', teams.TeamName) from teams inner join(Club) on (teams.idClub = Club.idClub) where teams.TeamId = Matches.idTeamWinning) AS WinningTeamName ,";
		BuildSql = BuildSql + " Matches.ResultDescription,";
		BuildSql = BuildSql + " Matches.OppositionRuns,";
		BuildSql = BuildSql + " Matches.OppositionWickets,";
		BuildSql = BuildSql + " Matches.NavestockRuns,";
		BuildSql = BuildSql + " Matches.NavestockWickets,";
		BuildSql = BuildSql + " Stats.idPlayer,";
		BuildSql = BuildSql + " Players.Firstname,";
		BuildSql = BuildSql + " Players.Lastname,";
		BuildSql = BuildSql + " Stats.idTeam,";
		BuildSql = BuildSql + " teams.TeamName,";
		BuildSql = BuildSql + " Stats.BatingOrder,";
		BuildSql = BuildSql + " Stats.RunsScored,";
		BuildSql = BuildSql + " Stats.idHowOut,";
		BuildSql = BuildSql + " HowOut.HowOutDescription,";
		BuildSql = BuildSql + " Stats.OversBowled,";
		BuildSql = BuildSql + " Stats.Wickets,";
		BuildSql = BuildSql + " Stats.RunsConseded";
		BuildSql = BuildSql + " From Stats inner join (Players, HowOut, teams, Matches)";
		BuildSql = BuildSql + " ON (Stats.idPlayer=Players.idPlayer and Stats.idHowOut=HowOut.idHowOut and Stats.idTeam = teams.TeamId and Stats.idMatch=Matches.idMatch)";
		BuildSql = BuildSql + " where Stats.idPlayer = " + idPlayer + " and year(Matches.MatchDate) = year(now())";
		BuildSql = BuildSql + " Order by Matches.MatchDate";

		return BuildSql;
	}



}

