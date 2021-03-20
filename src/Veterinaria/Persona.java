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

    // Todos las personas tiene asociados una lista de citas y un interza de usuario
    public ArrayList<Cita> misCitas;
    public GUI.Usuario UI;

    /**
     * La información basica de una persona
     * 
     * @param nombreUsuario nombre de la persona
     * @param tipoDocumento tipo del documento
     * @param documento     documento de la persona (no cambia)
     * @param contraseña    contraseña de la cuenta de la persona
     * @param tipoUsuario   hay 3 tipo de usuarios, este se generar automaticamente
     *                      al crear un usuario especifico
     * @see {@link TipoDocumento} {@link tipoUsuario} {@link Usuario}
     *      {@link Veterinario} {@link Admi}
     */
    public Persona(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña,
            TipoUsuario tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;

        // Inicializar las citas
        misCitas = new ArrayList<Cita>();

        // Añadir este usuario a la lista principal de usuarios
        (PerrosPET.personas).add(this);
    }

    /**
     * Muestra la interfaz para un usuario
     */
    public void showUserInterface() {
        UI = new GUI.Usuario(this);
        UI.setVisible(true);
    }
}
