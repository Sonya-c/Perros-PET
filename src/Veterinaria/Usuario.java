package Veterinaria;

import java.util.ArrayList;
import perros.pet.PerrosPET;

public class Usuario extends Persona {

    public ArrayList<Perro> misPerros;

    /**
     * El usuario hereda de persona Tiene asociada una lista de perros. Toma como
     * argumento los datos basicos de una persona.
     * 
     * @see {@link Persona}
     */
    public Usuario(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.USUARIO);

        // Inicializar las listas (no pueden ser vacios)
        this.misCitas = new ArrayList<Cita>();
        this.misPerros = new ArrayList<Perro>();

        // Obtener los datos de este objetos
        this.getCitas();
        this.getMascotas();

        // Añadir este objeto a la lista principal de usuarios
        (PerrosPET.usuarios).add(this);
    }

    /**
     * Obtener las citas asociadas a este objetos. Para ello, se busca en la lista
     * principal de usuarios aquellos cuyo usuario sea este.
     */
    public void getCitas() {
        for (Cita cita : PerrosPET.citas) {
            if ((cita.usuario).equals(this)) {
                misCitas.add(cita);
            }
        }
    }

    /**
     * Obtener las mascotas asociadas a este objeto. Para ello, se busca en la lista
     * principal de perros aquellos cuyo dueños sea este
     */
    public void getMascotas() {
        for (Perro perro : PerrosPET.perros) {
            if ((perro.dueño).equals(this)) {
                misPerros.add(perro);
            }
        }
    }
}