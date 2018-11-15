/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import UI.GUI3;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rasmus2
 */
public class Controller {
    
    public void readTextFile(JTable jTable1) {
        GUI3 gui = new GUI3();
        
        DefaultTableModel model;
        model = (DefaultTableModel)jTable1.getModel();
        
        ArrayList<String[]> swimmers = new ArrayList();

        Filereader fr = new Filereader();
        swimmers = fr.getSwimmersByName();

        for (int i = 0; i < swimmers.size(); i++) {
            String[] strings = swimmers.get(i);
            model.insertRow(model.getRowCount(), new Object[]{strings[0],strings[1],strings[2],strings[3],strings[4], strings[5]});
        }
    }
}
