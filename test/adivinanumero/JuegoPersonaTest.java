/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinanumero;

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
public class JuegoPersonaTest {
    
    public JuegoPersonaTest() {
    }
  

    /**
     * Test of generadorNumero method, of class JuegoPersona.
     */
   

    /**
     * Test of duplicado method, of class JuegoPersona.
     */
    @Test
    public void testDuplicado() {
        System.out.println("duplicado");
        int numero = 5544;
        JuegoPersona instance = new JuegoPersona();
        boolean expResult = true;
        boolean result = instance.duplicado(numero);
        assertEquals(expResult, result);
          if(result==false){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of cantBienReg method, of class JuegoPersona.
     */
  

    /**
     * Test of jugar method, of class JuegoPersona.
     */
    @Test
    public void testJugar() {
        JuegoPersona juego = new JuegoPersona();
                juego.jugar();
        juego.jugar();
        boolean resultexpected = true;
        assertTrue(juego instanceof JuegoPersona == resultexpected);
        if(juego instanceof JuegoPersona == false){
        fail("The test case is a prototype.");
    }}

    
    @Test
    public void testIngresarTexto() {
        System.out.println("ingresarTexto");
        String txt = "Hola";
        JuegoPersona instance = new JuegoPersona();
        instance.ingresarTexto(txt);
        
        if(!txt.equals("Hola")){
        fail("The test case is a prototype.");
        }}

    
   
}
