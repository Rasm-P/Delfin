/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import UI.RemoveMemberGUI;
import UI.RemoveResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

 /**
 * Controller class. 
 * Has methods used by GUI
 * 
*/
public class Controller {

 /**
 * Reads text file containing every member of the club.
 * Returns a list of the members.
 * 
*/
    public ArrayList<String[]> readTextFile() {
        String inFilename = "delfiner2.txt";
        ArrayList<String[]> swimmers = new ArrayList();

        Filereader fr = new Filereader();
        return swimmers = fr.getSwimmersByName(inFilename);
    }

 /**
 * Used to remove a member from the members list and the text file containing mebers.
 * Compares the existing members in the list to an admin input.
 * 
*/
    public void compareMembers(String member) {
        ArrayList<String[]> swimmers = new ArrayList();
        String str;
        String inFilename = "delfiner2.txt";
        Filereader fr = new Filereader();
        swimmers = fr.getSwimmersByName(inFilename);

        try {

            for (int i = 0; i < swimmers.size(); i++) {
                String[] strings = swimmers.get(i);
                if (strings[0].equals(member)) {
                    str = String.join(", ", strings);
                    fr.removeSwimmer(str, inFilename);
                } 
            }
        } catch (IOException ex) {
            Logger.getLogger(RemoveMemberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 /**
 * Reads text file containing the times of members. 
 * Returns a list of times.
 * 
*/
    public ArrayList<String[]> getResults()
    {
        ArrayList<String[]> results;
        results = new ArrayList();
        String inFilename = "Results.txt";
        Filereader fr = new Filereader();
        return results = fr.getResults(inFilename);
    }

 /**
 * Used to remove a result from the results list and the text file containing results.
 * Compares the name of a member with an existing results in the list to an admin input.
 * 
*/
    public void compareResults(String text) {
        ArrayList<String[]> results = new ArrayList();
        String str;
        String inFilename = "Results.txt";
        Filereader fr = new Filereader();
        results = fr.getResults(inFilename);

        try {

            for (int i = 0; i < results.size(); i++) {
                String[] strings = results.get(i);
                if (strings[0].equals(text)) {
                    str = String.join(", ", strings);
                    fr.removeResults(str, inFilename);
                } 
            }
        } catch (IOException ex) {
            Logger.getLogger(RemoveResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


