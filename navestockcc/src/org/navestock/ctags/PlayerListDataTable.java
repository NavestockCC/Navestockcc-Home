package org.navestock.ctags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.navestock.stats.PlayerList;
import org.navestock.stats.PlayerStatsServices;


public class PlayerListDataTable extends SimpleTagSupport {
	
	private int TeamId;
	
	public void setTeamId(int TeamId) {
		this.TeamId = TeamId;
	}
	
	public void doTag() throws JspException {

		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();

		try {
			PlayerStatsServices PlyerSatServices = new PlayerStatsServices();
			List <PlayerList> PlayerDataTbl = PlyerSatServices.getPlayerList(TeamId);
			
			if((PlayerDataTbl != null) && (!PlayerDataTbl.isEmpty())){
				out.println("<table>");
				out.println("<tr>");
					out.println("<th style=\"text-align:left;\">Player</th>");
					out.println("<th style=\"text-align:right;\">Number of Games Played</th>");
				out.println("</tr>");
				
				for (int i = 0; i < PlayerDataTbl.size(); i++){
					out.println("<tr>");
					out.println("<td style=\"text-align:left;\">");
					out.println("<a href=playerstats.jsp?pId=" + PlayerDataTbl.get(i).getIdPlayer() + ">");
					out.println(PlayerDataTbl.get(i).getFirstname() + " " + PlayerDataTbl.get(i).getLastname());
					out.println("</a>");
					out.println("</td>");
					out.println("<td style=\"text-align:right;\">");
					out.println("<a href=playerstats.jsp?pId=" + PlayerDataTbl.get(i).getIdPlayer() + ">");
					out.println(PlayerDataTbl.get(i).getMatchCount());
					out.println("</a>");
					out.println("</td>");
					out.println("</tr>");

					}
				out.println("</table>");
		}
			else{
				out.println("<p>No stats available</p>");
			}
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
