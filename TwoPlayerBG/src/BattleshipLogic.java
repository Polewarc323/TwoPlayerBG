
public class BattleshipLogic {
	private int[][] p1ShipP2Hit;
	private int[][] p2ShipP1Hit;
	private int p1Lives;
	private int p2Lives;
	private boolean isGameOver;
	
	public BattleshipLogic(){
		p1ShipP2Hit = new int[10][10];
		p2ShipP1Hit = new int[10][10];
		p1Lives = 17;
		p2Lives = 17;
		isGameOver = false;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				p1ShipP2Hit[i][j] = 0;
				p2ShipP1Hit[i][j] = 0;
			}
		}
	}
	
	private int convertLetterToNum(String userInput) {
			char letter = userInput.toUpperCase().charAt(0);
			switch (letter) {
			case 'A':
				return 0;
			case 'B':
				return 1;
			case 'C':
				return 2;
			case 'D':
				return 3;
			case 'E':
				return 4;
			case 'F':
				return 5;
			case 'G':
				return 6;
			case 'H':
				return 7;
			case 'I':
				return 8;
			case 'J':
				return 9;
			default:
				return -1;
			}
	}
}
