
package paint;

import java.io.Serializable;

public class Pto implements Serializable{
    private int Tipo;
    private double x,y,x2,y2;      
    public Pto(){
        setPto(1,0,0,0,0);
    }
    public Pto(int Tipo, double x, double y,double x2,double y2){
        setPto(Tipo, x,y,x2,y2);
    }
    
    public void setPto(int Tipo, double x, double y,double x2,double y2){
        this.Tipo = Tipo;
        this.x = x; this.y = y; 
        this.x2 = x2; this.y2 = y2;         
    }
    public int getTipo(){    return Tipo; }
    public double getX(){    return x;    }
    public double getY(){    return y;    }
    public double getX2(){   return x2;   }
    public double getY2(){   return y2;   }   
    @Override
    public String toString(){ return  Tipo+"> ("+x+", "+ y+"), ("+x2+","+ y2+")"; }
}
