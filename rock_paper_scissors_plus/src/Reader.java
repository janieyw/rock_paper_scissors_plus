import java.util.Scanner;

/**
 * Assists Talker with reading from user input. 
 * Ensures that user input is valid by requesting new input until a valid 
 * value is received.
 * 
 * @author YeongWoo Kim
 *
 */
public class Reader {

	public Reader() {
        scanner = new Scanner(System.in);
    }
	
	// valid input: 0, 1
	public int readStrategy() {
		String input = scanInput();
		while (!isValidStrategy(input)) {
			printInvalidInputMessage();
			input = scanInput();   
		}
		return Integer.parseInt(input);
	}
	
	// valid input: 0, 1 ,2
	public int readMode() {
		String input = scanInput();
		while (!isValidMode(input)) {
		    printInvalidInputMessage();
		    input = scanInput();
		}
		return Integer.parseInt(input);
	}
	
	// TODO: take mode as argument?
	public char readPlayerThrow(int mode) {
		String input = scanInput();
		while (!isValidThrow(input, mode)) {
			printInvalidInputMessage();
			input = scanInput();
		}
		return convertInputToChar(input);
	}

	private void printInvalidInputMessage() {
		System.out.print(INVALID_INPUT_MESSAGE);
	}
	
	private String scanInput() {
		return scanner.nextLine();
	}
	
	private boolean isChar(String input) {
		return input.length() == 1;
	}
	
	// TODO: contains repetitive code similar to isValidMode()!
	private boolean isValidStrategy(String input) {
		if (!isChar(input)) {
			return false;
		}
		int inputToInt = converInputToInt(input);
		if (inputToInt == 0 || inputToInt == 1) {
			return true;
		}
		return false;
	}
	
	// TODO: contains repetitive code similar to isValidStrategy()!
	private boolean isValidMode(String input) {
		if (!isChar(input)) {
			return false;
		}
		int inputToInt = converInputToInt(input);
		if (inputToInt == 0 || inputToInt == 1 || inputToInt == 2) {
			return true;
		}
		return false;
	}
	
	private boolean isValidThrow(String input, int mode) {
		if (!isChar(input)) {
			return false;
		}
		char inputToChar = convertInputToChar(input);
		switch (mode) {
			case 0:
				return isValidThrow_RPS(inputToChar);
			case 1:
				return isValidThrow_RPSLK(inputToChar);
			case 2:
				return isValidThrow_RPSFW(inputToChar);
			default: 
				throw new IllegalArgumentException();
		}
 	}
	
	// valid input for mode 0: r, p, s
	private boolean isValidThrow_RPS(char t) {
		return (t == 'r' || t == 'p' || t == 's');
	}
	
	// valid input for mode 1: r, p, s, k, l
	private boolean isValidThrow_RPSLK(char t) {
		return (isValidThrow_RPS(t) || t == 'l' || t == 'k');
	}
	
	// valid input for mode 2: r, p, s, f, w
	private boolean isValidThrow_RPSFW(char t) {
		return (isValidThrow_RPS(t) || t == 'f' || t == 'w');
	}
		
	private char convertInputToChar(String input) {
		return Character.toLowerCase(input.charAt(0));
	}
	
	private int converInputToInt(String input) {
		char inputToChar = convertInputToChar(input);
		return Character.getNumericValue(inputToChar);
	}
	
	private static Scanner scanner;
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid input! Try again : ";

}
