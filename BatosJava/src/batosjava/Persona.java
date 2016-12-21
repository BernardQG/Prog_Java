/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batosjava;

/**
 *
 * @author Lenovo
 */
public class Persona {
    protected String Nombre;
    protected int Edad;
    protected double Peso;
    
    public Persona(){
        setPersona("Null", 0,0.0);    
    }
    public Persona(String Name, int Age, double Weigth)
    {
        setPersona(Name, Age, Weigth);
    }
    public void setPersona(String Name, int Age, double Weigth)
    {
     Nombre = Name;
     Edad = Age;
     Peso = Weigth;
    }
    public String getName(){ return Nombre; }
    public int getAge(){ return Edad; }
    public double getWeigth(){ return Peso; }   
    public String toBato(){ return "\n             Name: "+ Nombre+" Edad: "+ Edad+" Peso: "+Peso; } 
    
    
}
