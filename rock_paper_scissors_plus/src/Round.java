/**
 * Represents a round. 
 * 
 * @author YeongWoo Kim
 *
 */
public class Round {

	public Round(char computerThrow, char playerThrow) {
		this.computerThrow = computerThrow;
		this.playerThrow = playerThrow;
	}
	
	public char getComputerThrow() {
		return computerThrow;
	}
	
	public char getPlayerThrow() {
		return playerThrow;
	}
	
	public boolean isTie() {
		return Referee.isTie(computerThrow, playerThrow);
	}
	
	public boolean isComputerWin() {
		return Referee.isComputerWin(computerThrow, playerThrow);
	}
	
	private char computerThrow;
	private char playerThrow;
	
}
