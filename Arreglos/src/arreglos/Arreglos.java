/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;
import java.util.Scanner; 

/**
 *
 * @author WQuintino
 */
public class Arreglos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
double n ; 

Scanner lector=new Scanner (new InputStreamReader(System.in)); 
System.out.println("ingrese un numero double:"); 
n= Float.parseFloat(lector.next()); 
System.out.println("El cubo de "+n+" es: " + cubo(n)); 
} 
public static double cubo (double x) { 
return x*x*x; 
} 
    }
    
}
