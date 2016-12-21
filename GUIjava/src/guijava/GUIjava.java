/*Progra utilizan  una GUI basica para calcular el area de un cuadrado*/
package guijava;
import java.awt.Color;
import java.awt.Container;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.*;
import javax.swing.event.*;
public class GUIjava extends JFrame  implements ChangeListener{
    public JSlider CLor = new JSlider(JSlider.HORIZONTAL,0,4,1);
    public GUIjava(){
        setLayout(null);
        /*
        JTextArea areaSalida = new JTextArea();
        areaSalida.setBounds(10, 10, 100, 50);
        add(areaSalida);*/
        //JSlider CLor = new JSlider(JSlider.HORIZONTAL,0,4,1);
        
        CLor.setBounds(10, 10, 100, 50);
        ChangeListener cl = null;
        CLor.addChangeListener(this);
        
        add(CLor);
        
    }
    
    /*public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    if (!source.getValueIsAdjusting()) {
        int fps = (int)source.getValue();
        if (fps == 0) {
            if (!frozen) stopAnimation();
        } else {
            delay = 1000 / fps;
            timer.setDelay(delay);
            timer.setInitialDelay(delay * 10);
            if (frozen) startAnimation();
        }
    }*/

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
    
}
