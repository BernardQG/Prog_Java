
package empleadojava;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class mainEmpleado {
     public static void main(String args[]){
          String salida;
          salida = "Emmpleados antes de crear la instancia"+ Empleado.obCuenta();
          Empleado e1=new Empleado("Juan","Perez");
          Empleado e2=new Empleado("Maria","Jimenez");
          
          salida +="\n\n Empleado despues de crear la instancia"+Empleado.obCuenta();
          salida +="\n"+ e1.obEm()+"\n"+e2.obEm();
          e1=null;
          e2=null;
          System.gc();
          JOptionPane.showMessageDialog(null, salida,"Miembro estaticos y recolector de basura", JOptionPane.INFORMATION_MESSAGE);
          System.exit(0);
          
     }
    
}
