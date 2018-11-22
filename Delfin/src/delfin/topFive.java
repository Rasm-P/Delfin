/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

/**
 *
 * @author Rasmus2
 */
public class topFive implements Comparable{
    private String name;
    private String email;
    private double time;
    private String deciplin;

    public topFive(String name, String email, double time, String deciplin) {
        this.name = name;
        this.email = email;
        this.time = time;
        this.deciplin = deciplin;
    }
        
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public double getIntTime() {
        return time;
    }
    
    public double getTime() {
        return time;
    }

    public String getDeciplin() {
        return deciplin;
    }

    @Override
    public int compareTo(Object comparestu) {
        int compareage=(int) ((topFive)comparestu).getTime();
        
        return (int) (this.time-compareage);
    }
    
    @Override
    public String toString() {
        return name + ", " + email + ", " + time + ", " + deciplin;
    }
    
}
