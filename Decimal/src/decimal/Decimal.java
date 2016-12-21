/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimal;

import java.util.Scanner;

/**
 *
 * @author WQuintino
 */
public class Decimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int u=0; double d=0.0;
        u=in.nextInt();
        d=in.nextDouble();
        
        System.out.print(u+"       "+d+"\n\n\n");
    }
    
}
