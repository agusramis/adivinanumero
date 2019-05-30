package adivinanumero;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Adivinanumero {
     private static final int CANT_DIGITOS = 4;
    private static ArrayList<Integer> numeroAleatorio;
    private static Scanner scanner = new Scanner(System.in);
    private static int respuesta;
  public static void main(String[] args) {
		
    int seleccion = JOptionPane.showOptionDialog(
   null,
   "Ingrese el número de la opción del juego que quiere jugar\" ", 
  null,
   JOptionPane.YES_NO_CANCEL_OPTION,
   JOptionPane.QUESTION_MESSAGE,
   null,
   new Object[] { "1. Adivinar un número de 4 cifras (CON INTERFAZ GRAFICA)", "2. Pensar un número de 4 cifras y que la PC lo adivine(SIN INTERFAZ GRAFICA) ",},   // null para YES, NO y CANCEL
   "opcion 1"); 
     
        switch (seleccion) {
            case 0:
                JuegoPersona juego = new JuegoPersona();
                juego.jugar();
              
                break;
            case 1:
                
                JuegoPc juegoPc = new JuegoPc();
                juegoPc.jugarPC();
                break;
        }
  }
}