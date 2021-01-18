/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testflight;


/**
 *
 * @author salma
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Destination Date:");
        
        FlightDestination [] destination = new FlightDestination[5];
        destination[0] = new FlightDestination("America",50000,40000,30000);
        destination[1] = new FlightDestination("NewZealand",40000,30000,20000);
        destination[2] = new FlightDestination("Germany",20000,15000,10000);
        destination[3] = new FlightDestination("France",25000,15000,17000);
        destination[4] = new FlightDestination("Brazil",15000,20000,10000);
        
       // System.out.println(destination[4].getName() + "\n" + destination[4].getBusinessPrice());
        
        
        Airoplane [] airplane  = new Airoplane[2];
        airplane[0] = new Airoplane("Boing",4,6,8,10,5,50);
        airplane[1] = new Airoplane("Airbus",6,8,10,15,10,60);
        
        
        Flight [] flight = new Flight[10];
        flight[0] = new Flight(airplane[0],"Cairo",destination[0],"1/5/2020","19.30","12.00");
        flight[1] = new Flight(airplane[0],"Cairo",destination[1],"2/5/2020","19.30","12.00");
        flight[2] = new Flight(airplane[0],"Cairo",destination[3],"3/5/2020","19.30","12.00");
        flight[3] = new Flight(airplane[0],"Cairo",destination[2],"6/5/2020","19.30","12.00");
        flight[4] = new Flight(airplane[0],"Cairo",destination[4],"5/5/2020","19.30","12.00");
        flight[5] = new Flight(airplane[1],"Cairo",destination[0],"5/5/2020","19.30","12.00");
        flight[6] = new Flight(airplane[1],"Cairo",destination[4],"7/5/2020","19.30","12.00");
        flight[7] = new Flight(airplane[1],"Cairo",destination[2],"1/5/2020","19.30","12.00");
        flight[8] = new Flight(airplane[1],"Cairo",destination[1],"10/5/2020","19.30","12.00");
        flight[9] = new Flight(airplane[1],"Cairo",destination[3],"11/5/2020","19.30","12.00");

        
        String destinationCountry = "America"; //cmboDestintion.selectedItem
        String pName = "Ahmed Rdwan"; //ttxNam.txt
        String pNo = "A12345" ; // txtPassport.text
        int row_no = 17; //textSeatNo.text
        char cat = 'B'; //txtCatgory.Text
        makeTicket(destination, flight,destinationCountry ,row_no,  cat, pName, pNo) ;
        
        destinationCountry = "Brazil"; //cmboDestintion.selectedItem
         pName = "Salma Ahmed"; //ttxNam.txt
         pNo = "BC12345" ; // txtPassport.text
         row_no = 20; //textSeatNo.text
         cat = 'D'; //txtCatgory.Text
        makeTicket(destination, flight,destinationCountry ,row_no,  cat, pName, pNo) ;
        
        
        
        
    }
    
    private static void makeTicket(FlightDestination[] destination,Flight[] flight , String destinationCountry, int row_no, char cat, String pName, String pNo) {
        Flight userFlight = null;
        for(int i=0 ; i < flight.length; i++) {
            if(flight[i].getDetination().equals(destinationCountry)) {
                userFlight = flight[i];
            }
        }
        if(userFlight == null)
            return;
        
        
        try {
        Passenger p= new Passenger(pName,pNo);
        
        String id = String.format("%d%c", row_no, cat);
        FlightSeat fs = userFlight.getseatbyID(id);
        
        userFlight.setTicket(p, fs);
        fs = userFlight.getseatbyID(id);
        System.out.println(   fs.seatId() + " : " + fs.getStatus() + " : " + fs.getPrice() );
        System.out.println(userFlight.getAvailableSeatCount()+":" + userFlight.getTotalSeatsCount());
        
        }catch (IllegalArgumentException e ) {
            System.out.println("ERROR ALLOCATION SEAT: " + e.getMessage());
        }
        //fs = userFlight.getseatbyID(id);
        
    }
    
    
}
