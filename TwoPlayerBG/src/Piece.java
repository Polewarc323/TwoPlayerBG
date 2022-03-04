

/****************************************************************************
*
*Class serves as the pieces for the connect four game
*The methods are designed to help with the implement of a GUI

*@author Calab Bahlbi
*@version January 28, 2022
*
*
*****************************************************************************/

public class Piece {
    private String color;

	/***********************************************************************
	*
	* Get color method
	*
	* @return gets the piece color
	**********************************************************************/
    
    public String getColor() {
        return color;
    }

	/***********************************************************************
	*
	* Set color method
	* @param color sets color
	* @return sets the piece color
	**********************************************************************/
    
    public void setColor(String color) {
        this.color = color;
    }
}
