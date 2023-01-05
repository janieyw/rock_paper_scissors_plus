import java.util.Arrays;

/**
 * Records round results in resultsTable and tracks playerThrows to get 
 * favPlayerThrow, which is used to generate a computer throw for AI strategy.
 * 
 * @author YeongWoo Kim
 *
 */
public class Historian {
	
	public static int[][] initializeResultsTable(int mode) {
		if (mode == 0) {
			resultsTable = new int[4][4];
		}
		else {
			resultsTable = new int[6][6];
		}
		// initialize values of all indexes to 0.
		for (int[] row : resultsTable)
		    Arrays.fill(row, 0);
		return resultsTable;
	}
	
	// from the perspective of the player
	public static void updateResultsTable(Round round,
								   char computerThrow, char playerThrow) {
		int computerThrowIndex = Throw.parseCharToInt(computerThrow);
		int playerThrowIndex = Throw.parseCharToInt(playerThrow);
		if (round.isComputerWin()) {
			resultsTable[computerThrowIndex][playerThrowIndex]--;
		}
		else {
			resultsTable[computerThrowIndex][playerThrowIndex]++;
		}
	}
	
	public static void updateFavPlayerThrow(char playerThrow) {
		int playerThrowIndex = Throw.parseCharToInt(playerThrow);
		playerThrowCountTable[playerThrowIndex]++;
	}
	
	public static char getFavPlayerThrow(int mode) {
		int maxIndex = 0;
		for (int i = 1; i < playerThrowCountTable.length; i++) {
			if (playerThrowCountTable[maxIndex] < playerThrowCountTable[i]) {
				maxIndex = i;
			}
		}
		return Throw.parseIntToChar(mode, maxIndex);
	}
	
	private static int[][] resultsTable;
	private static int[] playerThrowCountTable = new int[5];
	
}
