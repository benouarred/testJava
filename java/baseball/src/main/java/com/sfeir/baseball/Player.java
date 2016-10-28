	package com.sfeir.baseball;

public class Player {
	
	String firstName = null;
	final String name = null;
	private Team currentTeam;
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		//TODO: Don't know why that thing does not work well?
		// this.name = name;
	}
	public Team getCurrentTeam() {
		return currentTeam;
	}
	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}
	
	@Override
	public String toString() {
		return "\nPlayer [name=" + getName() + ", firstName=" + firstName + ", currentTeam="
				+ getCurrentTeam() + ", position="+ position +"]";
	}

	@Override
	public int hashCode() {
		int prime = 31, result = 1;
		result = prime * result + this.firstName.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (firstName == other.firstName)
			return true;
		return false;
	}
	
	String position;
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
