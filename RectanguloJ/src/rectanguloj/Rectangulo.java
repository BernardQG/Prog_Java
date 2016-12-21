/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rectanguloj;
import java.lang.Math;
/**
 *
 * @author QUINTINO
 */
public class Rectangulo {
    protected Punto P1, P2,P3,P4;
    protected double l1, l2,l3,l4;
    public Rectangulo(){ setRec(0,0,0,0,0,0,0,0);  }
    public Rectangulo(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4){ 
     setRec(x1, y1, x2, y2, x3, y3, x4, y4);     
    }
    
    public void setRec(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4){
        if(x1>=0 && y1>=0 &&  x2>=0 && y2>=0 && x3>=0 && y3>=0 && x4>=0 && y4>=0)
        {    
          if(x1<=20 && y1<=20 &&  x2<=20 && y2<=20 && x3<=20 && y3<=20 && x4<=20 && y4<=20)
           {      
             
             l1=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
             l2=Math.sqrt(Math.pow(x4-x3,2)+Math.pow(y4-y3,2));
             l3=Math.sqrt(Math.pow(x4-x1,2)+Math.pow(y4-y1,2));
             l4=Math.sqrt(Math.pow(x3-x2,2)+Math.pow(y3-y2,2));
             if(l1==l2 && l3==l4){
            
                  P1=new Punto(x1,y1);
                  P2=new Punto(x2,y2);
                  P3=new Punto(x3,y3);
                  P4=new Punto(x4,y4);
                  longitud();
                  ancho();
                  Perimetro();
                  Area();
                                    
             }
             else{ System.out.println("No es un rectangulo"); }
           }
        }
        else{
            System.out.println("Datos fuera de rango");
        }
       }
       public void longitud(){ 
           System.out.println("\nLongitud: "+ Math.sqrt(Math.pow(P4.getX()-P1.getX(),2)+Math.pow(P4.getY()-P1.getY(),2)));
       } 
       public void ancho(){ 
           System.out.println("\nAncho: "+ Math.sqrt(Math.pow(P2.getX()-P1.getX(),2)+Math.pow(P2.getY()-P1.getY(),2)));
       } 
       public void Perimetro(){ 
           double sum;
           sum = l1+l2+l3+l4;
           System.out.println("\nPerimetro: "+ sum);
       }
        public void Area(){ 
           double A;
           A = l1*l4;
           System.out.println("\nArea: "+ A);
       }
       
       
    }
        

