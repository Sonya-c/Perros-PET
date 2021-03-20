package Veterinaria;

import perros.pet.PerrosPET;

public class Factura {
    public Cita cita;
    public float totalPagar;
    public float[] horasServicio;

    // Constante de los precios
    public final float PAGAR_CONSULTA_VETERINARIO = 60000; // por hora
    public final float PAGAR_CONTROL = 10000; // por media hora
    public final float PAGAR_DESPARACITACIÓN = 40000; // por media hora
    public final float PAGAR_VACUNACION = 35000; // por media hora
    public final float PAGAR_GUARDRIA = 35000; // por dia
    public final float PAGAR_RADIOLOGIA = 100000; // por hora
    public final float PAGAR_BAÑO = 25000; // por dos horas

    public Factura(Cita cita, float horasServicio[]) {
        this.cita = cita;
        this.horasServicio = horasServicio;

        cita.factura = this;
        (PerrosPET.facturas).add(this);
        for (Admi admi : PerrosPET.administradores) {
            admi.misFacturas.add(this);
        }
    }

}
