package Veterinaria;

import java.util.Date;
import perros.pet.PerrosPET;

public class Cita {
    public boolean[] servicios;
    public Date fecha;
    public Factura factura; // true si ya es realizo
    public Historial historial;
    public Perro perro;
    public Usuario usuario;
    public Veterinario veterinario = null;

    /**
     * Esta clase representa una cita
     * 
     * @param servicios es un vector de 7 elemento booleanos: CONSULTA, CONTROL,
     *                  DESPARACITACIÓN, VACUNACIÓN, GUARDERIA, RADIOLOGIA, BAÑO
     * @param fecha     es la fecha asignada para esa fecha
     * @param perro     es el perro de la cita
     * @param usuario   es el usuario que toma la cita
     */
    public Cita(boolean servicios[], Date fecha, Perro perro, Usuario usuario) {
        this.servicios = servicios;
        this.fecha = fecha;
        this.perro = perro;
        this.usuario = usuario;

        // Añadir a la lista principa y a la lista de usuarios esta cita
        (PerrosPET.citas).add(this);
        (usuario.misCitas).add(this);

        // Si un veterinario esta disponible, asignarle esta cita. Esto se deberia hacer
        // antes de crear la cita
        if (findVeterinario())
            (veterinario.misCitas).add(this);

        // Agregarle esta cita a todos los administradores
        for (Admi admi : PerrosPET.administradores) {
            (admi.misCitas).add(this);
        }
    }

    /**
     * Que se debe hacer: Que veterinarios estan libres en la hora dada Recorrer la
     * lista de doctores y por cada doctor buscar que citas tiene programadas. Si no
     * tiene nunguna cita a esa hora, asignarle esta cita.
     */
    public boolean findVeterinario() {
        // Bucamos en todos los veterinarios
        for (Veterinario elVeterinario : PerrosPET.veterinarios) {

            if (!(elVeterinario.misCitas).isEmpty()) {
                // Si el veterinario tiene citas: buscamos en todas ellas para confirmar sus
                // disponivilidad en la fecha
                if (elVeterinario.disponible(this.fecha)) {
                    this.veterinario = elVeterinario;
                    return true; // Ya que ya tenemos veterinario, podemos terminar
                } else {
                    break; // Quiere decir que el veterinario esta ocupado
                    // Asi que hay que buscar en el siguiente
                }
            }
        }
        // Si al final, no encontramos un veterinario que puedar atender en esta fecha,
        // debemos enviar un mensaje de error
        return false;
    }
}
