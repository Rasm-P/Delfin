/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import delfin.Swimmer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author rashe
 */
public class FileWriter {

    public static void writeFile(Swimmer swim, String file) throws FileNotFoundException, UnsupportedEncodingException
    {
        file = "delfin2.txt";
        try
        {
            PrintStream output = new PrintStream(new FileOutputStream(file, true));

            output.print(System.lineSeparator() + swim);
        } catch (IOException ex)
        {
            System.out.println("Fejl i fil, kontakt din systemadministrator");
        }
    }

}
