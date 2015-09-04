package org.navestock.match;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@SuppressWarnings("serial")
	public class matchListServelet extends HttpServlet {

		  
	/**
	   * Process the HTTP doGet request.
	   */
		public void doGet(HttpServletRequest request, 
			      HttpServletResponse response) throws ServletException, IOException 
			  {
			MatchList matchlst = new MatchList();
			
			request.setAttribute("MatchList", matchlst.getMatchList(request.getParameter("tId")));

			RequestDispatcher rd = request.getRequestDispatcher("matchlist.jsp");
			rd.forward(request, response);
			  }
	}