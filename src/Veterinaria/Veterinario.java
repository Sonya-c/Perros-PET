package Veterinaria;

import java.util.ArrayList;
import perros.pet.PerrosPET;

public class Veterinario extends Persona {

    public Veterinario(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.VETERINARIO);
        misCitas = new ArrayList<Cita>();
    }

    public void getCitas() {
        for (Cita cita : PerrosPET.citas) {
            if ((cita.veterinario).equals(this)) {
                misCitas.add(cita);
            }
        }
    }

}