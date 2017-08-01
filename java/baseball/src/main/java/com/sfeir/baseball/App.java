package com.sfeir.baseball;

import java.util.HashSet;

/**
 * Red Sox the best team ever!
 * <b>Yankees Sucks</b>
 * 
 * Fun Jokes: 
 * <p><b>Q:</b> What's the difference between dirt and the New York Yankees?<br> 
 * <b>A:</b> Nothing...they both always get swept.</p>
 * 
 *  
 * <p><b>Q:</b> What is the difference between a Yankees fan and a baby?
 * <b>A:</b> The baby will stop whining after a while. </p>
 */
public class App {
	static String MLB_LOGO = "               Boston  Red Sox Baseball  Boston   Red Sox  Baseball \n"
				+ "              BA                            SEB                   A \n"
				+ "              LL                   S.F.Gia    BAS                 EB \n"
				+ "              AL                  LBoston\"    A\'s                 \"B \n"
				+ "              AS                 EBALLS.F.G      ia               nt \n"
				+ "              sB                  ASEBALLS.       F.G             ia \n"
				+ "              BA                   SEBALLOakland\"A\'s\"B            AS \n"
				+ "              EB                 ALLS.F.GiantsBASEBALLS.          F. \n"
				+ "              Gi   aBA          SEBALLOakland\"A\'s\"BASEBALL        S. \n"
				+ "              F.   Gia         ntsBASEBALLS.F.GiaBASEBALLO        ak \n"
				+ "               l                 and\"A\'s\"BASEBALLS.F.             Gi \n"
				+ "                a                ntsBASEBALLS.F.GiaBA            S\n"
				+ "                 S.F. Giants Baseball S.F. Giants Baseball'";

	public static void main(String[] args) {
 
		// David Ortiz
		String namePlayer1 = "Ortiz";
		String firstNamePlayer1 = "David";
		Player davidOrtiz = new Player();
		davidOrtiz.setName(namePlayer1);
		davidOrtiz.setFirstName(firstNamePlayer1);
		davidOrtiz.setPosition(Position.DESIGNATEDHITTER);

		// David Price
		String namePlayer2 = "Price";
		String firstNamePlayer2 = "David";
		Player davidPrice = new Player();
		davidPrice.setName(namePlayer2);
		davidPrice.setFirstName(firstNamePlayer2);
		davidPrice.setPosition(Position.PITCHER);

		// David Wells
		String namePlayer3 = "Wells";
		String firstNamePlayer3 = "David";
		Player davidWells = new Player();
		davidWells.setName(namePlayer3);
		davidWells.setFirstName(firstNamePlayer3);
		davidWells.setPosition(Position.PITCHER);

		//TODO: Add Jhon Farrell as a Manager?! How can I do that? Java Is so complicated
		String nameManager = "Farrell";
		String firstNameManager = "Jhon";
		Person jhonFarrell = new Person();
		jhonFarrell.setName(nameManager);
		jhonFarrell.setFirstName(firstNameManager);
		
		// R
		Team redSox = new Team("Red Sox", "Boston", "Fenway Park", true, jhonFarrell);
		TeamManagement teamManagement = new TeamManagement(redSox);
		
		// Add David Price, David Ortiz and David Wells
		// We had such a great team now two super famous pitchers! We gonna win
		// the MLB.
		HashSet<Player> allPlayers1 = teamManagement.addAPlayerToATeam(redSox.getPlayers(), davidOrtiz);
		HashSet<Player> allPlayers2 = teamManagement.addAPlayerToATeam(allPlayers1, davidPrice);
		HashSet<Player> allPlayers3 = teamManagement.addAPlayerToATeam(allPlayers2, davidWells);

		redSox.setPlayers(allPlayers3);

		// Set the team to the player
		davidPrice.setCurrentTeam(redSox);
		davidOrtiz.setCurrentTeam(redSox);
		davidWells.setCurrentTeam(redSox);

		
		
		System.out.println(MLB_LOGO);
		System.out.println(" ");

		DisplayTheTeamUtils.displayTheTeam(teamManagement);
	}
}
