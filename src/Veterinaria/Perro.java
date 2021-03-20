package Veterinaria;

import java.util.Date;
import perros.pet.PerrosPET;

public class Perro {
    public final Usuario dueño;
    public String nombre;
    public String raza;
    public String color;
    public Date fechaNacimiento;

    /**
     * El perro esta ligado a un usuario
     * 
     * @param dueño           es el objeto usuario que es el dueño de este perro
     * @param nombre          es el nombre del perro, En la lista principal este se
     *                        puede repetir. Pero, en la lista del dueño no.
     * @param raza            la raza del perro
     * @param color           el color dde perro
     * @param fechaNacimiento fecha de nacimiento del perro
     */
    public Perro(Usuario dueño, String nombre, String raza, String color, Date fechaNacimiento) {
        this.dueño = dueño;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.fechaNacimiento = fechaNacimiento;

        // Añadir el perro a la lista principal y a la lista de perros del respectivo
        // usuario
        (PerrosPET.perros).add(this);
        (dueño.misPerros).add(this);
    }
}
