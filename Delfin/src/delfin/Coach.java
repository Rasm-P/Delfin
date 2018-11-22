/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rasmus P, Ditlev, Emil og Rasmus H.
 */
public class Coach {
    
    private String name;
    private Date dob;
    private String email;
    private double sallery;
    private ArrayList<Team> teams = new ArrayList();

    public Coach(String name, Date dob, String email, double sallery, ArrayList<Team> teams) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.sallery = sallery;
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSallery() {
        return sallery;
    }

    public void setSallery(double sallery) {
        this.sallery = sallery;
    }

    public ArrayList<Team> getTeam() {
        return teams;
    }

    public void setTeam(ArrayList<Team> team) {
        this.teams = team;
    }
    
    @Override
    public String toString() {
        return "Coach{" + "name=" + name + ", dob=" + dob + ", email=" + email + ", sallery=" + sallery + ", teams=" + teams + '}';
    }
    
}
