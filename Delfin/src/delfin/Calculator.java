/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;



/**
 *
 * @author Rasmus P, Ditlev, Emil og Rasmus H.
 */
public class Calculator {
    private static double seniorPrice = 1600;
    private static double seniorDiscountPrice = 1600*0.75;
    private static double juniorPrice = 1000;
    private static double passivePrice = 500;

    public static double getSeniorPrice() {
        return seniorPrice;
    }

    public static double getSeniorDiscountPrice() {
        return seniorDiscountPrice;
    }

    public static double getJuniorPrice() {
        return juniorPrice;
    }

    public static double getPassivePrice() {
        return passivePrice;
    }
    
}

