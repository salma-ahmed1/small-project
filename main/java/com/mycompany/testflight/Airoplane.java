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
public class Airoplane 
{
    private String model;
    private int buseinessSeatsCountPerRow;
    private int FirstSeatsCountPerRow;
    private int econmySeatsCountPerRow;
    private Seat airPlanSeats[] ;
    private int firstRowNo;
    private int businessRowNo;
    private int economyRowNo;
    
    public Airoplane(String model, int bscount, int fscount, int escount, int frows, int brows, int erows) {
        this.model = model;
        this.FirstSeatsCountPerRow = fscount;
        this.buseinessSeatsCountPerRow = bscount;
        this.econmySeatsCountPerRow = escount;
        this.firstRowNo = frows;
        this.economyRowNo = erows;
        this.businessRowNo = brows;
        
        
        createSeats () ;
    }
    
    private void createSeats()
    {
        int total = FirstSeatsCountPerRow * firstRowNo + buseinessSeatsCountPerRow * businessRowNo + econmySeatsCountPerRow * economyRowNo;
        
        airPlanSeats = new Seat[total];
        
        int i = 0;
        i = createRowSeats(1,firstRowNo,FirstSeatsCountPerRow,i,SeatClass.Fisrt);
        
        i = createRowSeats(firstRowNo + 1,firstRowNo + businessRowNo,buseinessSeatsCountPerRow,i,SeatClass.Bussiness);
        
        createRowSeats(firstRowNo + businessRowNo + 1,firstRowNo + businessRowNo + economyRowNo,econmySeatsCountPerRow,i,SeatClass.Economy); 
    } //end of createseats
    
    private int createRowSeats(int fromRow, int toRow, int noOfSeats, int arrStartNo,SeatClass sc)
    {
        for (int j = fromRow ; j <= toRow; j++) {
            int x = 0;
            char cat = 'A';
            while (x < noOfSeats) {
                airPlanSeats[arrStartNo] = new Seat(j, cat, sc);
                x++;
                cat++;
                arrStartNo++;
            }
        }
        return arrStartNo;
    }

    public Seat[] getPlaneSeat()
    {
        return airPlanSeats;
    }
}