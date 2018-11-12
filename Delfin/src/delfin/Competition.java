/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

import java.util.ArrayList;

/**
 *
 * @author Dxtlxv Xndxrsxn
 */
public class Competition {

    private String comName;
    private double time;
    private int placement;
    private String disciplin;
    private ArrayList<Result> placements;

    public Competition(String comName, double time, int placement, String disciplin, ArrayList<Result> placements) throws IllegalAccessException
    {
        if (comName == null || time < 0 || placement < 0 || disciplin == null || placements.size() < 0)
        {
            throw new IllegalAccessException("Noob");
        }

        this.comName = comName;
        this.time = time;
        this.placement = placement;
        this.disciplin = disciplin;
        this.placements = placements;
    }

}
