package aestrella;
//objeto que contiene un punto, su distancia, su punto predecesor y su disponibilidad
public class punto {
    protected int x,y, px, py;
    protected double s; 
    protected boolean d;//disponibilidad
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    //contructores
    public punto(){
       setP(0,0,0,0,0,false);
    }
    public punto(int x,int y, int px, int py, double s, boolean d){
        setP(x,y,px,py,s,d);
    }
    void setP(int x,int y, int px, int py, double s, boolean d){
        this.x=x; this.y=y;
        this.px=px; this.py=py;
        this.s=s; this.d=d;        
    }
    //public void impP(){  System.out.println(ANSI_PURPLE + "Punto: ("+x + ","+y+")| ("+px + ","+py+"), "+s + " y "+ d+ ANSI_RESET);  }
    public void impP(){  System.out.println(ANSI_PURPLE + "Punto: ("+x + ","+y+")| Origen: ("+px + ","+py+"), Distancia: "+s + ANSI_RESET);  }
    //gets, devolver valores individuales
    public int getX(){  return x; }
    public int getY(){  return y; }
    public int getPX(){  return px; }
    public int getPY(){  return py; }
    public double getS(){  return s; }
    public boolean getd(){  return d; }  
    public boolean Igual(int x, int y){  
        if(x==this.x && y==this.y){ return true; }
        else{ return false; }
    }  
    public void setd(boolean d){  this.d = d; }  
    public void sets(double s){  this.s = s; } 
    
}
