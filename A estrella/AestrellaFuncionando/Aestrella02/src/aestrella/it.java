
package aestrella;
import java.util.*;
import java.lang.*;
public class it {
    static punto P = new punto();
    static punto auxP = new punto();
    static punto auxP2 = new punto();
     
     
    static int a,b,fX,fY;
  
    static ArrayList <punto> List= new ArrayList <punto>();
    static Stack <punto> Pila = new Stack <punto>();
    public static void AEya(int[][] MTr)//Aestrella
    {
          //System.out.print("Hola");
          while(Pila.peek().Igual(fX, fY)!=true){
              
          System.out.println("Entra, AEstrella: "+Pila.peek().getX()+" y "+Pila.peek().getY()+" -  "+Pila.peek().Igual(fX, fY));           
                      
          checar(MTr);
                       
          }
          System.out.println("AEstrella: "+Pila.peek().getX()+" y "+Pila.peek().getY()+" -  "+Pila.peek().Igual(fX, fY));           
    }
    
    public static void checar(int[][] MTr)//verifica los vecinos
    {
        double s,mM=1000; int ai=0, aj=0;
        //System.out.println("\nEntra "); 
        P=Pila.peek();
        //P.impP();
        for(int i = P.getX()-1; i <=P.getX()+1; i++){
            for(int j=P.getY()-1;j<= P.getY()+1;j++){
                
               
              // if(i>=0 && j>=0 && MTr[i][j]!=1){//falta: y si no esta en lista
               if(i>=0 && j>=0 && reV(i,j) && i<MTr.length && j<MTr[0].length && !P.Igual(i, j) && MTr[i][j]!=1){//falta: y si no esta en lista   
                  //System.out.println(i+" y "+j); 
                  s= P.getS() + Math.sqrt(Math.pow(i-fX, 2)+ Math.pow(j-fY, 2));
                  
                  if(s<mM){ ai=i; aj=j; mM=s; } 
                  
                  //talvez un if si existe algun toro valor mas pequeño
                  auxP = new punto(i, j, P.getX(), P.getY(), s, true);
                  List.add(auxP);                  
               }
               
            }
        }
        //ReDi(mM,MTr);
        
       //if(!ReDi(mM,MTr) && !RAtorado(MTr) ){ }
       RAtorado(MTr);    
       Avanzar(ai,aj,P.getX(),P.getY()); 
           
       
    }
    
    
    
    //Si existe una mejor opcion
     public static boolean ReDi(double mM,int[][] MTr ){//si existe otro camino mas apropiado pues cambia y sigue
        
         int c=0, p=0; boolean d=false;
         
         while(c<List.size()){
           auxP2 = List.get(c);
           if(auxP2.getS()<mM && auxP2.getd()){  p=c; d=true; }
           c++; 
         }
         if(d){ rehacerPila(p); } 
         return d;
         
     }
         
     public static boolean RAtorado(int[][] MTr ){
     //Si ya no hay caminos pero no ha llegado al punto
         int contador=0; boolean b=false;
         impL();      
            System.out.println(); 
         System.out.println("Ratorado "+ P.getX() +" "+P.getY());
         for(int i = P.getX()-1; i <=P.getX()+1; i++){
            for(int j=P.getY()-1;j<= P.getY()+1;j++){     
              //checando los casos sin salida
              if(i!=P.getX() || j!=P.getY()){  
                System.out.println("R:"+ i +" "+j);
                if(i<0 || j<0){ contador++; System.out.println("a: " + 1);}
                else if(!reV(i,j)){ contador++; System.out.println("r: " + 1);}//Hay aqui un parchesin
                
                else if(i>=MTr.length|| j>=MTr[0].length){ contador++; System.out.println("b: " + 1); }
                
                else if(i>=0 && j>=0 &&  i<MTr.length && j<MTr[0].length && MTr[i][j]==1){
                    contador++; System.out.println("c: " + 1); 
                }               
              
               /*if((i<0 || j<0) || (i!=P.getX() && j!=P.getY())|| !reV(i,j) || i>MTr.length || j>MTr[0].length || MTr[i][j]==1){//falta: y si no esta en lista   
                  System.out.println("R:"+ i +" "+j);
                   
                                  
               }*/
              }
            }
        
         }
         //pues si el contador es 8 significa que no hay mas camino 
         //y hay que buscar otra ruta
         //if(contador==8){ 
         System.out.println("Contador: "+ contador);
         if(false){
             
             b=true;
            int c=0, p=0; boolean d=false;
            int mM=1000;
            while(c<List.size()){
               auxP2 = List.get(c);
               if(auxP2.getS()<mM && auxP2.getd()){  p=c; d=true; }
               c++; 
           }
           if(d){ rehacerPila(p); } 
           else { 
               System.out.print("Ya no hay mas opciones tu matriz es imposible");
               System.exit(0);         
           } 
         }
         else{ b= false; }
         return b;
     
     
     }
     
     public static void rehacerPila(int c){//c es la nueva pocicion         
         
        int [] vec = new int[100];
        vec[0]=c;
        int j=1;
        while(List.get(c).getPX()!=a && List.get(c).getPY()!=b){
            
              for(int i=0;i<List.size();i++){
                   if(List.get(i).Igual(List.get(c).getPX(), List.get(c).getPY()))
                   {   
                       c=i; vec[j]=c; j++;
                       //System.out.println(i);
                   }
              }
        }
        //vaciar la pila
        while(Pila.empty()){ Pila.pop(); }
        
        //llenar la vila checar si ingresa el punto inicial
        for(int i=j;i>0;i--){ Pila.push(List.get(vec[i])); }
        Pila.peek().setd(false);
        //definir que no esta disponible el punto en lista
         int i=0;
         while(i<List.size()){
             if(List.get(i).getX()==Pila.peek().getX() && List.get(i).getY()==Pila.peek().getY())
             {
                  List.get(i).setd(false);
             }
             i++;        
         }
         
         
     
     }

     public static boolean reV(int x, int y)//ya esta
     {
         boolean b=true;
         int c=0; 
         
         while(c<List.size()){
         auxP2 = List.get(c);
         if(auxP2.Igual(x, y) && auxP2.getd()==false){ b=false; }
         c++; }
         return b;
     }
     public static void Avanzar(int x, int y, int xO, int yO)
     {
       
         double s;
         if((xO+yO)%2==0){
              if((x+y)%2==0){ s = P.getS()+1.5; }//cuando se mueve en diagonal
              else{ s = P.getS()+1;}//cuando se mueve en horizontal o vertical
         }
         else{
             if((x+y)%2==0){ s = P.getS()+1; }//cuando se mueve en horizontal o vertical
             else{ s = P.getS()+1.5;}//cuando se mueve en diagonal
         }              
         
         auxP = new punto(x, y, xO, yO, s, false);
         Pila.push(auxP);
         
         
         //definir que no esta disponible el punto en lista
         int i=0;
         while(i<List.size()){
             if(List.get(i).getX()==x && List.get(i).getY()==y)
             {
                  List.get(i).setd(false);
             }
             i++;        
         }
         
        
     }
    public static void impM(int[][] MTr)//imprime la matriz
    {
        for(int i = 0; i < MTr.length; i++){
            for(int j=0;j<MTr[0].length;j++){
               System.out.print(MTr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void impPila()//imprime la pila
    {  int i=0; while(i<Pila.size()){  System.out.print(i+" "); Pila.get(i).impP(); i++; } }
    public static void impL()//imprime la Lista
    {  int i=0; while(i<List.size()){  System.out.print(i+" "); List.get(i).impP(); i++; } }
    
}
