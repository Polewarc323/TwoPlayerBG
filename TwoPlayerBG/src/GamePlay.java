package connect4Stuff.Controller;
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


    public GamePlay() {
        row = -1;
        col = -1;
        value = 0;
    }

    //Move done
    public GamePlay moveDone(int row, int col) {
        GamePlay moveDone = new GamePlay();
        moveDone.row = row;
        moveDone.col = col;
        moveDone.value = -1;
        return moveDone;
    }
    
    //Move for expansion (with utility function)
    public GamePlay possibleMove(int row, int col, int value) {
        GamePlay posisibleMove = new GamePlay();
        posisibleMove.row = row;
        posisibleMove.col = col;
        posisibleMove.value = value;
        return posisibleMove;
    }

 
    //Move used to compare in MinMax algorithm
    public GamePlay moveToCompare(int value) {
        GamePlay moveToCompare = new GamePlay();
        moveToCompare.row = -1;
        moveToCompare.col = -1;
        moveToCompare.value = value;
        return moveToCompare;
    }

    public int getValue() {
        return value;
    }

    public void setRow(int aRow) {
        row = aRow;
    }

    public void setCol(int aCol) {
        col = aCol;
    }

    public void setValue(int aValue) {
        value = aValue;
    }
}
