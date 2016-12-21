/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui1;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.layout.Background;
import javax.swing.*;

/**
 *
 * @author WQuintino
 */
public class GUI1 extends JApplet{

    String str = "";
    
        public void init(){
        
         
        setSize(600,400);
        str += "Paint";
        JPanel p = new JPanel();
        
    
    }
    final int radius = 55;
   
    

    public void paint ( Graphics gr )
    { 
        JTextArea area = new JTextArea("Hello World");
        area.setSize(55, 15);
        JButton B1= new JButton("This is a button");
        B1.setSize(16, 15);
          this.add(area);
        this.add(B1);
    
       
        gr.setColor(Color.lightGray);
        gr.fillRect( 0, 0, 600, 110 );
         gr.setColor(Color.red);
        gr.drawString(str, 10, 25);
        
        gr.setColor( Color.BLACK );
        gr.drawOval( 222, 222, radius*2, radius*2 );
    }
    
    
}
