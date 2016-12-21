/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinero;

/**
 *
 * @author WQuintino
 */
public class cuentaAhorro {
    private double TIAnual;
    private double ahorro;
        
    public cuentaAhorro(){
        setC(0.000,0.000);
    }
    public cuentaAhorro(double ahorro){
        setC(ahorro);
         
    }
    public cuentaAhorro(double ahorro, double TLAnual){
        setC(ahorro,TLAnual);
        
    }    
    public void setC(double ahorro){   this.ahorro = ahorro;  }
    public void setC(double ahorro, double TIAnual2){
        this.ahorro = ahorro;
        TIAnual = TIAnual2; 
        //System.out.println(ahorro+"  "+ TIAnual2);
    }
    public void TIM(){ 
     
               //System.out.println(ahorro+"  "+ TIAnual);
        ahorro= ahorro + ahorro*(TIAnual/100)/12;
        
    } 
    public void modificarTIA(int n){ 
        TIAnual=n;
        //System.out.println(n+"  "+ TIAnual);
    }
    public double getSaldo(){ return ahorro; }
    
    
}
