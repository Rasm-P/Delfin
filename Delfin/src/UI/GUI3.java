/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data.Controller;
import Data.Filereader;
import delfin.LoginEncryption;
import delfin.Swimmer;
import delfin.Team;
import delfin.topFive;
import java.awt.Color;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rasmus2
 */
public class GUI3 extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    /*
    Controller con = new Controller();
    Filereader file = new Filereader();
    ArrayList<String[]> results = con.getResults();
    ArrayList<String[]> swimmers = con.readTextFile();
    ArrayList<Swimmer> swim = file.swimmerToObject(swimmers);
    DefaultTableModel model;
     */
    private void setMemberTable() {
        Controller con = new Controller();
        ArrayList<String[]> swimmers = con.readTextFile();
        DefaultTableModel model;

        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < swimmers.size(); i++) {
            String[] strings = swimmers.get(i);
            model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]});
        }
    }

    private void setSvømmeresultater() {
        Controller con = new Controller();
        ArrayList<String[]> results = con.getResults();
        DefaultTableModel model;

        model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (int i = 0; i < results.size(); i++) {
            String[] strings = results.get(i);
            model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[2], strings[7], strings[8], strings[9], strings[10]});
        }
    }

    private void setKontingent() {
        Controller con = new Controller();
        Filereader file = new Filereader();
        ArrayList<String[]> swimmers = con.readTextFile();
        ArrayList<Swimmer> swim = file.swimmerToObject(swimmers);
        DefaultTableModel model;

        model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);

        if (jComboBox3.getSelectedItem().equals("Alle kontingenter")) {
            for (int i = 0; i < swimmers.size(); i++) {
                String[] strings = swimmers.get(i);
                Swimmer swimmer = swim.get(i);
                if (Boolean.parseBoolean(strings[5]) == false) {
                    model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[6], "Restance"});
                } else {
                    model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[6], Swimmer.calculatorPriceMember(swimmer)});
                }
            }
        }
        if (jComboBox3.getSelectedItem().equals("Alle betalt")) {
            for (int i = 0; i < swimmers.size(); i++) {
                String[] strings = swimmers.get(i);
                Swimmer swimmer = swim.get(i);
                if (Boolean.parseBoolean(strings[5]) == true) {
                    model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[6], Swimmer.calculatorPriceMember(swimmer)});
                }
            }
        }
        if (jComboBox3.getSelectedItem().equals("Alle restance")) {
            for (int i = 0; i < swimmers.size(); i++) {
                String[] strings = swimmers.get(i);
                Swimmer swimmer = swim.get(i);
                if (Boolean.parseBoolean(strings[5]) == false) {
                    model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[6], "Restance"});
                }
            }
        }
    }

    private void setHold() {
        Controller con = new Controller();
        Filereader file = new Filereader();
        ArrayList<String[]> swimmers = con.readTextFile();
        ArrayList<Swimmer> swim = file.swimmerToObject(swimmers);
        DefaultTableModel model;

        ArrayList<Swimmer> swimmersJunior = new ArrayList<>();
        ArrayList<Swimmer> swimmersSenior = new ArrayList<>();
        ArrayList<Swimmer> butterfly = new ArrayList<>();
        ArrayList<Swimmer> crawl = new ArrayList<>();
        ArrayList<Swimmer> rygcrawl = new ArrayList<>();
        ArrayList<Swimmer> brystsvoemning = new ArrayList<>();
        Team konkurrencesvømmerJunior = new Team("Junior", "konkurrencesvømmerJunior", swimmersJunior);
        Team konkurrencesvømmerSenior = new Team("Senior", "konkurrencesvømmerSenior", swimmersSenior);
        Team butterflyHold = new Team("Butterfly", "butterflyHold", butterfly);
        Team crawlHold = new Team("Crawl", "crawlHold", crawl);
        Team rygcrawlHold = new Team("Rygcrawl", "rygcrawlHold", rygcrawl);
        Team brystsvoemningHold = new Team("Brystsvømning", "brystsvømningHold", brystsvoemning);
        for (int i = 0; i < swim.size(); i++) {
            Swimmer swims = swim.get(i);
            int age = (Period.between(swims.getDob(), LocalDate.now()).getYears());
            if (age < 18 && swims.isPro() == true) {
                konkurrencesvømmerJunior.addMembers(swims);
            }
            if (age >= 18 && swims.isPro() == true) {
                konkurrencesvømmerSenior.addMembers(swims);
            }
            if (swims.getDeciplin().equals("butterfly")) {
                butterflyHold.addMembers(swims);
            }
            if (swims.getDeciplin().equals("crawl")) {
                crawlHold.addMembers(swims);
            }
            if (swims.getDeciplin().equals("rygcrawl")) {
                rygcrawlHold.addMembers(swims);
            }
            if (swims.getDeciplin().equals("brystsvoemning")) {
                brystsvoemningHold.addMembers(swims);
            }
        }
        model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        if (jComboBox1.getSelectedItem().equals("Konkurrencesvømmer Junior")) {
            for (int i = 0; i < konkurrencesvømmerJunior.getMembers().size(); i++) {
                Swimmer swimmer = konkurrencesvømmerJunior.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.getDeciplin(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
        if (jComboBox1.getSelectedItem().equals("Konkurrencesvømmer Senior")) {
            for (int i = 0; i < konkurrencesvømmerSenior.getMembers().size(); i++) {
                Swimmer swimmer = konkurrencesvømmerSenior.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.getDeciplin(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
        if (jComboBox1.getSelectedItem().equals("Butterfly")) {
            for (int i = 0; i < butterflyHold.getMembers().size(); i++) {
                Swimmer swimmer = butterflyHold.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.getDeciplin(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
        if (jComboBox1.getSelectedItem().equals("Crawl")) {
            for (int i = 0; i < crawlHold.getMembers().size(); i++) {
                Swimmer swimmer = crawlHold.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.getDeciplin(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
        if (jComboBox1.getSelectedItem().equals("Rygrawl")) {
            for (int i = 0; i < rygcrawlHold.getMembers().size(); i++) {
                Swimmer swimmer = rygcrawlHold.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.getDeciplin(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
        if (jComboBox1.getSelectedItem().equals("Brystsvømning")) {
            for (int i = 0; i < brystsvoemningHold.getMembers().size(); i++) {
                Swimmer swimmer = brystsvoemningHold.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.getDeciplin(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
    }

    private void setKonkurance() {
        Controller con = new Controller();
        ArrayList<String[]> results = con.getResults();
        DefaultTableModel model;

        ArrayList<topFive> butterflyTop = new ArrayList<>();
        ArrayList<topFive> crawlTop = new ArrayList<>();
        ArrayList<topFive> rygcrawlTop = new ArrayList<>();
        ArrayList<topFive> brystsvoemningTop = new ArrayList<>();

        for (int i = 0; i < results.size(); i++) {
            String[] strings = results.get(i);
            if (strings[10].equals("butterfly") && butterflyTop.size() <= 5) {
                topFive swimmer = new topFive(strings[0], strings[1], Double.parseDouble(strings[8]), strings[10]);
                butterflyTop.add(swimmer);
            }
            if (strings[10].equals("crawl") && crawlTop.size() <= 5) {
                topFive swimmer = new topFive(strings[0], strings[1], Double.parseDouble(strings[8]), strings[10]);
                crawlTop.add(swimmer);
            }
            if (strings[10].equals("rygcrawl") && rygcrawlTop.size() <= 5) {
                topFive swimmer = new topFive(strings[0], strings[1], Double.parseDouble(strings[8]), strings[10]);
                rygcrawlTop.add(swimmer);
            }
            if (strings[10].equals("brystsvoemning") && brystsvoemningTop.size() <= 5) {
                topFive swimmer = new topFive(strings[0], strings[1], Double.parseDouble(strings[8]), strings[10]);
                brystsvoemningTop.add(swimmer);
            }
        }

        Collections.sort(butterflyTop);
        Collections.sort(crawlTop);
        Collections.sort(rygcrawlTop);
        Collections.sort(brystsvoemningTop);

        model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);
        if (jComboBox2.getSelectedItem().equals("Butterfly")) {
            for (int i = 0; i < butterflyTop.size(); i++) {
                topFive strings = butterflyTop.get(i);
                model.insertRow(model.getRowCount(), new Object[]{strings.getName(), strings.getEmail(), strings.getTime(), strings.getDeciplin()});
            }
        }
        if (jComboBox2.getSelectedItem().equals("Crawl")) {
            for (int i = 0; i < crawlTop.size(); i++) {
                topFive strings = crawlTop.get(i);
                model.insertRow(model.getRowCount(), new Object[]{strings.getName(), strings.getEmail(), strings.getTime(), strings.getDeciplin()});
            }
        }
        if (jComboBox2.getSelectedItem().equals("Rygrawl")) {
            for (int i = 0; i < rygcrawlTop.size(); i++) {
                topFive strings = rygcrawlTop.get(i);
                model.insertRow(model.getRowCount(), new Object[]{strings.getName(), strings.getEmail(), strings.getTime(), strings.getDeciplin()});
            }
        }
        if (jComboBox2.getSelectedItem().equals("Brystsvoemning")) {
            for (int i = 0; i < brystsvoemningTop.size(); i++) {
                topFive strings = brystsvoemningTop.get(i);
                model.insertRow(model.getRowCount(), new Object[]{strings.getName(), strings.getEmail(), strings.getTime(), strings.getDeciplin()});
            }
        }

    }

    public GUI3() {
        initComponents();
        getContentPane().setBackground(Color.white);

        setMemberTable();
        setSvømmeresultater();
        setKontingent();
        setHold();
        setKonkurance();
        /*
        Controller con = new Controller();
        Filereader file = new Filereader();
        ArrayList<String[]> results = con.getResults();
        ArrayList<String[]> swimmers = con.readTextFile();
        ArrayList<Swimmer> swim = file.swimmerToObject(swimmers);
        DefaultTableModel model;
        
         */

 /*
        model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (int i = 0; i < swimmers.size(); i++) {
            String[] strings = swimmers.get(i);
            Swimmer swimmer = swim.get(i);
            if (Boolean.parseBoolean(strings[5]) == false) {
                model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[5], "Restance"});
            } else {
                model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[5], Swimmer.calculatorPriceMember(swimmer)});
            }
        }
         */
 /*
        model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (int i = 0; i < results.size(); i++) {
            String[] strings = results.get(i);
            model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[2], strings[6], strings[7], strings[8], strings[9]});
        }
         */

 /*
        ArrayList<Swimmer> swimmersJunior = new ArrayList<>();
        ArrayList<Swimmer> swimmersSenior = new ArrayList<>();
        Team konkurrencesvømmerJunior = new Team("Junior", "konkurrencesvømmerJunior", swimmersJunior);
        Team konkurrencesvømmerSenior = new Team("Senior", "konkurrencesvømmerSenior", swimmersSenior);
        for (int i = 0; i < swim.size(); i++) {
            Swimmer swims = swim.get(i);
            int age = (Period.between(swims.getDob(), LocalDate.now()).getYears());
            if (age < 18 && swims.isPro() == true) {
                konkurrencesvømmerJunior.addMembers(swims);
            }
            if (age >= 18 && swims.isPro() == true) {
                konkurrencesvømmerSenior.addMembers(swims);
            }
        }
        model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        if (jComboBox1.getSelectedItem().equals("Konkurrencesvømmer Junior")) {
            for (int i = 0; i < konkurrencesvømmerJunior.getMembers().size(); i++) {
                Swimmer swimmer = konkurrencesvømmerJunior.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
        if (jComboBox1.getSelectedItem().equals("Konkurrencesvømmer Senior")) {
            for (int i = 0; i < konkurrencesvømmerSenior.getMembers().size(); i++) {
                Swimmer swimmer = konkurrencesvømmerSenior.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton36 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton39 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton40 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton48 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton52 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Capture2.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jLabel19)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addComponent(jLabel19))
        );

        jPanel2.add(jPanel12, "card8");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jButton7.setText("Medlemmer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Svømmeresultater");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Kontingenter");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Svømmedecipliner");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Decipliner top 5");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delfin.PNG"))); // NOI18N

        jButton37.setText("Logout");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton37))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jButton37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel10, "card4");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jButton36.setText("Medlemmer");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton38.setText("Kontingenter");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delfin.PNG"))); // NOI18N

        jButton39.setText("Logout");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton39)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(799, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jButton39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel9, "card3");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jButton41.setText("Medlemmer");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setText("Svømmeresultater");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton44.setText("Svømmedecipliner");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setText("Decipliner top 5");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delfin.PNG"))); // NOI18N

        jButton40.setText("Logout");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton40)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(296, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jButton40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel8, "card2");

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel1.setText("Brugernavn:");

        jLabel6.setText("Password:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(634, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel11, "card7");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Medlemmer");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date of birth", "eMail", "Deciplin", "Status", "Konkurancesvømmer", "Payment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Database information Medlemmer:");

        jButton48.setText("Tilføj ny medlem");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton50.setText("Fjern en medlem");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jButton51.setText("Refresh");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton48)
                            .addGap(18, 18, 18)
                            .addComponent(jButton50)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton51))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton48)
                    .addComponent(jButton50)
                    .addComponent(jButton51))
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel1.add(jPanel3, "card2");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date of birth", "eMail", "Stævne", "Tid", "Placering", "Deciplin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setText("Database information Svømmeresultater:");

        jButton17.setText("Tilføj resultater");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel7.setText("Svømmeresultater");

        jButton52.setText("Refresh");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton18.setText("Fjern resultater");
        jButton18.setActionCommand("Fjern resultater");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton17)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton52))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton52)
                    .addComponent(jButton18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel1.add(jPanel4, "card3");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date of birth", "Paid", "Payment/Restance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel8.setText("Database information Kontingenter:");

        jLabel10.setText("Kontingenter");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alle kontingenter", "Alle betalt", "Alle restance" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel1.add(jPanel5, "card4");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date of birth", "Decipin", "Passiv", "Konkurrencesvømmer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel11.setText("Database information Svømmedecipliner:");

        jLabel13.setText("Svømmedecipliner");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Konkurrencesvømmer Senior", "Konkurrencesvømmer Junior", "Butterfly", "Crawl", "Rygrawl", "Brystsvømning" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel1.add(jPanel6, "card5");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date of birth", "Tid", "Deciplin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jLabel14.setText("Database information Konkurancer:");

        jLabel16.setText("Decipliner top 5 ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Butterfly", "Crawl", "Rygrawl", "Brystsvoemning" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16)
                        .addComponent(jLabel14)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel1.add(jPanel7, "card6");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);

        if (jPanel10.isVisible() && jPanel3.isVisible()) {
            jButton48.setVisible(true);
            jButton50.setVisible(true);
        } else {
            jButton48.setVisible(false);
            jButton50.setVisible(false);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jPanel3.setVisible(false);
        jPanel4.setVisible(true);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(true);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(true);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(true);
        jPanel11.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);

        if (jPanel10.isVisible() && jPanel3.isVisible()) {
            jButton48.setVisible(true);
            jButton50.setVisible(true);
        } else {
            jButton48.setVisible(false);
            jButton50.setVisible(false);
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(true);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);

        if (jPanel10.isVisible() && jPanel3.isVisible()) {
            jButton48.setVisible(true);
            jButton50.setVisible(true);
        } else {
            jButton48.setVisible(false);
            jButton50.setVisible(false);
        }
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        jPanel3.setVisible(false);
        jPanel4.setVisible(true);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(true);
        jPanel7.setVisible(false);
        jPanel11.setVisible(false);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(true);
        jPanel11.setVisible(false);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        jPanel12.setVisible(true);
        jPanel10.setVisible(false);
        jPanel9.setVisible(false);
        jPanel8.setVisible(false);

        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(true);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        jPanel12.setVisible(true);
        jPanel10.setVisible(false);
        jPanel9.setVisible(false);
        jPanel8.setVisible(false);

        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(true);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        jPanel12.setVisible(true);
        jPanel10.setVisible(false);
        jPanel9.setVisible(false);
        jPanel8.setVisible(false);

        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel11.setVisible(true);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        NewMemberGUI itemloader = new NewMemberGUI();
        itemloader.setVisible(true);
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        RemoveMemberGUI itemloader = new RemoveMemberGUI();
        itemloader.setVisible(true);
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        setMemberTable();

        setSvømmeresultater();
        setKontingent();
        setHold();
        setKonkurance();

        /*
        Controller con = new Controller();
        ArrayList<String[]> swimmers = con.readTextFile();

        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < swimmers.size(); i++) {
            String[] strings = swimmers.get(i);
            model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]});
        }
         */
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        setSvømmeresultater();

        setMemberTable();
        setKontingent();
        setHold();
        setKonkurance();
        /*
        Controller con = new Controller();
        ArrayList<String[]> results = con.getResults();

        DefaultTableModel model;
        model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (int i = 0; i < results.size(); i++) {
            String[] strings = results.get(i);
            model.insertRow(model.getRowCount(), new Object[]{strings[0], strings[1], strings[2], strings[6], strings[7], strings[8], strings[9]});
        }
         */
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        setHold();

        setMemberTable();
        setSvømmeresultater();
        setKontingent();
        setKonkurance();
        /*
        Controller con = new Controller();
        Filereader file = new Filereader();
        ArrayList<String[]> swimmers = con.readTextFile();
        ArrayList<Swimmer> swim = file.swimmerToObject(swimmers);

        ArrayList<Swimmer> swimmersJunior = new ArrayList<>();
        ArrayList<Swimmer> swimmersSenior = new ArrayList<>();
        Team konkurrencesvømmerJunior = new Team("Junior", "konkurrencesvømmerJunior", swimmersJunior);
        Team konkurrencesvømmerSenior = new Team("Senior", "konkurrencesvømmerSenior", swimmersSenior);
        for (int i = 0; i < swim.size(); i++) {
            Swimmer swims = swim.get(i);
            int age = (Period.between(swims.getDob(), LocalDate.now()).getYears());
            if (age < 18 && swims.isPro() == true) {
                konkurrencesvømmerJunior.addMembers(swims);
            }
            if (age >= 18 && swims.isPro() == true) {
                konkurrencesvømmerSenior.addMembers(swims);
            }
        }

        DefaultTableModel model;
        model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        if (jComboBox1.getSelectedItem().equals("Konkurrencesvømmer Junior")) {
            for (int i = 0; i < konkurrencesvømmerJunior.getMembers().size(); i++) {
                Swimmer swimmer = konkurrencesvømmerJunior.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
        if (jComboBox1.getSelectedItem().equals("Konkurrencesvømmer Senior")) {
            for (int i = 0; i < konkurrencesvømmerSenior.getMembers().size(); i++) {
                Swimmer swimmer = konkurrencesvømmerSenior.getMembers().get(i);
                model.insertRow(model.getRowCount(), new Object[]{swimmer.getName(), swimmer.getDob(), swimmer.isStatus(), swimmer.isPro()});
            }
        }
         */
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        setKonkurance();

        setMemberTable();
        setSvømmeresultater();
        setKontingent();
        setHold();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        AddResult itemloader = new AddResult();
        itemloader.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        setKontingent();

        setMemberTable();
        setSvømmeresultater();
        setHold();
        setKonkurance();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (LoginEncryption.checkPassword(LoginEncryption.createSecurePassword(password.getText())) && (username.getText().equals("admin"))) {
            jPanel12.setVisible(false);
            jPanel10.setVisible(true);
            jPanel9.setVisible(false);
            jPanel8.setVisible(false);

            jPanel3.setVisible(true);
            jPanel4.setVisible(false);
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);
            jPanel7.setVisible(false);
            jPanel11.setVisible(false);

            if (jPanel10.isVisible() && jPanel3.isVisible()) {
                jButton48.setVisible(true);
                jButton50.setVisible(true);
            } else {
                jButton48.setVisible(false);
                jButton50.setVisible(false);
            }
        }

        if (LoginEncryption.checkPassword(LoginEncryption.createSecurePassword(password.getText())) && (username.getText().equals("kassér"))) {
            jPanel12.setVisible(false);
            jPanel10.setVisible(false);
            jPanel9.setVisible(true);
            jPanel8.setVisible(false);

            jPanel3.setVisible(true);
            jPanel4.setVisible(false);
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);
            jPanel7.setVisible(false);
            jPanel11.setVisible(false);

            if (jPanel10.isVisible() && jPanel3.isVisible()) {
                jButton48.setVisible(true);
                jButton50.setVisible(true);
            } else {
                jButton48.setVisible(false);
                jButton50.setVisible(false);
            }
        }

        if (LoginEncryption.checkPassword(LoginEncryption.createSecurePassword(password.getText())) && (username.getText().equals("træner"))) {
            jPanel12.setVisible(false);
            jPanel10.setVisible(false);
            jPanel9.setVisible(false);
            jPanel8.setVisible(true);

            jPanel3.setVisible(true);
            jPanel4.setVisible(false);
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);
            jPanel7.setVisible(false);
            jPanel11.setVisible(false);

            if (jPanel10.isVisible() && jPanel3.isVisible()) {
                jButton48.setVisible(true);
                jButton50.setVisible(true);
            } else {
                jButton48.setVisible(false);
                jButton50.setVisible(false);
            }
        }
        /*
        jPopupMenu1.setVisible(rootPaneCheckingEnabled);
        jPopupMenu1.setToolTipText("Forket adgangskode");
         */
        password.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
