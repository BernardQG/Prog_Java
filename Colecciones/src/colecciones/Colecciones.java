package colecciones;
public class Colecciones {
    public static void main(String[] args) {
             Arreglos obj1= new Arreglos();
             
             obj1.PIgualdad();
             obj1.impA();
             
             int p=obj1.buscar(2);
             System.out.println((p>=0?"\nValor encontrado en " + p: "\nValor no encontrado ")+" en el arreglo de enteros");                                                                 
             
    }
}    

