package org.navestock.teams;

	import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.navestock.dbcom.NavestockDbConnection;

	public class Teams {
		
		private Integer teamId;
		private String teamName;
		private String teamClub;
		private String teamLeague;
		private String teamPostCode;
		private ArrayList<Team> TList = new  ArrayList<Team>();
		
	 public void setTeam(int TeamId, String TeamName, String TeamClub, String TeamLeague, String TeamPostCode){
		 this.teamId = TeamId;
		 this.teamName = TeamName;
		 this.teamClub = TeamClub;
		 this.teamLeague = TeamLeague;
		 this.teamPostCode = TeamPostCode;
	 }
		
		
		/**
		 * @return the teamId
		 */
		public Integer getTeamId() {
			return teamId;
		}
	
		/**
		 * Create and update teams
		 */		
		public void setTeamDB(int tId, String tName, String tClub, String tLeague, String tPostCode) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

			NavestockDbConnection connObj = new NavestockDbConnection();
			Connection conn = connObj.getNavestockDbConnection();
			
			CallableStatement callableStatement =conn.prepareCall("{call addTeam(?,?,?,?,?)}");
			callableStatement.setInt("tId", tId );
			callableStatement.setString("tName", tName);
			callableStatement.setString("tClub", tClub);
			callableStatement.setString("tLeague", tLeague);
			callableStatement.setString("tPostCode", tPostCode);
			
			callableStatement.executeQuery();

			connObj.closeNavestockDbConnection(conn);
		}



		
		public ArrayList<Team> getTeamList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
			NavestockDbConnection connObj = new NavestockDbConnection();
			Connection conn = connObj.getNavestockDbConnection();

			ResultSet rs = conn.createStatement().executeQuery(
				    "SELECT * FROM teams ORDER BY Club, TeamName");
			rs.first();
			if (rs != null){
				do {
					Team team = new Team();
					team.setTeam(rs.getInt("TeamId"), rs.getString("TeamName"), rs.getString("Club"), rs.getString("League"), rs.getString("HomeGroundPostCode"));
					TList.add(team);
				} while (rs.next());
				
			}	
			    connObj.closeNavestockDbConnection(conn);
				return TList;
		}		
		
		public ArrayList<Team> getTeamList(String tClub) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
			String SQL = null;
			if(tClub.equalsIgnoreCase("Navestock")){
				SQL = "SELECT * FROM teams WHERE Club = 'Navestock' ORDER BY Club, TeamName";
			} 
			else if(tClub.equalsIgnoreCase("Opposition")){
				SQL = "SELECT * FROM teams WHERE Club != 'Navestock' ORDER BY Club, TeamName";	
			}
			else{
				SQL = "SELECT * FROM teams ORDER BY Club, TeamName";	
			}
			
			
			NavestockDbConnection connObj = new NavestockDbConnection();
			Connection conn = connObj.getNavestockDbConnection();

			ResultSet rs = conn.createStatement().executeQuery(SQL);
			
			rs.first();
			if (rs != null){
				do {
					Team team = new Team();
					team.setTeam(rs.getInt("TeamId"), rs.getString("TeamName"), rs.getString("Club"), rs.getString("League"), rs.getString("HomeGroundPostCode"));
					TList.add(team);
				} while (rs.next());
				
			}	
			    connObj.closeNavestockDbConnection(conn);
				return TList;
		}			
		
		
		/*
		 * Getter and setter methods
		 */
		/**
		 * @return the teamName
		 */
		public String getTeamName() {
			return teamName;
		}
		/**
		 * @param teamName the teamName to set
		 */
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}


		public String getTeamClub() {
			return teamClub;
		}


		public void setTeamClub(String teamClub) {
			this.teamClub = teamClub;
		}


		public String getTeamLeague() {
			return teamLeague;
		}


		public void setTeamLeague(String teamLeague) {
			this.teamLeague = teamLeague;
		}


		public String getTeamPostCode() {
			return teamPostCode;
		}


		public void setTeamPostCode(String teamPostCode) {
			this.teamPostCode = teamPostCode;
		}
	}