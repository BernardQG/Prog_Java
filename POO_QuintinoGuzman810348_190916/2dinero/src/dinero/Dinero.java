/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinero;

/**
 *
 * @author WQuintino
 */
public class Dinero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cuentaAhorro ahorrador1, ahorrador2;
        ahorrador1 = new cuentaAhorro(2000);
        ahorrador2 = new cuentaAhorro(3000, 4);
        ahorrador1.modificarTIA(4);
        //Saldos originales
        System.out.println("Saldos sin modificar: ");
        System.out.println("Ahorrador 1: " + ahorrador1.getSaldo());
        System.out.println("Ahorrador 2: " + ahorrador2.getSaldo());
        ahorrador1.TIM();
        ahorrador2.TIM();      
        //Calculando el cambio del interez
        System.out.println("Con taza de interez anual: 4%");
        System.out.println("Ahorrador 1: " + ahorrador1.getSaldo());
        System.out.println("Ahorrador 2: " + ahorrador2.getSaldo());
        //Calculando el cambio del interez
      
        System.out.println("Con taza de interez anual: 5%");
        ahorrador1.modificarTIA(5);
        ahorrador1.TIM();     
        System.out.println("Ahorrador 1: " + ahorrador1.getSaldo());
        ahorrador2.modificarTIA(5);
        ahorrador2.TIM();
        System.out.println("Ahorrador 2: " + ahorrador2.getSaldo());
        
    }
    
}
