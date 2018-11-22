/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import delfin.Result;
import delfin.Swimmer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Rasmus2
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Swimmer rasmus = new Swimmer("Rasmus", LocalDate.parse("1998-06-03"), "ramus@gmail.com", "din", false, true, false);
        Result result = new Result(rasmus, "DM", 12.12, 3, "crawl");
        System.out.println(result);
    }
    
}
