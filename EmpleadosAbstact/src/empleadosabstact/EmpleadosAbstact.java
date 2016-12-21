
package empleadosabstact;
import static java.lang.System.out;
/**
 *
 * @author WQuintino
 */
public class EmpleadosAbstact {
    public static void main(String[] args) {
        // TODO code application logic here
        
        EmpleadoAsalariado E11 = new EmpleadoAsalariado("Bernardo Quintino","12F01",550.5);
        Empleado E12 = new EmpleadoAsalariado("Gen Itales","12F02",447.5);
        Empleado E3 = new EmpleadoXHora("Elvis co8","12F03",604.6,65);
        Empleado E4 = new EmpleadoXComicion("yuri ","87F05",60,40);
        System.out.println(E11.toString());        
        System.out.println(E12.toString());        
        System.out.println(E3.toString());        
        System.out.println(E4.toString()); 
        
        Empleado[] Emp = new Empleado[3];
        
        Emp[0] = new EmpleadoAsalariado("Rufino","12F06",237.5);
        Emp[1] = new EmpleadoXComicion("El toñito","87F3",40,40);
        Emp[2] = new EmpleadoXComicion("teacherT ","87F07",44,50);
        
        for(int i = 0; i<3;i++){
        out.println(Emp[i]);
        }
        
        
        
        
        
        
    }
    
}
