
/****************************************************************************
 *
 *Class serves as the logic for the Battleship Game for 2 player Board games.
 *The methods are designed to help with the implement of a GUI.
 *
 *@author Romandy Vu
 *@version January 28, 2022
 *
 *
 *****************************************************************************/
public class BattleshipLogic {

	/**Board of player 1 ship placement and player 2 hit placement.
	 *0 for an empty, 1 for a ship, 2 for a damaged ship location*/
	private int[][] p1ShipP2Hit;

	/**Board of player 2 ship placement and player 1 hit placement.
	 * 0 for an empty, 1 for a ship, 2 for a damaged ship location*/
	private int[][] p2ShipP1Hit;

	/**The "lives" or ship parts undamaged for player 1.
	 *Used to help determine if game is over*/
	private int p1Lives;

	/**The "lives" or ship parts undamaged for player 2.
	 *Used to help determine if game is over*/
	private int p2Lives;

	/**Number of rows in a traditional Battleship game.*/
	private static final int ROWS = 10;

	/**Number of columns in a traditional Battleship game.*/
	private static final int COLS = 10;

	/**Spot sum of carrier, destroyer, submarine, cruiser and patrol boat.*/
	private static final int LIVES = 17;

	/**********************************************************************
	 *
	 * The constructor for the Battleship game, serving as a session/game.
	 *
	 **********************************************************************/
	public BattleshipLogic(){
	p1ShipP2Hit = new int[ROWS][COLS];
	p2ShipP1Hit = new int[ROWS][COLS];
	p1Lives = LIVES;
	p2Lives = LIVES;

	//Fills board with 0 to help with ship placement.
	for (int i = 0; i < ROWS; i++) {
		for (int j = 0; j < COLS; j++) {
			p1ShipP2Hit[i][j] = 0;
			p2ShipP1Hit[i][j] = 0;
		}
	}
}

	/***********************************************************************
	*
	* Helps convert the user input into array indexes.
	*
	* @param userInput A string of the user's ship or hit location.
	* @return an integer for the array index corresponding to user's input.
	* Returns -1 if the user input is invalid to help other methods.
	**********************************************************************/
	private int convertStringToArrayVal(final String userInput) {
			if (userInput.equalsIgnoreCase("A")
				|| userInput.equalsIgnoreCase("1")
				|| userInput.equalsIgnoreCase("01")) {
				return 0;

			} else if (userInput.equalsIgnoreCase("B")
					|| userInput.equalsIgnoreCase("2")
					|| userInput.equalsIgnoreCase("02")) {
				return 1;
			} else if (userInput.equalsIgnoreCase("C")
					|| userInput.equalsIgnoreCase("3")
					|| userInput.equalsIgnoreCase("03")) {
				return 2;

			} else if (userInput.equalsIgnoreCase("D")
					|| userInput.equalsIgnoreCase("4")
					|| userInput.equalsIgnoreCase("04")) {
				return 3;

			} else if (userInput.equalsIgnoreCase("E")
					|| userInput.equalsIgnoreCase("5")
					|| userInput.equalsIgnoreCase("05")) {
				return 4;

			} else if (userInput.equalsIgnoreCase("F")
					|| userInput.equalsIgnoreCase("6")
					|| userInput.equalsIgnoreCase("06")) {
				return 5;

			} else if (userInput.equalsIgnoreCase("G")
					|| userInput.equalsIgnoreCase("7")
					|| userInput.equalsIgnoreCase("07")) {
				return 6;

			} else if (userInput.equalsIgnoreCase("H")
					|| userInput.equalsIgnoreCase("8")
					|| userInput.equalsIgnoreCase("08")) {
				return 7;

			} else if (userInput.equalsIgnoreCase("I")
					|| userInput.equalsIgnoreCase("9")
					|| userInput.equalsIgnoreCase("09")) {
				return 8;

			} else if (userInput.equalsIgnoreCase("J")
					|| userInput.equalsIgnoreCase("10")) {
				return 9;

			} else {
				return -1;
			}
	}

	/**********************************************************************
	 *
	 *Determines if game is over so GUI stops looping for user's input.
	 *This should be a loop condition that prompts
	 *for player's input and after player 1 places their hit
	 *in that loop.
	 *
	 * @return true if all of player 1's or player 2's ships are destroyed.
	 **********************************************************************/
	public boolean isGameOver() {
		return (p1Lives == 0) || (p2Lives == 0);
	}

	/********************************************************************
	 *
	 * Determines if the user's input is a valid coordinate.
	 *
	 * @param coordinate is a string of the user's input.
	 * @return True if the input is valid, otherwise false.
	 ******************************************************************/
	private boolean isInputValid(final String coordinate) {
		//Checks if input is 2-3 characters long
		if (coordinate.length() < 2 || coordinate.length() > 3) {
			return false;
		}
		//Checks if first character is a letter
		if (!Character.isLetter(coordinate.charAt(0))) {
			return false;
		}
		int row = convertStringToArrayVal(coordinate.substring(0, 1));
		int col = convertStringToArrayVal(coordinate.substring(1, coordinate.length()));

		//Checks if input a valid coordinate.
		return (-1 != row && -1 != col);



	}


	/******************************************************************
	 *
	 * A method for placing the player's ship.
	 * Return value helps GUI determine to prompt user to try again.
	 * due to an invalid input.
	 * There should be:
	 * 1 carrier
	 * 1 battleship
	 * 1 cruiser
	 * 1 submarine
	 * 1 patrol boat for each board.
	 *
	 * @param player an integer to determine whose turn
	 * (1 == player 1, else player 2).
	 * @param frontCoord A coordinate to represent
	 * 1 of the ends of the ship to indicate ship placement.
	 * @param backCoord Another coordinate to represent
	 * 1 of the ends of the ship to indicate ship placement.
	 * @param ship an int to represent what ship the player is placing.
	 * 5 for carrier,
	 * 4 for Battleship,
	 * 3 for Cruiser/Submarine,
	 * 2 for Patrol Boat.
	 * @return true if the placement of the ship was successful.
	 * False if the input is invalid due to coordinates or overlapping
	 * placement of ships.
	 ******************************************************************/
	public boolean placeShip(final int player,
			final String frontCoord,
			final String backCoord,
			final int ship) {
		//Uses private method to check validity.
		if (!isInputValid(frontCoord) || !isInputValid(backCoord)) {
			return false;
		}
		/*Convert user's coordinate to array location
		 * rowPosFront = row location for front of ship (A-J)
		 * rowPosBack = row location for back of ship (A-J)
		 * colPosFront = column location for front of ship (1-10)
		 * colPosBack = column location for back of ship(1-10)
		 * */
		int rowPosFront = convertStringToArrayVal(frontCoord.substring(0,1));
		int rowPosBack = convertStringToArrayVal(backCoord.substring(0,1));
		int colPosFront= convertStringToArrayVal(frontCoord.substring(1,frontCoord.length()));
		int colPosBack = convertStringToArrayVal(backCoord.substring(1,backCoord.length()));

		//Used for checking and filling out the board
		int startLoc;
		int endLoc;
		int[][] board;

		//Gets the board according to parameter.
		if (1 == player) {
			board = this.p1ShipP2Hit;
		} else {
			board = this.p2ShipP1Hit;
		}

		//Checks it input is valid (the ends are the same location)
		if (!(rowPosFront == rowPosBack) ^ (colPosFront == colPosBack)){
			return false;

		//Indicates that player wants the ship in the same row.
		} else if (rowPosFront == rowPosBack) {
			//Checks if coordinates are properly distanced.
			if (Math.abs(colPosFront - colPosBack) != (ship - 1)) {
				return false;
			}

			startLoc = Math.min(colPosFront, colPosBack);
			endLoc = Math.max(colPosFront, colPosBack);

			//Checks if any of the coordinates are taken.
			for (int i = startLoc; i <= endLoc; i++) {
				if (board[rowPosFront][i] == 1) {
					return false;
				}
			}

			//Places the ship
			for (int i = startLoc; i <= endLoc; i++) {
				board[rowPosFront][i] = 1;
			}

		//Indicates the player wants the ship in the same column
		} else {
			//Checks end coordinates are properly distanced.
			if (Math.abs(rowPosFront - rowPosBack) != (ship - 1)) {
				return false;
			}

			startLoc = Math.min(rowPosFront, rowPosBack);
			endLoc = Math.max(rowPosFront, rowPosBack);

			//Checks if any of the coordinates are taken.
			for (int i = startLoc; i <= endLoc; i++) {
				if (board[i][colPosFront] == 1) {
					return false;
				}
			}
			//Places the ship
			for (int i = startLoc; i <= endLoc; i++) {
				board[i][colPosFront] = 1;
			}

		}
		//Updates the player's board.
		if (1 == player) {
			this.p1ShipP2Hit = board;
		} else {
			this.p2ShipP1Hit = board;
		}

		return true;

	}

	/*******************************************************************
	 *
	 * A method to help the GUI determine whether to create a pop of if
	 * the player hit something or input is invalid
	 *(due to invalid coordinates, or location they already placed)
	 * and should try again.
	 *
	 * @param coordinate where the player wants to hit.
	 * @param player which player's turn (1 for player 1, else player 2)
	 * @return 0 if the player did not hit anything,
	 * 1 if the player hits a ship,
	 * 2 if the user input is invalid.
	 ******************************************************************/
	public int placeHit(final String coordinate, final int player) {
		int[][] board;
		int lives;
		int coord;

		//Check if input is valid
		if (!isInputValid(coordinate)) {
			return 2;
		}
		//Determines which board to use.
		if (1 == player){
			board = this.p2ShipP1Hit;
			lives = p2Lives;
		} else {
			board = this.p1ShipP2Hit;
			lives = p1Lives;
		}

		int row = convertStringToArrayVal(coordinate.substring(0, 1));
		int col = convertStringToArrayVal(coordinate.substring(1,coordinate.length()));
		coord = board[row][col];

		//Player hit a ship
		if (1 == coord) {
			board[row][col] = 2;
			lives--;

		} else if (0 == coord) {
			board[row][col] = 2;
		}

		//Updates board
		if (1 == player){
			this.p2ShipP1Hit = board;
			p2Lives = lives;
		} else {
			this.p1ShipP2Hit = board;
			p1Lives = lives;
		}

		return coord;

	}

	/*****************************************************************
	 *
	 * Resets the a board of a player.
	 * Used to help the GUI prompt a message if a player
	 * wants to reset their ship placements before placing hits.
	 *
	 * @param player whose board to reset.
	 * (1 for player 1, 2 for player 2)
	 *****************************************************************/
	public void resetBoard(final int player) {
		int[][] board = new int[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = 0;
			}
		}

		if (1 == player) {
			this.p1ShipP2Hit = board;
		}

		if (2 == player) {
			this.p2ShipP1Hit = board;
		}

	}

	/**************************************************************
	 *
	 * Sends back the board of a particular player.
	 * Used to help the GUI show the placement of the player's ship
	 * when considering other ship placements.
	 *
	 * This is also used for testing the class.
	 *
	 * @param player the player's ship placement board
	 * (1 for player 1, else player 2).
	 * @return the player's current board during ship placement.
	 *************************************************************/
	public int[][] getBoard(final int player) {
		if (1 == player) {
			return this.p1ShipP2Hit;
		}
		return this.p2ShipP1Hit;
	}

	/**********************************************************************
	 *
	 * Returns the lives of a player. (Used for testing)
	 *
	 * @param player the player's lives being looked
	 * (1 for player 1, else for player 2)
	 * @return the lives of the specified player
	 *********************************************************************/
	public int getLives(final int player) {
		if (1 == player) {
			return p1Lives;
		} else {
			return p2Lives;
		}
	}

	/************************************************************
	 *
	 * Returns the value of a coordinate. (Used for testing).
	 *
	 * @param coordinate the coordinate being looked at.
	 * @param player the board looked at (1 for player 1, else player 2).
	 * @return the value of the coordinate (1,2,3), -1 if invalid.
	 *************************************************************/
	public int getCoordinateData(final String coordinate, final int player){
		int[][] board = getBoard(2);
		if (1 == player) {
			board = getBoard(1);
		}

		int row = convertStringToArrayVal(coordinate.substring(0,1));
		int col = convertStringToArrayVal(coordinate.substring(1,coordinate.length()));

		if (-1 == row || -1 == col){
			return -1;
		}
		return board[row][col];

	}



}
