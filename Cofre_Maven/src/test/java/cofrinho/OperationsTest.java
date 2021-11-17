/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cofrinho;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
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
    
        @Test
    public void testMaiorMoeda() {
        System.out.println("MaiorMoeda");
        Cofrinho cofre = new Cofrinho();
        Operations instance = new Operations();
        instance.InserirMoeda(cofre, 5);
        instance.InserirMoeda(cofre, 10);
        String result = instance.MaiorMoeda(cofre);
        assertEquals("10 centavos", result);

    }



    @Test
    public void testRetirarMoeda() {
        System.out.println("RetirarMoeda");
        Cofrinho cofre = null;
        int moeda = 0;
        Operations instance = new Operations();
        boolean expResult = false;
       boolean result = instance.RetirarMoeda(cofre, moeda);
        assertEquals(expResult, result);

    }
    
    
        @Test
    public void testMenorMoeda() {
        System.out.println("MenorMoeda");
        Cofrinho cofre = new Cofrinho();
        Operations instance = new Operations();
        instance.InserirMoeda(cofre, 5);
        instance.InserirMoeda(cofre, 10);
        String result = instance.MenorMoeda(cofre);
        assertEquals("5 centavos", result);
    }

    
        @Test
    public void testValorTotal() {
        System.out.println("ValorTotal");
        Cofrinho cofre = new Cofrinho();
        Operations instance = new Operations();
        instance.InserirMoeda(cofre, 5);
        instance.InserirMoeda(cofre, 10);
        NumberFormat formatter = new DecimalFormat("0.00");
        float result = instance.ValorTotal(cofre);
        assertEquals("0,15" , formatter.format(result));


    }

        @Test
    public void testMoedasNoCofre() {
        System.out.println("MoedasNoCofre");
        Cofrinho cofre = new Cofrinho();
        Operations instance = new Operations();
        List<String> moedas = new ArrayList<>();
        instance.InserirMoeda(cofre, 10);
        instance.InserirMoeda(cofre, 25);
        moedas.add("10 centavos");
        moedas.add("25 centavos");
        //instance.MoedasNoCofre(cofre);
        List<String> result = instance.MoedasNoCofre(cofre);
        assertEquals(moedas, result);

    }

    
    
    

}
