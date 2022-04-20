//Used to help computer place ships and hits.
import java.util.Random;
import java.util.ArrayList;

/****************************************************************************
 *
 *Class serves as the logic for the Battleship Game for 2 player Board games.
 *The methods are designed to help with the implement of a GUI
 *such as getting the lives of the player, board data, if game is over,
 *getting the row or column index from coordinates.
 *The class contains method for unit testing.
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

	/**Smallest ship piece (patrol boat at length 2). */
	private static final int MIN_SHIP_SIZE = 2;

	/**Largest ship piece (Cruiser at length 5). */
	private static final int MAX_SHIP_SIZE = 5;

	/**Helps computer keep track of coordinate of a ship hit.*/
	private ArrayList<int[]> compHitList;

	/**Represents the player number of the computer,
	 * if option is to play against computer.*/
	private static final int COMPUTER = 2;

	/**Keeps track of the row the computer placed their hits.*/
	private int compRecentRow;

	/**Keeps track of the col the computer placed their hits.*/
	private int compRecentCol;

	/**Keeps track of the result of the recent computer hit.*/
	private int compRecentResult;

	/**********************************************************************
	 *
	 * The constructor for the Battleship game, serving as a session/game.
	 *
	 **********************************************************************/
	public BattleshipLogic() {
	p1ShipP2Hit = new int[ROWS][COLS];
	p2ShipP1Hit = new int[ROWS][COLS];
	p1Lives = LIVES;
	p2Lives = LIVES;
	compHitList = new ArrayList<int[]>();


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
		int row = getRowIndex(coordinate);
		int col = getColIndex(coordinate);

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

		/*Check if the ship is a valid ship from int
		 * though the user won't be determining the ship size
		 * Only the GUI, but just in case.
		 */

		if (MIN_SHIP_SIZE > ship || MAX_SHIP_SIZE < ship) {
			return false;
		}
		/*Convert user's coordinate to array location
		 * rowPosFront = row location for front of ship (A-J)
		 * rowPosBack = row location for back of ship (A-J)
		 * colPosFront = column location for front of ship (1-10)
		 * colPosBack = column location for back of ship(1-10)
		 * */
		int rowPosFront = getRowIndex(frontCoord);
		int rowPosBack = getRowIndex(backCoord);
		int colPosFront = getColIndex(frontCoord);
		int colPosBack = getColIndex(backCoord);

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
		if (!(rowPosFront == rowPosBack)
				^ (colPosFront == colPosBack)) {
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
		if (1 == player) {
			board = this.p2ShipP1Hit;
			lives = p2Lives;
		} else {
			board = this.p1ShipP2Hit;
			lives = p1Lives;
		}

		int row = convertStringToArrayVal(coordinate.substring(0, 1));
		int col = convertStringToArrayVal(coordinate.substring(
				1, coordinate.length()));
		coord = board[row][col];

		//Player hit a ship
		if (1 == coord) {
			board[row][col] = 2;
			lives--;

		}
		if (0 == coord) {
			board[row][col] = 2;
		}


		//Updates lives
		if (1 == player) {
			p2Lives = lives;
		} else {
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
		int[][] source;
		int[][] copy = new int[ROWS][COLS];

		if (1 == player) {
			source = this.p1ShipP2Hit;
		} else {
		source = this.p2ShipP1Hit;
		}

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				copy[i][j] = source[i][j];
			}
		}

		return copy;
	}

	/****************************************************************
	 *
	 * Sends the row and column an array for the GUI to help with
	 * updating.
	 *
	 * @param coordinate the coordinate to get the row and column
	 * index from.
	 * @return an array containing [row, column] respectively.
	 ****************************************************************/
	public int[] getRowAndColIndex(final String coordinate) {

		int row = convertStringToArrayVal(coordinate.substring(0, 1));
		int col = convertStringToArrayVal(coordinate.substring(
				1, coordinate.length()));

		int[] data = {row, col};

		return data;

	}

	/*****************************************************************
	 *
	 * Returns the row index for the array from the given coordinate.
	 * Used to help Battleship GUI.
	 *
	 * @param coordinate the coordinate to get the row index from.
	 * @return the row index (integer)
	 *****************************************************************/
	public int getRowIndex(final String coordinate) {
		return convertStringToArrayVal(coordinate.substring(0, 1));
	}

	/*********************************************************************
	 *
	 * Returns the column index for the array from the given coordinate.
	 * Used to help Battleship GUI.
	 *
	 * @param coordinate the coordinate to get the column index from.
	 * @return the column index (integer)
	 *********************************************************************/
	public int getColIndex(final String coordinate) {
		return convertStringToArrayVal(coordinate.substring(
				1, coordinate.length()));
	}

	/**********************************************************************
	 *
	 * Returns the lives of a player. ( Primarily used for testing)
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
	 * @return the value of the coordinate (0,1,2), -1 if invalid.
	 *************************************************************/
	public int getCoordinateData(
	final String coordinate, final int player) {
		int[][] board = getBoard(2);
		if (1 == player) {
			board = getBoard(1);
		}

		int row = getRowIndex(coordinate);
		int col = getColIndex(coordinate);

		if (-1 == row || -1 == col) {
			return -1;
		}
		return board[row][col];

	}
	
	/***********************************************************
	 * 
	 * @param row the row index (row # - 1) the player pressed.
	 * @param col the column index (column # - 1) the player pressed.
	 * @param player the player who is placing the hit.
	 * @return an integer value where 0 is a miss, 1 is a hit,
	 * 2 is an error by entering a location they already hit
	 * or invalid coordinate.
	 **********************************************************/
	public int placeHit(final int row, final int col, final int player){
		//Check if parameters are valid
		if (row < 0 || row >= ROWS || col < 0 || col >= COLS){
			return 2;
		}
		char letter = (char)(row + 65);
		int num = col + 1;
		String coordinate = letter + "" + num;
		
		
	return placeHit(coordinate, player);
	}
	
	/********************************************************
	 * 
	 * A helper method to place the computer's ship randomly
	 * on the board.
	 * 
	 * @param shipSize the length of the ship being placed.
	 * 
	 ********************************************************/
	private void computerPlaceShip(final int shipSize) {
		Random random = new Random();
		String frontCoord;
		String backCoord;
		char charPos;
		int numPos;
		int direction;
		int count = 0;
		int diff = shipSize - 1;

		do{
			//Get letter
			charPos = (char)(random.nextInt(10) + 65);
			numPos = random.nextInt(10);
			direction = random.nextInt(4);
			frontCoord = charPos + "" + numPos; 
			if (0 == direction){
				backCoord = ((char)(charPos - diff) + "" + numPos);
			}
			else if (1 == direction) {
				backCoord = charPos + "" + (numPos + diff); 
			}
			else if (2 == direction) {
				backCoord = (char) (charPos + diff) + "" + numPos;
			}
			else {
				backCoord = charPos + "" + (numPos - diff);
			}

			} while (!placeShip(COMPUTER, frontCoord, backCoord,  shipSize));

	}

	/********************************************************
	 *
	 * A method that places all the ships in the Battleship
	 * game.
	 ********************************************************/
	public void computerPlaceShips() {
		computerPlaceShip(5);
		computerPlaceShip(4);
		computerPlaceShip(3);
		computerPlaceShip(3);
		computerPlaceShip(2);
	}

	/*******************************************************
	 * Places the ship onto the board (array) for the player.
	 * This is an alternative to inputting the coordinates by
	 * click on the grid itself.
	 *
	 * Return value helps GUI determine to prompt user to try again.
	 * due to an invalid input.
	 * There should be:
	 * 1 carrier
	 * 1 battleship
	 * 1 cruiser
	 * 1 submarine
	 * 1 patrol boat for each board.
	 * 
	 * @param player the player who is placing the ships.
	 * @param frontRowIndex the row index of where the player
	 * wants the front of the ship to be.
	 * @param frontColIndex the column index where the player
	 * wants the front of the ship to be.
	 * @param backRowIndex the the row index where the player
	 * wants the back of the ship to be.
	 * @param backColIndex the column index where the player
	 * wants the back of the ship to be.
	 * @param ship the ship being placed.
	 * @return True if ship placement is successful, false
	 * otherwise.
	 ********************************************************/
	public boolean placeShip(final int player,
			final int frontRowIndex, final int frontColIndex,
			final int backRowIndex, final int backColIndex,
			final int ship) {
		String frontCoord;
		String backCoord;
		char frontLetter;
		char backLetter;
		int backNum = backColIndex + 1;
		int frontNum = frontColIndex + 1;

		frontLetter = (char)(65 + frontRowIndex);
		backLetter = (char)(65 + backRowIndex);

		frontCoord = frontLetter + "" + frontNum;
		backCoord = backLetter + "" + backNum;

		return placeShip(player, frontCoord, backCoord, ship);
	}


	/*********************************************************
	 *
	 *Method to call for the computer to place a hit.
	 *
	 * @return 0 if the computer missed,
	 * 1 if the computer hit a ship,
	 * 2 if the computer made an error placing a hit.
	 *******************************************************/
	public int computerPlaceHit(){
		Random random = new Random();
		int row;
		int col;
		int[] previousHit;
		int[] baseHit;
		int result;

		boolean upOk;
		boolean downOk;
		boolean leftOk;
		boolean rightOk;

		//Condition when computer has no idea where to hit
		if (compHitList.size() == 0) {
			return randomComputerHit();
		}
		//Condition where computer has 1 hit location
		else if (compHitList.size() == 1) {
			baseHit = compHitList.get(0);
			row = baseHit[0];
			col = baseHit[1];

			upOk = upOk(row, col);
			downOk = downOk(row, col);
			leftOk = leftOk(row, col);
			rightOk = rightOk(row, col);

			int decider;
			int chosen = 0;

			do {
				chosen = 0;
				decider = random.nextInt(4);

				if (!upOk && !downOk && !leftOk && !rightOk) {
					chosen = -1;
				}

				else if (0 == decider && upOk) {
					row--;
					chosen = 1;
				}

				else if (1 == decider && downOk) {
					row++;
					chosen = 1;
				}

				else if (2 == decider && rightOk) {
					col++;
					chosen = 1;
				}

				else if (3 == decider && leftOk){
					col--;
					chosen = 1;
				}
			} while(0 == chosen);

			if (-1 == chosen) {
				compHitList.clear();
				return randomComputerHit();
			}
			else if (1 == chosen) {
				result = placeHit(row, col, COMPUTER);
				this.compRecentCol = col;
				this.compRecentRow = row;
				this.compRecentResult = result;
				if(1 == result) {
					int[] recentHit = {row, col};
					this.compHitList.add(recentHit);

				}
				return result;
			}

		}

		else if (compHitList.size() == 2) {
			baseHit = compHitList.get(0);
			previousHit = compHitList.get(1);

			//Consecutive hit to the right column 
			if (previousHit[0] == baseHit[0] 
					&& previousHit[1] > baseHit[1]) {
				//Check if the right is okay to hit.
				if (rightOk(previousHit[0], previousHit[1])) {
					//If hit result is 1, save the new col coordinate for next attack.

					result = placeHit(previousHit[0], previousHit[1] + 1, COMPUTER);

					this.compRecentRow = previousHit[0];
					this.compRecentCol = previousHit[1] + 1;
					this.compRecentResult = result;

					if(1 == result) {
						previousHit[1]++;
					}
					//If hit is 0, remove from the list.
					else {
						compHitList.remove(1);
					}

					return result;
				}
				//If Right is not okay, remove previousHit, and check left from base.
				else {
					compHitList.remove(1);
					if(leftOk(baseHit[0], baseHit[1])) {

						result = placeHit(baseHit[0], baseHit[1] - 1, COMPUTER);

						this.compRecentRow = baseHit[0];
						this.compRecentCol = baseHit[1] - 1;
						this.compRecentResult = result;

						if(1 == result) {
							int[] next = {baseHit[0], baseHit[1] - 1};
							compHitList.add(next);
						}
						else {
							//If 0, then clear list.
							compHitList.clear();
						}
						return result;

					}
					//Clear list to randomly hit.
					compHitList.clear();
					return randomComputerHit();
				}
			}

			//Consecutive hit to the left column.
			else if (previousHit[0] == baseHit[0] && previousHit[1] < baseHit[1]) {
				//Check if the left is okay to hit.
				if (leftOk(previousHit[0], previousHit[1])) {
					//If hit result is 1, save the new col coordinate for next attack.
					result = placeHit(previousHit[0], previousHit[1] - 1, COMPUTER);

					this.compRecentRow = previousHit[0];
					this.compRecentCol = previousHit[1] - 1;
					this.compRecentResult = result;

					if(1 == result) {
						previousHit[1]--;
					}
					//If hit is 0, remove from the list.
					else {
						compHitList.remove(1);
					}

					return result;
				}
				//If left is not okay, remove previousHit, and check right from base.
				else {
					compHitList.remove(1);
					if(rightOk(baseHit[0], baseHit[1])) {

						result = placeHit(baseHit[0], baseHit[1] + 1, COMPUTER);
						this.compRecentRow = baseHit[0];
						this.compRecentCol = baseHit[1] + 1;
						this.compRecentResult = result;

						if(1 == result) {
							int[] next = {baseHit[0], baseHit[1] + 1};
							compHitList.add(next);
						}
						else {
							//If 0, then clear list.
							compHitList.clear();
						}
						return result;

					}
					//Clear list to randomly hit.
					compHitList.clear();
					return randomComputerHit();
				}

			}
			
			else if (previousHit[0] > baseHit[0] && previousHit[1] == baseHit[1]) {
				//Check if the row below is okay to hit.
				if (downOk(previousHit[0], previousHit[1])) {
					//If hit result is 1, save the new col coordinate for next attack.
					result = placeHit(previousHit[0] + 1, previousHit[1], COMPUTER);
					this.compRecentRow = previousHit[0] + 1;
					this.compRecentCol = previousHit[1];
					this.compRecentResult = result;

					if(1 == result) {
						previousHit[0]++;
					}
					//If hit is 0, remove from the list.
					else {
						compHitList.remove(1);
					}

					return result;
				}
				
				//If bottom is not okay, remove previousHit, and check above from base.
				else {
					compHitList.remove(1);
					if(upOk(baseHit[0], baseHit[1])) {
						result = placeHit(baseHit[0] - 1, baseHit[1], COMPUTER);

						this.compRecentRow = baseHit[0] - 1;
						this.compRecentCol = baseHit[1];
						this.compRecentResult = result;

						if(1 == result) {
							int[] next = {baseHit[0] - 1, baseHit[1]};
							compHitList.add(next);
						}
						else {
							//If 0, then clear list.
							compHitList.clear();
						}
						return result;

					}
					//Clear list to randomly hit.
					compHitList.clear();
					return randomComputerHit();
				}

			}

			else if (previousHit[0] < baseHit[0] && previousHit[1] == baseHit[1]) {
				//Check if row above is okay to hit.
				if (upOk(previousHit[0], previousHit[1])) {
					//If hit result is 1, save the new col coordinate for next attack.
					result = placeHit(previousHit[0] - 1, previousHit[1], COMPUTER);
					this.compRecentRow = previousHit[0] - 1;
					this.compRecentCol = previousHit[1];
					this.compRecentResult = result;

					if(1 == result) {
						previousHit[0]--;
					}
					//If hit is 0, remove from the list.
					else {
						compHitList.remove(1);
					}
					return result;
				}

				//If up is not okay, remove previousHit, and check below base hit.
				else {
					compHitList.remove(1);
					if(downOk(baseHit[0], baseHit[1])) {
						result = placeHit(baseHit[0] + 1, baseHit[1], COMPUTER);
						this.compRecentRow = baseHit[0] + 1;
						this.compRecentCol = baseHit[1];
						this.compRecentResult = result;
						if(1 == result) {
							int[] next = {baseHit[0] + 1, baseHit[1]};
							compHitList.add(next);
						}
						else {
							//If 0, then clear list.
							compHitList.clear();
						}
						return result;

					}
					//Clear list to randomly hit.
					compHitList.clear();
					return randomComputerHit();
				}

			}

		}

		System.out.println("An issue with the computer player has occured.");
		compHitList.clear();
		return randomComputerHit();

	}
	
	/****************************************************
	 *
	 * Helper method for the computer to place a hit.
	 *
	 * @return 0 if a miss, 1 if a hit, 2 if an error.
	 ****************************************************/
	private int randomComputerHit() {
		Random random = new Random();
		int row;
		int col;
		int result;

		do {
			row = random.nextInt(10);
			col = random.nextInt(10);
			result = placeHit(row, col, COMPUTER);
		}while(2 == result);

		if(1 == result) {
			int[] toHitList = {row, col};
			compHitList.add(toHitList);
		}
		this.compRecentCol = col;
		this.compRecentRow = row;
		this.compRecentResult = result;

		return result;

	}

	/*****************************************************
	 *
	 * Method to help computer place hit by checking row above.
	 *
	 * @param rowIndex the row index of the board.
	 * @param colIndex the column index of the board.
	 * @return True if the row above is allowed for the computer
	 * to place a hit.
	 ******************************************************/
	private boolean upOk(final int rowIndex, final int colIndex) {
		if (rowIndex == 0) {
			return false;
		}
		else if (p1ShipP2Hit[rowIndex - 1][colIndex] == 2) {
			return false;
		}
		return true;
	}

	/****************************************************
	 *
	 * Method to help computer place hit by checking row below.
	 *
	 * @param rowIndex the row index of the board.
	 * @param colIndex the column index of the board.
	 * @return True if the row below is allowed for the computer
	 * to place a hit.
	 ******************************************************/
	private boolean downOk(final int rowIndex, final int colIndex) {
		if (rowIndex == 9) {
			return false;
		}
		else if (p1ShipP2Hit[rowIndex + 1][colIndex] == 2) {
			return false;
		}
		return true;
	}

	/*****************************************************
	 *
	 * Method to help computer place hit by checking right column.
	 *
	 * @param rowIndex the row index of the board.
	 * @param colIndex the column index of the board.
	 * @return True if right column is allowed for the computer
	 * to place a hit.
	 ******************************************************/
	private boolean rightOk(final int rowIndex, final int colIndex) {
		if (colIndex == 9) {
			return false;
		}
		else if (p1ShipP2Hit[rowIndex][colIndex + 1] == 2) {
			return false;
		}
		return true;
	}

	/*****************************************************
	 *
	 * Method to help computer place hit by checking left column.
	 *
	 * @param rowIndex the row index of the board.
	 * @param colIndex the column index of the board.
	 * @return True if left column is allowed for the computer
	 * to place a hit.
	 ******************************************************/
	private boolean leftOk(final int rowIndex, final int colIndex) {
		if (colIndex == 0) {
			return false;
		}
		else if (p1ShipP2Hit[rowIndex][colIndex - 1] == 2) {
			return false;
		}
		return true;
	}

	/*******************************************************
	 *
	 * Method to get information of computer hit for testing
	 * purposes and to return row and col index that the
	 * computer hit.
	 *
	 * @return an int array containing the row and column
	 * the computer hit respectively.
	 ******************************************************/
	public int[] getComputerHit(){
		String result;
		String coordinate;

		char letter = (char)(65 + this.compRecentRow);
		int num = this.compRecentCol + 1;

		coordinate = letter + "" + num;

		if (0 == this.compRecentResult) {
			result = "MISS";
		}
		else if (1 == this.compRecentResult){
			result = "HIT";
		}
		else {
			result = "ERROR";
		}

		System.out.println("Placed hit at: " + coordinate +
				" resulting in: " + result);

		int[] data = {compRecentRow, compRecentCol};
		
		return data;

	}
	

	/*****************************************************
	 *
	 * Prints the board of the specified player.
	 * @param player the board of the player being printed.
	 * 1 for player 1, else player 2
	 *****************************************************/
	public void printBoard(final int player) {
		int[][] board = this.p2ShipP1Hit;

		if(1 == player) {
			board = this.p1ShipP2Hit;
		}

		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}

		System.out.println();

	}

	/*****************************************************
	 *
	 * Used for testing purposes to test computer hit
	 * algorithm by randomly generating board for player 1.
	 ****************************************************/
	protected void randomPlayer1Board() {
		computerPlaceShips();
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				p1ShipP2Hit[i][j] = p2ShipP1Hit[i][j];
			}
		}
		p2ShipP1Hit = new int[ROWS][COLS];

	}


}
