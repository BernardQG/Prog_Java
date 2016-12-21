/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatch;

/**
 *
 * @author WQuintino
 */
public class TryCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i=0;
        try{ 
            System.out.println("\tSuma de dos numeros\n");
            i = 5 +(int)5.4; }        
        catch(Exception e){
        i=4+4;
        
        }
        finally{
               System.out.println("Suma: "+ i);
        }
    }
    
}
