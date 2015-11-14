package org.navestock.stats;


public class PlayerList {
	
	private int idPlayer;
	private String Firstname;
	private String Lastname;
	private int MatchCount;
	

	private String Seasonyear;
	
//PlayerList constructor	
	public PlayerList(){};

	public PlayerList(int idPlyr, String Frstnme, String Lstnme, int MtchCount,  String SYear){
		this.idPlayer = idPlyr;
		this.Firstname = Frstnme;
		this.Lastname = Lstnme;
		this.MatchCount = MtchCount;
		this.Seasonyear = SYear;
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

	public String getSeasonyear() {
		return Seasonyear;
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

	public void setSeasonyear(String seasonyear) {
		Seasonyear = seasonyear;
	};
	
	public int getMatchCount() {
		return MatchCount;
	}

	public void setMatchCount(int matchCount) {
		MatchCount = matchCount;
	}
	

}
