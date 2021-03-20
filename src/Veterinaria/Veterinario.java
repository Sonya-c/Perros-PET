package Veterinaria;

import java.util.ArrayList;
import GUI.Usuario;

public class Veterinario extends Persona {

    public ArrayList<Cita> misCitas;
    public ArrayList<Historial> miHistorial;

    public Veterinario(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.VETERINARIO);
        misCitas = new ArrayList<Cita>();
    }

    // ------------CITAS--------------//
    public void setCita(ArrayList<Cita> citas) {
        misCitas = citas;
    }

    public void addCita(Cita cita) {
        misCitas.add(cita);
    }

    public void removeCita(Cita cita) {
        misCitas.remove(cita);
    }

    // -----------EL HISTORIAL DEL VETERINARIO-------------//
    public void setHistorial(ArrayList<Historial> historial) {
        this.miHistorial = historial;
    }

    public void addHistorial(Historial nuevaReceta) {
        this.miHistorial.add(nuevaReceta);
    }

    public void removeHistorial(Historial receta) {
        this.miHistorial.remove(receta);
    }

}