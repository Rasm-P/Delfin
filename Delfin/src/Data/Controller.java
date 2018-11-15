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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rasmus2
 */
public class Controller {
    
    public JTable readTextFile(JTable jTable1) {
        DefaultTableModel model;
        model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        
        ArrayList<String[]> swimmers = new ArrayList();

        Filereader fr = new Filereader();
        swimmers = fr.getSwimmersByName();

        for (int i = 0; i < swimmers.size(); i++) {
            String[] strings = swimmers.get(i);
            model.insertRow(model.getRowCount(), new Object[]{strings[0],strings[1],strings[2],strings[3],strings[4], strings[5]});
        }
        
        return jTable1;
        
    }
    
    public void compareMembers(JTextField jTextField1) {
        ArrayList<String[]> swimmers = new ArrayList();
        String str;
        
        Filereader fr = new Filereader();
        swimmers = fr.getSwimmersByName();

        try {
            for (int i = 0; i < swimmers.size(); i++) {
                String[] strings = swimmers.get(i);
                if (strings[0].contains(jTextField1.getText())) {
                    str = String.join(", ", strings);
                    fr.removeSwimmer(str);
                } 
            }
        } catch (IOException ex) {
            Logger.getLogger(RemoveMemberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
