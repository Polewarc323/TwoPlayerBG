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
	}

}
