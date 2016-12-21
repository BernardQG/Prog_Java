package empleadosabstact;

/**
 *
 * @author WQuintino
 */
public class EmpleadoBaseMasComicion extends EmpleadoXComicion{
    private double SalarioBase;
    
    public EmpleadoBaseMasComicion(String Nombre,String NSeguro, double Venta, double Tarifa, double SalarioBase){
           super(Nombre, NSeguro, Venta, Tarifa);
           this.SalarioBase=SalarioBase;
    }
    public double Ingresos(){   return SalarioBase + super.Ingresos();    }
    
    public String toString(){ 
        return Nombre + " $"+SalarioBase;
    }  
    
}
