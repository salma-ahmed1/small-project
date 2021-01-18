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
public class Flight
{
    private String country;
    private FlightDestination destination;
    private String flightDate;
    private String arrTime;
    private String departTime;
    private FlightSeat seats[];
    private Airoplane airPlane;
    
    public Flight(Airoplane p, String country, FlightDestination destination , String fdate , String arrtime, String departime)
    {
        this.country = country;
        this.destination = destination;
        this.flightDate = fdate;
        this.arrTime = arrtime;
        this.departTime = departime;
        this.airPlane = p;
        
        createFlightSeats();
    }
    
    private void createFlightSeats()
    {
        Seat[] aSeats = airPlane.getPlaneSeat();
        seats = new FlightSeat[aSeats.length];
        for(int i=0; i < aSeats.length; i++ )
        {
            double price = destination.getPrice(aSeats[i].seatClass);
            Seat s = aSeats[i];
            seats[i] = new FlightSeat(s, price);
        }
    }
    
    public void setTicket(Passenger p, FlightSeat s)
    {
        int i = 0;
        boolean found = false ;
        for(; i < seats.length ; i++)
            if(seats[i].seatId().equals(s.seatId())) {
                found = true ;
             break;   
            }
        
        try {
            if(found)
                seats[i].setPassenger(p);
            //else 
                //"";
        }catch (java.lang.IllegalArgumentException e) {
            throw e;
            
            
        }
        
    }
    
    public int getAvailableSeatCount () {
        int count=0;
        for(int i=0; i< seats.length; i++){
            if(seats[i].getStatus() == FlightSeatStatus.Free) {
                count++;
            }
        }
        return count; 
    }
    
    public int getTotalSeatsCount() {
        return seats.length;
    }
    public int geBookedSeatsCount() {
        return seats.length - getAvailableSeatCount();
    }
    
    
    public  FlightSeat[] getAvailableSeat() {
        int count= getAvailableSeatCount();
        FlightSeat[] sts = new FlightSeat[count];
        int j = 0;
        for(int i=0; i< seats.length; i++){
            if(seats[i].getStatus() == FlightSeatStatus.Free) {
                sts[j] = seats[i];
                j++;
            }
        }
        return sts; 
    }
    public  FlightSeat[] getBookedSeat() {
        int count= getAvailableSeatCount();
        count = seats.length - count;
        FlightSeat[] sts = new FlightSeat[count];
        int j = 0;
        for(int i=0; i< seats.length; i++){
            if(seats[i].getStatus() == FlightSeatStatus.Booked) {
                sts[j] = seats[i];
                j++;
            }
        }
        return sts; 
    }
    
    public FlightSeat getseatbyID(String id)
    {
        for(int i=0 ; i < seats.length ; i++) {
            if(seats[i].seatId().equals(id)){
                //System.out.println( i + ": Found" +  seats[i].seatId() );
                return seats[i];
            }
            //System.out.println( i + ": Not Found" +  seats[i].seatId() );
        }
        return null;
    }
    
    
    public FlightDestination getDetination() {
        return this.destination;
    }
    
    
    
    
}//end class flight
