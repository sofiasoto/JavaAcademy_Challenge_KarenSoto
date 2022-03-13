package com.javaacademy.theatreproject;

public class Seat implements Comparable<Seat> {
    private int row;
    private String line;
    private double price;
    private boolean reserved = false;

    public Seat(int seatNum, String line, double price, boolean reserved) {
        this.row = seatNum;
        this.line = line;
        this.price = price;
        this.reserved = reserved;
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    
    public boolean reserve(Seat seat){
        if (!seat.isReserved()) {
            seat.setReserved(true);
            System.out.println("Seat " + seat.getRow() + " reserved");
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelReservation(Seat seat){
        if (seat.isReserved()) {
            seat.setReserved(false);
            System.out.println("Reservation of seat " + seat.getRow() + " cancelled");
            return true;
        } else {
            return false;
        }
    }

    /**Will show free, reserved and total amount of sold seats, free and reserved */
    public void print(){
        
    }

    @Override
    public int compareTo(Seat o) {
        String seatNow = line+row;
        String compSeat = o.getLine()+o.getRow();
       return seatNow.compareToIgnoreCase(compSeat);
    }

}
