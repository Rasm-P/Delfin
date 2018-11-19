/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
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

        
    public static LocalDate setDob () {
        
        while(true)
        try {
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String dob = scanner.nextLine();
            LocalDate localDate = LocalDate.parse(dob, formatter);
             return localDate;
             
        } catch(Exception e) {
            
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
            
        return true;
        
        return false;
    }

        
            
    
}
