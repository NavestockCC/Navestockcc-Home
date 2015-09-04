package org.navestock.ctags;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.navestock.fixtures.Fixture;;

public class FixtureDetails extends SimpleTagSupport {
	
	private int MatchId; 
	
	public void setMatchId(int matchId) {
		MatchId = matchId;
	}

	public void doTag() throws JspException {

		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		SimpleDateFormat matchDateFormat = new SimpleDateFormat("dd MMMM yyyy");

		try {
			Fixture fxtre = new Fixture();
			fxtre.getFixtureDB(MatchId);
			
			out.println("<p><b>" + fxtre.getNavestockTeamName() +" vs " + fxtre.getOppositionTeamName() +"</b></p>");
			out.println("<p>" + matchDateFormat.format(fxtre.getMatchDate()) + " : " + fxtre.getMatchStartTime() + "</p>");
			out.println("<p>" + fxtre.getMatchType() + "<p>");
			
			out.println("<br><p><b>Played at:</b><p>");
			out.println("<p>" + fxtre.getArrderssLong('H') + "<p>");
			out.println("<input type='hidden' id='pstcode' value='" + fxtre.getGroundPostCode() + "'>");
			
			out.println("<br><p><b>Match status:</b><p>");
			out.println("<p>" + fxtre.getFixtureStatus() + "<p>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
