/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;


import java.time.LocalDate;
import java.time.Period;


/**
 *
 * @author rashe
 */
public class Swimmer {
    
    private String name;
    private LocalDate dob;
    private String email;
    private boolean status;
    private boolean pro; 
    private boolean payment;

    public Swimmer(String name, LocalDate dob, String email, boolean status, boolean pro, boolean payment)
    {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.status = status;
        this.pro = pro;
        this.payment = payment;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDob()
    {
        return dob;
    }

    public void setDob(LocalDate dob)
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
    
    @Override
    public String toString() {
        return name + ", " + dob + ", "+ email + ", "+ status + ", " + pro + ", " + payment ;
    }
    
    public static double calculatorPriceMember(Swimmer swimmer) {
        int age = (Period.between(swimmer.getDob(), LocalDate.now()).getYears());
        
        if(swimmer.isStatus()==false)
            return Calculator.getPassive();
        
        if(age < 18)
            return Calculator.getJunior();
        
        if(age >= 18 && age < 61)
            return Calculator.getSenior();
        
        if(age > 60)
            return Calculator.getSeniorDiscount();
            
        return 0.0;
    }
}
