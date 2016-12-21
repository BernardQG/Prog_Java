/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectanguloj;

/**
 *
 * @author QUINTINO
 */
public class MainRectangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangulo Rec= new Rectangulo(1,0,0,1,3,4,4,3);
        
        char [][] Mtr = new char[5][5];
        for(int i=0; i<5;i++){
         
          for(int j=0; j<5;j++){
              if(Rec.P1.getX()==j && Rec.P1.getY()==i) { Mtr[i][j]='*'; }
              else if(Rec.P2.getX()==j && Rec.P2.getY()==i) { Mtr[i][j]='*'; }
              else if(Rec.P3.getX()==j && Rec.P3.getY()==i) { Mtr[i][j]='*'; }
              else if(Rec.P4.getX()==j && Rec.P4.getY()==i) { Mtr[i][j]='*'; }
              else{
                 Mtr[i][j]='#';
              }
          }
          
        }
        for(int i=0; i<5;i++){
          System.out.println();
          for(int j=0; j<5;j++){
             System.out.print(Mtr[i][j]+" ");
          }
          
        }
        
                  
        
    }
   
    
}
