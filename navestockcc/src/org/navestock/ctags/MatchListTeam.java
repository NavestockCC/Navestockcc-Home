package org.navestock.ctags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.text.SimpleDateFormat;

import org.navestock.fixtures.FixtureList;

public class MatchListTeam extends SimpleTagSupport {
	
	private int TeamId;
	
	public String getSQL(int teamId){
		
		String Select = null;
		String From = null;
		String Where = null;
		String OrderBy = null;
		
		
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
		Where = "Where NavestockTeamId = " + teamId +  " and year(MatchDate) = year(now())"; 
		OrderBy = "ORDER BY NavestockTeamName asc, MatchYear desc, MatchDate asc";		
		
		return Select + " " + From + " " + Where + " " + OrderBy;
	}
	
	
	public void setTeamId(int TeamId) {
		this.TeamId = TeamId;
	}	
	
	
	@SuppressWarnings("unused")
	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		
		Boolean varUL = false; // Variable to control the <ul> tag display 
		
		
		try {
			FixtureList fixturelst = new FixtureList(getSQL(TeamId));
			
			if(fixturelst == null){
				out.println("<p>No future fixtures scheduled.</p>");
			 }else{
				SimpleDateFormat format = new SimpleDateFormat("dd MMMM");
				SimpleDateFormat mnthYear = new SimpleDateFormat("MMMM yyyy");
				SimpleDateFormat year = new SimpleDateFormat("yyyy");
				String MatchMonth = "";
				String MatchYear = "";
				
				for (int i = 0; i < fixturelst.getSize(); i++) {
					if(!MatchYear.equals(year.format(fixturelst.getFixture(i).getMatchDate()))){
						MatchYear = year.format(fixturelst.getFixture(i).getMatchDate());
						
						if(varUL == true){
							out.println("</ul>");
							varUL = false;
						}
						
						out.println("<p class='left_panel_heading'>" + fixturelst.getFixture(i).getNavestockTeamName() + " : " + MatchYear + "</p>");
						
						if(varUL == false){
							out.println("<ul class='widget_ul'>");
							varUL = true;}
					}
					
					if(!MatchMonth.equals(mnthYear.format(fixturelst.getFixture(i).getMatchDate()))){
						MatchMonth = mnthYear.format(fixturelst.getFixture(i).getMatchDate());
						if(varUL == true){
							out.println("</ul>");
							varUL = false;}
						
						out.println("<p class='panel_widget_heading light_green_gradient'>" + MatchMonth + "</p>");
						
						if(varUL == false){
							out.println("<ul class='widget_ul'>");
							varUL = true;}									
				   }
			
			
				out.println("<a href=matchdetails.jsp?mId=" + fixturelst.getFixture(i).getMatchId() + "><li>");
					if(fixturelst.getFixture(i).getIdWinningTeam() == -1){
							out.println("<p class='game_listDate'>" + "<b>" + format.format(fixturelst.getFixture(i).getMatchDate()) + "</b>"  + ", " + fixturelst.getFixture(i).getMatchStartTime() + " (" + fixturelst.getFixture(i).getMatchType() + ") " +"</p>");
							out.println("<p class='game_listTeams'>"+ "<b>" + fixturelst.getFixture(i).getOppositionTeamName() + "</b>" + " at " + fixturelst.getFixture(i).getGroundName() + ", " + fixturelst.getFixture(i).getGroundAddressTown() + ", " + fixturelst.getFixture(i).getGroundPostCode() + ", (" + fixturelst.getFixture(i).getHomeOrAway()  +")" +"</p>");						
					} else{
						out.println("<p class='game_listDate'>" + "<b>" + format.format(fixturelst.getFixture(i).getMatchDate())  + ", " + fixturelst.getFixture(i).getOppositionTeamName() + "</b>" + " (" + fixturelst.getFixture(i).getMatchType() + ") " +"</p>");
						out.println("<p class='game_listTeams'>"+ fixturelst.getFixture(i).getFixtureStatus()  +"</p>");
					}
				
				out.println("</li></a>");
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