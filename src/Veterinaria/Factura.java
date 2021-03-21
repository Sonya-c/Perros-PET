package Veterinaria;

import perros.pet.PerrosPET;

public class Factura {
    public Cita cita;
    public float totalPagar;
    public float[] horasServicio;

    // Constante de los precios
    // CONSULTA, CONTROL, DESPARACITACIÓN, VACUNACIÓN, GUARDERIA, RADIOLOGIA, BAÑO
    public final float PAGAR_CONSULTA_VETERINARIO = 60000; // por hora
    public final float PAGAR_CONTROL = 20000; // por hora
    public final float PAGAR_DESPARACITACIÓN = 80000; // por hora
    public final float PAGAR_VACUNACION = 70000; // por hora
    public final float PAGAR_GUARDRIA = 35000; // por dia
    public final float PAGAR_RADIOLOGIA = 100000; // por hora
    public final float PAGAR_BAÑO = 12500; // por horas

    /**
     * La factura se crear una vez que una cita se completa
     * 
     * @param cita          la cita a la que esta asociada la factura
     * @param horasServicio es una lista de 7 elementos que representan las horas de
     *                      cada servicio
     */
    public Factura(Cita cita, float horasServicio[]) {
        this.cita = cita;
        this.horasServicio = horasServicio;

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
