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
    
    private Swimmer swimmer;
    private Competition comp;

    public Result(Swimmer swimmer, Competition comp)
    {
        this.swimmer = swimmer;
        this.comp = comp;
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
        return "Result{" + "swimmer=" + swimmer + ", comp=" + comp + '}';
    }
    
}
