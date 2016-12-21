/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciaenjava;
/**
 *
 * @author Lenovo
 */
public class Circulo extends Punto{
    protected double radius;
    public Circulo(){ setRadius(0); }
    public Circulo(double circleRadius, int xCoordinate, int yCoordinate){
        super (xCoordinate, yCoordinate);
        setRadius(circleRadius);
        
    }
    public void setRadius(double circleRadius){
       radius = (circleRadius >=0.0 ? circleRadius :0.0);
    }
    public double getRadius(){ return radius; }
    public double area(){ return Math.PI * radius * radius; }
    public String toString(){
      return "centro="+" ["+x+", "+y+"]"+": Radio= "+ radius; 
    }

    
    
    
}
