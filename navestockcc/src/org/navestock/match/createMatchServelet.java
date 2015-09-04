package org.navestock.match;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.navestock.teams.TeamList;

@SuppressWarnings("serial")
public class createMatchServelet extends HttpServlet {

	  
/**
   * Process the HTTP doGet request.
   */
	public void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {
			response.setContentType("text/html");
			
			TeamList HomeTeam = new TeamList();

				try {
					request.setAttribute("hTeam", HomeTeam.getTeamList("Navestock"));
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				TeamList OppositionTeam = new TeamList();

				try {
					request.setAttribute("oTeam", OppositionTeam.getTeamList("Opposition"));
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			RequestDispatcher rd = request.getRequestDispatcher("CreateMatch.jsp");
			rd.forward(request, response);
		  }
	
	public void doPost(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException {
			Match cMatch = new Match();

			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dateresult =  df.parse(request.getParameter("matchDate"));
				java.sql.Date sqlDate = new java.sql.Date(dateresult.getTime());
				cMatch.setMatchDB(Integer.parseInt(request.getParameter("navestockTeamId")), Integer.parseInt(request.getParameter("oppositionTeamId")), sqlDate, request.getParameter("matchStartTime"), request.getParameter("homeOrAway"));
			} catch (NumberFormatException | ClassNotFoundException
					| InstantiationException | IllegalAccessException
					| SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			doGet(request, response);		
	}
}