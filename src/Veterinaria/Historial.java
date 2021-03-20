package Veterinaria;

public class Historial {
    public Cita cita;
    public String diagnostico;
    public String receta;

    public Historial(Cita cita, String diagnostico, String receta) {
        this.cita = cita;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }
}
