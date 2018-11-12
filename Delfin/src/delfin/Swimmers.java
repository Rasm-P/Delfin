/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

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

    public Swimmers(String name, Date dob, String email, boolean status, boolean pro)
    {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.status = status;
        this.pro = pro;
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
    
    
    
            
}
