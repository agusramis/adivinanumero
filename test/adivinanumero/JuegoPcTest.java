/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinanumero;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajram
 */
public class JuegoPcTest {
    
    public JuegoPcTest() {
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
     * Test of generadorNumero method, of class JuegoPc.
     */
    @Test
    public void testGeneradorNumero() {
        
        JuegoPc instance = new JuegoPc();
        ArrayList<Integer> esperado = new ArrayList<Integer>();
       esperado.add(5);
        esperado.add(4);
    esperado.add(2);
    esperado.add(1);
        ArrayList<Integer> result = instance.generadorNumero();
        assertNotEquals(esperado, result);
        if(result.equals(esperado)){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of convertirArray method, of class JuegoPc.
     */
    @Test
    public void testConvertirArray() {
      
        int n = 5421;
        JuegoPc instance = new JuegoPc();
         ArrayList<Integer> esperado = new ArrayList<Integer>();
       esperado.add(5);
        esperado.add(4);
    esperado.add(2);
    esperado.add(1);
        ArrayList<Integer> result = instance.convertirArray(n);
        assertEquals(esperado, result);
     if(!result.equals(esperado)){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of compararAnterior method, of class JuegoPc.
     */


    /**
     * Test of duplicado method, of class JuegoPc.
     */
    @Test
    public void testDuplicado() {
        
        ArrayList<Integer> esperado = new ArrayList<Integer>();
       esperado.add(5);
        esperado.add(5);
    esperado.add(2);
    esperado.add(1);
        JuegoPc instance = new JuegoPc();
        boolean expResult = true;
        boolean result = instance.duplicado(esperado);
        assertEquals(expResult, result);
      if(result==false){
        fail("The test case is a prototype.");
    }
    }

    
    @Test
    public void testConvertirToInt() {
        ArrayList<Integer> esperado = new ArrayList<Integer>();
       esperado.add(5);
        esperado.add(4);
    esperado.add(2);
    esperado.add(1);
        JuegoPc instance = new JuegoPc();
        int expResult = 5421;
        int result = instance.convertirToInt(esperado);
        assertEquals(expResult, result);
        if(result!=expResult){
        fail("The test case is a prototype.");
    }}

   
    @Test
    public void testConvertToStr() {
        
       ArrayList<Integer> esperado = new ArrayList<Integer>();
       esperado.add(5);
        esperado.add(4);
    esperado.add(2);
    esperado.add(1);
        JuegoPc instance = new JuegoPc();
        String expResult = "5421";
        String result = instance.convertToStr(esperado);
        assertEquals(expResult, result);
      if(!result.equals(expResult)){
        fail("The test case is a prototype.");
    }

    
 
    
}}
