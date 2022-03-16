package com.javaacademy.theatreproject;

import java.util.HashSet;
import java.util.Set;

public class TheatreSet {
	private String name;
	private Set<Seat> seatList = new HashSet<Seat>();
	
	 public TheatreSet(String name, int rows, int numberOfSeats) {
	        this.name = name;

	        int lastRow = 'A' + (rows - 1);
	        for (char row = 'A'; row <= lastRow; row++) {
	            for (int seatNum = 1; seatNum <= numberOfSeats; seatNum++) {
	                Seat seat = new Seat(seatNum,String.valueOf(row), 50, false);
	                seatList.add(seat);
	            }
	        }
	    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(Set<Seat> seatList) {
		this.seatList = seatList;
	}
	 
	 
}
