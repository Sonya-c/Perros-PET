package Veterinaria;

import java.util.Date;

import perros.pet.PerrosPET;

public class Perro {
    public final Usuario dueño;
    public String nombre;
    public String raza;
    public String color;
    public Date fechaNacimiento;

    public Perro(Usuario dueño, String nombre, String raza, String color, Date fechaNacimiento) {
        this.dueño = dueño;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.fechaNacimiento = fechaNacimiento;

        (PerrosPET.perros).add(this);
        dueño.addMascota(this);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
