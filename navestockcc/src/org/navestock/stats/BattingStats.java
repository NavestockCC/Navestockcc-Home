package org.navestock.stats;

public class BattingStats {

	private int idPlayer;
	private String playerName;
	private int statYear;
	private int idTeam;
	private String teamName;
	private int runsScored;
	private int nInnings;
	private int nOutCount;
	private long avrage;
	
	
	public BattingStats(){
		
	}
	
	public BattingStats(int playerId, String playerNme, int dt, int teamId, String tName, int runScored, int Innings, int OutCount, int battingAvg ) {
		this.idPlayer = playerId;
		this.playerName = playerNme;
		this.statYear = dt;
		this.idTeam = teamId;
		this.teamName = tName;
		this.runsScored = runScored;
		this.nInnings = Innings;
		this.nOutCount = OutCount;
		this.avrage =  battingAvg;
	}




	public int getStatYear() {
		return statYear;
	}

	public int getIdTeam() {
		return idTeam;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public int getnInnings() {
		return nInnings;
	}

	public int getnOutCount() {
		return nOutCount;
	}

	public long getAvrage() {
		return avrage;
	}

	public void setStatYear(int statYear) {
		this.statYear = statYear;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
	public void setRunsScoredAdd(int runsScored) {
		this.runsScored = this.runsScored + runsScored;
	}

	public void setnInnings(int nInnings) {
		this.nInnings = nInnings;
	}
	public void setnInningsAdd(int nInnings) {
		this.nInnings = this.nInnings + nInnings;
	}

	public void setnOutCount(int nOutCount) {
		this.nOutCount = nOutCount;
	}
	public void setnOutCountAdd(int nOutCount) {
		this.nOutCount = this.nOutCount + nOutCount;
	}

	public void setAvrage() {
		if(this.nOutCount!=0){
			this.avrage = this.runsScored/this.nOutCount;
		}else{
			this.avrage = this.runsScored;
		}
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
