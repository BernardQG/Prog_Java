
package empleadosabstact;

public class EmpleadoAsalariado extends Empleado{
    private double SalarioSemanal;
    public EmpleadoAsalariado(String Nombre,String NSeguro, double SalarioSemanal){
           super(Nombre, NSeguro);
           this.SalarioSemanal=SalarioSemanal;
    }
    public double Ingresos(){   return SalarioSemanal;    }
    
    public String toString(){ 
        return Nombre + " $"+SalarioSemanal;
    }  
    
}
