/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiarcaracter;


/**
 *
 * @author WQuintino
 */
public class CambiarC {
    protected String Pl;
    protected char cR;
    public CambiarC(){
      setFrase("");
    }
    public CambiarC(String f)
    {
      setFrase(f);  
    }
    public void setFrase(String f){   Pl=f;   }
    public String cambiarC(){
         int a, b;
         a=0;
         b=Pl.length();;         
         for(int i=0; i<Pl.length();i++){
             if(i>=a && i<b && (int)Pl.charAt(i)!=32){
               if((int)Pl.charAt(i)==90 || (int)Pl.charAt(i)==122){  
                         System.out.print((char)(Pl.charAt(i)-25));
                } 
               else if((int)Pl.charAt(i)==57){  
                         System.out.print((char)(Pl.charAt(i)-9));
                } 
               else{
                System.out.print((char)(Pl.charAt(i)+1));
               }
             }
             else{ System.out.print(Pl.charAt(i));}
         }
         System.out.print("\n\n\n");
      return Pl;   
    }
}
