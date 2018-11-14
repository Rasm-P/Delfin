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
 * @author rashe
 */
public class HelpUI {

    private static Scanner scanner = new Scanner(System.in);

    
    public static String checkIsString(String s) {
        
         
        if(!s.matches("[a-zA-Z]*")) {
            throw new IllegalArgumentException("OOPS");
        
        }
        return s;
    }
    public static void main(String[] args) {
        HelpUI.checkIsString("qw2e123");
    }
    public static LocalDate setDob() {

        while (true) {
            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dob = scanner.nextLine();
                LocalDate localDate = LocalDate.parse(dob, formatter);
                return localDate;

            } catch (Exception e) {

                System.err.println("Oooops");
            }
        }
    }

   

    public static boolean memberShipStatus(String s) {
        
        if (s.equals("nej")) {
            return false;
        }
        return true;
    }

    public static boolean isPro(String s) {
        
        if (s.equals("nej")) {
            return false;
        }
        return true;
    }

    public static boolean havePaid(String s) {
        
        if (s.equals("nej")) {
            return false;
        }
        return true;
        
    }
}
