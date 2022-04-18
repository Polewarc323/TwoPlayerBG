

import java.util.Random;


/****************************************************************************
*
*Class serves as the logic for the Connect Four Game for 2 player Board games.
*The methods are designed to help with the implement of a GUI
*The class contains method for unit testing.
*@author Calab Bahlbi
*@version January 28, 2022
*
*
*****************************************************************************/

public class Connect4Logic {
    public Board board;
    private final String color1;
    private final String color2;
    

    // true if player1's turn
    // false if player2's turn
    private boolean is1playing;

    
	/***********************************************************************
	*
	* Determines who is playing.
	*
	* @return return a boolean value which determines if player 1 or player
	* 2 is playing
	**********************************************************************/
   
    public boolean isIs1playing() {
        return is1playing;
    }

   
	/***********************************************************************
	*
	* Starts a new game
	*
	* @param color1 A string that determines color of piece 1
	* @param color2 A string that determines color of piece 2
	* @param rows An in that displays rows
	* @param columns An int that displays columns
	* @return returns the game
	**********************************************************************/
    
    public Connect4Logic(String color1, String color2, int rows, int columns) {
        this.board = new Board(rows, columns);
        this.color1 = color1;
        this.color2 = color2;

        is1playing = (new Random()).nextBoolean();
    }

    /**********************************************************************
     *
     * @param col which column did the user try to add a piece to
     * @return
     *      -1: if unsuccessful
     *      an int of which row it was added to if successful
     *********************************************************************/
    public int round(int col) {
        String color = is1playing ? color1 : color2;

        int row = board.addPiece(col, color);

        if(row != -1) is1playing = !is1playing;

        return row;
    }

   
	/***********************************************************************
	*
	* Checks for the winner in the GUI
	*
	* @param column which column did the user try to add a piece to
	* @return the winner and winning color
	**********************************************************************/
    
    public boolean checkForWinnerInGUI(int column) {
        String winningColor;

        // inversion because of late information
        if(!is1playing) {
            winningColor = color1;
        } else {
            winningColor = color2;
        }

        return checkForWinner(column, winningColor);
    }

	/***********************************************************************
	*
	* Checks if a player has 4 pieces in a row diagonally
	*
	* @param col which column did the user try to add a piece to
	* @param row which row did the user try to add a piece to
	* @param winningColor what is the winning color of the player
	* @param rightDiagonal checks for 4 in a row diagonally
	* @return if there has been a winner who has 4 in a row diagonally
	**********************************************************************/
    
    private boolean checkDiagonal(int row, int col, String winningColor, boolean rightDiagonal) {
        int winningStreak = 4;
        int reverser = rightDiagonal ? 1 : -1;
        int rows = board.getRows();
        int columns = board.getColumns();
        Piece[][] ourBoard = board.getOurBoard();

        for(int winRow = row - 3, winCol = col - (3 * reverser); winRow <= row + 3; winRow++, winCol += reverser) {
            if (!rightDiagonal) {
                if (winRow < 0 || winCol < 0) continue;
                if (winRow >= rows || winCol >= columns) break;
            } else {
                if(winRow < 0 || winCol >= columns) continue;
                if(winRow >= rows || winCol < 0) break;
            }

            if(ourBoard[winRow][winCol] != null && ourBoard[winRow][winCol].getColor().equals(winningColor)) {
                if (--winningStreak == 0) return true;
            } else winningStreak = 4;
        }
        return false;
    }

    
	/***********************************************************************
	*
	* Checks for the winner
	*
	* @param col which column did the user try to add a piece to
	* @param winningColor what is the winning color of the player
	* @return the winner and winning color
	**********************************************************************/
    
    public boolean checkForWinner(int col, String winningColor) {
        int rows = board.getRows();
        int columns = board.getColumns();
        Piece[][] ourBoard = board.getOurBoard();

        for(int row = 0; row < rows; row++) {
            if(ourBoard[row][col] != null) {
                // if this reaches 0, we have won
                int winningStreak = 3;

                // check downwards
                for(int winRow = row + 1; winRow < rows; winRow++) {
                    if(ourBoard[winRow][col].getColor().equals(winningColor)) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 3;
                }

                winningStreak = 4;
                // look at the horizontal
                for(int winCol = col - 3; winCol <= col + 3; winCol++) {
                    if(winCol < 0) continue;
                    if(winCol >= columns) break;

                    if(ourBoard[row][winCol] != null && ourBoard[row][winCol].getColor().equals(winningColor)) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 4;
                }

                if(checkDiagonal(row, col, winningColor, false)) return true;
                if(checkDiagonal(row, col, winningColor, true)) return true;

                return false;
            }
        }
        return false;
    }
    
    
	/***********************************************************************
	*
	* Resets the game and board
	*
	* @param columns which column did the user try to add a piece to
	* @param rows which row did the user try to add a piece to
	* @return a fresh board
	**********************************************************************/
    
    public void reset(int rows, int columns) {
        this.board = new Board(rows, columns);
        is1playing = (new Random()).nextBoolean();
    }
    
}
