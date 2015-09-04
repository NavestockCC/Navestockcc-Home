package org.navestock.teams;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.navestock.dbcom.NavestockDbConnection;
import org.navestock.teams.Team;


//import com.google.cloud.sql.jdbc.Connection;
import java.sql.Connection;


public class TeamList {
	
	private ArrayList <Team> TList = new  ArrayList<Team>();
	
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

}
