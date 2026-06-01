package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Caminar;

public class Gato extends Animal implements Caminar{
    public Gato(int id, String nombre) {
        super(id, nombre, TipoAnimal.GATO);
    }

    @Override
    public void Camina() {
        System.out.println("El gato puede caminar");
}

}