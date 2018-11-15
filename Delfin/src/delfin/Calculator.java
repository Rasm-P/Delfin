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
    
    public static double swimmerCalculator(Swimmer swimmer) {
            
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
       
    public static int ageInYears(Swimmer swimmer) {
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
    
}

