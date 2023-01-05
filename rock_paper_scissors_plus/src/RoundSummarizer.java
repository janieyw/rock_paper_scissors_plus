/**
 * Summarizes round results for printing.
 * 
 * @author YeongWoo Kim
 *
 */
public class RoundSummarizer {
	
	public static void printRoundSummary(Round round) {
		if (round.isTie()) {
			printTieMessage();
		}
		else if (round.isComputerWin()) {
			printComputerWinMessage();
		}
		else {  // !round.isComputerWin()
			printPlayerWinMessage();
		}	
 	}
	
	private static void printTieMessage() {
		System.out.println(TIE_MESSAGE);
	}
	
	private static void printComputerWinMessage() {
		System.out.println(COMPUTER_WIN_MESSAGE);
	}

	private static void printPlayerWinMessage() {
		System.out.println(PLAYER_WIN_MESSAGE);
	}
	
	private static final String TIE_MESSAGE = "Tie!";
	private static final String COMPUTER_WIN_MESSAGE = "Computer wins!"; 
	private static final String PLAYER_WIN_MESSAGE = "Player wins!"; 
	
}
