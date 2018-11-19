/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

import java.sql.Time;

/**
 *
 * @author rashe
 */
public class Result {
    
    private Swimmer swimmer;
    private Competition comp;
    private int time;
    private int placement;
    public Result(Swimmer swimmer, Competition comp, int time, int placement)
    {
        this.swimmer = swimmer;
        this.comp = comp;
        this.time = time;
        this.placement = placement;
    }

    public int getTime()
    {
        return time;
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

    public Competition getComp()
    {
        return comp;
    }

    public void setComp(Competition comp)
    {
        this.comp = comp;
    }

    @Override
    public String toString() {
        return swimmer + ", " + comp + ", " + time;
    }
    
}
