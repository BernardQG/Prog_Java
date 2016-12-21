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
public class Punto {
    protected int x,y;
    public Punto(){
        setPoint(0,0);
    }
    public Punto (int xCoordinate,int yCoordinate){
      setPoint(xCoordinate, yCoordinate);
    }
    public void setPoint(int xCoordinate, int yCoordinate)
    {      x=xCoordinate; y=yCoordinate;     }
    
    public int getX(){ return x; }
    public int getY(){ return y; }
    public String toString(){
      return "["+x+","+y+"]"; 
    }
    
 }
            
