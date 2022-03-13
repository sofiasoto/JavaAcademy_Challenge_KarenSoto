package com.javaacademy.theatreproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public boolean reserveSeat(int seatNum, String line, double price, boolean reserved) {
        Seat requestedSeat = new Seat(seatNum,line,price,reserved);
        int foundSeat = Collections.binarySearch(seatList, requestedSeat, null);
        if (foundSeat >= 0) {
            return requestedSeat.reserve(requestedSeat);
        } else {
            System.out.println("The seat number " +  line+seatNum +" is not available");
            return false;
        }
    }


    public boolean cancelSeat(int seatNum, String line, double price, boolean reserved){
        Seat requestedSeat=new Seat(seatNum,line,price,reserved);
        int foundSeat=Collections.binarySearch(seatList,requestedSeat,null);
        if(foundSeat>=0){
            return requestedSeat.cancelReservation(requestedSeat);
        }
        else {
            System.out.println("No seat "+ line+seatNum);
            return false;
        }
    }

}
