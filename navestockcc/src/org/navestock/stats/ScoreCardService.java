package org.navestock.stats;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.navestock.dbcom.NavestockDbConnection;
import org.navestock.stats.ScoreCard;

public class ScoreCardService {

	public static List<ScoreCard> ScoreCards = new ArrayList<ScoreCard>();
	
	public ScoreCardService() {}
	
	public List<ScoreCard> getScoreCard(int idMtch){
		List<ScoreCard> ScoreCards = new ArrayList<ScoreCard>();
		
		NavestockDbConnection connObj = new NavestockDbConnection();
		Connection conn = connObj.getNavestockDbConnection();
		ResultSet rs;
		
		try {
			rs = conn.createStatement().executeQuery(SQL(idMtch));
				while (rs.next()) {
					ScoreCard sc = new ScoreCard(rs.getInt("idClub"), rs.getString("ClubName"), rs.getInt("TeamId"),rs.getString("TeamName"), rs.getInt("idPlayer"), rs.getString("Firstname"), rs.getString("Lastname"), rs.getInt("BatingOrder"),rs.getInt("RunsScored"), rs.getInt("idHowOut"), rs.getString("HowOutDescription"), rs.getInt("OversBowled"), rs.getInt("Wickets"), rs.getInt("RunsConseded"), rs.getInt("idMatch"));
					ScoreCards.add(sc);
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
		return ScoreCards;
		}
	
	private String SQL(int idMtch){
		String BuildSql = null;
		
		BuildSql = "SELECT Club.idClub,";
		BuildSql = BuildSql + " Club.ClubName,";
		BuildSql = BuildSql + " teams.TeamId,";
		BuildSql = BuildSql + " teams.TeamName,";
		BuildSql = BuildSql + " Players.idPlayer,";
		BuildSql = BuildSql + " Players.Firstname,";
		BuildSql = BuildSql + " Players.Lastname,";
		BuildSql = BuildSql + " Stats.BatingOrder,";
		BuildSql = BuildSql + " Stats.RunsScored,";
		BuildSql = BuildSql + " HowOut.idHowOut,";
		BuildSql = BuildSql + " HowOut.HowOutDescription,";
		BuildSql = BuildSql + " Stats.OversBowled,";
		BuildSql = BuildSql + " Stats.Wickets,";
		BuildSql = BuildSql + " Stats.RunsConseded,";
		BuildSql = BuildSql + " Stats.idMatch";
		BuildSql = BuildSql + " FROM (HowOut INNER JOIN (((Stats INNER JOIN Matches ON Stats.idMatch = Matches.idMatch)"; 
		BuildSql = BuildSql + " INNER JOIN Players ON Stats.idPlayer = Players.idPlayer)"; 
		BuildSql = BuildSql + " INNER JOIN teams ON Stats.idTeam = teams.TeamId) ON HowOut.idHowOut = Stats.idHowOut)"; 
		BuildSql = BuildSql + " INNER JOIN Club ON teams.idClub = Club.idClub";
		BuildSql = BuildSql + " Where Stats.idMatch = " + idMtch;
		
		return BuildSql;
	}
	
	

}
