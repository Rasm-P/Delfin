
package Data;

import delfin.Swimmer;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Rasmus P, Ditlev, Emil og Rasmus H.
 */
public class Filereader {

    private static final boolean DEBUG = true;

 /**
 * Returns an arraylist containing String arrays.
 * The string arrays each contain a member, and their attributes are split by commas and can be used individually.
 * 
 * 
*/
    public ArrayList<String[]> getSwimmersByName(String inFilename) {

        inFilename = "delfiner2.txt";

        try {
            ArrayList<String[]> swimmers = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("ISO-8859-1");
            Path path = Paths.get(inFilename);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines) {
                if (!line.equals("")) {
                    String[] swim = line.split(splitBy);
                    swimmers.add(swim);
                }
            }
            return swimmers;
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
 /**
 * Converts the swimmer string array to an object.
 * Constructs a swimmer from the individual strings in the swimmers string array.
 * 
*/
    public ArrayList<Swimmer> swimmerToObject(ArrayList<String[]> swimmers) {
        ArrayList<Swimmer> swim = new ArrayList<>();

        for (int i = 0; i < swimmers.size(); i++) {
            String[] strings = swimmers.get(i);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
            Swimmer swimmer = new Swimmer(strings[0], LocalDate.parse(strings[1], formatter), strings[2], strings[3], Boolean.parseBoolean(strings[4]), Boolean.parseBoolean(strings[5]), Boolean.parseBoolean(strings[6]));

            swim.add(swimmer);
        }
        return swim;
    }

 /**
 * Removes a member from the file containing all members.
 * User input is given and compared to the string arrays until a match is made, then the desired member will be removed.
 * 
*/
    public void removeSwimmer(String str, String inFilename) throws IOException {

        inFilename = "delfiner2.txt";
        
        File file = new File(inFilename);
        List<String> out = Files.lines(file.toPath()).filter(line -> !line.contains(str)).collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardCharsets.ISO_8859_1, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

     /**
 * Returns an arraylist containing String arrays.
 * The string arrays each contain a members result, and their attributes are split by commas and can be used individually.
 * 
 * 
*/
    public ArrayList<String[]> getResults(String inFIlename) {

        String inFilename = "Results.txt";
        try {
            ArrayList<String[]> results = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("ISO-8859-1");
            Path path = Paths.get(inFilename);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines) {
                if (!line.equals("")) {
                    String[] result = line.split(splitBy);
                    results.add(result);
                }
            }
            return results;
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
        return null;
    }

     /**
 * Returns an arraylist containing String arrays.
 * The string arrays each contain a team, and their attributes are split by commas and can be used individually. 
 * 
*/
    public ArrayList<String[]> getTeams(String inFilename) {

        inFilename = "Teams.txt";
        try {
            ArrayList<String[]> teams = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("ISO-8859-1");
            Path path = Paths.get(inFilename);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines) {
                if (!line.equals("")) {
                    String[] swim = line.split(splitBy);
                    teams.add(swim);
                }
            }
            return teams;
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
        return null;
    }

/**
 * Given user input this method searches for matching information in the arraylist containing members.
 * 
*/
    public Swimmer seachSwimmer(ArrayList<Swimmer> swimmers, String name) {

        Swimmer swims = null;
            for (int i = 0; i < swimmers.size(); i++) {
                Swimmer swim = swimmers.get(i);
                if (swim.getName().equals(name)) {
                        swims = swim;
                } 
            }
        return swims;
    }

    /**
 * Removes a result from the file containing all results.
 * User input is given and compared to the string arrays until a match is made, then the desired result will be removed.
 * 
*/
    void removeResults(String str, String inFilename) throws IOException {
        
        inFilename = "Results.txt";
        
        File file = new File(inFilename);
        List<String> out = Files.lines(file.toPath()).filter(line -> !line.contains(str)).collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardCharsets.ISO_8859_1, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }


}



