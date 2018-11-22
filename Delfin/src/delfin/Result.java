/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

import java.sql.Time;

/**
 *
 * @author Rasmus P, Ditlev, Emil og Rasmus H.
 */
public class Result {
    
    private Swimmer swimmer;
    private String comp;
    private double time;
    private int placement;
    private String disiplin;
    public Result(Swimmer swimmer, String comp, double time, int placement, String disiplin)
    {
        this.swimmer = swimmer;
        this.comp = comp;
        this.time = time;
        this.placement = placement;
        this.disiplin = disiplin;
        
    }

    public int getTime()
    {
        return (int) time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public Swimmer getSwimmer()
    {
        return swimmer;
    }

    public void setSwimmer(Swimmer swimmer)
    {
        this.swimmer = swimmer;
    }

    public String getComp()
    {
        return comp;
    }

    public void setComp(Competition comp)
    {
        
    }

    @Override
    public String toString() {
        return swimmer.getName() + ", " + swimmer.getDob() + ", " + swimmer.getEmail() + ", " + swimmer.getDeciplin() + ", " + swimmer.isStatus() + ", " + swimmer.isPro() + ", " + swimmer.isPayment() + ", " + comp + ", " + time + ", " + placement + ", " + disiplin;
    }
    
}
