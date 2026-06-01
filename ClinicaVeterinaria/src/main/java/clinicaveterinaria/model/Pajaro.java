package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.volador;

public class Pajaro extends Animal implements volador {
    public Pajaro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PAJARO);
    }

    @Override
    public void volar() {
                System.out.println("El pajaro puede Volar");

    }
}
