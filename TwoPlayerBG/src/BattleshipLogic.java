
public class BattleshipLogic {
	private int[][] p1ShipP2Hit;
	private int[][] p2ShipP1Hit;
	private int p1Lives;
	private int p2Lives;
	
	public BattleshipLogic(){
		p1ShipP2Hit = new int[10][10];
		p2ShipP1Hit = new int[10][10];
		p1Lives = 17;
		p2Lives = 17;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				p1ShipP2Hit[i][j] = 0;
				p2ShipP1Hit[i][j] = 0;
			}
		}
	}
	
	private int convertStringToArrayVal(String userInput) {
			if(userInput.equalsIgnoreCase("A") || userInput.equalsIgnoreCase("1")) {
				return 0;
			}
			else if (userInput.equalsIgnoreCase("B") ||userInput.equalsIgnoreCase("2")) {
				return 1;
			}
			else if (userInput.equalsIgnoreCase("C") ||userInput.equalsIgnoreCase("3")) {
				return 2;
			}
			else if (userInput.equalsIgnoreCase("D") ||userInput.equalsIgnoreCase("4")) {
				return 3;
			}
			else if (userInput.equalsIgnoreCase("E") ||userInput.equalsIgnoreCase("5")) {
				return 4;
			}
			else if (userInput.equalsIgnoreCase("F") ||userInput.equalsIgnoreCase("6")) {
				return 5;
			}
			else if (userInput.equalsIgnoreCase("G") ||userInput.equalsIgnoreCase("7")) {
				return 6;
			}
			else if (userInput.equalsIgnoreCase("H") ||userInput.equalsIgnoreCase("8")) {
				return 7;
			}
			else if (userInput.equalsIgnoreCase("I") ||userInput.equalsIgnoreCase("9")) {
				return 8;
			}
			else if (userInput.equalsIgnoreCase("J") ||userInput.equalsIgnoreCase("10")) {
				return 9;
			}
			else {
				return -1;
			}
	}
	
	public boolean isGameOver() {
		return (p1Lives == 0) || (p2Lives == 0); 
	}
	
	private boolean isInputValid(String coordinate) {
		if(coordinate.length() < 2 || coordinate.length() > 3) {
			return false;
		}
		if(!Character.isLetter(coordinate.charAt(0))) {
			return false;
		}
		int row = convertStringToArrayVal(coordinate.substring(0,1));
		int col = convertStringToArrayVal(coordinate.substring(1,3));
		
		return (-1 != row && -1 != col);
		
		
		
	}
	
	
	public boolean placeShip(int player, String frontCoord, String backCoord, int ship) {
		if(!isInputValid(frontCoord) || !isInputValid(backCoord)) {
			return false;
		}
		
		int rowPosFront = convertStringToArrayVal(frontCoord.substring(0,1));
		int rowPosBack = convertStringToArrayVal(backCoord.substring(0,1));
		int colPosFront= convertStringToArrayVal(frontCoord.substring(1,3));
		int colPosBack = convertStringToArrayVal(backCoord.substring(1,3));
		
		int startLoc;
		int endLoc;
		int[][] board;
		
		if (1 == player) {
			board = this.p1ShipP2Hit;
		}
		else{
			board = this.p2ShipP1Hit;
		}
		
		if(!(rowPosFront == rowPosBack) ^ (colPosFront == colPosBack)) {
			return false;
		}
		
		else if(rowPosFront == rowPosBack) {
			if(Math.abs(rowPosFront-rowPosBack) != (ship -1)) {
				return false;
			}
			
			startLoc = Math.min(colPosFront, colPosBack);
			endLoc = Math.max(colPosFront, colPosBack);
			
			for(int i = startLoc; i <= endLoc; i++) {
				if(board[rowPosFront][i] == 1) {
					return false;
				}
			}
			
			for(int i = startLoc; i <= endLoc; i++) {
				board[rowPosFront][i] = 1;
			}
			
			
		}
		
		else{
			if(Math.abs(colPosFront-colPosBack) != (ship -1)) {
				return false;
			}
			
			startLoc = Math.min(rowPosFront, rowPosBack);
			endLoc = Math.max(rowPosFront, rowPosBack);
			
			for(int i = startLoc; i <= endLoc; i++) {
				if(board[i][colPosFront] == 1) {
					return false;
				}
			}
			
			for(int i = startLoc; i <= endLoc; i++) {
				board[i][colPosFront] = 1;
			}
			
		}
		
		if (1 == player) {
			this.p1ShipP2Hit = board;
		}
		else{
			this.p2ShipP1Hit = board;
		}
		
		return true;
		
	}
	
	public int placeHit(String coordinate, int player){
		int board[][];
		int lives;
		int coord;
		
		if(!isInputValid(coordinate)) {
			return 2;
		}
		if (1 == player){
			board = this.p2ShipP1Hit;
			lives = p2Lives;
		}
		else {
			board = this.p1ShipP2Hit;
			lives = p1Lives;	
		}
		
		int row = convertStringToArrayVal(coordinate.substring(0,1));
		int col = convertStringToArrayVal(coordinate.substring(1,3));
		coord = board[row][col];
		
		if(1 == coord) {
			board[row][col] = 2;
			lives--;
			
		}
		
		if (1 == player){
			this.p2ShipP1Hit = board;
			p2Lives = lives;
		}
		else {
			this.p1ShipP2Hit = board;
			p1Lives = lives;	
		}
		
		return coord;
				
	}
		
}
