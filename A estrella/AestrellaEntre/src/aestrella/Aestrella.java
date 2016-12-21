package aestrella;
import static aestrella.it.impM;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
import java.util.Scanner;

public class Aestrella extends it{
    static int ba=0, l=0;

     
    
    /*{{0,0,0,0},
                          {0,0,0,0},
                          {0,0,0,0},
                          {0,0,0,0}};
*/
public static int[][] leer(String Archivo,int[][] MTr) throws FileNotFoundException, IOException {
String cadena;
        int i=0;
        FileReader f;
  
        
        try {
            f = new FileReader(Archivo);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                
            for(int j=0; j<cadena.length();j++){
             if(Character.isDigit(cadena.charAt(j))){
               //System.out.print(cadena.charAt(j)+" ");
               MTr[i][j/2]=(int)((int)cadena.charAt(j)-(int)48);
             }
            }
            i++;
            //System.out.println();
            }
            b.close();
        
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Aestrella.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        return MTr;
}

      

public static void main(String[] args) throws IOException{                          
  
     int di;
     String A="D:/NetBeansProjects/Aestrella/Archivo1.txt";
    //Scanner in = new Scanner(System.in);
    Dimenciones(A);
    //System.out.print("Dimenciones tu matriz: ");
    //di = in.nextInt();   
    
    int[][] MTr = new int[ba][l/2+1];
    
    MTr = leer(A,MTr);
    //impM(MTr);
            
  
        
       //Punto inicial

      a=2; b=0;
      P.setP(a, b, 0, 0, 0, false);
      Pila.push(P);      
      List.add(P);
      
      //Punto Final
      fX=4; fY=2;
      
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
    public static void Dimenciones(String Archivo) throws FileNotFoundException, IOException {
        String cadena; ba=0;
        FileReader f;  
        try {
            f = new FileReader(Archivo);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                l=cadena.length();
                ba++;
            //System.out.println();
            }
            b.close();
        
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Aestrella.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
}
