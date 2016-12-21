/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * @author WQuintino
 */
public class libro {
    protected String Titulo;
    protected String Autor;
    protected int nE;
    protected int Prestamo;
    
    public libro(){
        setBL("", "", 0);
    }
    public libro(String t, String a, int n){
        setBL(t,a,n);
    }
    public void setBL(String t, String a, int n){
        Titulo = t;
        Autor = a;
        nE = n;
    }
    public void setTitulo(String t){ Titulo =t;}
    public void setAutor(String a){ Autor = a; }
    public void setNe(int n){ nE = n; }
    public void setPrestamo(int p){ Prestamo = p; }
   
    public void prestamo(int n){ 
        if(Prestamo+ n <=nE){ Prestamo=Prestamo + n;} 
        else{ System.out.println("El numero de ejemplares disponibles es menor que los que deceas\nNumero de ejemplares disponivles: "+ getDispo()); }
    }
    public String getTitulo(){ return Titulo;}
    public String getAutor(){ return Autor; }
    public int getNe(){ return nE; }
    public int getPrestamo(){ return Prestamo; }
   
    
    public int getDispo(){ return (nE-Prestamo); }
    public void pBL(){ System.out.print("\n"+getTitulo() +" > "+ getAutor() +" > " + getNe()+" > " + getPrestamo());}
    public void regr(int n){ 
        if(nE > 0 && Prestamo - n >= 0){ Prestamo=Prestamo - n;}
        else{
            System.out.println("Nel no puedes regresar mas de los que hay");
        }
    }
        
    
}
