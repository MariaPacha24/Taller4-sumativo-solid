package clinicaveterinaria.model;
import clinicaveterinaria.interfaces.ITratamiento;
public class MedicamentoTratamiento implements ITratamiento {
    private final double costo;
    private int id;
    private String descripcion;

    public MedicamentoTratamiento(int id, String descripcion, double costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    public MedicamentoTratamiento (double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo * 1.10;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Administrar segun receta.";
    }
}