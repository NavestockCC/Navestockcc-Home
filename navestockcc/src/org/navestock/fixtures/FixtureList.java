package org.navestock.fixtures;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.navestock.dbcom.NavestockDbConnection;
import org.navestock.fixtures.Fixture;


public class FixtureList {
	private ArrayList <Fixture> FixtureList = new  ArrayList<Fixture>();
	
	public FixtureList(String SQL) {
		
			NavestockDbConnection connObj = new NavestockDbConnection();
			Connection conn = connObj.getNavestockDbConnection();

			ResultSet rs;
			try {
				rs = conn.createStatement().executeQuery(SQL);
				rs.first();
				if (rs != null){
					do {
						Fixture fixturedetails = new Fixture(rs.getInt("idMatch"), rs.getInt("NavestockTeamId"), rs.getString("NavestockTeamName"), rs.getInt("OppositionTeamId"), 
								rs.getString("OppositionTeamName"), rs.getString("MatchType"), rs.getString("HomeOrAway") ,rs.getDate("MatchDate"), 
								rs.getString("MatchStartTime"), rs.getInt("idGround"), rs.getString("GroundName"), rs.getString("Address1"), rs.getString("Address2"), 
								rs.getString("AddressTown"), rs.getString("AddressCounty"), rs.getString("PostCode"), rs.getInt("NavestockRuns"), rs.getInt("NavestockWickets"), 
								rs.getInt("OppositionRuns"), rs.getInt("OppositionWickets"), rs.getInt("idTeamWinning") , rs.getString("ResultDescription"), rs.getString("WinningTeamName"));
						FixtureList.add(fixturedetails);
					} while (rs.next());				
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
			}		
	
	public int getSize(){
		return FixtureList.size();
	}
	
	public  Fixture getFixture(int indexId){		
		return FixtureList.get(indexId);
	}


}

