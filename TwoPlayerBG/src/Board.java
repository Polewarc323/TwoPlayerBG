import java.util.Random;

/****************************************************************************
*
*Class serves as the board for the connect four game
*The methods are designed to help with the implement of a GUI

*@author Calab Bahlbi
*@version January 28, 2022
*
*
*****************************************************************************/

public class Board {

    private int rows;
    private int columns;

    Piece [][]ourBoard;
	public static final int NUM_COLUMNS = 7;
	public static final int NUM_ROWS = 6;
	public static final int SEGMENT_LENGTH = 4;
	private int[][] position; // 0 = empty, 1 is player 1, 2 is player 2
	private int[] columnCount; // number of pieces in each column
	private int turn; // which player's turn is it, 1 or 2

    
	/***********************************************************************
	*
	* Get board method
	*
	* @return returns the board
	**********************************************************************/
    
    public Piece[][] getOurBoard() {
        return ourBoard;
    }

    
	/***********************************************************************
	*
	* Get columns method
	*
	* @return returns columns
	**********************************************************************/
    
    public int getColumns() {
        return columns;
    }

	/***********************************************************************
	*
	* Get rows method
	*
	* @return returns rows
	**********************************************************************/
    
    public int getRows() {
        return rows;
    }

    /*********************************************************************
     *
     * @param colToAdd which column did the user try to add a piece to
     * @param color what is the piece color
     * @return
     *      -1: if unsuccessful
     *      an int of which row it was added to if successful
     ********************************************************************/
    public int addPiece(int colToAdd, String color) {
        // within normal range
        if(colToAdd >= 0 && colToAdd < columns) {
            // we can add
            if(ourBoard[0][colToAdd] == null) {
                boolean addedThePiece = false;
                int addedRow = -1;
                for(int row = rows - 1; row >= 0; row--)
                    if(ourBoard[row][colToAdd] == null) {
                        ourBoard[row][colToAdd] = new Piece();
                        ourBoard[row][colToAdd].setColor(color);
                        addedThePiece = true;
                        addedRow = row;
                        break;
                    }
                return addedRow;
            } else {
                // that row is full
                System.err.println("This column is full, please choose another, dummy.");
                return -1;
            }
        } else {
            // outside normal range
            System.err.println("You are trying to add somewhere that is not supported, fool.");
            return -1;
        }
    }
    
    public int AIadd(String color) {
    	Random rn = new Random();
    	int col = rn.nextInt(7);
    	System.out.println(col);
    	addPiece(col, color);
		return col;
    	
    }

	/***********************************************************************
	*
	* Method that displays the board
	*
	* @param rows An int that displays rows
	* @param columns An int that displays columns
	* @return returns the board
	**********************************************************************/
    
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        ourBoard = new Piece[rows][columns];
        for(int row = 0; row < rows; row++)
            for(int col = 0; col < columns; col++)
                ourBoard[row][col] = null;
		
    }
    
	/***********************************************************************
	*
	* Constructor used for test cases
	*
	* @param position displays position
	* @param turn displays turns
	* @return turn
	**********************************************************************/
    
	public Board(int[][] position, int turn) {
        position = new int[NUM_COLUMNS][NUM_ROWS];
		columnCount = new int[NUM_COLUMNS];
		turn = 1; // 1 goes first
		this.position = position;
		columnCount = new int[NUM_COLUMNS];
		for (int c = 0; c < Board.NUM_COLUMNS; c++) {
			int piecesInColumn = 0;
			for (int r = 0; r < Board.NUM_ROWS; r++) {
				if (position[c][r] != 0) {
					piecesInColumn++;
				}
			}
			columnCount[c] = piecesInColumn;
		}
		
		this.turn = turn;
	}
	
	
	
	
}
