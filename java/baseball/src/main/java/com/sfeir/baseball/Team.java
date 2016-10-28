package com.sfeir.baseball;

import java.util.HashSet;

public class Team {

	String name;
	String cityLocation;
	String stadiumName;
	Boolean isMajorLeagueTeam;
	HashSet players;

	public Team(String name, String cityLocation, String stadiumName, Boolean isMajorLeagueTeam) {
		this.name = name;
		this.cityLocation = cityLocation;
		this.stadiumName = stadiumName;
		this.isMajorLeagueTeam = isMajorLeagueTeam;
	}

	public String getName() {
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityLocation() {
		return cityLocation;
	}

	public void setCityLocation(String cityLocation) {
		this.cityLocation = cityLocation;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public Boolean getIsMajorLeagueTeam() {
		return isMajorLeagueTeam;
	}

	public void setIsMajorLeagueTeam(Boolean isMajorLeagueTeam) {
		this.isMajorLeagueTeam = isMajorLeagueTeam;
	}

	public HashSet getPlayers() {
		return players;
	}

	public void setPlayers(HashSet players) {
		this.players = players;
	}

	public HashSet<Player> addAPlayerToATeam(HashSet<Player> players, Player playerToAdd) {
		// All safe man I know my job
		HashSet<Player> playersTmp = players == null ? new HashSet() : players;
		playersTmp.add(playerToAdd);
		return playersTmp;
	}

	@Override
	public String toString() {
		return "Team [name=" + getName() + ", cityLocation=" + getCityLocation() + ", statiumName=" + getStadiumName()
				+ ", isMajorLeagueTeam=" + getIsMajorLeagueTeam() + ", players=" + getPlayers() + " \n]";
	}
	
	public HashSet getPitchers(){
		HashSet result = new HashSet();
		Player[] playerArrays = (Player[]) this.players.toArray();
		for(int i = 0; i < playerArrays.length; i ++){
			Player currentPlayer = playerArrays[i];
			if(currentPlayer.getPosition().toLowerCase() == "pitcher"){
				result.add(currentPlayer);
			}
		}
		return result;
	}
	
	public HashSet getCatchers(){
		HashSet result = new HashSet();
		Player[] playerArrays = (Player[]) this.players.toArray();
		for(int i = 0; i < playerArrays.length; i ++){
			Player currentPlayer = playerArrays[i];
			if(currentPlayer.getPosition().toLowerCase() == "catcher"){
				result.add(currentPlayer);
			}
		}
		return result;
	}
	
	
	public HashSet getInfields(){
		HashSet result = new HashSet();
		Player[] playerArrays = (Player[]) this.players.toArray();
		for(int i = 0; i < playerArrays.length; i ++){
			Player currentPlayer = playerArrays[i];
			if(currentPlayer.getPosition().toLowerCase() == "infield"){
				result.add(currentPlayer);
			}
		}
		return result;
	}
	
	public HashSet getOutfields(){
		HashSet result = new HashSet();
		Player[] playerArrays = (Player[]) this.players.toArray();
		for(int i = 0; i < playerArrays.length; i ++){
			Player currentPlayer = playerArrays[i];
			if(currentPlayer.getPosition().toLowerCase() == "outfield"){
				result.add(currentPlayer);
			}
		}
		return result;
	}
	
	public HashSet getDesignatedHitters(){
		HashSet result = new HashSet();
		Player[] playerArrays = (Player[]) this.players.toArray();
		for(int i = 0; i < playerArrays.length; i ++){
			Player currentPlayer = playerArrays[i];
			if(currentPlayer.getPosition().toLowerCase() == "designated hitter"){
				result.add(currentPlayer);
			}
		}
		return result;
	}
}
