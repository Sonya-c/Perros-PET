/*
 * Clave secreta: veterinario(eheh9s)
 * Clave secreta: administrador(gi0wnt)
 */
package perros.pet;

import GUI.*;
import Veterinaria.*;
import java.util.ArrayList;

public class PerrosPET {
    public static ArrayList<Cita> citas;
    public static ArrayList<Persona> personas;
    public static ArrayList<Veterinaria.Veterinario> veterinarios;
    public static ArrayList<Veterinaria.Usuario> usuarios;
    public static ArrayList<Veterinaria.Admi> administradores;

    // Interfaz de Usuario
    public static Ingreso ingreso;

    public static void main(String[] args) {
        citas = new ArrayList<Cita>();
        personas = new ArrayList<Persona>();
        veterinarios = new ArrayList<Veterinaria.Veterinario>();
        usuarios = new ArrayList<Veterinaria.Usuario>();
        administradores = new ArrayList<Veterinaria.Admi>();

        Veterinaria.Usuario usuario = new Veterinaria.Usuario("Paquita la del barrio", TipoDocumento.CEDULA, "3222222",
                "3222222");
        Veterinario v = new Veterinario("Marco", TipoDocumento.CEDULA, "123456789", "123456789");

        personas.add(usuario);
        personas.add(v);

        ingreso = new Ingreso();
        ingreso.setVisible(true);
    }

    public static void addPersona(Persona persona) {
        personas.add(persona);
    }

    public static void addUsuario(Veterinaria.Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void addVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
    }

    public static void addAdministrador(Admi administrador) {
        administradores.add(administrador);
    }
}
