package Veterinaria;

public class Admi extends Persona {

    public Admi(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.ADMINISTRADOR);

    }
}
