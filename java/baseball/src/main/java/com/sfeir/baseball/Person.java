package com.sfeir.baseball;

public class Person {
	private String firstName;
	private String name;
	private Team currentTeam;
	
	public Person() {
		name = null;
		firstName = null;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		 this.name = name;
	}
	public Team getCurrentTeam() {
		return currentTeam;
	}
	
	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}
	
	@Override
	public String toString() {
		return "\n [name=" + getName() + ", firstName=" + firstName+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentTeam == null) ? 0 : currentTeam.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (currentTeam == null) {
			if (other.currentTeam != null)
				return false;
		} else if (!currentTeam.equals(other.currentTeam))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
