package Veterinaria;

import perros.pet.PerrosPET;

public class Admi extends Persona {

    public Admi(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.ADMINISTRADOR);

    }

    public void getCitas() {
        for (Cita cita : PerrosPET.citas) {
            misCitas.add(cita);
        }
    }

}
