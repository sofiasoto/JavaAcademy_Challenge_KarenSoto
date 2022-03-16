package com.javaacademy.theatreproject;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TheatreTest {
	
	private static Theatre theatre;
	private static List<Seat> sList;
	
	@BeforeAll
	public static void setup() {
	 
		theatre = new Theatre("Java Academy_Karen Soto", 8, 8);
		sList = theatre.getSeatList();
	}

	@ParameterizedTest
	@ValueSource(strings  = {"a3","A4","A7","D3","D4","D5","C7","B4","H7"}) 
	public void reserveTest(String word){
		
		int seatNumber = Character.getNumericValue(word.charAt(1));
		String line = Character.toString(word.charAt(0));
		
		assertTrue(theatre.reserveSeat(seatNumber, line, 50));
		
		sList = theatre.updatedSeats(theatre.getSeatList(), seatNumber, line,false);
	}
	
	@ParameterizedTest
	@ValueSource(strings  = {"a0","A400","X7","","00","AA","D4"}) 
	public void validateTest(String word){
		int seatNumber = Character.getNumericValue(word.charAt(1));
		String line = Character.toString(word.charAt(0));
		assertTrue(theatre.validateSeat(seatNumber,line));
	}
	
	@ParameterizedTest
	@ValueSource(strings  = {"A4"}) 
	public void cancelTest(String word){
		int seatNumber = Character.getNumericValue(word.charAt(1));
		String line = Character.toString(word.charAt(0));
		assertTrue(theatre.cancelSeat(seatNumber,line,sList));
		sList = theatre.updatedSeats(theatre.getSeatList(), seatNumber, line,true);
	}
	
	@AfterAll()
	public static void printTest(){
		theatre.printingTheatre(theatre.getName(), sList);
	}
}
