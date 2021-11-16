/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cofrinho;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 55359
 */
public class OperationsTest {
    
    public OperationsTest() {
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
     * Test of InserirMoeda method, of class Operations.
     */
    @Test
    public void testInserirMoeda() {
        System.out.println("InserirMoeda");
        Cofrinho cofre = null;
        int moeda = 0;
        Operations instance = new Operations();
        boolean expResult = false;
        boolean result = instance.InserirMoeda(cofre, moeda);
        assertEquals(expResult, result);

    }


    
}
