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
    private static int senior = 1600;
    private static double seniorDiscount = 1600*0.75;
    private static int junior = 1000;
    private static int passive = 500;
    
    public static double swimmerCalculator(Swimmers swimmer) {
            
        if(swimmer.isStatus()==false)
            return passive;
        if(Calculator.ageInYears(swimmer) < 18)
            return junior;
        if(Calculator.ageInYears(swimmer) > 60)
             return seniorDiscount;
        if(Calculator.ageInYears(swimmer) < 60)
            return senior;
        
        return 0.0;
    
    }
       
    public static int ageInYears(Swimmers swimmer) {
        LocalDate date = swimmer.getDob();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy LLLL dd");
        String formattedString = date.format(formatter);
        String age = formattedString.substring(0, 4);
        int yearsOld = Integer.parseInt(age);
        int year = (Calculator.yearNow());
        return year - yearsOld;
        
    }
    public static int yearNow() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy LLLL dd");
        String formattedString = now.format(formatter);
        String year = formattedString.substring(0, 4);
        int yearNow = Integer.parseInt(year);
        return yearNow;
    }
    public static int ageMonth() {
        return 2;
    }
    public static void main(String[] args) throws ParseException {
        LocalDate dateX = LocalDate.of(1992, 05, 05);
        Swimmers swimmer = new Swimmers("Hans", dateX, "qweqwe", true, true, true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1995-05-05");
        Date date1 = sdf.parse("2005-01-07");
        LocalDate now = LocalDate.now();
        System.out.println(Math.abs(swimmer.getDob().getYear()-now.getYear()));
        System.out.println(Math.abs(swimmer.getDob().getDayOfMonth()-now.getDayOfMonth()));
        System.out.println(Math.abs(swimmer.getDob().getMonthValue()-now.getMonthValue()));
        
        long diff = Math.abs(date.getYear()-date1.getYear());
        long diff1 = Math.abs(date1.getDate()-date.getDate());
        long diff2 = Math.abs(date.getMonth()-date1.getMonth());
        System.out.println(diff + " " + diff1 + " " + diff2);
    }
    
  
   
}
