package Veterinaria;

import java.util.ArrayList;
import perros.pet.PerrosPET;

public class Usuario extends Persona {
    public ArrayList<Perro> misPerros;

    public Usuario(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.USUARIO);

        (PerrosPET.usuarios).add(this);

        misCitas = new ArrayList<Cita>();
        this.misPerros = new ArrayList<Perro>();
        this.getCitas();
        this.getMascotas();
    }

    public void getCitas() {
        for (Cita cita : PerrosPET.citas) {
            if ((cita.usuario).equals(this)) {
                misCitas.add(cita);
            }
        }
    }

    public void addCita(Cita cita) {
        misCitas.add(cita);
    }

    public void removeCita(Cita cita) {
        misCitas.remove(cita);
    }

    public void getMascotas() {
        for (Perro perro : PerrosPET.perros) {
            if ((perro.dueño).equals(this)) {
                misPerros.add(perro);
            }
        }
    }

    public void addMascota(Perro perro) {
        misPerros.add(perro);
    }

    public void removeMascota(Perro perro) {
        misPerros.remove(perro);
    }
}