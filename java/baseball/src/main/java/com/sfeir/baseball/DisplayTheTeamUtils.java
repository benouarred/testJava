package com.sfeir.baseball;

import java.util.Date;

public class DisplayTheTeamUtils {

	/**
	 * Display my favorite team!
	 * 
	 * @param teamToDisplay
	 */
	public static void displayTheTeam(final Team teamToDisplay) {
		System.out.println("\t\t ===== " + teamToDisplay.name.toUpperCase() + " =====");
		System.out.println(" ");
		System.out
				.println("I have " + teamToDisplay.players.size() + " players in my team " + teamToDisplay.getName().toUpperCase());

		System.out.println(" ");
		System.out.println(" == Pitchers == ");
		System.out.println("" + teamToDisplay.getPitchers());

		System.out.println(" ");
		System.out.println(" == Catchers == ");
		System.out.println(teamToDisplay.getCatchers());

		System.out.println(" ");
		System.out.println(" == Infields == ");
		System.out.println(teamToDisplay.getInfields());

		System.out.println(" ");
		System.out.println(" == Outfields == ");
		System.out.println(teamToDisplay.getOutfields());

		System.out.println(" ");
		System.out.println(" == Designated Hitters == ");
		System.out.println(teamToDisplay.getDesignatedHitters());

		System.out.println(" ");
		System.out.println("The hole team is composed of : " + teamToDisplay);

		System.out.println(" ");
		System.out.println(" ===== We will win the season : " + extractYear() + " ===== ");
	}

	/**
	 * Extract the year.
	 * 
	 * @return
	 */
	private static Integer extractYear() {
		// The new date
		Date currentYear = new Date();
		// This getYear is deprecated and returns wrong values! Stupid JAVA!
		// currentYear.getYear();
		String yearTmp = currentYear.toString();
		// Because "CEST 2016" at the end
		String yearCompute = yearTmp.substring(yearTmp.lastIndexOf('T'));
		Integer year = Integer.valueOf(yearCompute.trim());
		return year;
	}
}
