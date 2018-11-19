/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import UI.RemoveMemberGUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rasmus2
 */
public class Controller {

    public ArrayList<String[]> readTextFile() {
        //String inFilename = "/home/zzar/Documents/Delfin/Delfin/delfiner2.txt";
        String inFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\delfiner2.txt";
        ArrayList<String[]> swimmers = new ArrayList();

        Filereader fr = new Filereader();
        return swimmers = fr.getSwimmersByName(inFilename);
    }

    public void compareMembers(String member) {
        ArrayList<String[]> swimmers = new ArrayList();
        String str;
        String inFilename = "/home/zzar/Documents/Delfin/Delfin/delfiner2.txt";
        //String inFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\delfiner2.txt";
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




    
    

    public ArrayList<String[]> getResults()
    {
        ArrayList<String[]> results;
        results = new ArrayList();
        String inFilename = "/home/zzar/Documents/Delfin/Delfin/results.txt";
        //String inFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\results.txt";
        Filereader fr = new Filereader();
        return results = fr.getResults(inFilename);
    }


}

   


