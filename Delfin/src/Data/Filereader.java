/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import delfin.Swimmers;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus2
 */
public class Filereader {

    private static final boolean DEBUG = true;
    String inFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\delfiner.txt";
    //String outFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\delfiner.txt";
    
<<<<<<< HEAD
    public ArrayList<String[]> getSwimmersByName() {
        try {
            ArrayList<String[]> swimmers = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("UTF-8");
            Path path = Paths.get(inFilename);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines) {
                String[] swim = line.split(splitBy);
                swimmers.add(swim);
            }
            return swimmers;
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
        return null;
=======
    public ArrayList<Swimmers> getSvimmersByName() {
      return null;  
>>>>>>> 84520d57d8dff352bb218fa534a8660939a42f59
    }
}
