/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import delfin.Swimmer;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Rumle
 */
public class FilereaderTest {

    public FilereaderTest() {
    }

    /**
     *
     */
    @Before
    public void initialize() throws FileNotFoundException, UnsupportedEncodingException {
      String Filename = "test.txt";
      Swimmer swim = new Swimmer("Ole", LocalDate.of(1999, 5, 2), "ole@gmail.com", true, false, false);
      FileWriter.writeFile(swim, Filename);
    }

    /**
     * Test of getSwimmersByName method, of class Filereader.
     */
    @Test
    public void testGetSwimmersByName() {
        System.out.println("getSwimmersByName");
        Filereader instance = new Filereader();
        ArrayList expResult = null;
        int exp = 27;
        String inFilename = "/home/zzar/Documents/Delfin/Delfin/Delfin/test.txt";
        ArrayList result = instance.getSwimmersByName(inFilename);
        assertNotNull(result);
        assertEquals(exp, result.size());

    }

    /**
     * Test of removeSwimmer method, of class Filereader.
     */
    @Test
    public void testRemoveSwimmer() throws Exception {
        System.out.println("removeSwimmer");
        String inFileName = "/home/zzar/Documents/Delfin/Delfin/Delfin/test.txt";
        String str = "Ole, 1999-05-02, ole@gmail.com, true, false, false";
        Filereader instance = new Filereader();
        instance.removeSwimmer(str, inFileName);
        int exp = 24;
        ArrayList result = instance.getSwimmersByName(inFileName);
        assertNotNull(result);
        assertEquals(exp, result.size());
    }

    /**
     * Test of removeSwimmer method, of class Filereader.
     */
    @Test
    public void testAddSwimmer() throws Exception {
        System.out.println("addSwimmer");
        String inFilename = "/home/zzar/Documents/Delfin/Delfin/Delfin/test.txt";
        Swimmer swim = new Swimmer("Ole", LocalDate.of(1999, 5, 2), "ole@gmail.com", true, false, false);
        FileWriter instance = new FileWriter();
        instance.writeFile(swim, inFilename);
        Filereader instance2 = new Filereader();
        int exp = 26;
        ArrayList result = instance2.getSwimmersByName(inFilename);
        assertNotNull(result);
        assertEquals(exp, result.size());
    }
    /**
     * Test of removeSwimmer method, of class Filereader.
     */
    @Test
    public void testGetResult() throws Exception {
        System.out.println("GetSwimmer");
        String Filename2 = "Results.txt";
        Filereader instance2 = new Filereader();
        int exp = 8;
        ArrayList result = instance2.getResults(Filename2);
        assertNotNull(result);
        assertEquals(exp, result.size());
    }
    
//    @Test
//    public void testSeachSwimmer()
//    {
//        System.out.println("Test Seach Swimmer");
//        String Filename3 = "test.txt";
//        Filereader instance = new Filereader();
////        Swimmer swimmer = instance.seachSwimmer(, "Rasmus");
//        Swimmer exp = new Swimmer("Rasmus", LocalDate.of(1998, 06, 03), "rasmus@gmail.com", true, true, false);
//        assertEquals(exp, swimmer);
//    }

}
