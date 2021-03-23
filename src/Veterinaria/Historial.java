package Veterinaria;

import perros.pet.PerrosPET;

public class Historial {
    public Cita cita;
    public String diagnostico;
    public String receta;
    public int id;

    /**
     * 
     * @param cita
     * @param diagnostico
     * @param receta
     */
    public Historial(Cita cita, String diagnostico, String receta) {
        this.cita = cita;
        this.diagnostico = diagnostico;
        this.receta = receta;
        this.id = PerrosPET.historiales.size() + 1;
        cita.idHistorial = id;

        (PerrosPET.historiales).add(this);
        if (cita.veterinario != null) {
            (cita.veterinario).misHistoriales.add(this);
        }
    }
}
