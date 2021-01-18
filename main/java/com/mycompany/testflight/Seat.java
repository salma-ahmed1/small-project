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

public class Seat
{
    protected int rowNo;
    protected SeatClass seatClass;
    protected char category;
    protected SeatLocation seatLocation;
    
    public String seatId()
    {
        return String.format("%d%c", rowNo, category);
    }
    
    public Seat (int row, char cat, SeatClass x) {
        this.rowNo = row;
        this.category = cat;
        this.seatClass = x;
    }
}

enum SeatClass{Economy,Bussiness,Fisrt};
enum SeatLocation {Window, Asile, Between};
