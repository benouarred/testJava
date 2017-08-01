package com.sfeir.baseball;

import java.util.HashSet;

public class Team {

	String name;
	String cityLocation;
	String stadiumName;
	Boolean isMajorLeagueTeam;
	Person manager;
	HashSet<Player> players;

	public Team(String name, String cityLocation, String stadiumName, Boolean isMajorLeagueTeam, Person manager) {
		this.name = name;
		this.cityLocation = cityLocation;
		this.stadiumName = stadiumName;
		this.isMajorLeagueTeam = isMajorLeagueTeam;
		this.manager = manager;
		players = new HashSet<Player>();
	}

	public String getName() {
		return name;
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

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public HashSet<Player> getPlayers() {
		return players;
	}

	public void setPlayers(HashSet<Player> players) {
		this.players = players;
	}	

	@Override
	public String toString() {
		return "Team [name=" + getName() + ", cityLocation=" + getCityLocation() + ", statiumName=" + getStadiumName()
				+ ", isMajorLeagueTeam=" + getIsMajorLeagueTeam() + ", players=" + getPlayers() + " \n]";
	}
}
