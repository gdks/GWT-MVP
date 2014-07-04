package com.gfi.training.gwtmvp.shared;

import com.google.gwt.dev.util.collect.HashMap;

public class Board {
	
	private HashMap<Board.Square, Player> data;
	
	public Board() {
		initBoard();
	}
	
	public void initBoard() {
		
		data = new HashMap<Board.Square, Player>();
	}
	
	public boolean isFull() {
		
		if(data.size() == 9) {
			return true;
		}
		
		return false;
	}
	
	public void put(Board.Square square, Player player) {
		data.put(square, player);
	}

	public Player getPlayerOnSquare(Board.Square square) {

		Player value = data.get(square);

		if (value != null) {
			return value;
		} else {
			return null;
		}
	}
	
	public enum Square {
		ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9);
		
		@SuppressWarnings("unused")
		private int value;

	    private Square(int value) {
	    	this.value = value;
	    }
	}
}
