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
        int exp = 26;
        ArrayList result = instance.getSwimmersByName();
        assertNotNull(result);
        assertEquals(exp, result.size());

    }

    /**
     * Test of removeSwimmer method, of class Filereader.
     */
    //@Ignore
    @Test
    public void testRemoveSwimmer() throws Exception {
        System.out.println("removeSwimmer");
        String str = "Ole, 1999-05-02, ole@gmail.com, true, false, false";
        Filereader instance = new Filereader();
        instance.removeSwimmer(str);
        int exp = 25;
        ArrayList result = instance.getSwimmersByName();
        assertNotNull(result);
        assertEquals(exp, result.size());
    }
    
}
