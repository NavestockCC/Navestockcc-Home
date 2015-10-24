package org.navestock.teams;

	import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.navestock.dbcom.NavestockDbConnection;

	public class Team {
		
		private int teamId;
		private String teamName;
		private String teamClub;
		private String teamLeague;
		private String teamPostCode;
		
		
	 public void setTeam(int TeamId, String TeamName, String TeamClub, String TeamLeague, String TeamPostCode){
		 this.teamId = TeamId;
		 this.teamName = TeamName;
		 this.teamClub = TeamClub;
		 this.teamLeague = TeamLeague;
		 this.teamPostCode = TeamPostCode;
	 }
		
		

	
		/**
		 * Create and update teams
		 */		
		public void setTeamDB(int tId, String tName, String tClub, String tLeague, String tPostCode) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

			NavestockDbConnection connObj = new NavestockDbConnection();
			Connection conn = connObj.getNavestockDbConnection();
			
			try{
				CallableStatement callableStatement =conn.prepareCall("{call addTeam(?,?,?,?,?)}");
				callableStatement.setInt("tId", tId );
				callableStatement.setString("tName", tName);
				callableStatement.setString("tClub", tClub);
				callableStatement.setString("tLeague", tLeague);
				callableStatement.setString("tPostCode", tPostCode);
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


		/*
		 * Getter and setter methods
		 */
		public Integer getTeamId() {
			return teamId;
		}
		
		public String getTeamName() {
			return teamName;
		}

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