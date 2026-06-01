package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Caminar;
import clinicaveterinaria.interfaces.Nadador;

public class Perro extends Animal implements Nadador, Caminar{
    public Perro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PERRO);
    }

   @Override
    public void Camina() {
        System.out.println("El perro puede caminar");
}

@Override
    public void nadar() {
        System.out.println("El perro puede nadar");
}


}
