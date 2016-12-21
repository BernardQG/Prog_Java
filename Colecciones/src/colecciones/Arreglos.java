package colecciones;
import java.util.*;
public class Arreglos {
    
        private int arreglos[]={1,2,3,4,5,6};
        private double arreglosD[]={8.4,9.3,0.3,5.9,3.4};
        private int re[], copA[];
        public Arreglos(){
            re = new int [10];
            copA = new int [arreglos.length];
            Arrays.fill(re, 5);
            Arrays.sort(arreglosD);
            System.arraycopy(arreglos, 0, copA, 0, arreglos.length);           
        }
        public int buscar(int valor){ return Arrays.binarySearch(arreglos, valor); }
        public void PIgualdad(){
            boolean b = Arrays.equals(arreglos, copA);
            System.out.println("Arreglos"+ (b?"==":"!=")+ "copiar arreblos");
            
            b = Arrays.equals(arreglos, re);
            System.out.println("Arreglos"+ (b?"==":"!=")+ "rellenar arreblos");
            
        }
        public void impA(){
            int i;
            System.out.println("\nArreglo entero");
            for(i=0;i<arreglos.length;i++){
               System.out.print(arreglos[i]+" ");
            }
            
            
            System.out.println("\nArreglo double ordenado");
            for(i=0;i<arreglosD.length;i++){
               System.out.print(arreglosD[i]+" ");
            }
            
            
            System.out.println("\nRellenar Arreglo");
            for(i=0;i<re.length;i++){
               System.out.print(re[i]+" ");
            }
        }        
    }
    

