/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import delfin.Swimmer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Rumle
 */
public class FilereaderTest {

    public FilereaderTest() {
    }

    /**
     * Setting test.txt up so the tests work.
     */
    @BeforeClass
    public static void initialize() throws FileNotFoundException, UnsupportedEncodingException {
        String Filename = "test.txt";
        Swimmer swim = new Swimmer("Ole", LocalDate.of(1999, 5, 2), "ole@gmail.com", "rygcrawl", true, false, false);
        FileWriter.writeFile(swim, Filename);
    }

    @AfterClass
    public static void after() throws IOException {
        String Filename = "test.txt";
        String str = "Ole, 1999-05-02, ole@gmail.com, true, false, false";
        Filereader instance = new Filereader();
        instance.removeSwimmer(str, Filename);

    }

    /**
     * Test of getSwimmersByName method, of class Filereader.
     */
    @Test
    public void testGetSwimmersByName() {
        System.out.println("getSwimmersByName");
        Filereader instance = new Filereader();
        int exp = 41;
        String inFilename = "test.txt";
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
        String inFileName = "test.txt";
        String str = "Ole, 1999-05-02, ole@gmail.com, true, false, false";
        Filereader instance = new Filereader();
        instance.removeSwimmer(str, inFileName);
        int exp = 41;
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
        String inFilename = "test.txt";
        Swimmer swim = new Swimmer("Ole", LocalDate.of(1999, 5, 2), "ole@gmail.com", "rygcrawl", true, false, false);
        FileWriter instance = new FileWriter();
        instance.writeFile(swim, inFilename);
        Filereader instance2 = new Filereader();
        int exp = 41;
        ArrayList result = instance2.getSwimmersByName(inFilename);

        assertNotNull(result);
        assertEquals(exp, result.size());
    }


}
