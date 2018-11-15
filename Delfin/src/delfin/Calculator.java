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
import java.time.Period;
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
    
    public static double calculatorPriceMember(Swimmer swimmer) {
        int age = (Period.between(swimmer.getDob(), LocalDate.now()).getYears());
        
        if(swimmer.isStatus()==false)
            return passive;
        
        if(age < 18)
            return junior;
        
        if(age >= 18 && age < 61)
            return senior;
        
        if(age > 60)
            return seniorDiscount;
            
        return 0.0;
        
            }
    }


