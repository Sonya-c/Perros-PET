/*
 * Clave secreta: veterinario(eheh9s)
 * Clave secreta: administrador(gi0wnt)
 */
package perros.pet;

import GUI.*;
import Veterinaria.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PerrosPET {
    // Intancias de las diferentes clases
    public static ArrayList<Cita> citas;
    public static ArrayList<Persona> personas;
    public static ArrayList<Veterinaria.Veterinario> veterinarios;
    public static ArrayList<Veterinaria.Usuario> usuarios;
    public static ArrayList<Veterinaria.Admi> administradores;
    public static ArrayList<Veterinaria.Perro> perros;
    public static ArrayList<Veterinaria.Factura> facturas;
    public static ArrayList<Veterinaria.Historial> historiales;

    // Interfaz de Usuario
    public static Ingreso ingreso;

    public static void main(String[] args) {
        // Inicialización
        citas = new ArrayList<>();
        personas = new ArrayList<>();
        veterinarios = new ArrayList<>();
        usuarios = new ArrayList<>();
        administradores = new ArrayList<>();
        perros = new ArrayList<>();
        facturas = new ArrayList<>();
        historiales = new ArrayList<>();

        // LEER LOS DATOS DESDE LOS ARCHIVOS Y CREAR LOS OBJETOS

        Veterinaria.Usuario usuario1 = new Veterinaria.Usuario("Brett Yang", TipoDocumento.CEDULA, "123", "123");
        Veterinaria.Admi usuario2 = new Veterinaria.Admi("Eddy Chen", TipoDocumento.CEDULA, "666", "666");
        Veterinaria.Usuario usuario3 = new Veterinaria.Usuario("Paquita la del barrio", TipoDocumento.CEDULA, "322",
                "322");
        Veterinario veterinario1 = new Veterinario("Tom Holland", TipoDocumento.CEDULA, "000", "000");
        Admi admi1 = new Admi("Ulises", TipoDocumento.CEDULA, "444", "444");

        Perro perro11 = new Perro(usuario1, "Toby", "NA", "Negro", new Date(2002, 02, 26));
        Perro perro12 = new Perro(usuario1, "luis", "NA", "gris", new Date(2002, 11, 13));
        Perro perro2 = new Perro(usuario3, "Firulais", "NA", "Marron", new Date(2002, 02, 26));

        boolean servicios1[] = { true, true, true, true, true, true, true };
        Cita cita1 = new Cita(servicios1, new Date(), perro11, usuario1);
        Cita cita2 = new Cita(servicios1, new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(), perro11,
                usuario1);

        boolean servicios2[] = { true, true, true, true, true, true, true };
        Cita cita3 = new Cita(servicios2, new Date(), perro11, usuario3);
        
        Factura factura = new Factura(cita1, 123);

        Historial historial = new Historial(cita1, "mmal", "muy mal");
        
        System.out.println(facturas.size());
        // Mostrar el ingreso
        ingreso = new Ingreso();
        ingreso.setVisible(true);
    }

    public static String parseServicios(boolean servicios[]) {
        String[] serviciosNombre = { "Consulta veterinario", "Control", "Desparasitación", "Vacunación", "Guarderia",
                "Radiologia", "Baño" };
        String resultado = "";
        for (int i = 0; i < 7; i++) {
            if (servicios[i])
                resultado += serviciosNombre[i] + ", ";
        }

        return resultado;
    }
}