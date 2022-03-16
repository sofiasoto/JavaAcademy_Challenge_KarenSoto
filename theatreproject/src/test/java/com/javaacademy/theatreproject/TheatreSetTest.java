package com.javaacademy.theatreproject;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TheatreSetTest {
	private static TheatreSet theatre;
	private static Set<Seat> sList;
	
	@BeforeAll
	public static void setup() {
	 
		theatre = new TheatreSet("Java Academy_Karen Soto", 8, 8);
		sList = theatre.getSeatList();
	}

}
