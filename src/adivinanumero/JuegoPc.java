/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinanumero;

import java.util.ArrayList;
import java.util.*;


public class JuegoPc {
    private static Scanner scanner = new Scanner(System.in);
  public int intentos;
  public ArrayList<Integer> numSiguiente = new ArrayList<>();
  public String numeroSrt;
  boolean repetidos = false;
  public ArrayList<Integer> numAleatorio = new ArrayList<>();
  public HashMap<ArrayList<Integer>, ArrayList<Integer>> valor = new HashMap<>();
  public ArrayList<Integer> clave = new ArrayList<>();
  public int numero;
  

    public ArrayList<Integer> generadorNumero()  {    
   
    int digitoAleatorio;
       for (int i = 0; i < 4;) {
       digitoAleatorio = (int) (Math.random()*10);
      while(!(numAleatorio.contains(digitoAleatorio))){
                numAleatorio.add(digitoAleatorio);
                i++;
}}
        return numAleatorio;
    }

    public ArrayList<Integer> convertirArray(int n) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int digito = n % 10;
            n = n / 10;
            a.add(0, digito);
        }
        return a;
    }
    public void compararAnterior(ArrayList<Integer> siguiente) {
      
        int bien = 0;
        int regular = 0;

        do {
      
            do {
                numero = nuevoNumero(numero);
                numSiguiente = convertirArray(numero);

                repetidos = duplicado(numSiguiente);

            } while (repetidos == true);
            for (ArrayList<Integer> key : valor.keySet()) {
                bien = 0;
                regular = 0;
             
                clave = key;
                for (int i = 0; i < numSiguiente.size(); i++) {
                    if (key.contains(numSiguiente.get(i))) {
                        if (key.get(i) == numSiguiente.get(i)) {
                            bien = bien + 1;
                        } else {
                            regular = regular + 1;
                        }
                    }
                }

                if ((valor.get(clave)).get(0) != bien || (valor.get(clave)).get(1) != regular) {
                    break;
                }
            }
          
        } while ((valor.get(clave)).get(0) != bien || (valor.get(clave)).get(1) != regular);

    
        jugar(numSiguiente);

    }

    
    public boolean duplicado(ArrayList<Integer> siguiente) {
        repetidos = false;
        for (int i = 0; i < siguiente.size(); i++) {
            for (int j = 0; j < siguiente.size(); j++) {
                if (i != j) {
                    if (siguiente.get(i) == siguiente.get(j)) {
                        repetidos = true;
                    }
                }
            }
        }
        return repetidos;
    }


    public void jugar(ArrayList<Integer> numAleat) {
        
        String respuesta;
        ArrayList<Integer> resp = new ArrayList<>();
        intentos++;
        int numIngBien = 0;
        int numIngRegular = 0;

        numero = convertirToInt(numAleat);
        numeroSrt = convertToStr(numAleat);
        
        System.out.println("El numero es "+ numeroSrt);

        System.out.println("¿Cuántos dígitos están en su ubicación?");
        
        try {
            respuesta = scanner.nextLine();
            numIngBien = Integer.parseInt(respuesta);
        } catch (NumberFormatException nfe) {
            System.out.println("Solamente se permiten valores numericos");
            jugar(numAleat);
        }
        System.out.println("Indicar los digitos que no estan en su posición");
        try {
            respuesta = scanner.nextLine();
            numIngRegular = Integer.parseInt(respuesta);
        } catch (NumberFormatException nfe) {
            System.out.println("Solamente se permiten valores numericos");
            jugar(numAleat);
        }
        if(numIngBien+numIngRegular<5 && numIngBien+numIngRegular>-1)
        {
       
        resp.add(numIngBien);
        resp.add(numIngRegular);

        valor.put(numAleat, resp);
        //System.out.println(valor);

        if (numIngBien == 4) {
            System.out.println("Adivine el numero en "+intentos+" intentos");
            System.exit(0);
        }

        //Verificar respuestas anteriores
        compararAnterior(numSiguiente);

    }else{System.out.println("No permitido");
        jugar(numAleat);}
    
    }


public void jugarPC(){
  jugar(generadorNumero());
    
 
}


   public int convertirToInt(ArrayList<Integer> numAleatorio) {
        
        String numeroString = "";
        
        for (int i = 0; i < numAleatorio.size(); i++) {
            numeroString = numeroString + String.valueOf(numAleatorio.get(i));
        }
       
        int numeroInt = Integer.parseInt(numeroString);

        return numeroInt;
    }

    public String convertToStr(ArrayList<Integer> numAleatorio) {
        String numero = "";
        for (int i = 0; i < numAleatorio.size(); i++) {
            numero = numero + String.valueOf(numAleatorio.get(i));
        }
        return numero;
    }

  
    public int nuevoNumero(int num) {
        num = num + 1;
        return num;
    }


}
        
