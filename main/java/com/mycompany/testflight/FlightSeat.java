package com.mycompany.testflight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author salma
 */
enum FlightSeatStatus {Free, Booked};

public class FlightSeat extends Seat
{
    private double price;
    private FlightSeatStatus status;
    private Passenger p;
    
    public FlightSeat(int row, char cat, SeatClass x,  double price) {
        super(row, cat, x);
        //this.rowNo = row;
        //this.category = cat;
        //this.seatClass = x;
        this.price = price;
        this.status = FlightSeatStatus.Free;
    }
    
    public FlightSeat(Seat s, double price )
    {
        super(s.rowNo, s.category, s.seatClass);
        //this.category = s.category;
        //this.rowNo = s.rowNo;
        //this.seatClass = s.seatClass;
        //this.seatLocation = s.seatLocation;
        this.price = price;
        this.status = FlightSeatStatus.Free;
    }

    
    public void setPassenger(Passenger s)
    {
        if(this.status == FlightSeatStatus.Free)
        {
            this.p = s;
            this.status = FlightSeatStatus.Booked;
            //return true;
        }
        throw new java.lang.IllegalArgumentException ("Seat Not Vaialbe");
        
        //return false ;
    }   
    
    public FlightSeatStatus getStatus() {
        return status;
               
    }
    
    public double getPrice() {
        return price;
    }
}
