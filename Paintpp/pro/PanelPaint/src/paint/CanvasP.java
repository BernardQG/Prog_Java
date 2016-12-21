package paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Stack;

public class CanvasP extends javax.swing.JPanel implements MouseListener, MouseMotionListener{
   
    //aqui nacieron las variables
    public  ArrayList <Pto> pPto = new ArrayList<Pto>();//pila que contiene figuras como elementos
    public Point Pi = null , Pf= null;//para manejar las cordenadas
    public int dC=1, cont=1;
  
    
    private Color colr = new Color(149,16,182);
    private Color colr3 = new Color(16,182,77);
    private Color colr2 = new Color(42,190,255);
    
    
    //contrusctor, solo se establese como se va a ver y llama a los escuchadores.
    public CanvasP(){
        
          this.setBackground(Color.white);
          this.setBounds(0,130, 1900, 900);

          this.addMouseListener(this);
          this.addMouseMotionListener(this);
          
         
    }
   
    @Override
    public void paint(Graphics g) {//dibujaer en el panel, que es como un canvas       
         super.paint(g);         
         
         //g.setColor(this.colr);
         //Para poder consegir un mayor grozor en las lines
         Graphics2D g2 = (Graphics2D) g;          
         g2.setStroke(new BasicStroke(2));
         
        //aqui se dibujan en primera instancia las imagenes segun el botos que fue oprimido         
        if(Pi!=null){
            switch (dC) {
                case 1: //dibujar lineas
                    g.setColor(colr);                 
                    g.drawLine((int)Pi.getX(), (int)Pi.getY(), (int)Pf.getX(), (int)Pf.getY());
                    break;
                case 2:
                    //dibujar circulos
                    g.setColor(colr2); 
                    int r;
                    r=(int)Math.sqrt(Math.pow(Pi.getX()-Pf.getX(), 2) + Math.pow(Pi.getY()-Pf.getY(), 2));
                    g.drawOval((int)Pi.getX()-r, (int)Pi.getY()-r, 2*r, 2*r);
                    
                    break;
                default: //fibujar rectangulos
                    g.setColor(colr3);
                    if(Pi.getX()<Pf.getX()){
                        if(Pi.getY()<Pf.getY()){
                            g.drawRoundRect((int)Pi.getX(), (int)Pi.getY(),
                                    Math.abs((int)Pf.getX()-(int)Pi.getX()),
                                    Math.abs((int)Pf.getY()-(int)Pi.getY()), 0, 0);
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
                    g.setColor(colr);
                    
                    g.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
                    break;
                case 2:
                    //dibujar circulos
                    int r;
                    g.setColor(colr2);
                    r=(int)Math.sqrt(Math.pow(a.getX()-b.getX(), 2)
                            + Math.pow(a.getY()-b.getY(), 2));
                    g.drawOval((int)a.getX()-r, (int)a.getY()-r, 2*r, 2*r);
                    break;
                default:
                    //fibujar rectangulos
                    g.setColor(colr3);
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
    public void mouseEntered(MouseEvent me) {  }
    @Override
    public void mouseExited(MouseEvent me) {  }
    @Override
    public void mouseDragged(MouseEvent me) {
       Pf = new Point(me.getX(), me.getY());
             repaint();            
    }

    @Override
    public void mouseMoved(MouseEvent me) {  }




    

    
    
}
