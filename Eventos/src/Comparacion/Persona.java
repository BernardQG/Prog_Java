
package Comparacion;

/**
 *
 * @author WQuintino
 */
public class Persona implements Comparable<Persona>{
    private String nombre;
    private Short edad;

    public Persona(String nombre, Short edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }
    
    @Override
    public int compareTo(Persona p) {
        if(edad<p.edad)
            return -1;
        else if(edad>p.edad)
            return 1;
        return 0;
    }
    
}
