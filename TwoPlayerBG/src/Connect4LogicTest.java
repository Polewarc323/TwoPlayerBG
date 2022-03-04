


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import connect4Stuff.Models.Board;
import connect4Stuff.Controller.Connect4Logic;

/*************************************************
*
*The Junit Tests for Connect4Logic
* @author Calab Bahlbi
*
*************************************************/
class Connect4LogicTest {
	


	@Test
	void testWin1() {
		int[][] position = {
		        {2, 1, 1, 1, 2, 2},
				{2, 1, 2, 1, 2, 1},
				{1, 2, 1, 2, 1, 2},
				{1, 2, 1, 2, 1, 2},
				{2, 2, 1, 2, 1, 2},
				{1, 1, 2, 1, 2, 1},
				{2, 1, 2, 1, 2, 1}};
		Board b = new Board(position, 1);
		assertTrue(b.checkForWinner()); 
	}
	
	@Test
	void testWin2() {
		int[][] position = {
		        {2, 1, 2, 1, 2, 1},
				{2, 1, 2, 1, 2, 2},
				{1, 2, 1, 2, 1, 2},
				{1, 2, 1, 2, 1, 2},
				{2, 2, 1, 2, 1, 2},
				{1, 1, 2, 1, 2, 1},
				{2, 1, 2, 1, 1, 1}};
		Board b = new Board(position, 1);
		assertTrue(b.checkForWinner());
	}
	
	@Test
	void testWin3() {
		int[][] position = {
		        {2, 1, 1, 1, 2, 2},
				{2, 1, 2, 1, 2, 2},
				{1, 2, 1, 2, 1, 2},
				{1, 2, 1, 2, 1, 1},
				{2, 2, 1, 2, 1, 2},
				{1, 1, 2, 1, 2, 1},
				{2, 1, 2, 1, 1, 2}};
		Board b = new Board(position, 1);
		assertTrue(b.checkForWinner());
	}
	
	@Test
	void testWin4() {
		int[][] position = {
		        {2, 2, 2, 1, 2, 1},
				{2, 1, 2, 1, 2, 2},
				{1, 2, 1, 2, 1, 2},
				{1, 2, 1, 2, 1, 1},
				{2, 2, 1, 2, 1, 2},
				{1, 1, 2, 1, 2, 1},
				{2, 2, 1, 1, 1, 2}};
		Board b = new Board(position, 1);
		assertTrue(b.checkForWinner());
	}
	
	@Test
	void testWin5() {
		int[][] position = {
		        {2, 2, 2, 2, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0}};
		Board b = new Board(position, 1);
		assertTrue(b.checkForWinner());
	}
	
	@Test
	void testWinDiagonal() {
		int[][] position = {
		        {2, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0},
				{0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0}};
		Board b = new Board(position, 1);
		assertTrue(b.checkDiagonal());
	}
	
	@Test
	void testWinDiagonal2() {
		int[][] position = {
		        {2, 0, 0, 1, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0, 0},
				{1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0}};
		Board b = new Board(position, 1);
		assertTrue(b.checkDiagonal());
	}
	
	@Test
	void testWinDiagonal3() {
		int[][] position = {
		        {2, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0, 0},
				{1, 0, 2, 0, 0, 0},
				{0, 0, 0, 2, 0, 0},
				{0, 0, 0, 0, 2, 0},
				{0, 0, 0, 0, 0, 2}};
		Board b = new Board(position, 1);
		assertTrue(b.checkDiagonal());
	}
	
	@Test
	void testWinDiagonal4() {
		int[][] position = {
		        {2, 0, 0, 1, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0, 0},
				{1, 0, 0, 2, 0, 0},
				{0, 0, 2, 0, 0, 0},
				{0, 2, 0, 0, 0, 0},
				{2, 0, 0, 0, 0, 0}};
		Board b = new Board(position, 1);
		assertTrue(b.checkDiagonal());
	}
}
