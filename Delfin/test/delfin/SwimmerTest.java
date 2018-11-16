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
 * @author Emil
 */
public class SwimmerTest {
    
    public SwimmerTest() {
    }
    
    
    @Test
    public void testCalculatorPriceMember() {
        LocalDate date = LocalDate.of(1998, 02, 02);
        Swimmer lars = new Swimmer("Lars", date, "lars@gmail.com", true, true, true);
        
        double result = lars.calculatorPriceMember(lars);
        assertEquals(1600, result, 0.0);
    }
    
}
