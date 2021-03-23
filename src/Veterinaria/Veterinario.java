package Veterinaria;

import java.util.ArrayList;
import java.util.Date;
import perros.pet.PerrosPET;

public class Veterinario extends Persona {

    public ArrayList<Veterinaria.Historial> misHistoriales;

    /**
     * El veterinario hereda de persona Tiene asociada una lista de historiales Toma
     * como argumento los datos basicos de una persona.
     * 
     * @see {@link Persona}
     */
    public Veterinario(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.VETERINARIO);

        // Inicializar las citas (no pueden ser null)
        misCitas = new ArrayList<Cita>();
        misHistoriales = new ArrayList<Veterinaria.Historial>();

        // Obtener la información asociada a este objeto
        this.getCitas();
        this.getHistorial();

        // Añadir este obtejo a la lista principal de veterinarios
        (PerrosPET.veterinarios).add(this);
    }

    /**
     * Busca en la lista principal de historiales aquellos que fueron asignados a
     * este veterinario.
     */
    public void getCitas() {
        if (PerrosPET.citas.isEmpty()) {
            for (Cita cita : PerrosPET.citas) {
                if ((cita.veterinario).equals(this)) {
                    misCitas.add(cita);
                }
            }
        }
    }

    /**
     * Busca el la lista principal de historiales aquellos historiales que fueron
     * atendidos por este veterinario. Para ello, busca en todos los historiales. Si
     * la cita de un historial fue asignada a este veterinario, se va a añadir a la
     * lista de historiales de este veterinario.
     */
    public void getHistorial() {
        for (Historial historial : PerrosPET.historiales) {
            if (((historial.cita).veterinario).equals(this)) {
                misHistoriales.add(historial);
            }
        }
    }

    /**
     * Dada un fecha, se busca en el veterinario si está disponible en esa fecha.
     * Para ello, recorre todas las citas del veterinario, si esta coincide con la
     * fecha dada.
     * 
     * @param fechaCita La fecha en la que quiere buscar la disponibilidad.
     * @return La disponibilidad. True si esta disponible, false si no lo está
     */
    public boolean disponible(Date fechaCita) {
        for (Cita cita : misCitas) {
            if (cita.existe) {
                if ((cita.fecha).compareTo(fechaCita) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}