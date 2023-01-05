/**
 * Handles all requests to print to the console or read from user input.
 * Assisted by Reader with reading from user input.
 * 
 * @author YeongWoo Kim
 *
 */
public class Talker {
	
	public Talker() {
		this.reader = new Reader();
	}
	
	public int getStrategy() {
		printStrategyRequest();
		int strategy = readStrategy();
		return strategy;
	}
	
	public int getMode() {
		printModeRequest();
		int mode = readMode();
		return mode;
	}
	
	public char getPlayerThrow(int mode) {
		printThrowRequest(mode);
		char playerThrow = readPlayerThrow(mode);
		return playerThrow;
	}
	
	public void printWelcomeMessage() {
		System.out.println(WELCOME_MESSAGE);
	}
	
	public void printLineSeparator() {
		System.out.println(LINE_SEPARATOR);
	}
	
	// should explain rules for each game mode?
	public void printRulesMessage() {
		System.out.println(RULES_MESSAGE);
	}
	
	public void printRoundSummary(Round round) {
		RoundSummarizer.printRoundSummary(round);
	}
	
	public void printByeMessage() {
		System.out.println(BYE_MESSAGE);
	}
	
	private void printStrategyRequest() {
		System.out.print(STRATEGY_REQUEST);
	}
	
	private void printModeRequest() {
		System.out.print(MODE_REQUEST);
	}
	
	private void printThrowRequest(int mode) {
		switch (mode) {
			case 0:
				System.out.print(String.format(THROW_REQUEST, RPS));
				break;
			case 1:
				System.out.print(String.format(THROW_REQUEST, RPSLK));
				break;
			case 2:
				System.out.print(String.format(THROW_REQUEST, RPSFW));
				break;
		}
	}
	
	private int readStrategy() {
		return reader.readStrategy();
	}
	
	private int readMode() {
		return reader.readMode();
	}
	
	private char readPlayerThrow(int mode) {
		return reader.readPlayerThrow(mode);
	}
	
	private static final String WELCOME_MESSAGE = "=============================================================\n"
                                                + "            Welcome to Rock, Paper, Scissors PLUS!\n"
                                                + "=============================================================";
	
	private static final String LINE_SEPARATOR = "-------------------------------------------------------------";
	
	private static final String STRATEGY_REQUEST = "Would you like to play against AI?\n"
                                                 + "0. no\n"
                                                 + "1. yes\n"
                                                 + "Enter 0 or 1 : ";
	
	private static final String MODE_REQUEST = "In which game mode would you like to play?\n"
                                             + "0. Rock, Paper, Scissors\n"
                                             + "1. Rock, Paper, Scissors, Lizard, Spock\n"
                                             + "2. Rock, Paper, Scissors, Fire, Water\n"
                                             + "Enter 0, 1, or 2 : ";
	
	private static final String RULES_MESSAGE = "Type a character representing a move, then press enter.\n"  // or q for quit when prompted?
			                                  + "Enjoy!";
	
//	private static final String MODE0_RULES = "You've chosen Rock, Paper, Scissors (RPS)! In RPS...\n" 
//			                                + "r beats s\n"
//			                                + "p beats r\n"
//			                                + "s beats p";
//	
//	private static final String MODE1_RULES = "You've chosen Rock, Paper, Scissors, Lizard, Spock (RPSLK)! In RPSLK...\n" 
//            								+ "r beats s and l\n"
//            								+ "p beats r and k\n"
//            								+ "s beats p and l\n"
//            								+ "l beats k and p\n"
//            								+ "k beats s and r";
//	
//	private static final String MODE2_RULES = "You've chosen Rock, Paper, Scissors, Fire, Water (RPSFW)! In RPSFW...\n" 
//											+ "r beats s and w\n"
//											+ "p beats r and w\n"
//											+ "s beats p and w\n"
//											+ "f beats everything EXCEPT water\n"
//											+ "r beats f";
	
	private static final String THROW_REQUEST = "Enter move (%s) or (q)uit : ";

	private static final String RPS = "r, p, s";
	private static final String RPSLK = "r, p, s, l, k";
	private static final String RPSFW = "r, p, s, f, w";
	
	private static final String BYE_MESSAGE = "\n                           Goodbye!\n"
                                            + "=============================================================";
	
	private Reader reader;
	
}
