
package empleadosabstact;
/**
 *
 * @author WQuintino
 */
public class EmpleadoXComicion extends Empleado{
    private double Tarifa;
    private double Venta;
    
    public EmpleadoXComicion(String Nombre,String NSeguro, double Venta, double Tarifa){
           super(Nombre, NSeguro);
           this.Tarifa=Tarifa;
           this.Venta=Venta;           
    }
    public double Ingresos(){   return Tarifa*Venta;    }
    
    public String toString(){ 
        return Nombre + " $"+Tarifa*Venta;
    }  
    
}
