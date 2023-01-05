import java.util.Random;

/**
 * Generates throws for computer.
 * Contains two methods to do this, each for each strategy.
 * 
 * @author YeongWoo Kim
 *
 */
public class Thrower {

	public Thrower() {
		this.random = new Random();
	}
	
	// for strategy 0
	public char getComputerThrow(int mode) {
		switch (mode) {
			case 0:
				return "rps".charAt(random.nextInt(3));
			case 1:
				return "rpskl".charAt(random.nextInt(5));
			case 2:
				return "rpsfw".charAt(random.nextInt(5));
			default:
				throw new IllegalArgumentException();
		}
	}
	
	// for strategy 1, against AI
	/**
	 * Returns a throw that beats the throw most preferred by the player.
	 * 
	 * TODO: get favorite player throw, and generate a throw that beats that
	 *  move
	 */
	public char getAIThrow(char favPlayerThrow) {
		switch (favPlayerThrow) {
		 	case 'r': case 'k':
		 		return 'p';
		 	case 'p': case 'l':
		 		return 's';
		 	case 's': case 'w':
		 		return 'r';
		 	case 'f':
		 		return 'w';
		 	default:
		 		throw new IllegalArgumentException();
	    }
	}
	
	Random random;
	
}
