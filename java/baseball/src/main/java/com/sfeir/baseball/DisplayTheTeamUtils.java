package com.sfeir.baseball;

import java.time.LocalDate;

public class DisplayTheTeamUtils {

	/**
	 * Display my favorite team!
	 * 
	 * @param teamToDisplay
	 */
	public static void displayTheTeam(final TeamManagement management) {		
		
		System.out.println("\t\t ===== " + management.getTeam().getName().toUpperCase() + " =====");
		System.out.println(" ");
		System.out.println("Manager is :");
		System.out.println(management.getTeam().getManager());
		System.out.println(" ");		
		System.out.println("I have " + management.getTeam().getPlayers().size() + " players in my team " + management.getTeam().getName().toUpperCase());

		for(Position position : Position.values()) {
			System.out.println(" ");
			System.out.println(" == "+position.getLabel()+" == ");
			System.out.println("" + management.getPlayers(position));
		}

		System.out.println(" ");
		System.out.println("The hole team is composed of : " + management.getTeam());

		System.out.println(" ");
		System.out.println(" ===== We will win the season : " + extractYear() + " ===== ");
	}
	

	/**
	 * Extract the year.
	 * 
	 * @return
	 */
	private static Integer extractYear() {
		int year = LocalDate.now().getYear();
		return year;
	}
}
