package com.gfi.training.gwtmvp.client.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gfi.training.gwtmvp.shared.Board;
import com.gfi.training.gwtmvp.shared.Player;

public class BoardTest {
	
	private Board testSubject;
	
	@Before
	public void setUp() throws Exception {
		testSubject = new Board();
	}
	
	@Test
	public void testPlacingAPieceOnTheBoard() {
		testSubject.put(Board.Square.THREE, Player.CROSS);
	}
	
	@Test
	public void testIfBoardReturnsFullWhenAllSquaresPlayed() {
	  
		testSubject.put(Board.Square.ONE, Player.NAUGHT);
		testSubject.put(Board.Square.TWO, Player.CROSS);
		testSubject.put(Board.Square.THREE, Player.NAUGHT);
		testSubject.put(Board.Square.FOUR, Player.CROSS);
		testSubject.put(Board.Square.FIVE, Player.NAUGHT);
		testSubject.put(Board.Square.SIX, Player.CROSS);
		testSubject.put(Board.Square.SEVEN, Player.NAUGHT);
		testSubject.put(Board.Square.EIGHT, Player.CROSS);
		testSubject.put(Board.Square.NINE, Player.NAUGHT);
		
		assertTrue(testSubject.isFull());
	}
	
	@Test
	public void testIfBoardReturnsFullWhenThereAreEmptySquares() {
	  
		testSubject.put(Board.Square.ONE, Player.NAUGHT);
		testSubject.put(Board.Square.TWO, Player.CROSS);
		testSubject.put(Board.Square.THREE, Player.NAUGHT);
		testSubject.put(Board.Square.EIGHT, Player.CROSS);
		testSubject.put(Board.Square.NINE, Player.NAUGHT);
		
		assertFalse(testSubject.isFull());
	}
	
	@Test
	public void testIfPopulatedSquareReturnsAPlayer() {
		testSubject.put(Board.Square.ONE, Player.NAUGHT);
		assertEquals(Player.NAUGHT, testSubject.getPlayerOnSquare(Board.Square.ONE));
	}
	
	@Test
	public void testIfEmptySquareReturnsAPlayer() {
		assertEquals(null, testSubject.getPlayerOnSquare(Board.Square.ONE));
	}
	
	@Test
	public void testBoardEnumsHaveValues() {
		assertEquals(Board.Square.ONE, Board.Square.valueOf("ONE"));
	}
}
