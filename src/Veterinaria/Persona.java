package Veterinaria;

import java.util.ArrayList;

import perros.pet.PerrosPET;

public class Persona {
    // Atributos de la persona
    public String nombreUsuario;
    public TipoDocumento tipoDocumento;
    public String documento;
    public String correo;
    public String contraseña;
    public TipoUsuario tipoUsuario;

    public ArrayList<Cita> misCitas;
    public GUI.Usuario UI;

    public Persona(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña,
            TipoUsuario tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;

        misCitas = new ArrayList<Cita>();
        (PerrosPET.personas).add(this);
    }

    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void showUserInterface() {
        UI = new GUI.Usuario(this);
        UI.setVisible(true);
    }
}
