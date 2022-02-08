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
	public void testConstructor() {
		BattleshipLogic game = new BattleshipLogic();
		int[][] player1board = game.getBoard(1);
		int[][] player2board = game.getBoard(2);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
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
		
		//Make sure it's not in Player 2 board
		assertFalse(game.getCoordinateData("a01", 2) == 1);
		assertFalse(game.getCoordinateData("A2", 2) == 1);

		assertFalse(game.getCoordinateData("B1", 2) == 1);
		assertFalse(game.getCoordinateData("c01", 2) == 1);
		assertFalse(game.getCoordinateData("D1", 2) == 1);

		assertFalse(game.getCoordinateData("B02", 2) == 1);
		assertFalse(game.getCoordinateData("b3", 2) == 1);
		assertFalse(game.getCoordinateData("B04", 2) == 1);

		assertFalse(game.getCoordinateData("A5", 2) == 1);
		assertFalse(game.getCoordinateData("b05", 2) == 1);
		assertFalse(game.getCoordinateData("C5", 2) == 1);
		assertFalse(game.getCoordinateData("d05", 2) == 1);

		assertFalse(game.getCoordinateData("A10", 2) == 1);
		assertFalse(game.getCoordinateData("b10", 2) == 1);
		assertFalse(game.getCoordinateData("C10", 2) == 1);
		assertFalse(game.getCoordinateData("d10", 2) == 1);
		assertFalse(game.getCoordinateData("E10", 2) == 1);


	}
	@Test
	public void testValidPlayer2PlaceShips() {
		BattleshipLogic game = new BattleshipLogic();
		//Valid placement of patrol boat
		assertTrue(game.placeShip(2, "j10", "J9", 2));
		//Valid placement of Submarine
		assertTrue(game.placeShip(2, "J08", "h8", 3));
		//Valid placement of Cruiser
		assertTrue(game.placeShip(2, "g7", "G5", 3));
		//Valid placement of Destroyer
		assertTrue(game.placeShip(2, "f04", "i4", 4));
		assertTrue(game.placeShip(2, "J01","F1",5));

		assertTrue(game.getCoordinateData("j10", 2) == 1);
		assertTrue(game.getCoordinateData("j9", 2) == 1);

		assertTrue(game.getCoordinateData("j08", 2) == 1);
		assertTrue(game.getCoordinateData("I8", 2) == 1);
		assertTrue(game.getCoordinateData("h08", 2) == 1);

		assertTrue(game.getCoordinateData("G07", 2) == 1);
		assertTrue(game.getCoordinateData("g06", 2) == 1);
		assertTrue(game.getCoordinateData("G5", 2) == 1);

		assertTrue(game.getCoordinateData("F4", 2) == 1);
		assertTrue(game.getCoordinateData("G04", 2) == 1);
		assertTrue(game.getCoordinateData("H4", 2) == 1);
		assertTrue(game.getCoordinateData("I04", 2) == 1);

		assertTrue(game.getCoordinateData("f1", 2) == 1);
		assertTrue(game.getCoordinateData("g01", 2) == 1);
		assertTrue(game.getCoordinateData("h1", 2) == 1);
		assertTrue(game.getCoordinateData("I01", 2) == 1);
		assertTrue(game.getCoordinateData("J01", 2) == 1);

		//Make sure it's not in player 1 board
		assertTrue(game.getCoordinateData("j10", 1) == 0);
		assertTrue(game.getCoordinateData("j9", 1) == 0);

		assertTrue(game.getCoordinateData("j08", 1) == 0);
		assertTrue(game.getCoordinateData("I8", 1) == 0);
		assertTrue(game.getCoordinateData("h08", 1) == 0);

		assertTrue(game.getCoordinateData("G07", 1) == 0);
		assertTrue(game.getCoordinateData("g06", 1) == 0);
		assertTrue(game.getCoordinateData("G5", 1) == 0);

		assertTrue(game.getCoordinateData("F4", 1) == 0);
		assertTrue(game.getCoordinateData("G04", 1) == 0);
		assertTrue(game.getCoordinateData("H4", 1) == 0);
		assertTrue(game.getCoordinateData("I04", 1) == 0);

		assertTrue(game.getCoordinateData("f1", 1) == 0);
		assertTrue(game.getCoordinateData("g01", 1) == 0);
		assertTrue(game.getCoordinateData("h1", 1) == 0);
		assertTrue(game.getCoordinateData("I01", 1) == 0);
		assertTrue(game.getCoordinateData("J01", 1) == 0);



	}
	
	@Test
	public void testInvalidPlayer1PlaceShips() {
		
	}
	
	@Test
	public void testInvalidPlayer2PlaceShips() {
		
	}
	
	@Test
	public void testGameOver() {
		
	}
	
	@Test
	public void testValidPlayer1PlaceHit() {
		
	}
	
	@Test
	public void testValidPlayer2PlaceHit() {
		
	}
	
	@Test
	public void testInvalidPlayer1PlaceHit() {
		
	}
	
	@Test
	public void testInvalidPlayer2PlaceHit() {
		
	}
	
	@Test
	public void testBoardData() {
		
	}
	
	@Test
	public void testResetBoard() {
		
	}

}
