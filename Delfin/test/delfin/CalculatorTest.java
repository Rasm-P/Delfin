/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of swimmerCalculator method, of class Calculator.
     */
    @Test
    public void testSwimmerCalculator() {
     Calculator instance = new Calculator();
     LocalDate date = LocalDate.of(1998, 02, 02);
     Swimmer lars = new Swimmer("Lars", date, "lars@gmail", true, true, true);
     
     double result = instance.swimmerCalculator(lars);
     assertEquals(1600, result, 0.0);
    }

    /**
     * Test of ageInYears method, of class Calculator.
     */
    @Test
    public void testAgeInYears() {
     Calculator instance = new Calculator();
     LocalDate date = LocalDate.of(1998, 02, 02);
     Swimmer lars = new Swimmer("Lars", date, "lars@gmail", true, true, true);
     
     double result = instance.ageInYears(lars);
     assertEquals(20, result, 0.0);
    }

    /**
     * Test of yearNow method, of class Calculator.
     */
    @Test
    public void testYearNow() {
     Calculator instance = new Calculator ();
     
     int result = instance.yearNow();
     assertEquals(2018, result, 0.0);
    }
    
}
