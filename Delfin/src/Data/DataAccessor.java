/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import delfin.DBConnector;
import delfin.Swimmer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author LærerMart
 */
public class DataAccessor {
        private DBConnector connector = null;
  
     DataAccessor(DBConnector connector) {
        this.connector = connector;
     }
     public ArrayList<Swimmer> getSvimmersByName() {
        //throw new UnsupportedOperationException("Not supported yet.");
        try{
        String query = "Select * from delfin.svimmers Order By 'name';";

        Connection connection = connector.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        String name = "";
        //Date dob = 1998-01-01;
        String email = "";
        boolean status = true;
        boolean pro = true;
        boolean payment = true;
        
        
        ArrayList<Swimmer> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
//            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
//            swimmers.add(new Swimmer(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    
    public ArrayList<Swimmer> getSvimmersByDob() {
        //throw new UnsupportedOperationException("Not supported yet.");
        try{
        String query = "Select * from delfin.svimmers Order By 'dob';";

        Connection connection = connector.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        String name = "";
        //Date dob = 1998-01-01;
        String email = "";
        boolean status = true;
        boolean pro = true;
        boolean payment = true;
        
        
        ArrayList<Swimmer> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
//            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
//            swimmers.add(new Swimmer(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    
    public ArrayList<Swimmer> getSvimmersByEmail() {
        //throw new UnsupportedOperationException("Not supported yet.");
        try{
        String query = "Select * from delfin.svimmers Order By 'email';";

        Connection connection = connector.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        String name = "";
        //Date dob = 1998-01-01;
        String email = "";
        boolean status = true;
        boolean pro = true;
        boolean payment = true;
        
        
        ArrayList<Swimmer> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
//            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
//            swimmers.add(new Swimmer(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    public ArrayList<Swimmer> getSvimmersByStatus() {
        //throw new UnsupportedOperationException("Not supported yet.");
        try{
        String query = "Select * from delfin.svimmers Order By 'status';";

        Connection connection = connector.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        String name = "";
        //Date dob = 1998-01-01;
        String email = "";
        boolean status = true;
        boolean pro = true;
        boolean payment = true;
        
        
        ArrayList<Swimmer> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
//            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
//            swimmers.add(new Swimmer(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    
    public ArrayList<Swimmer> getSvimmersByPro() {
        //throw new UnsupportedOperationException("Not supported yet.");
        try{
        String query = "Select * from delfin.svimmers Order By 'pro';";

        Connection connection = connector.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        String name = "";
        //Date dob = 1998-01-01;
        String email = "";
        boolean status = true;
        boolean pro = true;
        boolean payment = true;
        
        
        ArrayList<Swimmer> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
//            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
//            swimmers.add(new Swimmer(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    
    public ArrayList<Swimmer> getSvimmersByPayment() {
        //throw new UnsupportedOperationException("Not supported yet.");
        try{
        String query = "Select * from delfin.svimmers Order By 'payment';";

        Connection connection = connector.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        String name = "";
        //Date dob = 1998-01-01;
        String email = "";
        boolean status = true;
        boolean pro = true;
        boolean payment = true;
        
        
        ArrayList<Swimmer> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
//            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
//            swimmers.add(new Swimmer(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
}
