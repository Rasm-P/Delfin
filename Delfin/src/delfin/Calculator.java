/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Rasmus2
 */
public class Calculator {
    
    /*Age < 18 = 1000
    Age > 18 = 1600 && age < 60
    Age > 60 = 1600*0,75
    Status deaktiv = 500;
    Swimmers swimmer;
    
    public int calculator() {
        if(swimmer.isStatus()==false)
            return 500;
        if(swimmer.isStatus()==true && swimmer.getDob().atTime(LocalDate))
        
        //Udregn kontigent for et givent medlem
    }
    public int calculator() {
        //Udregn kontigent for alle i klubben
    } */
    public static void main(String[] args) throws ParseException {
        Swimmers swim = new Swimmers("Hans", ("1996-05-05"), "John@hotmail.com", true, true, true);
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("1995-05-05");
        Date date2 = sdf.parse("1977-06-01");
        LocalDate local = LocalDate.of(1996, Month.MARCH, 05);
        System.out.println(local);
        System.out.println(swim.toString());
        
                //LocalDate localDate = LocalDate.parse(dob, formatter);
        
    }
   
}
