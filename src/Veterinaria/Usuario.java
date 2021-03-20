package Veterinaria;

import java.util.ArrayList;

public class Usuario extends Persona {
    public ArrayList<Cita> misCitas;
    public ArrayList<Perro> misPerros;

    public Usuario(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.USUARIO);
        misCitas = new ArrayList<Cita>();
        misPerros = new ArrayList<Perro>();
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.misCitas = citas;
    }

    public void setPerros(ArrayList<Cita> perros) {
        this.misCitas = perros;
    }

    public void addPerro(Perro perro) {
        this.misPerros.add(perro);
    }

    public void removePerro(Perro perro) {
        this.misPerros.remove(perro);
    }

    public void addCita(Cita cita) {
        this.misCitas.add(cita);
    }

    public void removeCita(Cita cita) {
        this.misCitas.remove(cita);
    }

}