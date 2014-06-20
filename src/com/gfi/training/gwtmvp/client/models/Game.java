package com.gfi.training.gwtmvp.client.models;

import java.util.ArrayList;

public class Game {
	
	private Board board;
	private ArrayList<Board.Square[]> winScenarios;
	
	protected boolean isOver;
	private Player lastPlay;
	
	public Game(Board board) {
		
		this.winScenarios = new ArrayList<Board.Square[]>();
		this.winScenarios.add(new Board.Square[]{Board.Square.ONE, Board.Square.TWO, Board.Square.THREE});
		this.winScenarios.add(new Board.Square[]{Board.Square.FOUR, Board.Square.FIVE, Board.Square.SIX});
		this.winScenarios.add(new Board.Square[]{Board.Square.SEVEN, Board.Square.EIGHT, Board.Square.NINE});
		this.winScenarios.add(new Board.Square[]{Board.Square.ONE, Board.Square.FOUR, Board.Square.SEVEN});
		this.winScenarios.add(new Board.Square[]{Board.Square.TWO, Board.Square.FIVE, Board.Square.EIGHT});
		this.winScenarios.add(new Board.Square[]{Board.Square.THREE, Board.Square.SIX, Board.Square.NINE});
		this.winScenarios.add(new Board.Square[]{Board.Square.ONE, Board.Square.FIVE, Board.Square.NINE});
		this.winScenarios.add(new Board.Square[]{Board.Square.THREE, Board.Square.FIVE, Board.Square.SEVEN});
		
		board.initBoard();
	}
	
	public void reset() {
		board.initBoard();
		lastPlay = null;
	}
	
	public boolean play(Board.Square square, Player player) 
	//throws Exception
	{
		// the game must not be over and it must be our turn and the space we want to play must not already be used
		if(this.isOver() || !this.isMyTurn(player) || !this.playPossible(square) || square == null || player == null) {
			return false;
			//throw new Exception("Play not possible");
		}
		
		 // if play is possible then make set X or O on board and return true
		board.put(square, player);
		this.lastPlay = player;
		
		return true;
	}

	private boolean isMyTurn(Player player) {
		
		if(player == Player.CROSS && this.lastPlay == Player.CROSS) {
			return false;
		}
		
		if(player == Player.NAUGHT && this.lastPlay == Player.NAUGHT) {
			return false;
		}
		
		return true;
	}

	private boolean playPossible(Board.Square square) {

		if(board.getPlayerOnSquare(square) == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOver() {
		
		if(board.isFull() || this.isWon()) {
			this.isOver = true;
		} else {
			this.isOver = false;
		}
		
		return this.isOver;
	}

	protected boolean isWon() {

		for (Board.Square[] combination : this.winScenarios) {

			int i = 0;
			Player player = null;

			for (Board.Square square : combination) {				
				
				player = board.getPlayerOnSquare(square);
				
				if(player != null && player == board.getPlayerOnSquare(square)) {
					i += 1;
				}
				
				if(i == 3) return true;
			}
		}

		return false;
	}
}
