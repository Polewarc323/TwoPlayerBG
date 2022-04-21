import java.util.Scanner;

/****************************************************************************
*
*Class serves as the logic for the Connect Four Game AI algorithm
*The methods are designed to help with the implement of a GUI
*@author Calab Bahlbi
*@version March 20, 2022
*
*
*****************************************************************************/

public class GamePlay {	
    int row;
    int col;
    private int value; 
    static int columnPosition;
    static State theBoard;
    static MinMax computerPlayer;


	/***********************************************************************
	*
	* Constructor
	*
	* @return returns gameplay
	**********************************************************************/
    
    public GamePlay() {
        row = -1;
        col = -1;
        value = 0;
    }

	/***********************************************************************
	*
	* Determines when the AI's move is over
	*
	* @param row An int that displays rows
	* @param col An int that displays columns
	* @return returns movedone
	**********************************************************************/
    
    public GamePlay moveDone(int row, int col) {
        GamePlay moveDone = new GamePlay();
        moveDone.row = row;
        moveDone.col = col;
        moveDone.value = -1;
        return moveDone;
    }
    
  
	/***********************************************************************
	*
	* Move for expansion (with utility function)
	*
	* @param row An int that displays rows
	* @param col An int that displays columns
	* @param value int that displays value
	* @return returns possiblemove
	**********************************************************************/
    
    public GamePlay possibleMove(int row, int col, int value) {
        GamePlay posisibleMove = new GamePlay();
        posisibleMove.row = row;
        posisibleMove.col = col;
        posisibleMove.value = value;
        return posisibleMove;
    }

 
	/***********************************************************************
	*
	* Move used to compare in MinMax algorithm
	*
	* @param value int that displays value
	* @return returns movetocompare
	**********************************************************************/
    
    public GamePlay moveToCompare(int value) {
        GamePlay moveToCompare = new GamePlay();
        moveToCompare.row = -1;
        moveToCompare.col = -1;
        moveToCompare.value = value;
        return moveToCompare;
    }

	/***********************************************************************
	*
	* Get method for value
    *
	* @return returns value
	**********************************************************************/
    
    public int getValue() {
        return value;
    }

	/***********************************************************************
	*
	* Set method for row
    *
    * @param aRow displays rows
	* @return returns row
	**********************************************************************/
    
    public void setRow(int aRow) {
        row = aRow;
    }

	/***********************************************************************
	*
	* Set method for col
    *
    * @param aCol displays col
	* @return returns col
	**********************************************************************/
    
    public void setCol(int aCol) {
        col = aCol;
    }

	/***********************************************************************
	*
	* Set method for value
    *
    * @param aRow displays value
	* @return returns value
	**********************************************************************/
    
    public void setValue(int aValue) {
        value = aValue;
    }
    
    public static void main(String[] args) {	
        //We define the AI computer player "O" and the board
	computerPlayer = new MinMax(State.O);
	theBoard = new State();
	System.out.println("Connect 4 in Java!\n");
	theBoard.printBoard();
        //While the game has not finished
	while(!theBoard.checkGameOver()) {
            System.out.println();
            switch (theBoard.lastLetterPlayed) {
            //If O played last, then X plays now (blue color)
                case State.O:
                    System.out.print("User X moves.");
                    try {
                        do {
                            System.out.print("\nSelect a column to drop your piece (1-7): ");
                            Scanner in = new Scanner(System.in);
                            columnPosition = in.nextInt();
                        } while (theBoard.checkFullColumn(columnPosition-1));
                    } catch (Exception e){
                        System.out.println("\nValid numbers are 1,2,3,4,5,6 or 7. Try again\n");
                        break;
                    }
                    //Movement of the user
                    theBoard.makeMove(columnPosition-1, State.X);
                    System.out.println();
                    break;
            //If X played last, then O plays now (red color)
                case State.X:
                    GamePlay computerMove = computerPlayer.getNextMove(theBoard);
                    theBoard.makeMove(computerMove.col, State.O);
                    System.out.println("Computer O moves on column "+(computerMove.col+1)+".");
                    System.out.println();
                    break;
                default:
                    break;
            }
            theBoard.printBoard();
        }
        //The game has finished because...
        System.out.println();
        if (theBoard.winner == State.X) {
            System.out.println("User X wins!");
            System.out.println(theBoard.winningMethod);
        } else if (theBoard.winner == State.O) {
            System.out.println("Computer O wins!");
            System.out.println(theBoard.winningMethod);
        } else {
            System.out.println("It's a draw!");
        }
        System.out.println("Game over.");
    }
    
}
