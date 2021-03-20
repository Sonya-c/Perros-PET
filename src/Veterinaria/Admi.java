package Veterinaria;

import perros.pet.PerrosPET;
import java.util.ArrayList;

public class Admi extends Persona {

    public ArrayList<Veterinaria.Factura> misFacturas;

    /**
     * Es un administrador que hereda dede persona
     * 
     * @param nombreUsuario
     * @param tipoDocumento
     * @param documento
     * @param contraseña
     */
    public Admi(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.ADMINISTRADOR);

        // Se inicializa la lista (no puede ser nulo)
        misFacturas = new ArrayList<Veterinaria.Factura>();

        // Se obtien los datos de este administrador
        getCitas();
        getFactutas();

        // Añadimos este administrador a la lista principañ
        (PerrosPET.administradores).add(this);
    }

    /**
     * Obtiene las citas. Como es un administrador, obtiene todas las citas
     */
    public void getCitas() {
        for (Cita cita : PerrosPET.citas) {
            misCitas.add(cita);
        }
    }

    /**
     * Obtiene las facturas. Como es un administrador, obtiene todas las facturas
     */
    public void getFactutas() {
        for (Factura factura : PerrosPET.facturas) {
            misFacturas.add(factura);
        }
    }
}