package org.navestock.match;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.navestock.dbcom.NavestockDbConnection;
import org.navestock.match.Match;



public class MatchList {
	
	private ArrayList <Match> MatchList = new  ArrayList<Match>();

	public ArrayList<Match> getMatchList(String teamId) {
		String SQL = null;
		
		if(teamId != null){
			SQL = "Select idMatch, NavestockTeamId, (Select concat(Club.ClubName, ' : ', teams.TeamName) from teams left join Club on Club.idClub=teams.idClub where teams.TeamId = Matches.NavestockTeamId) as NavestockTeamName, OppositionTeamId, (Select concat(Club.ClubName, ' : ', teams.TeamName) from teams left join Club on Club.idClub=teams.idClub where teams.TeamId = Matches.OppositionTeamId) as OppositionTeamName, MatchDate, MatchStartTime, Ground, GroundPostCode, HomeOrAway From Matches Where NavestockTeamId = " + teamId + " ORDER BY NavestockTeamName, MatchDate ASC";			
			//SQL = "select Matches.idMatch, Matches.NavestockTeamId, (Select concat(Club.ClubName, ' : ', teams.TeamName) from teams left join Club on Club.idClub=teams.idClub where teams.TeamId = Matches.NavestockTeamId) as NavestockTeamName, Matches.OppositionTeamId, (Select concat(Club.ClubName, ' : ', teams.TeamName) from teams left join Club on Club.idClub=teams.idClub where teams.TeamId = Matches.OppositionTeamId) as OppositionTeamName, Matches.MatchDate, Matches.MatchStartTime, Matches.HomeOrAway, Ground.idGround, Ground.GroundName, Ground.PostCode from Matches left join (Ground) on (Matches.idGround=Ground.idGround) Where Matches.NavestockTeamId = " + teamId + " ORDER BY Matches.NavestockTeamId, Matches.MatchDate ASC";
		} else {
			SQL = "Select idMatch, NavestockTeamId, (Select concat(Club.ClubName, ' : ', teams.TeamName) from teams left join Club on Club.idClub=teams.idClub where teams.TeamId = Matches.NavestockTeamId) as NavestockTeamName, OppositionTeamId, (Select concat(Club.ClubName, ' : ', teams.TeamName) from teams left join Club on Club.idClub=teams.idClub where teams.TeamId = Matches.OppositionTeamId) as OppositionTeamName, MatchDate, MatchStartTime, Ground, GroundPostCode, HomeOrAway From Matches ORDER BY NavestockTeamName, MatchDate ASC";
			
		}
		
		
		NavestockDbConnection connObj = new NavestockDbConnection();
		Connection conn = connObj.getNavestockDbConnection();

		ResultSet rs;
		try {
			rs = conn.createStatement().executeQuery(SQL);
			rs.first();
			if (rs != null){
				do {
					Match matchList = new Match();
					matchList.setMatch(rs.getInt("idMatch"), rs.getInt("NavestockTeamId"), rs.getString("NavestockTeamName"), rs.getInt("OppositionTeamId"), rs.getString("OppositionTeamName"), rs.getDate("MatchDate"), rs.getString("MatchStartTime"), rs.getString("Ground"), rs.getString("GroundPostCode"), rs.getString("HomeOrAway"));
					MatchList.add(matchList);
					} 
				while (rs.next());				
				} 
			} 
		catch (SQLException e) {
			e.printStackTrace();
			}
		finally{
			if(conn!=null){
				connObj.closeNavestockDbConnection(conn);
				}
			}		
		return MatchList;
	}
	
	
	

}
