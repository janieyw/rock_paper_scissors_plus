/**
 * Manages the core game logic. Invoked by main.
 * 
 * @author YeongWoo Kim
 *
 */
public class Controller {

	public Controller() {
		talker =  new Talker();
		thrower = new Thrower();
	}
	
	public void welcomePlayer() {
		talker.printWelcomeMessage();
	}
	
	public int getStrategy() {
		STRATEGY = talker.getStrategy();
		talker.printLineSeparator();
		return STRATEGY;
	}
	
	public int getMode() {
		MODE = talker.getMode();
		talker.printLineSeparator();
		return MODE;
	}
	
	public void explainRules() {
		talker.printRulesMessage();
		talker.printLineSeparator();
	}
	
	public int[][] initializeResultsTable() {
		return Historian.initializeResultsTable(MODE);
	}
	
	public void printRoundNumber(int roundNumber) {
		System.out.println(String.format("Round %d", roundNumber));
	}
	
	public void play() {
		createRound();
		updateFavPlayerThrow();
		printComputerThrow();
		printRoundSummary();
		while (round.isTie()) {
			createRound();
			updateFavPlayerThrow();
			printComputerThrow();
			printRoundSummary();
		}
		updateResultsTable();
		talker.printLineSeparator();
	}

	public void printFinalResults(int[][] resultsTable, int roundNumber) {
		Reporter.printFinalResults(resultsTable, MODE, roundNumber);
	}
	
	public void sayGoodbye() {
		talker.printByeMessage();
	}
	
	private Round createRound() {
		playerThrow = getPlayerThrow();
		if (STRATEGY == 0) {
			computerThrow = getComputerThrow();
		}
		else {  // STRATEGY == 1
			computerThrow = getAIThrow();
		}
		return round = new Round(computerThrow, playerThrow);
	}
	
	private void printComputerThrow() {
		System.out.println("Computer throws " + computerThrow + "! ");
	}
	
	private char getComputerThrow() {
		char computerThrow = thrower.getComputerThrow(MODE);
		return computerThrow;
	}
	
	private char getAIThrow() {
		favPlayerThrow = getFavPlayerThrow();
		char computerThrow = thrower.getAIThrow(favPlayerThrow);
		return computerThrow;
	}
	
	private char getPlayerThrow() {
		char playerThrow = talker.getPlayerThrow(MODE);
		return playerThrow;
	}
	
	private void updateResultsTable() {
		Historian.updateResultsTable(round, computerThrow, playerThrow);
	}
	
	private char getFavPlayerThrow() {
		favPlayerThrow = Historian.getFavPlayerThrow(MODE);
		return favPlayerThrow;
	}
	
	private void updateFavPlayerThrow() {
		Historian.updateFavPlayerThrow(playerThrow);
	}
	
	private void printRoundSummary() {
		talker.printRoundSummary(round);
	}

	public static int STRATEGY;
	public static int MODE;
	
	public static char computerThrow;
	public static char playerThrow;
	public static char favPlayerThrow;
	
	Talker talker;
	Thrower thrower;
	Round round;
			
}
