package com.gfi.training.gwtmvp.client.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;

@GwtModule("com.gfi.training.gwtmvp.mvp")
public class GameTest extends GwtTestWithMockito {
	
	private Game testSubject;
	private Board board;
	
	@Mock private Board mockBoard;
	
	@Before
	public void setUp() throws Exception {
		
		board = new Board();
		testSubject = new Game(board);
	}
	
	@Test
	public void testIfWeAreCheckingForGameEndConditions() {
		
		testSubject = new Game(mockBoard);
		testSubject.isOver();
		verify(mockBoard).isFull();
	}
	
	@Test
	public void testIsGameOverWhenBoardIsEmpty() {
		
		assertFalse(testSubject.isOver());
	}
	
	@Test
	public void testIsGameOverWhenBoardPartiallyFilled() {
		testSubject.play(Board.Square.ONE, Player.CROSS);
		testSubject.play(Board.Square.ONE, Player.NAUGHT);
		testSubject.play(Board.Square.ONE, Player.CROSS);
		assertFalse(testSubject.isOver());
	}
	
	@Test
	public void testIsGameOverWhenBoardIsFull() {
		
		testSubject.play(Board.Square.ONE, Player.CROSS);
		testSubject.play(Board.Square.TWO, Player.NAUGHT);
		testSubject.play(Board.Square.THREE, Player.CROSS);
		testSubject.play(Board.Square.FOUR, Player.NAUGHT);
		testSubject.play(Board.Square.FIVE, Player.CROSS);
		testSubject.play(Board.Square.SIX, Player.NAUGHT);
		testSubject.play(Board.Square.SEVEN, Player.CROSS);
		testSubject.play(Board.Square.EIGHT, Player.NAUGHT);
		testSubject.play(Board.Square.NINE, Player.CROSS);
		
		assertTrue(testSubject.isOver());
	}
	
	@Test
	public void testThatAPlayerCanNotPlayOutsideTheBoard() {
		boolean moveMade = testSubject.play(null, Player.CROSS);
		assertFalse(moveMade);
	}
	
	@Test
	public void testThatOnlyAValidPlayerCanBeUsed() {
		boolean moveMade = testSubject.play(Board.Square.ONE, null);
		assertFalse(moveMade);
	}
	
	@Test
	public void testThatAValidPlayerCanBeUsed() {
		Player cross = Player.CROSS;
		testSubject.play(Board.Square.ONE, cross);
	}
	
	@Test
	public void testIfGameIsWonWithVerticalColumn() {
		
		testSubject.play(Board.Square.ONE, Player.CROSS);
		testSubject.play(Board.Square.THREE, Player.NAUGHT);
		testSubject.play(Board.Square.FOUR, Player.CROSS);
		testSubject.play(Board.Square.EIGHT, Player.NAUGHT);
		testSubject.play(Board.Square.SEVEN, Player.CROSS);
		assertTrue(testSubject.isOver());
		
		testSubject.reset();
		
		testSubject.play(Board.Square.TWO, Player.CROSS);
		testSubject.play(Board.Square.THREE, Player.NAUGHT);
		testSubject.play(Board.Square.FIVE, Player.CROSS);
		testSubject.play(Board.Square.NINE, Player.NAUGHT);
		testSubject.play(Board.Square.EIGHT, Player.CROSS);
		assertTrue(testSubject.isOver());
	}
	
	@Test
	public void testIfGameIsWonWithHorizontalRow() {
		
		testSubject.play(Board.Square.ONE, Player.CROSS);
		testSubject.play(Board.Square.SIX, Player.NAUGHT);
		testSubject.play(Board.Square.TWO, Player.CROSS);
		testSubject.play(Board.Square.SEVEN, Player.NAUGHT);
		testSubject.play(Board.Square.THREE, Player.CROSS);
		assertTrue(testSubject.isOver());
		
		testSubject.reset();
		
		testSubject.play(Board.Square.SEVEN, Player.CROSS);
		testSubject.play(Board.Square.TWO, Player.NAUGHT);
		testSubject.play(Board.Square.EIGHT, Player.CROSS);
		testSubject.play(Board.Square.SIX, Player.NAUGHT);
		testSubject.play(Board.Square.NINE, Player.CROSS);
		assertTrue(testSubject.isOver());
	}
	
	@Test
	public void testIfGameIsWonWithDiagonal() {
		
		testSubject.play(Board.Square.ONE, Player.CROSS);
		testSubject.play(Board.Square.FOUR, Player.NAUGHT);
		testSubject.play(Board.Square.FIVE, Player.CROSS);
		testSubject.play(Board.Square.TWO, Player.NAUGHT);
		testSubject.play(Board.Square.NINE, Player.CROSS);
		assertTrue(testSubject.isOver());
		
		testSubject.reset();
		
		testSubject.play(Board.Square.THREE, Player.CROSS);
		testSubject.play(Board.Square.TWO, Player.NAUGHT);
		testSubject.play(Board.Square.FIVE, Player.CROSS);
		testSubject.play(Board.Square.FOUR, Player.NAUGHT);
		testSubject.play(Board.Square.SEVEN, Player.CROSS);
		assertTrue(testSubject.isOver());
	}
	
	@Test
	public void testMakePlayWhenSpaceEmpty() {
		boolean moveMade = this.testSubject.play(Board.Square.ONE, Player.CROSS);
		assertTrue(moveMade);
    }
	
	@Test
	public void testMakePlayWhenSpaceAlreadyFilled() {
		
		boolean moveMade;
		
		// we should be able to play when field is empty
		moveMade = this.testSubject.play(Board.Square.ONE, Player.CROSS);
		assertTrue(moveMade);
		
		// we shouldn't be able to make this play because we just played the field
		moveMade = this.testSubject.play(Board.Square.ONE, Player.NAUGHT);
		assertFalse(moveMade);
	}
	
	@Test
	public void testIfCrossesCanPlayWhenStartingNewGame() {
		boolean moveMade = this.testSubject.play(Board.Square.ONE, Player.CROSS);
		assertTrue(moveMade);
	}
	
	@Test
	public void testIfNaughtsCanPlayWhenStartingNewGame() {
		boolean moveMade = this.testSubject.play(Board.Square.ONE, Player.NAUGHT);
		assertTrue(moveMade);
	}
	
	@Test
	public void testIfNaughtsCanOnlyPlayAfterCrossesMidGame() {
		boolean moveMade;
		
		moveMade = this.testSubject.play(Board.Square.ONE, Player.CROSS);
		assertTrue(moveMade);
		
		moveMade = this.testSubject.play(Board.Square.TWO, Player.CROSS);
		assertFalse(moveMade);
	}
	
	@Test
	public void testIfCrossesCanOnlyPlayAfterNaughtsMidGame() {
		boolean moveMade;
		
		moveMade = this.testSubject.play(Board.Square.ONE, Player.NAUGHT);
		assertTrue(moveMade);
		
		moveMade = this.testSubject.play(Board.Square.TWO, Player.NAUGHT);
		assertFalse(moveMade);
	}
	
	@Test
	public void testIfPlayersCanAlternateTurns() {
		boolean moveMade;
		
		moveMade = this.testSubject.play(Board.Square.ONE, Player.NAUGHT);
		assertTrue(moveMade);
		
		moveMade = this.testSubject.play(Board.Square.TWO, Player.CROSS);
		assertTrue(moveMade);
		
		moveMade = this.testSubject.play(Board.Square.THREE, Player.NAUGHT);
		assertTrue(moveMade);
	}
}
