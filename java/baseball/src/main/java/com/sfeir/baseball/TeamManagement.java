package com.sfeir.baseball;

import java.util.HashSet;

public class TeamManagement {
	private Team team;
	
	public TeamManagement(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public HashSet<Player> addAPlayerToATeam(HashSet<Player> players, Player playerToAdd) {
		// All safe man I know my job
		HashSet<Player> playersTmp = new HashSet<Player>(players);
		playersTmp.add(playerToAdd);
		return playersTmp;
	}
	
	public HashSet<Player> getPlayers(Position position){
		HashSet<Player> players = team.getPlayers();
		
		HashSet<Player> result = new HashSet<Player>();
		
		for(Player currentPlayer : players) {
			if(currentPlayer.getPosition() == position){
				result.add(currentPlayer);
			}
		}
		
		return result;
	}
}
