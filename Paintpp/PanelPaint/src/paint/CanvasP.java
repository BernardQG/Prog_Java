package paint;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;
import javax.swing.*;
import org.w3c.dom.Node;

public class CanvasP extends javax.swing.JPanel implements MouseListener, MouseMotionListener{
   
   // public  String St= "", st2;
    public  Stack <Pto> pPto = new Stack<Pto>(); 
    
    
    
    public Point Pi = null , Pf= null;
    public int dC=1, cont=1;
    public CanvasP(){
          this.setBackground(Color.white);
          this.setBounds(0,130, 1900, 900);

          this.addMouseListener(this);
          this.addMouseMotionListener(this);
          
         
    }
    
    public void setdC(int c){ dC=c; }
    public int c;
   
    @Override
    public void paint(Graphics g) {
        super.paint(g);              
        if(Pi!=null){
            switch (dC) {
                case 1: //dibujar lineas
                    g.setColor(Color.yellow);                 
                    g.drawLine((int)Pi.getX(), (int)Pi.getY(), (int)Pf.getX(), (int)Pf.getY());
                    break;
                case 2:
                    //dibujar circulos
                    g.setColor(Color.CYAN); int r;
                    r=(int)Math.sqrt(Math.pow(Pi.getX()-Pf.getX(), 2) + Math.pow(Pi.getY()-Pf.getY(), 2));
                    g.drawOval((int)Pi.getX()-r, (int)Pi.getY()-r, 2*r, 2*r);
                    
                    break;
                default: //fibujar rectangulos
                    g.setColor(Color.green);
                    if(Pi.getX()<Pf.getX()){
                        if(Pi.getY()<Pf.getY()){
                            g.drawRoundRect((int)Pi.getX(), (int)Pi.getY(),
                                    Math.abs((int)Pf.getX()-(int)Pi.getX()),
                                    Math.abs((int)Pf.getY()-(int)Pi.getY()), 6, 6);
                        }
                        else{
                            g.drawRoundRect((int)Pi.getX(), (int)Pf.getY(),
                                    Math.abs((int)Pi.getX()-(int)Pf.getX()),
                                    Math.abs((int)Pi.getY()-(int)Pf.getY()), 0, 0);
                        }
                    }
                    else{
                        if(Pi.getY()>Pf.getY()){
                            g.drawRoundRect((int)Pf.getX(), (int)Pf.getY(),
                                    (int)Pi.getX()-(int)Pf.getX(),
                                    (int)Pi.getY()-(int)Pf.getY(), 0, 0);
                        }
                        else{
                            g.drawRoundRect((int)Pf.getX(), (int)Pi.getY(),
                                    (int)Pi.getX()-(int)Pf.getX(),
                                    (int)Pf.getY()-(int)Pi.getY(), 0, 0);
                        }
                    }
                    
                    break;
            }
        }
        int i=0;
        Point a = null , b= null;
        
        while(i<pPto.size()){
            a = new Point((int)pPto.get(i).getX(), (int)pPto.get(i).getY());
            b = new Point((int)pPto.get(i).getX2(), (int)pPto.get(i).getY2());
            
            
            switch (pPto.get(i).getTipo()) {
                case 1:
                    //dibujar lineas
                    g.setColor(Color.red);
                    //St+="\nLinea";
                    g.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
                    break;
                case 2:
                    //dibujar circulos
                    int r;
                    g.setColor(Color.BLUE);
                    r=(int)Math.sqrt(Math.pow(a.getX()-b.getX(), 2)
                            + Math.pow(a.getY()-b.getY(), 2));
                    g.drawOval((int)a.getX()-r, (int)a.getY()-r, 2*r, 2*r);
                    break;
                default:
                    //fibujar rectangulos
                    g.setColor(Color.green);
                    if(a.getX()<b.getX()){ 
                        if(a.getY()<b.getY()){
                                g.drawRoundRect((int)a.getX(), (int)a.getY(),
                                Math.abs((int)b.getX()-(int)a.getX()),
                                Math.abs((int)b.getY()-(int)a.getY()), 0, 0);
                        }
                        else{
                                g.drawRoundRect((int)a.getX(), (int)b.getY(),
                                Math.abs((int)a.getX()-(int)b.getX()),
                                Math.abs((int)a.getY()-(int)b.getY()), 0, 0);
                            }
                    }else{
                        if(a.getY()>b.getY()){
                            g.drawRoundRect((int)b.getX(), (int)b.getY(),
                                    (int)a.getX()-(int)b.getX(),
                                    (int)a.getY()-(int)b.getY(),0,0);
                        }
                        else{
                            g.drawRoundRect((int)b.getX(), (int)a.getY(),
                                    (int)a.getX()-(int)b.getX(),
                                    (int)b.getY()-(int)a.getY(), 0, 0);
                        }
                    }    break;
            }
            i++;
            
        }
                
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {}     
    @Override
    public void mousePressed(MouseEvent me) {       
       Pi = new Point(me.getX(), me.getY());          
    }
    
    
    @Override
    public void mouseReleased(MouseEvent me) {
          Pf = new Point(me.getX(), me.getY());           
          pPto.add(new Pto(dC,cont, Pi.getX(), Pi.getY(),Pf.getX(), Pf.getY()));
          cont++;
          repaint();           
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
       Pf = new Point(me.getX(), me.getY());
             repaint();            
           
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    

    
    
}
