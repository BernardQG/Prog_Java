package Comparacion;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;
import java.util.Collections;
/**
 *
 * @author WQuintino
 */
public class TestComparacion {
    public static void main(String[] a){
        List<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona("Juan", (short)19));
        lista.add(new Persona("Berna", (short)20));
        
        //out.println(lista.get(0).compareTo(lista.get(1)));
        out.println("LISTA DE PERSONAS SIN ORDENAR");
        for(Persona p : lista){
            out.println(p.getNombre() + " " + p.getEdad());
        }
        
        CompararPersonaPorNombre cpn = new CompararPersonaPorNombre();
        out.println(cpn.compare(lista.get(0), lista.get(1)));
        
        
    }
}
