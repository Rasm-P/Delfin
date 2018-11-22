/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import delfin.Result;
import delfin.Swimmer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Rasmus P, Ditlev, Emil og Rasmus H.
 */
public class FileWriter {

/**
 * Adds user input to the text file containing members.
 * This method is used to add members to a file.
 * The constructor parameters are given in the NewMemberGUI class.
 * 
*/
    public static void writeFile(Swimmer swim, String file) throws FileNotFoundException, UnsupportedEncodingException
    {
        file = "delfiner2.txt";
        try
        {
            PrintStream output = new PrintStream(new FileOutputStream(file, true));

            output.print(System.lineSeparator() + swim);
        } catch (IOException ex)
        {
            System.out.println("Fejl i fil, kontakt din systemadministrator");
        }
    }
    
 /**
 * Adds user input to the text file containing results.
 * This method is used to add results to a file.
 * The constructor parameters are given in the AddResult class.
 * 
*/
        public static void writeResult(Result result, String file) throws FileNotFoundException, UnsupportedEncodingException
    {
        file = "Results.txt";
        try
        {
            PrintStream output = new PrintStream(new FileOutputStream(file, true));
            
            output.print(System.lineSeparator() + result);
        } catch (IOException ex)
        {
            System.out.println("Fejl i fil, kontakt din systemadministrator");
        }
    }

}
