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
public abstract class Empleado {
    public String Nombre;
    public String NSeguro;
    
    public Empleado(String Nombre,String NSeguro){
        this.Nombre = Nombre;
        this.NSeguro = NSeguro;
    }
    abstract public double Ingresos();
    public String getNSeguro(){   return NSeguro;   }
    abstract public String toString();   
    
}
