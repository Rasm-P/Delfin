/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
/**
 *
 * @author Ditlev
 */
public class TextUI {
    
    private static Scanner scanner = new Scanner(System.in);
    
    
    public static String setName() {
        
        
        String name = scanner.nextLine();
        if(!name.equals(name)) {
            throw new IllegalArgumentException();
        }
                    
           return name;
  
    }

        
    public static Date setDob () {
        
        while(true)
        try {
            
            
            String dob = scanner.nextLine();
            
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            
                 return date;   
        } catch(ParseException e) {
            
            System.err.println("Oooops");
            
        }
        
        
    }
    
    public static String getEmail() {
        String email = scanner.nextLine();
        return email;
    }
    public static boolean status() {
        String status = scanner.nextLine();
        if(status.equals("nej"))
            return false;
          return true;
    }

    public static boolean isPro() {
        String pro = scanner.nextLine();

        if (pro.equals("ja")) {
            return true;
        }
        return false;
    }
    public static boolean havePaid() {
        String paid = scanner.nextLine();
        if(paid.equals("ja"))
            return false;
        return true;
    }

        
            
    
}
