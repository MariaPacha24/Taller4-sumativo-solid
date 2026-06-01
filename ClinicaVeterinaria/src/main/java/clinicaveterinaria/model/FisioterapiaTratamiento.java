package clinicaveterinaria.model;
import clinicaveterinaria.interfaces.ITratamiento;
public class FisioterapiaTratamiento implements ITratamiento {
    private final double costo;
    private int id;
    private String descripcion;

    public FisioterapiaTratamiento(int id, String descripcion, double costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    
    public FisioterapiaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo * 0.95;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Repetir sesiones dos veces por semana.";
    }
}