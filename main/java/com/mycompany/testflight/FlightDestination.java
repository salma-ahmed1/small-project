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
public class FlightDestination {
    
    private String countryName;
    private double buinessPrice;
    private double firstClassPrice;
    private double economyPrice;
    
    public FlightDestination(String n, double bp, double fp, double ep) {
        this.buinessPrice = bp;
        this.countryName = n;
        this.economyPrice = ep;
        this.firstClassPrice = fp;
    }
    
    public  double getPrice(SeatClass sc) {
        if(sc == SeatClass.Bussiness)
            return buinessPrice;
        else if (sc == SeatClass.Fisrt)
            return firstClassPrice;
        else if (sc == SeatClass.Economy)
            return economyPrice;
        
        return 0;
        
    }
    public double getBusinessPrice() {
       return buinessPrice;    
    }
       public double getFirstClassPrice() {
       return firstClassPrice;    
    }
       public double getEconomyPrice() {
       return economyPrice;    
    }
       
       public String getName() {
           return this.countryName;
       }
    
    
    
}
