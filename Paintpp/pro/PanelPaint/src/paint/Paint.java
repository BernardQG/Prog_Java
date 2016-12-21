package paint;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author WQuintino
 */
public class Paint {
    public static void main(String[] args) {
        Grf buk = new Grf();
        Color col = new Color(100,150,255);
        buk.getContentPane().setBackground(col);
        
        buk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buk.setSize(615,600);             
        buk.setLocationRelativeTo(null);
        buk.setVisible(true);        
        
    }
    
}
