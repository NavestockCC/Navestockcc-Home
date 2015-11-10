package org.navestock.ctags;

import java.text.SimpleDateFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.navestock.fixtures.FixtureList;

public class MatchListWidget extends SimpleTagSupport {

	private int GamesToDisplay;
	

	public String getSQL(int nLimit){
		
		String Select = null;
		String From = null;
		String Where = null;
		String OrderBy = null;
		String Limit = null;
		String SQL = null;
		String teamId = null;
		
		
		Select = "Select idMatch, "; 
		Select = Select + "NavestockTeamId, "; 
		Select = Select + "(Select concat(Club.ClubName, ' : ', teams.TeamName) from teams left join Club on teams.idClub=Club.idClub where teams.TeamId = Matches.NavestockTeamId) as NavestockTeamName, "; 
		Select = Select + "OppositionTeamId, ";	
		Select = Select + "(Select concat(Club.ClubName, ' : ', teams.TeamName) from teams left join Club on teams.idClub=Club.idClub where teams.TeamId = Matches.OppositionTeamId) as OppositionTeamName, "; 
		Select = Select + "MatchType, ";
		Select = Select + "HomeOrAway, ";
		Select = Select + "year(MatchDate) as MatchYear, ";
		Select = Select + "MatchDate, "; 
		Select = Select + "MatchStartTime, "; 
		Select = Select + "Matches.idGround, "; 
		Select = Select + "Ground.GroundName, ";
		Select = Select + "Ground.Address1, ";
		Select = Select + "Ground.Address2, ";
		Select = Select + "Ground.AddressTown, ";
		Select = Select + "Ground.AddressCounty, "; 
		Select = Select + "Ground.PostCode, ";
		Select = Select + "Matches.idTeamWinning, ";
		Select = Select + "Matches.NavestockRuns, ";
		Select = Select + "Matches.NavestockWickets, ";
		Select = Select + "Matches.OppositionRuns, ";
		Select = Select + "Matches.OppositionWickets, ";
		Select = Select + "(Select concat(Club.ClubName, ' ', teams.TeamName) from teams left join Club on teams.idClub=Club.idClub where teams.TeamId = Matches.idTeamWinning) as WinningTeamName, ";
		Select = Select + "Matches.ResultDescription";
		From = "From Matches	left join (Ground) on (Matches.idGround = Ground.idGround)";
		OrderBy = "ORDER BY NavestockTeamName asc, MatchYear desc, MatchDate asc";
		Limit = "limit " + nLimit;
		
		
		teamId = "2";
		Where = "Where NavestockTeamId = " + teamId +  " and  MatchDate >= now()";
		SQL = "(" + Select + " " + From + " " + Where + " " + OrderBy + " " + Limit + ")";
		
		teamId = "5";
		Where = "Where NavestockTeamId = " + teamId +  " and  MatchDate >= now()";
		SQL = SQL + " union (" + Select + " " + From + " " + Where + " " + OrderBy + " " + Limit+ ")";
		
		teamId = "55";
		Where = "Where NavestockTeamId = " + teamId +  " and  MatchDate >= now()";
		SQL = SQL + " union (" + Select + " " + From + " " + Where + " " + OrderBy + " " + Limit + ")";
		
		teamId = "7";
		Where = "Where NavestockTeamId = " + teamId +  " and  MatchDate >= now()";
		SQL = SQL + " union (" + Select + " " + From + " " + Where + " " + OrderBy + " " + Limit + ")";
		
		teamId = "1";
		Where = "Where NavestockTeamId = " + teamId +  " and  MatchDate >= now()";
		SQL = SQL + " union (" + Select + " " + From + " " + Where + " " + OrderBy + " " + Limit + ")";
		
		return SQL;
	}
		
	public void setGamesToDisplay(int gamesToDisplay) {
		GamesToDisplay = gamesToDisplay;
	}


	@SuppressWarnings("unused")
	public void doTag() throws JspException {

		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();

		Boolean varUL = false;
		
		
		
		try {
			
			FixtureList fixturelst = new FixtureList(getSQL(GamesToDisplay));			
			
			if(fixturelst == null || fixturelst.getSize() == 0){
				out.println("<p>No scheduled fixtures at present.</p>");
			 }else{
					SimpleDateFormat matchDateFormat = new SimpleDateFormat("MMMM dd, yyyy");
						String teamNme = "";
							
						for (int i = 0; i < fixturelst.getSize(); i++) {
							if(teamNme.equals(fixturelst.getFixture(i).getNavestockTeamName())){
							
								out.println("<a href=matchdetails.jsp?mId=" + fixturelst.getFixture(i).getMatchId() + "><li>"); 
								out.println("<p class='game_l1'>" + fixturelst.getFixture(i).getOppositionTeamName() + "</p>");
								out.println("<p class='game_l2'>" + matchDateFormat.format(fixturelst.getFixture(i).getMatchDate()) + " (" + fixturelst.getFixture(i).getMatchStartTime() + ")" + "</p>");
								out.println("</li></a>");
								
								
							}	else if(!teamNme.equals(fixturelst.getFixture(i).getNavestockTeamName())) { 
								teamNme = fixturelst.getFixture(i).getNavestockTeamName();
								if(varUL == true){
									out.println("</ul>");
									varUL = false;
								} 
								
								out.println("<p class='panel_widget_heading green'>" + teamNme + "</p>");
								
								if(varUL == false)
								{
									out.println("<ul class='widget_ul'>");
									varUL = true;
								}
								out.println("<a href=matchdetails.jsp?mId=" + fixturelst.getFixture(i).getMatchId() + "><li>"); 
								out.println("<p class='game_l1'>" + fixturelst.getFixture(i).getOppositionTeamName() + "</p>");
								out.println("<p class='game_l2'>" + matchDateFormat.format(fixturelst.getFixture(i).getMatchDate()) + " (" + fixturelst.getFixture(i).getMatchStartTime() + ")" + "</p>");
								out.println("</li></a>");
							}
						}

						if(varUL == true){
							out.println("</ul>");
						}
			 }
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}