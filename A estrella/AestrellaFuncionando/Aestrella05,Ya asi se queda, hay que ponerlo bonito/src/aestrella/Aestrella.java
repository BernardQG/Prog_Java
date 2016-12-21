package aestrella;

public class Aestrella extends it{
    static int[][] MTr = {{0,0,0,0},
                          {0,1,0,0},
                          {0,1,0,0},
                          {0,1,0,0}};
    
    public static void main(String[] args) {     
      impM(MTr);  System.out.println();
      //Punto inicial
      
      a=3; b=0;
      P.setP(a, b, 0, 0, 0, false);
      Pila.push(P);      
      List.add(P);
      
      //Punto Final
      fX=3; fY=3;
      
      AEya(MTr);//Aestrella
      
            impPila();         
            impL();      
          

    }    
}
