package com.javaacademy.theatreproject;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TheatreTest {

	@ParameterizedTest
	@ValueSource(strings  = {"a3","A4","A7","D3","D4","D5","C7","B4","H7"}) 
	public void reserveTest(String word){
		
	}
	
	@ParameterizedTest
	@ValueSource(strings  = {"a0","A400","X7","","00","AA","D4"}) 
	public void validateTest(String word){
		
	}
	
	@ParameterizedTest
	@ValueSource(strings  = {"A4"}) 
	public void cancelTest(String word){
		
	}
}
