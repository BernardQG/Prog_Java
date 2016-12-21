package batosjava;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class BatosJava {

    public static void main(String[] args) {
        Persona P1, P2, P3;
        P1 = new Persona("Bernardo", 20, 63.2); 
        P2 = new Persona(); 
        P3 = new Persona(); 
      
        
        String Salida = "\tPrograma de OOP >> Personas\n";
        Salida +="Persona 1: "+P1.toBato()+" \n";
        Salida +="Persona 2: "+P2.toBato()+" \n";
        Salida +="Persona 3: "+P3.toBato()+" \n";
        Salida +="\n\tEstableciendo mas personas! (set)\n";
        P2.setPersona("Jovanni", 21, 77.6);
        P3.setPersona("Erick", 20, 70.87);
        Salida += "\nPersonas Actualizada:\n";
        Salida +="Persona 1: "+P1.toBato()+" \n";
        Salida +="Persona 2: "+P2.toBato()+" \n";
        Salida +="Persona 3: "+P3.toBato()+" \n";
        JOptionPane.showMessageDialog(null,Salida, "Personas Chidas", JOptionPane.ERROR_MESSAGE);
        System.exit(0);      
        
        
    }
    
}
