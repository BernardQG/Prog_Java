
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
              
          System.out.println("\n\nEntra, AEstrella: "+Pila.peek().getX()+" y "+Pila.peek().getY()+" -  "+Pila.peek().Igual(fX, fY));           
                      impPila();
        impL();
          RAtorado(MTr);
          
          checar(MTr);
                       
          }
          System.out.println("AEstrella: "+Pila.peek().getX()+" y "+Pila.peek().getY()+" -  "+Pila.peek().Igual(fX, fY));           
    }
    
    public static void checar(int[][] MTr)//verifica los vecinos
    {
        double s,mM=1000; int ai=0, aj=0;
        System.out.println("\nChecar "); 
        
        
        
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
        impPila();
        impL();
       //if(!ReDi(mM,MTr) && !RAtorado(MTr) ){ }
           
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
         if(d){ rehacerPila(p,MTr); } 
         return d;
         
     }
         
     public static boolean RAtorado(int[][] MTr ){
     //Si ya no hay caminos pero no ha llegado al punto
         int contador=0; boolean b=false;
         //impL();      
           // System.out.println(); 
         System.out.println("Ratorado "+ P.getX() +" "+P.getY());
         for(int i = P.getX()-1; i <=P.getX()+1; i++){
            for(int j=P.getY()-1;j<= P.getY()+1;j++){     
              //checando los casos sin salida
              if(i!=P.getX() || j!=P.getY()){  
                //System.out.println("R:"+ i +" "+j);
                if(i<0 || j<0){ contador++; //System.out.println("a: " + 1);
                
                }
                else if(!reV(i,j)){ contador++; //System.out.println("r: " + 1);
                }//Hay aqui un parchesin
                
                else if(i>=MTr.length|| j>=MTr[0].length){ contador++; //System.out.println("b: " + 1);
                }
                
                else if(i>=0 && j>=0 &&  i<MTr.length && j<MTr[0].length && MTr[i][j]==1){
                    contador++; // System.out.println("c: " + 1); 
                }               
              
               /*if((i<0 || j<0) || (i!=P.getX() && j!=P.getY())|| !reV(i,j) || i>MTr.length || j>MTr[0].length || MTr[i][j]==1){//falta: y si no esta en lista   
                  System.out.println("R:"+ i +" "+j);
                   
                                  
               }*/
              }
            }
        
         }
         //pues si el contador es 8 significa que no hay mas camino 
         //y hay que buscar otra ruta
         if(contador==8){ 
         System.out.println("Contador: "+ contador);
         //if(false){
             
             b=true;
            int c=0, p=0; boolean d=false;
            double mM=1000;
            while(c<List.size()){
               
               if(List.get(c).getS()<mM && List.get(c).getd()){ 
                   p=c; d=true;
                   mM=List.get(c).getS(); 
               }
               c++; 
           }
           if(d){ 
               //List.get(p).impP();
               rehacerPila(p,MTr); 
              // System.exit(0);
           } 
           else { 
               System.out.print("Ya no hay mas opciones tu matriz es imposible");
               System.exit(0);         
           } 
         }
         else{ b= false; }
         return b;
     
     
     }
     
     public static void rehacerPila(int c, int[][] MTr){//c es la nueva pocicion         
         
        int [] vec = new int[100];
        //List.get(c).impP();
        vec[0]=c;
        int j=1;
        System.out.println("Calabaza");
        while(List.get(c).getPX()!=a && List.get(c).getPY()!=b){
        System.out.println("coliflor");    
              for(int i=0;i<List.size();i++){
                   if(List.get(i).Igual(List.get(c).getPX(), List.get(c).getPY()))
                   {   
                       c=i; vec[j]=c; j++;
                       
                       System.out.println(i);
                   }
              }
        }
        for(int i=0; i<j;i++ ){ System.out.println("Vector: "+ vec[i]); }
        //vaciar la pila
        /*System.out.println("Pila vacia?");
        impPila();
        System.out.println("Pila vacia?");*/
        //auxP = Pila.get(0);
        while(!Pila.empty()){ Pila.pop(); }
        /*
        System.out.println("Pila vacia?");
        impPila();
        System.out.println("Pila vacia?");
        
        //llenar la vila checar si ingresa el punto inicial
        Pila.push(auxP);
        System.out.println("Lista?");
        impL();
        System.out.println("Lista?"+j);
        */
        double s=0.0;
        for(int i=j;i>=0;i--){
             List.get(vec[i]).impP();
             System.out.print("\n  Entsdfgsdfgsfgsgfsfdgsfgsfgsdfgsdfgra\n");
             
             System.out.print("ptt: "+ List.get(vec[i]).getX()+ "  "+List.get(vec[i]).getY()+"  "+(List.get(vec[i]).getX()!=a || List.get(vec[i]).getY()!=b)+"\n");
            if(List.get(vec[i]).getX()!=a || List.get(vec[i]).getY()!=b)// && List.get(vec[i]).getX()!=a && List.get(vec[i]).getY()!=b)
           { 
                 //System.out.print("Entsdfgsdfgsfgsgfsfdgsfgsfgsdfgsdfgra");
                if((List.get(vec[i]).getPX()+List.get(vec[i]).getPY())%2==0)
                {
                    //System.out.print("Entsdfgsdfgsfgsgfsfdgsfgsfgsdfgsdfgra");
                    if((List.get(vec[i]).getX()+List.get(vec[i]).getY())%2==0)
                    {
                        s = Pila.peek().getS()+1.5;
                    }//cuando se mueve en diagonal
                    else if((List.get(vec[i]).getX()+List.get(vec[i]).getY())%2!=0)
                    {
                        //nunca entra
                       
                        s = Pila.peek().getS()+1;
                    }
                }//cuando se mueve en horizontal o vertical
                
                else{
                    System.out.print("Entsdfgsdfgsfgsgfsfdgsfgsfgsdfgsdfgra");
                    if((List.get(vec[i]).getX()+List.get(vec[i]).getY())%2==0)
                    {
                        s = Pila.peek().getS()+1; 
                    }//cuando se mueve en horizontal o vertical
                    else{
                        s = Pila.peek().getS()+1.5; 
                    }//cuando se mueve en diagonal
                }
            } 
            //else { System.out.print("Entsdfgsdfgsfgsgfsfdgsfgsfgsdfgsdfgra"); }
            Pila.push(List.get(vec[i]));
            Pila.peek().sets(s);
         }
        
        
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
         
         impPila();
         
         impL();//aqui me quede la pila se ingreso de dea manera o rayos.
        // checar(MTr);
         
     
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
    {  int i=0; System.out.println("\nPila");
    while(i<Pila.size()){  System.out.print(i+" "); Pila.get(i).impP(); i++; } }
    public static void impL()//imprime la Lista
            
    {  int i=0; System.out.println("\nLista");
    while(i<List.size()){  System.out.print(i+" "); List.get(i).impP(); i++; } }
    
}
