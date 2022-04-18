
import java.util.LinkedList;
import java.util.Random;

/****************************************************************************
*
*Class serves as the logic for the Connect Four Game AI algorithm
*The methods are designed to help with the implement of a GUI
*@author Calab Bahlbi
*@version March 20, 2022
*
*
*****************************************************************************/

public class MinMax {
    //Variable that holds the maximum depth the MinMax algorithm will reach (level of the three)
    int maxDepth;
    //Variable that holds which letter the computer controls
    int computerLetter;

    
    //Constructor
    public MinMax(int thePlayerLetter) {
        maxDepth = 5; //This is important to get a better decision (more depth, more accurate decision, more time)
        computerLetter = thePlayerLetter;
    }

    //Initiates the MinMax algorithm
    public GamePlay getNextMove(State board) {
        
        return max(board.boardWithExpansion(board), 0);
    }

    //The max and min methods are called interchangeably, one after another until a max depth is reached
  
    public GamePlay min(State board, int depth) { 
        Random r = new Random();
        
        if((board.checkGameOver()) || (depth == maxDepth)){
            GamePlay baseMove = new GamePlay();
            baseMove = baseMove.possibleMove(board.lastMove.row, board.lastMove.col, board.utilityFunction());
            return baseMove;
        }else{
            //The children-moves of the state are calculated (expansion)
            LinkedList<State> children = new LinkedList<State>(board.getChildren(State.X));
            GamePlay minMove = new GamePlay();
            minMove = minMove.moveToCompare(Integer.MAX_VALUE);
            for (int i =0; i < children.size();i++) {
                State child = children.get(i);
               
                GamePlay move = max(child, depth + 1);
                
                if(move.getValue() <= minMove.getValue()) {
                    if ((move.getValue() == minMove.getValue())) {
                       
                        if (r.nextInt(2) == 0) { 
                            minMove.setRow(child.lastMove.row);
                            minMove.setCol(child.lastMove.col);
                            minMove.setValue(move.getValue());
                        }
                    }
                    else {
                        minMove.setRow(child.lastMove.row);
                        minMove.setCol(child.lastMove.col);
                        minMove.setValue(move.getValue());
                    }
                }
            }
            return minMove;
        }
    }

    //The max and min methods are called interchangeably, one after another until a max depth or game over is reached
    public GamePlay max(State board, int depth) { 
        Random r = new Random();
       
        if((board.checkGameOver()) || (depth == maxDepth)) {
            GamePlay baseMove = new GamePlay();
            baseMove = baseMove.possibleMove(board.lastMove.row, board.lastMove.col, board.utilityFunction());
            return baseMove;
        }else{
            LinkedList<State> children = new LinkedList<State>(board.getChildren(computerLetter));
            GamePlay maxMove = new GamePlay();
            maxMove = maxMove.moveToCompare(Integer.MIN_VALUE);
            for (int i =0; i < children.size();i++) {
                State child = children.get(i);
                GamePlay move = min(child, depth + 1);
                //Here is the difference with Min method: The greatest value is selected
                if(move.getValue() >= maxMove.getValue()) {
                    if ((move.getValue() == maxMove.getValue())) {
                        if (r.nextInt(2) == 0) {
                            maxMove.setRow(child.lastMove.row);
                            maxMove.setCol(child.lastMove.col);
                            maxMove.setValue(move.getValue());
                        }
                    }
                else {
                    maxMove.setRow(child.lastMove.row);
                    maxMove.setCol(child.lastMove.col);
                    maxMove.setValue(move.getValue());
                    }
                }
            }
            return maxMove;
        }
    }
}
