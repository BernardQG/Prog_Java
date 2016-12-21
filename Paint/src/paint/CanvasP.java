package paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class CanvasP extends javax.swing.JPanel implements MouseListener{
    private Point pp;
    public CanvasP(){
          this.setBackground(Color.BLACK);
          this.setBounds(100,100, 200, 200);
          this.addMouseListener(this);
          
         
    }
     @Override
    public void paint(Graphics g) {
        super.paint(g);
       
        
       
             g.setColor(Color.red);
       
                g.drawOval(66,66, 50, 50);
                
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.print("hola");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
