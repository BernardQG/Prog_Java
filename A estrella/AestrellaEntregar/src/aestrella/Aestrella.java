package aestrella;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aestrella extends it{
    static int[][] MTr = {{0,0,0,0},
                          {0,1,0,0},
                          {0,1,0,0},
                          {0,1,0,0}};
    
public static void main(String[] args) throws IOException {                          
            
        
       //Punto inicial

      a=3; b=0;
      P.setP(a, b, 0, 0, 0, false);
      Pila.push(P);      
      List.add(P);
      
      //Punto Final
      fX=3; fY=3;
      
      iTitulo();
      impM(MTr);
      sleep(1000);
      AEya(MTr);//Aestrella
          impMRESULTADO(MTr);
          sleep(1000);

            impPila();
            
            //impL();              
    }    
    
    
    public static void iTitulo() 
    {
        System.out.println(ANSI_RED +"     ---------------------------------------------\n"                        
                         + ANSI_RED +"            <<<<<<    A ESTRELLA     >>>>>>       \n"                        
                         + ANSI_RED +"     ---------------------------------------------\n"
                         + ANSI_BLUE+"                        PROYECTO PROGRAMACION JAVA\n"
                         +           "     Esta en:  ("+b+","+a+")                     \n"
                         +           "     Va    a:  ("+fY+","+fX+")                   \n"
                         + ANSI_RESET);
        sleep(1000);
        
       
       
    }
    public static void sleep(long l) {
        try{                
            Thread.sleep(l);
        }
        
        catch(InterruptedException e){
            System.err.println(e.getMessage());
        }
    }
    
    
}
