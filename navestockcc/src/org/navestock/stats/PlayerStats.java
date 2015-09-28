package org.navestock.stats;

import java.util.Date;


public class PlayerStats {

	private int idMatch;
	private int OppositionTeamId;
	private String OppositionName;
	private Date MatchDate;
	private int idTeamWinning;
	private String WinningTeamName;
	private String ResultDescription;
	private int idPlayer;
	private String Firstname;
	private String Lastname;
	private int idTeam;
	private String TeamName;
	private int BatingOrder;
	private int RunsScored;
	private int idHowOut;
	private String HowOutDescription;
	private int OversBowled;
	private int Wickets;
	private int RunsConseded;
	
	public PlayerStats() {
		// TODO Auto-generated constructor stub
	}

	public PlayerStats(int idMtch, int OppstnTeamId, String OppstnName, Date MtchDate, int idTmWinning, String WinningTmName, String RsltDescription, int idPlyr, String Frstname, String Lstname, int idTm, String TmName, int BatingOrd, int RnsScored, int idHwOut, String HwOutDescription, int OvrsBowled, int Wickts, int RnsConseded) {
		this.idMatch = idMtch;
		this.OppositionTeamId = OppstnTeamId;
		this.OppositionName = OppstnName;
		this.MatchDate = MtchDate;
		this.idTeamWinning = idTmWinning;
		this.WinningTeamName = WinningTmName;
		this.ResultDescription = RsltDescription;
		this.idPlayer = idPlyr;
		this.Firstname = Frstname;
		this.Lastname = Lstname;
		this.idTeam = idTm;
		this.TeamName = TmName;
		this.BatingOrder = BatingOrd;
		this.RunsScored = RnsScored;
		this.idHowOut = idHwOut;
		this.HowOutDescription = HwOutDescription;
		this.OversBowled = OvrsBowled;
		this.Wickets = Wickts;
		this.RunsConseded = RnsConseded;

	}

	public String getResult(){
		if(this.idTeamWinning > 0){
			return this.WinningTeamName + " won by " + this.ResultDescription;
		}else if(this.idTeamWinning == -3){ 
			return "Draw";
		} else{
			return this.WinningTeamName + " " + this.ResultDescription;
		}
	}	
	
	
	public int getIdMatch() {
		return idMatch;
	}

	public int getOppositionTeamId() {
		return OppositionTeamId;
	}

	public String getOppositionName() {
		return OppositionName;
	}

	public Date getMatchDate() {
		return MatchDate;
	}

	public int getIdTeamWinning() {
		return idTeamWinning;
	}

	public String getWinningTeamName() {
		return WinningTeamName;
	}

	public String getResultDescription() {
		return ResultDescription;
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public String getFirstname() {
		return Firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public int getIdTeam() {
		return idTeam;
	}

	public String getTeamName() {
		return TeamName;
	}

	public int getBatingOrder() {
		return BatingOrder;
	}

	public int getRunsScored() {
		return RunsScored;
	}

	public int getIdHowOut() {
		return idHowOut;
	}

	public String getHowOutDescription() {
		return HowOutDescription;
	}

	public int getOversBowled() {
		return OversBowled;
	}

	public int getWickets() {
		return Wickets;
	}

	public int getRunsConseded() {
		return RunsConseded;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public void setOppositionTeamId(int oppositionTeamId) {
		OppositionTeamId = oppositionTeamId;
	}

	public void setOppositionName(String oppositionName) {
		OppositionName = oppositionName;
	}

	public void setMatchDate(Date matchDate) {
		MatchDate = matchDate;
	}

	public void setIdTeamWinning(int idTeamWinning) {
		this.idTeamWinning = idTeamWinning;
	}

	public void setWinningTeamName(String winningTeamName) {
		WinningTeamName = winningTeamName;
	}

	public void setResultDescription(String resultDescription) {
		ResultDescription = resultDescription;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	public void setBatingOrder(int batingOrder) {
		BatingOrder = batingOrder;
	}

	public void setRunsScored(int runsScored) {
		RunsScored = runsScored;
	}

	public void setIdHowOut(int idHowOut) {
		this.idHowOut = idHowOut;
	}

	public void setHowOutDescription(String howOutDescription) {
		HowOutDescription = howOutDescription;
	}

	public void setOversBowled(int oversBowled) {
		OversBowled = oversBowled;
	}

	public void setWickets(int wickets) {
		Wickets = wickets;
	}

	public void setRunsConseded(int runsConseded) {
		RunsConseded = runsConseded;
	}
	
	
}
