package aestrella;

public class Aestrella extends it{
    static int[][] MTr = {{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}};
    
    public static void main(String[] args) {     
      //Punto inicial
      System.out.print("Hola");
      a=2; b=3;
      P.setP(a, b, 0, 0, 0, false);
      Pila.push(P);      
      //Punto Final
      fX=3; fY=3;
      
      AEya(MTr);//Aestrella

         impPila();
         System.out.println();
         impL();      
         System.out.println();
    }    
}
