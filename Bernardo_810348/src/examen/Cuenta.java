/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

/**
 *
 * @author WQuintino
 */
public class Cuenta {
    protected int ID;
    protected String nom;
    protected String dir;
    protected String  tel;
    protected double Sl;
    
    public Cuenta(){
       setC(0,"","","",0.0);
    }
    public Cuenta(int i, String n, String d, String t, double s){
       setC(i,n,d,t,s);
    }
    public void setC(int i, String n, String d, String t, double s){
    ID=i; nom=n; dir=d; tel=t; 
    if(s<0) {
           System.out.println("USted a ingresado una magnitud negativa, pero ya a sido arreglado");
           Sl=-1*s;
       }
       else{
            Sl=s;
       }
    }
    public void depositar(double s){
       if(s<0) {
           System.out.println("USted a ingresado una magnitud negativa, pero ya a sido arreglado");
           Sl=Sl-s;
       }
       else{
            Sl=Sl+s;
       }
    }
    public void retiro(double r){
        if(Sl<r){ System.out.println("Error, el retiro no se a efecturado, su retiro es mayor que el saldo"); }   
        else{  if(r<0){Sl=Sl+r;}
               else{ Sl=Sl-r; }  
        }
    }
    public String toString(){
        return "\n\tID: "+ID+"\nNombre:"+ nom+"\nDireccion: "+dir+"\nTelefono: "+ tel+"\nSaldo: "+Sl; 
    }
    
}
