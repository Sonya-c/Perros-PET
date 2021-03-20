package Veterinaria;

public class Persona {
    public String nombreUsuario;
    public TipoDocumento tipoDocumento;
    public String documento;
    public String correo;
    public String contraseña;
    public TipoUsuario tipoUsuario;
    public GUI.Usuario UI;

    public Persona(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña,
            TipoUsuario tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
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
