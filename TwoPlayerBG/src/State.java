
import java.util.LinkedList;

/****************************************************************************
*
*Class serves as the logic for the Connect Four Game AI algorithm
*The methods are designed to help with the implement of a GUI
*@author Calab Bahlbi
*@version March 20, 2022
*
*
*****************************************************************************/

public class State {

    static final int X = 1;     
    static final int O = -1;    
    int EMPTY = 0;              
    //We need to know the player that made the last move
    GamePlay lastMove;
    int lastLetterPlayed; 
    int winner;
    int [][] gameBoard;
    String winningMethod;       


	/***********************************************************************
	*
	* Constructor of state (board)
	*
	* @return returns state (board)
	**********************************************************************/
    
    public State() {
        lastMove = new GamePlay();
        lastLetterPlayed = O; //The user starts first
        winner = 0;
        gameBoard = new int[6][7];
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                gameBoard[i][j] = EMPTY;
            }
        }
    }
	
	/***********************************************************************
	*
	* Set method for winner
    *
    * @param winner displays the winner
	* @return returns winner
	**********************************************************************/
    
    public void setWinner(int winner) {
        this.winner = winner;
    }

	/***********************************************************************
	*
	* Set method for winning method
    *
    * @param winningMethod displays the winner
	* @return returns winningMethod
	**********************************************************************/
    
    public void setWinnerMethod(String winningMethod) {
        this.winningMethod = winningMethod;
    }
    
	/***********************************************************************
	*
	* Make a movement based on a column and a player
	*
	* @param col An int that displays columns
	* @param letter An int that displays letter
	* @return returns the move made
	**********************************************************************/
    
    public void makeMove(int col, int letter) {
        lastMove = lastMove.moveDone(getRowPosition(col), col);
        gameBoard[getRowPosition(col)][col] = letter;
        lastLetterPlayed = letter;
    }
	
	/***********************************************************************
	*
	* Checks whether a move is valid; whether a square is empty. 
	* Used only when we need to expand a movement
	*
	* @param col An int that displays columns
	* @return returns if a valid move was made
	**********************************************************************/
    
    public boolean isValidMove(int col) {
        int row = getRowPosition(col);
        if ((row == -1) || (col == -1) || (row > 5) || (col > 6)) {
            return false;
        }
        if(gameBoard[row][col] != EMPTY) {
            return false;
        }
        return true;
    }
	
	/***********************************************************************
	*
	* Is used when we need to make a movement 
	* (Is possible to move the piece?)
	*
	* @param col An int that displays columns
	* @param row An int that displays rows
	* @return returns if a move can be made
	**********************************************************************/
    
    public boolean canMove(int row, int col) {
       
        if ((row <= -1) || (col <= -1) || (row > 5) || (col > 6)) {
            return false;
        }
        return true;
    }
	
	/***********************************************************************
	*
	* Checks if a column is full
	*
	* @param col An int that displays columns
	* @return returns message if a column is full
	**********************************************************************/
    
    public boolean checkFullColumn(int col) {
        if (gameBoard[0][col] == EMPTY)
            return false;
        else{
            System.out.println("The column "+(col+1)+" is full. Select another column.");
            return true;
        }
    }
	
	/***********************************************************************
	*
	* Gets the position of the row
	*
	* @param col An int that displays columns
	* @return returns row position
	**********************************************************************/
    
    public int getRowPosition(int col) {
        int rowPosition = -1;
        for (int row=0; row<6; row++) {
            if (gameBoard[row][col] == EMPTY) {
                    rowPosition = row;
            }
        }
        return rowPosition;
    }
    
	/***********************************************************************
	*
	* Make a movement based on a column and a player
	*
	* @param board displays the board
	* @return returns board with expansion
	**********************************************************************/
    
    public State boardWithExpansion(State board) {
        State expansion = new State();
        expansion.lastMove = board.lastMove;
        expansion.lastLetterPlayed = board.lastLetterPlayed;
        expansion.winner = board.winner;
        expansion.gameBoard = new int[6][7];
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                expansion.gameBoard[i][j] = board.gameBoard[i][j];
            }
        }
        return expansion;
    }
	
	/***********************************************************************
	*
	* Generates the children of the state. 
	* The max number of the children is 7 because we have 7 columns
	*
	* @param letter An int that displays letter
	* @return returns the children of the state
	**********************************************************************/
    
    public LinkedList<State> getChildren(int letter) {
        LinkedList<State> children = new LinkedList<State>();
        for(int col=0; col<7; col++) {
            if(isValidMove(col)) {
                State child = boardWithExpansion(this);
                child.makeMove(col, letter);
                children.add(child);
            }
        }
        return children;
    }
	
	/***********************************************************************
	*
	* Utility function for testing in the console
	*
	* @return returns X's and O's
	**********************************************************************/
    
    public int utilityFunction() {  
        int Xlines = 0;
        int Olines = 0;
        if (checkWinState()) {
            if(winner == X) {
                Xlines = Xlines + 90;
            } else {
                Olines = Olines + 90;
            }
        }	
        Xlines  = Xlines + check3In(X)*10 + check2In(X)*4;
        Olines  = Olines + check3In(O)*5 + check2In(O);
	return Olines - Xlines;
    }
	
	/***********************************************************************
	*
	* Checks if we have a winner
	*
	* @return returns winning message if there is a winner
	**********************************************************************/
    
    public boolean checkWinState() {
    //Case if we have 4-row
        for (int i=5; i>=0; i--) {
            for (int j=0; j<4; j++) {
                if (gameBoard[i][j] == gameBoard[i][j+1] && gameBoard[i][j] == gameBoard[i][j+2] && gameBoard[i][j] == gameBoard[i][j+3] && gameBoard[i][j] != EMPTY) {
                    setWinner(gameBoard[i][j]);
                    setWinnerMethod("Winner by row.");
                    return true;
                }
            }
        }
		
    //Case we have a 4-column
        for (int i=5; i>=3; i--) {
            for (int j=0; j<7; j++) {
                if (gameBoard[i][j] == gameBoard[i-1][j] && gameBoard[i][j] == gameBoard[i-2][j] && gameBoard[i][j] == gameBoard[i-3][j] && gameBoard[i][j] != EMPTY) {
                    setWinner(gameBoard[i][j]);
                    setWinnerMethod("Winner by column.");
                    return true;
                }
            }
        }
		
    //Case we have an ascendent 4-diagonal
        for (int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {
                if (gameBoard[i][j] == gameBoard[i+1][j+1] && gameBoard[i][j] == gameBoard[i+2][j+2] && gameBoard[i][j] == gameBoard[i+3][j+3] && gameBoard[i][j] != EMPTY) {
                    setWinner(gameBoard[i][j]);
                    setWinnerMethod("Winner by diagonal.");
                    return true;
                }
            }
        }
		
    //Case we have an descendent 4-diagonal
        for (int i=0; i<6; i++) {
            for (int j=0; j<7; j++) {
                if (canMove(i-3,j+3)) {
                    if (gameBoard[i][j] == gameBoard[i-1][j+1] && gameBoard[i][j] == gameBoard[i-2][j+2] && gameBoard[i][j] == gameBoard[i-3][j+3]  && gameBoard[i][j] != EMPTY) {
                        setWinner(gameBoard[i][j]);
                        setWinnerMethod("Winner by diagonal.");
                        return true;
                    }
                }
            }
        }
        //There is no winner yet
        setWinner(0);
        return false;
    }
	
	/***********************************************************************
	*
	* Checks if there are 3 pieces of a same player
	*
	* @param player holds value for the player
	* @return returns times
	**********************************************************************/
    
    public int check3In(int player) {	
        int times = 0;
        //In row
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                if (canMove(i, j + 2)) {
                    if (gameBoard[i][j] == gameBoard[i][j + 1] && gameBoard[i][j] == gameBoard[i][j + 2] && gameBoard[i][j] == player) {
                        times++;
                    }
                }
            }
        }

        //In column
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                if (canMove(i - 2, j)) {
                    if (gameBoard[i][j] == gameBoard[i - 1][j] && gameBoard[i][j] == gameBoard[i - 2][j] && gameBoard[i][j] == player) {
                        times++;
                    }
                }
            }
        }

        //In diagonal ascendent
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (canMove(i + 2, j + 2)) {
                    if (gameBoard[i][j] == gameBoard[i + 1][j + 1] && gameBoard[i][j] == gameBoard[i + 2][j + 2] && gameBoard[i][j] == player) {
                        times++;
                    }
                }
            }
        }

        //In diagonal descendent
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (canMove(i - 2, j + 2)) {
                    if (gameBoard[i][j] == gameBoard[i - 1][j + 1] && gameBoard[i][j] == gameBoard[i - 2][j + 2] && gameBoard[i][j] == player) {
                        times++;
                    }
                }
            }
        }
        return times;				
    }

	/***********************************************************************
	*
	* Checks if there are 2 pieces of a same player
	*
	* @param player holds value for the player
	* @return returns times
	**********************************************************************/
    public int check2In(int player) {	
        int times = 0;
        //In a row
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                if (canMove(i, j + 1)) {
                    if (gameBoard[i][j] == gameBoard[i][j + 1] && gameBoard[i][j] == player) {
                        times++;
                    }
                }
            }
        }

        //In a column
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                if (canMove(i - 1, j)) {
                    if (gameBoard[i][j] == gameBoard[i - 1][j] && gameBoard[i][j] == player) {
                        times++;
                    }
                }
            }
        }

        //In a diagonal ascendent
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (canMove(i + 1, j + 1)) {
                    if (gameBoard[i][j] == gameBoard[i + 1][j + 1] && gameBoard[i][j] == player) {
                        times++;
                    }
                }
            }
        }

        //In a diagonal descendent
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (canMove(i - 1, j + 1)) {
                    if (gameBoard[i][j] == gameBoard[i - 1][j + 1] && gameBoard[i][j] == player) {
                        times++;
                    }
                }
            }
        }
        return times;
    }
    
	/***********************************************************************
	*
	* Checks if the game is over
	*
	* @return returns game over message
	**********************************************************************/
    
    public boolean checkGameOver() {
        
        if (checkWinState()) {
            return true;
        }
        //Checks for blank spaces
        for(int row=0; row<6; row++) {
            for(int col=0; col<7; col++) {
                if(gameBoard[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

	/***********************************************************************
	*
	* Print the board
    * Method was only used for testing in the console
	*
	* @return returns the board
	**********************************************************************/
    
    public void printBoard() {
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println();
        for (int i=0; i<6; i++) {
            for (int j=0; j<7; j++) {
                    if (gameBoard[i][j] == 1) {
                        System.out.print("| " + "X "); 
                    } else if (gameBoard[i][j] == -1) {
                        System.out.print("| " + "O "); 
                    } else {
                        System.out.print("| " + "-" + " ");
                    }
            }
            System.out.println("|"); //End of each row
        }
    }
}
