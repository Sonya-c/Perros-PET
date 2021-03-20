/*
 * Clave secreta: veterinario(eheh9s)
 * Clave secreta: administrador(gi0wnt)
 */
package perros.pet;

import GUI.*;
import Veterinaria.*;
import java.util.ArrayList;
import java.util.Date;

public class PerrosPET {
    public static ArrayList<Cita> citas;
    public static ArrayList<Persona> personas;
    public static ArrayList<Veterinaria.Veterinario> veterinarios;
    public static ArrayList<Veterinaria.Usuario> usuarios;
    public static ArrayList<Veterinaria.Admi> administradores;
    public static ArrayList<Veterinaria.Perro> perros;

    // Interfaz de Usuario
    public static Ingreso ingreso;

    public static void main(String[] args) {
        citas = new ArrayList<Cita>();
        personas = new ArrayList<Persona>();
        veterinarios = new ArrayList<Veterinaria.Veterinario>();
        usuarios = new ArrayList<Veterinaria.Usuario>();
        administradores = new ArrayList<Veterinaria.Admi>();
        perros = new ArrayList<Veterinaria.Perro>();

        Veterinaria.Usuario usuario = new Veterinaria.Usuario("Paquita la del barrio", TipoDocumento.CEDULA, "3222222",
                "3222222");

        Date fecha = new Date(2002, 07, 26);
        Perro perro = new Perro(usuario, "pepe grillo", "malquipoo", "negro", fecha);
        usuario.addMascota(perro);
        String servicios[] = { "Baño", "consulta" };
        Cita cita1 = new Cita(servicios, fecha, perro, usuario);
        Cita cita2 = new Cita(servicios, fecha, perro, usuario);
        Cita cita3 = new Cita(servicios, fecha, perro, usuario);

        usuario.addCita(cita1);
        usuario.addCita(cita2);
        usuario.addCita(cita3);
        Veterinario v = new Veterinario("Marco", TipoDocumento.CEDULA, "123456789", "123456789");

        personas.add(usuario);
        personas.add(v);

        ingreso = new Ingreso();
        ingreso.setVisible(true);
    }

    public static String join(String separador, String lista[]) {
        String resultado = "";

        for (String item : lista) {
            resultado += item + separador + " ";
        }

        return resultado;
    }
}
