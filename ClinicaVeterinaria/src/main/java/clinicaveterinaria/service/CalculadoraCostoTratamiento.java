package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.ITratamiento;

public class CalculadoraCostoTratamiento {
    public double calcularConImpuestos(ITratamiento tratamiento) {
        double costoBase = tratamiento.calcularCostoFinal(); 
        double impuesto = 0.12; 
        return costoBase * (1 + impuesto);
    }
}
