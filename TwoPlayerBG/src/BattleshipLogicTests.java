import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*************************************************
 *
 *The Junit5 Test for BattleshipLogic
 * @author Romandy Vu
 *
 *************************************************/

class BattleshipLogicTests {
	
	/**The object being called to be tested.*/
	private BattleshipLogic game;
	/**Used to loop through the rows for methods containing coordinates.*/
	private String[] row = {"A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J"};
	/**Used to loop through columns for methods containing coordinates.*/
	private String[] col = {"1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10"};
	/**Used as the augment for methods containing coordinates.*/
	private String coordinate;

	@BeforeEach
	void setUp() throws Exception {
		game = new BattleshipLogic();
	}


	/*
	@Test
	void testConstructor() {
		int[][] player1board = game.getBoard(1);
		int[][] player2board = game.getBoard(2);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				assertTrue(player1board[i][j] == 0 
						&& player2board[i][j] == 0);
			}
		}

		assertTrue(game.getLives(1) == 17 && game.getLives(2) == 17);
		assertFalse(game.isGameOver());
	}

	@Test
	void testValidPlayer1PlaceShips() {
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

	@Test
	void testValidPlayer2PlaceShips() {
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
	}

	@Test
	void testInvalidPlayer1PlaceShips() {
			//1 Coordinate out of bounds
			assertFalse(game.placeShip(1, "A1", "A0", 2));
			//Both coordinate out of bounds
			assertFalse(game.placeShip(1, "A11", "A13", 3));
			//Diagonal placement of ship
			assertFalse(game.placeShip(1, "J10", "F6", 5));
			//Same coordinates
			assertFalse(game.placeShip(1, "C4", "C4", 4));
			//1 invalid coordinate
			assertFalse(game.placeShip(1, "E4", "asfdsfsd", 4));
			//2 invalid coordinates
			assertFalse(game.placeShip(1, "Z4", "4Casdasd", 4));
			//Swapped coordinates
			assertFalse(game.placeShip(1, "4A", "5A", 2));
			assertFalse(game.placeShip(1, "a", "a2", 3));

			//Invalid ship length placement (row)
			assertFalse(game.placeShip(1, "A3", "B3", 3));
			int[][] board = game.getBoard(1);
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					assertTrue(board[i][j] == 0);
				}
			}
			//Ship doesn't exist.
			assertFalse(game.placeShip(1, "A1", "A1", 1));
			assertFalse(game.placeShip(1, "A1", "A6", 6));

			//Test overlapping coordinates (row)
			assertTrue(game.placeShip(1, "E1", "E5", 5));
			assertFalse(game.placeShip(1, "E1","F1", 2));
			assertFalse(game.placeShip(1, "D3","F3",3));

			assertTrue(game.getCoordinateData("E1", 1) == 1);
			assertTrue(game.getCoordinateData("E2", 1) == 1);
			assertTrue(game.getCoordinateData("E3", 1) == 1);
			assertTrue(game.getCoordinateData("E4", 1) == 1);
			assertTrue(game.getCoordinateData("E5", 1) == 1);

			assertFalse(game.getCoordinateData("F1", 1) == 1);

			assertFalse(game.getCoordinateData("D3", 1) == 1);
			assertFalse(game.getCoordinateData("F3", 1) == 1);
	}

	@Test
	void testInvalidPlayer2PlaceShips() {

		//1 Coordinate out of bounds
		assertFalse(game.placeShip(2, "I10", "I11", 2));
		//Both coordinate out of bounds
		assertFalse(game.placeShip(2, "J11", "J13", 3));
		//Diagonal placement of ship
		assertFalse(game.placeShip(2, "A10", "E6", 5));
		//Same coordinates
		assertFalse(game.placeShip(2, "G4", "G4", 4));
		//1 invalid coordinate
		assertFalse(game.placeShip(2, "F4", "asfdsfsd", 4));
		//2 invalid coordinates
		assertFalse(game.placeShip(2, "5453", "4Cfdasfddasd", 4));
		//Swapped coordinates
		assertFalse(game.placeShip(2, "4B", "5B", 2));
		//Ship coordinates doesn't match length of ship (col)
		assertFalse(game.placeShip(2, "A1", "A6", 5));
			
		int[][] board = game.getBoard(2);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
					assertTrue(board[i][j] == 0);
			}
		}
		//Test overlapping coordinates
		assertTrue(game.placeShip(2, "C7", "G7", 5));
		assertFalse(game.placeShip(2, "E7","E8", 2));
		assertFalse(game.placeShip(2, "C6","C8",3));

		assertTrue(game.getCoordinateData("C7", 2) == 1);
		assertTrue(game.getCoordinateData("D7", 2) == 1);
		assertTrue(game.getCoordinateData("E7", 2) == 1);
		assertTrue(game.getCoordinateData("F7", 2) == 1);
		assertTrue(game.getCoordinateData("G7", 2) == 1);

		assertFalse(game.getCoordinateData("E8", 2) == 1);

		assertFalse(game.getCoordinateData("C6", 2) == 1);
		assertFalse(game.getCoordinateData("C8", 2) == 1);
	}
	@Test
	
	void testGameOver() {
		assertFalse(game.isGameOver());

		game.placeShip(1, "A1", "A2", 2);
		game.placeShip(1, "A3", "A5", 3);
		game.placeShip(1, "A6", "A10", 5);
		game.placeShip(1, "B1", "B3", 3);
		game.placeShip(1, "B4", "B7", 4);

		game.placeShip(2, "A1", "A2", 2);
		game.placeShip(2, "A3", "A5", 3);
		game.placeShip(2, "A6", "A10", 5);
		game.placeShip(2, "B1", "B3", 3);
		game.placeShip(2, "B4", "B7", 4);

		int[][] p1board = game.getBoard(1);
		int[][] p2board = game.getBoard(2);



		//Make sure row A is all 1.
		for (int i = 0; i < 10; i++) {
			assertTrue(p1board[0][i] == 1);
			assertTrue(p2board[0][i] == 1);
		}

		//Make sure row B is all 1 for 1-6
		for (int i = 0; i < 7; i++) {
			assertTrue(p1board[1][i] == 1);
			assertTrue(p2board[1][i] == 1);
		}

		for(int j = 0; j < col.length; j++) {
			coordinate = row[0] + col[j];
			assertTrue(game.placeHit(coordinate, 1) == 1);
			assertTrue(game.placeHit(coordinate, 2) == 1);
			assertFalse(game.isGameOver());
		}

		for(int j = 0; j < 6; j++) {
			coordinate = row[1] + col[j];
			assertTrue(game.placeHit(coordinate, 1) == 1);
			assertTrue(game.placeHit(coordinate, 2) == 1);
			assertFalse(game.isGameOver());
		}
		assertTrue(game.placeHit("B7", 1) == 1);
		assertTrue(game.isGameOver());
		assertTrue(game.placeHit("B7", 2) == 1);
		assertTrue(game.isGameOver());

		game = new BattleshipLogic();
		game.placeShip(1, "A1", "A2", 2);
		game.placeShip(1, "A3", "A5", 3);
		game.placeShip(1, "A6", "A10", 5);
		game.placeShip(1, "B1", "B3", 3);
		game.placeShip(1, "B4", "B7", 4);

		for(int j = 0; j < col.length; j++) {
			coordinate = row[0] + col[j];
			assertTrue(game.placeHit(coordinate, 2) == 1);
			assertFalse(game.isGameOver());
		}

		for(int j = 0; j < 6; j++) {
			coordinate = row[1] + col[j];
			assertTrue(game.placeHit(coordinate, 2) == 1);
			assertFalse(game.isGameOver());
		}

		assertTrue(game.placeHit("B7", 2) == 1);
		assertTrue(game.isGameOver());
	}
	
	@Test
	void testValidPlayer1PlaceHit() {
		game.placeShip(2, "A1", "A2", 2);
		game.placeShip(2, "A3", "A5", 3);
		game.placeShip(2, "A6", "A10", 5);
		game.placeShip(2, "B1", "B3", 3);
		game.placeShip(2, "B4", "B7", 4);
		
		for(int j = 0; j < col.length; j++) {
			coordinate = row[0] + col[j];
			assertTrue(game.placeHit(coordinate, 1) == 1);
		}

		for(int j = 0; j < 6; j++) {
			coordinate = row[1] + col[j];
			assertTrue(game.placeHit(coordinate, 1) == 1);
		}
		
		for (int i = 3; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				coordinate = row[i] + row[j];
				assertTrue(game.placeHit(coordinate, 1) == 0);
			}
		}

	}

	@Test
	void testValidPlayer2PlaceHit() {
		game.placeShip(1, "A1", "A2", 2);
		game.placeShip(1, "A3", "A5", 3);
		game.placeShip(1, "A6", "A10", 5);
		game.placeShip(1, "B1", "B3", 3);
		game.placeShip(1, "B4", "B7", 4);
		
		for(int j = 0; j < col.length; j++) {
			coordinate = row[0] + col[j];
			assertTrue(game.placeHit(coordinate, 2) == 1);
		}

		for(int j = 0; j < 6; j++) {
			coordinate = row[1] + col[j];
			assertTrue(game.placeHit(coordinate, 2) == 1);
		}
		
		for (int i = 3; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				coordinate = row[i] + row[j];
				assertTrue(game.placeHit(coordinate, 2) == 0);
			}
		}
	}

	@Test
	void testInvalidPlayer1PlaceHit() {
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j <col.length; j++) {
				coordinate = row[i] + col[j];
				game.placeHit(coordinate, 1);
			}
		}

		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j <col.length; j++) {
				coordinate = row[i] + col[j];
				assertTrue(game.placeHit(coordinate, 1) == 2);
			}
		}
		assertTrue(game.placeHit("43", 1) == 2);
		assertTrue(game.placeHit("3", 1) == 2);
		assertTrue(game.placeHit("Z10", 1) == 2);
	}

	@Test
	void testInvalidPlayer2PlaceHit() {
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j <col.length; j++) {
				coordinate = row[i] + col[j];
				game.placeHit(coordinate, 2);
			}
		}

		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j <col.length; j++) {
				coordinate = row[i] + col[j];
				assertTrue(game.placeHit(coordinate, 2) == 2);
			}
		}
		assertTrue(game.placeHit("43", 2) == 2);
		assertTrue(game.placeHit("3", 2) == 2);
		assertTrue(game.placeHit("Z10", 2) == 2);
	}

	@Test
	void testInvalidGetCoordinateData() {
		BattleshipLogic game = new BattleshipLogic();
		assertTrue(game.getCoordinateData("A1", 1) == 0);
		assertTrue(game.getCoordinateData("A0", 1) == -1);
		assertTrue(game.getCoordinateData("Z1", 1) == -1);
		assertTrue(game.getCoordinateData("Z11", 2) == -1);
	}
	
	@Test
	void testResetBoard() {
		//Valid placement of patrol boat
				assertTrue(game.placeShip(1, "A1", "A2", 2));
				assertTrue(game.getCoordinateData("a01", 1) == 1);
				assertTrue(game.getCoordinateData("A2", 1) == 1);
				
				//Valid placement of patrol boat
				assertTrue(game.placeShip(2, "j10", "J9", 2));
				assertTrue(game.getCoordinateData("j10", 2) == 1);
				assertTrue(game.getCoordinateData("j9", 2) == 1);
				
				game.resetBoard(1);
				assertTrue(game.getCoordinateData("a01", 1) == 0);
				assertTrue(game.getCoordinateData("A2", 1) == 0);
				game.resetBoard(2);
				assertTrue(game.getCoordinateData("j10", 2) == 0);
				assertTrue(game.getCoordinateData("j9", 2) == 0);
	}

	@Test
	void testGetRowAndColIndex(){
		int[] index;

		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < row.length; j++) {
				coordinate = row[i] + row[j];
				index = game.getRowAndColIndex(coordinate);
				assertTrue(index[0] == i && index[1] == j);
			}
		}

		index = game.getRowAndColIndex("L5");
		assertTrue(index[0] == -1 && index[1] == 4 );
		index = game.getRowAndColIndex("A16");
		assertTrue(index[0] == 0 && index[1] == -1);
		index = game.getRowAndColIndex("M11");
		assertTrue(index[0] == -1 && index[1] == -1 );
	}
	
	@Test
	void placeHitWithIndex() {
		assertTrue(game.placeShip(1, "A1", "A5", 5));
		assertTrue(game.placeShip(1, "B1", "B4", 4));
		assertTrue(game.placeShip(1, "C1", "C3", 3));
		assertTrue(game.placeShip(1, "D1", "D3", 3));
		assertTrue(game.placeShip(1, "E1", "E2", 2));
		
		assertTrue(game.placeShip(2, "J10", "F10", 5));
		assertTrue(game.placeShip(2, "J9", "G9", 4));
		assertTrue(game.placeShip(2, "J8", "H8", 3));
		assertTrue(game.placeShip(2, "J7", "H7", 3));
		assertTrue(game.placeShip(2, "J6", "I6", 2));
		
		System.out.println("Ships successfully placed.");
		
		for(int i = 0; i < 5; i++) {
			assertTrue(game.placeHit(i, 0, 2) == 1);
			assertTrue(game.placeHit(i, 0, 2) == 2);
		}
		
		for(int i = 0; i < 5; i++) {
			assertTrue(game.placeHit(9, i + 5, 1) == 1);
			assertTrue(game.placeHit(9, i + 5, 1) == 2);
		}
		
		assertTrue(game.placeHit(0, 9, 2) == 0);
		assertTrue(game.placeHit(1, 9, 2) == 0);
		assertTrue(game.placeHit(2, 9, 2) == 0);
		assertTrue(game.placeHit(3, 9, 2) == 0);
		assertTrue(game.placeHit(4, 9, 2) == 0);
		
		assertTrue(game.placeHit(0, 9, 2) == 2);
		assertTrue(game.placeHit(1, 9, 2) == 2);
		assertTrue(game.placeHit(2, 9, 2) == 2);
		assertTrue(game.placeHit(3, 9, 2) == 2);
		assertTrue(game.placeHit(4, 9, 2) == 2);
		
		assertTrue(game.placeHit(0, 0, 1) == 0);
		assertTrue(game.placeHit(1, 0, 1) == 0);
		assertTrue(game.placeHit(2, 0, 1) == 0);
		assertTrue(game.placeHit(3, 0, 1) == 0);
		assertTrue(game.placeHit(4, 0, 1) == 0);
		
		assertTrue(game.placeHit(0, 0, 1) == 2);
		assertTrue(game.placeHit(1, 0, 1) == 2);
		assertTrue(game.placeHit(2, 0, 1) == 2);
		assertTrue(game.placeHit(3, 0, 1) == 2);
		assertTrue(game.placeHit(4, 0, 1) == 2);
	}
	
	
	@Test
	void PlaceHitWithInvalidIndex() {
		assertTrue(game.placeHit(-5, 9, 2) == 2);
		assertTrue(game.placeHit(-5, -10, 1) == 2);
		assertTrue(game.placeHit(-5, 10, 2) == 2);
		assertTrue(game.placeHit(-1, -1, 2) == 2);
		
		assertTrue(game.placeHit(1, -1, 2) == 2);
		assertTrue(game.placeHit(2, 10, 1) == 2);
		assertTrue(game.placeHit(10, 1, 1) == 2);
		assertTrue(game.placeHit(10, 10, 1) == 2);
	}
	
	@Test
	void placeShipWithIndex() {
		assertTrue(game.placeShip(1, 0, 0, 4, 0, 5));
		assertTrue(game.placeShip(1, 0, 1, 3, 1, 4));
		assertTrue(game.placeShip(1, 0, 2, 2, 2, 3));
		assertTrue(game.placeShip(1, 0, 3, 2, 3, 3));
		assertTrue(game.placeShip(1, 0, 4, 1, 4, 2));
		
		assertTrue(game.placeShip(2, 9, 9, 9, 5, 5));
		assertTrue(game.placeShip(2, 8, 9, 8, 6, 4));
		assertTrue(game.placeShip(2, 7, 7, 7, 9, 3));
		assertTrue(game.placeShip(2, 6, 9, 6, 7, 3));
		assertTrue(game.placeShip(2, 5, 9, 5, 8, 2));
		
	}
	
	
	@Test
	void invalidPlaceShipWithIndex() {
		assertTrue(game.placeShip(1, 0, 0, 4, 0, 5));
		assertFalse(game.placeShip(1, 0, 0, 3, 0, 4));
		assertFalse(game.placeShip(1, 0, 0, 0, 3, 4));
		
		assertFalse(game.placeShip(2, -1, -1, -1, -1, 2));
		assertFalse(game.placeShip(2, -1, -1, -1, 0, 2));
		assertFalse(game.placeShip(2, -1, -1, -1, 10, 2));
		
		assertFalse(game.placeShip(2, -1, -1, 1, -1, 2));
		assertFalse(game.placeShip(2, -1, -1, 1, 1, 2));
		assertFalse(game.placeShip(2, -1, -1, 1, 10, 2));
		
		assertFalse(game.placeShip(2, -1, -1, 10, -1, 2));
		assertFalse(game.placeShip(2, -1, -1, 10, 5, 2));
		assertFalse(game.placeShip(2, -1, -1, 10, 10, 2));
		
		assertFalse(game.placeShip(2, -1, -1, 10, 10, 2));
		assertFalse(game.placeShip(2, -1, 5, 10, 10, 2));
		assertFalse(game.placeShip(2, -1, 11, 10, 10, 2));
		
		assertFalse(game.placeShip(2, 0, 0, -1, -1, 2));
	}
	
	@Test
	void computerPlaceShips() {
		game.computerPlaceShips();
		int[][] board = game.getBoard(2);
		int count = 0;
		for(int i = 0; i < row.length; i++) {
			for(int j = 0; j < col.length; j++) {
				if (1 == board[i][j]) {
					count++;
				}
				System.out.print(board[i][j] + " ");
				
			}
			System.out.println();
		}
		
		assertTrue(17 == count);
	}*/
	
	@Test
	void computerPlaceHits() {
		assertTrue(game.placeShip(1, "A2", "A6", 5));
		assertTrue(game.placeShip(1, "B1", "E1", 4));
		assertTrue(game.placeShip(1, "J10", "J8", 3));
		assertTrue(game.placeShip(1, "D3", "D5", 3));
		assertTrue(game.placeShip(1, "A10", "A9", 2));
		
		int count = 0;
		game.printBoard(1);
		
		while(!game.isGameOver()) {
			game.computerPlaceHit();
			game.getComputerHit();
			game.printBoard(1);
			
			if (count == 100) {
				System.out.println("All coordinates hit.");
				break;
			}
		}
		
	}
	
}
