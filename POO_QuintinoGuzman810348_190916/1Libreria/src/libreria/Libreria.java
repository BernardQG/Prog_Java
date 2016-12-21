
package libreria;

/**
 *
 * @author WQuintino
 */
public class Libreria {

    //decorativo
    static void pT(){ System.out.print("\nTitulo del libo >  Autor >  Numero de ejemplares > Prestamo "); }
    public static void main(String[] args) {
          libro l1 = new libro();
          libro l2, l3;
          //Generando los datos de los objetos
          l2=new libro("La valiente galletita", "Tomi wilson", 20);
          l3=new libro("El agua modaja"," Don ramon", 45);
          l1.setBL("El fuego quema", "DaVinci", 32);
          //Mostrar los datos
          pT(); 
          l1.pBL();
          l2.pBL();
          l3.pBL();
          
          //Prestar unos libros
          System.out.println("\n\nPrestando unos libros");
          l1.setPrestamo(6);
          l2.setPrestamo(15);
          l3.setPrestamo(12);
          //Mostrar los datos
          pT(); 
          l1.pBL();
          l2.pBL();
          l3.pBL();
          //Devolver
          System.out.println("\n\nDevolviendo 4 libros de l1");
          l1.regr(4);
          l1.pBL();
          //Casos error
          System.out.println("\n\nCuando queremos retirar mas de los que podemos en l2");
          l2.prestamo(100);
          l2.pBL();
          
          System.out.println("\n\n");
         
          
          
          
    }
    
    
}
