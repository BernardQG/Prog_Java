/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeerror;
import java.util.Scanner;
import java.lang.*;
import javax.swing.JOptionPane;
public class MensajeError {
    public static void main(String[] args) {
        int s,i;
        boolean bol=true, bol2=true;
        System.out.println("\tSumar a + b");
        System.out.println("Entrada de datos: ");
        System.out.print("a = ");
        Scanner entradaE = new Scanner(System.in);
        String a = entradaE.nextLine();
        System.out.print("b = ");
        String b = entradaE.nextLine();       
        for(i = 0; i<a.length();i++){ if(Character.isDigit(a.charAt(i))==false){ bol=false; } }
        for(i = 0; i<b.length();i++){ if(Character.isDigit(b.charAt(i))==false){ bol2=false; } }
        String Salida = "No carnal alguno de los numeros es o tiene un caracter";
        Salida+="\nHay que correrlo de nuevo y ahora no te equivoques.";        
        if(bol==true && bol2==true){
            s = Integer.parseInt(a) + Integer.parseInt(b);       
            System.out.println("Salida de dato: " + s); 
        }
        else{
         JOptionPane.showMessageDialog(null,Salida,"Nel joven", JOptionPane.ERROR_MESSAGE); System.exit(0); }               
    }    
}
