/*
 * Esta clase esta encargada de llevar los datos de las clases
 * Contienen objetos involucrados como el veterinario, el usuario y el perro
 * servicios, fecha, Id de la cita (no cambia)
 * Usuario, mascota y doctor 
*/

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
    public Veterinario veterinario;

    public Cita(boolean servicios[], Date fecha, Perro perro, Usuario usuario) {
        this.servicios = servicios;
        this.fecha = fecha;
        this.perro = perro;
        this.usuario = usuario;

        (PerrosPET.citas).add(this);
        (usuario.misCitas).add(this);

        if (findVeterinario())
            (veterinario.misCitas).add(this);

        for (Admi admi : PerrosPET.administradores) {
            (admi.misCitas).add(this);
        }
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public boolean findVeterinario() {
        /*
         * Que se debe hacer: Que veterinarios estan libres en la hora dada Recorrer la
         * lista de doctores y por cada doctor buscar que citas tiene programadas. Si no
         * tiene nunguna cita a esa hora, asignarle esta cita.
         */

        // Bucamos en todos los veterinarios
        for (Veterinario elVeterinario : PerrosPET.veterinarios) {
            int sw = 1; // Si es 0 quiere decir que el doctor esta ocupado en esa fecha

            if (!(elVeterinario.misCitas).isEmpty()) {
                // Si el veterinario tiene citas: buscamos en todas ellas para confirmar sus
                // disponivilidad en la fecha
                for (Cita cita : elVeterinario.misCitas) {
                    sw = (cita.fecha).compareTo(this.fecha);
                    if (sw == 0)
                        break; // Quiere decir que el veterinario esta ocupado
                               // Asi que hay que buscar en el siguiente
                }
            }

            // Verificamos que el veterinario este libre ese dia
            if (sw != 0) {
                this.veterinario = elVeterinario;
                return true; // Ya que ya tenemos veterinario, podemos terminar
            }
        }

        // Si al final, no encontramos un veterinario que puedar atender en esta fecha,
        // debemos enviar un mensaje de error
        return false;
    }

}
