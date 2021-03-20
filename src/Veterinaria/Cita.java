/*
 * Esta clase esta encargada de llevar los datos de las clases
 * Contienen objetos involucrados como el veterinario, el usuario y el perro
 * servicios, fecha, Id de la cita (no cambia)
 * Usuario, mascota y doctor 
*/

package Veterinaria;

import java.util.ArrayList;
import java.util.Date;

public class Cita {
    public int ID; // Es el identificador de la cita

    public String[] servicios;
    public Date fecha;
    public boolean estado; // true si ya es realizo

    public Perro perro;
    public Usuario usuario;
    public Veterinario veterinario;

    // ver documentación del metodo findVeterinario
    public ArrayList<Veterinario> losVeterinarios;

    public Cita(String servicios[], Date fecha, Perro perro, Usuario usuario) {
        this.servicios = servicios;
        this.fecha = fecha;
        this.perro = perro;
        this.usuario = usuario;
        this.losVeterinarios = new ArrayList<Veterinario>();
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public void setServicio(String servicios[]) {
        this.servicios = servicios;
    }

    public boolean findVeterinario() {
        /*
         * Que se debe hacer: Que veterinarios estan libres en la hora dada Recorrer la
         * lista de doctores y por cada doctor buscar que citas tiene programadas. Si no
         * tiene nunguna cita a esa hora, asignarle esta cita.
         */

        // Bucamos en todos los veterinarios
        for (Veterinario elVeterinario : losVeterinarios) {
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
