/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author rashe
 */
public class HelpUI {
    
        public static boolean status(String s) {
        
<<<<<<< HEAD
         
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
=======
        if(s.equals("nej"))
>>>>>>> 544af3be0edd17fd0207dfc8790c8af0097ce110
            return false;
          return true;
}
        
        
}
