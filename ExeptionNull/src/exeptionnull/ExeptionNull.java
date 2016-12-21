
package exeptionnull;
public class ExeptionNull {

    class ENull{
        String s="Ejercicio sobre excepciones";
        String getStrin(){ return s;}
    }
    public static void main(String[] args) {
        ENull en=null;
        try{
          en.getStrin();
        }
        catch(Exception e)
        {
            System.out.print("Se produjo una excepcion: "+ e.getMessage()+"\n\n");
        }
    }
    
}
