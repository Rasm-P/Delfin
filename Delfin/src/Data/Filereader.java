/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Rasmus2
 */
public class Filereader {

    private static final boolean DEBUG = true;
    // String inFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\delfiner2.txt";

    public ArrayList<String[]> getSwimmersByName(String inFilename)
    {
        inFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\delfiner2.txt";
        try
        {
            ArrayList<String[]> swimmers = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("UTF-8");
            Path path = Paths.get(inFilename);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines)
            {
                if (!line.equals(""))
                {
                    String[] swim = line.split(splitBy);
                    swimmers.add(swim);
                }
            }
            return swimmers;
        } catch (IOException ex)
        {
            if (DEBUG)
            {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public void removeSwimmer(String str, String inFilename) throws IOException
    {
        inFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\delfiner2.txt";
        File file = new File(inFilename);
        List<String> out = Files.lines(file.toPath()).filter(line -> !line.contains(str)).collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    
    public ArrayList<String[]> getResults()
    {
        String inFilename = "C:\\Users\\rashe\\Documents\\GitHub\\Results";
        try
        {
            ArrayList<String[]> results = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("UTF-8");
            Path path = Paths.get(inFilename);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines)
            {
                if (!line.equals(""))
                {
                    String[] swim = line.split(splitBy);
                    results.add(swim);
                }
            }
            return results;
        } catch (IOException ex)
        {
            if (DEBUG)
            {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
