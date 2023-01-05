/**
 * Contains methods to report finalResults of the game, which is stored in 
 * resultsTable. 
 * Calculates totals to fill in the last row and column in the table; 
 * Formats the completed table for printing.
 * 
 * @author YeongWoo Kim
 *
 */
public class Reporter {
	
	public static void printFinalResults(int[][] resultsTable, int mode, int roundNumber) {
		printFinalResultsHeader();
		printResultsTableHeader(mode);
		calculateTotal(resultsTable);
		printResultsTable(resultsTable, mode, roundNumber);
	}
	
	private static void printResultsTable(int[][] resultsTable, int mode, int roundNumber) {
		int dimension = resultsTable.length;
		if (mode == 0) {
			for (int c  = 0; c < dimension; c++) {
        		System.out.print(String.format("%" + 4 + "d", resultsTable[0][c]));
        	}
			System.out.print(NEWLINE + MODE0_SPACE + P_ROW_LABEL);
			for (int c  = 0; c < dimension; c++) {
        		System.out.print(String.format("%" + 4 + "d", resultsTable[1][c]));
        	}
			System.out.print(NEWLINE + MODE0_SPACE + S_ROW_LABEL);
			for (int c  = 0; c < dimension; c++) {
        		System.out.print(String.format("%" + 4 + "d", resultsTable[2][c]));
        	}
			System.out.print(NEWLINE + MODE0_TOT_ROW_LABEL);
			for (int c  = 0; c < dimension; c++) {
        		System.out.print(String.format("%" + 4 + "d", resultsTable[3][c]));
        	}
        	System.out.print("/" + roundNumber + NEWLINE);
			
		}
		else {
			for (int c  = 0; c < dimension; c++) {
        		System.out.print(String.format("%" + 4 + "d", resultsTable[0][c]));
        	}
        	System.out.print(NEWLINE + MODE1and2_SPACE + P_ROW_LABEL);
        	for (int c  = 0; c < dimension; c++) {
        		System.out.print(String.format("%" + 4 + "d", resultsTable[1][c]));
        	}
        	System.out.print(NEWLINE + MODE1and2_SPACE + S_ROW_LABEL);
        	for (int c  = 0; c < dimension; c++) {
        		System.out.print(String.format("%" + 4 + "d", resultsTable[2][c]));
        	}
        	if (mode == 1) {
        		System.out.print(NEWLINE + MODE1and2_SPACE + L_ROW_LABEL);
            	for (int c  = 0; c < dimension; c++) {
            		System.out.print(String.format("%" + 4 + "d", resultsTable[3][c]));
            	}
            	System.out.print(NEWLINE + MODE1and2_SPACE + K_ROW_LABEL);
            	for (int c  = 0; c < dimension; c++) {
            		System.out.print(String.format("%" + 4 + "d", resultsTable[4][c]));
            	}
        	}
        	else {  // mode == 2
        		System.out.print(NEWLINE + MODE1and2_SPACE + F_ROW_LABEL);
            	for (int c  = 0; c < dimension; c++) {
            		System.out.print(String.format("%" + 4 + "d", resultsTable[3][c]));
            	}
            	System.out.print(NEWLINE + MODE1and2_SPACE + W_ROW_LABEL);
            	for (int c  = 0; c < dimension; c++) {
            		System.out.print(String.format("%" + 4 + "d", resultsTable[4][c]));
            	}
        	}
        	System.out.print(NEWLINE + MODE1and2_TOT_ROW_LABEL);
            for (int c  = 0; c < dimension; c++) {
            	System.out.print(String.format("%" + 4 + "d", resultsTable[5][c]));
            }
            System.out.print("/" + roundNumber + NEWLINE);
		}
	}
	
	private static void calculateTotal(int[][] resultsTable) {
		int dimension = resultsTable.length;
		int total = 0;
		// calculate totals for each row except for the final row.
		for (int i = 0; i < dimension - 1; i++) {
			for (int j = 0; j < dimension - 1; j++) {
				resultsTable[i][dimension - 1] += resultsTable[i][j];
			}
		}
		// calculate totals for each column except for the final column.
		for (int i = 0; i < dimension - 1; i++) {
			for (int j = 0; j < dimension - 1; j++) {
				resultsTable[dimension - 1][i] += resultsTable[j][i];
			}
		}
		for (int i = 0; i < dimension - 1; i++) {
			total += resultsTable[dimension - 1][i];
		}
		resultsTable[dimension - 1][dimension - 1] = total;
	}
	
	private static void printFinalResultsHeader() {
		System.out.println(FINAL_RESULTS_HEADER);
	}
	
	private static void printResultsTableHeader(int mode) {
		switch (mode) {
			case 0:
				System.out.print(MODE0_COLUMN_LABEL);
				break;
			case 1:
				System.out.print(MODE1_COLUMN_LABEL);
				break;
			case 2:
				System.out.print(MODE2_COLUMN_LABEL);
				break;
		}
	}
	
	private static final String FINAL_RESULTS_HEADER = "                  Final Results of the Game\n\n"
                                                     + "                             You";
	
	private static final String MODE0_COLUMN_LABEL = "                        R   P   S  Tot\n"
												   + "                      -----------------\n" 
												   + "          Computer R |";  

	private static final String MODE1_COLUMN_LABEL = "                   R   P   S   L   K  Tot\n"
   			 									   + "                 -------------------------\n" 
   			 									   + "     Computer R |";
	
	private static final String MODE2_COLUMN_LABEL = "                   R   P   S   F   W  Tot\n" 
   			 									   + "                 -------------------------\n"
   			 									   + "     Computer R |";
	private static final String NEWLINE = "\n";
	private static final String P_ROW_LABEL = "P |";
	private static final String S_ROW_LABEL = "S |";
	private static final String K_ROW_LABEL = "K |";
	private static final String L_ROW_LABEL = "L |";
	private static final String F_ROW_LABEL = "F |";
	private static final String W_ROW_LABEL = "W |";
	private static final String MODE0_TOT_ROW_LABEL = "                 Tot |";
	private static final String MODE1and2_TOT_ROW_LABEL = "            Tot |";
	private static final String MODE0_SPACE = "                   ";
	private static final String MODE1and2_SPACE = "              "; 
	
}
