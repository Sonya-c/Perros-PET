package Veterinaria;

import perros.pet.PerrosPET;
import java.util.ArrayList;

public class Admi extends Persona {
    public ArrayList<Veterinaria.Factura> misFacturas;

    public Admi(String nombreUsuario, TipoDocumento tipoDocumento, String documento, String contraseña) {
        super(nombreUsuario, tipoDocumento, documento, contraseña, TipoUsuario.ADMINISTRADOR);

        (PerrosPET.administradores).add(this);
        misFacturas = new ArrayList<Veterinaria.Factura>();
        getCitas();
        getFactutas();
    }

    public void getCitas() {
        for (Cita cita : PerrosPET.citas) {
            misCitas.add(cita);
        }
    }

    public void getFactutas() {
        for (Factura factura : PerrosPET.facturas) {
            misFacturas.add(factura);
        }
    }

}
