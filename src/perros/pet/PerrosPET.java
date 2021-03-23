/*
 * Clave secreta: veterinario(eheh9s)
 * Clave secreta: administrador(gi0wnt)
 */
package perros.pet;

import GUI.*;
import Veterinaria.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PerrosPET {
    public static DateFormat dateFormat;

    // Arrays de las diferen
    public static ArrayList<Cita> citas;
    public static ArrayList<Persona> personas;
    public static ArrayList<Veterinaria.Veterinario> veterinarios;
    public static ArrayList<Veterinaria.Usuario> usuarios;
    public static ArrayList<Veterinaria.Admi> administradores;
    public static ArrayList<Veterinaria.Perro> perros;
    public static ArrayList<Veterinaria.Factura> facturas;
    public static ArrayList<Veterinaria.Historial> historiales;

    // Archivos
    public static String rutaDir = "C:\\PerrosPet";
    public static String ruta = "C:\\PerrosPet";
    public static File dir;
    public static File archivoPersonas;
    public static File archivoPerros;
    public static File archivoCitas;
    public static File archivoHistoriales;
    public static File archivoFacturas;

    // Interfaz de Usuario
    public static Ingreso ingreso;
    public static Loader loader;

    public static void main(String[] args) {
        loader = new Loader();
        loader.setVisible(true);
        dateFormat = new SimpleDateFormat("dd-MM-YYYY");

        // INICIALIZACIÓN DE LAS LISTAS
        citas = new ArrayList<>();
        personas = new ArrayList<>();
        veterinarios = new ArrayList<>();
        usuarios = new ArrayList<>();
        administradores = new ArrayList<>();
        perros = new ArrayList<>();
        facturas = new ArrayList<>();
        historiales = new ArrayList<>();

        // INICIALIZACIÓN DE LOS ARCHIVOS
        dir = new File(rutaDir);
        archivoPersonas = new File(ruta, "personas.txt");
        archivoPerros = new File(ruta, "perros.txt");
        archivoCitas = new File(ruta, "citas.txt");
        archivoHistoriales = new File(ruta, "historiales.txt");
        archivoFacturas = new File(ruta, "facturas.txt");

        if (!dir.exists()) {
            dir.mkdir();
        }

        // CREAR LOS DIFERENTES OBJETOS Y ENVIAR LOADER
        leerPersonas();
        loader.addValue();

        leerPerros();
        loader.addValue();

        leerCitas();
        loader.addValue();

        leerHistoriales();
        loader.addValue();

        leerFacturas();
        loader.addValue();

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

        // MOSTRAR LA PANTALLA DE INGRESO
        ingreso = new Ingreso();
        loader.limpiarBarra();
        loader.setVisible(false);
        ingreso.setVisible(true);
    }

    // -----------------LEER Y ACTUALIZAR LOS ARCHIVOS ------------------

    /**
     * Lee el archivo de personas y crea los objetos. Si no exite el archivo, lo
     * crea.
     */
    public static void leerPersonas() {
        if (!archivoPersonas.exists()) {
            try {
                archivoPersonas.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (Scanner sc = new Scanner(archivoPersonas)) {
                while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    String data[] = linea.split("/");

                    String nombreUsuario = data[0];
                    TipoUsuario tipoUsuario = Enum.valueOf(TipoUsuario.class, data[1]);
                    TipoDocumento tipoDocumento = Enum.valueOf(TipoDocumento.class, data[2]);
                    String documento = data[3];
                    String contraseña = data[4];

                    switch (tipoUsuario) {
                    case VETERINARIO:
                        new Veterinaria.Veterinario(nombreUsuario, tipoDocumento, documento, contraseña);
                        break;
                    case ADMINISTRADOR:
                        new Veterinaria.Admi(nombreUsuario, tipoDocumento, documento, contraseña);
                        break;
                    default:
                        new Veterinaria.Usuario(nombreUsuario, tipoDocumento, documento, contraseña);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se encontró");
            }
        }
    }

    public static void actualizarPersonas() throws IOException {
        if (archivoPersonas.delete()) {
            if (archivoPersonas.createNewFile()) {
                try (FileWriter fw = new FileWriter(archivoPersonas.getAbsoluteFile(), true)) {
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (Persona persona : personas) {
                        String nombre = persona.nombreUsuario;
                        String tipoUsuario = persona.tipoUsuario.toString();
                        String tipoDocumento = persona.tipoDocumento.toString();
                        String documento = persona.documento;
                        String contraseña = persona.contraseña;

                        bw.write(nombre + "/" + tipoUsuario + "/" + tipoDocumento + "/" + documento + "/" + contraseña);
                        bw.newLine();
                    }

                    bw.flush();
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("Error en la creación del archivo");
                }
            }
        }
    }

    /**
     * Lee el archivo perros y crea los objetos. Si no exite el archivo los crea
     * 
     * @throws ParseException
     */
    public static void leerPerros() throws ParseException {
        if (!archivoPerros.exists()) {
            try {
                archivoPerros.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (Scanner sc = new Scanner(archivoPerros)) {
                while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    String data[] = linea.split("/");

                    String nombreDueño = data[0];
                    String nombrePerro = data[1];
                    String raza = data[2];
                    String color = data[3];
                    String fechaNacimiento = data[4];

                    Veterinaria.Usuario dueño = (Veterinaria.Usuario) encontrarPersona(nombreDueño);
                    Date fecha = dateFormat.parse(fechaNacimiento);

                    new Perro(dueño, nombrePerro, raza, color, fecha);
                }
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se encontró");
            }
        }
    }

    public static void actualizarPerros() {
        if (archivoPerros.delete()) {
            if (archivoPerros.createNewFile()) {
                try (FileWriter fw = new FileWriter(archivoPerros.getAbsoluteFile(), true)) {
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (Perro perro : perros) {
                        String nombreDueño = perro.dueño.nombreUsuario;
                        String nombrePerro = perro.nombre;
                        String raza = perro.raza;
                        String fechaNacimiento = dateFormat.format(perro.fechaNacimiento);

                        bw.write(nombreDueño + "/" + nombrePerro + "/" + raza + "/" + fechaNacimiento);
                        bw.newLine();
                    }

                    bw.flush();
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("Error en la creación del archivo");
                }
            }
        }
    }

    /**
     * Lee el archivo cita y crea los objetos. Si no existe el archivo los crea
     * 
     * @throws ParseException
     */
    public static void leerCitas() throws ParseException {
        if (!archivoCitas.exists()) {
            try {
                archivoCitas.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (Scanner sc = new Scanner(archivoCitas)) {
                while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    String data[] = linea.split("/");

                    String servicios = data[0];
                    String fechaCita = data[1];
                    int idFactura = Integer.parseInt(data[2]);
                    int idHistorial = Integer.parseInt(data[3]);
                    String nombrePerro = data[4];
                    String nombreUsuario = data[5];
                    String nombreVeterinario = data[6];

                    Date fecha = dateFormat.parse(fechaCita);
                    Veterinaria.Usuario usuario = (Veterinaria.Usuario) encontrarPersona(nombreUsuario);
                    Veterinaria.Perro perro = (Veterinaria.Perro) encontrarPerro(usuario, nombrePerro);
                    Veterinaria.Veterinario veterinario = (Veterinaria.Veterinario) encontrarPersona(nombreVeterinario);

                    String listaServicios[] = servicios.split(",");
                    boolean listaVerdadServicios[] = new boolean[7];

                    for (int index = 0; index < 7; index++) {
                        if (listaServicios[index].equals("0")) {
                            listaVerdadServicios[index] = false;
                        } else {
                            listaVerdadServicios[index] = true;
                        }
                    }

                    Cita cita = new Cita(listaVerdadServicios, fecha, perro, usuario, veterinario);
                    cita.idFactura = idFactura;
                    cita.idHistorial = idHistorial;

                }
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se encontró");
            }
        }
    }

    public static Veterinaria.Persona encontrarPersona(String nombreUsuario) {
        for (Veterinaria.Persona persona : personas) {
            if ((persona.nombreUsuario).equals(nombreUsuario)) {
                return persona;
            }
        }
        return null;
    }

    public static Veterinaria.Perro encontrarPerro(Veterinaria.Usuario usuario, String nombrePerro) {
        for (Veterinaria.Perro perro : usuario.misPerros) {
            if ((perro.nombre).equals(nombrePerro))
                return perro;
        }
        return null;
    }

    public static void actualizarCitas() {
        if (archivoCitas.delete()) {
            if (archivoCitas.createNewFile()) {
                try (FileWriter fw = new FileWriter(archivoCitas.getAbsoluteFile(), true)) {
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    for (Cita cita: citas) {
                        String servicios = cita.servicios;
                        String fechaCita = dateFormat.format(cita.fechaCita);
                        int idFactura = cita.idFactura + "";e
                        int idHistorial = cita.idHistorial + "";
                        String nombrePerro = cita.nombrePerro;
                        String nombreUsuario = cita.nombreUsuario;
                        String nombreVeterinario = cita.nombreVeterinario;

                        bw.write("servicios + "/" + fechaCita + "/" + idFactura + "/" + idHistorial + "/" + nombrePerro + "/" + nombreUsuario + "/" + nombreVeterinario");
                        bw.newLine();
                    }
                    
                    bw.flush();
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("Error en la creación del archivo");
                }
            }
        }
    }

    /**
     * Lee el archivo historiales, si no exite lo crea
     */
    public static void leerHistoriales() {
        if (!archivoHistoriales.exists()) {
            try {
                archivoHistoriales.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (Scanner sc = new Scanner(archivoHistoriales)) {
                while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    String data[] = linea.split("/");

                    String disganostico = data[0];
                    String receta = data[1];
                    int id = Integer.parseInt(data[2]);

                    for (Veterinaria.Cita cita : citas) {
                        if (cita.idHistorial == id) {
                            new Historial(cita, disganostico, receta);
                        }
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se encontró");
            }
        }
    }

    public static void actualizarHistoriales() {
        if (archivoHistoriales.delete()) {
            if (archivoHistoriales.createNewFile()) {
                try (FileWriter fw = new FileWriter(archivoHistoriales.getAbsoluteFile(), true)) {
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    for (Historial historial : historiales) {
                        String diagnostico = historial.diagnostico;
                        String receta = historial.receta;
                        String id = historial.id + "";
                        
                        bw.write(diagnostico + "/" + receta + "/" id);
                        bw.newLine();
                    }
                    
                    bw.flush();
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("Error en la creación del archivo");
                }
            }
        }
    }

    /**
     * Lee el archivo facturas, si no existe lo crea
     */
    public static void leerFacturas() {
        if (!archivoFacturas.exists()) {
            try {
                archivoFacturas.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (Scanner sc = new Scanner(archivoFacturas)) {
                while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    String data[] = linea.split("/");

                    int id = Integer.parseInt(data[0]);
                    double pagar = Double.parseDouble(data[1]);

                    for (Veterinaria.Cita cita : citas) {
                        if (cita.idFactura == id) {
                            new Factura(cita, pagar);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se encontró");
            }
        }
    }

    public static void actualizarFacturas() {
        if (archivoFacturas.delete()) {
            if (archivoFacturas.createNewFile()) {
                try (FileWriter fw = new FileWriter(archivoFacturas.getAbsoluteFile(), true)) {
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (Factura factura : facturas) {
                        String id = factura.id + "";
                        String pagar = factura.totalPagar + "";

                        bw.write(id + "/" + pagar);
                        bw.newLine();
                    }
                    bw.flush();
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("Error en la creación del archivo");
                }
            }
        }
    }
}