package herenciaenjava;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class MainJava {
    public static void main(String args[]){
        Punto Punto2, Punto1;
        Circulo circulo1, circulo2;
        Punto1 = new Punto (30, 50);
        
        circulo1= new Circulo(2.7,120,89);
        
        String output = "Punto punto1: "+ Punto1.toString()+ "\nCirculo circulo1:  "+ circulo1.toString();
        Punto2 = circulo1;
        output += "\n\nCirculo circulo1 (referencia via punto2): "+Punto2.toString();
        circulo2 = (Circulo)Punto2;
        output += "\n\nCirculo circulo1 (via circulo2): "+circulo2.toString();
        
        DecimalFormat precision2 = new java.text.DecimalFormat("0.00");
        output += "\n Area de c (cia circulo2): "+ precision2.format(circulo2.area());
        
        output +="\npunto 1: ("+ Punto1.getX() +", "+ Punto1.getY()+")\n";   
        Punto1.setPoint(33,77);
        output +="Cambia punto 1 por ("+ Punto1.getX() +", "+ Punto1.getY()+")\n"; 
        JOptionPane.showMessageDialog(null, output, "Demostracion", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);       
        
    }
    
    
}
