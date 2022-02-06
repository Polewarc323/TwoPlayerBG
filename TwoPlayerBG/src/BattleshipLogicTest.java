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
		int[][] player2board = game.getBoard(2);
		
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
	 * Test valid placing ships for player 1
	 ********************************************************************************/
	public void testValidPlayer1PlaceShips() {
		BattleshipLogic game = new BattleshipLogic();
		//Valid placement of patrol boat
		assertTrue(game.placeShip(1, "A1", "A2", 2));
		//Valid placement of Submarine
		assertTrue(game.placeShip(1, "B1", "D1", 3));
		//Valid placement of Cruiser
		assertTrue(game.placeShip(1, "B2", "B4", 3));
		//Valid placement of Destroyer
		assertTrue(game.placeShip(1, "A5", "D5", 4));
		assertTrue(game.placeShip(1, "A10","E10",5));
		
		assertTrue(game.getCoordinateData("a01", 1) == 1);
		assertTrue(game.getCoordinateData("A2", 1) == 1);
		
		assertTrue(game.getCoordinateData("B1", 1) == 1);
		assertTrue(game.getCoordinateData("c01", 1) == 1);
		assertTrue(game.getCoordinateData("D1", 1) == 1);
		
		assertTrue(game.getCoordinateData("B02", 1) == 1);
		assertTrue(game.getCoordinateData("b3", 1) == 1);
		assertTrue(game.getCoordinateData("B04", 1) == 1);
		
		assertTrue(game.getCoordinateData("A5", 1) == 1);
		assertTrue(game.getCoordinateData("b05", 1) == 1);
		assertTrue(game.getCoordinateData("C5", 1) == 1);
		assertTrue(game.getCoordinateData("d05", 1) == 1);
		
		assertTrue(game.getCoordinateData("A10", 1) == 1);
		assertTrue(game.getCoordinateData("b10", 1) == 1);
		assertTrue(game.getCoordinateData("C10", 1) == 1);
		assertTrue(game.getCoordinateData("d10", 1) == 1);
		assertTrue(game.getCoordinateData("E10", 1) == 1);
		
		
	}

}
