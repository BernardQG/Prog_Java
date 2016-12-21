/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.*;

public class CanvasP extends javax.swing.JPanel{
    public CanvasP(){
          this.setBackground(Color.BLACK);
          this.setBounds(170, 170, 200, 200);
         
    }
     @Override
    public void paint(Graphics g) {
        super.paint(g);
       
        
       
             g.setColor(Color.red);
       
                g.drawOval(0, 0, 50, 50);
                
        
        
    }
    
}
