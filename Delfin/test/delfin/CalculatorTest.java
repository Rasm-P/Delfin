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
     * Test of calculatorPriceMember method, of class Swimmer.
     */
    @Test
    public void testswimmerPriceMemberPasive() {
        LocalDate date = LocalDate.of(1998, 02, 02);
        Swimmer lars = new Swimmer("Lars", date, "lars@gmail", false, true, true);
        double result = Swimmer.calculatorPriceMember(lars);
        assertEquals(500, result, 0.0);
    }

    /**
     * Test of calculatorPriceMember method, of class Swimmer.
     */
    @Test
    public void testswimmerPriceMemberJunior() {
        LocalDate date = LocalDate.of(2004, 02, 02);
        Swimmer lars = new Swimmer("Lars", date, "lars@gmail", true, true, true);
        double result = Swimmer.calculatorPriceMember(lars);
        assertEquals(1000, result, 0.0);

    }

    /**
     * Test of calculatorPriceMember method, of class Swimmer.
     */
    @Test
    public void testswimmerPriceMemberJuniorPassive() {
        LocalDate date = LocalDate.of(2004, 02, 02);
        Swimmer lars = new Swimmer("Lars", date, "lars@gmail", false, true, true);
        double result = Swimmer.calculatorPriceMember(lars);
        assertEquals(500, result, 0.0);

    }

    /**
     * Test of calculatorPriceMember method, of class Swimmer.
     */
    
    @Test
    public void testswimmerPriceMemberSenior() {
        LocalDate date = LocalDate.of(1990, 02, 02);
        Swimmer lars = new Swimmer("Lars", date, "lars@gmail", true, true, true);
        double result = Swimmer.calculatorPriceMember(lars);
        assertEquals(1600, result, 0.0);
    }
     @Test
    public void testswimmerPriceMemberSeniorPassive() {
        LocalDate date = LocalDate.of(1990, 02, 02);
        Swimmer lars = new Swimmer("Lars", date, "lars@gmail", false, true, true);
        double result = Swimmer.calculatorPriceMember(lars);
        assertEquals(500, result, 0.0);
    }
    /**
     * Test of calculatorPriceMember method, of class Swimmer.
     */
    @Test
    public void testswimmerPriceMemberSeniorDiscount() {
        LocalDate date = LocalDate.of(1950, 02, 02);
        Swimmer lars = new Swimmer("Lars", date, "lars@gmail", true, true, true);
        double result = Swimmer.calculatorPriceMember(lars);
        assertEquals(1200, result, 0.0);

    }
    /**
     * Test of calculatorPriceMember method, of class Swimmer.
     */
    
    @Test
    public void testswimmerPriceMemberSeniorDiscountPassive() {
        LocalDate date = LocalDate.of(2004, 02, 02);
        Swimmer lars = new Swimmer("Lars", date, "lars@gmail", false, true, true);
        double result = Swimmer.calculatorPriceMember(lars);
        assertEquals(500, result, 0.0);

    }

    



}
}
