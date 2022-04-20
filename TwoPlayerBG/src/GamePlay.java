
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
    
}
