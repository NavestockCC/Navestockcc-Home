package org.navestock.ctags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.navestock.stats.ScoreCard;
import org.navestock.stats.ScoreCardService;

public class ScoreCardWidget extends SimpleTagSupport {

	private int MatchId; 
	
	public void setMatchId(int matchId) {
		MatchId = matchId;
	}
	
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		
		ScoreCardService scs = new ScoreCardService();
		List <ScoreCard> scl = scs.getScoreCard(MatchId);
		String BattingCard = "";
		String BowlingCard = "";
		boolean DispBatting = false;
		boolean DispBowling = false;
		
		if((scl != null) && (!scl.isEmpty())){
			for (int i = 0; i < scl.size(); i++){
				if(scl.get(i).getRunsScored() > 0){
					DispBatting = true;
				}
				BattingCard = BattingCard + "<tr><td class='scoreCardPlayer'>" + scl.get(i).getBatingOrder() + "</td><td class='scoreCardPlayer'><a href=playerstats.jsp?pId=" + scl.get(i).getIdPlayer() + ">" + scl.get(i).getPlayer() + "</a></td><td class='scoreCardOut'>" + scl.get(i).getHowOutDescription() + "</td><td class='scoreCardNumbers'>" + scl.get(i).getRunsScored() + "</td></tr>";
				
				if(scl.get(i).getOversBowled() > 0){
					DispBowling = true;
					BowlingCard = BowlingCard + "<a href=playerstats.jsp?pId=" + scl.get(i).getIdPlayer() + "><tr><td class=''scoreCardPlayer>" + scl.get(i).getPlayer() + "</td><td class='scoreCardNumbers'>" + scl.get(i).getOversBowled() + "</td><td class='scoreCardNumbers'>" + scl.get(i).getWickets() + "</td><td class='scoreCardNumbers'>" + scl.get(i).getRunsConseded() + "</td></tr></a>";
					}	
			}
		
		//Display batting card	
			out.println("<table class='scoreCardTable'>");
			if(DispBatting){out.println("<tr class='scoreCardHeading'><td colspan='3' class='scoreCardHeadingCells'>Navestock Batting Stats</td><td class='scoreCardHeadingCells'>Runs</td></tr>");}
			out.println(BattingCard);
			out.println("</table>");
		
	 //Display bowling card
			if(DispBowling){
				out.println("<br><br>");
				out.println("<table class='scoreCardTable'>");
				out.println("<tr class='scoreCardHeading'><td>Bowler</td><td class='scoreCardHeadingCells'>Overs</td><td class='scoreCardHeadingCells'>Wickets</td><td class='scoreCardHeadingCells'>Runs</td></tr>");
				out.println(BowlingCard);
				out.println("</table>");
			}
		}
		
	}
}
