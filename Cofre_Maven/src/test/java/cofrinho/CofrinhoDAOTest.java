package cofrinho;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CofrinhoDAOTest {
   
    /**
     * Test of conectarnoBanco method, of class CofrinhoDAO.
     */
    @Test
    public void testConectarnoBanco() {
        System.out.println("conectarnoBanco");
        CofrinhoDAO instance = new CofrinhoDAO();
        boolean result = instance.conectarnoBanco();
        assertTrue(result);
    }

    /**
     * Test of NovoCofrinho method, of class CofrinhoDAO.
     */
    @Test
    public void testNovoCofrinho() {
        System.out.println("NovoCofrinho");
        String nome = "User_Test";
        int i = 2;
        CofrinhoDAO instance = new CofrinhoDAO();
        
        boolean result = instance.NovoCofrinho(nome, i);
        assertTrue(result);
        
    }
    /**
     * Test of inserirMoeda method, of class CofrinhoDAO.
     */
    @Test
    public void testInserirMoeda() {
        System.out.println("inserirMoeda");
        Moeda moeda = new Moeda((float) 0.25);
        int id = 3;
        String nome = "User_Test2";
        CofrinhoDAO instance = new CofrinhoDAO();
        instance.NovoCofrinho(nome, id);
        
        boolean result = instance.inserirMoeda(moeda, id);
        assertTrue(result);
       
    }

    /**
     * Test of buscarMaiorMoeda method, of class CofrinhoDAO.
     */
    @Test
    public void testBuscarMaiorMoeda() {
        System.out.println("buscarMaiorMoeda");
        Moeda moeda = new Moeda((float) 0.25);
        Moeda moeda2 = new Moeda((float) 0.50);
        int id = 4;
        String nome = "User_Test3";
        CofrinhoDAO instance = new CofrinhoDAO();
        instance.NovoCofrinho(nome, id);
        instance.inserirMoeda(moeda, id);
        instance.inserirMoeda(moeda2, id);
        
        Float expResult = ((float) 0.50);
        Float result = instance.buscarMaiorMoeda(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of RetirarMoeda method, of class CofrinhoDAO.
     */
    @Test
    public void testRetirarMoeda() {
        System.out.println("RetirarMoeda");
        float valor = ((float) 0.50); 
        Moeda moeda = new Moeda((float) 0.25);
        Moeda moeda2 = new Moeda((float) 0.50);
        int id = 5;
        String nome = "User_Test4";
        CofrinhoDAO instance = new CofrinhoDAO();
        instance.NovoCofrinho(nome, id);
        instance.inserirMoeda(moeda, id);
        instance.inserirMoeda(moeda2, id);
        
        
        boolean result = instance.RetirarMoeda(valor, id);
        assertTrue(result);
        
    }

    /**
     * Test of valorTotal method, of class CofrinhoDAO.
     */
    @Test
    public void testValorTotal() {
        System.out.println("valorTotal");
        Moeda moeda = new Moeda((float) 0.25);
        Moeda moeda2 = new Moeda((float) 0.50);
        int id = 6;
        String nome = "User_Test5";
        CofrinhoDAO instance = new CofrinhoDAO();
        instance.NovoCofrinho(nome, id);
        instance.inserirMoeda(moeda, id);
        instance.inserirMoeda(moeda2, id);
        
        float expResult = ((float) 0.75);
        float result = instance.valorTotal(id);
        assertEquals(expResult, result, 0.0);
        
    }
    /**
     * Test of numeroDeMoedas method, of class CofrinhoDAO.
     */
    @Test
    public void testNumeroDeMoedas() {
        System.out.println("numeroDeMoedas");
        Moeda moeda = new Moeda((float) 0.25);
        int id = 7;
        String nome = "User_Test6";
        CofrinhoDAO instance = new CofrinhoDAO();
        instance.NovoCofrinho(nome, id);
        instance.inserirMoeda(moeda, id);
        
        int expResult = 1;
        int result = instance.numeroDeMoedas(id);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of pegaNome method, of class CofrinhoDAO.
     */
    @Test
    public void testPegaNome() {
        System.out.println("pegaNome");
        int id = 8;
        String nome = "User_Test7";
        CofrinhoDAO instance = new CofrinhoDAO();
        instance.NovoCofrinho(nome, id);
        boolean result = instance.pegaNome(id);
        assertTrue(result);
        
    }

    /**
     * Test of MoedasNoCofrinho method, of class CofrinhoDAO.
     */
    @Test
    public void testMoedasNoCofrinho() {
        System.out.println("MoedasNoCofrinho");
        Moeda moeda = new Moeda((float) 0.10);
        int id = 9;
        String nome = "User_Test8";
        CofrinhoDAO instance = new CofrinhoDAO();
        instance.NovoCofrinho(nome, id);
        instance.inserirMoeda(moeda, id);
        float expResult = ((float) 0.10);
        float result = instance.MoedasNoCofrinho(id);
        assertEquals(expResult, result, 0.0);
       
    }
    
}
