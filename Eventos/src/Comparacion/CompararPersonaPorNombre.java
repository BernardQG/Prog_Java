package Comparacion;

import java.util.Comparator;

/**
 *
 * @author WQuintino
 */
public class CompararPersonaPorNombre implements Comparator<Persona>{

    @Override
    public int compare(Persona p1, Persona p11) {
        return p1.getNombre().compareTo(p11.getNombre());
    }
    
}
