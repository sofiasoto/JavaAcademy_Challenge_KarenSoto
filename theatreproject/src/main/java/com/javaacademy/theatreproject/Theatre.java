package com.javaacademy.theatreproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Theatre {
    //having a 8x8 theatre+

    private String name;
    private List<Seat> seatList = new ArrayList<>();
    //private Integer rows;//A-H
    //private Integer numberOfSeats;//i=8

    public Theatre(String name, int rows, int numberOfSeats) {
        this.name = name;

        int lastRow = 'A' + (rows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= numberOfSeats; seatNum++) {
                Seat seat = new Seat(seatNum,String.valueOf(row), 50, false);
                //Seat seat = new Seat(row + String.format("%02d", seatNum));
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

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public boolean reserveSeat(int seatNum, String line, int price) {
    	Seat requestedSeat = new Seat(seatNum,line,price);
        int foundSeat = Collections.binarySearch(seatList, requestedSeat, null);
        if (foundSeat >= 0) {
        	
        	Seat us = requestedSeat.reserve(requestedSeat);
        	if(us==null) return false;
        	
            return true;
        } else {
            System.out.println("The seat number " +  line+seatNum +" is not available");
            return false;
        }
    }
    
    public boolean validateSeat(int seatNum, String line) {
    	String s= line + seatNum;
    	if(line.equals("")||seatNum==0) return false;
    	if(!s.matches("[A-H]{1}\\d{1}")) {
			return false;
		}else {
			return true;
		}	
    }

    public boolean cancelSeat(int seatNum, String line, List<Seat> sList){
        Seat requestedSeat=new Seat(seatNum,line);
        int foundSeat=Collections.binarySearch(sList,requestedSeat,null);
        if(foundSeat>=0){
        	requestedSeat.setReserved(true);
            return requestedSeat.cancelReservation(requestedSeat);
        }
        else {
            System.out.println("The seat "+ line+seatNum + " does not exists");
            return false;
        }
    }
    
    public void printingTheatre(String name, List<Seat> seats ) {
    	System.out.println("Welcome " +name);
    	
    	List<Seat> sold = seats.stream().filter(s -> s.isReserved() == true).collect(Collectors.toList());
    	Integer sum = sold.stream()
    			
    			
    			.mapToInt(s -> s.getPrice())
    			  .sum();
    	
    	for(int i=0;i<seats.size();i++) {
    		
    		if(seats.get(i).getRow()%8==0) {
    			if (seats.get(i).isReserved()) {
    				System.out.print("[" + seats.get(i).getLine()+seats.get(i).getRow()+ "]\r");
    			}else {
    				System.out.print("." + "\r");
    			}
    			
    		}else {
    			if (seats.get(i).isReserved()) {
    				System.out.print("[" + seats.get(i).getLine()+seats.get(i).getRow() + "] ");
    			}else {
    				
    				System.out.print("."  + " ");
    			}
    			
    		}
    	}
    	
    	System.out.println("Total Available: " + (seats.size()-sold.size()));
    	
    	System.out.println("Total Sold: " + sold.size());
    	
    	System.out.println("Total Income: " + sum);
    }

    
    public List<Seat> updatedSeats(List<Seat> seats, int seatNumber, String line, boolean cancelOrnot){
    	List<Seat> uList = new ArrayList<Seat>();
    	
    	if(cancelOrnot) {
    		for(Seat i : seats) {
        		if(i.getLine().equals(line) && i.getRow()==seatNumber) {
        			i.setReserved(false);
        			uList.add(i);
        		}else {
        			uList.add(i);
        		}
        	}
    	}else {
    		for(Seat i : seats) {
        		if(i.getLine().equals(line) && i.getRow()==seatNumber) {
        			i.setReserved(true);
        			uList.add(i);
        		}else {
        			uList.add(i);
        		}
        	}
    	}
    	
    	
    	return uList;
    }
}
