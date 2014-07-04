package com.gfi.training.gwtmvp.client.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gfi.training.gwtmvp.shared.Player;

public class PlayerTest {
	
	@Test
	public void testPlayerEnumsHaveValues() {
		assertEquals(Player.NAUGHT, Player.valueOf("NAUGHT"));
		assertEquals(Player.CROSS, Player.valueOf("CROSS"));
	}
}
