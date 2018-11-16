/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

import java.io.FileReader;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LærerMart
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }
    
    /**
     * Test of swimmerCalculator method, of class Calculator.
     */
    @Test
    public void testswimmerPriceMember() {
     LocalDate date = LocalDate.of(1998, 02, 02);
     Swimmer lars = new Swimmer("Lars", date, "lars@gmail", true, true, true);
     double result = Swimmer.calculatorPriceMember(lars);
     assertEquals(1600, result, 0.0);
    }

    /**
     * Test of ageInYears method, of class Calculator.
     */
    @Test
    public void testswimmerPriceMember2()
    {
     LocalDate date = LocalDate.of(1998, 02, 02);
     Swimmer lars = new Swimmer("Lars", date, "lars@gmail", false, true, true);
     double result = Swimmer.calculatorPriceMember(lars);
     assertEquals(500, result, 0.0);
     
        
    }
    

    
    
}
