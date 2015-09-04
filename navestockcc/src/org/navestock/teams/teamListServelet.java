package org.navestock.teams;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.navestock.teams.TeamList;
import org.navestock.teams.Team;

@SuppressWarnings("serial")
public class teamListServelet extends HttpServlet {

	  
/**
   * Process the HTTP doGet request.
   */
	public void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {
			  
//(IN tId int, IN tName CHAR(30), IN tClub CHAR(30), IN tLeague CHAR(30), IN tPostCode CHAR(30))
			  String tName =  request.getParameter("tName");
			  int tIdInt;
			  if(tName!=null){
				  String tId = request.getParameter("tId");
				  if(tId == ""){
					  tIdInt = -1;
				  }
				  else{
					  tIdInt = Integer.parseInt(tId);
				  }
//				  int tId = Integer.parseInt(request.getParameter("tId"));
				  String tClub =  request.getParameter("tClub");
				  String tLeague =  request.getParameter("tLeague");
				  String tHomeGroundPostCode =  request.getParameter("tHomeGroundPostCode");				  
				Team TeamDB = new Team();
				try {
					
					TeamDB.setTeamDB(tIdInt, tName, tClub, tLeague, tHomeGroundPostCode);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			  
			  }
			  
			  TeamList SundayTeam = new TeamList();
			  try {
				  request.setAttribute("tList", SundayTeam.getTeamList("All"));
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | SQLException e) {
				e.printStackTrace();
			}
			  
			
			  RequestDispatcher rd = request.getRequestDispatcher("team.jsp");
			  rd.forward(request, response);
		  }

}
