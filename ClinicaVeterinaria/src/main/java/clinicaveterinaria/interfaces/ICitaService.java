package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;

import java.util.List;


public interface ICitaService {


    void crearCita(Cita cita);

    Cita obtenerCita(int id);

    void cancelarCita(int id);
    void crearVeterinario(Veterinario veterinario);
    public Veterinario obtenerVeterinario(int id) ;
    


    

    
   

   
}
