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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author WQuintino
 */
public class Grf  extends JFrame implements ActionListener, MouseListener{
    private JButton Blinea = new JButton("/");
    private JButton Bcircu = new JButton("O");
    private JButton Brecta = new JButton("[]");
    private JButton Babrir = new JButton("Abrir");
    private JButton Bretro = new JButton("Retroceder");
    private JButton Bguard = new JButton("Guardar");
    private JButton Bborra = new JButton("Limpio");
   
    public JTextArea Text = new JTextArea();
    
    public CanvasP cVs= new CanvasP();    
    
            
    public Grf(){
        super("Pain ft. Bernardo");
        
        setLayout(null);
        
        
        this.add(cVs);
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
        Bborra.setBounds(510, 10, 80, 100);
        
        
        
        
     
        
        Blinea.addActionListener(this);
        Bcircu.addActionListener(this);
        Brecta.addActionListener(this);
        Bretro.addActionListener(this);
        Bguard.addActionListener(this);
        Babrir.addActionListener(this);
        Bborra.addActionListener(this);
      
        
        cVs.addMouseListener(this);
        
        
        add(Blinea);
        add(Bcircu);
        add(Brecta);
        add(scroll);
        add(Babrir);
        add(Bretro);
        add(Bguard);
        add(Bborra); 
    }      
      

    @Override
    public void actionPerformed(ActionEvent ae) {
     
             
       
      if(ae.getSource()==Blinea){
      
       cVs.dC=1;
      }
      else if(ae.getSource()==Bcircu){
       cVs.dC=2;
      }
      else if(ae.getSource()==Brecta){
       cVs.dC=3;
      }
      else if(ae.getSource()==Bretro){
          
          if(!cVs.pPto.empty()){
              cVs.cont=cVs.pPto.peek().getCon();
              cVs.pPto.pop();
              cVs.Pi=null;
              cVs.Pf=null;
              
              repaint();
          }          
          impP();
          
      }
      else if(ae.getSource()==Bguard){
                
        try{
           
              
                JFileChooser file=new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
          file.setFileFilter(filter);
                file.showSaveDialog(this);
                File guarda =file.getSelectedFile();
                
 
                if(guarda !=null)
                {
                    
                  File  save=new File(guarda+".txt");
                  ObjectOutputStream o = new ObjectOutputStream(
                        new FileOutputStream(save));
                   int i=0;
                while(i<cVs.pPto.size()){
                   o.writeObject(cVs.pPto.get(i));
    
                   i++;
                }
               o.flush();
               o.close();
          JOptionPane.showMessageDialog(null,
                  "El archivo se a guardado Exitosamente",
                   "Información",JOptionPane.INFORMATION_MESSAGE);
               
                }
        }
                catch(IOException ex)
  {
   JOptionPane.showMessageDialog(null,
        "Su archivo no se ha guardado",
           "Advertencia",JOptionPane.WARNING_MESSAGE);
  }
 }
                             
            
        else if(ae.getSource()==Bborra){
            while(!cVs.pPto.empty()){  cVs.pPto.pop(); }
              cVs.Pi=null;
              cVs.Pf=null;
              repaint();
              impP();                           
              cVs.cont=1;
        }
      
      else if(ae.getSource()==Babrir){
          
          //falta actualizar el texto
          
          JFileChooser file=new JFileChooser();
          FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
          file.setFileFilter(filter);
   file.showOpenDialog(this);
   //abrimos el archivo seleccionado
   File f=file.getSelectedFile();
   if(f!=null){
          
      try {
          
          while(!cVs.pPto.empty()){  cVs.pPto.pop(); }
          repaint();
                if(f.exists()){
                
                 ObjectInputStream is  = new ObjectInputStream(
                        new FileInputStream(f));
                 Pto aux = (Pto)is.readObject();
                 while(aux!=null){
                     
                      if (aux instanceof Pto)
                          
                          cVs.pPto.push(aux);
                       
                         //System.out.println(aux.toString());  // Se escribe en pantalla el objeto
                      aux = (Pto)is.readObject();
                      
                      
                 }
                 
                  
                  is.close();
                 
                                       
              
              
              
                  
                
                 }
                              
                
            }catch (IOException ex) {
                //Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
              Logger.getLogger(Grf.class.getName()).log(Level.SEVERE, null, ex);
          }
               cVs.Pi=null;
               cVs.Pf=null;
               repaint();
               impP(); 
               cVs.cont=cVs.pPto.peek().getCon()+1;
      
      
      
        }
      }
      
      
    }

   
    
 
    
    public void impP(){
      
    String St="";
    int i=0;
    while(i<cVs.pPto.size()){     
        St+="  "+cVs.pPto.get(i).getCon();
        if(cVs.pPto.get(i).getTipo()==1){     St+="  Linea\n";      }
        else if(cVs.pPto.get(i).getTipo()==2){St+="  Circulo\n";    }
        else {                         St+="  Rectangulo\n";      }  
        i++;
    }
    Text.setText(St);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        impP();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

   
   
    
   
    
}
