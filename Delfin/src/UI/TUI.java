/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data.Filereader;
import java.util.ArrayList;

/**
 *
 * @author Rasmus2
 */
public class TUI {

    public static void main(String[] args) {
        String inFilename = "C:\\Users\\Rasmus2\\Documents\\GitHub\\Delfin\\Delfin\\delfiner2.txt";
        ArrayList<String[]> swimmers = new ArrayList();

        Filereader fr = new Filereader();
        swimmers = fr.getSwimmersByName(inFilename);

        for (int i = 0; i < swimmers.size(); i++) {
            String[] strings = swimmers.get(i);
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }
}
