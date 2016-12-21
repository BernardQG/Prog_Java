/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guijava;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author WQuintino
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GUIjava b=new GUIjava();
        
         b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setSize(500, 500);
        b.setVisible(true);
    }
    
}
