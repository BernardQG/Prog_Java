/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author WQuintino
 */
public class Grf  extends JFrame implements ActionListener , MouseListener, MouseMotionListener{
    private JButton Blinea = new JButton("L");
    private JButton Bcircu = new JButton("C");
    private JButton Brecta = new JButton("R");
    private JButton Babrir = new JButton("Abrir");
    private JButton Bretro = new JButton("Retroceder");
    private JButton Bguard = new JButton("Guardar");
   
    private JTextArea Text = new JTextArea();
    
    private  String St= "", st2;
    private  Stack <Pto> pPto = new Stack<Pto>();    
    
    
    private JPanel P1 = new JPanel();
    
    private Point Pi = null , Pf= null;
    private int dC=1, cont=1;
            
    public Grf(){
        super("Pain ft. Bernardo");
        
        setLayout(null);
        
        //CanvasP cVs= new CanvasP();
        //this.add(cVs);
        Blinea.setBounds(10, 10, 50, 30);
        Bcircu.setBounds(70, 10, 50, 30);
        Brecta.setBounds(130, 10, 50, 30);
        
        Text.setBackground(Color.BLACK);
        Text.setForeground(Color.yellow); Text.setCaretColor(Color.yellow);
        Text.setEditable ( false );
        JScrollPane scroll = new JScrollPane ( Text  );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBounds(200, 10, 180, 100);
        
        Babrir.setBounds(400, 10, 100, 30);
        Bretro.setBounds(400, 45, 100, 30);
        Bguard.setBounds(400, 80, 100, 30);
        
        Blinea.addActionListener(this);
        Bcircu.addActionListener(this);
        Brecta.addActionListener(this);
        Bretro.addActionListener(this);
        Bguard.addActionListener(this);
        Babrir.addActionListener(this);
                
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        
        
        
        
        P1.setBounds(0, 130, 1500, 900);
        P1.setBackground(Color.white);
        add(P1);
        add(Blinea);
        add(Bcircu);
        add(Brecta);
        add(scroll);
        add(Babrir);
        add(Bretro);
        add(Bguard);
                    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //impP();
      if(ae.getSource()==Blinea){
      
       dC=1;
      }
      else if(ae.getSource()==Bcircu){
       dC=2;
      }
      else if(ae.getSource()==Brecta){
       dC=3;
      }
      else if(ae.getSource()==Bretro){
          if(cont>1)
              cont--;
          if(!pPto.empty()){
              if(cont<10){
              st2 = St.substring(0,St.length()-17);
              }
              else if(cont<100){
              st2 = St.substring(0,St.length()-18);
              }
              else{
              st2 = St.substring(0,St.length()-19);
              }
              St=st2;
              Text.setText(St);
              pPto.pop();
              Pi=null;
              Pf=null;
              
              repaint();
          }
          
      }
      else if(ae.getSource()==Bguard){
          Pto p3 = new Pto(1,2,3,4,5);
                System.out.println(p3.toString());
         File f = new File("Obje.txt");
        
            try {
                if(!f.exists()){
                f.createNewFile();
                }
                ObjectOutputStream o = new ObjectOutputStream(
                        new FileOutputStream(f));
                
                
                
                //o.writeObject(p3);
                
                //o.writeObject(dog);
                int i=0;
                while(i<pPto.size()){
                    
                    o.writeObject(pPto.get(i));
                    i++;
                }
                o.flush();
                o.close();
                             
            }catch (IOException ex) {
                //Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
            }
        
      }
      else if(ae.getSource()==Babrir){
           File f = new File("Obje.txt");
      try {
                if(f.exists()){
                
                 ObjectInputStream is  = new ObjectInputStream(
                        new FileInputStream(f));
                 Pto aux = (Pto)is.readObject();
                 while(aux!=null){
                      if (aux instanceof Pto)
                         System.out.println(aux.toString());  // Se escribe en pantalla el objeto
                      aux = (Pto)is.readObject();
                 }
                 
                 
                  is.close();
                  
                
                 }
                              
                
            }catch (IOException ex) {
                //Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
              Logger.getLogger(Grf.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     
    }

    
     @Override
    public void paint(Graphics g) {
        super.paint(g);      
        
        if(Pi!=null){
            if(dC==1){//dibujar lineas
             g.setColor(Color.red);
             //St+="\nLinea";
             g.drawLine((int)Pi.getX(), (int)Pi.getY(), (int)Pf.getX(), (int)Pf.getY());
             
            }
            else if(dC==2){//dibujar circulos
                int r;
                g.setColor(Color.blue);
                r=(int)Math.sqrt(Math.pow(Pi.getX()-Pf.getX(), 2) + Math.pow(Pi.getY()-Pf.getY(), 2));
                g.drawOval((int)Pi.getX()-r, (int)Pi.getY()-r, 2*r, 2*r);
             //St+="\nCirculo";
                
            }
            else {//fibujar rectangulos
                g.setColor(Color.green);
               if(Pi.getX()<Pf.getX()){
                   if(Pi.getY()<Pf.getY()){
                        g.drawRoundRect((int)Pi.getX(), (int)Pi.getY(),
                        Math.abs((int)Pf.getX()-(int)Pi.getX()),
                        Math.abs((int)Pf.getY()-(int)Pi.getY()), 6, 6);
                   }
                   else{ 
                       //System.out.println(Pf.getX()+"  "+Pf.getY());
                       
                       g.drawRoundRect((int)Pi.getX(), (int)Pf.getY(),                        
                        Math.abs((int)Pi.getX()-(int)Pf.getX()),
                        Math.abs((int)Pi.getY()-(int)Pf.getY()), 6, 6);
                   }
               }
               else{
                   if(Pi.getY()>Pf.getY()){
                        g.drawRoundRect((int)Pf.getX(), (int)Pf.getY(),
                        (int)Pi.getX()-(int)Pf.getX(),
                        (int)Pi.getY()-(int)Pf.getY(), 6, 6);
                   }
                   else{
                        g.drawRoundRect((int)Pf.getX(), (int)Pi.getY(),
                       (int)Pi.getX()-(int)Pf.getX(),
                       (int)Pf.getY()-(int)Pi.getY(), 6, 6);
                   }
               }
             //St+="\nRectangulo";   
            }
        }
        int i=0;
        Point a = null , b= null;
        while(i<pPto.size()){
            a = new Point((int)pPto.get(i).getX(), (int)pPto.get(i).getY());
            b = new Point((int)pPto.get(i).getX2(), (int)pPto.get(i).getY2());
            
            
             if(pPto.get(i).getTipo()==1){//dibujar lineas
             g.setColor(Color.red);
             //St+="\nLinea";
             g.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
             
            }
            else if(pPto.get(i).getTipo()==2){//dibujar circulos
                int r;
                g.setColor(Color.blue);
                r=(int)Math.sqrt(Math.pow(a.getX()-b.getX(), 2) 
                        + Math.pow(a.getY()-b.getY(), 2));
                g.drawOval((int)a.getX()-r, (int)a.getY()-r, 2*r, 2*r);
             //St+="\nCirculo";
                
            }
              else {//fibujar rectangulos
                g.setColor(Color.green);
               if(a.getX()<b.getX()){  if(a.getY()<b.getY()){
                        g.drawRoundRect((int)a.getX(), (int)a.getY(),
                        Math.abs((int)b.getX()-(int)a.getX()),
                        Math.abs((int)b.getY()-(int)a.getY()), 6, 6);
                   }
                   else{ 
                       //System.out.println(Pf.getX()+"  "+Pf.getY());
                       
                       g.drawRoundRect((int)a.getX(), (int)b.getY(),                        
                        Math.abs((int)a.getX()-(int)b.getX()),
                        Math.abs((int)a.getY()-(int)b.getY()), 6, 6);
                   }
               }
               else{
                   if(a.getY()>b.getY()){
                        g.drawRoundRect((int)b.getX(), (int)b.getY(),
                        (int)a.getX()-(int)b.getX(),
                        (int)a.getY()-(int)b.getY(), 6, 6);
                   }
                   else{
                        g.drawRoundRect((int)b.getX(), (int)a.getY(),
                       (int)a.getX()-(int)b.getX(),
                       (int)b.getY()-(int)a.getY(), 6, 6);
                   }
               }
             //St+="\nRectangulo";   
            }
            i++;
            
        }
        
        
        
        
    }
    
    
     
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
        if(me.getY()>160){
             Pi = new Point(me.getX(), me.getY());
             
        }
        else{
            
             Pi = new Point(me.getX(),160);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getY()>160){
             Pf = new Point(me.getX(), me.getY());
             
             if(dC==1){
             St+="  "+cont+"   Linea     \n";
              
            }
            else if(dC==2){//dibujar circulos
               
             St+="  "+cont+"   Circulo   \n";
                
            }
            else {
             St+="  "+cont+"   Rectangulo\n";   
            }
             Text.setText(this.St);
             pPto.add(new Pto(dC, Pi.getX(), Pi.getY(),Pf.getX(), Pf.getY()));
             //impP();
             cont++;
             repaint();            
        }        
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
      if(me.getY()>160){
             Pf = new Point(me.getX(), me.getY());
             repaint();            
        }     
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void impP(){
      Iterator<Pto> it1 = pPto.iterator();
    System.out.println("\n\t\t    ===  PILA  ===\n");
    while(it1.hasNext()){  System.out.println(it1.next().toString());  }
    }
    
   
    
}
