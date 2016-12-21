package paint;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author WQuintino
 */
public class Grf  extends JFrame implements ActionListener, MouseListener, ListSelectionListener{
    private final JButton Blinea = new JButton("/");
    private final JButton Bcircu = new JButton("O");
    private final JButton Brecta = new JButton("[]");
    private final JButton Babrir = new JButton("Abrir");
    private final JButton Bretro = new JButton("Retroceder");
    private final JButton Bguard = new JButton("Guardar");
    private final JButton Bborra = new JButton("Limpio");
   
    public JTextArea Text = new JTextArea();   
    public JList Lj= new JList();
    public JScrollPane scroll = new JScrollPane (Lj);
    
    private Color colr = new Color(220,220,255);    
    public CanvasP cVs= new CanvasP();    
    private JLabel te = new JLabel("*Click para eliminar una figura");
    
            
    public Grf(){
        super("Pain by Bernardo Quintino");
        setLayout(null);
        Blinea.setBackground(Color.LIGHT_GRAY);
        Brecta.setBackground(colr);
        Bcircu.setBackground(colr);
        
        
        Lj.setBackground(Color.GRAY);
        Lj.setForeground(Color.white);
        Bguard.setEnabled(false);
        
        
        
       
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
       
             
        Blinea.setBounds(10, 10, 50, 30);
        Bcircu.setBounds(70, 10, 50, 30);
        Brecta.setBounds(130, 10, 50, 30);
        te.setBounds(200, 10, 200, 15);
        te.setForeground(Color.WHITE);
        scroll.setBounds(200, 30, 190, 80);
        
        //Lj.setBounds(200, 10, 180, 100);
        Babrir.setBounds(400, 10, 100, 30);
        Bretro.setBounds(400, 45, 100, 30);
        Bguard.setBounds(400, 80, 100, 30);
        Bborra.setBounds(510, 10, 80, 100);
        Bborra.setRequestFocusEnabled(true);

      
        Blinea.addActionListener(this);
        Bcircu.addActionListener(this);
        Brecta.addActionListener(this);
        Bretro.addActionListener(this);
        Bguard.addActionListener(this);
        Babrir.addActionListener(this);
        Bborra.addActionListener(this);
        
        
        Lj.addListSelectionListener(this);
        Lj.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION );       
        cVs.addMouseListener(this);
        
  
        add(cVs);
        add(Blinea);
        add(Bcircu);
        add(Brecta);
        add(te);
        add(scroll);
        add(Babrir);
        add(Bretro);
        add(Bguard);
        add(Bborra); 
        
    }      
      

    @Override
    public void actionPerformed(ActionEvent ae) {         
      if(ae.getSource()==Blinea){        cVs.dC=1;     
      
      Blinea.setBackground(Color.LIGHT_GRAY);
      Bcircu.setBackground(colr);
      Brecta.setBackground(colr);
      
      }
      else if(ae.getSource()==Bcircu){   cVs.dC=2; 
      Blinea.setBackground(colr);
      Bcircu.setBackground(Color.LIGHT_GRAY);
      Brecta.setBackground(colr); }
      else if(ae.getSource()==Brecta){   cVs.dC=3;      
      Blinea.setBackground(colr);
      Bcircu.setBackground(colr);
      Brecta.setBackground(Color.LIGHT_GRAY);
      }
      else if(ae.getSource()==Bretro){          
          int u=0;
          if(!cVs.pPto.isEmpty()){
              u=cVs.pPto.size()-1;
              cVs.cont=cVs.pPto.get(u).getCon();
              cVs.pPto.remove(u);
              cVs.Pi=null;
              cVs.Pf=null;
              
              repaint();
          }          
          impP();
           if(cVs.pPto.isEmpty()){ 
              Bguard.setEnabled(false);
              }
          
      }
      else if(ae.getSource()==Bguard){
                
        try{             
                JFileChooser file=new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
                file.setFileFilter(filter);
                int grd=file.showSaveDialog(this);
                File guarda =file.getSelectedFile();
                
                if(guarda !=null && grd ==file.APPROVE_OPTION)
                {
                    
                  File  save=new File(guarda+".txt");
                  ObjectOutputStream o = new ObjectOutputStream(
                        new FileOutputStream(save));
                   int i=0;
                while(i<cVs.pPto.size()){
                   o.writeObject(cVs.pPto.get(i));
    
                   i++;
                }
                o.flush();      o.close();
                JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente",
                   "Información",JOptionPane.INFORMATION_MESSAGE);
               
                }
            }
                catch(IOException ex)
                {
                    JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
 }
                            
        else if(ae.getSource()==Bborra){
           
             cVs.pPto.clear();
              cVs.Pi=null;  cVs.Pf=null;
              if(cVs.pPto.isEmpty()){ 
              Bguard.setEnabled(false);
              }
              repaint();
              impP();                           
              cVs.cont=1;
        }
      
      else if(ae.getSource()==Babrir){
          
          JFileChooser file=new JFileChooser();
          FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
          file.setFileFilter(filter);
          
   int arbr = file.showOpenDialog(this);
   
   //abrimos el archivo seleccionado
   File f=file.getSelectedFile();
     
   if(f!=null && arbr==JFileChooser.APPROVE_OPTION){
          
      try {
          
           cVs.pPto.clear();
          repaint();
                if(f.exists()){
                
                 ObjectInputStream is  = new ObjectInputStream(
                        new FileInputStream(f));
                 Pto aux = (Pto)is.readObject();
                 while(aux!=null){
                     
                      if (aux instanceof Pto)
                          cVs.pPto.add(aux);
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
               int u=cVs.pPto.size()-1;
               cVs.cont=cVs.pPto.get(u).getCon()+1;
            }
      }
      
      
    }
    
    public void impP(){
     
    
    DefaultListModel modelo = new DefaultListModel();
    
    int i=0;  
    while(i<cVs.pPto.size()){            
        
        switch (cVs.pPto.get(i).getTipo()) {
            case 1:    modelo.addElement("  "+cVs.pPto.get(i).getCon()+"  Linea\n");     break;
            case 2:    modelo.addElement("  "+cVs.pPto.get(i).getCon()+"  Circulo\n");   break;
            default:   modelo.addElement("  "+cVs.pPto.get(i).getCon()+"  Rectangulo\n"); break;
        }
        i++;
    }
     Lj.setModel(modelo);
    }

    @Override
    public void mouseClicked(MouseEvent me) {  }
    @Override
    public void mousePressed(MouseEvent me) {  }
    @Override
    public void mouseReleased(MouseEvent me) {  impP(); 
     Bguard.setEnabled(true);
    scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());  
    
    
    }
    @Override
    public void mouseEntered(MouseEvent me) {  }
    @Override
    public void mouseExited(MouseEvent me) {  }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       
          if (e.getSource() == Lj && !e.getValueIsAdjusting() ) {
              Lj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
              int indice =  Lj.getSelectedIndex();
              
                       
              
              
               if (indice>=0) {
                   
                   cVs.pPto.remove(indice);
                    
               }
               
              
               impP();
               
               
               
                cVs.Pi=null;
                   cVs.Pf=null;
                       
          
              if(cVs.pPto.isEmpty()){
                   cVs.cont=1;
                  
                   
              }
              cVs.repaint();
            
        }         
        
    }

    
}
