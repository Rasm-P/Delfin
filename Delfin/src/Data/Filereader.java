/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import delfin.Calculator;
import delfin.Swimmer;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Rasmus2
 */
public class Filereader {

    private static final boolean DEBUG = true;

    public ArrayList<String[]> getSwimmersByName(String inFilename) {

        inFilename = "delfiner2.txt";

        try {
            ArrayList<String[]> swimmers = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("UTF-8");
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

    public ArrayList<Swimmer> swimmerToObject(ArrayList<String[]> swimmers) {
        ArrayList<Swimmer> swim = new ArrayList<>();

        for (int i = 0; i < swimmers.size(); i++) {
            String[] strings = swimmers.get(i);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            Swimmer swimmer = new Swimmer(strings[0], LocalDate.parse(strings[1], formatter), strings[2], Boolean.parseBoolean(strings[3]), Boolean.parseBoolean(strings[4]), Boolean.parseBoolean(strings[5]));
            swim.add(swimmer);
        }
        return swim;
    }

    public void removeSwimmer(String str, String inFilename) throws IOException {

        inFilename = "delfiner2.txt";

        File file = new File(inFilename);
        List<String> out = Files.lines(file.toPath()).filter(line -> !line.contains(str)).collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public ArrayList<String[]> getResults(String inFIlename) {

        String inFilename = "Results.txt";
        try {
            ArrayList<String[]> results = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("UTF-8");
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

    public ArrayList<String[]> getTeams(String inFilename) {

        inFilename = "Teams.txt";
        try {
            ArrayList<String[]> teams = new ArrayList();
            String splitBy = ", ";

            Charset cs = Charset.forName("UTF-8");
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
<<<<<<< HEAD

    public Swimmer seachSwimmer(ArrayList<Swimmer> swimmers, String name) {
        Swimmer swim = null;

        for (int i = 0; i < swimmers.size(); i++) {
            if (swimmers.get(i).getName().equals(name)) {
                swim = swimmers.get(i);
                return swim;
=======
    
    public ArrayList<Swimmer>

    public Swimmer seachSwimmer(ArrayList<Swimmer> swimmers, String name) {

        Swimmer swims = null;
            for (int i = 0; i < swimmers.size(); i++) {
                Swimmer swim = swimmers.get(i);
                if (swim.getName().equals(name)) {
                        return swims = swim;
                } 
>>>>>>> 7de33a96e43da55da831befa96b229fdd52158fc
            }
        }
        return swim;
    }

}
