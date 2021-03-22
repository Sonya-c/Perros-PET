package Veterinaria;

import perros.pet.PerrosPET;

public class Factura {
    public Cita cita;
    public double totalPagar;
    public int id;

    /**
     * La factura se crear una vez que una cita se completa
     * 
     * @param cita          la cita a la que esta asociada la factura
     * @param horasServicio es una lista de 7 elementos que representan las horas de
     *                      cada servicio
     */
    public Factura(Cita cita, double totalPagar) {
        this.cita = cita;
        this.totalPagar = totalPagar;
        this.id = PerrosPET.facturas.size() + 1;
        
        // Agregarle a la cita esta factura
        cita.factura = this;

        // Añadir a la pagina principal y a la lista de facturas de todos los
        // administradores
        (PerrosPET.facturas).add(this);
        for (Admi admi : PerrosPET.administradores) {
            admi.misFacturas.add(this);
        }
    }
}
