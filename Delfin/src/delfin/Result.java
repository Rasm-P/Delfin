/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

/**
 *
 * @author rashe
 */
public class Result {
    
    private Swimmers swimmer;
    private Competition comp;

    public Result(Swimmers swimmer, Competition comp)
    {
        this.swimmer = swimmer;
        this.comp = comp;
    }

    public Swimmers getSwimmer()
    {
        return swimmer;
    }

    public void setSwimmer(Swimmers swimmer)
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
    


    
    
    
}
