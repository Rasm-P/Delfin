/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 *
 * @author Ditlev
 */
public class LoginEncryption {


    public static void checkPassword() {

    }

 /**
 * Encrypts a user input.
 * 
*/
    public static String createSecurePassword(String pass) {
        for (int i = 0; i < pass.length(); ++i) {
            pass = pass.substring(i, pass.length() - pass.length() / 2) + "fs5Sg6" + pass.substring(pass.length() / 2, pass.length() - 1) + pass.substring(i, pass.length());
            pass = pass.replace("e", "afe2fDy");
            pass = pass.replace("E", "hgQg6SD");
            pass = pass.replace("A", "nhO?5=2");
            pass = pass.replace("k", "xzwertu");
            pass = pass.replace("u", "uioewl");
            pass = pass.substring(i).replace(".", "*");
            return pass;
        }
        return pass;
    }

     /**
 * Stores encrypted passwords in a file
 * 
*/
    public static void storePassword(String passW) {

        try {
            PrintStream output = new PrintStream(new FileOutputStream("password.txt", true));

            output.print(System.lineSeparator() + passW);
        } catch (IOException ex) {
            System.out.println("Fejl i fil, kontakt din systemadministrator");
        }
    }

     /**
 * Checks if password entered on login matches the stored password.
 * 
*/
    public static boolean checkPassword(String passW) {
        boolean app = false;

        String inFilename = "password.txt";

        try {

            Charset cs = Charset.forName("UTF-8");
            Path path = Paths.get(inFilename);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines) {
                if (line.equals(passW)) {
                    app = true;
                }
            }

            return app;

        } catch (Exception x) {

            System.out.println(x.getMessage());
        }
        return false;
    }

}
