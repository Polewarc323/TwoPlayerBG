


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;


/*************************************************
*
*The Junit Tests for Connect4Logic
* @author Calab Bahlbi
*
*************************************************/
class Connect4LogicTest {
	
String red = "red";
String yellow = "yellow";
	@Test
	void testWin1() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		assertTrue(c.checkForWinner(1, red)); 
	}
	
	@Test
	void testWin2() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(1, yellow);
		c.board.addPiece(2, yellow);
		c.board.addPiece(3, yellow);
		c.board.addPiece(4, yellow);
		assertTrue(c.checkForWinner(4, yellow));
	}
	
	@Test
	void testWin3() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(1, red);
		c.board.addPiece(2, yellow);
		c.board.addPiece(2, red);
		c.board.addPiece(3, yellow);
		c.board.addPiece(3, red);
		c.board.addPiece(4, yellow);
		c.board.addPiece(3, red);
		c.board.addPiece(4, yellow);
		c.board.addPiece(4, red);
		c.board.addPiece(1,yellow);
		c.board.addPiece(4, red);
		
		assertTrue(c.checkForWinner(4, red));
	}
	
	@Test
	void testWin4() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(7, red);
		c.board.addPiece(6, yellow);
		c.board.addPiece(6, red);
		c.board.addPiece(5, yellow);
		c.board.addPiece(5, red);
		c.board.addPiece(4, yellow);
		c.board.addPiece(4, red);
		c.board.addPiece(4, yellow);
		c.board.addPiece(5, red);
		c.board.addPiece(7, yellow);
		c.board.addPiece(4, red);
	
		assertFalse(c.checkForWinner(4, yellow));
	}
	
	@Test
	void testWin5() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		assertTrue(c.checkForWinner(1, red));
	}
	
	@Test
	void testWinDiagonal() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		assertTrue(c.checkForWinner(1, red));
	}
	
	@Test
	void testWinDiagonal2() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		assertTrue(c.checkForWinner(1, red));
	}
	
	@Test
	void testWinDiagonal3() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		assertTrue(c.checkForWinner(1, red));
	}
	
	@Test
	void testWinDiagonal4() {
		Connect4Logic c = new Connect4Logic(red, yellow, 6,7);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		c.board.addPiece(1, red);
		assertTrue(c.checkForWinner(1, red));
	}
}
