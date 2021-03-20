package Veterinaria;

import java.util.ArrayList;
import perros.pet.PerrosPET;

public class Veterinario extends Persona {
    public ArrayList<Veterinaria.Historial> misHistoriales;

    public Veterinario(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.VETERINARIO);
        misCitas = new ArrayList<Cita>();
        misHistoriales = new ArrayList<Veterinaria.Historial>();
        getHistorial();
        (PerrosPET.veterinarios).add(this);
    }

    public void getCitas() {
        for (Cita cita : PerrosPET.citas) {
            if ((cita.veterinario).equals(this)) {
                misCitas.add(cita);
            }
        }
    }

    public void getHistorial() {
        for (Historial historial : PerrosPET.historiales) {
            if (((historial.cita).veterinario).equals(this)) {
                misHistoriales.add(historial);
            }
        }
    }

}