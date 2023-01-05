/**
 * Contains two methods for conversion between char and int, which both 
 * represent a throw.
 * 
 * @author YeongWoo Kim
 *
 */
public class Throw {

	public static int parseCharToInt(char c) {
		switch (c) {
			case 'r':
				return 0;
			case 'p':
				return 1;
			case 's':
				return 2;
			case 'l': case 'f':
				return 3;
			case 'k': case 'w':
				return 4;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public static char parseIntToChar(int mode, int i) {
		switch (i) {
			case 0:
				return 'r';
			case 1:
				return 'p';
			case 2:
				return 's';
			case 3:
				if (mode == 1) return 'k';
				else return 'f';
			case 4:
				if (mode == 1) return 'l';
				else return 'w';
			default:
				throw new IllegalArgumentException();
		}
	}
	
}
