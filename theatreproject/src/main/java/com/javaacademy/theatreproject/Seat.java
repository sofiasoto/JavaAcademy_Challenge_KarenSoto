package com.javaacademy.theatreproject;

public class Seat implements Comparable<Seat> {
    private int row;
    private String line;
    private int price;
    private boolean reserved = false;

    public Seat(int seatNum, String line, int price, boolean reserved) {
        this.row = seatNum;
        this.line = line;
        this.price = price;
        this.reserved = reserved;
    }
    
    public Seat(int seatNum, String line, int price) {
        this.row = seatNum;
        this.line = line;
        this.price = price;
    }
    
    public Seat(int seatNum, String line) {
        this.row = seatNum;
        this.line = line;
    }
    public String getLine() {
        return line;
    }
    public void setLine(String line) {
        this.line = line;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    
    public Seat reserve(Seat seat){
        if (!seat.isReserved()) {
            seat.setReserved(true);
            System.out.println("Seat " + seat.getLine() + seat.getRow() + " reserved");
            return seat;
        } else {
        	 System.out.println("Seat " + seat.getLine() + seat.getRow() + " not reserved");
            return null;
        }
    }

    public boolean cancelReservation(Seat seat){
        if (seat.isReserved()==true) {
            seat.setReserved(false);
            System.out.println("Reservation of seat " + seat.getLine() + seat.getRow() + " cancelled");
            return true;
        } else {
        	System.out.println("The seat is not reserved " + seat.getLine() + seat.getRow());
            return false;
        }
    }

    @Override
    public int compareTo(Seat o) {
        String seatNow = line+row;
        String compSeat = o.getLine()+o.getRow();
       return seatNow.compareToIgnoreCase(compSeat);
    }

}
