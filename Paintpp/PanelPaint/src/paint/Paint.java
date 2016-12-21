package paint;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
/**
 *
 * @author WQuintino
 */
public class Paint {
    public static void main(String[] args) {
        Grf buk = new Grf();
        
        buk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buk.setSize(615,600);      
        //buk.setResizable(false);
        //buk.setUndecorated(true);       
        buk.setLocationRelativeTo(null);
        buk.setVisible(true);
        
        
        
    }
    
}
