/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosabstact;

/**
 *
 * @author WQuintino
 */
public class EmpleadoXHora extends Empleado{
    private int SalarioxHora;
    public EmpleadoXHora(String Nombre,String NSeguro, double SalarioxHora, int HoraT){
           super(Nombre, NSeguro);
           if(HoraT>40){
               this.SalarioxHora=(int)SalarioxHora + (int)(SalarioxHora*1.5*(HoraT-40));
           }
           else{
                this.SalarioxHora=(int)SalarioxHora;
           }
    }
    public double Ingresos(){   return SalarioxHora;    }
    
    public String toString(){ 
        return Nombre + " $"+SalarioxHora;
    }  
    
}
