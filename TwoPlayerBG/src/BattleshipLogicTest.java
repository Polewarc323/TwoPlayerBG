import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/************************************************************************************
 * 
 * The test class for BattleshipLogic.java
 * 
 * @author Romandy Vu (GVSU-Romandy-Vu)
 * @version February 5, 2022
 ************************************************************************************/
public class BattleshipLogicTest {

	@Test
	/**********************************************************************************
	 * Tests the constructor (start of game session).
	 *********************************************************************************/
	public void testConstructor(){
		BattleshipLogic game = new BattleshipLogic();
		int[][] player1board = game.getBoard(1);
		int[][]player2board = game.getBoard(2);
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				assertTrue(player1board[i][j] == 0 && player2board[i][j] == 0);
			}
		}
		
		assertTrue(game.getLives(1) == 17 && game.getLives(2) == 17);
		assertFalse(game.isGameOver());
	}
	
	@Test
	/*********************************************************************************
	 * Test placing ships
	 ********************************************************************************/
	public void testPlayer1PlaceShips() {
		BattleshipLogic game = new BattleshipLogic();
		//Valid player 1 placement of patrol boat
		assertTrue(game.placeShip(1, "A1", "A2", 2));
		//Invalid  player 1 placement of submarine due to invalid coordinates.
		assertFalse(game.placeShip(1,"dssdasd","V7",3));
		//Invalid player 1 placement of Cruiser due to spot already taken.
		assertFalse(game.placeShip(1, "A1", "C1", 3));
		//Invalid player 1 placement of Carrier due to coordinates that aren't in board.
		assertFalse(game.placeShip(1, "K9", "K14", 5));
		//Invalid player 1 placement of destroyer due to invalid coordinate difference.
		assertFalse(game.placeShip(1, "B1", "B3", 4));
		
		
		int[][] player1board = game.getBoard(1);
		//Coordinate of patrol boats
		assertTrue(player1board[0][0] == 1);
		assertTrue(player1board[0][1] == 1);
		//Cruiser should not been placed.
		assertFalse(player1board[1][0] == 1);
		assertFalse(player1board[2][0] == 1);
		//Check if destroyer placed (should be false)
		assertFalse(player1board[1][0] == 1);
		assertFalse(player1board[1][1] == 1);
		
	}

}
