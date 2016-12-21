/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadolista;
public class Eman {
    protected String nom;
    protected String ape;
    protected int eda;
    protected double sue;
    public Eman()
    {
        setEman("","",0,0);
    }
    public Eman(String n, String a, int ap, double s){
        setEman(n,a,ap,s);
    }
    void setEman(String n, String a, int ap, double s){
       nom = n; ape = a; eda = ap; sue = s; 
    }
       public String obName(){ return nom; }
       public String obApellido(){ return ape; }
       public int obEdad(){ return eda; }
       public double obCuenta(){ return sue; }        
       
       public void setN(String n){ nom = n; }
       public void setA(String a){ ape = a; }
       public void setE(int ed){  eda=ed; }
       public void setC(double cu){  sue=cu; }  
       
       public String obEm(int i){ i=i+1; return "Empleado "+i+": "+nom+" "+ ape +" "+eda+" "+sue; }    
    
    
    
}
