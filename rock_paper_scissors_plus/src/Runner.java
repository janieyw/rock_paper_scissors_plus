/**
 * Runner for the RPS+ program.
 * 
 * @author YeongWoo Kim
 *
 */
public class Runner {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		int[][] resultsTable;
		int roundNumber = 0;
		
		controller.welcomePlayer();
		controller.getStrategy();
		controller.getMode();
		controller.explainRules();
		resultsTable = controller.initializeResultsTable();
		// TODO: allow quit?
		while (++roundNumber <= 100) {
			controller.printRoundNumber(roundNumber);
			controller.play();
		}
		controller.printFinalResults(resultsTable, roundNumber);
		controller.sayGoodbye();
		
	}
	
}
