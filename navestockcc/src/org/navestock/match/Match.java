package org.navestock.match;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.navestock.dbcom.NavestockDbConnection;

public class Match {

	private int matchId;
	private int navestockTeamId;
	private String navestockTeamName; 
	private int oppositionTeamId;
	private String oppositionTeamName;
	private Date matchDate;
	private String matchStartTime;
	private String ground;
	private String groundPostCode;
	private String homeOrAway;
	
	
	public void setMatch(int vmatchId, int vnavestockTeamId, String vnavestockTeamName, int voppositionTeamId, String voppositionTeamName, Date vmatchDate, String vmatchStartTime, String vground, String vgroundPostCode, String vhomeOrAway ){
		this.matchId = vmatchId;
		this.navestockTeamId = vnavestockTeamId;
		this.setNavestockTeamName(vnavestockTeamName); 
		this.oppositionTeamId = voppositionTeamId;
		this.setOppositionTeamName(voppositionTeamName);
		this.matchDate = vmatchDate;
		this.matchStartTime =  vmatchStartTime;
		this.ground =  vground;
		this.groundPostCode = vgroundPostCode;
		this.homeOrAway = vhomeOrAway;	
	}
	
	
	public void setMatchDB(int mNavestockTeamId, int mOppositionTeamId, java.sql.Date mMatchDate, String mMatchStartTime, String mHomeOrAway) 
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		NavestockDbConnection connObj = new NavestockDbConnection();
		Connection conn = connObj.getNavestockDbConnection();
		
		try{
			CallableStatement callableStatement =conn.prepareCall("{call addMatch(?,?,?,?,?)}");
			callableStatement.setInt("mNavestockTeamId", mNavestockTeamId);
			callableStatement.setInt("mOppositionTeamId", mOppositionTeamId);
			callableStatement.setDate("mMatchDate", mMatchDate);
			callableStatement.setString("mMatchStartTime", mMatchStartTime);
			callableStatement.setString("mHomeOrAway", mHomeOrAway);		
			callableStatement.executeQuery();
			}
		catch(SQLException e){
			e.printStackTrace();
			}
		finally{
			if(conn!=null){
				connObj.closeNavestockDbConnection(conn);
				}
			}
		}
	
	public void getMatchDB(int MatchId){
		NavestockDbConnection connObj = new NavestockDbConnection();
		Connection conn = connObj.getNavestockDbConnection();
		
		String SQL = "SELECT * FROM Matches WHERE idMatchs=" + MatchId;
		try {
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			if (rs != null){
				this.matchId = rs.getInt("idMatch");
				this.navestockTeamId = rs.getInt("NavestockTeamId");
				this.oppositionTeamId = rs.getInt("OppositionTeamId");
				this.matchDate = rs.getDate("MatchDate");
				this.matchStartTime = rs.getString("MatchStartTime");
				this.ground = rs.getString("Ground");
				this.groundPostCode = rs.getString("GroundPostCode");
				this.homeOrAway = rs.getString("HomeOrAway");
				}
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		finally{
			if(conn!=null){
				connObj.closeNavestockDbConnection(conn);
				}
			}	
		}
	
	/*
	 * Getter and Setter methods
	 */
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getNavestockTeamId() {
		return navestockTeamId;
	}
	public void setNavestockTeamId(int navestockTeamId) {
		this.navestockTeamId = navestockTeamId;
	}
	public int getOppositionTeamId() {
		return oppositionTeamId;
	}
	public void setOppositionTeamId(int oppositionTeamId) {
		this.oppositionTeamId = oppositionTeamId;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public String getMatchStartTime() {
		return matchStartTime;
	}
	public void setMatchStartTime(String matchStartTime) {
		this.matchStartTime = matchStartTime;
	}
	public String getGround() {
		return ground;
	}
	public void setGround(String ground) {
		this.ground = ground;
	}
	public String getGroundPostCode() {
		return groundPostCode;
	}
	public void setGroundPostCode(String groundPostCode) {
		this.groundPostCode = groundPostCode;
	}
	public String getHomeOrAway() {
		return homeOrAway;
	}
	public void setHomeOrAway(String homeOrAway) {
		this.homeOrAway = homeOrAway;
	}


	public String getNavestockTeamName() {
		return navestockTeamName;
	}


	public void setNavestockTeamName(String navestockTeamName) {
		this.navestockTeamName = navestockTeamName;
	}


	public String getOppositionTeamName() {
		return oppositionTeamName;
	}


	public void setOppositionTeamName(String oppositionTeamName) {
		this.oppositionTeamName = oppositionTeamName;
	}
	
	
	
}
