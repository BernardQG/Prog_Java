/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectanguloj;

/**
 *
 * @author QUINTINO
 */
public class Punto {
    protected double x, y;
    public Punto(){        setPunto(0,0);    }
    public Punto(double Cx,double Cy)  {    setPunto(Cx,Cy);     }
    public void setPunto(double Cx,double Cy){ x=Cx; y=Cy; }
    public double getX(){ return x; }
    public double getY(){ return y; }
    public String toString(){
      return "["+x+","+y+"]"; 
    }
    
}
