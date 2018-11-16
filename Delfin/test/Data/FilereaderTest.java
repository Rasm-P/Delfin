/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rumle
 */
public class FilereaderTest {
    
    public FilereaderTest() {
    }

    /**
     * Test of getSwimmersByName method, of class Filereader.
     */
    @Test
    public void testGetSwimmersByName() {
        System.out.println("getSwimmersByName");
        Filereader instance = new Filereader();
        ArrayList expResult = null;
        ArrayList result = instance.getSwimmersByName();
        assertEquals(expResult, result);

    }

    /**
     * Test of removeSwimmer method, of class Filereader.
     */
    @Test
    public void testRemoveSwimmer() throws Exception {
        System.out.println("removeSwimmer");
        String str = "";
        Filereader instance = new Filereader();
        instance.removeSwimmer(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
