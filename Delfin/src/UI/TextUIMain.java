/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import delfin.Swimmers;
import java.util.Date;

/**
 *
 * @author Ditlev
 */
public class TextUIMain {
    
    public static void main(String[] args) {
        //Swimmers swimmer1 = new Swimmers
        System.out.println("Navn");
        String name = TextUI.setName();
        System.out.println("Date of birth(Day/Month/year)");
        Date date = TextUI.setDob();
        System.out.println("Emil:");
        String mail = TextUI.getEmail();
        System.out.println("Medlemsskabsstatus");
        Boolean status = TextUI.status();
        System.out.println("konkurrencesvømmer");
        Boolean pro = TextUI.isPro();
        System.out.println("Har betalt");
        Boolean payment = TextUI.havePaid();
        Swimmers swimmer = new Swimmers(name, date, mail, status, pro, payment);
        System.out.println(swimmer.toString());
        
    }
    
}
