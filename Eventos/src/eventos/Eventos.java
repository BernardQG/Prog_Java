
package eventos;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author WQuintino
 */
public class Eventos extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    private JLabel lb1 = new JLabel("Nombre:");
    private JTextField tf1 = new JTextField("");
    private JButton jb1 = new JButton("GUARDAR");
    private JButton jb2 = new JButton("REGRESAR");
    
    private Point p1=null, p11=null;
    public Eventos() {
        setLayout(null);
        lb1.setBounds(0, 100, 100, 30);
        tf1.setBounds(100, 100, 100, 30);
        jb1.setBounds(100, 150, 100, 40);
        jb2.setBounds(250, 150, 100, 40);
        
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        add(lb1);
        add(tf1);
        add(jb1);
        add(jb2);
        
        setSize(500, 500);
        setVisible(true);
    }

    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        if(p1!=null){
            g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p11.getX(), (int)p11.getY());
        }
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList lista3 = new ArrayList();
        Vector v = new Vector();
        LinkedList l = new LinkedList();
        List l21 = new LinkedList();
        Collection l22 = new LinkedList();
        
        Queue c1 = new LinkedList();
        Queue c2 = new PriorityQueue();
        PriorityQueue pq = new PriorityQueue();
        
        c2.add(2);
        c2.add(5);
        c2.add(8);
        
        for (Object o : c2) {
            System.out.println(o);
        }
        
        if(true)
            System.exit(0);
        
        
        
        
        
        
        
        
        Eventos e = new Eventos();
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Perro dog = new Perro(new Dueno("Carlos"), "DOGY");
        File f = new File("Objet2.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
                ObjectOutputStream o = new ObjectOutputStream(
                        new FileOutputStream(f));
                o.writeObject(dog);
                o.flush();
                o.close();
                
                
                ObjectInputStream is  = new ObjectInputStream(
                        new FileInputStream(f));
                
                Perro obj = (Perro) is.readObject();
                System.out.println(obj.getDogName() + " " + obj.getDueno().getNombre());
                
                
            } catch (IOException ex) {
                //Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException ex) {
                    //Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jb1){
            System.out.println("Se presiono GUARDAR");
        }else if(ae.getSource()==jb2){
            System.out.println("Se presiono REG.");
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        p1 = new Point(e.getX(), e.getY());
        System.out.println(p1.getX() +" "+ p1.getY());
        tf1.setText(""+p1.getX() + " " + p1.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        p11 = new Point(e.getX(), e.getY());
        System.out.println("Se solto boton del raton:"+ p1.getX() +" "+ p1.getY());
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
        System.out.println(me.getX() +" "+ me.getY());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
         //To change body of generated methods, choose Tools | Templates.
    }
    
}

class Perro implements Serializable{
    private Dueno dueno;
    private String dogName;
    
    public Perro(Dueno dueno, String dogName) {
        this.dueno = dueno;
        this.dogName = dogName;
    }

    public Dueno getDueno() {
        return dueno;
    }
    
    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
    
}

class Dueno implements Serializable{
    private String nombre="Jose";
    
    public Dueno(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
