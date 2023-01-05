/**
 * Determines if a round results in a tie or a computer win, given 
 * computerThrow and playerThrow.
 * 
 * @author YeongWoo Kim
 *
 */
public class Referee {

	public static boolean isTie(char computerThrow, char playerThrow) {
		 return computerThrow == playerThrow;
	}
	
	public static boolean isComputerWin(char computerThrow, char playerThrow) {
		switch (computerThrow) {
			case 'r':
				return (playerThrow == 's' || playerThrow == 'l' || 
				        playerThrow == 'w');
			case 'p':
				return (playerThrow == 'r' || playerThrow == 'k' || 
		        		playerThrow == 'w');
			case 's':
				return (playerThrow == 'p' || playerThrow == 'l' || 
	    				playerThrow == 'w');
			case 'l':
				return (playerThrow == 'k' || playerThrow == 'p');
			case 'k':
				return (playerThrow == 's' || playerThrow == 'r');
			case 'f':
				return (playerThrow == 'r' || playerThrow == 'p' || 
	    				playerThrow == 's');
			case 'w':
				return (playerThrow == 'f');
			default:
				throw new IllegalArgumentException();
		}
	}
	
}
