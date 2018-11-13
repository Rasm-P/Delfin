/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rashe
 */
public class Swimmers {
    
    private String name;
    private Date dob;
    private String email;
    private boolean status;
    private boolean pro; 
    private boolean payment;

    public Swimmers(String name, Date dob, String email, boolean status, boolean pro, boolean payment)
    {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.status = status;
        this.pro = pro;
        this.payment = payment;
    }
    
    private DBConnector connector = null;
  
     Swimmers(DBConnector connector) {
        this.connector = connector;
     }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public boolean isPro()
    {
        return pro;
    }

    public void setPro(boolean pro)
    {
        this.pro = pro;
    }

    public boolean isPayment()
    {
        return payment;
    }

    public void setPayment(boolean payment)
    {
        this.payment = payment;
    }
    public ArrayList<Swimmers> getSvimmersByName() {
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
        
        
        ArrayList<Swimmers> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
            swimmers.add(new Swimmers(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    
    public ArrayList<Swimmers> getSvimmersByDob() {
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
        
        
        ArrayList<Swimmers> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
            swimmers.add(new Swimmers(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    
    public ArrayList<Swimmers> getSvimmersByEmail() {
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
        
        
        ArrayList<Swimmers> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
            swimmers.add(new Swimmers(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    public ArrayList<Swimmers> getSvimmersByStatus() {
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
        
        
        ArrayList<Swimmers> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
            swimmers.add(new Swimmers(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    
    public ArrayList<Swimmers> getSvimmersByPro() {
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
        
        
        ArrayList<Swimmers> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
            swimmers.add(new Swimmers(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    
    
    
    
    public ArrayList<Swimmers> getSvimmersByPayment() {
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
        
        
        ArrayList<Swimmers> swimmers = new ArrayList();

        while (rs.next()) {
            
            name = rs.getString("name");
            dob = rs.getDate("dob");
            email = rs.getString("email");
            status = rs.getBoolean("status");
            pro = rs.getBoolean("pro");
            payment = rs.getBoolean("payment");
            
            swimmers.add(new Swimmers(name, dob, email, status, pro, payment));
        
        
        }
        return swimmers;
        }
        catch(SQLException ex){
                
                
        }
        return null;
    }
    @Override
    public String toString() {
        return "Swimmers{" + "name=" + name + ", dob=" + dob + ", email=" + email + ", status=" + status + ", pro=" + pro + ", payment=" + payment + '}';
    }
     
}
