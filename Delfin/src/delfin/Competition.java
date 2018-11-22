/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. yeet
 */
package delfin;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Dxtlxv Xndxrsxn
 */
public class Competition {

    private String comName;
    private LocalDate time;
    private int placement;
    private String disciplin;
 
    public Competition(String comName, LocalDate time, String disciplin) 
    {

        this.comName = comName;
        this.time = time;
        this.placement = placement;
        this.disciplin = disciplin;

    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }
    
    @Override
    public String toString() {
        return comName + ", " + time + ", " + placement + ", " + disciplin;
    }

}
